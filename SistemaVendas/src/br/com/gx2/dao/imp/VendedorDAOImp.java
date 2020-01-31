package br.com.gx2.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gx2.dao.VendedorDAO;
import br.com.gx2.entity.Vendedor;
import br.com.gx2.exception.DbException;

public class VendedorDAOImp implements VendedorDAO {

	private Connection conn;

	public VendedorDAOImp(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Vendedor vendedor) {
		PreparedStatement st = null;
		try {
			String sql = "insert into vendedores (nome_vendedor, matricula) " + "values " + "(?,?)";
			st = conn.prepareStatement(sql);
			st.setString(1, vendedor.getNomeVendedor());
			st.setString(2, vendedor.getMatricula());
			st.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

	}

	@Override
	public void update(Vendedor vendedor) {
		PreparedStatement st = null;
		try {
			String sql = "update vendedores set nome_vendedor = ?, matricula = ? where codigo_vendedor = ?";
			st = conn.prepareStatement(sql);
		   
			st.setString(1, vendedor.getNomeVendedor());
			st.setString(2, vendedor.getMatricula());
			st.setInt(3, vendedor.getCodigoVendedor());
			st.executeUpdate();
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

	}

	@Override
	public void deleteById(Integer codigoVendedor) {
		PreparedStatement st = null;
		try {
			String sql = "delete from vendedores where codigo_vendedor = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, codigoVendedor);
			st.executeUpdate();

			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}


	}

	@Override
	public Vendedor findById(Integer codigoVendedor) {
		PreparedStatement st = null;
		ResultSet rs = null;
		Vendedor vendedor = null;
		try {

			String sql = "select codigo_vendedor, nome_vendedor, matricula from vendedores where codigo_vendedor = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, codigoVendedor);
			rs = st.executeQuery();
			if (rs.next()) {
				vendedor = new Vendedor();
				vendedor.setCodigoVendedor(rs.getInt("codigo_vendedor"));
				vendedor.setNomeVendedor(rs.getString("nome_Vendedor"));
				vendedor.setMatricula(rs.getString("matricula"));

			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

		return vendedor;

	}

	@Override
	public List<Vendedor> findAll() {

		PreparedStatement st = null;
		ResultSet rs = null;
		Vendedor vendedor = null;
		List<Vendedor> vendedors = new ArrayList<Vendedor>();

		try {

			String sql = "select codigo_vendedor, nome_vendedor, matricula from vendedores";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();

			while (rs.next()) {
				vendedor = new Vendedor();
				vendedor.setCodigoVendedor(rs.getInt("codigo_vendedor"));
				vendedor.setNomeVendedor(rs.getString("nome_Vendedor"));
				vendedor.setMatricula(rs.getString("matricula"));
				vendedors.add(vendedor);

			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		return vendedors;
	}

}
