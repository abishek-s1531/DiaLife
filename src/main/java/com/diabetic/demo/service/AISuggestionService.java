package com.diabetic.demo.service;

import java.util.List;

import com.diabetic.demo.entity.AISuggestion;

public interface AISuggestionService {

    AISuggestion generateSuggestion(Long userId);

    List<AISuggestion> getSuggestionsByUserId(Long userId);
}