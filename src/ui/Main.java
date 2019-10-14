package ui;

import modelo.*;
import java.util.*;

public class Main {
	
	private CopaPanamericana copaPanamericana;
	private Scanner lector;
	
	public Main() {
		copaPanamericana = new CopaPanamericana();
		lector = new Scanner(System.in);
		
	}

	public static void main(String[] args) {
		Main interfaz = new Main();
		interfaz.menu();
	}
	
	public void showOptions() {
		System.out.println("Bienvenido a la Copa Panamericana");
		System.out.println("Seleccione la opción que desea");
		System.out.println("1. Registrar un posible participante");
		System.out.println("2. Para agregar de manera aleatoria los participantes inscritos");		
		System.out.println("3. Buscar un posible participante de la Copa");
		System.out.println("4. Para buscar un participante inscrito en la Copa");
		System.out.println("5. Cargar los datos al programa");
		System.out.println("6. Salir");
	}
	
	public void menu() {
		int userInput = 0;

		while (userInput != 6) {
			showOptions();
			userInput = lector.nextInt();
			lector.nextLine();

			switch (userInput) {
			case 1:
				System.out.println("Ingrese el nombre del posible participante que desea agregar");
				String nombre = lector.nextLine();
				
				System.out.println("Ingrese el apellido del posible participante que desea agregar");
				String apellido = lector.nextLine();
				
				System.out.println("Ingrese el ID del participante que desea agregar");
				String id = lector.nextLine();
				
				ParticipantePosible nuevo = new ParticipantePosible(nombre, apellido, id);
				copaPanamericana.agregarParticipantePosible(nuevo);
				
			break;
			
			case 2:
				System.out.println(copaPanamericana.agregarParticipanteInscritoAleatoriamente());
			break;
			
			case 3:
				
				System.out.println("Ingrese el ID del participante que desea buscar");
				String idBuscado = lector.nextLine();
				
				System.out.println(copaPanamericana.mostrarPosibleParticipanteEncontrado(idBuscado));
				
			break;
			
			case 4:
				
				System.out.println("Ingrese el ID del participante que desea buscar");
				String idBuscado1 = lector.nextLine();
				
				System.out.println(copaPanamericana.mostrarParticipanteInscritoEncontrado(idBuscado1));
				
			break;
			
			case 5:
				System.out.println("Seleccione que tipo de ruta desea elegir");
				System.out.println("1. Predefinida del programa\n 2. Ruta ingresada por usted");
				int seleccionRuta = lector.nextInt();
				lector.nextLine();
				
				if(seleccionRuta == 1) {
					//System.out.println(copaPanamericana.cargarDatosGenerados(copaPanamericana.RUTA_PRUEBA));
					System.out.println(copaPanamericana.cargarDatosGenerados(copaPanamericana.RUTA_GENERADOS));
				}
				
				else {
					System.out.println("Ingrese la ruta de la siguiente manera: C:/Ubicacion/Carpeta/Nombre");
					String rutaDatos = lector.nextLine();
					System.out.println(copaPanamericana.cargarDatosGenerados(rutaDatos));
				}
			break;
				
			}//Cierra el switch
		}//Cierra el while
	}//Cierra el metodo

}
