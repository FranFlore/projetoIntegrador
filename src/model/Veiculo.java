package model;


public class Veiculo {
	
	private int idVeiculo;
	private String placa;
	private String anoModelo;
	private boolean tipoHabilitacao;
	private String localizacaoAtual;
	private double consumoKm;
	
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
	public boolean isTipoHabilitacao() {
		return tipoHabilitacao;
	}
	public void setTipoHabilitacao(boolean tipoHabilitacao) {
		this.tipoHabilitacao = tipoHabilitacao;
	}
	public String getLocalizacaoAtual() {
		return localizacaoAtual;
	}
	public void setLocalizacaoAtual(String localizacaoAtual) {
		this.localizacaoAtual = localizacaoAtual;
	}
	public double getConsumoKm() {
		return consumoKm;
	}
	public void setConsumoKm(double consumoKm) {
		this.consumoKm = consumoKm;
	}

	public int compraVeiculo(Veiculo veiculo) {
		//sera incluido um veiculo no banco de dados e retornara o id do veiculo
		return 0;
	}
	public boolean vendeVeiculo(Veiculo veiculo) {
		//sera excluido o veiculo do banco de dados e retornara verdeiro caso a exclusao
		//seja feito com sucesso
		return true;
	}
	
}
