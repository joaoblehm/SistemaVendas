package br.com.gx2.service.imp;

import java.util.ArrayList;
import java.util.List;

import br.com.gx2.dao.DAOFactory;
import br.com.gx2.dao.GrupoDAO;
import br.com.gx2.entity.Grupo;
import br.com.gx2.service.GrupoService;

public class GrupoServiceImp implements GrupoService{

	public boolean cadastrarGrupo(Grupo obj) {
		boolean retorno = false;
		if (obj != null) {
			GrupoDAO dao = DAOFactory.createGrupoDAO();
			dao.insert(obj);
			
			retorno = true;
		}

		return retorno;
	}

	public boolean alterarGrupo(Grupo obj) {
		boolean retorno = false;
		if (obj != null) {

			GrupoDAO dao = DAOFactory.createGrupoDAO();
			dao.update(obj);
			
			retorno = true;
		}

		return retorno;
	}

	public boolean apagarGrupo(Integer obj) {
		boolean retorno = false;
		if (obj != null) {

			GrupoDAO dao = DAOFactory.createGrupoDAO();
			dao.deleteById(obj);
			
			retorno = true;
			
		}

		return retorno;
	}

	public Grupo pesquisarGrupoId(Integer obj) {
		Grupo grupo = null;
		if (obj != null) {
			grupo = new Grupo();
			GrupoDAO dao = DAOFactory.createGrupoDAO();
			grupo = dao.findById(obj);
		}

		return grupo;
	}

	public List<Grupo> exibirTodosGrupos() {

		List<Grupo> grupos = new ArrayList<Grupo>();
		
		GrupoDAO dao = DAOFactory.createGrupoDAO();
		grupos = dao.findAll();

		return grupos;
	}

}
