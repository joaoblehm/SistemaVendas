package br.com.gx2.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gx2.dao.ItensCupomFiscalDAO;
import br.com.gx2.entity.Cliente;
import br.com.gx2.entity.CupomFiscal;
import br.com.gx2.entity.Grupo;
import br.com.gx2.entity.ItensCupomFiscal;
import br.com.gx2.entity.Loja;
import br.com.gx2.entity.Produto;
import br.com.gx2.entity.Vendedor;
import br.com.gx2.exception.DbException;

public class ItensCupomFiscalDAOImp implements ItensCupomFiscalDAO {

	private Connection conn;

	public ItensCupomFiscalDAOImp(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(ItensCupomFiscal itensCupomFiscal) {
		PreparedStatement st = null;
		try {
			String sql = "insert into itens_cupom_fiscal (\r\n" + "  quantidade,\r\n" + "  valor_unitario,\r\n"
					+ "  codigo_produto,\r\n" + "  codigo_cupom) values (?,?,?,?)";
			st = conn.prepareStatement(sql);
			st.setDouble(1, itensCupomFiscal.getQuantidade());
			st.setDouble(2, itensCupomFiscal.getValorUnitario());
			st.setInt(3, itensCupomFiscal.getProduto().getCodigoProduto());
			st.setInt(4, itensCupomFiscal.getCupomFiscal().getCodigoCupom());
			st.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

	}

	@Override
	public void update(ItensCupomFiscal itensCupomFiscal) {
		PreparedStatement st = null;
		try {
			String sql = " update itens_cupom_fiscal set \r\n" + "  quantidade = ?,\r\n" + "  valor_unitario = ?,\r\n"
					+ "  codigo_produto = ?,\r\n" + "  codigo_cupom = ?\r\n" + "  where codigo_item_cupom_fiscal = ?";
			st = conn.prepareStatement(sql);
			st.setDouble(1, itensCupomFiscal.getQuantidade());
			st.setDouble(2, itensCupomFiscal.getValorUnitario());
			st.setInt(3, itensCupomFiscal.getProduto().getCodigoProduto());
			st.setInt(4, itensCupomFiscal.getCupomFiscal().getCodigoCupom());
			st.setInt(5, itensCupomFiscal.getCodigoItemCupomFiscal());
			st.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

	}

	@Override
	public void deleteById(Integer codigoItensCupomFiscal) {
		PreparedStatement st = null;
		try {
			String sql = "delete from itens_cupom_fiscal where codigo_item_cupom_fiscal = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, codigoItensCupomFiscal);
			st.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

	}

	@Override
	public List<ItensCupomFiscal> findById(Integer codigoCupomFiscal) {
		PreparedStatement st = null;
		ResultSet rs = null;
		ItensCupomFiscal itensCupomFiscal = null;
		List<ItensCupomFiscal> cuponsFiscais = new ArrayList<ItensCupomFiscal>();

		try {

			String sql = "select   i.codigo_item_cupom_fiscal,    	    \r\n" + 
					"         i.quantidade,\r\n" + 
					"	 	  i.valor_unitario,         \r\n" + 
					"         i.codigo_produto,         \r\n" + 
					"         p.ncm,\r\n" + 
					"	 	  p.descricao_produto,         \r\n" + 
					"         g.codigo_grupo,         \r\n" + 
					"         g.descricao_grupo,\r\n" + 
					"	      i.codigo_cupom,         \r\n" + 
					"         cp.valor_total, \r\n" + 
					"         cp.emissao, \r\n" + 
					"         cp.codigo_loja,\r\n" + 
					"         l.nome_loja,\r\n" + 
					"         cp.codigo_cliente,\r\n" + 
					"         c.nome_cliente,\r\n" + 
					"         c.cpf,\r\n" + 
					"         cp.codigo_vendedor,\r\n" + 
					"         v.matricula,\r\n" + 
					"         v.nome_vendedor\r\n" + 
					"\r\n" + 
					"from    itens_cupom_fiscal i,  	    \r\n" + 
					"        cupons_fiscais cp,\r\n" + 
					"	produtos p,         \r\n" + 
					"        grupos g,\r\n" + 
					"        clientes c,\r\n" + 
					"        vendedores v,\r\n" + 
					"        lojas l  \r\n" + 
					"\r\n" + 
					"where   i.codigo_cupom = cp.codigo_cupom  \r\n" + 
					"and     i.codigo_produto = p.codigo_produto\r\n" + 
					"and     p.codigo_grupo = g.codigo_grupo\r\n" + 
					"and     cp.codigo_loja = l.codigo_loja\r\n" + 
					"and     cp.codigo_cliente = c.codigo_cliente\r\n" + 
					"and     cp.codigo_vendedor = v.codigo_vendedor " +
					"and     i.codigo_cupom = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, codigoCupomFiscal);
			rs = st.executeQuery();

			while (rs.next()) {

				Grupo grupo = new Grupo(rs.getInt("codigo_grupo"), rs.getString("descricao_grupo"));
				Loja loja = new Loja(rs.getInt("codigo_loja"), rs.getString("nome_loja"));
				Vendedor vendedor =  new Vendedor(rs.getInt("codigo_cliente"), rs.getString("nome_cliente"), rs.getString("cpf"));
				Cliente cliente = new Cliente(rs.getInt("codigo_vendedor"), rs.getString("matricula"), rs.getString("nome_vendedor"));
				Produto produto = new Produto(rs.getInt("codigo_produto"), rs.getString("ncm"), rs.getString("descricao_produto"), grupo);
				CupomFiscal cupomFiscal = new CupomFiscal(rs.getInt("codigo_grupo"), rs.getDouble("valor_total"), rs.getDate("emissao"), loja, cliente, vendedor);
				
				itensCupomFiscal = new ItensCupomFiscal();
				itensCupomFiscal.setCodigoItemCupomFiscal(rs.getInt("codigo_item_cupom_fiscal"));
				itensCupomFiscal.setQuantidade(rs.getDouble("quantidade"));
				itensCupomFiscal.setValorUnitario(rs.getDouble("valor_unitario"));
				itensCupomFiscal.setProduto(produto);
				itensCupomFiscal.setCupomFiscal(cupomFiscal);
				cuponsFiscais.add(itensCupomFiscal);

			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		return cuponsFiscais;

	}

	@Override
	public List<ItensCupomFiscal> findAll() {

		PreparedStatement st = null;
		ResultSet rs = null;
		ItensCupomFiscal itensCupomFiscal = null;
		List<ItensCupomFiscal> cuponsFiscais = new ArrayList<ItensCupomFiscal>();

		try {

			String sql = "select   i.codigo_item_cupom_fiscal,    	    \r\n" + 
					"         i.quantidade,\r\n" + 
					"	 	  i.valor_unitario,         \r\n" + 
					"         i.codigo_produto,         \r\n" + 
					"         p.ncm,\r\n" + 
					"	 	  p.descricao_produto,         \r\n" + 
					"         g.codigo_grupo,         \r\n" + 
					"         g.descricao_grupo,\r\n" + 
					"	      i.codigo_cupom,         \r\n" + 
					"         cp.valor_total, \r\n" + 
					"         cp.emissao, \r\n" + 
					"         cp.codigo_loja,\r\n" + 
					"         l.nome_loja,\r\n" + 
					"         cp.codigo_cliente,\r\n" + 
					"         c.nome_cliente,\r\n" + 
					"         c.cpf,\r\n" + 
					"         cp.codigo_vendedor,\r\n" + 
					"         v.matricula,\r\n" + 
					"         v.nome_vendedor\r\n" + 
					"\r\n" + 
					"from    itens_cupom_fiscal i,  	    \r\n" + 
					"        cupons_fiscais cp,\r\n" + 
					"	produtos p,         \r\n" + 
					"        grupos g,\r\n" + 
					"        clientes c,\r\n" + 
					"        vendedores v,\r\n" + 
					"        lojas l  \r\n" + 
					"\r\n" + 
					"where   i.codigo_cupom = cp.codigo_cupom  \r\n" + 
					"and     i.codigo_produto = p.codigo_produto\r\n" + 
					"and     p.codigo_grupo = g.codigo_grupo\r\n" + 
					"and     cp.codigo_loja = l.codigo_loja\r\n" + 
					"and     cp.codigo_cliente = c.codigo_cliente\r\n" + 
					"and     cp.codigo_vendedor = v.codigo_vendedor";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();

			while (rs.next()) {

				Grupo grupo = new Grupo(rs.getInt("codigo_grupo"), rs.getString("descricao_grupo"));
				Loja loja = new Loja(rs.getInt("codigo_loja"), rs.getString("nome_loja"));
				Vendedor vendedor =  new Vendedor(rs.getInt("codigo_cliente"), rs.getString("nome_cliente"), rs.getString("cpf"));
				Cliente cliente = new Cliente(rs.getInt("codigo_vendedor"), rs.getString("matricula"), rs.getString("nome_vendedor"));
				Produto produto = new Produto(rs.getInt("codigo_produto"), rs.getString("ncm"), rs.getString("descricao_produto"), grupo);
				CupomFiscal cupomFiscal = new CupomFiscal(rs.getInt("codigo_grupo"), rs.getDouble("valor_total"), rs.getDate("emissao"), loja, cliente, vendedor);
				
				itensCupomFiscal = new ItensCupomFiscal();
				itensCupomFiscal.setCodigoItemCupomFiscal(rs.getInt("codigo_item_cupom_fiscal"));
				itensCupomFiscal.setQuantidade(rs.getDouble("quantidade"));
				itensCupomFiscal.setProduto(produto);
				itensCupomFiscal.setCupomFiscal(cupomFiscal);
				cuponsFiscais.add(itensCupomFiscal);

			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		return cuponsFiscais;
	}

}
