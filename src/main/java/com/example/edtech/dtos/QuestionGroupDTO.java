package com.example.edtech.dtos;

import java.util.List;
import java.util.Map;

public class QuestionGroupDTO {
    private List<QuestionDTO> questions;

    public QuestionGroupDTO() {
    }

    public QuestionGroupDTO(List<QuestionDTO> questions) {
        this.questions = questions;
    }

    // Getter - Setter
    public List<QuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDTO> questions) {
        this.questions = questions;
    }
}
