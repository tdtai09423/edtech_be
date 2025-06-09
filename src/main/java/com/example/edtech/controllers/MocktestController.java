package com.example.edtech.controllers;

import com.example.edtech.dtos.MocktestGroupDTO;
import com.example.edtech.entities.Mocktest;
import com.example.edtech.services.MocktestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mocktests")
public class MocktestController {

    @Autowired
    private MocktestService mocktestService;

    @PostMapping
    public Mocktest createMocktest(@RequestBody Mocktest mocktest) {
        return mocktestService.saveMocktest(mocktest);
    }

    @PostMapping("/bulk")
    public List<Mocktest> createManyMocktests(@RequestBody List<Mocktest> mocktests) {
        return mocktestService.saveManyMocktests(mocktests);
    }

    @GetMapping("/group")
    public List<MocktestGroupDTO> getGroupedMocktests() {
        return mocktestService.getAllGroupedByTitleAndLanguage();
    }

    @GetMapping("/language/{languageId}")
    public List<Mocktest> getByLanguage(@PathVariable Long languageId) {
        return mocktestService.getMocktestsByLanguageId(languageId);
    }

    @GetMapping("/title/{title}")
    public MocktestGroupDTO getMocktestsByTitle(@PathVariable String title) {
        return mocktestService.getMocktestGroupByTitle(title);
    }

    @PutMapping("/{id}")
    public Mocktest updateMocktest(@PathVariable Long id, @RequestBody Mocktest mocktest) {
        return mocktestService.updateMocktest(id, mocktest);
    }

    @DeleteMapping("/{id}")
    public void deleteMocktest(@PathVariable Long id) {
        mocktestService.deleteMocktest(id);
    }
}
