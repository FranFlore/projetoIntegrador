package controller;

import java.time.LocalDate;
import java.util.List;
import dao.VeiculoDao;
import model.Veiculo;

public class VeiculoController {

	public void cadastrarVeiculo(Veiculo veiculo) throws Exception {
		LocalDate dataAquisicao = LocalDate.now();
		veiculo.setDataAquisicao(dataAquisicao);
		veiculo.setStatus("Ativo");

		if (veiculo.getPlaca() == null || veiculo.getPlaca().length() <7) {
			throw new Exception("Placa Inv�lida");
		}
		if (veiculo.getAnoModelo() == null || veiculo.getAnoModelo().length() <5) {
			throw new Exception("Ano/Modelo Inv�lido");
		}
		if (veiculo.getTipoHabilitacao() == null || veiculo.getTipoHabilitacao().isEmpty()) {
			throw new Exception("Tipo Habilita��o Inv�lido");
		}
		if(veiculo.getConsumoKm() <= 0) {
			throw new Exception("Consumo/Km inv�lido");
		}
		VeiculoDao.getInstance().salvar(veiculo);
	}

	public void atualizarVeiculo(Veiculo veiculo) throws Exception {
		if(veiculo == null) {
			throw new Exception("Ve�culo inv�lido");
		}
		VeiculoDao.getInstance().atualizar(veiculo);
	}

	public void excluirVeiculo(Veiculo veiculo) throws Exception {
		if (veiculo == null) {
			throw new Exception("Ve�culo Inv�lido");
		}
		VeiculoDao.getInstance().excluir(veiculo);
	}

	public List<Veiculo> listar() {
		return VeiculoDao.getInstance().listar();
	}
	
	public Veiculo getVeiculo(int idVeiculo) {
		return VeiculoDao.getInstance().getVeiculoById(idVeiculo);
	}
}