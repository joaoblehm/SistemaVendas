package br.com.gx2.service;

import java.util.List;

import br.com.gx2.entity.Grupo;

public interface GrupoService {

	public boolean cadastrarGrupo(Grupo obj);
	public boolean alterarGrupo(Grupo obj);
	public boolean apagarGrupo(Integer obj);
	public Grupo pesquisarGrupoId(Integer obj);
	public List<Grupo> exibirTodosGrupos();
	
	
	
	
}
