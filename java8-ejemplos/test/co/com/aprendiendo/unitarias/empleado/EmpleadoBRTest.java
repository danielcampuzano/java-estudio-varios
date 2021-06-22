package co.com.aprendiendo.unitarias.empleado;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmpleadoBRTest {

	@Test
	void testCalculaSalarioBruto() {
		EmpleadoBR emBr = new EmpleadoBR();
		float resultadoReal = emBr.calculaSalarioBruto("vendedor", 2000.0f, 8.0f);
		float resultadoEsperado = 1360.0f;
		assertEquals(resultadoEsperado, resultadoReal, 0.01);
	}

	@Test
	void testCalculaSalarioNeto() {
		EmpleadoBR emBr = new EmpleadoBR();
		float resultadoReal = emBr.calculaSalarioNeto(2000.0f);
		float resultadoEsperado = 1640.0f;
		assertEquals(resultadoEsperado, resultadoReal, 0.01);
	}
	
//	@Test(expected=BRException.class)
//	void testCalculaSalarioBruto() {
//		
//	}

}
