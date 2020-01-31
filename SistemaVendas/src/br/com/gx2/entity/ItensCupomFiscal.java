package br.com.gx2.entity;

import java.io.Serializable;

public class ItensCupomFiscal implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer codigoItemCupomFiscal;
	private Double quantidade;
	private Double valorUnitario;
	private Produto produto;
	private CupomFiscal cupomFiscal;
	
	public ItensCupomFiscal() {
		
	}

	public ItensCupomFiscal(Integer codigoItemCupomFiscal, Double quantidade, Double valorUnitario, Produto produto,
			CupomFiscal cupomFiscal) {
		super();
		this.codigoItemCupomFiscal = codigoItemCupomFiscal;
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
		this.produto = produto;
		this.cupomFiscal = cupomFiscal;
	}

	public Integer getCodigoItemCupomFiscal() {
		return codigoItemCupomFiscal;
	}

	public void setCodigoItemCupomFiscal(Integer codigoItemCupomFiscal) {
		this.codigoItemCupomFiscal = codigoItemCupomFiscal;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public CupomFiscal getCupomFiscal() {
		return cupomFiscal;
	}

	public void setCupomFiscal(CupomFiscal cupomFiscal) {
		this.cupomFiscal = cupomFiscal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoItemCupomFiscal == null) ? 0 : codigoItemCupomFiscal.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result + ((quantidade == null) ? 0 : quantidade.hashCode());
		result = prime * result + ((valorUnitario == null) ? 0 : valorUnitario.hashCode());
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
		ItensCupomFiscal other = (ItensCupomFiscal) obj;
		if (codigoItemCupomFiscal == null) {
			if (other.codigoItemCupomFiscal != null)
				return false;
		} else if (!codigoItemCupomFiscal.equals(other.codigoItemCupomFiscal))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		if (quantidade == null) {
			if (other.quantidade != null)
				return false;
		} else if (!quantidade.equals(other.quantidade))
			return false;
		if (valorUnitario == null) {
			if (other.valorUnitario != null)
				return false;
		} else if (!valorUnitario.equals(other.valorUnitario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItensCupomFiscal [codigoItemCupomFiscal=" + codigoItemCupomFiscal + ", quantidade=" + quantidade
				+ ", valorUnitario=" + valorUnitario + ", produto=" + produto + ", cupomFiscal=" + cupomFiscal + "]";
	}
	
	
	
	
}
