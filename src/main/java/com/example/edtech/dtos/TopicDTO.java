package com.example.edtech.dtos;

import java.util.Map;

public class TopicDTO {
    private String title;
    private Map<String, QuestionGroupDTO> questionGroups;

    public TopicDTO() {
    }

    public TopicDTO(String title, Map<String, QuestionGroupDTO> questionGroups) {
        this.title = title;
        this.questionGroups = questionGroups;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Map<String, QuestionGroupDTO> getQuestionGroups() {
        return questionGroups;
    }

    public void setQuestionGroups(Map<String, QuestionGroupDTO> questionGroups) {
        this.questionGroups = questionGroups;
    }
}
