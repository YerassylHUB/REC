package com.example.demo.services.impl;

import com.example.demo.dtos.GlobalResponseDTO;
import com.example.demo.repositories.SlipsRepository;
import com.example.demo.repositories.PremiumRepository;
import com.example.demo.repositories.BranchRepository;
import com.example.demo.repositories.CedantsRepository;
import com.example.demo.repositories.CountryRepository;
import com.example.demo.services.GlobalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GlobalServiceImpl implements GlobalService {

  private final SlipsRepository slipsRepository;
  private final PremiumRepository premiumRepository;
  private final BranchRepository branchRepository;
  private final CedantsRepository cedantsRepository;
  private final CountryRepository countryRepository;

  private final static List<String> CEDANT_IDS = List.of(
    "5de7d0ed329d8746112bef92",
    "5ebbfec8329d8763057a4014",
    "5ec3e07e329d8748f31aa8c2"
  );

  @Override
  public List<GlobalResponseDTO> getAllData() throws Exception {
    var cedants = cedantsRepository.findAllByIdIn(CEDANT_IDS);

    List<GlobalResponseDTO> globalResponseDTOS = cedants.stream().map(cedants1 -> {
      GlobalResponseDTO globalResponseDTO = new GlobalResponseDTO();
      var slips = slipsRepository.findAllByCedantsId(cedants1.getId());
      var country = countryRepository.findById(cedants1.getCountriesId());
      var countryName = ((country.isPresent()) ? country.get().getName() : "");

      slips.forEach(s -> {
        var primes = premiumRepository.findAllBySlipsPrimeId(s.getId());
        primes.forEach(p -> {
          var branch = branchRepository.findById(p.getBranchesId());
          if (branch.isPresent()){
            globalResponseDTO.setReferences(s.getRe_ferences());
            globalResponseDTO.setCountry(countryName);
            globalResponseDTO.setCedants(cedants1.getName());
            globalResponseDTO.setValidationStatus(s.getValidationStatus());
            globalResponseDTO.setConfirmationStatus(s.getConfirmationStatus());
            globalResponseDTO.setPublicationDate(s.getPublishedDate());
            globalResponseDTO.setBranche(branch.get().getName());
            globalResponseDTO.setCalculatedREC((p.getPremiumHt() * 36) / 100);
          }
        });
      });
      return globalResponseDTO;
    }).collect(Collectors.toList());

    return globalResponseDTOS;
  }
}