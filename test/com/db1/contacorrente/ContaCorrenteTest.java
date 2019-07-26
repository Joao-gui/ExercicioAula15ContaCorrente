package com.db1.contacorrente;

import org.junit.Assert;
import org.junit.Test;


public class ContaCorrenteTest {
	
	@Test
	public void deveRetornarErrorQuandoInformadoAgenciaInvalida() {
		String mensagem = null;
		
		try {
			ContaCorrente contaCorrente = new ContaCorrente(null, "00001234", "Maiko Cunha");
		}catch (RuntimeException e) {
			mensagem = e.getMessage();
		}
		
		Assert.assertNotNull(mensagem);
		Assert.assertEquals("Deve ser informada uma agência valida.", mensagem);
	}	
	
	@Test
	public void deveRetornarErrorQuandoInformadoNumeroInvalida() {
		String mensagem = null;
		
		try {
			ContaCorrente contaCorrente = new ContaCorrente("00465", null, "Maiko Cunha");
		}catch (RuntimeException e) {
			mensagem = e.getMessage();
		}
		
		Assert.assertNotNull(mensagem);
		Assert.assertEquals("Deve ser informado um numero valido.", mensagem);
	}	
	
	@Test
	public void deveRetornarErrorQuandoInformadoClienteInvalida() {
		String mensagem = null;
		
		try {
			ContaCorrente contaCorrente = new ContaCorrente("00465", "00001234", null);
		}catch (RuntimeException e) {
			mensagem = e.getMessage();
		}
		
		Assert.assertNotNull(mensagem);
		Assert.assertEquals("Deve ser informado um cliente valido.", mensagem);
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
		String mensage = null;
		try {
			contaCorrente.depositar(-0.01);
		}catch(RuntimeException e) {
			mensage = e.getMessage();
		}
		Assert.assertEquals("Valor depositado deve ser maior que zero.", mensage);
		Assert.assertEquals(0.0, contaCorrente.getSaldo(), 0.0001);
		Assert.assertEquals(0, contaCorrente.getHistorico().size());
	}
	
	@Test
	public void deveRetornarExcecaoQuandoValorDepositadoZero() {
		ContaCorrente contaCorrente = new ContaCorrente("00465", "00001234", "Maiko Cunha");
		String mensage = null;
		try {
			contaCorrente.depositar(0.0);
		}catch(RuntimeException e) {
			mensage = e.getMessage();
		}
		Assert.assertEquals("Valor depositado deve ser maior que zero.", mensage);
		Assert.assertEquals(0.0, contaCorrente.getSaldo(), 0.0001);
		Assert.assertEquals(0, contaCorrente.getHistorico().size());
	}
	
	@Test
	public void deveRetornarExcecaoQuandoValorDepositadoNulo() {
		ContaCorrente contaCorrente = new ContaCorrente("00465", "00001234", "Maiko Cunha");
		String mensage = null;
		try {
			contaCorrente.depositar(null);
		}catch(RuntimeException e) {
			mensage = e.getMessage();
		}
		Assert.assertEquals("Valor depositado deve ser maior que zero.", mensage);
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
	

}
