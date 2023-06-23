package ar.edu.unlam.interfaz;

import java.util.Scanner;

import ar.edu.unlam.dominio.MenuEleccionClase;
import ar.edu.unlam.dominio.MenuPrincipal;
import ar.edu.unlam.dominio.Personaje;
import ar.edu.unlam.dominio.MenuPelea;

public class Main {
	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		System.out.println(
				"Bienvenidos al juego de 1 vs 1 de lucha, usted podrá elegir su personaje, el traje y el arma que utilizara para enfrentarse a la máquina. ");
		System.out.println("Cada personaje posee características diferentes! no tengas miedo y anímate a pelear.");
		System.out.println("");
		System.out.println("Ingrese su Nombre");

		String nombre = teclado.next();

		System.out.println("");

		System.out.println("Bienvenido al juego, " + nombre);

		System.out.println("");
		// Personajes personaje1 = new Personajes(100, 20);

		mostrarMenuPrincipal();
	}

	private static void mostrarMenuPrincipal() {
		Scanner teclado = new Scanner(System.in);
		boolean opcionValida = false;

		while (!opcionValida) {
			System.out.println("Menú Principal:");
			System.out.println("");

//			for (MenuPrincipal opcion : MenuPrincipal.values()) {
//				System.out.println((opcion.ordinal() + 1) + ". " + opcion);
//			}

			for (int i = 0; i < MenuPrincipal.values().length; i++) {
				MenuPrincipal opcion = MenuPrincipal.values()[i];
				System.out.println((opcion.ordinal() + 1) + ". " + opcion);
			}

			System.out.println("");

			System.out.print("Que opciones queres seleccionar?:  ");
			char op1 = teclado.next().charAt(0);
			// int opcionSeleccionada = teclado.nextInt();
			int opcionSeleccionada = op1 - 48;// se puede restarle 47 y evitar la linea siguiente de decremento

			opcionSeleccionada--;
			if (opcionSeleccionada >= 0 && opcionSeleccionada < MenuPrincipal.values().length) {
				MenuPrincipal opcion = MenuPrincipal.values()[opcionSeleccionada];
				System.out.println("");
				System.out.println("Usted selecciono la opción: " + opcion);
				System.out.println("");
				if (opcion == MenuPrincipal.PELEA) {
					menuDeDificultad();
					menuDeClase();
					procesoMenuPelea(teclado);
					// menuDeCompras()

				}

				opcionValida = true;
			} else {
				System.out.println("Elegiste una opcion incorrecta, Por favor volve a intentarlo.");
			}
		}
	}

	private static void menuDeCompras() {
		System.out.println("Ahora vamos a equipar al personaje");

	}

	private static void menuDeDificultad() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Seleccione la dificultad que desea enfrentar: ");

		boolean validarDificultad = false;
		do {
			System.out.println("1. Facil");
			System.out.println("2. Normal");
			System.out.println("3. Dificil");
			char opcionDificultad = teclado.next().charAt(0);
			switch (opcionDificultad) {
			case '1':
				System.out.println("Usted eligio la dificultad Facil");
				// crear objeto con parametros bajos
				Personaje rival1 = new Personaje(1000, 100);

				validarDificultad = true;
				break;
			case '2':
				System.out.println("Usted eligio la dificultar Normal");
				// crear objeto con parametros medios
				Personaje rival2 = new Personaje(1500, 150);

				validarDificultad = true;
				break;
			case '3':
				System.out.println("Usted eligio la mayor dificultad, suerte con eso");
				// crear objeto con parametros altos
				Personaje rival3 = new Personaje(2500, 200);

				validarDificultad = true;
				break;
			default:
				System.out.println("Ingrese una opcion valida");
			}
		} while (!validarDificultad);

	}

	private static void menuDeClase() {
		Scanner teclado = new Scanner(System.in);
		boolean opcionValida = false;
		while (!opcionValida) {

			System.out.println("ELIJA LA CLASE:");
			System.out.println("");

//			for (MenuEleccionClase opcion2 : MenuEleccionClase.values()) {
//				System.out.println((opcion2.ordinal() + 1) + "-" + opcion2);
//			}

			for (int i = 0; i < MenuEleccionClase.values().length; i++) {
				MenuEleccionClase opcion2 = MenuEleccionClase.values()[i];
				System.out.println((opcion2.ordinal() + 1) + ". " + opcion2);
			}

			System.out.println("Que clase deseas seleccionar? :");
			char op1 = teclado.next().charAt(0);
			int opcionSeleccionada2 = op1 - 48;
			// int opcionSeleccionada2 = teclado.nextInt();
			opcionSeleccionada2--;

			if (opcionSeleccionada2 >= 0 && opcionSeleccionada2 < MenuEleccionClase.values().length) {
				MenuEleccionClase opcion2 = MenuEleccionClase.values()[opcionSeleccionada2];

				System.out.println("Usted selecciono la opción: " + opcion2);
				opcionValida = true;

			} else
				System.out.println("Por favor ingrese una opcion valida");
		}
	}
	
	private static void procesoMenuPelea(Scanner teclado) {
		MenuPelea opcionMenuPelea;
		
		do {
			mostrarMenuPelea();
			
			opcionMenuPelea = ingresarOpcion(teclado);
			
			switch(opcionMenuPelea) {
			case ATACAR:
				System.out.println("");
				break;
			case DEFENDER:
				System.out.println("");
				break;
			}
		} while (opcionMenuPelea==MenuPelea.ATACAR || opcionMenuPelea==MenuPelea.DEFENDER); //no
	}
	
	private static MenuPelea ingresarOpcion(Scanner teclado) {
		MenuPelea opcionMenuPelea = MenuPelea.ATACAR;
		int opcion = 0;

		do {
			opcion = teclado.nextInt();
			if (opcion>=0 && opcion<MenuPelea.values().length) {
				opcionMenuPelea = MenuPelea.values()[opcion];
			} else {
				System.out.println("Opcion Invalida");
				mostrarMenuPelea();
			}
		} while (opcion < 0 || opcion >= MenuPelea.values().length);
		
		return opcionMenuPelea;

	}

	private static void mostrarMenuPelea() {
		System.out.println(" ");
		System.out.println("COMBATIENDO...");
		System.out.println(" ");
		System.out.println("Ingrese la accion que quiere realizar: ");
		for (int i = 0; i < MenuPelea.values().length; i++) {
			MenuPelea opcion = MenuPelea.values()[i];
			System.out.println((opcion.ordinal() + 1) + ". " + opcion);
//			System.out.println("Ingrese " + i + " " + MenuPelea.values().length);
		}
	}

}
