package com.db1.contacorrente;

import java.util.ArrayList;
import java.util.List;

import com.db1.contacorrente.infra.Verificadora;

// Comportamentos
// depositar
// sacar
// Criar a conta


// saldo

public class ContaCorrente {
	
	private String agencia;
	
	private String numero;
	
	private String cliente;
	
	private Double saldo;
	
	private List<String> historico;
	
	public ContaCorrente(String agencia, String numero, String cliente) {
		Verificadora.verificaStringValida(agencia, "Deve ser informada uma ag�ncia valida.");
		Verificadora.verificaStringValida(numero, "Deve ser informado um numero valido.");
		Verificadora.verificaStringValida(cliente, "Deve ser informado um cliente valido.");					
		this.agencia = agencia;
		this.numero = numero;
		this.cliente = cliente;
		this.saldo = 0.0;
		this.historico = new ArrayList<String>();		
	}
	
	public void depositar(Double valor) {
		Verificadora.valorMaiorQueZero(valor, "Valor depositado deve ser maior que zero.");
		
		this.saldo += valor;
		this.historico.add("Depositado: R$ " + valor);
	}
	
	public String getAgencia() {
		return agencia;
	}
	
	public String getCliente() {
		return cliente;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public Double getSaldo() {
		return saldo;
	}
	
	public List<String> getHistorico() {
		return historico;
	}
			

}
