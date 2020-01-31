package br.com.gx2.service;

import java.util.List;

import br.com.gx2.entity.Vendedor;

public interface VendedorService {

	public boolean cadastrarVendedor(Vendedor obj);
	public boolean alterarVendedor(Vendedor obj);
	public boolean apagarVendedor(Integer obj);
	public Vendedor pesquisarVendedorId(Integer obj);
	public List<Vendedor> exibirTodosVendedores();
	
	
	
	
}
