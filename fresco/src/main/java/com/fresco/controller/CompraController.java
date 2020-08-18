package com.fresco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fresco.model.CompraModel;
import com.fresco.repository.CompraRepository;

@RestController
@RequestMapping("/compra")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CompraController {
	
	@Autowired
	private CompraRepository repository;
	
	@GetMapping
	public ResponseEntity<List<CompraModel>> listarCompra(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CompraModel> listarCompraPorId(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<CompraModel> addCompra(@RequestBody CompraModel compra){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(compra));
	}
	
	@PutMapping
	public ResponseEntity<CompraModel> editarCompra(@RequestBody CompraModel compra){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(compra));
	}
}
