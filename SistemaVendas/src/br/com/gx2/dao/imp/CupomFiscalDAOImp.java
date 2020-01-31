package br.com.gx2.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.gx2.dao.CupomFiscalDAO;
import br.com.gx2.entity.Cliente;
import br.com.gx2.entity.CupomFiscal;
import br.com.gx2.entity.Loja;
import br.com.gx2.entity.Vendedor;
import br.com.gx2.exception.DbException;

public class CupomFiscalDAOImp implements CupomFiscalDAO {

	private Connection conn;

	public CupomFiscalDAOImp(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(CupomFiscal cupomFiscal) {
		PreparedStatement st = null;
		try {
			String sql = "insert into cupom_fiscal (valor_total, emissao, codigo_loja, codigo_cliente, codigo_vendedor) " + "values " + "(?,?,?,?,?)";
			st = conn.prepareStatement(sql);
			
			st.setDouble(1, cupomFiscal.getValorTotal());
			st.setDate(2, null);
			st.setInt(3, cupomFiscal.getLoja().getCodigoLoja());
			st.setInt(4, cupomFiscal.getCliente().getCodigoCliente());
			st.setInt(5, cupomFiscal.getVendedor().getCodigoVendedor());
			st.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

	}

	@Override
	public void update(CupomFiscal cupomFiscal) {
		PreparedStatement st = null;
		try {
			String sql = " update cupons_fiscais set  \r\n" + 
					"  valor_total = ?,\r\n" + 
					"  emissao = ?,\r\n" + 
					"  codigo_loja = ?,\r\n" + 
					"  codigo_cliente = ?,\r\n" + 
					"  codigo_vendedor = ?\r\n" + 
					"\r\n" + 
					"  where codigo_cupom = ?";
			st = conn.prepareStatement(sql);
		     Calendar calendar = Calendar.getInstance();
		     java.sql.Date emissao = new java.sql.Date(calendar.getTime().getTime());

			st.setDouble(1, cupomFiscal.getValorTotal());
			st.setDate(2, emissao);
			st.setInt(3, cupomFiscal.getLoja().getCodigoLoja());
			st.setInt(4, cupomFiscal.getCliente().getCodigoCliente());
			st.setInt(5, cupomFiscal.getVendedor().getCodigoVendedor());
			st.setInt(6, cupomFiscal.getCodigoCupom());
			st.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

	}

	@Override
	public void deleteById(Integer codigoCupomFiscal) {
		PreparedStatement st = null;
		try {
			String sql = "delete from cupons_fiscais where codigo_cupom = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, codigoCupomFiscal);
			st.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

	}

	@Override
	public CupomFiscal findById(Integer codigoCupomFiscal) {
		PreparedStatement st = null;
		ResultSet rs = null;
		CupomFiscal cupomFiscal = null;
		try {

			
			String sql = "select cp.codigo_cupom, \r\n" + 
					"	   cp.valor_total, \r\n" + 
					"	   cp.emissao, \r\n" + 
					"       cp.codigo_loja,\r\n" + 
					"       l.nome_loja,\r\n" + 
					"       cp.codigo_cliente,\r\n" + 
					"       c.nome_cliente,\r\n" + 
					"       c.cpf,\r\n" + 
					"       cp.codigo_vendedor,\r\n" + 
					"       v.matricula,\r\n" + 
					"       v.nome_vendedor\r\n" + 
					"\r\n" + 
					"from   cupons_fiscais cp,\r\n" + 
					"	   clientes c,\r\n" + 
					"       vendedores v,\r\n" + 
					"       lojas l\r\n" + 
					"\r\n" + 
					"where  cp.codigo_loja = l.codigo_loja\r\n" + 
					"and    cp.codigo_cliente = c.codigo_cliente\r\n" + 
					"and    cp.codigo_vendedor = v.codigo_vendedor\r\n" +
					"and    cp.codigo_cupom = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, codigoCupomFiscal);
			rs = st.executeQuery();
			if (rs.next()) {
				cupomFiscal = new CupomFiscal();
				cupomFiscal.setCodigoCupom(rs.getInt("codigo_cupom"));
				cupomFiscal.setValorTotal(rs.getDouble("valor_total"));
				cupomFiscal.setEmissao(rs.getDate("emissao"));
				cupomFiscal.setLoja(new Loja(rs.getInt("codigo_loja"), rs.getString("nome_loja"))); 
				cupomFiscal.setCliente(new Cliente(rs.getInt("codigo_cliente"),rs.getString("nome_cliente"), rs.getString("cpf")));
				cupomFiscal.setVendedor(new Vendedor(rs.getInt("codigo_vendedor"), rs.getString("nome_vendedor"), rs.getString("matricula")));
			

			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

		return cupomFiscal;

	}

	@Override
	public List<CupomFiscal> findAll() {

		PreparedStatement st = null;
		ResultSet rs = null;
		CupomFiscal cupomFiscal = null;
		List<CupomFiscal> cuponsFiscais = new ArrayList<CupomFiscal>();

		try {

			String sql = "select cp.codigo_cupom, \r\n" + 
					"	   cp.valor_total, \r\n" + 
					"	   cp.emissao, \r\n" + 
					"       cp.codigo_loja,\r\n" + 
					"       l.nome_loja,\r\n" + 
					"       cp.codigo_cliente,\r\n" + 
					"       c.nome_cliente,\r\n" + 
					"       c.cpf,\r\n" + 
					"       cp.codigo_vendedor,\r\n" + 
					"       v.matricula,\r\n" + 
					"       v.nome_vendedor\r\n" + 
					"\r\n" + 
					"from   cupons_fiscais cp,\r\n" + 
					"	   clientes c,\r\n" + 
					"       vendedores v,\r\n" + 
					"       lojas l\r\n" + 
					"\r\n" + 
					"where  cp.codigo_loja = l.codigo_loja\r\n" + 
					"and    cp.codigo_cliente = c.codigo_cliente\r\n" + 
					"and    cp.codigo_vendedor = v.codigo_vendedor";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();

			while (rs.next()) {
				cupomFiscal = new CupomFiscal();
				cupomFiscal.setCodigoCupom(rs.getInt("codigo_cupom"));
				cupomFiscal.setValorTotal(rs.getDouble("valor_total"));
				cupomFiscal.setEmissao(rs.getDate("emissao"));
				cupomFiscal.setLoja(new Loja(rs.getInt("codigo_loja"), rs.getString("nome_loja"))); 
				cupomFiscal.setCliente(new Cliente(rs.getInt("codigo_cliente"),rs.getString("nome_cliente"), rs.getString("cpf")));
				cupomFiscal.setVendedor(new Vendedor(rs.getInt("codigo_vendedor"), rs.getString("nome_vendedor"), rs.getString("matricula")));
				cuponsFiscais.add(cupomFiscal);
				
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		return cuponsFiscais;
	}

}
