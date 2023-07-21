package com.marcosmelo.br.code.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcosmelo.br.code.projeto.model.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

	public Pessoa findByNomeAndFuncionario(String nome, boolean funcionario);
}
