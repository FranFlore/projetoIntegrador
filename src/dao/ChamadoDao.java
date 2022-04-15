package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Chamado;
import model.Colaborador;
import util.ConnectionUtil;

public class ChamadoDao {

	private static ChamadoDao instance;
	private Connection con = ConnectionUtil.getConnection();

	public static ChamadoDao getInstance() {
		if(instance == null) {
			instance = new ChamadoDao();
		}
		return instance;
	}

	public void salvar(Chamado chamado) {
		try {
			String sql = "insert into chamado (descricao, dataCriacao, status, nomeSolicitante, enderecoAtendimento) values (?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setNString(1,  chamado.getDescricao());
			pstmt.setDate(2, getDataCriacao(chamado));
			pstmt.setNString(3,  chamado.getStatus());
			pstmt.setNString(4,  chamado.getNomeSolicitante());
			pstmt.setNString(5,  chamado.getEnderecoAtendimento());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(Chamado chamado) {
		try {
			String sql = "update chamado set descricao = ?, dataCriacao = ?, dataEncerramento = ?, status = ?, nomeSolicitante = ?, enderecoAtendimento = ?, distanciaPercorrida= ?, emissaoCo = ?, idVeiculo = ?, idColaborador = ? where idChamado = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setNString(1, chamado.getDescricao());
			pstmt.setDate(2, getDataCriacao(chamado));
			pstmt.setDate(3, getDataEncerramento(chamado));
			pstmt.setNString(4, chamado.getStatus());
			pstmt.setNString(5, chamado.getNomeSolicitante());
			pstmt.setNString(6, chamado.getEnderecoAtendimento());
			pstmt.setDouble(7, chamado.getDistanciaPercorrida());
			pstmt.setDouble(8, chamado.getEmissaoCo());
			pstmt.setInt(9, chamado.getVeiculo() != null ? chamado.getVeiculo().getIdVeiculo() : null);
			pstmt.setInt(10, chamado.getColaborador() != null ? chamado.getColaborador().getIdColaborador() : null);
			pstmt.setLong(11, chamado.getIdChamado());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluir(Chamado chamado) {
		try {
			String sql = "delete from chamado where idChamado = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, chamado.getIdChamado());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Chamado> listar() {
		List<Chamado> listaChamado = new ArrayList<>();
		try {
			String sql = "select * from chamado";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Chamado chamado = new Chamado();
				chamado.setIdChamado(rs.getInt("idChamado"));
				chamado.setDescricao(rs.getString("descricao"));
				chamado.setEnderecoAtendimento(rs.getString("enderecoAtendimento"));
				chamado.setNomeSolicitante("nomeSolicitante");
				chamado.setDataCriacao(rs.getDate("dataCriacao").toLocalDate());
				chamado.setDataEncerramento(rs.getDate("dataEncerramento") != null ? rs.getDate("dataEncerramento").toLocalDate() : null);
				chamado.setStatus(rs.getString("status"));
				chamado.setDistanciaPercorrida(rs.getDouble("distanciaPercorrida"));
				chamado.setEmissaoCo(rs.getDouble("emissaoCo"));
				chamado.setVeiculo(VeiculoDao.getInstance().getVeiculoById(rs.getInt("idVeiculo")));
				chamado.setColaborador(ColaboradorDao.getInstance().getColaboradorById(rs.getInt("idColaborador")));
				listaChamado.add(chamado);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaChamado;
	}
	
	public Chamado getChamadoById(int idChamado) {
		Chamado returnChamado = new Chamado();
		try {
			String sql = "select * from chamado where idChamado = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idChamado);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				returnChamado.setIdChamado(rs.getInt("idChamado"));
				returnChamado.setDescricao(rs.getString("descricao"));
				returnChamado.setEnderecoAtendimento(rs.getString("enderecoAtendimento"));
				returnChamado.setNomeSolicitante(rs.getString("nomeSolicitante"));
				returnChamado.setDataCriacao(rs.getDate("dataCriacao").toLocalDate());
				returnChamado.setDataEncerramento(rs.getDate("dataEncerramento") != null ? rs.getDate("dataEncerramento").toLocalDate() : null);
				returnChamado.setStatus(rs.getString("status"));
				returnChamado.setDistanciaPercorrida(rs.getDouble("distanciaPercorrida"));
				returnChamado.setEmissaoCo(rs.getDouble("emissaoCo"));
				returnChamado.setVeiculo(VeiculoDao.getInstance().getVeiculoById(rs.getInt("idVeiculo")));
				returnChamado.setColaborador(ColaboradorDao.getInstance().getColaboradorById(rs.getInt("idColaborador")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return returnChamado;
	}

	public Date getDataCriacao(Chamado chamado) {
		return chamado.getDataCriacao() != null ? Date.valueOf(chamado.getDataCriacao()) : null;
	}

	public Date getDataEncerramento(Chamado chamado) {
		return chamado.getDataEncerramento() != null ? Date.valueOf(chamado.getDataEncerramento()) : null;
	}
}