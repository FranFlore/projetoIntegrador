package model;

import java.time.LocalDate;

public class Chamado {
	
	private int idChamado;
	private String descricao;
	private LocalDate dataCriacao;
	private String nomeSolicitante;
	private String enderecoAtendimento;
	private double distanciaPercorrida;
	private int idVeiculo;
	private int idColaborador;
	
	
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
	public int getIdVeiculo() {
		return idVeiculo;
	}
	public void setIdVeiculo(int idVeiculo) {
		this.idVeiculo = idVeiculo;
	}
	public int getIdColaborador() {
		return idColaborador;
	}
	public void setIdColaborador(int idColaborador) {
		this.idColaborador = idColaborador;
	}
	public int abreChamado(Chamado chamado) {
		//sera incluido chamado no banco de dados e retornara o id do chamado
		return 0;
	}
	public boolean encerraChamado(Chamado chamado) {
		//sera excluido/encerrado o chamado no banco de dados e 
		//retornara verdadeiro se o chamado foi encerrado com sucesso
		return true;
	}
	public void atualizaStatusChamado(Chamado chamado) {
		//fara atualizacao do status do chamado e nao retornara nada
		
	}
	public void atenderChamado(Chamado chamado, Colaborador colaborador) {
		//vai receber o chamado e o colaborador e fara o vinculo entre ambos
		
	}
	public void selecionarVeiculo(Chamado chamado, Veiculo veiculo) {
		//vai receber o chamado e o veiculo e fara o vinculo entre ambos
		
	}
	public double calculaEmissao(Chamado chamado, Veiculo veiculo) {
		//vai receber o chamado e o veiculo e fara e fara o calculo da emissao do co2
		return 0;
	}
	
}
