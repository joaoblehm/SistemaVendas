package br.com.gx2.testes;

import java.util.List;

import br.com.gx2.dao.ClienteDAO;
import br.com.gx2.dao.DAOFactory;
import br.com.gx2.entity.Cliente;

public class TesteCliente {


	public static void main(String[] args) {
		
		Cliente cliente = new Cliente(null, "João Buracão","171");
		ClienteDAO dao = DAOFactory.createClienteDAO();
		
		//dao.insert(cliente);
		List<Cliente> clientes = dao.findAll();
		for (Cliente c1 : clientes) {
			System.out.print(c1.getCodigoCliente() + " - ");
			System.out.print(c1.getNomeCliente() + " - ");
			System.out.println(c1.getCpf());
		}
		
		Cliente c2 = dao.findById(11);
		System.out.print(c2.getCodigoCliente() + " - ");
		System.out.print(c2.getNomeCliente() + " - ");
		System.out.println(c2.getCpf());
		
		dao.deleteById(c2.getCodigoCliente());
	}

}
