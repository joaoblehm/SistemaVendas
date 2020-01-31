package br.com.gx2.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gx2.dao.GrupoDAO;
import br.com.gx2.entity.Grupo;
import br.com.gx2.exception.DbException;

public class GrupoDAOImp implements GrupoDAO {

	private Connection conn;

	public GrupoDAOImp(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Grupo grupo) {
		PreparedStatement st = null;
		try {
			String sql = "insert into grupos (descricao_grupo) " + "values " + "(?)";
			st = conn.prepareStatement(sql);
			st.setString(1, grupo.getDescricaoGrupo());
			st.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

	}

	@Override
	public void update(Grupo grupo) {
		PreparedStatement st = null;
		try {
			String sql = "update grupos set descricao_grupo = ? where codigo_grupo = ?";
			st = conn.prepareStatement(sql);
			st.setInt(2, grupo.getCodigoGrupo());
			st.setString(1, grupo.getDescricaoGrupo());
			st.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

	}

	@Override
	public void deleteById(Integer codigoGrupo) {
		PreparedStatement st = null;
		try {
			String sql = "delete from grupos where codigo_grupo = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, codigoGrupo);
			st.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

	}

	@Override
	public Grupo findById(Integer codigoGrupo) {
		PreparedStatement st = null;
		ResultSet rs = null;
		Grupo Grupo = null;
		try {

			String sql = "select codigo_grupo, descricao_grupo from grupos where codigo_grupo = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, codigoGrupo);
			rs = st.executeQuery();
			if (rs.next()) {
				Grupo = new Grupo();
				Grupo.setCodigoGrupo(rs.getInt("codigo_grupo"));
				Grupo.setDescricaoGrupo(rs.getString("descricao_grupo"));

			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

		return Grupo;

	}

	@Override
	public List<Grupo> findAll() {

		PreparedStatement st = null;
		ResultSet rs = null;
		Grupo Grupo = null;
		List<Grupo> Grupos = new ArrayList<Grupo>();

		try {

			String sql = "select codigo_grupo, descricao_grupo from grupos";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();

			while (rs.next()) {
				Grupo = new Grupo();
				Grupo.setCodigoGrupo(rs.getInt("codigo_grupo"));
				Grupo.setDescricaoGrupo(rs.getString("descricao_grupo"));
				Grupos.add(Grupo);

			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		return Grupos;
	}

}
