package com.fresco.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

@Entity
@Table(name = "tb_compra")
public class CompraModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_compra;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone="GMT-3")
	private LocalDate data;
	
	@NotNull
	@Size(min = 5, max = 10)
	private String forma_pgto;
	
	@NotNull
	@Size(min = 8, max = 25)
	private String status;

	public long getId_compra() {
		return id_compra;
	}

	public void setId_compra(long id_compra) {
		this.id_compra = id_compra;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getForma_pgto() {
		return forma_pgto;
	}

	public void setForma_pgto(String forma_pgto) {
		this.forma_pgto = forma_pgto;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
