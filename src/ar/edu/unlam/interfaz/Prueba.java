package ar.edu.unlam.interfaz;

import java.util.Scanner;

import ar.edu.unlam.dominio.MenuEleccionClase;
import ar.edu.unlam.dominio.MenuPrincipal;
import ar.edu.unlam.dominio.Personaje;

public class Prueba {
	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		System.out.println("Bienvenidos al juego de 1 vs 1 de lucha, usted podrá elegir su personaje, el traje y el arma que utilizara para enfrentarse a la máquina. ");
		System.out.println("Cada personaje posee características diferentes! no tengas miedo y anímate a pelear.");
		System.out.println("");
		System.out.println("Ingrese su Nombre");

		String nombre = teclado.next();

		System.out.println("");

		System.out.println("Bienvenido al juego" + " " + nombre);

		System.out.println("");
		Personaje personaje1 = new Personaje();

		mostrarMenu();
	}

	private static void mostrarMenu() {
		Scanner teclado = new Scanner(System.in);
		boolean opcionValida = false;

		while (!opcionValida) {
			System.out.println("Menú Principal:");
			System.out.println("");
			for (MenuPrincipal opcion : MenuPrincipal.values()) {
				System.out.println((opcion.ordinal() + 1) + ". " + opcion);
			}
			System.out.println("");
			
			System.out.print("Que opciones queres seleccionar?:  ");
			
			int opcionSeleccionada = teclado.nextInt();
			
			opcionSeleccionada--;
			if (opcionSeleccionada >= 0 && opcionSeleccionada < MenuPrincipal.values().length) {
				MenuPrincipal opcion = MenuPrincipal.values()[opcionSeleccionada];
				System.out.println("");
				System.out.println("Usted selecciono la opción: " + opcion);
				System.out.println("");
				if (opcion == MenuPrincipal.PELEA) {
					mostrarMenu2();
				}

				opcionValida = true;
			} else {
				System.out.println("Elegiste una opcion incorrecta, Por favor volve a intentarlo.");
			}
		}
	}

	
	private static void mostrarMenu2() {
		Scanner teclado = new Scanner(System.in);
		//boolean opcionValida2=false;
		//while(!opcionValida2) {
		
		System.out.println("ELIJA LA CLASE:");
		System.out.println("");

		for (MenuEleccionClase opcion2 : MenuEleccionClase.values()) {
			System.out.println((opcion2.ordinal() + 1) + "-" + opcion2);
		}

		System.out.println("Que clase deseas seleccionar? :");
		char opcionSeleccionada2 = teclado.next().charAt(0);
		//if(opcionSeleccionada2 == 1 || opcionSeleccionada2 ==2) {
		int a = opcionSeleccionada2 - 48;
		
		a--;

		if (a >= 0 && a < MenuEleccionClase.values().length) {
			MenuEleccionClase opcion2 = MenuEleccionClase.values()[a];

			System.out.println("Usted selecciono la opción: " + opcion2);

			teclado.close();

		}
		}
	}
//}
//}