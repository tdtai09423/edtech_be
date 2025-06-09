package com.example.edtech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.edtech.entities.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}