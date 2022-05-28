package service;

import java.util.List;
import java.util.Scanner;

import model.Electrodomestico;

public class EliminarElectrodomesticoService {

	public void eliminarElectrodomestico(List<Electrodomestico> todosLosElectrodomesticosList) {
		Scanner scanner = new Scanner(System.in);
		Electrodomestico electrodomesticoElegido = null;
		String codigoEliminar;

		for (Electrodomestico electrodomestico : todosLosElectrodomesticosList) {
			System.out.println(electrodomestico.toString());
		}
		System.out.println("Introduzca el codigo del electrodoméstico que quiere eliminar:");
		codigoEliminar = scanner.nextLine();

		for (Electrodomestico electrodomestico : todosLosElectrodomesticosList) {
			if (electrodomestico.getCodigo() != null
					&& electrodomestico.getCodigo().getCodigo().equals(codigoEliminar)) {
				electrodomesticoElegido = electrodomestico;
			}
		}
		if (electrodomesticoElegido != null) {
			todosLosElectrodomesticosList.remove(electrodomesticoElegido);
			System.out.println("Artículo eliminado correctamente.");
		} else {
			System.out.println("Código no encontrado");
		}
	}

}
