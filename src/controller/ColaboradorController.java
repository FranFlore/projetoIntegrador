package controller;

import java.time.LocalDate;
import java.util.List;
import dao.ColaboradorDao;
import model.Colaborador;

public class ColaboradorController {

	public void cadastrarColaborador(Colaborador colaborador) throws Exception {
		LocalDate dataAdmissao = LocalDate.now();
		colaborador.setDataAdmissao(dataAdmissao);
		colaborador.setStatus("Ativo");

		if (colaborador.getNome() == null || colaborador.getNome().length() <3) {
			throw new Exception("Nome do Colaborador inválido.");
		}
		if(colaborador.getPossuiHabilitacao()) {
			if(colaborador.getTipoHabilitacao() == null || colaborador.getTipoHabilitacao().isEmpty()) {
				throw new Exception("Tipo de Habilitação inválida.");	
			}
		}
		ColaboradorDao.getInstance().salvar(colaborador);
	}

	public void atualizarColaborador(Colaborador colaborador) throws Exception {
		if(colaborador == null) {
			throw new Exception("Colaborador inválido");
		}
		ColaboradorDao.getInstance().atualizar(colaborador);
	}

	public void excluirColaborador(Colaborador colaborador) throws Exception {
		if(colaborador == null) {
			throw new Exception("Colaborador inválido");
		}
		ColaboradorDao.getInstance().excluir(colaborador);
	}

	public List<Colaborador> listar() {
		return ColaboradorDao.getInstance().listar();
	}
	
	public Colaborador getColaborador(int idColaborador) {
		return ColaboradorDao.getInstance().getColaboradorById(idColaborador);
	}
}