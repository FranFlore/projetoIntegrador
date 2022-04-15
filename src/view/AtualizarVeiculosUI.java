package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import controller.VeiculoController;
import model.Veiculo;

public class AtualizarVeiculosUI extends JInternalFrame {
	private JTextField txtPlacaVeiculo;
	private JTextField txtTipoHabilitacao;
	private JComboBox cmbStatus;
	private JComboBox cmbVeiculo;
	private JTextField txtAnoModelo;
	private JTextField txtConsumo;
	private JTextField txtDataCompra;
	private JTextField txtDataVenda;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtualizarVeiculosUI frame = new AtualizarVeiculosUI();
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
	public AtualizarVeiculosUI() {
		setClosable(true);
		setTitle("Atualizar Veículo");
		setBounds(100, 100, 604, 387);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Veículo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
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
					String selectedValue = cmbVeiculo.getSelectedItem().toString();
					if(selectedValue != null && !selectedValue.isEmpty()) {
						String[] veiculoData = selectedValue.split("-");
						int idVeiculo = Integer.parseInt(veiculoData[0].trim());
						Veiculo veiculo = new Veiculo();
						veiculo.setIdVeiculo(idVeiculo);
						veiculo.setPlaca(txtPlacaVeiculo.getText());
						veiculo.setAnoModelo(txtAnoModelo.getText());
						veiculo.setTipoHabilitacao(txtTipoHabilitacao.getText());
						if(txtConsumo.getText() != null && !txtConsumo.getText().isEmpty()) {
							double consumo = Double.parseDouble(txtConsumo.getText());
							veiculo.setConsumoKm(consumo);
						}
						if(txtDataCompra.getText() != null && !txtDataCompra.getText().isEmpty()) {
							LocalDate dataCompra = LocalDate.parse(txtDataCompra.getText());
							veiculo.setDataAquisicao(dataCompra);
						}
						if(txtDataVenda.getText() != null && !txtDataVenda.getText().isEmpty()) {
							LocalDate dataVenda = LocalDate.parse(txtDataVenda.getText());
							veiculo.setDataVenda(dataVenda);
						}
						veiculo.setStatus(cmbStatus.getSelectedItem().toString());
						new VeiculoController().atualizarVeiculo(veiculo);
						JOptionPane.showMessageDialog(null, "Veículo Atualizado com Sucesso");
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Selecione um veículo para atualizar");	
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});
		
		JButton btnSalvaProximo = new JButton("Salvar e Pr\u00F3ximo");
		btnSalvaProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String selectedValue = cmbVeiculo.getSelectedItem().toString();
					if(selectedValue != null && !selectedValue.isEmpty()) {
						String[] veiculoData = selectedValue.split("-");
						int idVeiculo = Integer.parseInt(veiculoData[0].trim());
						Veiculo veiculo = new Veiculo();
						veiculo.setIdVeiculo(idVeiculo);
						veiculo.setPlaca(txtPlacaVeiculo.getText());
						veiculo.setAnoModelo(txtAnoModelo.getText());
						veiculo.setTipoHabilitacao(txtTipoHabilitacao.getText());
						if(txtConsumo.getText() != null && !txtConsumo.getText().isEmpty()) {
							double consumo = Double.parseDouble(txtConsumo.getText());
							veiculo.setConsumoKm(consumo);
						}
						if(txtDataCompra.getText() != null && !txtDataCompra.getText().isEmpty()) {
							LocalDate dataCompra = LocalDate.parse(txtDataCompra.getText());
							veiculo.setDataAquisicao(dataCompra);
						}
						if(txtDataVenda.getText() != null && !txtDataVenda.getText().isEmpty()) {
							LocalDate dataVenda = LocalDate.parse(txtDataVenda.getText());
							veiculo.setDataVenda(dataVenda);
						}
						veiculo.setStatus(cmbStatus.getSelectedItem().toString());
						new VeiculoController().atualizarVeiculo(veiculo);
						JOptionPane.showMessageDialog(null, "Veículo Atualizado com Sucesso");
						txtPlacaVeiculo.setText("");
						txtPlacaVeiculo.setEnabled(false);
						txtTipoHabilitacao.setText("");
						txtTipoHabilitacao.setEnabled(false);
						txtDataCompra.setText("");
						txtDataCompra.setEnabled(false);
						txtDataVenda.setText("");
						txtDataVenda.setEnabled(false);
						txtConsumo.setText("");
						txtConsumo.setEnabled(false);
						txtAnoModelo.setText("");
						txtAnoModelo.setEnabled(false);
						cmbStatus.setSelectedItem("Ativo");
						cmbStatus.setEnabled(false);
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});
		
		cmbVeiculo = new JComboBox();
		cmbVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String selectedValue = cmbVeiculo.getSelectedItem().toString();
					if(selectedValue != null && !selectedValue.isEmpty()) {
						String[] colaboradorData = selectedValue.split("-");
						int idVeiculo = Integer.parseInt(colaboradorData[0].trim());
						Veiculo veiculo = new VeiculoController().getVeiculo(idVeiculo);
						txtPlacaVeiculo.setText(veiculo.getPlaca());
						txtPlacaVeiculo.setEnabled(true);
						txtAnoModelo.setText(veiculo.getAnoModelo());
						txtAnoModelo.setEnabled(true);
						txtTipoHabilitacao.setText(veiculo.getTipoHabilitacao());
						txtTipoHabilitacao.setEnabled(true);
						txtConsumo.setText(String.valueOf(veiculo.getConsumoKm()));
						txtConsumo.setEnabled(true);
						txtDataCompra.setText(veiculo.getDataAquisicao().toString());
						txtDataCompra.setEnabled(true);
						txtDataVenda.setText(veiculo.getDataVenda() != null ? veiculo.getDataVenda().toString() : "");
						txtDataVenda.setEnabled(true);
						for(int i =0; i < cmbStatus.getItemCount(); i++) {
							String status = cmbStatus.getItemAt(i).toString();
							if(status.equalsIgnoreCase(veiculo.getStatus())) {
								cmbStatus.setSelectedIndex(i);
							}
						}
						cmbStatus.setEnabled(true);
					} else {
						if(txtPlacaVeiculo != null) {
							txtPlacaVeiculo.setText("");
							txtPlacaVeiculo.setEnabled(false);							
						}
						if(txtTipoHabilitacao != null) {
							txtTipoHabilitacao.setText("");
							txtTipoHabilitacao.setEnabled(false);							
						}
						if(txtAnoModelo != null) {
							txtAnoModelo.setText("");
							txtAnoModelo.setEnabled(false);							
						}
						if(txtDataCompra != null) {
							txtDataCompra.setText("");
							txtDataCompra.setEnabled(false);
						}
						if(txtDataVenda != null) {
							txtDataVenda.setText("");
							txtDataVenda.setEnabled(false);
						}
						if(txtConsumo != null) {
							txtConsumo.setText("");
							txtConsumo.setEnabled(false);
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
		List<Veiculo> veiculos = new ArrayList<Veiculo>();
		veiculos = new VeiculoController().listar();
		cmbVeiculo.addItem("");
		for(Veiculo veiculo : veiculos) {
			cmbVeiculo.addItem(veiculo.getIdVeiculo() + " - " + veiculo.getPlaca());
		}

		JLabel lblSelectVeiculo = new JLabel("Selecione um Veículo");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSelectVeiculo, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbVeiculo, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnSalvaProximo, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 558, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSelectVeiculo)
					.addGap(10)
					.addComponent(cmbVeiculo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnSalvaProximo)
						.addComponent(btnSalvar))
					.addGap(30))
		);
		
		JLabel lblPlacaVeiculo = new JLabel("Placa: ");
		lblPlacaVeiculo.setVerticalAlignment(SwingConstants.TOP);
		lblPlacaVeiculo.setHorizontalAlignment(SwingConstants.LEFT);
		
		txtPlacaVeiculo = new JTextField();
		txtPlacaVeiculo.setEnabled(false);
		txtPlacaVeiculo.setColumns(10);
		
		JLabel lblTipoHabilitacao = new JLabel("Tipo de Habilita\u00E7\u00E3o:");
		lblTipoHabilitacao.setVerticalAlignment(SwingConstants.TOP);
		lblTipoHabilitacao.setHorizontalAlignment(SwingConstants.LEFT);
		
		txtTipoHabilitacao = new JTextField();
		txtTipoHabilitacao.setEnabled(false);
		txtTipoHabilitacao.setColumns(10);
		
		JLabel lblDataCompra = new JLabel("Data de Compra:");
		JLabel lblDataVenda = new JLabel("Data de Venda:");
		JLabel lblStatus = new JLabel("Status:");

		cmbStatus = new JComboBox();
		cmbStatus.setEnabled(false);
		cmbStatus.setModel(new DefaultComboBoxModel(new String[] {"Ativo", "Inativo", "Vendido"}));
		
		JLabel lblAnoModelo = new JLabel("Ano/Modelo:");
		lblAnoModelo.setHorizontalAlignment(SwingConstants.LEFT);
		
		txtAnoModelo = new JTextField();
		txtAnoModelo.setEnabled(false);
		txtAnoModelo.setColumns(10);
		
		JLabel lblConsumoKM = new JLabel("Consumo/KM:");
		
		txtConsumo = new JTextField();
		txtConsumo.setEnabled(false);
		txtConsumo.setColumns(10);
		
		txtDataCompra = new JTextField();
		txtDataCompra.setEnabled(false);
		txtDataCompra.setColumns(10);
		
		txtDataVenda = new JTextField();
		txtDataVenda.setEnabled(false);
		txtDataVenda.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblAnoModelo, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
									.addGap(34))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblTipoHabilitacao, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGap(394))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(lblPlacaVeiculo, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblConsumoKM))
											.addGap(10))
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(lblDataCompra, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
											.addGap(25)))
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblDataVenda)
										.addGap(53)))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblStatus, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(txtDataCompra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
											.addComponent(txtConsumo)
											.addComponent(txtPlacaVeiculo)
											.addComponent(txtAnoModelo)
											.addComponent(txtTipoHabilitacao)))
									.addGap(301))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(cmbStatus, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(txtDataVenda, Alignment.LEADING))
									.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPlacaVeiculo)
						.addComponent(txtPlacaVeiculo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAnoModelo)
						.addComponent(txtAnoModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(7)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTipoHabilitacao)
						.addComponent(txtTipoHabilitacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblConsumoKM)
						.addComponent(txtConsumo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDataCompra)
						.addComponent(txtDataCompra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDataVenda)
						.addComponent(txtDataVenda, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(cmbStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblStatus))
					.addContainerGap(57, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
	}
}
