package dao;

import java.util.ArrayList;
import java.util.List;

import model.Colaborador;

public class ColaboradorDao {

	private static ColaboradorDao instance;
	private List<Colaborador> listaColaborador = new ArrayList<>();

	public static ColaboradorDao getInstance() {
		if(instance == null) {
			instance = new ColaboradorDao();
		}
		return instance;
	}

	public void salvar(Colaborador colaborador) {
		listaColaborador.add(colaborador);
	}

	public void atualizar(Colaborador colaborador) {
		listaColaborador.set(colaborador.getIdColaborador() -1, colaborador);
	}

	public void excluir(Colaborador colaborador) {
		listaColaborador.remove(colaborador.getIdColaborador() - 1);
	}

	public List<Colaborador> listar() {
		return listaColaborador;
	}
}
