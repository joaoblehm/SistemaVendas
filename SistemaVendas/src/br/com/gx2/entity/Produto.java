package br.com.gx2.entity;

import java.io.Serializable;

public class Produto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer codigoProduto;
	private String ncm;
	private String desricaoProduto;
	private Grupo grupo;
	
	public Produto() {
		
	}

	public Produto(Integer codigoProduto, String ncm, String desricaoProduto, Grupo grupo) {
		super();
		this.codigoProduto = codigoProduto;
		this.ncm = ncm;
		this.desricaoProduto = desricaoProduto;
		this.grupo = grupo;
	}

	public Integer getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(Integer codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public String getNcm() {
		return ncm;
	}

	public void setNcm(String ncm) {
		this.ncm = ncm;
	}

	public String getDescricaoProduto() {
		return desricaoProduto;
	}

	public void setDescricaoProduto(String desricaoProduto) {
		this.desricaoProduto = desricaoProduto;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoProduto == null) ? 0 : codigoProduto.hashCode());
		result = prime * result + ((desricaoProduto == null) ? 0 : desricaoProduto.hashCode());
		result = prime * result + ((grupo == null) ? 0 : grupo.hashCode());
		result = prime * result + ((ncm == null) ? 0 : ncm.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (codigoProduto == null) {
			if (other.codigoProduto != null)
				return false;
		} else if (!codigoProduto.equals(other.codigoProduto))
			return false;
		if (desricaoProduto == null) {
			if (other.desricaoProduto != null)
				return false;
		} else if (!desricaoProduto.equals(other.desricaoProduto))
			return false;
		if (grupo == null) {
			if (other.grupo != null)
				return false;
		} else if (!grupo.equals(other.grupo))
			return false;
		if (ncm == null) {
			if (other.ncm != null)
				return false;
		} else if (!ncm.equals(other.ncm))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Produto [codigoProduto=" + codigoProduto + ", ncm=" + ncm + ", desricao=" + desricaoProduto + ", grupo="
				+ grupo + "]";
	}
	
	

}
