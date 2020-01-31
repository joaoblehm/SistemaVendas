package br.com.gx2.dao;

import java.util.List;

import br.com.gx2.entity.Loja;

public interface LojaDAO {
	
	public void insert(Loja loja);
	
	public void update(Loja loja);
	
	public void deleteById(Integer codigoLoja);
	
	public Loja findById(Integer codigoLoja);
	
	public List<Loja> findAll();

}
