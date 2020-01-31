package br.com.gx2.entity;

import java.io.Serializable;

public class Grupo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer codigoGrupo;
	private String descricaoGrupo;
	
	public Grupo() {
		
	}

	public Grupo(Integer codigoGrupo, String descricaoGrupo) {
		super();
		this.codigoGrupo = codigoGrupo;
		this.descricaoGrupo = descricaoGrupo;
	}

	public Integer getCodigoGrupo() {
		return codigoGrupo;
	}

	public void setCodigoGrupo(Integer codigoGrupo) {
		this.codigoGrupo = codigoGrupo;
	}

	public String getDescricaoGrupo() {
		return descricaoGrupo;
	}

	public void setDescricaoGrupo(String descricaoGrupo) {
		this.descricaoGrupo = descricaoGrupo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoGrupo == null) ? 0 : codigoGrupo.hashCode());
		result = prime * result + ((descricaoGrupo == null) ? 0 : descricaoGrupo.hashCode());
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
		Grupo other = (Grupo) obj;
		if (codigoGrupo == null) {
			if (other.codigoGrupo != null)
				return false;
		} else if (!codigoGrupo.equals(other.codigoGrupo))
			return false;
		if (descricaoGrupo == null) {
			if (other.descricaoGrupo != null)
				return false;
		} else if (!descricaoGrupo.equals(other.descricaoGrupo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Grupo [codigoGrupo=" + codigoGrupo + ", descricaoGrupo=" + descricaoGrupo + "]";
	}
	
	

}
