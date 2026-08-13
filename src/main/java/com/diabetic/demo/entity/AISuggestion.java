package com.diabetic.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ai_suggestions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AISuggestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String suggestionType;

    private String severity;

    private String aiModel;

    private LocalDateTime generatedAt;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String suggestion;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}