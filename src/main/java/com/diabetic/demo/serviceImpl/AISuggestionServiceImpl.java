package com.diabetic.demo.serviceImpl;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.diabetic.demo.entity.AISuggestion;
import com.diabetic.demo.entity.HealthRecord;
import com.diabetic.demo.entity.User;
import com.diabetic.demo.repository.AISuggestionRepository;
import com.diabetic.demo.repository.HealthRecordRepository;
import com.diabetic.demo.repository.UserRepository;
import com.diabetic.demo.service.AISuggestionService;

@Service
public class AISuggestionServiceImpl implements AISuggestionService {

    @Autowired
    private AISuggestionRepository aiSuggestionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HealthRecordRepository healthRecordRepository;

    @Autowired
    private RestTemplate restTemplate;


    @Value("${groq.api.key}")
    private String groqApiKey;

    @Value("${groq.api.url}")
    private String groqApiUrl;

    @Value("${groq.api.model}")
    private String groqModel;


    public AISuggestion generateSuggestion(Long userId) {

        // STEP 1: Get User
        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                    new RuntimeException(
                        "User not found with id: " + userId
                    )
                );


        // STEP 2: Get latest health record
        HealthRecord healthRecord =
                healthRecordRepository
                .findTopByUserIdOrderByDateTimeDesc(userId)
                .orElseThrow(() ->
                    new RuntimeException(
                        "No health record found for this user"
                    )
                );


        // STEP 3: Create prompt
        String prompt = """
                You are an AI assistant for a diabetes management application.

                Give a short and helpful wellness suggestion based on
                the following information.

                Patient Name: %s

                Fasting Sugar: %s mg/dL
                Post Meal Sugar: %s mg/dL
                Bed Time Sugar: %s mg/dL

                Record Date: %s

                Important rules:
                - Use simple language.
                - Do not diagnose diseases.
                - Do not prescribe medication.
                - Do not recommend changing insulin doses.
                - Give general lifestyle guidance only.
                - If values appear concerning, advise consulting
                  a qualified healthcare professional.

                Keep the answer under 150 words.
                """
                .formatted(
                    user.getName(),
                    healthRecord.getFastingSugar(),
                    healthRecord.getPostMealLevel(),
                    healthRecord.getBedTimeLevel(),
                    healthRecord.getDateTime()
                );

          
        System.out.println("Groq API Key loaded: " + 
                (groqApiKey != null && !groqApiKey.isBlank()));

        System.out.println("Key starts with gsk_: " + 
                (groqApiKey != null && groqApiKey.startsWith("gsk_")));
        // STEP 4: Headers
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);

        headers.setBearerAuth(groqApiKey);


        // STEP 5: Groq message
        Map<String, String> message = new HashMap<>();

        message.put("role", "user");

        message.put("content", prompt);


        // STEP 6: Groq request body
        Map<String, Object> requestBody = new HashMap<>();

        requestBody.put("model", groqModel);

        requestBody.put("messages", List.of(message));

        requestBody.put("temperature", 0.5);


        // STEP 7: Send request
        HttpEntity<Map<String, Object>> request =
                new HttpEntity<>(requestBody, headers);


        ResponseEntity<Map> response =
                restTemplate.postForEntity(
                    groqApiUrl,
                    request,
                    Map.class
                );


        // STEP 8: Get response from Groq
        List<Map<String, Object>> choices =
                (List<Map<String, Object>>)
                response.getBody().get("choices");


        Map<String, Object> firstChoice =
                choices.get(0);


        Map<String, Object> messageResponse =
                (Map<String, Object>)
                firstChoice.get("message");


        String aiResponse =
                messageResponse.get("content").toString();


        // STEP 9: Save AI response
        AISuggestion suggestion = new AISuggestion();

        suggestion.setSuggestionType("GENERAL");

        suggestion.setSeverity("INFO");

        suggestion.setAiModel(groqModel);

        suggestion.setGeneratedAt(LocalDateTime.now());

        suggestion.setSuggestion(aiResponse);

        suggestion.setUser(user);


        return aiSuggestionRepository.save(suggestion);
    }


    // Get suggestions of one user
    public List<AISuggestion> getSuggestionsByUserId(Long userId) {

        return aiSuggestionRepository
                .findByUserIdOrderByGeneratedAtDesc(userId);
    }
}