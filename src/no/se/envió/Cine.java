
package no.se.envió;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// Desarrollado por
// Vladimir Vargas Díaz
// Kevin Felipe Marroquín
// Germán David García Nieves

import java.util.Scanner;


public class Cine {

    /**
     * @
     * @param args the command line arguments
     */
    static final int SILLAS = 20;
	static final int FILAS = 11;
	static char[][] cine = new char[FILAS][SILLAS];
	static String[][] reservas = new String[FILAS][SILLAS];

	static void iniciar() {
		for (int i = 0; i < FILAS; i++) {
			for (int j = 0; j < SILLAS; j++) {
				cine[i][j] = 'o';
			}
		}
	}

	static void menu() {

		System.out.println("Programa - Sala de cine");

		System.out.println("1)Reservar sillas con efectivo.");
		System.out.println("2)Reservar sillas con tarjeta.");
		System.out.println("3)Cancelar reserva");
		System.out.println("4)Nueva tarjeta(TARCINE)");
		System.out.println("5)Mostrar sillas disponibles");
		System.out.println("6)Mostrar saldo disponible(TARCINE)");
		System.out.println("7)Mostrar saldo en caja.");
		System.out.println("8)Salir");
	}

	static int reservarEfectivo(char fila, int silla, String tarjeta) {
		int f = conversion(fila);
		if(f != -1 && (silla > 0 && silla <= 20)){
		if (cine[f][silla - 1] == 'o') {
			if (f == 8 || f == 9 || f == 10) {
				cine[f][silla - 1] = 'x';				
				f = 1;
				if(tarjeta != null)
					reservas[f][silla - 1] = tarjeta;
			} else {
				cine[f][silla - 1] = 'x';
				f = 2;
				if(tarjeta != null)
					reservas[f][silla - 1] = tarjeta;
			}
		} else {
			f = -1;
		}
		} else{
			f = -2;
		}
		return f;
	}

	static int verificar(String tarjeta, String[] clientes) {
		int indice = -1;
		for (int i = 0; i < clientes.length; i++) {
			if (clientes[i] != null) {
				if (clientes[i].equals(tarjeta)) {
					indice = i;
					break;
				} else {
					indice = -1;
				}
			}
		}
		return indice;
	}

	static int conversion(char fila) {
		int a = 0;
		if (fila == 'a' || fila == 'A') {
		} else if (fila == 'a' || fila == 'A') {
			a = 0;
		} else if (fila == 'b' || fila == 'B') {
			a = 1;
		} else if (fila == 'c' || fila == 'C') {
			a = 2;
		} else if (fila == 'd' || fila == 'D') {
			a = 3;
		} else if (fila == 'e' || fila == 'E') {
			a = 4;
		} else if (fila == 'f' || fila == 'F') {
			a = 5;
		} else if (fila == 'g' || fila == 'G') {
			a = 6;
		} else if (fila == 'h' || fila == 'h') {
			a = 7;
		} else if (fila == 'i' || fila == 'I') {
			a = 8;
		} else if (fila == 'j' || fila == 'j') {
			a = 9;
		} else if (fila == 'k' || fila == 'K') {
			a = 10;
		} else
			a = -1;
		return a;
	}

	static void mostrarCine() {
		char fila = 'A';
		for (int i = 1; i <= SILLAS; i++) {
			System.out.printf("%3d", i);
		}
		System.out.println();
		for (int i = 0; i < FILAS; i++) {
			System.out.printf("%c ", fila);
			for (int j = 0; j < SILLAS; j++) {
				System.out.printf("%c%s", cine[i][j], "  ");
			}
			System.out.println();
			fila++;
		}
		System.out.println("\nDisponible: o        Ocupado: x\n");
	}
	
	
	
	

	public static void main(String args[]) {

		Scanner entrada = new Scanner(System.in);
		final double PREFERENCIAL = 11000;
		final double GENERAL = 8000;
		final double T_INICIAL = 70000;
		
		String[] clientes = new String[20];
		double[] saldoClientes = new double[20];
		int numeroClientes = 0;
		String tarjeta = null;
		int indice = 0;
		
		boolean seguir = true;
		int seleccion = 0;
		int silla = 0;
		char fila = 0;
		
		double saldo = 0.0;
		
		
		iniciar();
		while (seguir) {
			menu();
			seleccion = entrada.nextInt();
			switch (seleccion) {
			case 1:
				System.out.println("Seleccione la fila A-K");
				fila = entrada.next().charAt(0);
				System.out.println("Seleccione la silla 1-20");
				silla = entrada.nextInt();				
				seleccion = reservarEfectivo(fila, silla, null);
				if(seleccion == 1){
					System.out.println("\nLa reserva de la silla tipo preferencial se ha realizado con exito\n");
					saldo += PREFERENCIAL;					
				}else if(seleccion == 2){
					System.out.println("\nLa reserva de la silla tipo general se ha realizado con exito\n");
					saldo += GENERAL;
				}else if(seleccion == -1){
					System.out.println("\nEl asiento esta ocupado\n");
				}else if(seleccion == -2){
					System.out.println("\nDatos incorrectos\n");
				}
				break;
			case 2:
				
				System.out.println("Ingrese el numero de la tarjeta TARCINE");
				tarjeta = entrada.next();
				indice = verificar(tarjeta, clientes);
				if(indice == -1){
					System.out.println("\nNo se a encontrado la tarjeta: " + tarjeta + "\n");
				}else{
					System.out.println("Seleccione la fila A-K");
					fila = entrada.next().charAt(0);
					System.out.println("Seleccione la silla 1-20");
					silla = entrada.nextInt();				
					seleccion = reservarEfectivo(fila, silla, tarjeta);
					if(seleccion == 1){
						if(saldoClientes[indice]>=PREFERENCIAL){
							System.out.println("\nLa reserva de la silla tipo preferencial se ha realizado con exito\n");
							saldo += PREFERENCIAL;	
						}else{
							System.out.println("\nEl saldo es insuficiente\n");
						}
					}else if(seleccion == 2){
						if(saldoClientes[indice]>=GENERAL){
							System.out.println("\nLa reserva de la silla tipo general se ha realizado con exito\n");
							saldo += GENERAL;
						}else{
							System.out.println("\nEl saldo es insuficiente\n");
						}
					}else if(seleccion == -1){
						System.out.println("\nEl asiento esta ocupado\n");
					}
				}
				break;
			case 3:
				System.out.println("Seleccione el asiento a cancelar");
				System.out.println("Seleccione la fila A-K");
				fila = entrada.next().charAt(0);
				System.out.println("Seleccione la silla 1-20");
				silla = entrada.nextInt();
				
				seleccion = conversion(fila);
				if(cine[seleccion][silla -1] == 'x'){
					if(reservas[seleccion][silla - 1] != null){
						indice = verificar(reservas[seleccion][silla - 1], clientes);
						if (seleccion == 8 || seleccion == 9 || seleccion == 10) {
							saldoClientes[indice] += PREFERENCIAL;
							saldo -= PREFERENCIAL;
							cine[seleccion][silla -1] = 'o';
						}else{
							saldoClientes[indice] += GENERAL;
							saldo -= GENERAL;
							cine[seleccion][silla -1] = 'o';
						}
					}else{
						if (seleccion == 8 || seleccion == 9 || seleccion == 10) {
							saldo -= PREFERENCIAL;
						}else{
							saldo -= GENERAL;
						}
					}
				}else{
					System.out.println("\nEl asiento esta disponible\n");
				}
				break;
			case 4:
				System.out.println("Ingrese el documento del solicitante");
				tarjeta = entrada.next();
				if (verificar(tarjeta, clientes) == -1) {
					clientes[numeroClientes] = tarjeta;
					saldoClientes[numeroClientes] = T_INICIAL;
					numeroClientes++;
					saldo += 70000;
					System.out.println("\nEl registro fue realizado con exito.\n");
				}else{
					System.out.println("\nEl cliente ya existe.\n");
				}
				break;
			case 5:
				System.out.println();
				mostrarCine();
				System.out.println();
				break;
			case 6:
				System.out.println("Ingrese el numero de la tarjeta TARCINE");
				tarjeta = entrada.next();
				indice = verificar(tarjeta, clientes);
				if(indice != -1){
					System.out.println("\nEl saldo de la tarjeta " + clientes[indice] + " "+" es: " + saldoClientes[indice] + "\n");
				}else{
					System.out.println("\nNo se a encontrado la tarjeta: " + tarjeta + "\n");
				}
				break;
			case 7:
				System.out.printf("\n%s%.2f\n","El saldo en caja es de: ", saldo);
				System.out.println();
				break;
			case 8:
				seguir = false;
				break;
			default:				
			}
		}		
		entrada.close();

	}
    
}