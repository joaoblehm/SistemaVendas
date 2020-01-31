package br.com.gx2.testes;

import java.util.List;

import br.com.gx2.dao.DAOFactory;
import br.com.gx2.dao.VendedorDAO;
import br.com.gx2.entity.Vendedor;

public class TesteVendedorDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Vendedor vendedor = new Vendedor(11, "12345678","Ronaldinho XXX");
		VendedorDAO dao = DAOFactory.createVendedorDAO();
		//dao.insert(vendedor);
		List<Vendedor> vendedores = dao.findAll();
		for (Vendedor v1 : vendedores) {
			System.out.print(v1.getNomeVendedor() + " - ");
			System.out.println(v1.getMatricula());
		}
		dao.update(vendedor);
		dao.deleteById(11);

	}

}
