package com.apiSpring.springApi.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apiSpring.springApi.model.Produtos;
import com.apiSpring.springApi.repository.ProdutosRepository;

@RestController
@RequestMapping(value="/api")
public class ProdutoResources {

	@Autowired
	ProdutosRepository produtosRepository;
	
	@GetMapping(value="/produto")
	public List<Produtos> listarProdutos(){
		
		//produtosRepository.save(new Produtos("DVD",new BigDecimal(10),new BigDecimal(4)));
		//produtosRepository.save(new Produtos("CD",new BigDecimal(40),new BigDecimal(4.50)));
		return produtosRepository.findAll();
	}
	
	@GetMapping(value="/produto/{id}")
	public Produtos listarProdutosUnico(@PathVariable(value="id") long id){
		
		//produtosRepository.save(new Produtos("DVD",new BigDecimal(10),new BigDecimal(4)));
		
		return produtosRepository.findById(id);
	}
	
	@PostMapping(value="/produto")
	public Produtos salvarProduto(@RequestBody Produtos produto) {
		return produtosRepository.save(produto);
	}
	
	@DeleteMapping(value="/produto")
	public void deleteProduto(@RequestBody Produtos produto) {
		produtosRepository.delete(produto);
	}
	
	@PutMapping(value="/produto")
	public Produtos atualizarProduto(@RequestBody Produtos produto) {
		return produtosRepository.save(produto);
	}
}
