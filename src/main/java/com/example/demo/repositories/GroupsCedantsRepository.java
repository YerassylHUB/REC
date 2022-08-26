package com.example.demo.repositories;

import com.example.demo.entities.GroupsCedant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupsCedantsRepository extends JpaRepository<GroupsCedant, String> {
}
