package modelo;

import java.io.*;

public class CopaPanamericana {

	// CONSTANTES

	public final static String SP = File.separator;
	public final static String RAIZ = "C:" + SP + "Users" + SP + "Danna García" + SP + "Documents" + SP
			+ "copaPanamericana" + SP;
	public final static String RUTA_GENERADOS = "data" + SP + "Almacenamiento" + "posiblesParticipantes";
	public final static String RUTA_PRUEBA = "data" + SP + "Almacenamiento" + "posiblesParticipantesPrueba";

	// RELACIONES

	private ParticipantePosible primerParticipantePosible;
	private ParticipanteInscrito primerParticipanteInscrito;

	// CONSTRUCTOR

	public CopaPanamericana() {
		//agregarParticipanteInscritoAleatoriamente();
	}

	// METODOS

	// Getter y setter

	public ParticipantePosible getPrimerParticipantePosible() {
		return primerParticipantePosible;
	}

	public void setPrimerParticipantePosible(ParticipantePosible primerParticipantePosible) {
		this.primerParticipantePosible = primerParticipantePosible;
	}

	public ParticipanteInscrito getPrimerParticipanteInscrito() {
		return primerParticipanteInscrito;
	}

	public void setPrimerParticipanteInscrito(ParticipanteInscrito primerParticipanteInscrito) {
		this.primerParticipanteInscrito = primerParticipanteInscrito;
	}

	// Metodo para cargar los datos generados de los participantes

	public String cargarDatosGenerados(String rutaDatos) {
		String msg = "";
		try {
			FileReader archivo = new FileReader(rutaDatos);
			BufferedReader reader = new BufferedReader(archivo);
			String mensaje = reader.readLine();
			while (mensaje != null) {
				String[] datos = mensaje.split(",");
				ParticipantePosible nuevo = new ParticipantePosible(datos[2], datos[3], datos[1]);
				primerParticipantePosible.insertar(nuevo);
				mensaje = reader.readLine();
			}
			reader.close();
			msg = "Los datos fueron cargados con éxito";

		} catch (FileNotFoundException e) {
			msg = "Hubo un error cargando los datos";

		} catch (IOException e) {
			msg = "Hubo un error cargando los datos";
		}
		return msg;
	}

	// Metodo para agregar los participantes inscritos de manera random

	public String agregarParticipanteInscritoAleatoriamente() {
		String msg = "";
		int contador = 0;
		int random = 0;
		msg = "Nombre de los participantes elegidos aleatoriamente \n";
		// Generar un numero entre el 1 y el 100.000
		while (contador != primerParticipantePosible.darPeso()) {
			random = (int) (Math.random() * (100000 - 1) + 100000);
			String idRandom = String.valueOf(random);
			ParticipantePosible temp = primerParticipantePosible.buscar(idRandom);
			ParticipanteInscrito nuevo = new ParticipanteInscrito(temp.getNombre(), temp.getApellido(), temp.getId());
			agregarParticipanteInscrito(nuevo);
			msg += nuevo.getNombre() + " " + nuevo.getApellido() + "\n";
		}
		return msg;
	}

	// Metodo para agregar un posible participante

	public void agregarParticipantePosible(ParticipantePosible nuevo) {
		if (nuevo != null)
			primerParticipantePosible.insertar(nuevo);
	}

	// Metodo para agregar un participante inscrito ordenadamente

	public void agregarParticipanteInscrito(ParticipanteInscrito nuevo) {
		if (primerParticipanteInscrito == null)
			primerParticipanteInscrito = nuevo;
		// Verifica si primerParticipanteInscrito es mayor que nuevo
		else if (primerParticipanteInscrito.getId().compareToIgnoreCase(nuevo.getId()) > 0) {
			primerParticipanteInscrito.insertarAntes(nuevo);
			primerParticipanteInscrito = nuevo;
		} else {
			// el temp0 se encarga de asignar
			ParticipanteInscrito temp0 = null;
			// el temp1 se encarga de recorrer la lista
			ParticipanteInscrito temp1 = primerParticipanteInscrito;
			while (temp1 != null && temp1.getId().compareTo(nuevo.getId()) < 0) {
				temp0 = temp1;
				temp1 = temp1.getParticipanteSiguiente();
			}
			if (temp0 != null) {
				temp0.insertarDespues(nuevo);
			}
		}
	}

	// Metodo que busca un posible participante

	public String buscarPosibleParticipante(String id) {
		String msg = "";
		long tiempoActual = System.currentTimeMillis();
		ParticipantePosible participante = primerParticipantePosible.buscar(id);
		long tiempoDespues = System.currentTimeMillis();
		long tiempoTotal = tiempoDespues - tiempoActual;
		msg = "El tiempo que tardo el programa en buscar el ID " + id + " en el arbol fue de " + tiempoTotal + "\n";
		if (participante != null)
			msg += "Se encontró el participante buscado \nNombre del participante: " + participante.getNombre()
					+ "\nApellido del participante: " + participante.getApellido() + "\nID del participante: "
					+ participante.getId();
		else
			msg += "No existe ningún posible participante con el ID ingresado";

		return msg;
	}

	// Metodo que busca un participante por el ID

	public String buscarParticipanteInscrito(String id) {
		String msg = "";
		boolean encontrado = false;
		long tiempoActual = System.currentTimeMillis();
		ParticipanteInscrito actual = primerParticipanteInscrito;
		while (actual != null && !encontrado) {
			if(actual.getId().equals(id)) {
				encontrado = true;
				msg += "Se encontró el participante buscado \nNombre del participante: " + actual.getNombre()
				+ "\nApellido del participante: " + actual.getApellido() + "\nID del participante: "
				+ actual.getId() + "\n";
			}
			else {
				actual = actual.getParticipanteSiguiente();
			}
		}//Cierra el while
		long tiempoDespues = System.currentTimeMillis();
		long tiempoTotal = tiempoDespues - tiempoActual;
		msg = "El tiempo que tardo el programa en buscar el ID " + id + " en el arbol fue de " + tiempoTotal + "\n";
		if(encontrado == false)
			msg += "No existe ningun participante con el ID ingresado";
		return msg;
	}

}
