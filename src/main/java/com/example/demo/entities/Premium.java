package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "premium", indexes = {@Index(name = "id", columnList = "id", unique = true)})
public class Premium {

  @Id
  private String id;
  private Integer activeStatus;
  private String branch;
  private String branchesId;
  private String caseValidationStatus;
  private String caseVariant;
  private String category;
  private String cedantsId;
  private Integer commissionCession;
  private Integer insuredCapital;
  private String policyNumber;
  private LocalDateTime updatedAt;
  private String slipsPrimeId;
  private Double premiumHt;
}
