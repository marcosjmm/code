package com.marcosmelo.br.code.projeto.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
public class MembroId implements Serializable{

	private static final long serialVersionUID = 302664533211585221L;
	
	@Column(name = "idprojeto")
	private Long idprojeto;
	
	@Column(name = "idpessoa")
	private Long idpessoa;

}
