package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Colaborador;
import util.ConnectionUtil;

public class ColaboradorDao {

	private static ColaboradorDao instance;
	private Connection con = ConnectionUtil.getConnection();

	public static ColaboradorDao getInstance() {
		if(instance == null) {
			instance = new ColaboradorDao();
		}
		return instance;
	}

	public void salvar(Colaborador colaborador) {
		try {
			String sql = "insert into colaborador (nome, dataAdmissao, possuiHabilitacao, tipoHabilitacao, status) values (?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setNString(1, colaborador.getNome());
			pstmt.setDate(2, getDataAdmissao(colaborador));
			pstmt.setBoolean(3, colaborador.getPossuiHabilitacao());
			pstmt.setNString(4, colaborador.getTipoHabilitacao());
			pstmt.setNString(5, colaborador.getStatus());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(Colaborador colaborador) {
		try {
			String sql = "update colaborador set nome = ?, dataAdmissao = ?, dataDemissao = ?, status = ?, possuiHabilitacao = ?, tipoHabilitacao = ? where idColaborador = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setNString(1, colaborador.getNome());
			pstmt.setDate(2, getDataAdmissao(colaborador));
			pstmt.setDate(3, getDataDemissao(colaborador));
			pstmt.setNString(4, colaborador.getStatus());
			pstmt.setBoolean(5, colaborador.getPossuiHabilitacao());
			pstmt.setNString(6, colaborador.getTipoHabilitacao());
			pstmt.setDouble(7, colaborador.getIdColaborador());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluir(Colaborador colaborador) {
		try {
			String sql = "delete from colaborador where idColaborador = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, colaborador.getIdColaborador());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Colaborador> listar() {
		List<Colaborador> listaColaborador = new ArrayList<>();
		try {
			String sql = "select * from colaborador";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Colaborador colaborador = new Colaborador();
				colaborador.setIdColaborador(rs.getInt("idColaborador"));
				colaborador.setDataAdmissao(rs.getDate("dataAdmissao").toLocalDate());
				colaborador.setDataDemissao(rs.getDate("dataDemissao") != null ? rs.getDate("dataDemissao").toLocalDate() : null);
				colaborador.setStatus(rs.getString("status"));
				colaborador.setNome(rs.getString("nome"));
				colaborador.setPossuiHabilitacao(rs.getBoolean("possuiHabilitacao"));
				colaborador.setTipoHabilitacao(rs.getString("tipoHabilitacao"));
				listaColaborador.add(colaborador);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaColaborador;
	}

	public Colaborador getColaboradorById(int idColaborador) {
		Colaborador returnColaborador = new Colaborador();
		try {
			String sql = "select * from colaborador where idColaborador = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idColaborador);
			ResultSet result = pstmt.executeQuery();
			while(result.next()) {
				returnColaborador.setIdColaborador(result.getInt("idColaborador"));
				returnColaborador.setDataAdmissao(result.getDate("dataAdmissao").toLocalDate());
				returnColaborador.setDataDemissao(result.getDate("dataDemissao") != null ? result.getDate("dataDemissao").toLocalDate() : null);
				returnColaborador.setStatus(result.getString("status"));
				returnColaborador.setNome(result.getString("nome"));
				returnColaborador.setPossuiHabilitacao(result.getBoolean("possuiHabilitacao"));
				returnColaborador.setTipoHabilitacao(result.getString("tipoHabilitacao"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return returnColaborador;
	}

	public Date getDataAdmissao(Colaborador colaborador) {
		return colaborador.getDataAdmissao() != null ? Date.valueOf(colaborador.getDataAdmissao()) : null;
	}

	public Date getDataDemissao(Colaborador colaborador) {
		return colaborador.getDataDemissao() != null ? Date.valueOf(colaborador.getDataDemissao()) : null;
	}
}