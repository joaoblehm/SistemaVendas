package br.com.gx2.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CupomFiscal implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer codigoCupom;
	private Double valorTotal;
	private Date emissao;//quando usar no jdbc passar o obsjeto new java.sql.Date()
	private Loja loja;
	private Cliente cliente;
	private Vendedor vendedor;
	private List<ItensCupomFiscal> itensCupomFiscal;
	
	public CupomFiscal() {
		
	}

	public CupomFiscal(Integer codigoCupom, Double valorTotal, Date emissao, Loja loja, Cliente cliente,
			Vendedor vendedor) {
		super();
		this.codigoCupom = codigoCupom;
		this.valorTotal = valorTotal;
		this.emissao = emissao;
		this.loja = loja;
		this.cliente = cliente;
		this.vendedor = vendedor;
		
	}

	public Integer getCodigoCupom() {
		return codigoCupom;
	}

	public void setCodigoCupom(Integer codigoCupom) {
		this.codigoCupom = codigoCupom;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Date getEmissao() {
		return emissao;
	}

	public void setEmissao(Date emissao) {
		this.emissao = emissao;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public List<ItensCupomFiscal> getItensCupomFiscal() {
		return itensCupomFiscal;
	}

	public void setItensCupomFiscal(List<ItensCupomFiscal> itensCupomFiscal) {
		this.itensCupomFiscal = itensCupomFiscal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((codigoCupom == null) ? 0 : codigoCupom.hashCode());
		result = prime * result + ((emissao == null) ? 0 : emissao.hashCode());
		result = prime * result + ((loja == null) ? 0 : loja.hashCode());
		result = prime * result + ((valorTotal == null) ? 0 : valorTotal.hashCode());
		result = prime * result + ((vendedor == null) ? 0 : vendedor.hashCode());
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
		CupomFiscal other = (CupomFiscal) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (codigoCupom == null) {
			if (other.codigoCupom != null)
				return false;
		} else if (!codigoCupom.equals(other.codigoCupom))
			return false;
		if (emissao == null) {
			if (other.emissao != null)
				return false;
		} else if (!emissao.equals(other.emissao))
			return false;
		if (loja == null) {
			if (other.loja != null)
				return false;
		} else if (!loja.equals(other.loja))
			return false;
		if (valorTotal == null) {
			if (other.valorTotal != null)
				return false;
		} else if (!valorTotal.equals(other.valorTotal))
			return false;
		if (vendedor == null) {
			if (other.vendedor != null)
				return false;
		} else if (!vendedor.equals(other.vendedor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CupomFiscal [codigoCupom=" + codigoCupom + ", valorTotal=" + valorTotal + ", emissao=" + emissao
				+ ", loja=" + loja + ", cliente=" + cliente + ", vendedor=" + vendedor + "]";
	}

	
	

}
