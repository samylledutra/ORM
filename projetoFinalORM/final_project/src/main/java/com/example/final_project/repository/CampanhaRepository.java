package com.example.final_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.final_project.model.Campanha;

@Repository
public interface CampanhaRepository extends JpaRepository<Campanha, Long> {
}
