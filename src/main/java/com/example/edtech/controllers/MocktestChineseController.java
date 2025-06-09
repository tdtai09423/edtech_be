package com.example.edtech.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.edtech.dtos.MocktestChineseDTO;
import com.example.edtech.dtos.TopicDTO;
import com.example.edtech.entities.MocktestChinese;
import com.example.edtech.services.MocktestChineseService;

@RestController
@RequestMapping("/api/mocktest-chinese")
public class MocktestChineseController {

    @Autowired
    private MocktestChineseService mocktestChineseService;

    // Tạo mới mocktest
    @PostMapping
    public MocktestChinese createMocktest(@RequestBody MocktestChinese mocktest) {
        System.out.println(mocktest);
        return mocktestChineseService.saveMockTest(mocktest);
    }

    // Lấy tất cả mocktest
    @GetMapping
    public List<MocktestChinese> getAllMocktests() {
        return mocktestChineseService.getAllMockTests();
    }

    @GetMapping("/grouped")
    public List<MocktestChineseDTO> getGroupedMocktests() {
        return mocktestChineseService.getGroupedMocktests();
    }

    @GetMapping("/detail")
    public ResponseEntity<?> getGroupedByTitle(@RequestParam(value = "title", required = false) String title) {
        if (title != null && !title.isEmpty()) {
            MocktestChineseDTO dto = mocktestChineseService.getGroupedMocktestByTitle(title);
            if (dto != null) {
                return ResponseEntity.ok(dto);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Không tìm thấy mocktest với title: " + title);
            }
        } else {
            return ResponseEntity.ok(mocktestChineseService.getGroupedMocktests());
        }
    }

    // Lấy mocktest theo id
    @GetMapping("/{id}")
    public ResponseEntity<MocktestChinese> getMocktestById(@PathVariable Long id) {
        Optional<MocktestChinese> optionalMocktest = mocktestChineseService.getMockTestById(id);
        return optionalMocktest.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Xóa mocktest theo id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMocktest(@PathVariable Long id) {
        mocktestChineseService.deleteMockTest(id);
        return ResponseEntity.noContent().build();
    }
}
