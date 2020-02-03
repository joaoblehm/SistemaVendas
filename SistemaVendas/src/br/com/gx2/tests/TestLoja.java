package br.com.gx2.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import br.com.gx2.entity.Cliente;
import br.com.gx2.entity.Loja;
import br.com.gx2.service.LojaService;
import br.com.gx2.service.ServiceFactory;

public class TestLoja {

	
private LojaService lojaService = ServiceFactory.createLojaService();


@Test
public void CadastroLojaTest() {
	
		int codigoLoja = 1;
		String descricaoLoja = "Americanas";
		Loja loja = new Loja (codigoLoja,descricaoLoja);
		
		assertTrue(lojaService.cadastrarLoja(loja));
	
		//boolean retorno = lojaService.cadastrarLoja(loja);
		//assertTrue(retorno);
	
	
}

@Test

public void AlterarLojaTest() {
	
	int codigoLoja =2;
	String descricaoLoja = "São João";
	
	Loja loja  = new Loja (codigoLoja,descricaoLoja);
	
	boolean retorno = lojaService.alterarLoja(loja);
	assertTrue(retorno);
	
	
}


@Test

public void ApagarLojaTest() {
	
	boolean retorno = lojaService.apagarLoja(2);
	
	
	assertTrue(retorno);
	assertNull(lojaService.pesquisarLojaId(2));
	
	
}
	
@Test
public void PesquisaLojaTest() {
	
	Loja loja = lojaService.pesquisarLojaId(3);
	
	assertThat(lojaService.pesquisarLojaId(3), is(loja));
}


@Test
public void ExibirTodosLojaTest() {
	
	List<Loja> listaL = lojaService.exibirTodosLojas();
	assertThat(lojaService.exibirTodosLojas(), is(listaL));
}	
}
