package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import modelo.CopaPanamericana;
import modelo.ParticipanteInscrito;
import modelo.ParticipantePosible;

public class ParticipantePosibleTest {
	
	CopaPanamericana copaPanamericanaTest;

	// Escenario donde se agregan dos posibles participantes

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
		setupEscenario2();
		ParticipantePosible c = copaPanamericanaTest.getPrimerParticipantePosible();

		// Busca uno que si existe
		c = c.buscar("1");
		assertNotNull(c);
		assertEquals("1", c.getId());

	}

}
