package modelo;

public class ParticipanteRepetidoException extends Exception{
	
	public ParticipanteRepetidoException(String id) {
		super("El ID " + id + " ya se encuentra registrado");
	}

}
