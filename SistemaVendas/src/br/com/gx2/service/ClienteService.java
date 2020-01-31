package br.com.gx2.service;

import java.util.List;

import br.com.gx2.entity.Cliente;

public interface ClienteService {

	public boolean cadastrarCliente(Cliente obj);
	public boolean alterarCliente(Cliente obj);
	public boolean apagarCliente(Integer obj);
	public Cliente pesquisarClienteId(Integer obj);
	public List<Cliente> exibirTodosClientes();
	
	
	
	
}
