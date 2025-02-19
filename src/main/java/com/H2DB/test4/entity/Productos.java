package com.H2DB.test4.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRODUCTOS")
public class Productos {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "producto_id")
	private int productoId;
	
	@ManyToOne
	@JoinColumn(name = "orden_id")
	private Ordenes ordenId;
	
	@Column(name = "codigo")
	private String codigo;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "decimal")
	private double decimal;

	public int getProductoId() {
		return productoId;
	}

	public void setProductoId(int productoId) {
		this.productoId = productoId;
	}

	public Ordenes getOrdenId() {
		return ordenId;
	}

	public void setOrdenId(Ordenes ordenId) {
		this.ordenId = ordenId;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getDecimal() {
		return decimal;
	}

	public void setDecimal(double decimal) {
		this.decimal = decimal;
	}
	

	
	
}
