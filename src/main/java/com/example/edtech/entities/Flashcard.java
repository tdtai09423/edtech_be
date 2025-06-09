package com.example.edtech.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Flashcard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String question;

    private String image; // có thể lưu URL hoặc path file

    private String answer;
    private String purpose;

    @ManyToOne
    @JoinColumn(name = "created_by_id")
    private User createdBy;

    private LocalDateTime createdAt;

    @ManyToOne
    private Language language;

    public Flashcard() {
        this.createdAt = LocalDateTime.now();
    }

    public Flashcard(String title, String question, String image, String answer, User createdBy, Language language,
            String purpose) {
        this.title = title;
        this.question = question;
        this.image = image;
        this.answer = answer;
        this.purpose = purpose;
        this.createdBy = createdBy;
        this.language = language;
        this.createdAt = LocalDateTime.now();
    }

    // getters và setters
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

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
