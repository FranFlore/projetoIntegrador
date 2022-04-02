package model;

import java.time.LocalDate;

public class Colaborador {

	private int idColaborador;
	private String nome;
	private LocalDate dataAdmissao;
	private LocalDate dataDemissao;
	private boolean possuiHabilitacao;
	private String tipoHabilitacao;
	private String status;

	public int getIdColaborador() {
		return idColaborador;
	}

	public void setIdColaborador(int idColaborador) {
		this.idColaborador = idColaborador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(LocalDate dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public LocalDate getDataDemissao() {
		return dataDemissao;
	}

	public void setDataDemissao(LocalDate dataDemissao) {
		this.dataDemissao = dataDemissao;
	}

	public boolean getPossuiHabilitacao() {
		return possuiHabilitacao;
	}

	public void setPossuiHabilitacao(boolean possuiHabilitacao) {
		this.possuiHabilitacao = possuiHabilitacao;
	}

	public String getTipoHabilitacao() {
		return tipoHabilitacao;
	}

	public void setTipoHabilitacao(String tipoHabilitacao) {
		this.tipoHabilitacao = tipoHabilitacao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}