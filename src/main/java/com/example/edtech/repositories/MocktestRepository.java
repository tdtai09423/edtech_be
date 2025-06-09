package com.example.edtech.repositories;

import com.example.edtech.entities.Language;
import com.example.edtech.entities.Mocktest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MocktestRepository extends JpaRepository<Mocktest, Long> {
    List<Mocktest> findByLanguage(Language language);

    List<Mocktest> findByTitle(String title);
}
