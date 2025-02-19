package com.H2DB.test4.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ORDENES")
public class Ordenes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "orden_id")
	private int ordenId;
	
	@ManyToOne
	@JoinColumn(name = "sucursal_id")
	private Sucursales sucursalId;
	
	@Column(name = "fecha")
	@JsonFormat(shape=Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate fecha;
	
	@Column(name = "total")
	private double total;

	public int getOrdenId() {
		return ordenId;
	}

	public void setOrdenId(int ordenId) {
		this.ordenId = ordenId;
	}

	public Sucursales getSucursalId() {
		return sucursalId;
	}

	public void setSucursalId(Sucursales sucursalId) {
		this.sucursalId = sucursalId;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}


	
	

}
