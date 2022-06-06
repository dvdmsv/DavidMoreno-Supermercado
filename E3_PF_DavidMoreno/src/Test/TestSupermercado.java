package Test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import supermercado.Supermercado;

public class TestSupermercado {
	private static Supermercado superm;

	@BeforeClass
	public static void setUpBeforeClass() {
		superm = new Supermercado();
	}

	@Test
	public void testGenerarHash() {
		String calculado = superm.generarHash("admin");
		String esperado = "21232f297a57a5a743894a0e4a801fc3";
		assertEquals(esperado, calculado);
	}

	@Test
	public void testLoginCorrecto() {
		assertTrue(superm.loginCorrecto("admin", "21232f297a57a5a743894a0e4a801fc3"));
	}

	@Test
	public void testLoginAdmin() {
		assertTrue(superm.loginAdmin("admin", "21232f297a57a5a743894a0e4a801fc3"));
	}

	@Test
	public void testBuscarUsuario() {
		assertTrue(superm.buscarUsuario("admin"));
	}

	@Test
	public void testProductoExiste() {
		assertTrue(superm.productoExiste("20001"));
	}

	@Test
	public void testProductoExistePorNom() {
		assertTrue(superm.productoExistePorNom("Docena de Huevos"));
	}

	@Test
	public void testStockDisponible() {
		int calculado = superm.stockDisponible("20001");
		int esperado = 3;
		assertEquals(esperado, calculado, 0.01);
	}

	@Test
	public void testGetCodProd() {
		int calculado = superm.getCodProd("Docena de Huevos");
		int esperado = 20001;
		assertEquals(esperado, calculado);
	}

	@Test
	public void testGetCodUsu() {
		int calculado = superm.getCodUsu("admin");
		int esperado = 10001;
		assertEquals(esperado, calculado);
	}

	@Test
	public void testGetIVA4() {
		double calculado = superm.getIVA4();
		double esperado = 1.04;
		assertEquals(esperado, calculado, 0.01);
	}

	@Test
	public void testGetIVA10() {
		double calculado = superm.getIVA10();
		double esperado = 1.10;
		assertEquals(esperado, calculado, 0.01);
	}

	@Test
	public void testGetIVA21() {
		double calculado = superm.getIVA21();
		double esperado = 1.21;
		assertEquals(esperado, calculado, 0.01);
	}

	@Test
	public void testIsInt() {
		assertTrue(superm.isInt("5"));
	}

	@Test
	public void testIsFloat() {
		assertTrue(superm.isFloat("5.05"));
	}

	@AfterClass
	public static void tearDownAfterClass() {
		superm = null;
	}
}
