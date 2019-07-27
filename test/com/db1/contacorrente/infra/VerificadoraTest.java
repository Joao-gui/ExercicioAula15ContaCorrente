package com.db1.contacorrente.infra;

import org.junit.Assert;
import org.junit.Test;

import com.db1.contacorrente.ContaCorrente;


public class VerificadoraTest {
	
	@Test
	public void deveRetornarExceptionQuandoValorNull() {
		String menssage = null;
		try {
			Verificadora.verificaStringValida(null, "Valor n�o pode ser nulo");
		}catch (RuntimeException e) {
			menssage = e.getMessage();
		}
		Assert.assertEquals("Valor n�o pode ser nulo", menssage);
		
	}
	
	@Test
	public void deveRetornarExceptionQuandoValorEmpty() {
		String menssage = null;
		try {
			Verificadora.verificaStringValida(" ", "Valor n�o pode ser empty");
		}catch (RuntimeException e) {
			menssage = e.getMessage();
		}
		Assert.assertEquals("Valor n�o pode ser empty", menssage);
	}
	
	@Test
	public void naoDeveExceptionQuandoValorValido() {
		String menssage = null;
		try {
			Verificadora.verificaStringValida("DB1 Start ", "Valor n�o pode ser empty nem nulo");
		}catch (RuntimeException e) {
			menssage = e.getMessage();
		}
		Assert.assertNull(menssage);
	}
	
	@Test
	public void deveRetornarExceptionQunadoDepositoNulo() {
		String menssage = null;
		try {
			Verificadora.valorMaiorQueZero(null, "Valor depositado deve ser maior que zero.");
		}catch (RuntimeException e) {
			menssage = e.getMessage();
		}
		Assert.assertEquals("Valor depositado deve ser maior que zero.", menssage);
	}
	
	@Test
	public void deveRetornarExceptionQunadoDepositoMenorQueZero() {
		String menssage = null;
		try {
			Verificadora.valorMaiorQueZero(-0.1, "Valor depositado deve ser maior que zero.");
		}catch (RuntimeException e) {
			menssage = e.getMessage();
		}
		Assert.assertEquals("Valor depositado deve ser maior que zero.", menssage);
	}
	
	@Test
	public void naoDeveRetornarExceptionQuandoValorDepositadoForValido() {
		String menssage = null;
		try {
			Verificadora.valorMaiorQueZero(100.0, "Valor depositado deve ser maior que zero.");
		}catch (RuntimeException e) {
			menssage = e.getMessage();
		}
		Assert.assertNull(menssage);
	}
	
	@Test 
	public void deveRetornarExceptionQuandoValorDoSaqueForMaiorQueSaldo() {
		String menssage = null;		
		try {
			Verificadora.valorMaiorQueZeroSaldoDisponivel(100.0, "Saldo insuficiente.");
		}catch(RuntimeException e) {
			menssage = e.getMessage();
		}
		Assert.assertEquals("Saldo insuficiente.", menssage);
	}
	
	@Test
	public void deveRetornarExceptionQunadoValorDoSaqueForNull() {
		String menssage = null;
		try {
			Verificadora.valorMaiorQueZeroSaldoDisponivel(null, "Valor de saque deve ser maior que zero.");
		}catch (RuntimeException e) {
			menssage = e.getMessage();
		}
		Assert.assertEquals("Valor de saque deve ser maior que zero.", menssage);		
	}
	
	@Test
	public void deveRetornarExceptionQunadoSaqueForMenorQueZero() {
		String menssage = null;
		try {
			Verificadora.valorMaiorQueZeroSaldoDisponivel(-0.1, "Valor de saque deve ser maior que zero.");
		}catch (RuntimeException e) {
			menssage = e.getMessage();
		}
		Assert.assertEquals("Valor de saque deve ser maior que zero.", menssage);
	}
	
	@Test 
	public void naoDeveRetornarExceptionQuandoSaqueForValido() {
		ContaCorrente contaCorrente = new ContaCorrente("00465", "00001234", "Maiko Cunha");
		contaCorrente.depositar(200.0);
		String menssage = null;		
		try {
			Verificadora.valorMaiorQueZeroSaldoDisponivel(100.0, "Saldo insuficiente.");
		}catch(RuntimeException e) {
			menssage = e.getMessage();
		}
		Assert.assertNull(menssage);
	}

}
