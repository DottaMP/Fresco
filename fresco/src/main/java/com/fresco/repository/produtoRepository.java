package com.fresco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fresco.model.produtoModel;

@Repository
public interface produtoRepository extends JpaRepository<produtoModel, Long> {
	

}
