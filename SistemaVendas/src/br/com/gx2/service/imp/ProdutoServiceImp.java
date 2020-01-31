package br.com.gx2.service.imp;

import java.util.ArrayList;
import java.util.List;

import br.com.gx2.dao.DAOFactory;
import br.com.gx2.dao.ProdutoDAO;
import br.com.gx2.entity.Produto;
import br.com.gx2.service.ProdutoService;

public class ProdutoServiceImp implements ProdutoService{

	public boolean cadastrarProduto(Produto obj) {
		boolean retorno = false;
		if (obj != null) {
			ProdutoDAO dao = DAOFactory.createProdutoDAO();
			dao.insert(obj);
			
			retorno = true;
			
		}

		return retorno;
	}

	public boolean alterarProduto(Produto obj) {
		boolean retorno = false;
		if (obj != null) {

			ProdutoDAO dao = DAOFactory.createProdutoDAO();
			dao.update(obj);
			
			retorno = true;
		}
		

		return retorno;
	}

	public boolean apagarProduto(Integer obj) {
		boolean retorno = false;
		if (obj != null) {

			ProdutoDAO dao = DAOFactory.createProdutoDAO();
			dao.deleteById(obj);
			
			retorno = true;
			
		}

		return retorno;
	}

	public Produto pesquisarProdutoId(Integer obj) {
		Produto Produto = null;
		if (obj != null) {
			Produto = new Produto();
			ProdutoDAO dao = DAOFactory.createProdutoDAO();
			Produto = dao.findById(obj);
		}

		return Produto;
	}

	public List<Produto> exibirTodosProdutos() {

		List<Produto> Produtos = new ArrayList<Produto>();
		
		ProdutoDAO dao = DAOFactory.createProdutoDAO();
		Produtos = dao.findAll();

		return Produtos;
	}

}
