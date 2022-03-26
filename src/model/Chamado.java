package model;

import java.time.LocalDate;

public class Chamado {

	private int idChamado;
	private String descricao;
	private LocalDate dataCriacao;
	private LocalDate dataEncerramento;
	private String status;
	private String nomeSolicitante;
	private String enderecoAtendimento;
	private double distanciaPercorrida;
	private double emissaoCo;
	private Veiculo veiculo;
	private Colaborador colaborador;

	public Chamado(String descricao, String nomeSolicitante, String enderecoAtendimento) {
		this.descricao = descricao;
		this.nomeSolicitante = nomeSolicitante;
		this.enderecoAtendimento = enderecoAtendimento;
	}

	public int getIdChamado() {
		return idChamado;
	}

	public void setIdChamado(int idChamado) {
		this.idChamado = idChamado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDate getDataEncerramento() {
		return dataEncerramento;
	}

	public void setDataEncerramento(LocalDate dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNomeSolicitante() {
		return nomeSolicitante;
	}

	public void setNomeSolicitante(String nomeSolicitante) {
		this.nomeSolicitante = nomeSolicitante;
	}

	public String getEnderecoAtendimento() {
		return enderecoAtendimento;
	}

	public void setEnderecoAtendimento(String enderecoAtendimento) {
		this.enderecoAtendimento = enderecoAtendimento;
	}

	public double getDistanciaPercorrida() {
		return distanciaPercorrida;
	}

	public void setDistanciaPercorrida(double distanciaPercorrida) {
		this.distanciaPercorrida = distanciaPercorrida;
	}

	public double getEmissaoCo() {
		return emissaoCo;
	}

	public void setEmissaoCo(double emissaoCo) {
		this.emissaoCo = emissaoCo;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}
}
