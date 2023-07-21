package com.marcosmelo.br.code.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcosmelo.br.code.projeto.dto.MembroDTO;
import com.marcosmelo.br.code.projeto.model.entity.Membro;
import com.marcosmelo.br.code.projeto.repository.MembroRepository;
import com.marcosmelo.br.code.projeto.service.MembroService;

@RestController
@RequestMapping("/code/membro")
public class MembroController {
	
	@Autowired
	private MembroRepository membroRepository;
	
	@Autowired
	private MembroService membroService;
	
	@GetMapping("/listar")
	public List<Membro> listarMembro(){
		return membroRepository.findAll();
	}
	
	@PostMapping("/incluir")
	public void incluir(@RequestBody MembroDTO membro) {
		
		this.membroService.salvarMembro(membro);		
	}
	

}
