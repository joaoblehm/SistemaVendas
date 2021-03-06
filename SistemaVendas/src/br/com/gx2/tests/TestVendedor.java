package br.com.gx2.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import br.com.gx2.entity.Cliente;
import br.com.gx2.entity.Vendedor;
import br.com.gx2.service.ServiceFactory;
import br.com.gx2.service.VendedorService;

public class TestVendedor {
	
	private VendedorService vServices = ServiceFactory.createVendedorService();
	
	@Test
	public void CadastrarVendedorTest() {
		
		int codigoVendedor =1;
		String matricula ="44545454545n";
		String nomeVendedor = "GodoJava";
		
		Vendedor vendedor = new Vendedor(codigoVendedor,matricula,nomeVendedor);
		
  		boolean retorno = vServices.cadastrarVendedor(vendedor);
  		assertTrue(retorno);
		
	}
	
	@Test
	
	public void AlterarVendedorTest() {
			
		int codigoVendedor =2;
		String matricula ="445545454545n";
		String nomeVendedor = "GordoJava";
		
		Vendedor vendedor = new Vendedor(codigoVendedor,matricula,nomeVendedor);
		
		boolean retorno = vServices.alterarVendedor(vendedor);
		assertTrue(retorno);
		
	}
	
	
	@Test
	
	public void ApagarVendedorTest() {
		
		boolean retorno = vServices.apagarVendedor(2);
		
		
		assertTrue(retorno);
		assertNull(vServices.pesquisarVendedorId(2));
	}
	
	
	@Test
	
	public void PesquisaVendedorTest() {
		
		Vendedor vendedor = vServices.pesquisarVendedorId(3);
		
		assertThat(vServices.pesquisarVendedorId(3), is(vendedor));
	}
	
	@Test
	
	public void ExibirTodosVendedores() {
		

		List<Vendedor> listaV = vServices.exibirTodosVendedores();
		assertThat(vServices.exibirTodosVendedores(), is(listaV));
	}

}
