package Test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import conectar.UsuarioDAO;

public class TestUsuarioDAO {
	private static UsuarioDAO usuDAO;

	@BeforeClass
	public static void setUpBeforeClass() {
		usuDAO = new UsuarioDAO();
	}

	@Test
	public void testBuscarUsuarioBD() {
		assertTrue(usuDAO.buscarUsuarioBD("admin"));
	}

	@Test
	public void testLoginBD() {
		assertTrue(usuDAO.loginBD("admin", "21232f297a57a5a743894a0e4a801fc3"));
	}

	@Test
	public void testLoginAdminBD() {
		assertTrue(usuDAO.loginAdminBD("admin", "21232f297a57a5a743894a0e4a801fc3"));
	}

	@Test
	public void testGetCodUsuarioBD() {
		int calculado = usuDAO.getCodUsuarioBD("admin");
		int esperado = 10001;
		assertEquals(esperado, calculado);
	}
	
	@AfterClass
	public static void tearDownAfterClass() {
		usuDAO = null;
	}
}
