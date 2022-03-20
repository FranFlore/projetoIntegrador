package model;

import java.time.LocalDate;

public class Colaborador {
	
	private int idColaborador;
	private String nome;
	private LocalDate dataAdmissao;
	private boolean possuiHabilitacao;
	private String tipoHabilitacao;
	
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
	public boolean isPossuiHabilitacao() {
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
	public int contrataColaborador(Colaborador colaborador) {
		//sera incluido o colaborador no banco de dados e retornara o id do colaborador
		return 0;
	}
	public boolean rescindeColaborador(Colaborador colaborador) {
		//sera excluido o colaborador do banco de dados e retornara verdeiro caso a exclusao
		//seja feito com sucesso
		return true;
	}
	public boolean atualizaCnh(Colaborador colaborador, String cnh) {
		//sera atualizada a cnh do colaborador e retornara true caso 
		//seja feito com sucesso
		return true;
	}
		
}
