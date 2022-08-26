package com.example.demo.services.impl;

import com.example.demo.dtos.regiondto.RegionDto;
import com.example.demo.entities.Region;
import com.example.demo.repositories.RegionRepository;
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
@Slf4j
@Service
public class RegionServiceImpl implements ProcessService {

    private static final String FILE_PATH = "json-db/region.json";
    private final ObjectMapper objectMapper;
    private final RegionRepository regionRepository;
    private final ReaderService readerService;

    @PostConstruct
    @Override
    public void saveProcess() throws Exception {
        JsonNode s = objectMapper.readTree(readerService.getContent(FILE_PATH));
        List<RegionDto> regionDtos = objectMapper.convertValue(s, new TypeReference<>() {
        });

        List<Region> regions = new ArrayList<>();
        regionDtos
                .forEach(e -> {
                    var br = Region
                            .builder()
                            .id(e.getId().getId())
                            .code(e.getCode())
                            .name(e.getName())
                            .build();
                    regions.add(br);
                });
        regionRepository.saveAll(regions);
    }
}
