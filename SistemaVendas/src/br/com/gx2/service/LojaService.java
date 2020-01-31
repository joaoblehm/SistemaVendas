package br.com.gx2.service;

import java.util.List;

import br.com.gx2.entity.Loja;

public interface LojaService {

	public boolean cadastrarLoja(Loja obj);
	public boolean alterarLoja(Loja obj);
	public boolean apagarLoja(Integer obj);
	public Loja pesquisarLojaId(Integer obj);
	public List<Loja> exibirTodosLojas();
	
	
	
	
}
