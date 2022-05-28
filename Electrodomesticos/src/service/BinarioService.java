package service;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import controller.Principal;
import model.Codigo;
import model.Electrodomestico;
import model.ElectrodomesticoGrande;
import model.ElectrodomesticoPeque;

public class BinarioService {

	private final File archivo = new File(Principal.NOMBRE_ARCHIVO_BIN);

	private List<Electrodomestico> todosLosElectrodomesticosList = new ArrayList<>();

	private ActualizarArchivoBinario updateObjectOutputStream = null;

	public void setListEscribiendoBinario(List<Electrodomestico> todosLosElectrodomesticosList) {

		try {
			FileOutputStream fileOutputStream;
			ObjectOutputStream escritura;
			if (todosLosElectrodomesticosList.isEmpty()) {
				fileOutputStream = new FileOutputStream(archivo);
				escritura = new ObjectOutputStream(fileOutputStream);
				escritura.writeObject(new ElectrodomesticoGrande(new Codigo("A4541484"), "Sin descripcion", "ASUS", 2,
						5, 2.5, 1.25, 1, 1, false));
			} else {
				fileOutputStream = new FileOutputStream(archivo);
				escritura = new ObjectOutputStream(fileOutputStream);
				for (Electrodomestico electrodomestico : todosLosElectrodomesticosList) {
					escritura.writeObject(electrodomestico);
				}
				System.out.println("Lista actualizada");
			}

			escritura.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public List<Electrodomestico> getListLeyendoBinario() throws ClassNotFoundException {
		try {
			FileInputStream fileInputStream = new FileInputStream(archivo);
			ObjectInputStream lectura = new ObjectInputStream(fileInputStream);
			while (fileInputStream.available() > 0) {
				Electrodomestico electrodomestico = (Electrodomestico) lectura.readObject();
				todosLosElectrodomesticosList.add(electrodomestico);
			}
			fileInputStream.close();
		} catch (EOFException e) {
			System.out.println("Error al leer el archivo");
			e.printStackTrace();
			return new ArrayList<Electrodomestico>();
		} catch (IOException e) {
			System.out.println("Error al leer el archivo");
			e.printStackTrace();
			return new ArrayList<Electrodomestico>();
		}
		return todosLosElectrodomesticosList;
	}

	public void addBinario(List<Electrodomestico> todosLosElectrodomesticosList) {

		try {
			FileOutputStream fileOutputStream = new FileOutputStream(archivo, true);
			// Al principio del programa la lista está vacía.
			if (todosLosElectrodomesticosList.isEmpty()) {
				todaLaListaVacia(fileOutputStream);
			} else {
				updateObjectOutputStream = new ActualizarArchivoBinario(fileOutputStream);
				for (Electrodomestico electrodomestico : todosLosElectrodomesticosList) {
					updateObjectOutputStream.writeObject(electrodomestico);
				}
			}

			if (updateObjectOutputStream != null) {
				updateObjectOutputStream.close();
			}

		} catch (IOException e) {
			System.out.println("Error al escribir en el archivo");
			e.printStackTrace();
		}
	}

	private void todaLaListaVacia(FileOutputStream fileOutputStream) throws IOException {

		updateObjectOutputStream = new ActualizarArchivoBinario(fileOutputStream);

		updateObjectOutputStream
				.writeObject(new ElectrodomesticoPeque(new Codigo("B1288157"), "descripcion", "ATVR", 11, 250.50));
		updateObjectOutputStream.writeObject(new ElectrodomesticoGrande(new Codigo("A1288100"), " sin descripcion",
				"ARUU", 6, 200, 12, 2.5, 1.35, 5, false));
		updateObjectOutputStream
				.writeObject(new ElectrodomesticoPeque(new Codigo("B1288444"), "descripcion", "ATVR", 4, 175));

	}

}
