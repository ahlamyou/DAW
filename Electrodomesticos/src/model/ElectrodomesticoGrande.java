package model;

import java.io.Serializable;

public class ElectrodomesticoGrande extends Electrodomestico implements Serializable, IGastosEnvio {
	private double peso;
	private double alto;
	private double ancho;
	private double fondo;
	private boolean instalacion;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ElectrodomesticoGrande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ElectrodomesticoGrande(Codigo codigo, String descripcion, String modelo, int stock, double precioUnitario,
			double peso, double alto, double ancho, double fondo, boolean instalacion) {
		super(codigo, descripcion, modelo, stock, precioUnitario);

		this.peso = peso;
		this.alto = alto;
		this.ancho = ancho;
		this.fondo = fondo;
		this.instalacion = instalacion;
	}

	@Override
	public String toString() {
		return super.toString() + "ElectrodomesticoGrande [peso=" + peso + ", alto=" + alto + ", ancho=" + ancho
				+ ", fondo=" + fondo + ", instalacion=" + instalacion + "]";
	}

	@Override
	public double gastosEnvio() {
		double calculoEnvio;

		calculoEnvio = ((ancho * alto * fondo) / 1000000) * peso;
		if (calculoEnvio > 50) {
			return 50;
		}

		return ((ancho * alto * fondo) / 1000000) * peso;

	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAlto() {
		return alto;
	}

	public void setAlto(double alto) {
		this.alto = alto;
	}

	public double getAncho() {
		return ancho;
	}

	public void setAncho(double ancho) {
		this.ancho = ancho;
	}

	public double getFondo() {
		return fondo;
	}

	public void setFondo(double fondo) {
		this.fondo = fondo;
	}

	public boolean isInstalacion() {
		return instalacion;
	}

	public void setInstalacion(boolean instalacion) {
		this.instalacion = instalacion;
	}

	@Override
	double precioTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

}
