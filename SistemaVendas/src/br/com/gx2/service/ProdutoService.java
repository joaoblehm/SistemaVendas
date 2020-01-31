package br.com.gx2.service;

import java.util.List;

import br.com.gx2.entity.Produto;

public interface ProdutoService {

	public boolean cadastrarProduto(Produto obj);
	public boolean alterarProduto(Produto obj);
	public boolean apagarProduto(Integer obj);
	public Produto pesquisarProdutoId(Integer obj);
	public List<Produto> exibirTodosProdutos();
	
	
	
	
}
