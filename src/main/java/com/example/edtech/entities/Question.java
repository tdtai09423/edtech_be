package com.example.edtech.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String image;
    private String value;
    private String text;
    private String desR;
    private String desL;
    private Boolean isAnswer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mocktest_id")
    @JsonBackReference
    private MocktestChinese mocktestChinese;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesR() {
        return desR;
    }

    public void setDesR(String desR) {
        this.desR = desR;
    }

    public String getDesL() {
        return desL;
    }

    public void setDesL(String desL) {
        this.desL = desL;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getIsAnswer() {
        return isAnswer;
    }

    public void setIsAnswer(Boolean isAnswer) {
        this.isAnswer = isAnswer;
    }

    public MocktestChinese getMocktestChinese() {
        return mocktestChinese;
    }

    public void setMocktestChinese(MocktestChinese mocktestChinese) {
        this.mocktestChinese = mocktestChinese;
    }
}
