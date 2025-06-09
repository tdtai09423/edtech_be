package com.example.edtech.dtos;

import java.util.List;
import com.example.edtech.entities.Flashcard;
import com.example.edtech.entities.Language;

public class FlashcardGroupDTO {
    private String title;
    private List<Flashcard> flashcards;
    private Language language;
    private String purpose;

    public FlashcardGroupDTO(String title, Language language, String purpose, List<Flashcard> flashcards) {
        this.title = title;
        this.language = language;
        this.purpose = purpose;
        this.flashcards = flashcards;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public List<Flashcard> getFlashcards() {
        return flashcards;
    }

    public void setFlashcards(List<Flashcard> flashcards) {
        this.flashcards = flashcards;
    }
}
