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
@Table(name = "slips",
  indexes = {
    @Index(
      name = "id",
      columnList = "id",
      unique = true
    ),
    @Index(
      name = "cedants_id",
      columnList = "cedants_id"
    ),
  })
public class Slips {

  @Id
  private String id;
  private String approvalStatus;
  @Column(name = "cedants_id")
  private String cedantsId;
  private String cedantsTypeId;
  private LocalDateTime confirmationDate;
  private String confirmationStatus;
  private LocalDateTime createdAt;
  private Integer isPaid;
  private String publishedDate;
  private String re_ferences;
  private String reinsurancesId;
  private String userCedantId;
  private String validationStatus;


}
