package test.java;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import main.java.UTILS;

public class UTILSTest {
	
	@SuppressWarnings("deprecation")
	@Test
	public void testVerificacion_getTipoMuestra() {
		assertEquals(0L, UTILS.diferenciaDias(new Date(), new Date()));
		assertEquals(5, UTILS.diferenciaDias(new Date(2018, 10, 24), new Date(2018, 10, 29)));
	}
}
