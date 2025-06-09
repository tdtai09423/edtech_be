package com.example.edtech.dtos;

public class QuestionDTO {
    private Long id;
    private String image;
    private String value;
    private String text;
    private String desR;
    private String desL;

    private boolean isAnswer;

    public QuestionDTO(Long id, String image, String value, String text, String desR, String desL, boolean isAnswer) {
        this.id = id;
        this.image = image;
        this.value = value;
        this.text = text;
        this.desR = desR;
        this.desL = desL;
        this.isAnswer = isAnswer;
    }

    // Getter và Setter
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public boolean isAnswer() {
        return isAnswer;
    }

    public void setAnswer(boolean isAnswer) {
        this.isAnswer = isAnswer;
    }
}
