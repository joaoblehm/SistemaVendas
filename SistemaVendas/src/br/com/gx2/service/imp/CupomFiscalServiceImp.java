package br.com.gx2.service.imp;

import java.util.ArrayList;
import java.util.List;

import br.com.gx2.dao.DAOFactory;
import br.com.gx2.dao.CupomFiscalDAO;
import br.com.gx2.entity.CupomFiscal;
import br.com.gx2.service.CupomFiscalService;

public class CupomFiscalServiceImp implements CupomFiscalService{

	public boolean cadastrarCupomFiscal(CupomFiscal obj) {
		boolean retorno = false;
		if (obj != null) {
			CupomFiscalDAO dao = DAOFactory.createCupomFiscalDAO();
			dao.insert(obj);
		}

		return retorno;
	}

	public boolean alterarCupomFiscal(CupomFiscal obj) {
		boolean retorno = false;
		if (obj != null) {

			CupomFiscalDAO dao = DAOFactory.createCupomFiscalDAO();
			dao.update(obj);
		}

		return retorno;
	}

	public boolean apagarCupomFiscal(Integer obj) {
		boolean retorno = false;
		if (obj != null) {

			CupomFiscalDAO dao = DAOFactory.createCupomFiscalDAO();
			dao.deleteById(obj);
			
		}

		return retorno;
	}

	public CupomFiscal pesquisarCupomFiscalId(Integer obj) {
		CupomFiscal CupomFiscal = null;
		if (obj != null) {
			CupomFiscal = new CupomFiscal();
			CupomFiscalDAO dao = DAOFactory.createCupomFiscalDAO();
			CupomFiscal = dao.findById(obj);
		}

		return CupomFiscal;
	}

	public List<CupomFiscal> exibirTodosCuponsFiscais() {

		List<CupomFiscal> cuponsFiscais = new ArrayList<CupomFiscal>();
		
		CupomFiscalDAO dao = DAOFactory.createCupomFiscalDAO();
		cuponsFiscais = dao.findAll();

		return cuponsFiscais;
	}

}
