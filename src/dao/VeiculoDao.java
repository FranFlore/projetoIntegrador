package dao;

import java.util.ArrayList;
import java.util.List;

import model.Veiculo;

public class VeiculoDao {

	private static VeiculoDao instance; 
	private List<Veiculo> listaVeiculo = new ArrayList<>();

	public static VeiculoDao getInstance() {
		if(instance == null) {
			instance = new VeiculoDao();
		}
		return instance;
	}

	public void salvar(Veiculo veiculo) {
		listaVeiculo.add(veiculo);
	}

	public void atualizar(Veiculo veiculo) {
		listaVeiculo.set(veiculo.getIdVeiculo() - 1, veiculo);
	}

	public void excluir(Veiculo veiculo) {
		listaVeiculo.remove(veiculo.getIdVeiculo() - 1);
	}

	public List<Veiculo> listar() {
		return listaVeiculo;
	
	}
}
