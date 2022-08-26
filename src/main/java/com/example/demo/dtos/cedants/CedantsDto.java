package com.example.demo.dtos.cedants;

import com.example.demo.dtos.*;
import com.example.demo.dtos.groupscedants.GrCedantsDto;
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
public class CedantsDto implements Serializable {

    @JsonProperty("_id")
    private IdDto id;
    @JsonProperty("benefit_percentage")
    private String benefitPercentage;
    @JsonProperty("code")
    private String code;
    @JsonProperty("color1")
    private String color1;
    @JsonProperty("color2")
    private String color2;
    @JsonProperty("contact")
    private String contact;
    @JsonProperty("countries_id")
    private CountriesIdDto countriesId;
    @JsonProperty("created_at")
    private CreatedAtDto createdAt;
    @JsonProperty("email")
    private String email;
    @JsonProperty("estimation_type")
    private String estimationType;
    @JsonProperty("groups_cedants_id")
    private GrCedantsDto grCedantsId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("region_id")
    private RegionIdDto regionId;
    @JsonProperty("reinsurances_id")
    private ReinsurancesDto reinsurancesId;
    @JsonProperty("updated_at")
    private UpdatedAtDto updatedAt;
}
