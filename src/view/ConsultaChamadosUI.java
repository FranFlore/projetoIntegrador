package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import controller.ChamadoController;
import controller.ColaboradorController;
import controller.VeiculoController;
import model.Chamado;
import model.Colaborador;
import model.Veiculo;

public class ConsultaChamadosUI extends JInternalFrame {
	private JComboBox cmbChamado;
	private JTextField txtNomeSolicitante;
	private JTextField txtEnderecoSolicitante;
	private JTextArea txtDescricao;
	private JTextField txtDistanciaPercorrida;
	private JTextField txtDataAbertura;
	private JTextField txtDataEncerramento;
	private JTextField txtEmissao;
	private JComboBox cmbStatus;
	private JComboBox cmbVeiculo;
	private JComboBox cmbColaborador;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaChamadosUI frame = new ConsultaChamadosUI();
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
	public ConsultaChamadosUI() {
		setTitle("Consulta de Chamado");
		setBounds(100, 100, 604, 560);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Chamado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		cmbChamado = new JComboBox();
		cmbChamado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String selectedValue = cmbChamado.getSelectedItem().toString();
					if(selectedValue != null && !selectedValue.isEmpty()) {
						String[] chamadoData = selectedValue.split("-");
						int idChamado = Integer.parseInt(chamadoData[0].trim());
						Chamado chamado = new ChamadoController().getChamado(idChamado);
						txtDescricao.setText(chamado.getDescricao());
						txtEnderecoSolicitante.setText(chamado.getEnderecoAtendimento());
						txtNomeSolicitante.setText(chamado.getNomeSolicitante());
						txtDistanciaPercorrida.setText(String.valueOf(chamado.getDistanciaPercorrida()));
						txtDataAbertura.setText(chamado.getDataCriacao().toString());
						txtDataEncerramento.setText(chamado.getDataEncerramento() != null ? chamado.getDataEncerramento().toString() : "");
						txtEmissao.setText(String.valueOf(chamado.getEmissaoCo()));
						for(int i =0; i < cmbStatus.getItemCount(); i++) {
							String status = cmbStatus.getItemAt(i).toString();
							if(status.equalsIgnoreCase(chamado.getStatus())) {
								cmbStatus.setSelectedIndex(i);
							}
						}
						List<Veiculo> veiculos = new ArrayList<Veiculo>();
						veiculos = new VeiculoController().listar();
						cmbVeiculo.addItem("");
						for(Veiculo veiculo : veiculos) {
							cmbVeiculo.addItem(veiculo.getIdVeiculo() + " - " + veiculo.getPlaca());
						}
						if(chamado.getVeiculo() != null) {
							cmbVeiculo.setSelectedItem(chamado.getVeiculo().getIdVeiculo() + " - " + chamado.getVeiculo().getPlaca());
						}
						List<Colaborador> colaboradores = new ArrayList<Colaborador>();
						colaboradores = new ColaboradorController().listar();
						cmbColaborador.addItem("");
						for(Colaborador colaborador : colaboradores) {
							cmbColaborador.addItem(colaborador.getIdColaborador() + " - " + colaborador.getNome());
						}
						if(chamado.getColaborador() != null) {
							cmbColaborador.setSelectedItem(chamado.getColaborador().getIdColaborador() + " - " + chamado.getColaborador().getNome());
						}
					} else {
						if(txtDescricao != null) {
							txtDescricao.setText("");
							txtDescricao.setEnabled(false);							
						}
						if(txtEnderecoSolicitante != null) {
							txtEnderecoSolicitante.setText("");
							txtEnderecoSolicitante.setEnabled(false);							
						}
						if(txtNomeSolicitante != null) {
							txtNomeSolicitante.setText("");
							txtNomeSolicitante.setEnabled(false);							
						}
						if(txtDistanciaPercorrida != null) {
							txtDistanciaPercorrida.setText("");
							txtDistanciaPercorrida.setEnabled(false);
						}
						if(txtEmissao != null) {
							txtEmissao.setText("");
							txtEmissao.setEnabled(false);
						}
						if(txtDataAbertura != null) {
							txtDataAbertura.setText("");
							txtDataAbertura.setEnabled(false);
						}
						if(txtDataEncerramento != null) {
							txtDataEncerramento.setText("");
							txtDataEncerramento.setEnabled(false);
						}
						if(cmbVeiculo != null) {
							cmbVeiculo.setSelectedIndex(0);
							cmbVeiculo.setEnabled(false);
						}
						if(cmbColaborador != null) {
							cmbColaborador.setSelectedIndex(0);
							cmbColaborador.setEnabled(false);
						}
						if(cmbStatus != null) {
							cmbStatus.setEnabled(false);							
						}
					}
				} catch (Exception ex){
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});
		List<Chamado> chamados = new ArrayList<Chamado>();
		chamados = new ChamadoController().listar();
		cmbChamado.addItem("");
		for(Chamado chamado : chamados) {
			cmbChamado.addItem(chamado.getIdChamado() + " - " + chamado.getDescricao());
		}

		JLabel lblSelectVeiculo = new JLabel("Selecione um Chamado");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSelectVeiculo, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbChamado, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 558, GroupLayout.PREFERRED_SIZE)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSelectVeiculo)
					.addGap(10)
					.addComponent(cmbChamado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 411, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar))
					.addGap(23))
		);
		
		JLabel lblPlacaVeiculo = new JLabel("Descrição: ");
		lblPlacaVeiculo.setVerticalAlignment(SwingConstants.TOP);
		lblPlacaVeiculo.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblDataEncerramento = new JLabel("Data de Encerramento:");
		lblDataEncerramento.setVerticalAlignment(SwingConstants.TOP);
		lblDataEncerramento.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel lblDataAbertura = new JLabel("Data de Abertura:");
		JLabel lblDistanciaPercorrida = new JLabel("Dist\u00E2ncia Percorrida:");
		JLabel lblStatus = new JLabel("Status:");

		JLabel lblNomeSolicitante = new JLabel("Nome do Solicitante:");
		lblNomeSolicitante.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel lblEnderecoSolicitante = new JLabel("Endere\u00E7o do Atendimento:");
		
		txtDescricao = new JTextArea();
		txtDescricao.setEnabled(false);
		txtDescricao.setLineWrap(true);
		
		txtNomeSolicitante = new JTextField();
		txtNomeSolicitante.setEnabled(false);
		txtNomeSolicitante.setColumns(10);
		
		txtEnderecoSolicitante = new JTextField();
		txtEnderecoSolicitante.setEnabled(false);
		txtEnderecoSolicitante.setColumns(10);
		
		txtDistanciaPercorrida = new JTextField();
		txtDistanciaPercorrida.setEnabled(false);
		txtDistanciaPercorrida.setColumns(10);
		
		txtDataAbertura = new JTextField();
		txtDataAbertura.setEnabled(false);
		txtDataAbertura.setColumns(10);
		
		txtDataEncerramento = new JTextField();
		txtDataEncerramento.setEnabled(false);
		txtDataEncerramento.setColumns(10);
		
		JLabel lblColaborador = new JLabel("Colaborador:");
		
		JLabel lblVeiculo = new JLabel("Ve\u00EDculo:");
		
		cmbColaborador = new JComboBox();
		cmbColaborador.setEnabled(false);
		
		cmbVeiculo = new JComboBox();
		cmbVeiculo.setEnabled(false);
		
		cmbStatus = new JComboBox();
		cmbStatus.setModel(new DefaultComboBoxModel(new String[] {"Aberto", "Em Atendimento", "Fechado"}));
		cmbStatus.setEnabled(false);
		
		JLabel lblEmissaoCO = new JLabel("Emiss\u00E3o CO2:");
		
		txtEmissao = new JTextField();
		txtEmissao.setEnabled(false);
		txtEmissao.setColumns(10);
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPlacaVeiculo, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtDescricao, GroupLayout.PREFERRED_SIZE, 524, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblEnderecoSolicitante, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblDistanciaPercorrida)
										.addComponent(lblStatus, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblEmissaoCO, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNomeSolicitante, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
									.addGap(14)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(cmbColaborador, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(txtEnderecoSolicitante)
										.addComponent(txtNomeSolicitante, GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
										.addComponent(cmbVeiculo, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(gl_panel.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(txtDistanciaPercorrida)
												.addComponent(txtDataAbertura, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
												.addComponent(txtDataEncerramento, GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
												.addComponent(txtEmissao, GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
												.addComponent(cmbStatus, 0, 339, Short.MAX_VALUE))))))
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblColaborador, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(443, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblVeiculo, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(482, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblDataEncerramento, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
							.addGap(348))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblDataAbertura, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(418, Short.MAX_VALUE))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPlacaVeiculo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtDescricao, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNomeSolicitante)
						.addComponent(txtNomeSolicitante, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnderecoSolicitante)
						.addComponent(txtEnderecoSolicitante, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblColaborador)
						.addComponent(cmbColaborador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVeiculo)
						.addComponent(cmbVeiculo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtDistanciaPercorrida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDistanciaPercorrida))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDataAbertura)
						.addComponent(txtDataAbertura, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDataEncerramento)
						.addComponent(txtDataEncerramento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(txtEmissao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cmbStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblEmissaoCO)
							.addGap(18)
							.addComponent(lblStatus)))
					.addGap(59))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
	}

}
