package com.example.edtech.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.edtech.dtos.FlashcardGroupDTO;
import com.example.edtech.entities.Flashcard;
import com.example.edtech.services.FlashcardService;

@RestController
@RequestMapping("/api/flashcards")
public class FlashcardController {

    @Autowired
    private FlashcardService flashcardService;

    @GetMapping
    public List<Flashcard> getAllFlashcards() {
        return flashcardService.getAllFlashcards();
    }

    @GetMapping("/{id}")
    public Flashcard getFlashcardById(@PathVariable Long id) {
        return flashcardService.getFlashcardById(id)
                .orElseThrow(() -> new RuntimeException("Flashcard not found with id " + id));
    }

    @GetMapping("/my")
    public ResponseEntity<List<Flashcard>> getMyFlashcards(@RequestParam Long userId) {
        List<Flashcard> flashcards = flashcardService.getFlashcardsByUser(userId);
        return ResponseEntity.ok(flashcards);
    }

    @PostMapping("/bulk")
    public List<Flashcard> createMultipleFlashcards(@RequestBody List<Flashcard> flashcards) {
        return flashcardService.saveFlashcards(flashcards);
    }

    @GetMapping("/subject")
    public List<Flashcard> getFlashcardsByTitle(@RequestParam String title) {
        return flashcardService.findByTitle(title);
    }

    @PutMapping("/{id}")
    public Flashcard updateFlashcard(@PathVariable Long id, @RequestBody Flashcard flashcardDetails) {
        Flashcard flashcard = flashcardService.getFlashcardById(id)
                .orElseThrow(() -> new RuntimeException("Flashcard not found with id " + id));

        flashcard.setQuestion(flashcardDetails.getQuestion());
        flashcard.setImage(flashcardDetails.getImage());
        flashcard.setAnswer(flashcardDetails.getAnswer());
        flashcard.setCreatedBy(flashcardDetails.getCreatedBy());
        flashcard.setLanguage(flashcardDetails.getLanguage());

        return flashcardService.saveFlashcard(flashcard);
    }

    @GetMapping("/group")
    public ResponseEntity<?> getFlashcardsGroupedByTitle(
            @RequestParam(required = false) String languageIdStr,
            @RequestParam(required = false) String purpose,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {

        Integer languageId = null;
        if (languageIdStr != null && !languageIdStr.trim().isEmpty()) {
            try {
                languageId = Integer.parseInt(languageIdStr.trim());
            } catch (NumberFormatException e) {
                return ResponseEntity.badRequest().body("languageId phải là số nguyên hợp lệ");
            }
        }

        int pageIndex = (page > 0) ? page - 1 : 0;

        Page<FlashcardGroupDTO> pageResult = flashcardService.getAllGroupedByTitleAndLanguage(languageId, purpose,
                pageIndex, size);

        Map<String, Object> attribute = new HashMap<>();
        attribute.put("totalPage", pageResult.getTotalPages());
        attribute.put("currentPage", page);

        Map<String, Object> response = new HashMap<>();
        response.put("data", pageResult.getContent());
        response.put("attribute", attribute);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public void deleteFlashcard(@PathVariable Long id) {
        flashcardService.deleteFlashcard(id);
    }
}
