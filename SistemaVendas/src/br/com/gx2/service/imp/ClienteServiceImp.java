package br.com.gx2.service.imp;

import java.util.ArrayList;
import java.util.List;

import br.com.gx2.dao.ClienteDAO;
import br.com.gx2.dao.DAOFactory;
import br.com.gx2.entity.Cliente;
import br.com.gx2.service.ClienteService;

public class ClienteServiceImp implements ClienteService{

	public boolean cadastrarCliente(Cliente obj) {
		boolean retorno = false;
		if (obj != null) {
			ClienteDAO dao = DAOFactory.createClienteDAO();
			dao.insert(obj);
			retorno = true;
		}

		return retorno;
	}

	public boolean alterarCliente(Cliente obj) {
		boolean retorno = false;
		if (obj != null) {

			ClienteDAO dao = DAOFactory.createClienteDAO();
			dao.update(obj);
			
			retorno = true;
		}

		return retorno;
	}

	public boolean apagarCliente(Integer obj) {
		boolean retorno = false;
		if (obj != null) {

			ClienteDAO dao = DAOFactory.createClienteDAO();
			dao.deleteById(obj);
			
			retorno = true;
			
		}

		return retorno;
	}

	public Cliente pesquisarClienteId(Integer obj) {
		Cliente Cliente = null;
		if (obj != null) {
			Cliente = new Cliente();
			ClienteDAO dao = DAOFactory.createClienteDAO();
			Cliente = dao.findById(obj);
		}

		return Cliente;
	}

	public List<Cliente> exibirTodosClientes() {

		List<Cliente> Clientes = new ArrayList<Cliente>();
		
		ClienteDAO dao = DAOFactory.createClienteDAO();
		Clientes = dao.findAll();

		return Clientes;
	}

}
