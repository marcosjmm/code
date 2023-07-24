package com.marcosmelo.br.code.projeto.model.repository;

import java.util.Date;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.marcosmelo.br.code.projeto.model.entity.Membro;
import com.marcosmelo.br.code.projeto.model.entity.MembroId;
import com.marcosmelo.br.code.projeto.model.entity.Pessoa;
import com.marcosmelo.br.code.projeto.model.entity.Projeto;
import com.marcosmelo.br.code.projeto.model.enuns.ClassificacaoRisco;
import com.marcosmelo.br.code.projeto.model.enuns.Status;
import com.marcosmelo.br.code.projeto.repository.MembroRepository;
import com.marcosmelo.br.code.projeto.repository.PessoaRepository;
import com.marcosmelo.br.code.projeto.repository.ProjetoRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class MembroRepositoryTest {
	
	@Autowired
	MembroRepository membroRepository;
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	@Autowired 
	ProjetoRepository projetoRepository;
	
	@Test
	public void cadastrarMembro() {
		Pessoa gerente = pessoaRepository.save(new Pessoa(1L, "Nome", new Date(), "11122233344", true));
		
		Projeto projeto = projetoRepository.save(new Projeto(1l, "ProjetoTeste", new Date(), new Date(), new Date(), "Projeto inserido para teste",
				Status.EM_ANALISE, 100.0, ClassificacaoRisco.ALTO_RISCO, gerente));
		
		Pessoa pessoa = pessoaRepository.save(new Pessoa(2L, "membro", new Date(), "99988877766", true));
		
		MembroId membroId = new MembroId();
		membroId.setIdpessoa(pessoa.getId());
		membroId.setIdprojeto(projeto.getId());
		
		Membro membro = new Membro();
		membro.setId(membroId);
		
		Membro sucesso = membroRepository.save(membro);
		
		Assertions.assertThat(sucesso).isNotNull();
	}

}
