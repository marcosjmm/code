package com.marcosmelo.br.code.projeto.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;

import com.marcosmelo.br.code.projeto.model.entity.Pessoa;
import com.marcosmelo.br.code.projeto.model.entity.Projeto;
import com.marcosmelo.br.code.projeto.model.enuns.ClassificacaoRisco;
import com.marcosmelo.br.code.projeto.model.enuns.Status;
import com.marcosmelo.br.code.projeto.repository.PessoaRepository;
import com.marcosmelo.br.code.projeto.repository.ProjetoRepository;

@Named(value = "projetoMB")
@ViewScoped
public class ProjetoMB {
	
	private List<Projeto> listProjetos = new ArrayList<>();
	
	private List<Projeto> listProjetosSelecionados = new ArrayList<>();
	
	private Projeto projetoSelecionado = new Projeto();
	
	@Autowired
	private ProjetoRepository projetoRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@PostConstruct
	public List<Projeto> listarProjetos(){
		listProjetos = projetoRepository.findAll();
		return listProjetos;
	}
	
	public void incluirProjeto() {		
		if(projetoSelecionado.getId() == null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Projeto adicionado"));			
			
		}else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Projeto atualizado"));
			
		}		
				
		projetoRepository.save(projetoSelecionado);
		listProjetos = projetoRepository.findAll();
		
        PrimeFaces.current().executeScript("PF('manageProjetoDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-projetos");
		
	}
	
	public String getMensagemBotaoExcluir() {
		if (hasProjetosSelecionadas()) {
            int size = listProjetosSelecionados.size();
            return size > 1 ? size + " projetos selecionados" : "1 projeto selecionado";
        }
		
		return "Excluir";
	}
	
	public boolean hasProjetosSelecionadas() {
        return listProjetosSelecionados != null && !listProjetosSelecionados.isEmpty();
    }
	
	public void excluirProjetosSelecionados() {
		
		if(listProjetosSelecionados != null && !listProjetosSelecionados.isEmpty()) {
			projetoRepository.deleteAll(listProjetosSelecionados);
			listProjetosSelecionados = new ArrayList<>();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Projetos excluídos"));
		}
		
        listProjetos = projetoRepository.findAll();
        
        PrimeFaces.current().ajax().update("form:messages", "form:dt-projetos", "form:delete-projetos-button");
        PrimeFaces.current().executeScript("PF('dtProjetos').clearFilters()");
    }
	
	public void excluirProjeto() {
					
		if(this.permitirExclusao(projetoSelecionado.getStatus().getValue())) {			
			projetoRepository.delete(projetoSelecionado);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Projeto excluído"));
			listProjetos = projetoRepository.findAll();
			projetoSelecionado = new Projeto();
			listProjetosSelecionados = new ArrayList<>();
			
		}else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possível excluir o projeto selecionado"
					+ " pois seu status é " + projetoSelecionado.getStatus().getDescription()));
		}
		
        PrimeFaces.current().ajax().update("form:messages", "form:dt-projetos");
        PrimeFaces.current().executeScript("PF('dtProjetos').clearFilters()");
	}
	
	public void setListProjetos(List<Projeto> listProjetos) {
		this.listProjetos = listProjetos;
	}
	
	public List<Projeto> getListProjetos() {
		return listProjetos;
	}
	
	public Integer getTamanhoDaLista() {
		return listProjetos.size();
	}
	
	public void setTamanhoDaLista(Integer size) {
        // Método criado para ser utilizado pelo primefaces
    }
	
	public List<Projeto> getListProjetosSelecionados() {
		return listProjetosSelecionados;
	}
	
	public void setListProjetosSelecionados(List<Projeto> listProjetosSelecionados) {
		this.listProjetosSelecionados = listProjetosSelecionados;
	}
	
	public Projeto getProjetoSelecionado() {
		return projetoSelecionado;
	}
	
	public void setProjetoSelecionado(Projeto projetoSelecionado) {
		this.projetoSelecionado = projetoSelecionado;
	}
	
	public void openNew() {
		this.projetoSelecionado = new Projeto();
	}
	
	public EnumSet<Status> getStatusProjeto() {
        return EnumSet.allOf(Status.class);
    }

	public EnumSet<ClassificacaoRisco> getClasRisco(){
		return EnumSet.allOf(ClassificacaoRisco.class);
	}
	
	public List<Pessoa> getListPessoasGerente() {
		return pessoaRepository.findAll();
	}
	
	public boolean permitirExclusao(String value) {
		String[] statusNaoExclusao = new String[] {Status.INICIADO.getValue(), Status.EM_ANDAMENTO.getValue(),Status.ENCERRADO.getValue()};
		
		return !Arrays.asList(statusNaoExclusao).contains(value);
	}
}
