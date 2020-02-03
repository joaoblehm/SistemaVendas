package br.com.gx2.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import br.com.gx2.entity.Cliente;
import br.com.gx2.service.ClienteService;
import br.com.gx2.service.ServiceFactory;

public class TestCliente {
	
	
	private ClienteService service = ServiceFactory.createClienteService();
	
	@Test
	public void  CadastroClienteTest() {
		
		int codigoCliente = 12;
		String nomeCliente = "Malvadeza";
		String cpf ="1246646464";
		
		Cliente c1 = new Cliente(codigoCliente,nomeCliente,cpf);
  		
		assertTrue(service.cadastrarCliente(c1));
		
  		//boolean retorno = service.cadastrarCliente(cliente);
  		//assertTrue(retorno);
 		
	
  		
	}
	
	@Test
	public void AlterarClienteTest() {
		
		int codigoCliente = 13;
		String nomeCliente = "Malvadeza";
		String cpf ="1246646464";
		
		Cliente c1 = new Cliente(codigoCliente,nomeCliente,cpf);
		
		boolean retorno = service.alterarCliente(c1);
		assertTrue(retorno);
		
		
	}
	
	
	
	@Test
	public void ApagarClienteTest() {
	
		
	boolean retorno = service.apagarCliente(261);
	
	
	assertTrue(retorno);
	assertNull(service.pesquisarClienteId(261));
	
	
	}
		
	
	@Test
	public void PesquisaClienteTest() {
		
		Cliente cliente = service.pesquisarClienteId(243);
		
		assertThat(service.pesquisarClienteId(243), is(cliente));
	}
	
	
	@Test
	public void ExibirTodosClientesTest() {
		
		List<Cliente> listaC = service.exibirTodosClientes();
		assertThat(service.exibirTodosClientes(), is(listaC));
	}
}

