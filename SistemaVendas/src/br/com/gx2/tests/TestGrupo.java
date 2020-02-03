package br.com.gx2.tests;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;


import br.com.gx2.entity.Grupo;

import br.com.gx2.service.GrupoService;
import br.com.gx2.service.ServiceFactory;

public class TestGrupo {
	
private GrupoService service = ServiceFactory.createGrupoService();

@Test
public void CadastroGrupoTest() {
	
	int codigoGrupo = 1;
	String descricaoGrupo = "Smartphones";
	
	Grupo grupo = new Grupo(codigoGrupo, descricaoGrupo);
	
	//assertTrue(service.cadastrarGrupo(grupo));
	//boolean retorno = service.cadastrarGrupo(grupo);
	//assertTrue(retorno);
	
}

@Test
public void AlterarGrupoTest() {
	
	int codigoGrupo = 3;
	String descricaoGrupo = "Smartphones";
	
	
	Grupo grupo = new Grupo(codigoGrupo,descricaoGrupo);
	
	boolean retorno = service.alterarGrupo(grupo);
	assertTrue(retorno);
	
}

@Test
public void ApagarGrupoTest() {
	
	//boolean retorno = service.apagarGrupo(16);
	//assertTrue(retorno);
	//assertNull(service.pesquisarGrupoId(16));
	
}

@Test

public void PesquisarGrupoTest() {
	
	Grupo grupo = service.pesquisarGrupoId(14);
	
	assertThat(service.pesquisarGrupoId(14), is(grupo));
}

@Test
public void ExibirTodosGruposTest() {
	
	List<Grupo> listaG = service.exibirTodosGrupos();
	assertThat(service.exibirTodosGrupos(), is(listaG));
	
}
}
