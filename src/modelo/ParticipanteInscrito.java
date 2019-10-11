package modelo;

public class ParticipanteInscrito {

	// ATRIBUTOS

	private String nombre;
	private String apellido;
	private int id;
	
	// RELACIONES
	
	private ParticipanteInscrito participanteAnterior;
	private ParticipanteInscrito participanteSiguiente;

	// CONSTRUCTOR
	
	public ParticipanteInscrito(String nombre, String apellido, int id) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.id = id;
	}
	
	//METODOS
	
	//Getter y setter

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
	
	

}
