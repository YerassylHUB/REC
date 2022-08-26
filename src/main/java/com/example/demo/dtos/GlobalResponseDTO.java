package com.example.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class GlobalResponseDTO implements Serializable {

  private String references;

  private String country;

  private String cedants;

  private String validationStatus;

  private String confirmationStatus;

  private String publicationDate;

  private String branche;

  private Double calculatedREC;


}
