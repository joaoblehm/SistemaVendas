package br.com.gx2.service.imp;

import java.util.ArrayList;
import java.util.List;

import br.com.gx2.dao.VendedorDAO;
import br.com.gx2.dao.DAOFactory;
import br.com.gx2.entity.Vendedor;
import br.com.gx2.service.VendedorService;

public class VendedorServiceImp implements VendedorService{

	public boolean cadastrarVendedor(Vendedor obj) {
		boolean retorno = false;
		if (obj != null) {
			VendedorDAO dao = DAOFactory.createVendedorDAO();
			dao.insert(obj);
			
			retorno = true;
		}

		return retorno;
	}

	public boolean alterarVendedor(Vendedor obj) {
		boolean retorno = false;
		if (obj != null) {

			VendedorDAO dao = DAOFactory.createVendedorDAO();
			dao.update(obj);

			retorno = true;
		}

		return retorno;
	}

	public boolean apagarVendedor(Integer obj) {
		boolean retorno = false;
		if (obj != null) {

			VendedorDAO dao = DAOFactory.createVendedorDAO();
			dao.deleteById(obj);
			
			retorno = true;
		}

		return retorno;
	}

	public Vendedor pesquisarVendedorId(Integer obj) {
		Vendedor Vendedor = null;
		if (obj != null) {
			Vendedor = new Vendedor();
			VendedorDAO dao = DAOFactory.createVendedorDAO();
			Vendedor = dao.findById(obj);
		}

		return Vendedor;
	}

	public List<Vendedor> exibirTodosVendedores() {

		List<Vendedor> Vendedors = new ArrayList<Vendedor>();
		
		VendedorDAO dao = DAOFactory.createVendedorDAO();
		Vendedors = dao.findAll();

		return Vendedors;
	}

}
