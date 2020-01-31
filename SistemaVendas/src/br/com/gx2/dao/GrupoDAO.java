package br.com.gx2.dao;

import java.util.List;

import br.com.gx2.entity.Grupo;

public interface GrupoDAO {
	
	public void insert(Grupo grupo);
	
	public void update(Grupo grupo);
	
	public void deleteById(Integer codigoGrupo);
	
	public Grupo findById(Integer codigoGrupo);
	
	public List<Grupo> findAll();

}
