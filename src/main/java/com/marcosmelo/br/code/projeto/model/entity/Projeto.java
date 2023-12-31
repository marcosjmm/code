package com.marcosmelo.br.code.projeto.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.marcosmelo.br.code.projeto.model.enuns.ClassificacaoRisco;
import com.marcosmelo.br.code.projeto.model.enuns.Status;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	private Status status;
	
	@Column(name = "orcamento")
	private Double orcamento;
	
	@Column(name = "risco")
	private ClassificacaoRisco risco;
	
	@JoinColumn(name = "idgerente", referencedColumnName = "id")
	@ManyToOne()
	private Pessoa gerente = new Pessoa();

}
