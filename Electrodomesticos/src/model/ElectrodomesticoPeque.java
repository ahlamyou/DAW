package model;

import java.io.Serializable;

public class ElectrodomesticoPeque extends Electrodomestico implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ElectrodomesticoPeque() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ElectrodomesticoPeque(Codigo codigo, String descripcion, String modelo, int stock, double precioUnitario) {
		super(codigo, descripcion, modelo, stock, precioUnitario);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ElectrodomesticoPeque [toString()=" + super.toString() + ", getCodigo()=" + getCodigo()
				+ ", getDescripcion()=" + getDescripcion() + ", getModelo()=" + getModelo() + ", getStock()="
				+ getStock() + ", getPrecioUnitario()=" + getPrecioUnitario() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}

	@Override
	double precioTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

}
