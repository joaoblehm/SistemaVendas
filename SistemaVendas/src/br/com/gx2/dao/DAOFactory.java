package br.com.gx2.dao;

import br.com.gx2.dao.imp.ClienteDAOImp;
import br.com.gx2.dao.imp.CupomFiscalDAOImp;
import br.com.gx2.dao.imp.GrupoDAOImp;
import br.com.gx2.dao.imp.ItensCupomFiscalDAOImp;
import br.com.gx2.dao.imp.LojaDAOImp;
import br.com.gx2.dao.imp.ProdutoDAOImp;
import br.com.gx2.dao.imp.VendedorDAOImp;
import br.com.gx2.util.ConnectionFactory;

public class DAOFactory {

	public static LojaDAO createLojaDAO() {

		return new LojaDAOImp(ConnectionFactory.getConnection());
	}

	public static GrupoDAO createGrupoDAO() {

		return new GrupoDAOImp(ConnectionFactory.getConnection());
	}

	public static ClienteDAO createClienteDAO() {

		return new ClienteDAOImp(ConnectionFactory.getConnection());
	}

	public static VendedorDAO createVendedorDAO() {

		return new VendedorDAOImp(ConnectionFactory.getConnection());
	}

	public static ProdutoDAO createProdutoDAO() {

		return new ProdutoDAOImp(ConnectionFactory.getConnection());
	}

	public static CupomFiscalDAO createCupomFiscalDAO() {

		return new CupomFiscalDAOImp(ConnectionFactory.getConnection());
	}

	public static ItensCupomFiscalDAO createItemCupomFiscalDAO() {

		return new ItensCupomFiscalDAOImp(ConnectionFactory.getConnection());
	}

}
