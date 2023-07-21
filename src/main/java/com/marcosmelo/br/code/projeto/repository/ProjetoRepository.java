package com.marcosmelo.br.code.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcosmelo.br.code.projeto.model.entity.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long>{

}
