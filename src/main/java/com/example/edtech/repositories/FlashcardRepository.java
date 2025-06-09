package com.example.edtech.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.edtech.entities.Flashcard;

@Repository
public interface FlashcardRepository extends JpaRepository<Flashcard, Long> {
    List<Flashcard> findByTitleContainingIgnoreCase(String title);

    @Query("SELECT f FROM Flashcard f WHERE (:languageId IS NULL OR f.language.id = :languageId) AND (:purpose IS NULL OR f.purpose = :purpose)")
    List<Flashcard> findByLanguageAndPurpose(@Param("languageId") Integer languageId, @Param("purpose") String purpose);

    List<Flashcard> findByCreatedBy_Id(Long createdById);
}
