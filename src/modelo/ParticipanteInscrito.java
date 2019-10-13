package modelo;

import java.text.ParseException;

public class ParticipanteInscrito {

	// ATRIBUTOS

	private String nombre;
	private String apellido;
	private String id;

	// RELACIONES

	private ParticipanteInscrito participanteAnterior;
	private ParticipanteInscrito participanteSiguiente;

	// CONSTRUCTOR

	public ParticipanteInscrito(String nombre, String apellido, String id) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.id = id;
	}

	// METODOS

	// Getter y setter

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ParticipanteInscrito getParticipanteAnterior() {
		return participanteAnterior;
	}

	public void setParticipanteAnterior(ParticipanteInscrito participanteAnterior) {
		this.participanteAnterior = participanteAnterior;
	}

	public ParticipanteInscrito getParticipanteSiguiente() {
		return participanteSiguiente;
	}

	public void setParticipanteSiguiente(ParticipanteInscrito participanteSiguiente) {
		this.participanteSiguiente = participanteSiguiente;
	}

	// Metodo que inserta un participante antes que otro

	public void insertarAntes(ParticipanteInscrito nuevo) {
		if (participanteAnterior != null)
			participanteAnterior.participanteSiguiente = nuevo;

		nuevo.participanteAnterior = participanteAnterior;
		nuevo.participanteSiguiente = this;
		participanteAnterior = nuevo;

	}
	
	//Metodo que inserta un participante despues de otro

	public void insertarDespues(ParticipanteInscrito nuevo) {
		nuevo.participanteSiguiente = participanteSiguiente;
		if (participanteSiguiente != null)
			participanteSiguiente.participanteAnterior = nuevo;
		nuevo.participanteAnterior = this;
		participanteSiguiente = nuevo;
	}

}
