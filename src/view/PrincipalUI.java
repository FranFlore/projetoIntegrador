package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class PrincipalUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalUI frame = new PrincipalUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PrincipalUI() {
		setTitle("Controle Carbono");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 890, 800);
		
		JMenuBar mbPrincipal = new JMenuBar();
		setJMenuBar(mbPrincipal);
		
		JMenu mnColaboradores = new JMenu("Colaboradores");
		mbPrincipal.add(mnColaboradores);
		
		JMenuItem miCadastroColaborador = new JMenuItem("Cadastro de Colaborador");
		miCadastroColaborador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroColaboradoresUI cadastroColaboradores = new CadastroColaboradoresUI();
				cadastroColaboradores.setVisible(true);
				contentPane.add(cadastroColaboradores, 0);
			}
		});
		mnColaboradores.add(miCadastroColaborador);
		
		JMenuItem miAtualizarColaborador = new JMenuItem("Atualiza\u00E7\u00E3o de Colaborador");
		miAtualizarColaborador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AtualizarColaboradoresUI atualizarColaboradores = new AtualizarColaboradoresUI();
				atualizarColaboradores.setVisible(true);
				contentPane.add(atualizarColaboradores, 0);
			}
		});
		mnColaboradores.add(miAtualizarColaborador);
		
		JMenuItem miExcluirColaborador = new JMenuItem("Exclus\u00E3o de Colaborador");
		miExcluirColaborador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ExcluirColaboradoresUI excluirColaboradores = new ExcluirColaboradoresUI();
				excluirColaboradores.setVisible(true);
				contentPane.add(excluirColaboradores, 0);
			}
		});
		mnColaboradores.add(miExcluirColaborador);
		
		JMenuItem miConsultaColaborador = new JMenuItem("Consulta Colaborador");
		miConsultaColaborador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConsultaColaboradoresUI consultaColaboradores = new ConsultaColaboradoresUI();
				consultaColaboradores.setVisible(true);
				contentPane.add(consultaColaboradores, 0);
			}
		});
		mnColaboradores.add(miConsultaColaborador);
		
		JMenu mnVeiculos = new JMenu("Ve\u00EDculos");
		mbPrincipal.add(mnVeiculos);
		
		JMenuItem miCadastroVeiculo = new JMenuItem("Cadastro de Ve\u00EDculo");
		miCadastroVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroVeiculosUI cadastroVeiculo = new CadastroVeiculosUI();
				cadastroVeiculo.setVisible(true);
				contentPane.add(cadastroVeiculo, 0);
			}
		});
		mnVeiculos.add(miCadastroVeiculo);
		
		JMenuItem miAtualizarVeiculo = new JMenuItem("Atualiza\u00E7\u00E3o de Ve\u00EDculo");
		miAtualizarVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AtualizarVeiculosUI atualizaVeiculos = new AtualizarVeiculosUI();
				atualizaVeiculos.setVisible(true);
				contentPane.add(atualizaVeiculos, 0);
			}
		});
		mnVeiculos.add(miAtualizarVeiculo);
		
		JMenuItem miExcluirVeiculo = new JMenuItem("Exclus\u00E3o de Ve\u00EDculo");
		miExcluirVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExcluirVeiculosUI excluirVeiculos = new ExcluirVeiculosUI();
				excluirVeiculos.setVisible(true);
				contentPane.add(excluirVeiculos, 0);
			}
		});
		mnVeiculos.add(miExcluirVeiculo);
		
		JMenuItem miConsultaVeiculo = new JMenuItem("Consulta Ve\u00EDculo");
		miConsultaVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaVeiculosUI consultaVeiculos = new ConsultaVeiculosUI();
				consultaVeiculos.setVisible(true);
				contentPane.add(consultaVeiculos, 0);
			}
		});
		mnVeiculos.add(miConsultaVeiculo);
		
		JMenu mnChamados = new JMenu("Chamados");
		mbPrincipal.add(mnChamados);
		
		JMenuItem miCadastroChamado = new JMenuItem("Cadastro de Chamado");
		miCadastroChamado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroChamadosUI cadastroChamados = new CadastroChamadosUI();
				cadastroChamados.setVisible(true);
				contentPane.add(cadastroChamados);
			}
		});
		mnChamados.add(miCadastroChamado);
		
		JMenuItem miAtualizarChamado = new JMenuItem("Atualiza\u00E7\u00E3o de Chamado");
		miAtualizarChamado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AtualizarChamadosUI atualizarChamados = new AtualizarChamadosUI();
				atualizarChamados.setVisible(true);
				contentPane.add(atualizarChamados);
			}
		});
		mnChamados.add(miAtualizarChamado);
		
		JMenuItem miExcluirChamado = new JMenuItem("Exclus\u00E3o de Chamado");
		miExcluirChamado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExcluirChamadosUI excluirChamados = new ExcluirChamadosUI();
				excluirChamados.setVisible(true);
				contentPane.add(excluirChamados);
			}
		});
		mnChamados.add(miExcluirChamado);
		
		JMenuItem mIConsultaChamado = new JMenuItem("Consulta Chamado");
		mIConsultaChamado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaChamadosUI consultaChamados = new ConsultaChamadosUI();
				consultaChamados.setVisible(true);
				contentPane.add(consultaChamados);
			}
		});
		mnChamados.add(mIConsultaChamado);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 866, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 586, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
	}
}
