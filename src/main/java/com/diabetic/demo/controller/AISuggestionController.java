package com.diabetic.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diabetic.demo.entity.AISuggestion;
import com.diabetic.demo.service.AISuggestionService;


@RestController
@RequestMapping("/api/aisuggestions")
public class AISuggestionController {

    @Autowired
    private AISuggestionService aiSuggestionService;


   
    @PostMapping("/generate/{userId}")
    public ResponseEntity<AISuggestion> generateSuggestion(@PathVariable Long userId) {

        AISuggestion suggestion = aiSuggestionService.generateSuggestion(userId);
        return ResponseEntity.ok(suggestion);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<AISuggestion>> getUserSuggestions(@PathVariable Long userId) {

        return ResponseEntity.ok(
                aiSuggestionService.getSuggestionsByUserId(userId)
        );
    }
}
