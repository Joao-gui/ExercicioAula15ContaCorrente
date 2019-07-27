package com.db1.contacorrente.infra;

import com.db1.contacorrente.ContaCorrente;

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
	
	public static void valorMaiorQueZeroSaldoDisponivel(Double value, String menssage) {
		ContaCorrente contaCorrente = new ContaCorrente("00465", "00001234", "Maiko Cunha");
		if (value == null || value <= 0 || contaCorrente.getSaldo() < value) {
			throw new RuntimeException(menssage);
		}
	}

}
