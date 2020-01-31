package br.com.gx2.testes;

import java.util.List;

import br.com.gx2.dao.DAOFactory;
import br.com.gx2.dao.GrupoDAO;
import br.com.gx2.dao.ProdutoDAO;
import br.com.gx2.entity.Grupo;
import br.com.gx2.entity.Produto;

public class TesteProduto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Grupo grupo = new Grupo(1,"acessórios de informática");
		Produto produto = new Produto(17,"a3728912","Teclado com fio", grupo);
		
		ProdutoDAO dao = DAOFactory.createProdutoDAO();
		GrupoDAO grupoDao = DAOFactory.createGrupoDAO();
		//dao.insert(produto);
		Produto p1 = dao.findById(17);
		Grupo g1 = grupoDao.findById(grupo.getCodigoGrupo());
		
		System.out.print(p1.getCodigoProduto()+ " - ");
		System.out.print(p1.getDescricaoProduto()+ " - ");
		System.out.print(p1.getNcm()+ " - ");
		System.out.print(p1.getGrupo().getCodigoGrupo()+ " - ");
		System.out.println(g1.getDescricaoGrupo());
		
		List<Produto> produtos = dao.findAll();
		for (Produto p2 : produtos) {
			System.out.print(p2.getCodigoProduto()+ " - ");
			System.out.print(p2.getDescricaoProduto()+ " - ");
			System.out.print(p2.getNcm()+ " - ");
			System.out.println(p2.getGrupo().getCodigoGrupo());
		}
		
		dao.deleteById(17);// testes chave estrangeira
		
	}

}
