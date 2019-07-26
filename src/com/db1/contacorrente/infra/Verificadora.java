package com.db1.contacorrente.infra;

public class Verificadora {
	
	public static void verificaStringValida(String value,String message) {
		if (value == null || value.trim().isEmpty()) {
			throw new RuntimeException(message);
		}
	}
	
	public static void valorMaiorQueZero(Double value, String menssage) {
		if (value == null || value <= 0) {
			throw new RuntimeException(menssage);
		}
	}

}
