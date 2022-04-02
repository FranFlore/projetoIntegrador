package controller;

import java.time.LocalDate;
import java.util.List;
import dao.ColaboradorDao;
import model.Colaborador;

public class ColaboradorController {

	public void contratarColaborador(Colaborador colaborador) throws Exception {
		LocalDate dataAdmissao = LocalDate.now();
		colaborador.setDataAdmissao(dataAdmissao);
		colaborador.setStatus("Ativo");

		if (colaborador.getNome() == null || colaborador.getNome().length() <3) {
			throw new Exception("Nome do Colaborador inv�lido.");
		}
		if(colaborador.getPossuiHabilitacao()) {
			if(colaborador.getTipoHabilitacao() == null || colaborador.getTipoHabilitacao().isEmpty()) {
				throw new Exception("Tipo de Habilita��o inv�lida.");	
			}
		}
		ColaboradorDao.getInstance().salvar(colaborador);
	}

	public void atualizarCnh(Colaborador colaborador) throws Exception {
		if(colaborador.getPossuiHabilitacao()) {
			if (colaborador.getTipoHabilitacao() == null || colaborador.getTipoHabilitacao().isEmpty()) {
				throw new Exception("Tipo de Habilita��o inv�lida.");
			} else {
				ColaboradorDao.getInstance().atualizar(colaborador);
			}
		}
	}

	public void rescindirColaborador(Colaborador colaborador) throws Exception {
		LocalDate dataDemissao = LocalDate.now();
		colaborador.setDataDemissao(dataDemissao);

		if (colaborador == null) {
			throw new Exception("Colaborador Inv�lido");
		}

		colaborador.setStatus("Demitido");
		ColaboradorDao.getInstance().atualizar(colaborador);
	}

	public void excluirColaborador(Colaborador colaborador) throws Exception {
		if(colaborador == null) {
			throw new Exception("Colaborador inv�lido");
		}
		ColaboradorDao.getInstance().excluir(colaborador);
	}

	public List<Colaborador> listar() {
		return ColaboradorDao.getInstance().listar();
	}
}