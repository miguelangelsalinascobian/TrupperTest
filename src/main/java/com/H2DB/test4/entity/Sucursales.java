package com.H2DB.test4.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "SUCURSALES")
public class Sucursales {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sucursal_id")
	private Long sucursalId;
	@Column(name = "nombre")
	private String nombre;
	
	public Long getSucursalId() {
		return sucursalId;
	}
	public void setSucursalId(Long sucursalId) {
		this.sucursalId = sucursalId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
