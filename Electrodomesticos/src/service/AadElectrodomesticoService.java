package service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import model.Codigo;
import model.Electrodomestico;
import model.ElectrodomesticoGrande;
import model.ElectrodomesticoPeque;

public class AadElectrodomesticoService {
	private Scanner scanner = new Scanner(System.in);
	private String tipo;
	private String descripcion;
	private String modelo;
	private int stock;
	private double precioUnitario;
	private double peso;
	private double alto;
	private double ancho;
	private double fondo;
	private boolean instalacion;
	private double gastoenvio;
	private double precioFinal;
	private Codigo cod = new Codigo();
	private ElectrodomesticoGrande electrodomesticoGasto= new ElectrodomesticoGrande();

	public void aadElectrodomestico(List<Electrodomestico> todosLosElectrodomesticosList) throws InterruptedException {

		boolean userTypedCorrect = false;
		while (userTypedCorrect == false) {
			try {
				tipoElectrodomestico(todosLosElectrodomesticosList);
				userTypedCorrect = true;
			} catch (InputMismatchException inputMismatchException) {
				// para debug, puedes ver la causa con el siguiente código.
				inputMismatchException.printStackTrace();
				Thread.sleep(1000);
				// para que el usuario tenga un mensaje.
				System.out.println("oh! Has escrito algo que no es del tipo correcto!");
				System.out.println("Vuelve a introducir los datos");
				scanner.next();
			}
		}

	}

	private void tipoElectrodomestico(List<Electrodomestico> todosLosElectrodomesticosList) {
		do {
			System.out.println("Que tipo de electrodomestico desea añadir: Elija entre grande o pequeño");
			tipo = scanner.nextLine();
			if (tipo.equalsIgnoreCase("grande")) {
				electrodomesticoGrande(todosLosElectrodomesticosList);
				break;
			} else if (tipo.equalsIgnoreCase("pequeño")) {
				electrodomesticoPequeño(todosLosElectrodomesticosList);
				break;
			} else {
				System.out.println("Tipo no válido. Debe introducir GRANDE o PEQUEÑO");
			}

		} while (true);

	}

	private void electrodomesticoPequeño(List<Electrodomestico> todosLosElectrodomesticosList) {
		cod.comprobarCodigo();
		datosElectrodomestico();
		addElectrodomesticoPequeño(todosLosElectrodomesticosList);
	}

	private void electrodomesticoGrande(List<Electrodomestico> todosLosElectrodomesticosList) {
		cod.comprobarCodigo();
		datosElectrodomestico();
		datosElectrodomesticoGrande();
		electrodomesticoGasto.gastosEnvio();
		calculoPrecioElectrodomesticoGrande();
		addElectrodomesticoGrande(todosLosElectrodomesticosList);
	}

	private void datosElectrodomestico() {
		System.out.println("Introduzca descripcion:");
		descripcion = scanner.nextLine();

		System.out.println("Introduzca modelo:");
		modelo = scanner.nextLine();

		System.out.println("Introzduza stock:");
		stock = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Introduzca precio unitario:");
		precioUnitario = scanner.nextDouble();
		scanner.nextLine();

	}

	private void datosElectrodomesticoGrande() {
		System.out.println("Introzduza el peso:");
		peso = scanner.nextDouble();
		scanner.nextLine();
		System.out.println("Introzduza el alto:");
		alto = scanner.nextDouble();
		scanner.nextLine();
		System.out.println("Introzduza el ancho:");
		ancho = scanner.nextDouble();
		scanner.nextLine();
		System.out.println("Introzduza el fondo: ");
		fondo = scanner.nextDouble();
		scanner.nextLine();
		instalacion();

	}

	private void instalacion() {
		String respuestaInstalacion;

		do {
			System.out.println("¿Requiere instalación?");
			respuestaInstalacion = scanner.nextLine();
			if (respuestaInstalacion.equalsIgnoreCase("si")) {
				instalacion = true;
				break;
			} else if (respuestaInstalacion.equalsIgnoreCase("no")) {
				instalacion = false;
				break;
			} else {
				System.out.println("Debe responder SI o NO");
			}
		} while (true);

	}

	

	private void calculoPrecioElectrodomesticoGrande() {
		
		double precioMasGasto;
		precioMasGasto = precioUnitario + gastoenvio;
		if (instalacion == true) {
			precioFinal = precioMasGasto + 15;

		} else {
			precioFinal = precioMasGasto;
		}

	}

	private void addElectrodomesticoPequeño(List<Electrodomestico> todosLosElectrodomesticosList) {
		ElectrodomesticoPeque electrodomestico = new ElectrodomesticoPeque(new Codigo(cod.getCodigoUsuario()),
				descripcion, modelo, stock, precioUnitario);
		todosLosElectrodomesticosList.add(electrodomestico);
		System.out.println("Electrodomestico añadido correctamente");
	}

	private void addElectrodomesticoGrande(List<Electrodomestico> todosLosElectrodomesticosList) {
		System.out.println("Se sumará al precio unitario 15€ por gastos de instalación + gastos de envio");
		System.out.println("El precio unitario final es: " + precioFinal + "€");
		ElectrodomesticoGrande electrodomestico = new ElectrodomesticoGrande(new Codigo(cod.getCodigoUsuario()),
				descripcion, modelo, stock, precioFinal, peso, alto, ancho, fondo, instalacion);
		todosLosElectrodomesticosList.add(electrodomestico);
		System.out.println("Electrodomestico añadido correctamente");
	}
}
