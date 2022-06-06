package Test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import conectar.VentasDAO;

public class TestVentasDAO {
	private static VentasDAO venDAO;

	@BeforeClass
	public static void setUpBeforeClass() {
		venDAO = new VentasDAO();
	}
	
	@Test
	public void testAnadirVentaBD() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscarVentaBD() {
		venDAO.buscarVentaBD(null, null, 0);
	}

	@AfterClass
	public static void tearDownAfterClass() {
	}
}
