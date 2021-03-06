package com.rodrigo7prado.sisGestEduc.enums;

public enum StatusDocumentacaoAluno2 {
	PENDENTE_DADOS_PESSOAIS(1),
	INCONSISTENCIA_DADOS_PESSOAIS(2),
	PENDENTE_DADOS_FUNDAMENTAL(3),
	INCONSISTENCIA_DADOS_FUNDAMENTAL(4),
	PENDENTE_DADOS_MEDIO(5),
	INCONSISTENCIA_DADOS_MEDIO(6),
	DOCUMENTACAO_OK(7),
	LIBERADO_CERTIDAO(8),
	LIBERADO_HISTORICO_ESCOLAR(9),
	LIBERADO_CERTIFICADO(10);
	
	private int code;
	private StatusDocumentacaoAluno2(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static StatusDocumentacaoAluno2 valueOf(int code) {
		for(StatusDocumentacaoAluno2  value : StatusDocumentacaoAluno2.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid StatusDocumentacaoAluno code");
	}
}