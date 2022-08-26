package com.example.demo.repositories;

import com.example.demo.entities.Cedants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CedantsRepository extends JpaRepository<Cedants, String> {

  List<Cedants> findAllByIdIn(List<String> ids);
}
