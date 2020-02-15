package com.rodrigo7prado.sisGestEduc.enums;

public enum StatusDocAluno {
	SEM_DADOS(1),
	INCOMPLETO(2),
	INCONSISTENTE(3),
	OK(4);
	
	private int code;
	private StatusDocAluno(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static StatusDocAluno valueOf(int code) {
		for(StatusDocAluno  value : StatusDocAluno.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid StatusDocumentacaoAluno code");
	}
}