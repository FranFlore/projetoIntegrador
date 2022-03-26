package model;

import java.time.LocalDate;

public class Veiculo {

	private int idVeiculo;
	private String placa;
	private String anoModelo;
	private String tipoHabilitacao;
	private double consumoKm;
	private String status;
	private LocalDate dataAquisicao;
	private LocalDate dataVenda;

	public int getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(int idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(String anoModelo) {
		this.anoModelo = anoModelo;
	}

	public String getTipoHabilitacao() {
		return tipoHabilitacao;
	}

	public void setTipoHabilitacao(String tipoHabilitacao) {
		this.tipoHabilitacao = tipoHabilitacao;
	}

	public double getConsumoKm() {
		return consumoKm;
	}

	public void setConsumoKm(double consumoKm) {
		this.consumoKm = consumoKm;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDataStatus() {
		return status;
	}

	public void setDataAquisicao(LocalDate dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}

	public LocalDate getDataAquisicao() {
		return dataAquisicao;
	}

	public void setDataVenda(LocalDate dataVenda) {
		this.dataVenda = dataVenda;
	}

	public LocalDate getDataVenda() {
		return dataVenda;
	}
}