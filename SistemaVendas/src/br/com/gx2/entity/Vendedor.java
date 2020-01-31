package br.com.gx2.entity;

import java.io.Serializable;

public class Vendedor implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer codigoVendedor;
	private String matricula;
	private String nomeVendedor;
	
	
	public Vendedor() {
		
	}

	public Vendedor(Integer codigoVendedor, String matricula, String nomeVendedor) {
		super();
		this.codigoVendedor = codigoVendedor;
		this.matricula = matricula;
		this.nomeVendedor = nomeVendedor;
	}


	public Integer getCodigoVendedor() {
		return codigoVendedor;
	}


	public void setCodigoVendedor(Integer codigoVendedor) {
		this.codigoVendedor = codigoVendedor;
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public String getNomeVendedor() {
		return nomeVendedor;
	}


	public void setNomeVendedor(String nomeVendedor) {
		this.nomeVendedor = nomeVendedor;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoVendedor == null) ? 0 : codigoVendedor.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + ((nomeVendedor == null) ? 0 : nomeVendedor.hashCode());
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
		Vendedor other = (Vendedor) obj;
		if (codigoVendedor == null) {
			if (other.codigoVendedor != null)
				return false;
		} else if (!codigoVendedor.equals(other.codigoVendedor))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		if (nomeVendedor == null) {
			if (other.nomeVendedor != null)
				return false;
		} else if (!nomeVendedor.equals(other.nomeVendedor))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Vendedor [codigoVendedor=" + codigoVendedor + ", matricula=" + matricula + ", nomeVendedor="
				+ nomeVendedor + "]";
	}
	
	
}
