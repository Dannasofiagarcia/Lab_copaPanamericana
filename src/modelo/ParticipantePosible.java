package modelo;

public class ParticipantePosible implements Comparable {

	// ATRIBUTOS

	private String nombre;
	private String apellido;
	private String id;

	// RELACIONES

	private ParticipantePosible izquierda;
	private ParticipantePosible derecha;

	// CONSTRUCTOR

	public ParticipantePosible(String nombre, String apellido, String id) {
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

	public ParticipantePosible getIzquierda() {
		return izquierda;
	}

	public void setIzquierda(ParticipantePosible izquierda) {
		this.izquierda = izquierda;
	}

	public ParticipantePosible getDerecha() {
		return derecha;
	}

	public void setDerecha(ParticipantePosible derecha) {
		this.derecha = derecha;
	}

	public int compareTo(Object o) {
		ParticipantePosible otro = (ParticipantePosible) o;
		// Si es > 0 el que invoca el metodo es mayor
		// Si es < 0 el que invoca el metodo es menor
		return id.compareToIgnoreCase(otro.getId());
	}

	public void insertar(ParticipantePosible nuevo) {
		if (compareTo(nuevo.getId()) == 0)
			// throw new ContactoRepetidoException( nuevo.nombre );

			//Verifica si el que invoca el metodo es mayor que el nuevo
			if (compareTo(nuevo.getId()) > 0) {
				// Debe agregar el nuevo contacto por el subárbol izquierdo
				if (izquierda == null)
					izquierda = nuevo;
				else
					// vuelve a evaluar el metodo pero ahora agregandolo al participante de la
					// izquierda teniendo en
					// cuenta
					izquierda.insertar(nuevo);
			} else {
				// Debe agregar el nuevo contacto por el subárbol derecho
				if (derecha == null)
					derecha = nuevo;
				else
					derecha.insertar(nuevo);
			}
	}

}
