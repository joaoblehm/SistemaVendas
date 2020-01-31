package br.com.gx2.service;

import br.com.gx2.service.imp.ClienteServiceImp;
import br.com.gx2.service.imp.CupomFiscalServiceImp;
import br.com.gx2.service.imp.GrupoServiceImp;
import br.com.gx2.service.imp.LojaServiceImp;
import br.com.gx2.service.imp.ProdutoServiceImp;
import br.com.gx2.service.imp.VendedorServiceImp;

public class ServiceFactory {

	public static GrupoService createGrupoService() {

		return new GrupoServiceImp();
	}

	public static ProdutoService createProdutoService() {

		return new ProdutoServiceImp();
	}

	public static ClienteService createClienteService() {

		return new ClienteServiceImp();
	}

	public static VendedorService createVendedorService() {

		return new VendedorServiceImp();
	}
	
	public static CupomFiscalService createCupomFiscalService() {

		return new CupomFiscalServiceImp();
	}
	
	public static LojaService createLojaService() {

		return new LojaServiceImp();
	}

}
