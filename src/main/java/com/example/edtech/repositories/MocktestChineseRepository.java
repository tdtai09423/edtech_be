package com.example.edtech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.edtech.entities.MocktestChinese;

@Repository
public interface MocktestChineseRepository extends JpaRepository<MocktestChinese, Long> {
    // Bạn có thể thêm custom query nếu cần, ví dụ:
    // List<MocktestChinese> findByTypeQuestion(String typeQuestion);
}