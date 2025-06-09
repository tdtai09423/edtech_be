package com.example.edtech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.edtech.entities.Resource;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {
}