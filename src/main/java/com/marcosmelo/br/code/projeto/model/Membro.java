package com.marcosmelo.br.code.projeto.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="membros", schema="projeto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(MembroId.class)
public class Membro {
	
	@Id
	@ManyToOne
	@JoinColumn(name="idprojeto", referencedColumnName="id")
	private Projeto projeto;
	
	@Id
	@ManyToOne
	@JoinColumn(name="idpessoa", referencedColumnName="id")
	private Pessoa pessoa;

}
