package com.diabetic.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diabetic.demo.entity.AISuggestion;

public interface AISuggestionRepository
        extends JpaRepository<AISuggestion, Long> {

    List<AISuggestion> findByUserIdOrderByGeneratedAtDesc(Long userId);
}