package br.com.gx2.dao;

import java.util.List;

import br.com.gx2.entity.CupomFiscal;

public interface CupomFiscalDAO {
	
	public void insert(CupomFiscal cupomFiscal);
	
	public void update(CupomFiscal cupomFiscal);
	
	public void deleteById(Integer codigoCupomFiscal);
	
	public CupomFiscal findById(Integer codigoCupomFiscal);
	
	public List<CupomFiscal> findAll();

}
