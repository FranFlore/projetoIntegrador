package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import controller.ChamadoController;
import controller.ColaboradorController;
import controller.VeiculoController;
import model.Chamado;
import model.Colaborador;
import model.Veiculo;

public class Application {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		int opcoesModulo = 0;
		while (opcoesModulo < 4) {
			 opcoesModulo = getMenu("Você deseja acessar qual modulo:\n1-Chamados\n2-Colaboradores\n3-Veículos\n4-Sair", 4);
			 ChamadoController chamadoController = new ChamadoController();
			 ColaboradorController colaboradorController = new ColaboradorController();
			 VeiculoController veiculoController = new VeiculoController();
			switch(opcoesModulo) {
			  case 1:
				  int opcoesChamado = 0;
				  while(opcoesChamado < 7) {
					  opcoesChamado = getMenu("\nEscolha uma opção: \n1-Abrir Chamado\n2-Atender Chamado\n3-Encerrar Chamado\n4-Excluir Chamado\n5-Listar Chamados\n6-Calcular Emissao\n7-Voltar", 7);
					  switch(opcoesChamado) {
						  case 1:
							  try {
								  String descricao = getStringValue("\nInsira uma descrição para o chamado");
								  String nome = getStringValue("\nInforme seu nome");
								  String endereco = getStringValue("\nInforme seu endereço");
								  Chamado chamado = new Chamado(descricao, nome, endereco);
								  chamadoController.criarChamado(chamado);
								  System.out.println("\nChamado aberto com sucesso\n");
							  } catch (Exception e) {
								  System.out.println(e.getMessage() + "\n");
							  }
							  break;
						  case 2:
							  try{
								  Chamado chamado = getChamadoSelecionado(chamadoController);
								  chamado.setColaborador(getColaboradorSelecionado(colaboradorController));
								  chamado.setVeiculo(getVeiculoSelecionado(veiculoController));
								  chamadoController.atenderChamado(chamado);
								  System.out.println("Chamado atualizado com sucesso\n");
							  } catch(Exception e) {
								  System.out.println(e.getMessage() + "\n");
							  }
							  break;
						  case 3:
							  try {
								  Chamado chamado = getChamadoSelecionado(chamadoController);
								  chamado.setDistanciaPercorrida(getDoubleValue("\nInforme a distância percorrida"));
								  chamadoController.calculaEmissao(chamado);
								  chamadoController.encerrarChamado(chamado);
								  System.out.println("Chamado encerrado com sucesso\n");
							  } catch (Exception e) {
								  System.out.println(e.getMessage() + "\n");
							  }
							  break;
						  case 4:
							  try {
								  Chamado chamado = getChamadoSelecionado(chamadoController);
								  chamadoController.excluirChamado(chamado);
								  System.out.println("Chamado excluído com sucesso\n");
							  } catch (Exception e) {
								  System.out.println(e.getMessage() + "\n");
							  }
							  break;
						  case 5:
							  List<Chamado> chamados = chamadoController.listar();
							  for(Chamado chamado : chamados) {
									System.out.println("Id Chamado: " + chamado.getIdChamado());
									System.out.println("Descricao: " + chamado.getDescricao());
									System.out.println("Nome do Solicitante: " + chamado.getNomeSolicitante());
									System.out.println("Endereço do Atendimento: " + chamado.getEnderecoAtendimento());
									System.out.println("Distância Percorrida: " + chamado.getDistanciaPercorrida());
									System.out.println("Emissão de CO2: " + chamado.getEmissaoCo());
									System.out.println("Status: " + chamado.getStatus());
									System.out.println("Data Criação: " + chamado.getDataCriacao());
									System.out.println("Data Encerramento: " + chamado.getDataEncerramento());
									if(chamado.getColaborador() != null) {
										System.out.println("Colaborador: " + chamado.getColaborador().getNome());								
									} else {
										System.out.println("Colaborador:");
									}
									if(chamado.getVeiculo() != null) {
										System.out.println("Veiculo: " + chamado.getVeiculo().getPlaca());								
									} else {
										System.out.println("Veiculo:");
									}
									System.out.println("\n\n");
								}
							  if(chamados.size() == 0) {
								  System.out.println("\nNão há chamados cadastrados\n");
							  }
							  break;
						  case 6:
							  try {
								  Chamado chamado = getChamadoSelecionado(chamadoController);
								  chamado.setDistanciaPercorrida(getDoubleValue("\nInforme a distancia percorrida"));
								  chamadoController.calculaEmissao(chamado);
								  System.out.println("Chamado calculado com sucesso\n");
								} catch (Exception e) {
									System.out.println(e.getMessage() + "\n");
								}
							  break;
					  }
				  }
				  break;
			  case 2:
				  int opcoesColaborador = 0;
				  while(opcoesColaborador < 6) {
					  opcoesColaborador = getMenu("\nEscolha uma opção: \n1-Contratar Colaborador\n2-Rescindior Colaborador\n3-Atualizar CNH\n4-Excluir Colaborador\n5-Listar Colaboradores\n6-Voltar", 6);
					  switch(opcoesColaborador) {
						  case 1:
							  try {
								  Colaborador colaborador = new Colaborador();
								  colaborador.setNome(getStringValue("\nInforme o nome do colaborador"));
								  colaborador.setPossuiHabilitacao(getBooleanValue("\nInforme se o colaborador possui habilitação (Sim/Não)"));
								  if(colaborador.getPossuiHabilitacao()) {
									  colaborador.setTipoHabilitacao(getStringValue("\nInforme o tipo da habilitação"));									  
								  }
								  colaboradorController.contratarColaborador(colaborador);
								  System.out.println("\nColaborador cadastrado com sucesso\n");
							  } catch (Exception e) {
								  System.out.println(e.getMessage() + "\n");
							  }
							  break;
						  case 2:
							  try {
								  Colaborador colaborador = getColaboradorSelecionado(colaboradorController);
								  colaboradorController.rescindirColaborador(colaborador);
								  System.out.println("Colaborador demitido com sucesso\n");
							  } catch (Exception e) {
								  System.out.println(e.getMessage() + "\n");
							  }
							  break;
						  case 3:
							  try {
								  Colaborador colaborador = getColaboradorSelecionado(colaboradorController);
								  colaborador.setPossuiHabilitacao(getBooleanValue("\nInforme se o colaborador possui habilitação (Sim/Não)"));
								  colaborador.setTipoHabilitacao(getStringValue("\nInforme o tipo da habilitação"));
								  colaboradorController.atualizarCnh(colaborador);
								  System.out.println("Colaborador atualizado com sucesso\n");
							  } catch (Exception e) {
								  System.out.println(e.getMessage() + "\n");
							  }
							  break;
						  case 4:
							  try {
								  Colaborador colaborador = getColaboradorSelecionado(colaboradorController);
								  colaboradorController.excluirColaborador(colaborador);
								  System.out.println("Colaborador excluído com sucesso\n");
							  } catch (Exception e) {
								  System.out.println(e.getMessage() + "\n");
							  }
							  break;
						  case 5:
							  List<Colaborador> colaboradores = colaboradorController.listar();
							  for(Colaborador colaborador : colaboradores) {
								  System.out.println("Id Colaborador: " + colaborador.getIdColaborador());
								  System.out.println("Nome do Colaborador: " + colaborador.getNome());
								  System.out.println("Status: " + colaborador.getStatus());
								  System.out.println("Possui Habilitacao: " + colaborador.getPossuiHabilitacao());
								  System.out.println("Tipo de Habilitacao: " + colaborador.getTipoHabilitacao());
								  System.out.println("Data de Admissão: " + colaborador.getDataAdmissao());
								  System.out.println("Data de Demissão: " + colaborador.getDataDemissao());
								  System.out.println("\n\n");
							  }
							  if(colaboradores.size() == 0) {
								  System.out.println("\nNão há colaboradores cadastrados\n");
							  }
							  break;
					  }
				  }
				  break;
			  case 3:
				  int opcoesVeiculo = 0;
				  while(opcoesVeiculo < 7) {
					  opcoesVeiculo = getMenu("\nEscolha uma opção: \n1-Comprar\n2-Vender\n3-Habilitar\n4-Desabilitar\n5-Excluir\n6-Listar\n7-Voltar", 7);
					  switch(opcoesVeiculo) {
						  case 1:
							  try {
								  Veiculo veiculo = new Veiculo();
								  veiculo.setPlaca(getStringValue("\nInforme a Placa do Veiculo"));
								  veiculo.setAnoModelo(getStringValue("\nInforme o Ano/Modelo do Veiculo"));
								  veiculo.setTipoHabilitacao(getStringValue("\nInforme o Tipo de Habilitacao Necessária para dirigir o veiculo"));
								  veiculo.setConsumoKm(getDoubleValue("\nInforme o Consumo de gasolina por KM"));
								  veiculoController.comprarVeiculo(veiculo);
								  System.out.println("\nVeículo cadastrado com sucesso\n");
							  }catch(Exception ex) {
								  System.out.println(ex.getMessage());
							  }
							  break;
						  case 2:
							  try {
								  Veiculo veiculo = getVeiculoSelecionado(veiculoController);
								  veiculoController.venderVeiculo(veiculo);
								  System.out.println("\nVeiculo vendido com sucesso\n");
							  } catch (Exception e) {
								  System.out.println(e.getMessage());
							  }
							  break;
						  case 3:
							  try {
								  Veiculo veiculo = getVeiculoSelecionado(veiculoController);
								  veiculoController.habilitaVeiculo(veiculo);
								  System.out.println("\nVeiculo habilitado com sucesso\n");
							  } catch (Exception e) {
								  System.out.println(e.getMessage());
							  }
							  break;
						  case 4:
							  try {
								  Veiculo veiculo = getVeiculoSelecionado(veiculoController);
								  veiculoController.desabilitaVeiculo(veiculo);
								  System.out.println("\nVeiculo desabilitado com sucesso\n");
							  } catch (Exception e) {
								  System.out.println(e.getMessage());
							  }
							  break;
						  case 5:
							  try {
								  Veiculo veiculo = getVeiculoSelecionado(veiculoController);
								  veiculoController.excluirVeiculo(veiculo);
								  System.out.println("\nVeiculo excluído com sucesso\n");
							  } catch (Exception e) {
								  System.out.println(e.getMessage());
							  }
							  break;
						  case 6:
							  List<Veiculo> veiculos = veiculoController.listar();
							  for(Veiculo veiculo : veiculos) {
								  System.out.println("Id Veiculo: " + veiculo.getIdVeiculo());
								  System.out.println("Placa: " + veiculo.getPlaca());
								  System.out.println("Ano/Modelo: " + veiculo.getAnoModelo());
								  System.out.println("ConsumoKM: " + veiculo.getConsumoKm());
								  System.out.println("Tipo de Habilitacao: " + veiculo.getTipoHabilitacao());
								  System.out.println("Data de Aquisição: " + veiculo.getDataAquisicao());
								  System.out.println("Data de Venda: " + veiculo.getDataVenda());
								  System.out.println("Status: " + veiculo.getStatus());
								  System.out.println("\n\n");
							  }
							  if(veiculos.size() == 0) {
								  System.out.println("\nNão há veiculos cadastrados\n");
							  }
							  break;
					  }
				  }
				  break;
			}
		}
		System.out.println("Até Amanha");
	}

	public static int getMenu(String message, int options) {
		System.out.println(message);
		try {
			int returnValue = getIntValue();
			if(returnValue > options) {
				throw new Exception();
			}
			return returnValue;
		} catch (Exception e) {
			System.out.println("Opção Inválida, Informe numeros entre 1 e " + options + ".");
			return getMenu(message, options);
		}
	}

	public static int getIntValue() throws NumberFormatException, IOException {
		int returnValue = Integer.parseInt(input.readLine());
		return returnValue;
	}

	public static String getStringValue(String message) throws IOException {
		System.out.println(message);
		try {
			return input.readLine();
		} catch(Exception ex) {
			return getStringValue(message);
		}
	}

	public static boolean getBooleanValue(String message) {
		System.out.println(message);
		try {
			String value = input.readLine();
			if(value.equalsIgnoreCase("sim") || value.equalsIgnoreCase("s")) {
				return true;
			} else if(value.equalsIgnoreCase("não") || value.equalsIgnoreCase("nao") || value.equalsIgnoreCase("n")) {
				return false;
			}
			throw new Exception();
		} catch(Exception ex) {
			System.out.println("Informe Sim/Não;");
			return getBooleanValue(message);
		}
	}

	public static Double getDoubleValue(String message) {
		System.out.println(message);
		try {
			return Double.parseDouble(input.readLine());
		} catch(Exception ex) {
			return getDoubleValue(message);
		}
	}

	public static Veiculo getVeiculoSelecionado(VeiculoController controller) {
		List<Veiculo> veiculos = controller.listar();
		System.out.println("Selecione o Veiculo\n");
		for(Veiculo veiculo : veiculos) {
			System.out.println(veiculo.getIdVeiculo() + " - " + veiculo.getPlaca());
		}
		try {
			String value = input.readLine();
			int idVeiculo = Integer.parseInt(value);
			return veiculos.stream().filter(veiculo -> veiculo.getIdVeiculo() == idVeiculo).findFirst().orElseThrow(() -> new Exception());
		} catch (Exception ex) {
			System.out.println("Opção Inválida. Selecione um veículo válido");
			return getVeiculoSelecionado(controller);
		}
	}

	public static Colaborador getColaboradorSelecionado(ColaboradorController controller) {
		List<Colaborador> colaboradores = controller.listar();
		System.out.println("Selecione o Colaborador\n");
		for(Colaborador colaborador : colaboradores) {
			System.out.println(colaborador.getIdColaborador() + " - " + colaborador.getNome());
		}
		try {
			String value = input.readLine();
			int idColaborador = Integer.parseInt(value);
			return colaboradores.stream().filter(colaborador -> colaborador.getIdColaborador() == idColaborador).findFirst().orElseThrow(() -> new Exception());
		} catch (Exception ex) {
			System.out.println("Opção Inválida. Selecione um colaborador válido");
			return getColaboradorSelecionado(controller);
		}
	}

	public static Chamado getChamadoSelecionado(ChamadoController controller) {
		List<Chamado> chamados = controller.listar();
		System.out.println("Selecione o Chamado\n");
		for(Chamado chamado : chamados) {
			System.out.println(chamado.getIdChamado() + " - " + chamado.getDescricao());
		}
		try {
			String value = input.readLine();
			int idChamado = Integer.parseInt(value);
			return chamados.stream().filter(chamado -> chamado.getIdChamado() == idChamado).findFirst().orElseThrow(() -> new Exception());
		} catch (Exception ex) {
			System.out.println("Opção Inválida. Selecione um chamado válido");
			return getChamadoSelecionado(controller);
		}
	}
}
