package br.com.gx2.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gx2.dao.LojaDAO;
import br.com.gx2.entity.Loja;
import br.com.gx2.exception.DbException;

public class LojaDAOImp implements LojaDAO {

	private Connection conn;

	public LojaDAOImp(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Loja loja) {
		PreparedStatement st = null;
		try {
			String sql = "insert into lojas (nome_loja) " + "values " + "(?)";
			st = conn.prepareStatement(sql);
			st.setString(1, loja.getNomeLoja());
			st.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

	}

	@Override
	public void update(Loja loja) {
		PreparedStatement st = null;
		try {
			String sql = "update lojas set nome_loja = ? where codigo_loja = ?";
			st = conn.prepareStatement(sql);
		    st.setInt(2, loja.getCodigoLoja());
			st.setString(1, loja.getNomeLoja());
			st.executeUpdate();
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

	}

	@Override
	public void deleteById(Integer codigoLoja) {
		PreparedStatement st = null;
		try {
			String sql = "delete from lojas where codigo_loja = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, codigoLoja);
			st.executeUpdate();

			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}


	}

	@Override
	public Loja findById(Integer codigoLoja) {
		PreparedStatement st = null;
		ResultSet rs = null;
		Loja loja = null;
		try {

			String sql = "select codigo_loja, nome_loja from lojas where codigo_loja = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, codigoLoja);
			rs = st.executeQuery();
			if (rs.next()) {
				loja = new Loja();
				loja.setCodigoLoja(rs.getInt("codigo_loja"));
				loja.setNomeLoja("nome_loja");

			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

		return loja;

	}

	@Override
	public List<Loja> findAll() {

		PreparedStatement st = null;
		ResultSet rs = null;
		Loja loja = null;
		List<Loja> lojas = new ArrayList<Loja>();

		try {

			String sql = "select codigo_loja, nome_loja from lojas";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();

			while (rs.next()) {
				loja = new Loja();
				loja.setCodigoLoja(rs.getInt("codigo_loja"));
				loja.setNomeLoja(rs.getString("nome_loja"));
				lojas.add(loja);

			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		return lojas;
	}

}
