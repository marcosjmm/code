package com.marcosmelo.br.code.projeto.model.enuns;

public enum ClassificacaoRisco {
	
	BAIXO_RISCO("BXR", "Baixo Risco"),
	
	MEDIO_RISCO("MDR", "Médio Risco"),
	
	ALTO_RISCO("ALR", "Alto Risco");
	
	private final String value;
	
	private final String description;
	
	private ClassificacaoRisco(String value, String description) {
		this.value = value;
		this.description = description;
	}
	
	public String getValue() {
		return value;
	}
	
	public String getDescription() {
		return description;
	}

}
