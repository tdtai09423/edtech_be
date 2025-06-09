package com.example.edtech.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.edtech.dtos.FlashcardGroupDTO;
import com.example.edtech.entities.Flashcard;
import com.example.edtech.entities.Language;
import com.example.edtech.entities.User;
import com.example.edtech.repositories.FlashcardRepository;
import org.springframework.data.domain.Page;

@Service
public class FlashcardService {

    @Autowired
    private FlashcardRepository flashcardRepository;

    public List<Flashcard> getAllFlashcards() {
        return flashcardRepository.findAll();
    }

    public Optional<Flashcard> getFlashcardById(Long id) {
        return flashcardRepository.findById(id);
    }

    public Flashcard saveFlashcard(Flashcard flashcard) {
        return flashcardRepository.save(flashcard);
    }

    public List<Flashcard> saveFlashcards(List<Flashcard> flashcards) {
        return flashcardRepository.saveAll(flashcards);
    }

    public List<Flashcard> getFlashcardsByUser(Long userId) {
        return flashcardRepository.findByCreatedBy_Id(userId);
    }

    public void deleteFlashcard(Long id) {
        flashcardRepository.deleteById(id);
    }

    public List<Flashcard> findByTitle(String title) {
        return flashcardRepository.findByTitleContainingIgnoreCase(title);
    }

    public Page<FlashcardGroupDTO> getAllGroupedByTitleAndLanguage(Integer languageId, String purpose, int page,
            int size) {
        List<Flashcard> allFlashcards = flashcardRepository.findAll();

        // Lọc theo languageId
        if (languageId != null) {
            allFlashcards = allFlashcards.stream()
                    .filter(f -> f.getLanguage() != null && languageId.equals(f.getLanguage().getId()))
                    .collect(Collectors.toList());
        }

        // Lọc theo purpose
        if (purpose != null && !purpose.trim().isEmpty()) {
            String purposeTrim = purpose.trim();
            allFlashcards = allFlashcards.stream()
                    .filter(f -> purposeTrim.equalsIgnoreCase(f.getPurpose()))
                    .collect(Collectors.toList());
        }

        // Nhóm theo title + languageId
        Map<String, List<Flashcard>> grouped = allFlashcards.stream()
                .collect(Collectors.groupingBy(
                        f -> f.getTitle() + "||" + (f.getLanguage() != null ? f.getLanguage().getId() : "null")));

        List<FlashcardGroupDTO> allGroups = new ArrayList<>();
        for (List<Flashcard> flashcards : grouped.values()) {
            if (!flashcards.isEmpty()) {
                String title = flashcards.get(0).getTitle();
                String groupPurpose = flashcards.get(0).getPurpose();
                Language language = flashcards.get(0).getLanguage();
                allGroups.add(new FlashcardGroupDTO(title, language, groupPurpose, flashcards));
            }
        }

        // Phân trang
        int start = page * size;
        int end = Math.min(start + size, allGroups.size());

        List<FlashcardGroupDTO> pagedGroups = (start >= allGroups.size()) ? new ArrayList<>()
                : allGroups.subList(start, end);

        return new PageImpl<>(pagedGroups, PageRequest.of(page, size), allGroups.size());
    }
}
