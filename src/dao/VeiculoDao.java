package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Veiculo;
import util.ConnectionUtil;

public class VeiculoDao {

	private static VeiculoDao instance; 
	private Connection con = ConnectionUtil.getConnection();

	public static VeiculoDao getInstance() {
		if(instance == null) {
			instance = new VeiculoDao();
		}
		return instance;
	}

	public void salvar(Veiculo veiculo) {
		try {
			String sql = "insert into veiculo (placa, anoModelo, consumoKm, dataAquisicao, status, tipoHabilitacao) values (?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setNString(1, veiculo.getPlaca());
			pstmt.setNString(2, veiculo.getAnoModelo());
			pstmt.setDouble(3, veiculo.getConsumoKm());
			pstmt.setDate(4, getDataAquisicao(veiculo));
			pstmt.setNString(5, veiculo.getStatus());
			pstmt.setNString(6, veiculo.getTipoHabilitacao());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(Veiculo veiculo) {
		try {
			String sql = "update veiculo set placa = ?, dataAquisicao = ?, dataVenda = ?, status = ?, anoModelo = ?, tipoHabilitacao = ?, consumoKm = ? where idVeiculo = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setNString(1, veiculo.getPlaca());
			pstmt.setDate(2, getDataAquisicao(veiculo));
			pstmt.setDate(3, getDataVenda(veiculo));
			pstmt.setNString(4, veiculo.getStatus());
			pstmt.setNString(5, veiculo.getAnoModelo());
			pstmt.setNString(6, veiculo.getTipoHabilitacao());
			pstmt.setDouble(7, veiculo.getConsumoKm());
			pstmt.setInt(8, veiculo.getIdVeiculo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluir(Veiculo veiculo) {
		try {
			String sql = "delete from veiculo where idVeiculo = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, veiculo.getIdVeiculo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Veiculo> listar() {
		List<Veiculo> listVeiculo = new ArrayList<>();
		try {
			String sql = "select * from veiculo";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Veiculo veiculo = new Veiculo();
				veiculo.setIdVeiculo(rs.getInt("idVeiculo"));
				veiculo.setDataAquisicao(rs.getDate("dataAquisicao").toLocalDate());
				veiculo.setDataVenda(rs.getDate("dataVenda") != null ? rs.getDate("dataVenda").toLocalDate() : null);
				veiculo.setStatus(rs.getString("status"));
				veiculo.setPlaca(rs.getString("placa"));
				veiculo.setAnoModelo(rs.getString("anoModelo"));
				veiculo.setTipoHabilitacao(rs.getString("tipoHabilitacao"));
				veiculo.setConsumoKm(rs.getDouble("consumoKm"));
				listVeiculo.add(veiculo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listVeiculo;
	}

	public Veiculo getVeiculoById(int idVeiculo) {
		Veiculo returnVeiculo = new Veiculo();
		try {
			String sql = "select * from veiculo where idVeiculo = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idVeiculo);
			ResultSet result = pstmt.executeQuery();
			while(result.next()) {
				returnVeiculo.setIdVeiculo(result.getInt("idVeiculo"));
				returnVeiculo.setDataAquisicao(result.getDate("dataAquisicao").toLocalDate());
				returnVeiculo.setDataVenda(result.getDate("dataVenda") != null ? result.getDate("dataVenda").toLocalDate() : null);
				returnVeiculo.setStatus(result.getString("status"));
				returnVeiculo.setPlaca(result.getString("placa"));
				returnVeiculo.setAnoModelo(result.getString("anoModelo"));
				returnVeiculo.setTipoHabilitacao(result.getString("tipoHabilitacao"));
				returnVeiculo.setConsumoKm(result.getDouble("consumoKm"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return returnVeiculo;
	}

	public Date getDataAquisicao(Veiculo veiculo) {
		return veiculo.getDataAquisicao() != null ? Date.valueOf(veiculo.getDataAquisicao()) : null;
	}

	public Date getDataVenda(Veiculo veiculo) {
		return veiculo.getDataVenda() != null ? Date.valueOf(veiculo.getDataVenda()) : null;
	}
}