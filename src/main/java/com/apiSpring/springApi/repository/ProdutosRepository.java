package com.apiSpring.springApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apiSpring.springApi.model.Produtos;

public interface ProdutosRepository extends JpaRepository<Produtos, Long>{

	
	Produtos findById(long id);
}
