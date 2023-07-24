package com.marcosmelo.br.code.projeto.model.enuns;

public enum Status {
	
	EM_ANALISE("EMA", "Em análise"),
	
	ANALISE_REALIZADA("ARL", "Análise Realizada"),
	
	ANALISE_APROVADA("AAP", "Análise Aprovada"),
	
	INICIADO("INI", "Iniciado"),
	
	PLANEJADO("PLA", "Planejado"),
	
	EM_ANDAMENTO("ADT", "Em Andamento"),
	
	ENCERRADO("ENC", "Encerrado"),
	
	CANCELADO("CAN", "Cancelado");
	
	private final String value;
	
	private final String description;
	
	private Status(String value, String description) {
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
