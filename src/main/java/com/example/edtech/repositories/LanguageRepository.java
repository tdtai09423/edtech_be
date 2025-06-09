package com.example.edtech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.edtech.entities.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {
}
