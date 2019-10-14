package modelo;

import java.io.*;

public class CopaPanamericana {

	// CONSTANTES

	public final static String SP = File.separator;
	public final static String RAIZ = "C:" + SP + "Users" + SP + "Danna García" + SP + "Documents" + SP
			+ "copaPanamericana" + SP;
	public final static String RUTA_GENERADOS = RAIZ + "data" + SP + "Almacenamiento" + SP
			+ "posiblesParticipantes.csv";
	public final static String RUTA_PRUEBA = RAIZ + "data" + SP + "Almacenamiento" + SP
			+ "posiblesParticipantesPrueba.csv";

	// RELACIONES

	private ParticipantePosible primerParticipantePosible;
	private ParticipanteInscrito primerParticipanteInscrito;

	// CONSTRUCTOR

	public CopaPanamericana() {
		//cargarDatosGenerados(RUTA_PRUEBA);
		cargarDatosGenerados(RUTA_GENERADOS);
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
				ParticipantePosible nuevo = new ParticipantePosible(datos[1], datos[2], datos[0]);
				if (nuevo != null)
					agregarParticipantePosible(nuevo);
				mensaje = reader.readLine();
			}
			reader.close();
			msg = "Los datos fueron cargados con éxito";

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return msg;
	}

	// Metodo para agregar los participantes inscritos de manera random

	public String agregarParticipanteInscritoAleatoriamente() {
		String msg = "";
		int contador = 0;
		int random = 0;
		boolean igual = false;
		msg = "Nombre de los participantes elegidos aleatoriamente \n";
		// Generar un numero entre el 1 y el 100.000
		while (contador != (int) cantidadPosiblesParticipantes() / 2) {
			random = (int) (Math.random() * cantidadPosiblesParticipantes() + 1);
			String idRandom = String.valueOf(random);

			ParticipantePosible temp = buscarPosibleParticipante(idRandom);
			if (temp != null) {
				ParticipanteInscrito nuevo = new ParticipanteInscrito(temp.getNombre(), temp.getApellido(),
						temp.getId());
				agregarParticipanteInscrito(nuevo);
				msg += nuevo.getNombre() + " " + nuevo.getApellido() + "\n";
			}

			contador++;
		}
		return msg;
	}

	// Metodo para agregar un posible participante

	public void agregarParticipantePosible(ParticipantePosible nuevo) {
		if (primerParticipantePosible == null)
			primerParticipantePosible = nuevo;
		else
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

	// Metodo que verifica que el id no esta repetido

	public boolean idRepetido(String id) {
		boolean repetido = false;
		ParticipanteInscrito actual = primerParticipanteInscrito;
		while (actual != null) {
			if (actual.getId().equals(id))
				repetido = true;
			else
				actual = actual.getParticipanteSiguiente();
		}
		return repetido;
	}

	// Metodo que busca un posible participante y muestra cuanto tiempo tardo

	public String mostrarPosibleParticipanteEncontrado(String id) {
		String msg = "";
		long tiempoActual = System.currentTimeMillis();

		ParticipantePosible participante = buscarPosibleParticipante(id);

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

	// Metodo que busca un participante inscrito y muestra cuanto tiempo tardo

	public String mostrarParticipanteInscritoEncontrado(String id) {
		String msg = "";
		long tiempoActual = System.currentTimeMillis();

		ParticipanteInscrito participante = buscarParticipanteInscrito(id);

		long tiempoDespues = System.currentTimeMillis();
		long tiempoTotal = tiempoDespues - tiempoActual;

		msg = "El tiempo que tardo el programa en buscar el ID " + id + " en la lista doblemente enlazada fue de " + tiempoTotal + "\n";

		if (participante != null)
			msg += "Se encontró el participante buscado \nNombre del participante: " + participante.getNombre()
					+ "\nApellido del participante: " + participante.getApellido() + "\nID del participante: "
					+ participante.getId();
		else
			msg += "No existe ningún posible participante con el ID ingresado";

		return msg;
	}

	// Metodo para buscar posible participante

	public ParticipantePosible buscarPosibleParticipante(String id) {
		return primerParticipantePosible == null ? null : primerParticipantePosible.buscar(id);
	}

	// Metodo para buscar un participante inscrito

	public ParticipanteInscrito buscarParticipanteInscrito(String id) {
		return primerParticipanteInscrito == null ? null : primerParticipanteInscrito.buscarParticipanteInscrito(id);
	}
	
	//Metodo para saber cuantos posibles participantes hay
	
	public int cantidadPosiblesParticipantes() {
		int cantidad = primerParticipantePosible.darPeso();
		return cantidad;
	}

}
