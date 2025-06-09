package com.example.edtech.dtos;

import java.util.Map;

public class QuestionTypeGroupDTO {
    private String shareListenUrl;
    private Map<String, FormDTO> forms;

    public QuestionTypeGroupDTO() {
    }

    public QuestionTypeGroupDTO(String shareListenUrl, Map<String, FormDTO> forms) {
        this.shareListenUrl = shareListenUrl;
        this.forms = forms;
    }

    // Getter - Setter
    public String getShareListenUrl() {
        return shareListenUrl;
    }

    public void setShareListenUrl(String shareListenUrl) {
        this.shareListenUrl = shareListenUrl;
    }

    public Map<String, FormDTO> getForms() {
        return forms;
    }

    public void setForms(Map<String, FormDTO> forms) {
        this.forms = forms;
    }
}
