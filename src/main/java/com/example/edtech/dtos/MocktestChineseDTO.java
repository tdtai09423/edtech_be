package com.example.edtech.dtos;

import java.util.List;
import java.util.Map;

public class MocktestChineseDTO {
    private String title;
    private Map<String, QuestionTypeGroupDTO> questionGroups;

    public MocktestChineseDTO() {
    }

    public MocktestChineseDTO(String title, Map<String, QuestionTypeGroupDTO> questionGroups) {
        this.title = title;
        this.questionGroups = questionGroups;
    }

    // Getter - Setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Map<String, QuestionTypeGroupDTO> getQuestionGroups() {
        return questionGroups;
    }

    public void setQuestionGroups(Map<String, QuestionTypeGroupDTO> questionGroups) {
        this.questionGroups = questionGroups;
    }
}
