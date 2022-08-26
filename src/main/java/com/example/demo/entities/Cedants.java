package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(
  name = "cedants",
  indexes = {
    @Index(
      name = "id",
      columnList = "id",
      unique = true
    ),
    @Index(
      name = "region_id",
      columnList = "region_id"
    ),
  }
)
public class Cedants {

  @Id
  private String id;
  private String benefitPercentage;
  private String code;
  private String color1;
  private String color2;
  private String contact;
  private String countriesId;
  private LocalDateTime createdAt;
  private String email;
  private String estimationType;
  private String grCedantsId;
  private String name;
  @Column(name = "region_id")
  private String regionId;
  private String reinsurancesId;
  private LocalDateTime updatedAt;
}
