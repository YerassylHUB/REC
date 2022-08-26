package com.example.demo.services.impl;

import com.example.demo.dtos.groupscedants.GrCedantsDto;
import com.example.demo.entities.GroupsCedant;
import com.example.demo.repositories.GroupsCedantsRepository;
import com.example.demo.services.ProcessService;
import com.example.demo.services.ReaderService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class GroupsCedantsServiceImpl implements ProcessService {

    private static final String FILE_PATH = "json-db/groups_cedants.json";

    private final ObjectMapper objectMapper;
    private final ReaderService readerService;
    private final GroupsCedantsRepository groupsCedantsRepository;

    @PostConstruct
    @Override
    public void saveProcess() throws Exception {
        JsonNode s = objectMapper.readTree(readerService.getContent(FILE_PATH));
        List<GrCedantsDto> grCedantsDtos = objectMapper.convertValue(s, new TypeReference<>() {
        });
        List<GroupsCedant> groupsCedants = new ArrayList<>();
        grCedantsDtos
                .forEach(e -> {
                    var br = GroupsCedant
                            .builder()
                            .id(e.getId().getId())
                            .createdAt(e.getCreatedAt().getCreatedAt())
                            .name(e.getName())
                            .updatedAt(e.getUpdatedAt().getUpdatedAt())
                            .build();
                    groupsCedants.add(br);
                });
        groupsCedantsRepository.saveAll(groupsCedants);
    }
}
