package com.marcosmelo.br.code.projeto.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="projeto", schema="projeto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Projeto {
	
	@Id
	@Column(name = "id")
	@SequenceGenerator(name="projeto_id_generator", sequenceName="projeto_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="projeto_id_generator")
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "data_inicio")
	private Date dataInicio;
	
	@Column(name = "data_previsao_fim")
	private Date dataPrevisaoFim;
	
	@Column(name = "data_fim")
	private Date dataFim;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "orcamento")
	private Float orcamento;
	
	@Column(name = "risco")
	private String risco;
	
	@JoinColumn(name = "idgerente", referencedColumnName = "id")
	@ManyToOne()
	private Pessoa gerente;

}
