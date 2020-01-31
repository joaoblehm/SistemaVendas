package br.com.gx2.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import br.com.gx2.entity.Cliente;
import br.com.gx2.entity.Grupo;
import br.com.gx2.entity.Produto;
import br.com.gx2.service.GrupoService;
import br.com.gx2.service.ProdutoService;
import br.com.gx2.service.ServiceFactory;


public class testProduto {
	
	private ProdutoService pService = ServiceFactory.createProdutoService();
	
	private GrupoService gService = ServiceFactory.createGrupoService();
	
@Test
	public void CadastrarProdutoTest() {
		
		Grupo grupo = gService.pesquisarGrupoId(9);
		
		Produto produto = new Produto(null,"15245658","Airfry", grupo);
		
		//boolean retorno = pService.cadastrarProduto(produto);
		
		//assertTrue(pService.cadastrarProduto(produto));
		
		//assertTrue(retorno);
				
	}

@Test

public void AlterarProdutoTest() {
	
	Grupo grupo = gService.pesquisarGrupoId(9);
	
	Produto produto = new Produto(2,"848488","Batedeira", grupo);
	
	boolean retorno = pService.alterarProduto(produto);
	assertTrue(retorno);
	
}

@Test

public void ApagarProdutoTest() {
	
	Grupo grupo = gService.pesquisarGrupoId(9);
	boolean retorno = pService.apagarProduto(4);	
	
	assertNull(pService.pesquisarProdutoId(4));
	assertTrue(retorno);
	
}

@Test

public void PesquisaProdutoTest() {
	Grupo grupo = gService.pesquisarGrupoId(9);
	
	Produto produto = pService.pesquisarProdutoId(3);
	
	assertThat(pService.pesquisarProdutoId(3), is(produto));
	
	
}



@Test

public void ExibirTodosProdutosTest() {
	Grupo grupo = gService.pesquisarGrupoId(9);
	
	List<Produto> listaP = pService.exibirTodosProdutos();
	assertThat(pService.exibirTodosProdutos(), is(listaP));
}




}
