package br.mp.mpam.geraacp.model.entidades;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class PaginaPrincipalMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -591;
	private String mensagem ="OK!";
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	

}
