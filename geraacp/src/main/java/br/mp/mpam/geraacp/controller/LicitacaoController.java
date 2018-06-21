package br.mp.mpam.geraacp.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.mp.mpam.geraacp.model.entidades.Licitacao;
import br.mp.mpam.geraacp.model.repositorio.LicitacaoDAO;

@ManagedBean
@SessionScoped
public class LicitacaoController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -591;
	
	private List<Licitacao> listLicitacao;
	
	public List<Licitacao> getListLicitacao() {
		if (this.listLicitacao == null) {
			this.listLicitacao = dao.findAll();
		}
		
		return listLicitacao;
	}
	
	public void setListLicitacao(List<Licitacao> listLicitacao) {
		this.listLicitacao = listLicitacao;
	}
	
	public LicitacaoDAO dao = new LicitacaoDAO();
	
	public String adicionar(){
		return "/pages/competencia/new.jsf";
	}    
	
	public List<Licitacao> ListAllLicitacoes() {
    	return dao.findAll(); 
	}	
    public String redireciona() {
        //apply the login logic.
        return "inicio";
    }    
}
