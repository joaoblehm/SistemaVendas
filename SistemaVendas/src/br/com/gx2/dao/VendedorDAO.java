package br.com.gx2.dao;

import java.util.List;

import br.com.gx2.entity.Vendedor;

public interface VendedorDAO {
	
	public void insert(Vendedor vendedor);
	
	public void update(Vendedor vendedor);
	
	public void deleteById(Integer codigoVendedor);
	
	public Vendedor findById(Integer codigoVendedor);
	
	public List<Vendedor> findAll();

}
