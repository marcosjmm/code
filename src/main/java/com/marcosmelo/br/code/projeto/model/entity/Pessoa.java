package com.marcosmelo.br.code.projeto.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="pessoa", schema="projeto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {

	@Id
	@Column(name = "id")
	@SequenceGenerator(name="pessoa_id_generator", sequenceName="pessoa_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="pessoa_id_generator")
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "datanascimento")
	private Date dataNascimento;

	@Column(name="cpf")
	private String cpf;
	
	@Column(name="funcionario")
	private Boolean funcionario;
}
