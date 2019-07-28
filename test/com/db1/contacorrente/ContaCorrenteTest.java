package com.db1.contacorrente;

import org.junit.Assert;
import org.junit.Test;


public class ContaCorrenteTest {
	
	@Test
	public void deveRetornarErrorQuandoInformadoAgenciaInvalida() {
		String menssagem = null;
		
		try {
			ContaCorrente contaCorrente = new ContaCorrente(null, "00001234", "Maiko Cunha");
		}catch (RuntimeException e) {
			menssagem = e.getMessage();
		}
		
		Assert.assertNotNull(menssagem);
		Assert.assertEquals("Deve ser informada uma agência valida.", menssagem);
	}	
	
	@Test
	public void deveRetornarErrorQuandoInformadoNumeroInvalida() {
		String menssagem = null;
		
		try {
			ContaCorrente contaCorrente = new ContaCorrente("00465", null, "Maiko Cunha");
		}catch (RuntimeException e) {
			menssagem = e.getMessage();
		}
		
		Assert.assertNotNull(menssagem);
		Assert.assertEquals("Deve ser informado um numero valido.", menssagem);
	}	
	
	@Test
	public void deveRetornarErrorQuandoInformadoClienteInvalida() {
		String menssagem = null;
		
		try {
			ContaCorrente contaCorrente = new ContaCorrente("00465", "00001234", null);
		}catch (RuntimeException e) {
			menssagem = e.getMessage();
		}
		
		Assert.assertNotNull(menssagem);
		Assert.assertEquals("Deve ser informado um cliente valido.", menssagem);
	}	
	
	@Test
	public void deveCriarContaCorrenteComValoresValidos() {
		ContaCorrente contaCorrente = new ContaCorrente("00465", "00001234", "Maiko Cunha");
		Assert.assertEquals("00465", contaCorrente.getAgencia());
		Assert.assertEquals("00001234", contaCorrente.getNumero());
		Assert.assertEquals("Maiko Cunha", contaCorrente.getCliente());
		Assert.assertEquals(0.0, contaCorrente.getSaldo(), 0.00001);
		Assert.assertEquals(0, contaCorrente.getHistorico().size());
		}
	
	@Test
	public void deveRetornarExcecaoQuandoValorDepositadoInvalido() {
		ContaCorrente contaCorrente = new ContaCorrente("00465", "00001234", "Maiko Cunha");
		String menssage = null;
		try {
			contaCorrente.depositar(-0.01);
		}catch(RuntimeException e) {
			menssage = e.getMessage();
		}
		Assert.assertEquals("Valor depositado deve ser maior que zero.", menssage);
		Assert.assertEquals(0.0, contaCorrente.getSaldo(), 0.0001);
		Assert.assertEquals(0, contaCorrente.getHistorico().size());
	}
	
	@Test
	public void deveRetornarExcecaoQuandoValorDepositadoZero() {
		ContaCorrente contaCorrente = new ContaCorrente("00465", "00001234", "Maiko Cunha");
		String menssage = null;
		try {
			contaCorrente.depositar(0.0);
		}catch(RuntimeException e) {
			menssage = e.getMessage();
		}
		Assert.assertEquals("Valor depositado deve ser maior que zero.", menssage);
		Assert.assertEquals(0.0, contaCorrente.getSaldo(), 0.0001);
		Assert.assertEquals(0, contaCorrente.getHistorico().size());
	}
	
	@Test
	public void deveRetornarExcecaoQuandoValorDepositadoNulo() {
		ContaCorrente contaCorrente = new ContaCorrente("00465", "00001234", "Maiko Cunha");
		String menssage = null;
		try {
			contaCorrente.depositar(null);
		}catch(RuntimeException e) {
			menssage = e.getMessage();
		}
		Assert.assertEquals("Valor depositado deve ser maior que zero.", menssage);
		Assert.assertEquals(0.0, contaCorrente.getSaldo(), 0.0001);
		Assert.assertEquals(0, contaCorrente.getHistorico().size());
	}
	
	@Test
	public void deveDepositarValor() {
		ContaCorrente contaCorrente = new ContaCorrente("00465", "00001234", "Maiko Cunha");
		contaCorrente.depositar(100.0);
		
		Assert.assertEquals(100.0, contaCorrente.getSaldo(), 0.0001);
		Assert.assertEquals("Depositado: R$ 100.0", contaCorrente.getHistorico().get(0));
	}
	
	@Test
	public void deveRetornarExceptionQuandoSaqueForInvalido() {
		ContaCorrente contaCorrente = new ContaCorrente("00465", "00001234", "Maiko Cunha");
		String menssage = null;
		try {
			contaCorrente.sacar(-0.1);
		}catch(RuntimeException e) {
			menssage = e.getMessage();
		}
		Assert.assertEquals("Valor de saque tem que ser maior que zero, e possuir saldo disponivel para saque.", menssage);
		Assert.assertEquals(0.0, contaCorrente.getSaldo(), 0.0001);
		Assert.assertEquals(0, contaCorrente.getHistorico().size());		
	}
	
	@Test
	public void deveRetornarExceptionQunadoSaqueForZero() {
		ContaCorrente contaCorrente = new ContaCorrente("00465", "00001234", "Maiko Cunha");
		String menssage = null;
		try {
			contaCorrente.sacar(0.0);
		}catch(RuntimeException e) {
			menssage = e.getMessage();
		}
		Assert.assertEquals("Valor de saque tem que ser maior que zero, e possuir saldo disponivel para saque.", menssage);
		Assert.assertEquals(0.0, contaCorrente.getSaldo(), 0.0001);
		Assert.assertEquals(0, contaCorrente.getHistorico().size());		
	}
	
	@Test
	public void deveRetornarExceptionQuandoSaqueForNulo() {
		ContaCorrente contaCorrente = new ContaCorrente("00465", "00001234", "Maiko Cunha");
		String menssage = null;
		try {
			contaCorrente.sacar(null);
		}catch(RuntimeException e) {
			menssage = e.getMessage();
		}
		Assert.assertEquals("Valor de saque tem que ser maior que zero, e possuir saldo disponivel para saque.", menssage);
		Assert.assertEquals(0.0, contaCorrente.getSaldo(), 0.0001);
		Assert.assertEquals(0, contaCorrente.getHistorico().size());
	}
	@Test
	public void deveRetornarExceptionQuandoSaqueForMaiorQueSaldo() {
		ContaCorrente contaCorrente = new ContaCorrente("00465", "00001234", "Maiko Cunha");
		String menssage = null;
		try {
			contaCorrente.sacar(100.0);
		}catch(RuntimeException e) {
			menssage = e.getMessage();
		}
		Assert.assertEquals("Valor de saque tem que ser maior que zero, e possuir saldo disponivel para saque.", menssage);
		Assert.assertEquals(0, contaCorrente.getSaldo(), 0.0001);
		Assert.assertEquals(0, contaCorrente.getHistorico().size());
	}
	
	@Test
	public void deveSacarValor() {
		ContaCorrente contaCorrente = new ContaCorrente("00465", "00001234", "Maiko Cunha");
		contaCorrente.depositar(200.0);
		contaCorrente.sacar(100.0);
		
		Assert.assertEquals(100.0, contaCorrente.getSaldo(), 0.0001);
		Assert.assertEquals(2, contaCorrente.getHistorico().size());
		Assert.assertEquals("Depositado: R$ 200.0", contaCorrente.getHistorico().get(0));
		Assert.assertEquals("Valor retirado: R$ -100.0", contaCorrente.getHistorico().get(1));
	}
}
