package com.example.demo.dtos.premium;

import com.example.demo.dtos.BranchesIdDto;
import com.example.demo.dtos.CedantsIdDto;
import com.example.demo.dtos.IdDto;
import com.example.demo.dtos.UpdatedAtDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PremiumDto implements Serializable {

  @JsonProperty("_id")
  private IdDto id;
  @JsonProperty("active_status")
  private Integer activeStatus;
  @JsonProperty("branch")
  private String branch;
  @JsonProperty("branches_id")
  private BranchesIdDto branchesId;
  @JsonProperty("case_validation_status")
  private String caseValidationStatus;
  @JsonProperty("case_variant")
  private String caseVariant;
  @JsonProperty("category")
  private String category;
  @JsonProperty("cedants_id")
  private CedantsIdDto cedantsId;
  @JsonProperty("commission_cession")
  private Integer commissionCession;
  //    @JsonProperty("insured_capital")
//    private Integer insuredCapital;
  @JsonProperty("premium_ht")
  private Double premiumHt;
  @JsonProperty("policy_number")
  private String policyNumber;
  @JsonProperty("updated_at")
  private UpdatedAtDto updatedAt;
  @JsonProperty("slipes_prime_id")
  private SlipsPrimeIdDto slipsPrimeId;

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  public static class SlipsPrimeIdDto implements Serializable {

    @JsonProperty("$oid")
    private String id;

  }

}
