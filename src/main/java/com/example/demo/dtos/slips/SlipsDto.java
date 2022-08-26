package com.example.demo.dtos.slips;

import com.example.demo.dtos.*;
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
public class SlipsDto implements Serializable {

    @JsonProperty("_id")
    private IdDto id;
    @JsonProperty("approval_status")
    private String approvalStatus;
    @JsonProperty("cedants_id")
    private CedantsIdDto cedantsId;
    @JsonProperty("cedants_type_id")
    private CedantsTypeId cedantsTypeId;
//    @JsonProperty("confirmation_date")
//    private String confirmationDate;
    @JsonProperty("confirmation_status")
    private String confirmationStatus;
    @JsonProperty("created_at")
    private CreatedAtDto createdAt;
    @JsonProperty("is_paid")
    private Integer isPaid;
    @JsonProperty("published_date")
    private String publishedDate;
    @JsonProperty("reference")
    private String reference;
    @JsonProperty("reinsurances_id")
    private ReinsurancesDto reinsurancesId;
    @JsonProperty("user_cedant_id")
    private UserCedantIdDto userCedantId;
    @JsonProperty("validation_status")
    private String validationStatus;

}
