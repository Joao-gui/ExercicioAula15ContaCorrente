package com.db1.contacorrente.infra;


public class Verificadora {
	
	public static void verificaStringValida(String value,String menssage) {
		if (value == null || value.trim().isEmpty()) {
			throw new RuntimeException(menssage);
		}
	}
	
	public static void valorMaiorQueZero(Double value, String menssage) {
		if (value == null || value <= 0) {
			throw new RuntimeException(menssage);
		}
	}
	
	public static void valorMaiorQueZeroSaldoDisponivel(Double value, String menssage, Double saldo) {
		if (value == null || value <= 0 || saldo < value) {
			throw new RuntimeException(menssage);
		}
	}

}
