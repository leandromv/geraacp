package br.mp.mpam.geraacp.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.mp.mpam.geraacp.model.entidades.Competencia;
import br.mp.mpam.geraacp.model.repositorio.CompetenciaDAO;

@ManagedBean
@SessionScoped
public class CompetenciaController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -591;
	
	CompetenciaDAO dao;
	Competencia competencia;
	private List<Competencia> listCompetencia;
	
	
	
	
	public CompetenciaController() {
		 competencia = new Competencia();
		dao = new CompetenciaDAO();
	}
	public List<Competencia> getListCompetencia() {
		if (this.listCompetencia == null) {
			this.listCompetencia = dao.findAll();
		}
		return listCompetencia;
	}
	public void setListCompetencia(List<Competencia> listCompetencia) {
		this.listCompetencia = listCompetencia;
	}
	public String salvar() throws Exception {
		dao.salvar(competencia);
		return "index";
	}
    public List<Competencia> ListAllCompetencias() {
    	return dao.findAll(); 
	}	
	public Competencia getCompetencia() {
		return competencia;
	}
	public void setCompetencia(Competencia competencia) {
		this.competencia = competencia;
	}    
}
