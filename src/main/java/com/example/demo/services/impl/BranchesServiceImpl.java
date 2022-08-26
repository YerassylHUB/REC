package com.example.demo.services.impl;

import com.example.demo.dtos.branchdto.BranchDto;
import com.example.demo.entities.Branch;
import com.example.demo.repositories.BranchRepository;
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

@Service
@Slf4j
@RequiredArgsConstructor
public class BranchesServiceImpl implements ProcessService {

  private static final String FILE_PATH = "json-db/branches.json";
  private final ObjectMapper objectMapper;
  private final BranchRepository branchRepository;
  private final ReaderService readerService;


  @PostConstruct
  @Override
  public void saveProcess() throws Exception {
    JsonNode s = objectMapper.readTree(readerService.getContent(FILE_PATH));
    List<BranchDto> branchDtos = objectMapper.convertValue(s, new TypeReference<>() {
    });
    List<Branch> bran = new ArrayList<>();
    branchDtos
      .forEach(e -> {
        var br = Branch
          .builder()
          .id(e.getId().getId())
          .updatedAt(e.getUpdatedAt().getUpdatedAt())
          .createdAt(e.getCreatedAt().getCreatedAt())
          .name(e.getName())
          .code(e.getCode())
          .isParent(e.getIsParent())
          .type(e.getType())
          .status(e.getStatus())
          .build();
        bran.add(br);
      });
    branchRepository.saveAll(bran);
  }
}
