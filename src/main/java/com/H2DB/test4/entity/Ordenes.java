package com.H2DB.test4.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.CascadeType;
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
@Table(name = "ordenes")
public class Ordenes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orden_id")
	private Integer ordenId;
	
	@ManyToOne
	@JoinColumn(name = "sucursal_id", nullable = false)
	private Sucursales sucursalId;
	
	@Column(name = "fecha")
	@JsonFormat(shape=Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate fecha;
	
	@Column(name = "total", nullable = false)
	private double total;

	@OneToMany(mappedBy = "ordenId", cascade = CascadeType.ALL)
	private List<Productos> productos;

	public Integer getOrdenId() {
		return ordenId;
	}

	public void setOrdenId(Integer ordenId) {
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

	public List<Productos> getProductos() {
		return productos;
	}

	public void setProductos(List<Productos> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Ordenes [ordenId=" + ordenId + ", sucursalId=" + sucursalId + ", fecha=" + fecha + ", total=" + total
				+ ", productos=" + productos + "]";
	}
	
	
}
