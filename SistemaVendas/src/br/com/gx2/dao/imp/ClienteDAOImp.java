package br.com.gx2.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gx2.dao.ClienteDAO;
import br.com.gx2.entity.Cliente;
import br.com.gx2.exception.DbException;

public class ClienteDAOImp implements ClienteDAO {

	private Connection conn;

	public ClienteDAOImp(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Cliente cliente) {
		PreparedStatement st = null;
		try {
			String sql = "insert into clientes (nome_cliente, cpf) values (?, ?)";
			st = conn.prepareStatement(sql);
			st.setString(1, cliente.getNomeCliente());
			st.setString(2, cliente.getCpf());
			st.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

	}

	@Override
	public void update(Cliente cliente) {
		PreparedStatement st = null;
		try {
			String sql = "update clientes set nome_cliente = ?, cpf = ? where codigo_Cliente = ?";
			st = conn.prepareStatement(sql);
		   
			st.setString(1, cliente.getNomeCliente());
			st.setString(2, cliente.getCpf());
			st.setInt(3, cliente.getCodigoCliente());
			st.executeUpdate();
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

	}

	@Override
	public void deleteById(Integer codigoCliente) {
		PreparedStatement st = null;
		try {
			String sql = "delete from clientes where codigo_cliente = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, codigoCliente);
			st.executeUpdate();

			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}


	}

	@Override
	public Cliente findById(Integer codigoCliente) {
		PreparedStatement st = null;
		ResultSet rs = null;
		Cliente cliente = null;
		try {

			String sql = "select codigo_cliente, nome_cliente, cpf from clientes where codigo_cliente = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, codigoCliente);
			rs = st.executeQuery();
			if (rs.next()) {
				cliente = new Cliente();
				cliente.setCodigoCliente(rs.getInt("codigo_Cliente"));
				cliente.setNomeCliente(rs.getString("nome_Cliente"));
				cliente.setCpf(rs.getString("cpf"));
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

		return cliente;

	}

	@Override
	public List<Cliente> findAll() {

		PreparedStatement st = null;
		ResultSet rs = null;
		Cliente cliente = null;
		List<Cliente> clientes = new ArrayList<Cliente>();

		try {

			String sql = "select codigo_cliente, nome_cliente, cpf from clientes";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();

			while (rs.next()) {
				cliente = new Cliente();
				cliente.setCodigoCliente(rs.getInt("codigo_Cliente"));
				cliente.setNomeCliente(rs.getString("nome_Cliente"));
				cliente.setCpf(rs.getString("cpf"));
				clientes.add(cliente);

			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		return clientes;
	}

}
