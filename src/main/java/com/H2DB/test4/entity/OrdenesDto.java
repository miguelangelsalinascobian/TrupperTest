package com.H2DB.test4.entity;

import java.time.LocalDate;

public class OrdenesDto {
	private int ordenId;
	private int sucursalId;
	private LocalDate fecha;
	private double total;
	public int getOrdenId() {
		return ordenId;
	}
	public void setOrdenId(int ordenId) {
		this.ordenId = ordenId;
	}
	public int getSucursalId() {
		return sucursalId;
	}
	public void setSucursalId(int sucursalId) {
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
