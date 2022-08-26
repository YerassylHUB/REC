package com.example.demo.repositories;

import com.example.demo.entities.Slips;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SlipsRepository extends JpaRepository<Slips, String> {
  List<Slips> findAllByCedantsId(String cedantId);
}
