package application;

import java.util.List;
import java.util.Scanner;

import controller.ChamadoController;
import controller.ColaboradorController;
import controller.VeiculoController;
import model.Chamado;
import model.Colaborador;
import model.Veiculo;

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
						chamado.setIdChamado(chamados.size() == 0 ? 1 : chamados.size() + 1);
						try {
							chamadoController.criarChamado(chamado);
						} catch (Exception e) {
							System.out.println(e.getMessage() + "\n");
						} finally {
							System.out.println("Chamado aberto com sucesso\n");
							opcoesChamado = 7;
						}
					} else if(opcoesChamado == 2) {
						ColaboradorController colaboradorController = new ColaboradorController();
						List<Colaborador> colaboradores = colaboradorController.listar();
						VeiculoController veiculoController = new VeiculoController();
						List<Veiculo> veiculos = veiculoController.listar();
						Veiculo veiculoDoChamado = null;
						Colaborador colaboradorDoChamado = null;
						Chamado chamadoAtualizar = null;
						System.out.println("Selecione o colaborador\n");
						for(Colaborador colaborador : colaboradores) {
							System.out.println(colaborador.getIdColaborador() + " - " + colaborador.getNome() + "\n");
						}
						if(colaboradores.size() > 0) {
							int idColaborador = ler.nextInt();
							colaboradorDoChamado = colaboradores.get(idColaborador - 1);
						} else {
							System.out.println("Não existem colaboradores cadastrados\n");
						}
						System.out.println("Selecione o veiculo\n");
						for(Veiculo veiculo : veiculos) {
							System.out.println(veiculo.getIdVeiculo() + " - " + veiculo.getPlaca() + "\n");
						}
						if(veiculos.size() > 0) {
							int idVeiculo = ler.nextInt();
							veiculoDoChamado = veiculos.get(idVeiculo - 1);
						} else {
							System.out.println("Não existem veiculos cadastrados\n");
						}
						System.out.println("Selecione o chamado para vincular o colaborador\n");
						for(Chamado chamado : chamados) {
							System.out.println(chamado.getIdChamado() + " - " + chamado.getDescricao() + "\n");
						}
						if(chamados.size() > 0) {
							int idChamado = ler.nextInt();
							chamadoAtualizar = chamados.get(idChamado - 1);
						} else {
							System.out.println("Não existem chamados cadastrados\n");
						}
						if(chamadoAtualizar != null) {
							if(colaboradorDoChamado != null) {
								chamadoAtualizar.setColaborador(colaboradorDoChamado);
								chamadoAtualizar.setVeiculo(veiculoDoChamado);
								try {
									chamadoController.atenderChamado(chamadoAtualizar);
								} catch (Exception e) {
									System.out.println(e.getMessage() + "\n");
								} finally {
									System.out.println("Chamado atualizado com sucesso\n");
								}
							}
						}
						opcoesChamado = 7;
					} else if(opcoesChamado == 3) {
						System.out.println("Selecione o chamado para encerrar\n");
						for(Chamado chamado : chamados) {
							System.out.println(chamado.getIdChamado() + " - " + chamado.getDescricao() + "\n");
						}
						int idChamado = ler.nextInt();
						Chamado chamado = chamados.get(idChamado - 1);
						System.out.println("informe a distancia percorrida\n");
						double distanciaPercorrida = ler.nextDouble();
						try {
							chamado.setDistanciaPercorrida(distanciaPercorrida);
							chamadoController.calculaEmissao(chamado);
							chamadoController.encerrarChamado(chamado);
						} catch (Exception e) {
							System.out.println(e.getMessage() + "\n");
						} finally {
							System.out.println("Chamado encerrado com sucesso\n");
						}
						opcoesChamado = 7;
					} else if(opcoesChamado == 4) {
						System.out.println("Selecione o chamado para excluir\n");
						for(Chamado chamado : chamados) {
							System.out.println(chamado.getIdChamado() + " - " + chamado.getDescricao() + "\n");
						}
						int idChamado = ler.nextInt();
						Chamado chamado = chamados.get(idChamado - 1);
						try {
							chamadoController.excluirChamado(chamado);
						} catch (Exception e) {
							System.out.println(e.getMessage() + "\n");
						} finally {
							System.out.println("Chamado encerrado com sucesso\n");
						}
						opcoesChamado = 7;
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
					} else if(opcoesChamado == 6) {
						System.out.println("Selecione o chamado para calcular a emissao\n");
						for(Chamado chamado : chamados) {
							System.out.println(chamado.getIdChamado() + " - " + chamado.getDescricao() + "\n");
						}
						int idChamado = ler.nextInt();
						Chamado chamado = chamados.get(idChamado - 1);
						System.out.println("informe a distancia percorrida\n");
						double distanciaPercorrida = ler.nextDouble();
						try {
							chamado.setDistanciaPercorrida(distanciaPercorrida);
							chamadoController.calculaEmissao(chamado);
						} catch (Exception e) {
							System.out.println(e.getMessage() + "\n");
						} finally {
							System.out.println("Chamado calculado com sucesso\n");
						}
						opcoesChamado = 7;
					}
				}
			} else if(opcoesModulo == 2) {
				int opcoesColaborador = 0;
				System.out.println("\n\nEscolha uma opção: \n1-Contratar Colaborador\n2-Rescindior Colaborador\n3-Atualizar CNH\n4-Excluir Colaborador\n5-Listar Colaboradores\n6-Voltar");
				opcoesColaborador = ler.nextInt();
				while(opcoesColaborador != 6) {
					ColaboradorController colaboradorController = new ColaboradorController();
					List<Colaborador> colaboradores = colaboradorController.listar();
					if(opcoesColaborador == 1) {
						System.out.println("\nNome do Colaborador");
						String nome = "";
						nome = ler.nextLine();
						if(nome.isEmpty()) {
							nome = ler.nextLine();
						}
						System.out.println("\nPossui Habilitacao?");
						boolean possuiHabilitacao = false;
						possuiHabilitacao = ler.nextBoolean();
						String tipoHabilitacao = "";
						if(possuiHabilitacao) {
							System.out.println("\nInforme o tipo da Habilitacao");
							tipoHabilitacao = ler.nextLine();
							if(tipoHabilitacao.isEmpty()) {
								tipoHabilitacao = ler.nextLine();
							}
						}
						
						Colaborador colaborador = new Colaborador();
						colaborador.setIdColaborador(colaboradores.size() == 0 ? 1 : colaboradores.size() + 1);
						colaborador.setNome(nome);
						colaborador.setPossuiHabilitacao(possuiHabilitacao);
						colaborador.setTipoHabilitacao(tipoHabilitacao);
						try {
							colaboradorController.contratarColaborador(colaborador);
						} catch (Exception e) {
							System.out.println(e.getMessage() + "\n");
						} finally {
							System.out.println("Colaborador cadastrado com sucesso\n");
							opcoesColaborador = 6;
						}
					} else if(opcoesColaborador == 2) {
						System.out.println("Selecione o Colaborador\n");
						for(Colaborador colaborador : colaboradores) {
							System.out.println(colaborador.getIdColaborador() + " - " + colaborador.getNome() + "\n");
						}
						int idColaborador = ler.nextInt();
						Colaborador colaborador = colaboradores.get(idColaborador - 1);
						try {
							colaboradorController.rescindirColaborador(colaborador);
						} catch (Exception e) {
							System.out.println(e.getMessage() + "\n");
						}finally {
							System.out.println("Colaborador demitido com sucesso\n");
							opcoesColaborador = 6;
						}
					} else if(opcoesColaborador == 3) {
						System.out.println("Selecione o Colaborador\n");
						for(Colaborador colaborador : colaboradores) {
							System.out.println(colaborador.getIdColaborador() + " - " + colaborador.getNome() + "\n");
						}
						int idColaborador = ler.nextInt();
						System.out.println("Possui Habilitação?\n");
						boolean possuiHabilitacao = ler.nextBoolean();
						String tipoHabilitacao  = "";
						if(possuiHabilitacao) {
							System.out.println("Informe o Tipo da Habilitação\n");
							tipoHabilitacao = ler.nextLine();
							if(tipoHabilitacao.isEmpty()) {
								tipoHabilitacao = ler.nextLine();
							}
						}
						Colaborador colaborador = colaboradores.get(idColaborador - 1);
						try {
							colaborador.setPossuiHabilitacao(possuiHabilitacao);
							colaborador.setTipoHabilitacao(tipoHabilitacao);
							colaboradorController.atualizarCnh(colaborador);
						} catch (Exception e) {
							System.out.println(e.getMessage() + "\n");
						}finally {
							System.out.println("Colaborador atualizado com sucesso\n");
							opcoesColaborador = 6;
						}
					} else if(opcoesColaborador == 4) {
						System.out.println("Selecione o Colaborador\n");
						for(Colaborador colaborador : colaboradores) {
							System.out.println(colaborador.getIdColaborador() + " - " + colaborador.getNome() + "\n");
						}
						int idColaborador = ler.nextInt();
						Colaborador colaborador = colaboradores.get(idColaborador - 1);
						try {
							colaboradorController.excluirColaborador(colaborador);
						} catch (Exception e) {
							System.out.println(e.getMessage() + "\n");
						} finally {
							System.out.println("Colaborador excluído com sucesso\n");
							opcoesColaborador = 6;
						}
					} else if(opcoesColaborador == 5) {
						for(Colaborador colaborador : colaboradores) {
							System.out.println("Id Colaborador: " + colaborador.getIdColaborador() + "\n");
							System.out.println("Nome do Colaborador: " + colaborador.getNome() + "\n");
							System.out.println("Status: " + colaborador.getStatus() + "\n");
							System.out.println("Possui Habilitacao: " + colaborador.getPossuiHabilitacao() + "\n");
							System.out.println("Tipo de Habilitacao: " + colaborador.getTipoHabilitacao() + "\n");
							System.out.println("Data de Admissão: " + colaborador.getDataAdmissao() + "\n");
							System.out.println("Data de Demissão: " + colaborador.getDataDemissao() + "\n");
						}
						opcoesColaborador = 6;
					}
				}
			} else if(opcoesModulo == 3) {
				int opcoesVeiculo = 0;
				System.out.println("\n\nEscolha uma opção: \n1-Comprar Veiculo\n2-Vender Veiculo\n3-Habilitar Veiculo\n4-Desabilitar Veiculo\n5-Excluir Veiculo\n6-Listar Veiculo\n7-Voltar");
				opcoesVeiculo = ler.nextInt();
				while(opcoesVeiculo != 7) {
					VeiculoController veiculoControler = new VeiculoController();
					List<Veiculo> veiculos = veiculoControler.listar();
					if(opcoesVeiculo == 1) {
						System.out.println("\nInforme a Placa do Veiculo");
						String placa = "";
						placa = ler.nextLine();
						if(placa.isEmpty()) {
							placa = ler.nextLine();
						}
						System.out.println("\nInforme o Ano/Modelo do veiculo");
						String anoModelo = "";
						anoModelo = ler.nextLine();
						System.out.println("\nInforme o Tipo de Habilitacao Necessária para dirigir o veiculo");
						String tipoHabilitacao = "";
						tipoHabilitacao = ler.nextLine();
						System.out.println("\nInforme o Consumo de gasolina por KM");
						double consumoKm = 0;
						consumoKm = ler.nextDouble();

						Veiculo veiculo = new Veiculo();
						veiculo.setIdVeiculo(veiculos.size() == 0 ? 1 : veiculos.size() + 1);
						veiculo.setPlaca(placa);
						veiculo.setAnoModelo(anoModelo);
						veiculo.setConsumoKm(consumoKm);
						veiculo.setTipoHabilitacao(tipoHabilitacao);
						try {
							veiculoControler.comprarVeiculo(veiculo);
						} catch (Exception e) {
							System.out.println(e.getMessage() + "\n");
						} finally {
							System.out.println("Veículo cadastrado com sucesso\n");
							opcoesVeiculo = 7;
						}
					} else if(opcoesVeiculo == 2) {
						System.out.println("Selecione o Veiculo\n");
						for(Veiculo veiculo : veiculos) {
							System.out.println(veiculo.getIdVeiculo() + " - " + veiculo.getPlaca() + "\n");
						}
						int idVeiculo = ler.nextInt();
						Veiculo veiculo = veiculos.get(idVeiculo - 1);
						try {
							veiculoControler.venderVeiculo(veiculo);
						} catch (Exception e) {
							System.out.println(e.getMessage() + "\n");
						}finally {
							System.out.println("Veiculo vendido com sucesso\n");
							opcoesVeiculo = 7;
						}
					} else if(opcoesVeiculo == 3) {
						System.out.println("Selecione o Veiculo\n");
						for(Veiculo veiculo : veiculos) {
							System.out.println(veiculo.getIdVeiculo() + " - " + veiculo.getPlaca() + "\n");
						}
						int idVeiculo = ler.nextInt();
						Veiculo veiculo = veiculos.get(idVeiculo - 1);
						try {
							veiculoControler.habilitaVeiculo(veiculo);
						} catch (Exception e) {
							System.out.println(e.getMessage() + "\n");
						}finally {
							System.out.println("Veiculo vendido com sucesso\n");
							opcoesVeiculo = 7;
						}
					} else if(opcoesVeiculo == 4) {
						System.out.println("Selecione o Veiculo\n");
						for(Veiculo veiculo : veiculos) {
							System.out.println(veiculo.getIdVeiculo() + " - " + veiculo.getPlaca() + "\n");
						}
						int idVeiculo = ler.nextInt();
						Veiculo veiculo = veiculos.get(idVeiculo - 1);
						try {
							veiculoControler.desabilitaVeiculo(veiculo);
						} catch (Exception e) {
							System.out.println(e.getMessage() + "\n");
						}finally {
							System.out.println("Veiculo vendido com sucesso\n");
							opcoesVeiculo = 7;
						}
					} else if(opcoesVeiculo == 5) {
						System.out.println("Selecione o Colaborador\n");
						for(Veiculo veiculo : veiculos) {
							System.out.println(veiculo.getIdVeiculo() + " - " + veiculo.getPlaca() + "\n");
						}
						int idVeiculo = ler.nextInt();
						Veiculo veiculo = veiculos.get(idVeiculo - 1);
						try {
							veiculoControler.excluirVeiculo(veiculo);
						} catch (Exception e) {
							System.out.println(e.getMessage() + "\n");
						} finally {
							System.out.println("Veiculo excluído com sucesso\n");
							opcoesVeiculo = 7;
						}
					} else if(opcoesVeiculo == 6) {
						for(Veiculo veiculo : veiculos) {
							System.out.println("Id Veiculo: " + veiculo.getIdVeiculo() + "\n");
							System.out.println("Placa: " + veiculo.getPlaca() + "\n");
							System.out.println("Ano/Modelo: " + veiculo.getAnoModelo() + "\n");
							System.out.println("ConsumoKM: " + veiculo.getConsumoKm() + "\n");
							System.out.println("Tipo de Habilitacao: " + veiculo.getTipoHabilitacao() + "\n");
							System.out.println("Data de Aquisição: " + veiculo.getDataAquisicao() + "\n");
							System.out.println("Data de Venda: " + veiculo.getDataVenda() + "\n");
							System.out.println("Status: " + veiculo.getStatus()+ "\n");
						}
						opcoesVeiculo = 7;
					}
				}
			}
		}
		System.out.println("Até Amanha");
	}
}
