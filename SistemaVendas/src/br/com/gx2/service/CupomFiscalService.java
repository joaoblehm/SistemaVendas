package br.com.gx2.service;

import java.util.List;

import br.com.gx2.entity.CupomFiscal;

public interface CupomFiscalService {

	public boolean cadastrarCupomFiscal(CupomFiscal obj);
	public boolean alterarCupomFiscal(CupomFiscal obj);
	public boolean apagarCupomFiscal(Integer obj);
	public CupomFiscal pesquisarCupomFiscalId(Integer obj);
	public List<CupomFiscal> exibirTodosCuponsFiscais();
	
	
	
	
}
