package com.example.edtech.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class MocktestChinese {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String typeQuestion; // "listening" | "reading"
    private Double typeNum; // ví dụ: 1, 2, 3, 4
    private String shareListenUrl;

    @OneToMany(mappedBy = "mocktestChinese", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Question> questions;

    // Getters và Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTypeQuestion() {
        return typeQuestion;
    }

    public void setTypeQuestion(String typeQuestion) {
        this.typeQuestion = typeQuestion;
    }

    public Double getTypeNum() {
        return typeNum;
    }

    public void setTypeNum(Double typeNum) {
        this.typeNum = typeNum;
    }

    public String getShareListenUrl() {
        return shareListenUrl;
    }

    public void setShareListenUrl(String shareListenUrl) {
        this.shareListenUrl = shareListenUrl;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;

        if (questions != null) {
            for (Question q : questions) {
                q.setMocktestChinese(this);
            }
        }
    }
}
