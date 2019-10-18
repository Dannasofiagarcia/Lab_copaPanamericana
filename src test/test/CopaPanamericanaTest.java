package test;

import static org.junit.Assert.*;

import org.junit.Test;
import modelo.*;
import java.util.*;
import org.junit.Test;
import junit.framework.*;

public class CopaPanamericanaTest {

	private CopaPanamericana copaPanamericanaTest;

	// Escenario donde se agregan cuatro posibles participantes

	private void setupEscenario1() {
		copaPanamericanaTest = new CopaPanamericana();
		ParticipantePosible uno = new ParticipantePosible("Participante", "Uno", "1");
		ParticipantePosible dos = new ParticipantePosible("Participante", "Dos", "2");
		ParticipantePosible tres = new ParticipantePosible("Participante", "Tres", "3");
		ParticipantePosible cuatro = new ParticipantePosible("Participante", "Cuatro", "4");
		
		copaPanamericanaTest.agregarParticipantePosible(uno);
		copaPanamericanaTest.agregarParticipantePosible(dos);
		copaPanamericanaTest.agregarParticipantePosible(tres);
		copaPanamericanaTest.agregarParticipantePosible(cuatro);
	}

	private void setupEscenario2() {
		setupEscenario1();
		ParticipanteInscrito uno = new ParticipanteInscrito("Inscrito", "Uno", "1");
		ParticipanteInscrito dos = new ParticipanteInscrito("Inscrito", "Dos", "2");
		ParticipanteInscrito tres = new ParticipanteInscrito("Inscrito", "Tres", "3");
		ParticipanteInscrito cuatro = new ParticipanteInscrito("Inscrito", "Cuatro", "4");
		
		copaPanamericanaTest.agregarParticipanteInscrito(uno);
		copaPanamericanaTest.agregarParticipanteInscrito(dos);
		copaPanamericanaTest.agregarParticipanteInscrito(tres);
		copaPanamericanaTest.agregarParticipanteInscrito(cuatro);
		

	}

	@Test

	public void testBuscarParticipantePosible() {
		setupEscenario1();

		ParticipantePosible c;

		// Busca un nombre que no existe
		c = copaPanamericanaTest.buscarPosibleParticipante("0");
		assertNull(c);

		// Busca uno que si existe
		c = copaPanamericanaTest.buscarPosibleParticipante("4");
		assertNotNull(c);
		assertEquals("4", c.getId());
	}

	@Test

	public void testAgregarParticipantePosible() {
		setupEscenario1();
		ParticipantePosible p = new ParticipantePosible("Participante", "Prueba", "6");
		copaPanamericanaTest.agregarParticipantePosible(p);
		assertEquals("6", p.getId());
	}

	@Test

	public void testBuscarParticipanteInscrito() {
		setupEscenario2();
		ParticipanteInscrito c;
		
		// Busca un id que no existe
		c = copaPanamericanaTest.buscarParticipanteInscrito("0");
		assertNull(c);

		// Busca uno que si existe
		c = copaPanamericanaTest.buscarParticipanteInscrito("4");
		assertNotNull(c);
		assertEquals("4", c.getId());

	}
	
	//El metodo se demora en comprobar
	@Test
	
	public void testAgregarParticipanteInscritoAleatoriamente() {
		setupEscenario1();
		boolean esperado = true;
		copaPanamericanaTest.agregarParticipanteInscritoAleatoriamente();
		boolean resultado = false;
		if(copaPanamericanaTest.getPrimerParticipanteInscrito() != null)
			resultado = true;
		assertEquals(esperado, resultado);
	}

	
	@Test
	
	public void testCantidadPosiblesParticipantes() {
		setupEscenario1();
		int esperado = 100000;
		int resultado = copaPanamericanaTest.cantidadPosiblesParticipantes();
		assertEquals(esperado,resultado);
		
	}
}
