package com.fresco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fresco.model.CompraModel;

@Repository
public interface CompraRepository extends JpaRepository<CompraModel, Long> {

}
