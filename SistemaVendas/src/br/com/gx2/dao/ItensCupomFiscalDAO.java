package br.com.gx2.dao;

import java.util.List;

import br.com.gx2.entity.ItensCupomFiscal;

public interface ItensCupomFiscalDAO {
	
	public void insert(ItensCupomFiscal itensCupomFiscal);
	
	public void update(ItensCupomFiscal itensCupomFiscal);
	
	public void deleteById(Integer codigoItensCupomFiscal);
	
	public List<ItensCupomFiscal> findById(Integer codigoCupomFiscal);
	
	public List<ItensCupomFiscal> findAll();

}
