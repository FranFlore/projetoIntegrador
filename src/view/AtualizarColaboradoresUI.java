package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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

import controller.ColaboradorController;
import model.Colaborador;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import java.time.LocalDate;
import javax.swing.DefaultComboBoxModel;

public class AtualizarColaboradoresUI extends JInternalFrame {
	private JTextField txtNomeColaborador;
	private JTextField txtTipoHabilitacao;
	private JCheckBox chkPossuiHabilitacao;
	private JTextField txtDataAdmissao;
	private JTextField txtDataDemissao;
	private JComboBox cmbStatus;
	private JComboBox cmbColaborador;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtualizarColaboradoresUI frame = new AtualizarColaboradoresUI();
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
	public AtualizarColaboradoresUI() {
		setClosable(true);
		setTitle("Atualizar Colaborador");
		setBounds(100, 100, 604, 370);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Colaborador", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
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
					String selectedValue = cmbColaborador.getSelectedItem().toString();
					if(selectedValue != null && !selectedValue.isEmpty()) {
						String[] colaboradorData = selectedValue.split("-");
						int idColaborador = Integer.parseInt(colaboradorData[0].trim());
						Colaborador colaborador = new Colaborador();
						colaborador.setIdColaborador(idColaborador);
						colaborador.setNome(txtNomeColaborador.getText());
						colaborador.setPossuiHabilitacao(chkPossuiHabilitacao.isSelected());
						if(colaborador.getPossuiHabilitacao()) {
							colaborador.setTipoHabilitacao(txtTipoHabilitacao.getText());	
						} else {
							colaborador.setTipoHabilitacao(null);
						}
						if(txtDataAdmissao.getText() != null && !txtDataAdmissao.getText().isEmpty()) {
							LocalDate dataAdmissao = LocalDate.parse(txtDataAdmissao.getText());
							colaborador.setDataAdmissao(dataAdmissao);
						}
						if(txtDataDemissao.getText() != null && !txtDataDemissao.getText().isEmpty()) {
							LocalDate dataDemissao = LocalDate.parse(txtDataDemissao.getText());
							colaborador.setDataDemissao(dataDemissao);
						}
						colaborador.setStatus(cmbStatus.getSelectedItem().toString());
						new ColaboradorController().atualizarColaborador(colaborador);
						JOptionPane.showMessageDialog(null, "Colaborador Atualizado com Sucesso");
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Selecione um colaborador para atualizar");	
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
					String selectedValue = cmbColaborador.getSelectedItem().toString();
					if(selectedValue != null && !selectedValue.isEmpty()) {
						String[] colaboradorData = selectedValue.split("-");
						int idColaborador = Integer.parseInt(colaboradorData[0].trim());
						Colaborador colaborador = new Colaborador();
						colaborador.setIdColaborador(idColaborador);
						colaborador.setNome(txtNomeColaborador.getText());
						colaborador.setPossuiHabilitacao(chkPossuiHabilitacao.isSelected());
						if(colaborador.getPossuiHabilitacao()) {
							colaborador.setTipoHabilitacao(txtTipoHabilitacao.getText());	
						} else {
							colaborador.setTipoHabilitacao(null);
						}
						if(txtDataAdmissao.getText() != null && !txtDataAdmissao.getText().isEmpty()) {
							LocalDate dataAdmissao = LocalDate.parse(txtDataAdmissao.getText());
							colaborador.setDataAdmissao(dataAdmissao);
						}
						if(txtDataDemissao.getText() != null && !txtDataDemissao.getText().isEmpty()) {
							LocalDate dataDemissao = LocalDate.parse(txtDataDemissao.getText());
							colaborador.setDataDemissao(dataDemissao);
						}
						colaborador.setStatus(cmbStatus.getSelectedItem().toString());
						new ColaboradorController().atualizarColaborador(colaborador);
						txtNomeColaborador.setText("");
						txtNomeColaborador.setEnabled(false);
						txtTipoHabilitacao.setText("");
						txtTipoHabilitacao.setEnabled(false);
						txtDataDemissao.setText("");
						txtDataDemissao.setEnabled(false);
						txtDataAdmissao.setText("");
						txtDataAdmissao.setEnabled(false);
						cmbStatus.setSelectedItem("Ativo");
						cmbStatus.setEnabled(false);
						chkPossuiHabilitacao.setSelected(false);;
						chkPossuiHabilitacao.setEnabled(false);
						chkPossuiHabilitacao.setSelected(false);
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});
		
		cmbColaborador = new JComboBox();
		cmbColaborador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String selectedValue = cmbColaborador.getSelectedItem().toString();
					if(selectedValue != null && !selectedValue.isEmpty()) {
						String[] colaboradorData = selectedValue.split("-");
						int idColaborador = Integer.parseInt(colaboradorData[0].trim());
						Colaborador colaborador = new ColaboradorController().getColaborador(idColaborador);
						txtNomeColaborador.setText(colaborador.getNome());
						txtNomeColaborador.setEnabled(true);
						chkPossuiHabilitacao.setSelected(colaborador.getPossuiHabilitacao());
						chkPossuiHabilitacao.setEnabled(true);
						txtTipoHabilitacao.setText(colaborador.getTipoHabilitacao());
						txtTipoHabilitacao.setEnabled(true);
						txtDataAdmissao.setText(colaborador.getDataAdmissao().toString());
						txtDataAdmissao.setEnabled(true);
						txtDataDemissao.setText(colaborador.getDataDemissao() != null ? colaborador.getDataDemissao().toString() : "");
						txtDataDemissao.setEnabled(true);
						for(int i =0; i < cmbStatus.getItemCount(); i++) {
							String status = cmbStatus.getItemAt(i).toString();
							if(status.equalsIgnoreCase(colaborador.getStatus())) {
								cmbStatus.setSelectedIndex(i);
							}
						}
						cmbStatus.setEnabled(true);
					} else {
						if(txtNomeColaborador != null) {
							txtNomeColaborador.setText("");
							txtNomeColaborador.setEnabled(false);							
						}
						if(txtTipoHabilitacao != null) {
							txtTipoHabilitacao.setText("");
							txtTipoHabilitacao.setEnabled(false);							
						}
						if(txtDataAdmissao != null) {
							txtDataAdmissao.setText("");
							txtDataAdmissao.setEnabled(false);
						}
						if(txtDataDemissao != null) {
							txtDataDemissao.setText("");
							txtDataDemissao.setEnabled(false);
						}
						if(chkPossuiHabilitacao != null) {
							chkPossuiHabilitacao.setSelected(false);
							chkPossuiHabilitacao.setEnabled(false);
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
		List<Colaborador> colaboradores = new ArrayList<Colaborador>();
		colaboradores = new ColaboradorController().listar();
		cmbColaborador.addItem("");
		for(Colaborador colaborador : colaboradores) {
			cmbColaborador.addItem(colaborador.getIdColaborador() + " - " + colaborador.getNome());
		}

		JLabel lblSelectColaborador = new JLabel("Selecione um Colaborador");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSelectColaborador, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbColaborador, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
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
					.addComponent(lblSelectColaborador)
					.addGap(10)
					.addComponent(cmbColaborador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnSalvaProximo)
						.addComponent(btnSalvar))
					.addContainerGap(100, Short.MAX_VALUE))
		);
		
		JLabel lblNomeColaborador = new JLabel("Nome Colaborador: ");
		lblNomeColaborador.setVerticalAlignment(SwingConstants.TOP);
		lblNomeColaborador.setHorizontalAlignment(SwingConstants.LEFT);
		
		txtNomeColaborador = new JTextField();
		txtNomeColaborador.setEnabled(false);
		txtNomeColaborador.setColumns(10);
		
		chkPossuiHabilitacao = new JCheckBox("Possui Habilita\u00E7\u00E3o?");
		chkPossuiHabilitacao.setEnabled(false);
		
		JLabel lblTipoHabilitacao = new JLabel("Tipo de Habilita\u00E7\u00E3o:");
		lblTipoHabilitacao.setVerticalAlignment(SwingConstants.TOP);
		lblTipoHabilitacao.setHorizontalAlignment(SwingConstants.LEFT);
		
		txtTipoHabilitacao = new JTextField();
		txtTipoHabilitacao.setEnabled(false);
		txtTipoHabilitacao.setColumns(10);
		
		JLabel lblDataAdmissao = new JLabel("Data de Admiss\u00E3o:");
		
		txtDataAdmissao = new JTextField();
		txtDataAdmissao.setEnabled(false);
		txtDataAdmissao.setColumns(10);
		
		JLabel lblDataDemissao = new JLabel("Data de Demiss\u00E3o:");
		
		txtDataDemissao = new JTextField();
		txtDataDemissao.setEnabled(false);
		txtDataDemissao.setColumns(10);

		JLabel lblStatus = new JLabel("Status:");
		
		cmbStatus = new JComboBox();
		cmbStatus.setEnabled(false);
		cmbStatus.setModel(new DefaultComboBoxModel(new String[] {"Ativo", "Inativo", "Demitido"}));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblStatus, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNomeColaborador, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(lblDataDemissao, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblDataAdmissao, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblTipoHabilitacao, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)))
							.addGap(14)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtNomeColaborador, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(cmbStatus, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(txtDataDemissao, Alignment.LEADING)
									.addComponent(txtDataAdmissao, Alignment.LEADING)
									.addComponent(txtTipoHabilitacao, Alignment.LEADING))))
						.addComponent(chkPossuiHabilitacao, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(82, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNomeColaborador)
						.addComponent(txtNomeColaborador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTipoHabilitacao)
						.addComponent(txtTipoHabilitacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDataAdmissao)
						.addComponent(txtDataAdmissao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDataDemissao)
						.addComponent(txtDataDemissao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStatus)
						.addComponent(cmbStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chkPossuiHabilitacao)
					.addContainerGap(35, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
	}
}
