package com.db1.contacorrente.infra;

import org.junit.Assert;
import org.junit.Test;

import com.db1.contacorrente.ContaCorrente;


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
			Verificadora.valorMaiorQueZeroSaldoDisponivel(100.0, "Saldo insuficiente.", 0.0 );
		}catch(RuntimeException e) {
			menssage = e.getMessage();
		}
		Assert.assertEquals("Saldo insuficiente.", menssage);
	}
	
	@Test
	public void deveRetornarExceptionQunadoValorDoSaqueForNull() {
		String menssage = null;
		try {
			Verificadora.valorMaiorQueZeroSaldoDisponivel(null, "Valor de saque deve ser maior que zero.", 0.0);
		}catch (RuntimeException e) {
			menssage = e.getMessage();
		}
		Assert.assertEquals("Valor de saque deve ser maior que zero.", menssage);		
	}
	
	@Test
	public void deveRetornarExceptionQunadoSaqueForMenorQueZero() {
		String menssage = null;
		try {
			Verificadora.valorMaiorQueZeroSaldoDisponivel(-1.0, "Valor de saque deve ser maior que zero.", 0.0);
		}catch (RuntimeException e) {
			menssage = e.getMessage();
		}
		Assert.assertEquals("Valor de saque deve ser maior que zero.", menssage);
	}
	
	@Test 
	public void naoDeveRetornarExceptionQuandoSaqueForValido() {
		String menssage = null;		
		try {
			ContaCorrente contaCorrente = new ContaCorrente("0123", "0114", "joao");
			contaCorrente.depositar(200.0);
			Verificadora.valorMaiorQueZeroSaldoDisponivel(100.0, "Saldo insuficiente.", contaCorrente.getSaldo());
		}catch(RuntimeException e) {
			menssage = e.getMessage();
		}
		Assert.assertNull(menssage);
	}

}
