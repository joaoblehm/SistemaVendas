package br.com.gx2.dao;

import java.util.List;

import br.com.gx2.entity.Cliente;

public interface ClienteDAO {
	
	public void insert(Cliente cliente);
	
	public void update(Cliente cliente);
	
	public void deleteById(Integer codigoCliente);
	
	public Cliente findById(Integer codigoCliente);
	
	public List<Cliente> findAll();

}
