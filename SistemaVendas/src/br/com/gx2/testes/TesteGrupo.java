package br.com.gx2.testes;

import java.util.ArrayList;
import java.util.List;

import br.com.gx2.dao.DAOFactory;
import br.com.gx2.dao.GrupoDAO;
import br.com.gx2.entity.Grupo;

public class TesteGrupo {

	public static void main(String[] args) {
		
		Grupo grupo = new Grupo(4, "Teste JUnit");
		GrupoDAO dao = DAOFactory.createGrupoDAO();
		dao.deleteById(4);
		
		Grupo g1 = dao.findById(4);
		System.out.println(g1.getDescricaoGrupo());
		

	}

}
