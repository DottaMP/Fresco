package com.fresco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fresco.model.produtoModel;
import com.fresco.repository.produtoRepository;

@RequestMapping("/produto")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class produtoController {
	
	@Autowired
	private produtoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<produtoModel>> listarProduto (){
		return ResponseEntity.ok(repository.findAll()); 
	}
	
	@GetMapping("/{id}") //
	public ResponseEntity<produtoModel> listarProdutoPorId(@PathVariable long id){ //findById()
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<produtoModel> addProduto(@RequestBody produtoModel produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
	}
	
	@PutMapping
	public ResponseEntity<produtoModel> editarProduto(@RequestBody produtoModel produto){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(produto));
	}
	
	@DeleteMapping("/{id}")
	public void deletarProduto(@PathVariable long id) {
		repository.deleteById(id);
	}

}
