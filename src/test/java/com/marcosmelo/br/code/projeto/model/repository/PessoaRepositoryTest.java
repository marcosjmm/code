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
import com.marcosmelo.br.code.projeto.repository.PessoaRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class PessoaRepositoryTest {
	
	@Autowired
	PessoaRepository repository;
	
	@Test
	public void cadastrarPessoa() {
		Pessoa pessoa = new Pessoa(1L, "Nome", new Date(), "11122233344", true);
		
		Pessoa sucesso = repository.save(pessoa);
		
		Assertions.assertThat(sucesso).isNotNull();
	}

}
