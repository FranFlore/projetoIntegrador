package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

import controller.VeiculoController;
import model.Veiculo;

public class CadastroVeiculosUI extends JInternalFrame {
	private JTextField txtPlacaVeiculo;
	private JTextField txtTipoHabilitacao;
	private JTextField txtAnoModelo;
	private JTextField txtConsumo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroVeiculosUI frame = new CadastroVeiculosUI();
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
	public CadastroVeiculosUI() {
		setClosable(true);
		setTitle("Cadastro de Veículo");
		setBounds(100, 100, 604, 240);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Veículo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Veiculo veiculo = new Veiculo();
					veiculo.setPlaca(txtPlacaVeiculo.getText());
					veiculo.setAnoModelo(txtAnoModelo.getText());
					veiculo.setTipoHabilitacao(txtTipoHabilitacao.getText());
					if(txtConsumo.getText() != null && !txtConsumo.getText().isEmpty()) {
						double consumoKm = Double.parseDouble(txtConsumo.getText());
						veiculo.setConsumoKm(consumoKm);						
					}
					new VeiculoController().cadastrarVeiculo(veiculo);
					JOptionPane.showMessageDialog(null, "Veículo Cadastrado com Sucesso");
					dispose();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});
		
		JButton btnSalvaProximo = new JButton("Salvar e Pr\u00F3ximo");
		btnSalvaProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Veiculo veiculo = new Veiculo();
					veiculo.setPlaca(txtPlacaVeiculo.getText());
					veiculo.setAnoModelo(txtAnoModelo.getText());
					veiculo.setTipoHabilitacao(txtTipoHabilitacao.getText());
					if(txtConsumo.getText() != null && !txtConsumo.getText().isEmpty()) {
						double consumoKm = Double.parseDouble(txtConsumo.getText());
						veiculo.setConsumoKm(consumoKm);						
					}
					new VeiculoController().cadastrarVeiculo(veiculo);
					JOptionPane.showMessageDialog(null, "Veículo Cadastrado com Sucesso");
					txtPlacaVeiculo.setText("");
					txtTipoHabilitacao.setText("");
					txtAnoModelo.setText("");
					txtConsumo.setText("");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 558, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSalvaProximo, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnSalvaProximo)
						.addComponent(btnSalvar))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		
		JLabel lblNomeColaborador = new JLabel("Placa: ");
		lblNomeColaborador.setVerticalAlignment(SwingConstants.TOP);
		lblNomeColaborador.setHorizontalAlignment(SwingConstants.LEFT);
		
		txtPlacaVeiculo = new JTextField();
		txtPlacaVeiculo.setColumns(10);
		
		JLabel lblTipoHabilitacao = new JLabel("Tipo de Habilita\u00E7\u00E3o:");
		lblTipoHabilitacao.setVerticalAlignment(SwingConstants.TOP);
		lblTipoHabilitacao.setHorizontalAlignment(SwingConstants.LEFT);
		
		txtTipoHabilitacao = new JTextField();
		txtTipoHabilitacao.setColumns(10);
		
		txtAnoModelo = new JTextField();
		txtAnoModelo.setColumns(10);
		
		JLabel lblAnoModelo = new JLabel("Ano/Modelo:");
		
		txtConsumo = new JTextField();
		txtConsumo.setColumns(10);
		
		JLabel lblConsumo = new JLabel("Consumo/KM:");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNomeColaborador, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAnoModelo, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(9)
							.addComponent(lblTipoHabilitacao))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblConsumo, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)))
					.addGap(14)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txtConsumo)
						.addComponent(txtAnoModelo)
						.addComponent(txtPlacaVeiculo)
						.addComponent(txtTipoHabilitacao))
					.addContainerGap(327, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNomeColaborador)
						.addComponent(txtPlacaVeiculo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtAnoModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAnoModelo))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtTipoHabilitacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(14)
							.addComponent(lblTipoHabilitacao)))
					.addGap(9)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblConsumo)
						.addComponent(txtConsumo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
	}
}
