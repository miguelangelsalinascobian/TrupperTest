package com.H2DB.test4.dto;

import java.time.LocalDate;
import java.util.List;

import com.H2DB.test4.entity.Productos;

public class OrdenesDto {
	private Integer ordenId;
	private Integer sucursalId;
	private LocalDate fecha;
	private double total;
	private List<Productos> productos;
	
	public Integer getOrdenId() {
		return ordenId;
	}
	public void setOrdenId(Integer ordenId) {
		this.ordenId = ordenId;
	}
	public Integer getSucursalId() {
		return sucursalId;
	}
	public void setSucursalId(Integer sucursalId) {
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
		return "OrdenesDto [ordenId=" + ordenId + ", sucursalId=" + sucursalId + ", fecha=" + fecha + ", total=" + total
				+ ", productos=" + productos + "]";
	}
	
	
	
}
