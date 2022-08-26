package com.example.demo.services.impl;

import com.example.demo.dtos.cedants.CedantsDto;
import com.example.demo.entities.Cedants;
import com.example.demo.repositories.CedantsRepository;
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
public class CedantsServiceImpl implements ProcessService {

  private static final String FILE_PATH = "json-db/cedants.json";
  private final ObjectMapper objectMapper;
  private final ReaderService readerService;
  private final CedantsRepository cedantsRepository;

  @PostConstruct
  @Override
  public void saveProcess() throws Exception {
    JsonNode s = objectMapper.readTree(readerService.getContent(FILE_PATH));
    List<CedantsDto> cedantsDtos = objectMapper.convertValue(s, new TypeReference<>() {
    });

    List<Cedants> cedants = new ArrayList<>();
    cedantsDtos
      .forEach(e -> {
        var br = Cedants
          .builder()
          .id(e.getId().getId())
          .benefitPercentage(e.getBenefitPercentage())
          .code(e.getCode())
          .color1(e.getColor1())
          .color2(e.getColor2())
          .contact(e.getContact())
          .countriesId(e.getCountriesId().getId())
          .createdAt(e.getCreatedAt().getCreatedAt())
          .email(e.getEmail())
          .estimationType(e.getEstimationType())
          .name(e.getName())
          .regionId(e.getRegionId().getId())
          .reinsurancesId(e.getReinsurancesId().getId())
          .updatedAt(e.getUpdatedAt().getUpdatedAt())
          .build();
        cedants.add(br);
      });
    cedantsRepository.saveAll(cedants);
  }
}
