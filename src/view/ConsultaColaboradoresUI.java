package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.border.TitledBorder;

import controller.ColaboradorController;
import model.Colaborador;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JList;

public class ConsultaColaboradoresUI extends JInternalFrame {
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
					ConsultaColaboradoresUI frame = new ConsultaColaboradoresUI();
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
	public ConsultaColaboradoresUI() {
		setClosable(true);
		setTitle("Consultar Colaborador");
		setBounds(100, 100, 604, 370);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Colaborador", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
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
						chkPossuiHabilitacao.setSelected(colaborador.getPossuiHabilitacao());
						txtTipoHabilitacao.setText(colaborador.getTipoHabilitacao());
						txtDataAdmissao.setText(colaborador.getDataAdmissao().toString());
						txtDataDemissao.setText(colaborador.getDataDemissao() != null ? colaborador.getDataDemissao().toString() : "");
						for(int i =0; i < cmbStatus.getItemCount(); i++) {
							String status = cmbStatus.getItemAt(i).toString();
							if(status.equalsIgnoreCase(colaborador.getStatus())) {
								cmbStatus.setSelectedIndex(i);
							}
						}
					} else {
						if(txtNomeColaborador != null) {
							txtNomeColaborador.setText("");
						}
						if(txtTipoHabilitacao != null) {
							txtTipoHabilitacao.setText("");							
						}
						if(txtDataAdmissao != null) {
							txtDataAdmissao.setText("");
						}
						if(txtDataDemissao != null) {
							txtDataDemissao.setText("");
						}
						if(chkPossuiHabilitacao != null) {
							chkPossuiHabilitacao.setSelected(false);
						}
						if(cmbStatus != null) {
							cmbStatus.setSelectedItem("Ativo");
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
								.addPreferredGap(ComponentPlacement.RELATED)
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
						.addComponent(btnCancelar))
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
