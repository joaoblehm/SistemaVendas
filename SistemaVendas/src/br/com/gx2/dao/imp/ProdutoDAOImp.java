package br.com.gx2.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gx2.dao.ProdutoDAO;
import br.com.gx2.entity.Grupo;
import br.com.gx2.entity.Produto;
import br.com.gx2.exception.DbException;

public class ProdutoDAOImp implements ProdutoDAO {

	private Connection conn;

	public ProdutoDAOImp(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Produto produto) {
		PreparedStatement st = null;
		try {
			String sql = "insert into Produtos (descricao_Produto, ncm, codigo_grupo) " + "values " + "(?,?,?)";
			st = conn.prepareStatement(sql);
			st.setString(1, produto.getDescricaoProduto());
			st.setString(2, produto.getNcm());
			st.setInt(3, produto.getGrupo().getCodigoGrupo());
			st.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

	}

	@Override
	public void update(Produto produto) {
		PreparedStatement st = null;
		try {
			String sql = "update produtos set descricao_produto = ?, ncm = ?, codigo_grupo = ? where codigo_Produto = ?";
			st = conn.prepareStatement(sql);
			st.setString(1, produto.getDescricaoProduto());
			st.setString(2, produto.getNcm());
			st.setInt(3, produto.getGrupo().getCodigoGrupo());
			st.setInt(4, produto.getCodigoProduto());
			
			st.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

	}

	@Override
	public void deleteById(Integer codigoProduto) {
		PreparedStatement st = null;
		try {
			String sql = "delete from produtos where codigo_Produto = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, codigoProduto);
			st.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

	}

	@Override
	public Produto findById(Integer codigoProduto) {
		PreparedStatement st = null;
		ResultSet rs = null;
		Produto produto = null;
		try {

			String sql = "select codigo_produto, ncm, descricao_produto, codigo_grupo from produtos where codigo_produto = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, codigoProduto);
			rs = st.executeQuery();
			if (rs.next()) {
				produto = new Produto();
				produto.setCodigoProduto(rs.getInt("codigo_Produto"));
				produto.setNcm(rs.getString("ncm"));
				produto.setDescricaoProduto(rs.getString("descricao_Produto"));
				produto.setGrupo(new Grupo(rs.getInt("codigo_grupo"),null));

			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

		return produto;

	}

	@Override
	public List<Produto> findAll() {

		PreparedStatement st = null;
		ResultSet rs = null;
		Produto produto = null;
		List<Produto> produtos = new ArrayList<Produto>();

		try {

			String sql = "select codigo_produto, ncm, descricao_produto, codigo_grupo from produtos";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();

			while (rs.next()) {
				produto = new Produto();
				produto.setCodigoProduto(rs.getInt("codigo_Produto"));
				produto.setNcm(rs.getString("ncm"));
				produto.setDescricaoProduto(rs.getString("descricao_Produto"));
				produto.setGrupo(new Grupo(rs.getInt("codigo_grupo"),null));
				produtos.add(produto);

			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		return produtos;
	}

}
