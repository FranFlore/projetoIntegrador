package application;

import java.util.List;
import java.util.Scanner;

import controller.ChamadoController;
import model.Chamado;

public class Application {
	
	public static void main(String[] args) {
		int opcoesModulo = 0;
		Scanner ler = new Scanner(System.in);
		while (opcoesModulo != 4) {
			System.out.println("Você deseja acessar qual modulo:\n1-Chamados\n2-Colaboradores\n3-Veículos\n4-Sair");
			opcoesModulo = ler.nextInt();
			if(opcoesModulo == 1) {
				int opcoesChamado = 0;
				System.out.println("\n\nEscolha uma opção: \n1-Abrir Chamado\n2-Atender Chamado\n3-Encerrar Chamado\n4-Excluir Chamado\n5-Listar Chamados\n6-Calcular Emissao\n7-Voltar");
				opcoesChamado = ler.nextInt();
				while(opcoesChamado != 7) {
					ChamadoController chamadoController = new ChamadoController();
					List<Chamado> chamados = chamadoController.listar();
					if(opcoesChamado == 1) {
						System.out.println("\nDescreva o chamado");
						String descricao = "";
						descricao = ler.nextLine();
						if(descricao.isEmpty()) {
							descricao = ler.nextLine();
						}
						System.out.println("\nInforme seu nome");
						String nome = "";
						nome = ler.nextLine();
						if(nome.isEmpty()) {
							nome = ler.nextLine();
						}
						System.out.println("\nInforme seu endereço");
						String endereco = "";
						endereco = ler.nextLine();
						if(endereco.isEmpty()) {
							endereco = ler.nextLine();
						}
						Chamado chamado = new Chamado(descricao, nome, endereco);
						chamado.setIdChamado(chamados.size() == 0 ? 1 : chamados.size());
						try {
							chamadoController.criarChamado(chamado);
						} catch (Exception e) {
							System.out.println(e.getMessage());
						} finally {
							System.out.println("Chamado aberto com sucesso\n");
							opcoesChamado = 7;
						}
					} else if(opcoesChamado == 5) {
						for(Chamado chamado : chamados) {
							System.out.println("Id Chamado: " + chamado.getIdChamado() + "\n");
							System.out.println("Descricao: " + chamado.getDescricao() + "\n");
							System.out.println("Nome do Solicitante: " + chamado.getNomeSolicitante() + "\n");
							System.out.println("Endereço do Atendimento: " + chamado.getEnderecoAtendimento() + "\n");
							System.out.println("Distância Percorrida: " + chamado.getDistanciaPercorrida() + "\n");
							System.out.println("Emissão de CO2: " + chamado.getEmissaoCo() + "\n");
							System.out.println("Status: " + chamado.getStatus() + "\n");
							System.out.println("Data Criação: " + chamado.getDataCriacao() + "\n");
							System.out.println("Data Encerramento: " + chamado.getDataEncerramento() + "\n");
							if(chamado.getColaborador() != null) {
								System.out.println("Colaborador: " + chamado.getColaborador().getNome() + "\n");								
							} else {
								System.out.println("Colaborador:\n");
							}
							if(chamado.getVeiculo() != null) {
								System.out.println("Veiculo: " + chamado.getVeiculo().getPlaca() + "\n");								
							} else {
								System.out.println("Veiculo:\n");
							}
						}
						opcoesChamado = 7;
					}
				}
			} else if(opcoesModulo == 2) {
				int opcoesColaborador = 0;
				System.out.println("\n\nEscolha uma opção: \n1-Contratar Colaborador\n2-Rescindior Colaborador\n3-Atualizar CNH\n4-Excluir Colaborador\n5-Listar Colaboradores\n6-Voltar");
				opcoesColaborador = ler.nextInt();
				while(opcoesColaborador != 6) {
					
				}
			} else if(opcoesModulo == 3) {
				int opcoesVeiculo = 0;
				System.out.println("\n\nEscolha uma opção: \n1-Comprar Veiculo\n2-Vender Veiculo\n3-Habilitar Veiculo\n4-Desabilitar Veiculo\n5-Excluir Veiculo\n6-Listar Veiculo\n7-Voltar");
				opcoesVeiculo = ler.nextInt();
				while(opcoesVeiculo != 7) {
					
				}
			}
		}
		System.out.println("Até Amanha");
	}
}
