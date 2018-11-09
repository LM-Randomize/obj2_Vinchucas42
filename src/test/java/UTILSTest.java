package test.java;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import main.java.UTILS;

public class UTILSTest {
	
	@Test
	public void testVerificacion_getTipoMuestra() {
		assertEquals(0L, UTILS.diferenciaDias(new Date(), new Date()));
	}
}
