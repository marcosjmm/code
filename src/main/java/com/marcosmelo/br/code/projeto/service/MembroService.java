package com.marcosmelo.br.code.projeto.service;

import java.util.Optional;

import com.marcosmelo.br.code.projeto.dto.MembroDTO;
import com.marcosmelo.br.code.projeto.model.entity.Pessoa;
import com.marcosmelo.br.code.projeto.model.entity.Projeto;

public interface MembroService {
	
	Pessoa buscarPessoaNomeCargo(String nome, boolean funcionario);
	
	Optional<Projeto> buscarProjetoPorId(Long id);
	
	void salvarMembro(MembroDTO dto);

}
