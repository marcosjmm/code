package com.marcosmelo.br.code.projeto.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;

import com.marcosmelo.br.code.projeto.model.entity.MembroId;
import com.marcosmelo.br.code.projeto.model.entity.Pessoa;
import com.marcosmelo.br.code.projeto.model.entity.Projeto;
import com.marcosmelo.br.code.projeto.repository.MembroRepository;
import com.marcosmelo.br.code.projeto.repository.PessoaRepository;
import com.marcosmelo.br.code.projeto.repository.ProjetoRepository;

@Named(value = "pessoaMB")
@ViewScoped
public class PessoaMB {
	
	private List<Pessoa> listPessoas = new ArrayList<>();
		
	private List<Pessoa> listPessoasSelecionadas = new ArrayList<>();
	
	private Pessoa pessoaSelecionada = new Pessoa();
		
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private ProjetoRepository projetoRepository;
	
	@Autowired
	private MembroRepository membroRepository;
	
	@PostConstruct
	public List<Pessoa> listarPessoas(){
		listPessoas = pessoaRepository.findAll();
		return listPessoas; 
	}
	
	public void incluirPessoa() {		
		if(pessoaSelecionada.getId() == null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Pessoa adicionada"));			
			
		}else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Pessoa atualizada"));
			
		}		
		
		pessoaRepository.save(pessoaSelecionada);
		listPessoas = pessoaRepository.findAll();
		
        PrimeFaces.current().executeScript("PF('managePessoaDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-pessoas");
		
	}
	
	public String getMensagemBotaoExcluir() {
		if (hasPessoasSelecionadas()) {
            int size = listPessoasSelecionadas.size();
            return size > 1 ? size + " pessoas selecionadas" : "1 pessoa selecionada";
        }
		
		return "Excluir";
	}
	
	public boolean hasPessoasSelecionadas() {
        return listPessoasSelecionadas != null && !listPessoasSelecionadas.isEmpty();
    }
	
	public void excluirPessoasSelecionadas() {
		
		if(listPessoasSelecionadas != null && !listPessoasSelecionadas.isEmpty()) {
			pessoaRepository.deleteAll(listPessoasSelecionadas);
			listPessoasSelecionadas = new ArrayList<>();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Pessoas excluídas"));
		}
		
        listPessoas = pessoaRepository.findAll();
        
        PrimeFaces.current().ajax().update("form:messages", "form:dt-pessoas", "form:delete-pessoas-button");
        PrimeFaces.current().executeScript("PF('dtPessoas').clearFilters()");
    }
	
	public void excluirPessoa() {
		
		List<Projeto> listProjetos = projetoRepository.findByGerente(pessoaSelecionada);
		
		MembroId membroId = new MembroId();
		membroId.setIdpessoa(pessoaSelecionada.getId());
		
		
		if(listProjetos != null && !listProjetos.isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Essa pessoa não pode ser excluída pois é gerente de um projeto"));
				        
		} else {		
			pessoaRepository.delete(pessoaSelecionada);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Pessoa excluída"));
			
		}
		
		PrimeFaces.current().ajax().update("form:messages", "form:dt-pessoas");
        PrimeFaces.current().executeScript("PF('dtPessoas').clearFilters()");
		
		listPessoas = pessoaRepository.findAll();
		pessoaSelecionada = new Pessoa();
		listPessoasSelecionadas = new ArrayList<>();
	}	
	
	public void setListPessoas(List<Pessoa> listPessoas) {
		this.listPessoas = listPessoas;
	}
	
	public List<Pessoa> getListPessoas() {
		return listPessoas;
	}
	
	public Integer getTamanhoDaLista() {
		return listPessoas.size();
	}
	
	public void setTamanhoDaLista(Integer size) {
        // Método criado para ser utilizado pelo primefaces
    }
	
	public List<Pessoa> getListPessoasSelecionadas() {
		return listPessoasSelecionadas;
	}
	
	public void setListPessoasSelecionadas(List<Pessoa> listPessoasSelecionadas) {
		this.listPessoasSelecionadas = listPessoasSelecionadas;
	}
	
	public Pessoa getPessoaSelecionada() {
		return pessoaSelecionada;
	}
	
	public void setPessoaSelecionada(Pessoa pessoaSelecionada) {
		this.pessoaSelecionada = pessoaSelecionada;
	}
	
	public void openNew() {
		this.pessoaSelecionada = new Pessoa();
	}
	
}
