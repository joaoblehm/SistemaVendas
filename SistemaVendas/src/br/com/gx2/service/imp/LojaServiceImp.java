package br.com.gx2.service.imp;

import java.util.ArrayList;
import java.util.List;

import br.com.gx2.dao.DAOFactory;
import br.com.gx2.dao.LojaDAO;
import br.com.gx2.entity.Loja;
import br.com.gx2.service.LojaService;

public class LojaServiceImp implements LojaService{

	public boolean cadastrarLoja(Loja obj) {
		boolean retorno = false;
		if (obj != null) {
			LojaDAO dao = DAOFactory.createLojaDAO();
			dao.insert(obj);
			
			retorno = true;
		}

		return retorno;
	}

	public boolean alterarLoja(Loja obj) {
		boolean retorno = false;
		if (obj != null) {

			LojaDAO dao = DAOFactory.createLojaDAO();
			dao.update(obj);
		
			retorno = true;
		
		}

		return retorno;
	}

	public boolean apagarLoja(Integer obj) {
		boolean retorno = false;
		if (obj != null) {

			LojaDAO dao = DAOFactory.createLojaDAO();
			dao.deleteById(obj);
			
			retorno = true;
		}

		return retorno;
	}

	public Loja pesquisarLojaId(Integer obj) {
		Loja Loja = null;
		if (obj != null) {
			Loja = new Loja();
			LojaDAO dao = DAOFactory.createLojaDAO();
			Loja = dao.findById(obj);
		}

		return Loja;
	}

	public List<Loja> exibirTodosLojas() {

		List<Loja> Lojas = new ArrayList<Loja>();
		
		LojaDAO dao = DAOFactory.createLojaDAO();
		Lojas = dao.findAll();

		return Lojas;
	}

	

}
