package controller;

import java.time.LocalDate;
import java.util.List;

import dao.ChamadoDao;
import model.Chamado;

public class ChamadoController {
	
	private double percentualGasolinaLitro = 0.82;
	private double densidadeGasolina = 0.75;
	private double fatorTransformacao = 3.7;
	
	public void criarChamado(Chamado chamado)  throws Exception {
		LocalDate dataCriacao = LocalDate.now();
		chamado.setDataCriacao(dataCriacao);
		chamado.setStatus("Ativo");

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

	public void atenderChamado(Chamado chamado) throws Exception {
		if (chamado.getColaborador() == null) {
			throw new Exception("Colaborador Inválido");
		}
		if (chamado.getVeiculo() == null) {
			throw new Exception("Veículo Inválido");
		}
		chamado.setStatus("Em Atendimento");
		ChamadoDao.getInstance().atualizar(chamado);
	}

	public void encerrarChamado(Chamado chamado) throws Exception {
		LocalDate dataEncerramento = LocalDate.now();
		if (chamado == null) {
			throw new Exception("Chamado Inválido");
		}
		if(chamado.getDistanciaPercorrida() <= 0) {
			throw new Exception("Distância Percorrida Inválida");
		}
		if(chamado.getEmissaoCo() <= 0) {
			throw new Exception("Emissão não preenchida");
		}
		chamado.setStatus("Encerrado");
		chamado.setDataEncerramento(dataEncerramento);
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

	public void calculaEmissao(Chamado chamado) throws Exception {
		if(chamado == null) {
			throw new Exception("Chamado Inválido");
		}
		double consumoLitros = chamado.getVeiculo().getConsumoKm() * chamado.getDistanciaPercorrida();
		double emissaoCo = consumoLitros * percentualGasolinaLitro * densidadeGasolina * fatorTransformacao;
		chamado.setEmissaoCo(emissaoCo);
		ChamadoDao.getInstance().atualizar(chamado);
	}
}
