package com.example.demo.services.impl;

import com.example.demo.dtos.premium.PremiumDto;
import com.example.demo.entities.Premium;
import com.example.demo.repositories.PremiumRepository;
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
public class PremiumServiceImpl implements ProcessService {

  private static final String FILE_PATH = "json-db/case_not_life_premium.json";

  private final ObjectMapper objectMapper;
  private final ReaderService readerService;
  private final PremiumRepository premiumRepository;

  @PostConstruct
  @Override
  public void saveProcess() throws Exception {
    JsonNode s = objectMapper.readTree(readerService.getContent(FILE_PATH));
    List<PremiumDto> premiumDtos = objectMapper.convertValue(s, new TypeReference<>() {
    });

    List<Premium> premiums = new ArrayList<>();
    premiumDtos
      .forEach(e -> {
        var br = Premium
          .builder()
          .id(e.getId().getId())
          .activeStatus(e.getActiveStatus())
          .branch(e.getBranch())
          .branchesId(e.getBranchesId().getId())
          .caseValidationStatus(e.getCaseValidationStatus())
          .caseVariant(e.getCaseVariant())
          .category(e.getCategory())
          .cedantsId(e.getCedantsId().getId())
          .commissionCession(e.getCommissionCession())
          .policyNumber(e.getPolicyNumber())
          .slipsPrimeId(e.getSlipsPrimeId().getId())
          .premiumHt(e.getPremiumHt())
          .updatedAt(e.getUpdatedAt().getUpdatedAt())
          .build();
        premiums.add(br);
      });
    premiumRepository.saveAll(premiums);
  }
}
