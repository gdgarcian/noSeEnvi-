/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// Desarrollado por
// Vladimir Vargas Díaz
// Kevin Felipe Marroquín
// Germán David García Nieves
package no.se.envió;

import java.util.Scanner;


public class Traductor {
    final static int INGLES = 1;
	final static int FRANCES = 2;
	final static int ITALIANO = 3;
	final static int ESPANOL = 4;

	static int seleccion = 0;
	static int indice = 0;

	static String[] diccionarioIngles = new String[20];
	static String[] diccionarioFrances = new String[20];
	static String[] diccionarioItaliano = new String[20];
	static String[] diccionarioEspanol = new String[20];

	static int numPalabras = 0;

	static Scanner entrada = new Scanner(System.in);

	static void menu() {
		System.out.println("Traductor de palabras.");
		System.out.println("1) Agregar palabra.");
		System.out.println("2) Traducir palabra.");
		System.out.println("3) Salir");
	}

	static void idiomas(int a) {
		if (a == 0) {
			System.out.println("1) Ingles");
			System.out.println("2) Frances");
			System.out.println("3) Italiano");
		} else if (a == 1) {
			System.out.println("1) Ingles");
			System.out.println("2) Frances");
			System.out.println("3) Italiano");
			System.out.println("4) Español");
		} else if (a == 2) {
			System.out.println("2) Frances");
			System.out.println("3) Italiano");
			System.out.println("4) Español");
		} else if (a == 3) {
			System.out.println("1) Ingles");
			System.out.println("3) Italiano");
			System.out.println("4) Español");
		} else if (a == 4) {
			System.out.println("1) Ingles");
			System.out.println("2) Frances");
			System.out.println("4) Español");
		}
	}

	static void agregarPalabras() {
		int idioma = 0;
		String palabra = null;
		String traduccion = null;

		System.out.println("Ingrese la nueva palabra");
		palabra = entrada.next();
		System.out.println("Seleccione el idioma de la traduccion");
		idiomas(0);
		idioma = entrada.nextInt();
		System.out.println("");
		System.out.println("Ingrese la traduccion");
		traduccion = entrada.next();

		if (!"".equals(palabra) && !"".equals(traduccion)){
			switch (idioma) {
			case INGLES:
				if (!verificarEsp(palabra)) {
					diccionarioEspanol[numPalabras] = palabra;
					diccionarioIngles[numPalabras] = traduccion;
					System.out.println("La traduccion a sido agregada con exito.");
					numPalabras++;
				}else{
					if(diccionarioIngles[indice] == null)
						diccionarioIngles[indice] = traduccion;
				}
				break;
			case FRANCES:
				if (!verificarEsp(palabra)) {
					diccionarioEspanol[numPalabras] = palabra;
					diccionarioFrances[numPalabras] = traduccion;
					numPalabras++;
				}else{
					if(diccionarioFrances[indice] == null)
						diccionarioFrances[indice] = traduccion;
				}
				break;
			case ITALIANO:
				if (!verificarEsp(palabra)) {
					diccionarioEspanol[numPalabras] = palabra;
					diccionarioItaliano[numPalabras] = traduccion;
					numPalabras++;
				}else{
					if(diccionarioItaliano[indice] == null)
						diccionarioItaliano[indice] = traduccion;
				}
				break;
			case 4:
				break;
			default:
			}
	}else {

		}
	}

	static boolean verificarEsp(String palabra) {
		boolean repetida = false;
		for (int i = 0; i < numPalabras; i++) {
			if(diccionarioEspanol[i] != null)
			if (palabra.equals(diccionarioEspanol[i])) {
				repetida = true;
				indice = i;
			}
		}
		
		return repetida;
	}
	
	static boolean verificarIng(String palabra){
		boolean repetida = false;
		for (int i = 0; i < numPalabras; i++) {
			if(diccionarioIngles[i] != null)
			if (palabra.equals(diccionarioIngles[i])) {
				repetida = true;
				indice = i;
			}
		}		
		return repetida;
	}
	
	static boolean verificarFran(String palabra){
		boolean repetida = false;
		for (int i = 0; i < numPalabras; i++) {
			if(diccionarioFrances[i] != null)
			if (palabra.equals(diccionarioFrances[i])) {
				repetida = true;
				indice = i;
			}
		}		
		return repetida;
	}
	
	static boolean verificarIt(String palabra){
		boolean repetida = false;
		for (int i = 0; i < numPalabras; i++) {
			if(diccionarioItaliano[i] != null)
			if (palabra.equals(diccionarioItaliano[i])) {
				repetida = true;
				indice = i;
			}
		}
		return repetida;
	}

	static void traducirPalabras() {
		String palabra = null;
		System.out.println("Ingrese el idioma de la palabra que desea traducir.");
		idiomas(1);
		seleccion = entrada.nextInt();
		System.out.println("Ingrese la palabra que desea traducir");
		palabra = entrada.next();

		switch (seleccion) {
		case INGLES:
			System.out.println("Ingrese el el idioma al que desea traducir");
			idiomas(2);
			seleccion = entrada.nextInt();
			switch (seleccion) {
			case ESPANOL:
				if(verificarIng(palabra)){
					if( diccionarioEspanol[indice] != null ){
						System.out.println("Traduccion Ingles/espanol");
						System.out.println(diccionarioIngles[indice]+" : " + diccionarioEspanol[indice]);
					}else{
						System.out.println("No se ha encontrado la traduccion");
					}
				}
				break;
			case FRANCES:
				if(verificarIng(palabra)){
					if( diccionarioEspanol[indice] != null ){
						System.out.println("Traduccion Ingles/Frances");
						System.out.println(diccionarioIngles[indice]+" : " + diccionarioFrances[indice]);
					}else{
						System.out.println("No se ha encontrado la traduccion");
					}
				}
				break;
			case ITALIANO:
				if(verificarIng(palabra)){
					if( diccionarioEspanol[indice] != null ){
						System.out.println("Traduccion Ingles/Italiano");
						System.out.println(diccionarioIngles[indice]+" : " + diccionarioItaliano[indice]);
					}else{
						System.out.println("No se ha encontrado la traduccion");
					}
				}
				break;
			}
			break;
		case FRANCES:
			System.out.println("Ingrese el el idioma al que desea traducir");
			idiomas(3);
			seleccion = entrada.nextInt();
			switch (seleccion) {
			case ESPANOL:
				if(verificarFran(palabra)){
					if( diccionarioEspanol[indice] != null ){
						System.out.println("Traduccion Frances/Espanol");
						System.out.println(diccionarioFrances[indice]+" : " + diccionarioEspanol[indice]);
					}else{
						System.out.println("No se ha encontrado la traduccion");
					}
				}
				break;
			case INGLES:
				if(verificarFran(palabra)){
					if( diccionarioIngles[indice] != null ){
						System.out.println("Traduccion Frances/Ingles");
						System.out.println(diccionarioFrances[indice]+" : " + diccionarioIngles[indice]);
					}else{
						System.out.println("No se ha encontrado la traduccion");
					}
				}
				break;
			case ITALIANO:
				if(verificarFran(palabra)){
					if( diccionarioItaliano[indice] != null ){
						System.out.println("Traduccion Frances/Italiano");
						System.out.println(diccionarioFrances[indice]+" : " + diccionarioItaliano[indice]);
					}else{
						System.out.println("No se ha encontrado la traduccion");
					}
				}
				break;
			}
			break;
		case ITALIANO:
			System.out.println("Ingrese el el idioma al que desea traducir");
			idiomas(4);
			seleccion = entrada.nextInt();
			switch(seleccion){
				case INGLES:
					if(verificarIt(palabra)){
						if( diccionarioIngles[indice] != null ){
							System.out.println("Traduccion Italiano/Ingles");
							System.out.println(diccionarioItaliano[indice]+" : " + diccionarioIngles[indice]);
						}else{
							System.out.println("No se ha encontrado la traduccion");
						}
					}
					break;
				case FRANCES:
					if(verificarIt(palabra)){
						if( diccionarioFrances[indice] != null ){
							System.out.println("Traduccion Italiano/Frances");
							System.out.println(diccionarioItaliano[indice]+" : " + diccionarioFrances[indice]);
						}else{
							System.out.println("No se ha encontrado la traduccion");
						}
					}
					break;
				case ESPANOL:
					if(verificarIt(palabra)){
						if( diccionarioIngles[indice] != null ){
							System.out.println("Traduccion Italiano/Espanol");
							System.out.println(diccionarioItaliano[indice]+" : " + diccionarioEspanol[indice]);
						}else{
							System.out.println("No se ha encontrado la traduccion");
						}
					}
					break;
			}
			break;
		case ESPANOL:
			System.out.println("Ingrese el el idioma al que desea traducir");
			idiomas(0);
			seleccion = entrada.nextInt();
			switch (seleccion) {
			case INGLES:
				if(verificarEsp(palabra)){
					if( diccionarioIngles[indice] != null ){
						System.out.println("Traduccion Espanol/Ingles");
						System.out.println(diccionarioEspanol[indice]+" : " + diccionarioIngles[indice]);
					}else{
						System.out.println("No se ha encontrado la traduccion");
					}
				}
				break;
			case FRANCES:
				if(verificarEsp(palabra)){
					if( diccionarioFrances[indice] != null ){
						System.out.println("Traduccion Espanol/Frances");
						System.out.println(diccionarioEspanol[indice]+" : " + diccionarioFrances[indice]);
					}else{
						System.out.println("No se ha encontrado la traduccion");
					}
				}
				break;
			case ITALIANO:
				if(verificarEsp(palabra)){
					if( diccionarioItaliano[indice] != null ){
						System.out.println("Traduccion Espanol/Italiano");
						System.out.println(diccionarioEspanol[indice]+" : " + diccionarioItaliano[indice]);
					}else{
						System.out.println("No se ha encontrado la traduccion");
					}
				}
				break;
			}			
			break;
		}

	}
	
	static void test(){
		diccionarioEspanol[0] = "culo";
		diccionarioIngles[0] = "ass";
		diccionarioFrances[0] = "cul";
		diccionarioItaliano[0] = "culo";
		
		diccionarioEspanol[1] = "mujer";
		diccionarioIngles[1] = "woman";
		diccionarioFrances[1] = "femme";
		diccionarioItaliano[1] = "donna";
		
		diccionarioEspanol[2] = "sombrero";
		diccionarioIngles[2] = "hat";
		diccionarioFrances[2] = "chapeau";
		diccionarioItaliano[2] = "capello";
		
		diccionarioEspanol[3] = "manzana";
		diccionarioIngles[3] = "apple";
		diccionarioFrances[3] = "pomme";
		diccionarioItaliano[3] = "mela";
		
		diccionarioEspanol[4] = "negro";
		diccionarioIngles[4] = "black";
		diccionarioFrances[4] = "noir";
		diccionarioItaliano[4] = "nero";
		
		numPalabras = 5;
	}
	
	public static void main(String[] args) {
		boolean seguir = true;
		test();
		while (seguir) {
			menu();
			seleccion = entrada.nextInt();
			switch (seleccion) {
			case 1:
				agregarPalabras();
				break;
			case 2:
				traducirPalabras();
				break;
			case 3:
				seguir = false;
				break;
			default:
			}  			
		}
	}
}