package Test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import conectar.InventarioDAO;

public class TestInventarioDAO {
	private static InventarioDAO invDAO;

	@BeforeClass
	public static void setUpBeforeClass() {
		invDAO = new InventarioDAO();
	}

	@Test
	public void testGetCodProdBD() {
		int calculado = invDAO.getCodProdBD("Docena de Huevos");
		int esperado = 20001;
		assertEquals(esperado, calculado);
	}
	
	@Test
	public void testProductoExisteBD() {
		assertTrue(invDAO.productoExisteBD("20001"));
	}

	@Test
	public void testProductoExistePorNomBD() {
		assertTrue(invDAO.productoExistePorNomBD("Docena de Huevos"));
	}

	@Test
	public void testStockDisponibleBD() {
		int calculado = invDAO.stockDisponibleBD("20001");
		int esperado = 3;
		assertEquals(calculado, esperado);
	}

	@AfterClass
	public static void tearDownAfterClass() {
		invDAO = null;
	}
}
