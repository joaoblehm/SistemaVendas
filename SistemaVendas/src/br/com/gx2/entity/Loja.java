package br.com.gx2.entity;

import java.io.Serializable;

public class Loja implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer codigoLoja;
	private String nomeLoja;
	
	public Loja() {
		
	}

	public Loja(Integer codigoLoja, String nomeLoja) {
		super();
		this.codigoLoja = codigoLoja;
		this.nomeLoja = nomeLoja;
	}

	public Integer getCodigoLoja() {
		return codigoLoja;
	}

	public void setCodigoLoja(Integer codigoLoja) {
		this.codigoLoja = codigoLoja;
	}

	public String getNomeLoja() {
		return nomeLoja;
	}

	public void setNomeLoja(String nomeLoja) {
		this.nomeLoja = nomeLoja;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoLoja == null) ? 0 : codigoLoja.hashCode());
		result = prime * result + ((nomeLoja == null) ? 0 : nomeLoja.hashCode());
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
		Loja other = (Loja) obj;
		if (codigoLoja == null) {
			if (other.codigoLoja != null)
				return false;
		} else if (!codigoLoja.equals(other.codigoLoja))
			return false;
		if (nomeLoja == null) {
			if (other.nomeLoja != null)
				return false;
		} else if (!nomeLoja.equals(other.nomeLoja))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Loja [codigoLoja=" + codigoLoja + ", nomeLoja=" + nomeLoja + "]";
	}
	
	
	
	
	

}
