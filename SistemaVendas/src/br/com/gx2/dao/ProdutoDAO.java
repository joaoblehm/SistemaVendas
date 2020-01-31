package br.com.gx2.dao;

import java.util.List;

import br.com.gx2.entity.Produto;

public interface ProdutoDAO {
	
	public void insert(Produto produto);
	
	public void update(Produto produto);
	
	public void deleteById(Integer codigoProduto);
	
	public Produto findById(Integer codigoProduto);
	
	public List<Produto> findAll();

}
