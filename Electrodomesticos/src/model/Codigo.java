package model;

import java.io.Serializable;
import java.util.Scanner;

public class Codigo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private String codigo;
	private long uppercase;
	private long lowerCase;
	private long specialCharacter;
	private long number;
	private String codigoUsuario;

	public Codigo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Codigo(String codigo) {
		super();
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Codigo [codigo=" + codigo + "]";
	}

	public void comprobarCodigo() {
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println(
					"Introduzca el código. Debe tener 8 caracteres que deben ser numeros o letras mayusculas.");
			codigoUsuario = scanner.nextLine();
			if (codigoUsuario.length() == 8 && recorrerCodigo() == true) {
				break;
			} else {
				System.out.println("Codigo no válido. Ejemplo formato 0000AAAA. Vuelva a intentarlo");
			}
		} while (true);

	}

	private boolean recorrerCodigo() {
		valorescero();

		for (final char c : codigoUsuario.toCharArray()) {
			if (Character.isUpperCase(c)) {
				uppercase++;
			} else if (Character.isLowerCase(c)) {
				lowerCase++;
			} else if (Character.isDigit(c)) {
				number++;
			} else {
				specialCharacter++;
			}
		}

		if ((uppercase > 0 || number > 0) && lowerCase == 0 && specialCharacter == 0) {

			return true;
		}
		return false;
	}

	private void valorescero() {
		uppercase = 0;
		lowerCase = 0;
		specialCharacter = 0;
		number = 0;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

}
