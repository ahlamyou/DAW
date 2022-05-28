package service;

import java.util.List;
import java.util.Scanner;

import model.Electrodomestico;
import model.ElectrodomesticoGrande;
import model.ElectrodomesticoPeque;

public class VenderElectrodomesticoService {
	private Scanner scanner = new Scanner(System.in);
	private String codigoArticulo;
	private boolean codigoCorrecto;
	private int cantidad;
	private boolean cantidadCorrecta;
	private Electrodomestico electrodomesticoElegido;

	public void venderElectrodomestico(List<Electrodomestico> todosLosElectrodomesticosList) {
		String tipo;
		do {
			System.out.println("Que tipo de electrodomestico desea comprar: ¿Grande o pequeño?");
			tipo = scanner.nextLine();

			if (tipo.equalsIgnoreCase("grande")) {
				mostrarGrandes(todosLosElectrodomesticosList);
				codigo(todosLosElectrodomesticosList);
				stock(todosLosElectrodomesticosList);
				restarStock(todosLosElectrodomesticosList);
				mostrarArticuloActualizado(todosLosElectrodomesticosList);
				break;
			} else if (tipo.equalsIgnoreCase("pequeño")) {
				mostrarPeque(todosLosElectrodomesticosList);
				codigo(todosLosElectrodomesticosList);
				stock(todosLosElectrodomesticosList);
				restarStock(todosLosElectrodomesticosList);
				mostrarArticuloActualizado(todosLosElectrodomesticosList);
				break;
			} else {
				System.out.println("Debe elegir entre grande o pequeño");
			}

		} while (true);

	}

	private void mostrarGrandes(List<Electrodomestico> todosLosElectrodomesticosList) {

		for (Electrodomestico electrodomestico : todosLosElectrodomesticosList) {
			if (electrodomestico.getStock() != 0 && electrodomestico instanceof ElectrodomesticoGrande) {
				System.out.println(electrodomestico.toString());
			}
		}

	}

	private void mostrarPeque(List<Electrodomestico> todosLosElectrodomesticosList) {

		for (Electrodomestico electrodomestico : todosLosElectrodomesticosList) {
			if (electrodomestico.getStock() != 0 && electrodomestico instanceof ElectrodomesticoPeque) {
				System.out.println(electrodomestico.toString());

			}
		}

	}

	private void codigo(List<Electrodomestico> todosLosElectrodomesticosList) {
		do {
			System.out.println("Introduzca el codigo del artículo que desea comprar:");
			codigoArticulo = scanner.nextLine();
			comprobacionCodigo(todosLosElectrodomesticosList);
			if (codigoCorrecto == true) {
				break;
			} else if (codigoCorrecto == false) {
				System.out.println("Codigo incorrecto. Vuelva a intentarlo");

			}

		} while (true);

	}

	private void comprobacionCodigo(List<Electrodomestico> todosLosElectrodomesticosList) {
		for (Electrodomestico electrodomestico : todosLosElectrodomesticosList) {
			if (codigoArticulo.equals(electrodomestico.getCodigo().getCodigo())) {
				codigoCorrecto = true;
				electrodomesticoElegido = electrodomestico;
				break;
			} else {
				codigoCorrecto = false;
				break;
			}
		}

	}

	private void stock(List<Electrodomestico> todosLosElectrodomesticosList) {
		do {
			System.out.println("Introduzca la cantidad:");
			cantidad = scanner.nextInt();
			scanner.nextLine();
			comprobacionStock(todosLosElectrodomesticosList);
			if (cantidadCorrecta) {
				break;
			} else if (!cantidadCorrecta) {
				System.out.println("La cantidad elegida es superior al stock existente. Vuelva a intentarlo.");
			}

		} while (true);

	}

	private void comprobacionStock(List<Electrodomestico> todosLosElectrodomesticosList) {

		if (cantidad <= electrodomesticoElegido.getStock()) {
			cantidadCorrecta = true;

		} else if (cantidad > electrodomesticoElegido.getStock()) {
			cantidadCorrecta = false;

		}
	}

	private void restarStock(List<Electrodomestico> todosLosElectrodomesticosList) {
		for (Electrodomestico electrodomestico : todosLosElectrodomesticosList) {

			if (electrodomestico.getCodigo().getCodigo().equals(electrodomesticoElegido.getCodigo().getCodigo())) {
				electrodomestico.setStock(electrodomestico.getStock() - cantidad);
			}

		}

	}

	private void mostrarArticuloActualizado(List<Electrodomestico> todosLosElectrodomesticosList) {

		for (Electrodomestico electrodomestico : todosLosElectrodomesticosList) {
			System.out.println(electrodomestico.toString());
		}
	}
}
