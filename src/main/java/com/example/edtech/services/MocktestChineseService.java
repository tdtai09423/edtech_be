package com.example.edtech.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.edtech.dtos.FormDTO;
import com.example.edtech.dtos.MocktestChineseDTO;
import com.example.edtech.dtos.QuestionDTO;
import com.example.edtech.dtos.QuestionGroupDTO;
import com.example.edtech.dtos.QuestionTypeGroupDTO;
import com.example.edtech.dtos.TopicDTO;
import com.example.edtech.entities.MocktestChinese;
import com.example.edtech.repositories.MocktestChineseRepository;

@Service
public class MocktestChineseService {
    @Autowired
    private MocktestChineseRepository mocktestChineseRepository;

    public List<MocktestChinese> getAllMockTests() {
        return mocktestChineseRepository.findAll();
    }

    public MocktestChinese saveMockTest(MocktestChinese mocktest) {
        System.out.println(mocktest);
        return mocktestChineseRepository.save(mocktest);
    }

    public Optional<MocktestChinese> getMockTestById(Long id) {
        return mocktestChineseRepository.findById(id);
    }

    public void deleteMockTest(Long id) {
        mocktestChineseRepository.deleteById(id);
    }

    public List<MocktestChineseDTO> getGroupedMocktests() {
        List<MocktestChinese> mocktests = mocktestChineseRepository.findAll();

        Map<String, MocktestChineseDTO> groupedByTitle = new HashMap<>();

        for (MocktestChinese mocktest : mocktests) {
            String title = mocktest.getTitle();
            String typeQuestion = mocktest.getTypeQuestion();
            Double typeNum = mocktest.getTypeNum();

            MocktestChineseDTO dto = groupedByTitle.computeIfAbsent(title,
                    t -> new MocktestChineseDTO(t, new HashMap<>()));

            Map<String, QuestionTypeGroupDTO> questionGroups = dto.getQuestionGroups();

            // Map typeQuestion thành key dễ hiểu
            String questionGroupKey = switch (typeQuestion.toLowerCase()) {
                case "listening" -> "questionListen";
                case "reading" -> "questionRead";
                default -> typeQuestion.toLowerCase();
            };

            QuestionTypeGroupDTO group = questionGroups.get(questionGroupKey);
            if (group == null) {
                group = new QuestionTypeGroupDTO();
                group.setShareListenUrl(mocktest.getShareListenUrl());
                group.setForms(new HashMap<>());
                questionGroups.put(questionGroupKey, group);
            }

            String formKey = "form" + typeNum.intValue();
            FormDTO formDto = group.getForms().get(formKey);
            if (formDto == null) {
                formDto = new FormDTO(new ArrayList<>());
                group.getForms().put(formKey, formDto);
            }

            List<QuestionDTO> questionDtos = mocktest.getQuestions().stream()
                    .map(q -> new QuestionDTO(q.getId(), q.getImage(), q.getValue(), q.getText(), q.getDesR(),
                            q.getDesL(), q.getIsAnswer()))
                    .collect(Collectors.toList());

            // Chia questionDtos thành các nhóm nhỏ (ví dụ 2 câu 1 nhóm)
            int groupSize = 2;
            List<QuestionGroupDTO> questionGroupsList = formDto.getQuestionsAll();
            for (int i = 0; i < questionDtos.size(); i += groupSize) {
                List<QuestionDTO> subList = questionDtos.subList(i, Math.min(i + groupSize, questionDtos.size()));
                QuestionGroupDTO qGroup = new QuestionGroupDTO(subList);
                questionGroupsList.add(qGroup);
            }
        }

        return new ArrayList<>(groupedByTitle.values());
    }

    public MocktestChineseDTO getGroupedMocktestByTitle(String title) {
        List<MocktestChineseDTO> allGrouped = getGroupedMocktests();
        return allGrouped.stream()
                .filter(dto -> dto.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }
}
