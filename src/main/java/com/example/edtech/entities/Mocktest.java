package com.example.edtech.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Mocktest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title; // Tiêu đề mocktest
    private String question; // Câu hỏi

    @ElementCollection
    private List<String> answers; // Danh sách đáp án

    private String answerQuestion; // Đáp án đúng

    @ManyToOne
    @JoinColumn(name = "created_by_id")
    private User createdBy; // Người tạo

    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language; // Ngôn ngữ

    private String type; // Loại câu hỏi: reading / listening

    private String imageQuestion; // URL hình ảnh (nếu có)

    private String listenUrl; // URL file nghe (nếu có)

    // === Getters and Setters ===

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

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public String getAnswerQuestion() {
        return answerQuestion;
    }

    public void setAnswerQuestion(String answerQuestion) {
        this.answerQuestion = answerQuestion;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImageQuestion() {
        return imageQuestion;
    }

    public void setImageQuestion(String imageQuestion) {
        this.imageQuestion = imageQuestion;
    }

    public String getListenUrl() {
        return listenUrl;
    }

    public void setListenUrl(String listenUrl) {
        this.listenUrl = listenUrl;
    }
}
