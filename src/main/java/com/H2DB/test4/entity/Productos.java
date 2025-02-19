package com.H2DB.test4.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "producto_id")
	private Integer productoId;
	
	@ManyToOne
	@JoinColumn(name = "orden_id", nullable = false)
	@JsonIgnore
	private Ordenes ordenId;
	
	@Column(name = "codigo", nullable = false , length = 20)
	private String codigo;
	
	@Column(name = "descripcion", nullable = false , length = 200)
	private String descripcion;
	
	@Column(name = "precio", nullable = false)
	private Double precio;

	public Integer getProductoId() {
		return productoId;
	}

	public void setProductoId(Integer productoId) {
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

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Productos [productoId=" + productoId + ", ordenId=" + ordenId + ", codigo=" + codigo + ", descripcion="
				+ descripcion + ", precio=" + precio + "]";
	}
	
	
}
