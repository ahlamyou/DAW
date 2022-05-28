package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import model.Electrodomestico;
import service.BinarioService;

public class Principal {

	public final static String NOMBRE_ARCHIVO_BIN = "archivo.bin";
	private static Menu menu = new Menu();
	private static BinarioService binarioService = new BinarioService();

	public static void main(String[] args) throws InterruptedException, ClassNotFoundException {

		try {
			final File archivo = new File(NOMBRE_ARCHIVO_BIN);
			// Si el archivo no existe, lo crea
			if (!archivo.exists()) {
				archivoBinarioNoExiste(archivo);
				// Pero si existe:
			} else {
				archivoBinarioExiste(archivo);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			menu.menu(binarioService.getListLeyendoBinario());
		} catch (IOException e) {
			e.printStackTrace();
			menu.menu(binarioService.getListLeyendoBinario());
		}
	}

	private static void archivoBinarioNoExiste(File archivo) throws ClassNotFoundException, InterruptedException {
		binarioService.setListEscribiendoBinario(new ArrayList<Electrodomestico>());
		binarioService.addBinario(new ArrayList<Electrodomestico>());
		menu.menu(binarioService.getListLeyendoBinario());
	}

	private static void archivoBinarioExiste(File archivo)
			throws ClassNotFoundException, IOException, InterruptedException {
		FileInputStream fileInputStream = new FileInputStream(archivo);
		// Si el archivo no tiene bytes, se escribe
		if (fileInputStream.available() <= 0) {
			binarioService.setListEscribiendoBinario(new ArrayList<Electrodomestico>());
			binarioService.addBinario(new ArrayList<Electrodomestico>());
			menu.menu(binarioService.getListLeyendoBinario());
			fileInputStream.close();
			// Si ya tiene algo escrito, algún byte, que lea esta lista inicial y la manda
			// al menú.
		} else {
			menu.menu(binarioService.getListLeyendoBinario());
		}
	}

}
