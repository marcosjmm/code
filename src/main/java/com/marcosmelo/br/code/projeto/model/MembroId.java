package com.marcosmelo.br.code.projeto.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MembroId implements Serializable{

	private static final long serialVersionUID = 302664533211585221L;
	
	@Column(name = "idprojeto")
	private Long projeto;
	
	@Column(name = "idpessoa")
	private Long pessoa;

}
