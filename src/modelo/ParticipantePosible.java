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
		//if (compareTo(nuevo) == 0)
			// throw new ContactoRepetidoException( nuevo.nombre );

			// Verifica si el que invoca el metodo es mayor que el nuevo
			if (compareTo(nuevo) > 0) {
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

	// Metodo para saber el peso del arbol

	public int darPeso() {
		int p1 = (izquierda == null) ? 0 : izquierda.darPeso();
		int p2 = (derecha == null) ? 0 : derecha.darPeso();
		return 1 + p1 + p2;
	}

	// Metodo que busca un participante por el ID

	public ParticipantePosible buscar(String unId) {
		if (id.compareToIgnoreCase(unId) == 0)
			return this;
		else if (id.compareToIgnoreCase(unId) > 0)
			// condicion ? si es verdadero : si no lo es
			return (izquierda == null) ? null : izquierda.buscar(unId);
		else
			return (derecha == null) ? null : derecha.buscar(unId);
	}
	
	
}
