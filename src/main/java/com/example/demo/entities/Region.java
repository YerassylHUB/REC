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
@Table(name = "region", indexes = {
  @Index(
    name = "id",
    columnList = "id",
    unique = true
  ),
})
public class Region {

  @Id
  private String id;
  private String code;
  private String name;
  private LocalDateTime updatedAt;
  private LocalDateTime createdAt;

}
