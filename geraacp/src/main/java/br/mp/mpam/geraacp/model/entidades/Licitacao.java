package br.mp.mpam.geraacp.model.entidades;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Table(name = "licitacao", schema = "geraacp")
@Entity
public class Licitacao {

	@Id
	@GeneratedValue
	private Long id;	
	private String numerolicit;
	private String descricao;
	
	@ManyToOne( fetch=FetchType.LAZY)
	@JoinColumn(name="competencia_id")
    private Competencia competencia;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumerolicit() {
		return numerolicit;
	}
	public void setNumerolicit(String numerolicit) {
		this.numerolicit = numerolicit;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
