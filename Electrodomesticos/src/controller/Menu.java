package controller;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import model.Electrodomestico;
import service.AadElectrodomesticoService;
import service.BinarioService;
import service.EliminarElectrodomesticoService;
import service.VenderElectrodomesticoService;

public class Menu {
	private Scanner scanner = new Scanner(System.in);

	private int opcion;

	public void menu(List<Electrodomestico> todosLosElectrodomesticosList) throws InterruptedException {
		VenderElectrodomesticoService venderElectrodomestico = new VenderElectrodomesticoService();
		EliminarElectrodomesticoService eliminarElectrodomestico = new EliminarElectrodomesticoService();
		AadElectrodomesticoService addElectrodomestico = new AadElectrodomesticoService();
		do {
			menuParteUno();
			switch (opcion) {
			case 1: {
				addElectrodomestico.aadElectrodomestico(todosLosElectrodomesticosList);
				break;
			}
			case 2: {
				venderElectrodomestico.venderElectrodomestico(todosLosElectrodomesticosList);

				break;
			}
			case 3: {
				eliminarElectrodomestico.eliminarElectrodomestico(todosLosElectrodomesticosList);
				break;
			}
			case 4: {
				System.out.println("Hasta pronto!");
				BinarioService binarioService = new BinarioService();
				binarioService.setListEscribiendoBinario(todosLosElectrodomesticosList);
				return;
			}
			default:
				System.out.println("Opci�n no v�lida");
			}

		} while (true);
	}

	private void menuParteUno() throws InterruptedException {
		System.out.println("Elige una opci�n");
		System.out.println("1. A�adir electrodom�stico.");
		System.out.println("2. Vender electrodom�stico.");
		System.out.println("3. Eliminar electrodom�stico.");
		System.out.println("4. Salir.");
		boolean userTypedCorrect = false;
		while (userTypedCorrect == false) {
			try {
				opcion = scanner.nextInt();
				userTypedCorrect = true;
			} catch (InputMismatchException inputMismatchException) {
				// para debug, puedes ver la causa con el siguiente c�digo.
				inputMismatchException.printStackTrace();
				Thread.sleep(1000);
				// para que el usuario tenga un mensaje.
				System.out.println("Error! Elige una opci�n y escribe un n�mero!");
				scanner.next();
			}
		}
	}

}
