package com.marcosmelo.br.code.projeto.dto;

import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Transactional
public class MembroDTO {
	
	@NonNull
	private String nome;
	
	@NonNull
	private Boolean atribuicao;
	
	@NonNull
	private Long id_projeto;

}
