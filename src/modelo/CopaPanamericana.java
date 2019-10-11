package modelo;

import java.io.*;

public class CopaPanamericana {

	// CONSTANTES

	public final static String SP = File.separator;
	public final static String RAIZ = "C:" + SP + "Users" + SP + "Danna García" + SP + "Documents" + SP + "copaPanamericana" + SP;
	public final static String RUTA_GENERADOS = "data" + SP + "Almacenamiento" + SP + "posiblesParticipantes";
	public final static String RUTA_PRUEBA = "data" + SP + "Almacenamiento" + SP + "posiblesParticipantesPrueba";

	// RELACIONES

	private ParticipantePosible primerParticipantePosible;
	private ParticipanteInscrito primerParticipanteInscrito;

	// CONSTRUCTOR

	public CopaPanamericana() {

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

	public void cargarDatosGenerados() {
		try {
			String nombreArchivo = "posiblesParticipantes";
			//Activar el siguiente archivo para ver probar el programa con los 100.000 participantes
			FileReader archivo = new FileReader(RUTA_GENERADOS + nombreArchivo);
			//Activar el siguiente archivo para probar el programa con 10 participantes
			BufferedReader reader = new BufferedReader(archivo);
			String mensaje = reader.readLine();
			while (mensaje != null) {
				String[] datos = mensaje.split(",");
				ParticipantePosible nuevo = new ParticipantePosible(datos[2], datos[3], datos[1]);
				primerParticipantePosible.insertar(nuevo);
				mensaje = reader.readLine();
			}
			reader.close();

		} catch (FileNotFoundException e) {
			e.getCause();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Metodo para agregar los participantes inscritos de manera random
	
	

}
