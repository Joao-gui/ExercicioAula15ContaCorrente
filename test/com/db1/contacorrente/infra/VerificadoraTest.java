package com.db1.contacorrente.infra;

import org.junit.Assert;
import org.junit.Test;


public class VerificadoraTest {
	
	@Test
	public void deveRetornarExceptionQuandoValorNull() {
		String menssage = null;
		try {
			Verificadora.verificaStringValida(null, "Valor não pode ser nulo");
		}catch (RuntimeException e) {
			menssage = e.getMessage();
		}
		Assert.assertEquals("Valor não pode ser nulo", menssage);
		
	}
	
	@Test
	public void deveRetornarExceptionQuandoValorEmpty() {
		String menssage = null;
		try {
			Verificadora.verificaStringValida(" ", "Valor não pode ser empty");
		}catch (RuntimeException e) {
			menssage = e.getMessage();
		}
		Assert.assertEquals("Valor não pode ser empty", menssage);
	}
	
	@Test
	public void naoDeveExceptionQuandoValorValido() {
		String menssage = null;
		try {
			Verificadora.verificaStringValida("DB1 Start ", "Valor não pode ser empty nem nulo");
		}catch (RuntimeException e) {
			menssage = e.getMessage();
		}
		Assert.assertNull(menssage);
	}

}
