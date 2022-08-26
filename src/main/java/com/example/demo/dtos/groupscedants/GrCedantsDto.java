package com.example.demo.dtos.groupscedants;

import com.example.demo.dtos.CreatedAtDto;
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
public class GrCedantsDto implements Serializable {

    @JsonProperty("_id")
    private IdDto id;
    @JsonProperty("created_at")
    private CreatedAtDto createdAt;
    @JsonProperty("name")
    private String name;
    @JsonProperty("updated_at")
    private UpdatedAtDto updatedAt;

}
