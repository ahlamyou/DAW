package model;

import java.io.Serializable;

public abstract class Electrodomestico implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	abstract double precioTotal();

	private Codigo codigo;
	private String descripcion;
	private String modelo;
	private int stock;
	private double precioUnitario;

	public Electrodomestico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Electrodomestico(Codigo codigo, String descripcion, String modelo, int stock, double precioUnitario) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.modelo = modelo;
		this.stock = stock;
		this.precioUnitario = precioUnitario;
	}

	@Override
	public String toString() {
		return "Electrodomestico codigo=" + codigo + ", descripcion=" + descripcion + ", modelo=" + modelo + ", stock="
				+ stock + ", precioUnitario=" + precioUnitario;
	}

	public Codigo getCodigo() {
		return codigo;
	}

	public void setCodigo(Codigo codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

}
