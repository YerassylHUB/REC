package com.example.demo.services.impl;

import com.example.demo.dtos.countries.CountriesDto;
import com.example.demo.entities.Country;
import com.example.demo.repositories.CountryRepository;
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
public class CountryServiceImpl implements ProcessService {

  private static final String FILE_PATH = "json-db/countries.json";
  private final ObjectMapper objectMapper;
  private final ReaderService readerService;
  private final CountryRepository countryRepository;

  @PostConstruct
  @Override
  public void saveProcess() throws Exception {
    JsonNode s = objectMapper.readTree(readerService.getContent(FILE_PATH));
    List<CountriesDto> countriesdto = objectMapper.convertValue(s, new TypeReference<>() {
    });

    List<Country> countries = new ArrayList<>();
    countriesdto
      .forEach(e -> {
        var br = Country
          .builder()
          .id(e.getId().getId())
          .code(e.getCode())
          .name(e.getName())
          .updatedAt(e.getUpdatedAt().getUpdatedAt())
          .build();
        countries.add(br);
      });
    countryRepository.saveAll(countries);
  }
}
