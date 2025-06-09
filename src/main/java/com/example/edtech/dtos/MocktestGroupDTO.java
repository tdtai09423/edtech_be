package com.example.edtech.dtos;

import java.util.List;
import com.example.edtech.entities.Language;
import com.example.edtech.entities.Mocktest;

public class MocktestGroupDTO {
    private String title;
    private Language language;
    private List<Mocktest> mocktests;

    public MocktestGroupDTO(String title, Language language, List<Mocktest> mocktests) {
        this.title = title;
        this.language = language;
        this.mocktests = mocktests;
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

    public List<Mocktest> getMocktests() {
        return mocktests;
    }

    public void setMocktests(List<Mocktest> mocktests) {
        this.mocktests = mocktests;
    }
}