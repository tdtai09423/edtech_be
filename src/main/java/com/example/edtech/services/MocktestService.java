package com.example.edtech.services;

import com.example.edtech.dtos.MocktestGroupDTO;
import com.example.edtech.entities.Language;
import com.example.edtech.entities.Mocktest;
import com.example.edtech.repositories.MocktestRepository;
import com.example.edtech.repositories.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MocktestService {

    @Autowired
    private MocktestRepository mocktestRepository;

    @Autowired
    private LanguageRepository languageRepository;

    public Mocktest saveMocktest(Mocktest mocktest) {
        return mocktestRepository.save(mocktest);
    }

    public List<Mocktest> saveManyMocktests(List<Mocktest> mocktests) {
        return mocktestRepository.saveAll(mocktests);
    }

    public MocktestGroupDTO getMocktestGroupByTitle(String title) {
        List<Mocktest> mocktests = mocktestRepository.findByTitle(title);

        if (mocktests.isEmpty()) {
            throw new RuntimeException("No mocktests found with title: " + title);
        }

        Language language = mocktests.get(0).getLanguage();

        return new MocktestGroupDTO(title, language, mocktests);
    }

    public List<MocktestGroupDTO> getAllGroupedByTitleAndLanguage() {
        List<Mocktest> allMocktests = mocktestRepository.findAll();

        Map<String, List<Mocktest>> grouped = allMocktests.stream()
                .collect(Collectors.groupingBy(m -> m.getTitle() + "||" + m.getLanguage().getId()));

        List<MocktestGroupDTO> result = new ArrayList<>();

        for (Map.Entry<String, List<Mocktest>> entry : grouped.entrySet()) {
            List<Mocktest> groupList = entry.getValue();
            if (!groupList.isEmpty()) {
                Mocktest first = groupList.get(0);
                String title = first.getTitle();
                Language language = first.getLanguage();
                result.add(new MocktestGroupDTO(title, language, groupList));
            }
        }

        return result;
    }

    public Optional<Mocktest> getMocktestById(Long id) {
        return mocktestRepository.findById(id);
    }

    public List<Mocktest> getMocktestsByLanguageId(Long languageId) {
        Optional<Language> language = languageRepository.findById(languageId);
        return language.map(mocktestRepository::findByLanguage).orElse(List.of());
    }

    public Mocktest updateMocktest(Long id, Mocktest updatedMocktest) {
        return mocktestRepository.findById(id).map(existing -> {
            existing.setTitle(updatedMocktest.getTitle());
            existing.setQuestion(updatedMocktest.getQuestion());
            existing.setAnswers(updatedMocktest.getAnswers());
            existing.setAnswerQuestion(updatedMocktest.getAnswerQuestion());
            existing.setLanguage(updatedMocktest.getLanguage());
            existing.setCreatedBy(updatedMocktest.getCreatedBy());
            return mocktestRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Mocktest not found with id " + id));
    }

    public void deleteMocktest(Long id) {
        mocktestRepository.deleteById(id);
    }
}
