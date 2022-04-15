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

public class ExcluirVeiculosUI extends JInternalFrame {
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
					ExcluirVeiculosUI frame = new ExcluirVeiculosUI();
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
	public ExcluirVeiculosUI() {
		setClosable(true);
		setTitle("Excluir Veículo");
		setBounds(100, 100, 604, 389);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Veículo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JButton btnSalvar = new JButton("Excluir");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String selectedValue = cmbVeiculo.getSelectedItem().toString();
					if(selectedValue != null && !selectedValue.isEmpty()) {
						String[] veiculoData = selectedValue.split("-");
						int idVeiculo = Integer.parseInt(veiculoData[0].trim());
						Veiculo veiculo = new Veiculo();
						veiculo.setIdVeiculo(idVeiculo);
						new VeiculoController().excluirVeiculo(veiculo);
						JOptionPane.showMessageDialog(null, "Veículo Excluído com Sucesso");
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Selecione um veículo para excluir");	
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});
		
		JButton btnSalvaProximo = new JButton("Excluir e Pr\u00F3ximo");
		btnSalvaProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String selectedValue = cmbVeiculo.getSelectedItem().toString();
					if(selectedValue != null && !selectedValue.isEmpty()) {
						String[] veiculoData = selectedValue.split("-");
						int idVeiculo = Integer.parseInt(veiculoData[0].trim());
						Veiculo veiculo = new Veiculo();
						veiculo.setIdVeiculo(idVeiculo);
						new VeiculoController().excluirVeiculo(veiculo);
						JOptionPane.showMessageDialog(null, "Veículo Excluído com Sucesso");
						txtPlacaVeiculo.setText("");
						txtTipoHabilitacao.setText("");
						txtDataCompra.setText("");
						txtDataVenda.setText("");
						txtConsumo.setText("");
						txtAnoModelo.setText("");
						cmbStatus.setSelectedItem("Ativo");
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
						txtAnoModelo.setText(veiculo.getAnoModelo());
						txtTipoHabilitacao.setText(veiculo.getTipoHabilitacao());
						txtConsumo.setText(String.valueOf(veiculo.getConsumoKm()));
						txtDataCompra.setText(veiculo.getDataAquisicao().toString());
						txtDataVenda.setText(veiculo.getDataVenda() != null ? veiculo.getDataVenda().toString() : "");
						for(int i =0; i < cmbStatus.getItemCount(); i++) {
							String status = cmbStatus.getItemAt(i).toString();
							if(status.equalsIgnoreCase(veiculo.getStatus())) {
								cmbStatus.setSelectedIndex(i);
							}
						}
					} else {
						if(txtPlacaVeiculo != null) {
							txtPlacaVeiculo.setText("");
						}
						if(txtTipoHabilitacao != null) {
							txtTipoHabilitacao.setText("");							
						}
						if(txtAnoModelo != null) {
							txtAnoModelo.setText("");							
						}
						if(txtDataCompra != null) {
							txtDataCompra.setText("");
						}
						if(txtDataVenda != null) {
							txtDataVenda.setText("");
						}
						if(txtConsumo != null) {
							txtConsumo.setText("");
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
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 558, GroupLayout.PREFERRED_SIZE)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnSalvaProximo, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))))
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
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnSalvaProximo)
						.addComponent(btnSalvar))
					.addContainerGap(29, Short.MAX_VALUE))
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
