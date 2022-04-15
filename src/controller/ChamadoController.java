package controller;

import java.time.LocalDate;
import java.util.List;
import dao.ChamadoDao;
import dao.ColaboradorDao;
import model.Chamado;
import model.Colaborador;

public class ChamadoController {
	
	private double percentualGasolinaLitro = 0.82;
	private double densidadeGasolina = 0.75;
	private double fatorTransformacao = 3.7;

	public void criarChamado(Chamado chamado)  throws Exception {
		LocalDate dataCriacao = LocalDate.now();
		chamado.setDataCriacao(dataCriacao);
		chamado.setStatus("Aberto");

		if (chamado.getDescricao() == null || chamado.getDescricao().length() < 30) {
			throw new Exception("Descrição Inválida");
		}
		if (chamado.getEnderecoAtendimento() == null || chamado.getEnderecoAtendimento().length() < 5) {
			throw new Exception("Endereço de Atendimento Inválido");
		}
		if (chamado.getNomeSolicitante() == null || chamado.getNomeSolicitante().length() < 5) {
			throw new Exception("Nome do Solicitante Inválido");
		}
		ChamadoDao.getInstance().salvar(chamado);
	}

	public void atualizarChamado(Chamado chamado) throws Exception {
		ChamadoDao.getInstance().atualizar(chamado);
	}

	public void excluirChamado(Chamado chamado) throws Exception {
		if (chamado == null) {
			throw new Exception("Chamado Inválido");
		}
		ChamadoDao.getInstance().excluir(chamado);
	}

	public List<Chamado> listar() {
		return ChamadoDao.getInstance().listar();
	}

	public double calculaEmissao(Chamado chamado) throws Exception {
		if(chamado == null) {
			throw new Exception("Chamado Inválido");
		}
		double consumoLitros = chamado.getVeiculo().getConsumoKm() * chamado.getDistanciaPercorrida();
		double emissaoCo = consumoLitros * percentualGasolinaLitro * densidadeGasolina * fatorTransformacao;
		return emissaoCo;
	}

	public Chamado getChamado(int idChamado) {
		return ChamadoDao.getInstance().getChamadoById(idChamado);
	}
}