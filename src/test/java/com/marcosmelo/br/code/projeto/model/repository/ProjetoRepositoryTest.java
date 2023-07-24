package com.marcosmelo.br.code.projeto.model.repository;

import java.util.Date;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.marcosmelo.br.code.projeto.model.entity.Pessoa;
import com.marcosmelo.br.code.projeto.model.entity.Projeto;
import com.marcosmelo.br.code.projeto.model.enuns.ClassificacaoRisco;
import com.marcosmelo.br.code.projeto.model.enuns.Status;
import com.marcosmelo.br.code.projeto.repository.PessoaRepository;
import com.marcosmelo.br.code.projeto.repository.ProjetoRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class ProjetoRepositoryTest {

	@Autowired
	ProjetoRepository projetoRepository;
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	@Test
	public void cadastrarProjeto() {
		
		Pessoa gerente = pessoaRepository.save(new Pessoa(1L, "Nome", new Date(), "11122233344", true));
				
		Projeto projeto = projetoRepository.save(new Projeto(1l, "ProjetoTeste", new Date(), new Date(), new Date(), "Projeto inserido para teste",
				Status.EM_ANALISE, 100.0, ClassificacaoRisco.ALTO_RISCO, gerente));
		
		Assertions.assertThat(projeto).isNotNull();
	}
	
}
