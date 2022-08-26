package com.example.demo.dtos.branchdto;

import com.example.demo.dtos.CreatedAtDto;
import com.example.demo.dtos.IdDto;
import com.example.demo.dtos.ParentBranchIdDto;
import com.example.demo.dtos.UpdatedAtDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BranchDto implements Serializable {

  @JsonProperty("_id")
  private IdDto id;
  @JsonProperty("alias")
  private List<String> alias;
  @JsonProperty("code")
  private String code;
  @JsonProperty("is_parent")
  private Integer isParent;
  @JsonProperty("status")
  private Integer status;
  @JsonProperty("name")
  private String name;
  @JsonProperty("type")
  private String type;
  @JsonProperty("parent_branch_id")
  private ParentBranchIdDto parentBranchId;
  @JsonProperty("created_at")
  private CreatedAtDto createdAt;
  @JsonProperty("updated_at")
  private UpdatedAtDto updatedAt;
}
