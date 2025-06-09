package com.example.edtech.dtos;

import java.util.ArrayList;
import java.util.List;

public class FormDTO {
    private List<QuestionGroupDTO> questionsAll;

    public FormDTO() {
    }

    public FormDTO(List<QuestionGroupDTO> questionsAll) {
        this.questionsAll = questionsAll;
    }

    // Getter - Setter
    public List<QuestionGroupDTO> getQuestionsAll() {
        return questionsAll;
    }

    public void setQuestionsAll(List<QuestionGroupDTO> questionsAll) {
        this.questionsAll = questionsAll;
    }
}
