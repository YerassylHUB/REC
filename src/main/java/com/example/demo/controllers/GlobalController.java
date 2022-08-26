package com.example.demo.controllers;

import com.example.demo.dtos.GlobalResponseDTO;
import com.example.demo.services.GlobalService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api/global")
public class GlobalController {

  private final GlobalService globalService;

  @GetMapping("/getAll")
  public List<GlobalResponseDTO> getIntegrateVersion() throws Exception {
    return globalService.getAllData();
  }
}
