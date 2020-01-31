package br.com.gx2.testes;

import java.util.List;

import br.com.gx2.dao.DAOFactory;
import br.com.gx2.dao.LojaDAO;
import br.com.gx2.entity.Loja;

public class TesteLoja {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//Injeção de dependência
		LojaDAO dao = DAOFactory.createLojaDAO();
		
	    
		Loja loja = new Loja(18, "Google Play");
		dao.deleteById(11);
		
		
		List<Loja> lojas = dao.findAll();
		
		for (Loja l : lojas) {
			System.out.print(l.getCodigoLoja());
			System.out.print(" - ");
			System.out.println(l.getNomeLoja());
		}
		
		
		
	}

}
