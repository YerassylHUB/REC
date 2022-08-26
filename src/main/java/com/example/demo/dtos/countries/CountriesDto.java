package com.example.demo.dtos.countries;

import com.example.demo.dtos.IdDto;
import com.example.demo.dtos.RegionIdDto;
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
public class CountriesDto implements Serializable {

    @JsonProperty("_id")
    private IdDto id;
    @JsonProperty("code")
    private String code;
    @JsonProperty("name")
    private String name;
    @JsonProperty("region_id")
    private RegionIdDto regionId;
    @JsonProperty("updated_at")
    private UpdatedAtDto updatedAt;

}
