package com.example.demo.services.impl;

import com.example.demo.dtos.slips.SlipsDto;
import com.example.demo.entities.Slips;
import com.example.demo.repositories.SlipsRepository;
import com.example.demo.services.ProcessService;
import com.example.demo.services.ReaderService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
@Primary
public class SlipsServiceImpl implements ProcessService {

  private static final String FILE_PATH = "json-db/slips_premium.json";

  private final ObjectMapper objectMapper;
  private final ReaderService readerService;
  private final SlipsRepository slipsRepository;

  @PostConstruct
  @Override
  public void saveProcess() throws Exception {
    JsonNode s = objectMapper.readTree(readerService.getContent(FILE_PATH));
    List<SlipsDto> slipsDtos = objectMapper.convertValue(s, new TypeReference<>() {
    });

    List<Slips> slips = new ArrayList<>();
    slipsDtos
      .forEach(e -> {
        var br = Slips
          .builder()
          .id(e.getId().getId())
          .approvalStatus(e.getApprovalStatus())
          .cedantsId(e.getCedantsId().getId())
          .cedantsTypeId(e.getCedantsTypeId().getId())
          .confirmationStatus(e.getConfirmationStatus())
                .re_ferences(e.getReference())
          .isPaid(e.getIsPaid())
          .publishedDate(e.getPublishedDate())
          .reinsurancesId(e.getReinsurancesId().getId())
          .userCedantId(e.getUserCedantId().getId())
          .validationStatus(e.getValidationStatus())
          .build();
        slips.add(br);
      });
    slipsRepository.saveAll(slips);
  }
}
