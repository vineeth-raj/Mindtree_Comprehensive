package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Reception;

@Repository
public interface ReceptionRepository extends JpaRepository<Reception, Integer> {
}
