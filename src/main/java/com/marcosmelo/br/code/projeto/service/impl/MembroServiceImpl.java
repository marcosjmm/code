package com.marcosmelo.br.code.projeto.service.impl;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcosmelo.br.code.projeto.dto.MembroDTO;
import com.marcosmelo.br.code.projeto.exception.ProjetoException;
import com.marcosmelo.br.code.projeto.model.entity.Membro;
import com.marcosmelo.br.code.projeto.model.entity.MembroId;
import com.marcosmelo.br.code.projeto.model.entity.Pessoa;
import com.marcosmelo.br.code.projeto.model.entity.Projeto;
import com.marcosmelo.br.code.projeto.repository.MembroRepository;
import com.marcosmelo.br.code.projeto.repository.PessoaRepository;
import com.marcosmelo.br.code.projeto.repository.ProjetoRepository;
import com.marcosmelo.br.code.projeto.service.MembroService;

@Service
public class MembroServiceImpl implements MembroService{
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired 
	private MembroRepository membroRepository;
	
	@Autowired
	private ProjetoRepository projetoRepository;

	@Override
	public Pessoa buscarPessoaNomeCargo(String nome, boolean funcionario) {
		
		return pessoaRepository.findByNomeAndFuncionario(nome, funcionario);
	}

	@Override
	public void salvarMembro(MembroDTO dto) {
		Pessoa pessoa = this.buscarPessoaNomeCargo(dto.getNome(), dto.getAtribuicao());
		
		Optional<Projeto> projeto = this.buscarProjetoPorId(dto.getId_projeto());
		
		if(Objects.nonNull(pessoa)) {
			
			if(Boolean.TRUE.equals(pessoa.getFuncionario())) {
				
				if(Objects.nonNull(projeto) && projeto.isPresent()) {				
					MembroId membroId = new MembroId();
					membroId.setIdpessoa(pessoa.getId());
					membroId.setIdprojeto(projeto.get().getId());				
					
					Membro membro = new Membro();
					membro.setId(membroId);
					
					membroRepository.save(membro);
					
					
				}else {
					throw new ProjetoException("Não foi encontrado nenhum projeto "
							+ "com as informações passadas para ser vinculado junto ao membro.");
				}
				
			}else {
				throw new ProjetoException("Essa pessoa não tem atribuição de funcionário.");
			}
			
		}else {
			throw new ProjetoException("Não foi encontrada nenhuma pessoa com as informações passadas "
					+ "para ser cadastrada como membro.");
		}		
		
	}

	@Override
	public Optional<Projeto> buscarProjetoPorId(Long id) {
		return projetoRepository.findById(id);
	}
	
	

}
