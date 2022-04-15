package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.ColaboradorController;
import model.Colaborador;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroColaboradoresUI extends JInternalFrame {
	private JTextField txtNomeColaborador;
	private JTextField txtTipoHabilitacao;
	private JCheckBox chkPossuiHabilitacao;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroColaboradoresUI frame = new CadastroColaboradoresUI();
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
	public CadastroColaboradoresUI() {
		setClosable(true);
		setTitle("Cadastro de Colaboradores");
		setBounds(100, 100, 604, 240);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Colaborador", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
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
					Colaborador colaborador = new Colaborador();
					colaborador.setNome(txtNomeColaborador.getText());
					colaborador.setPossuiHabilitacao(chkPossuiHabilitacao.isSelected());
					if(colaborador.getPossuiHabilitacao()) {
						colaborador.setTipoHabilitacao(txtTipoHabilitacao.getText());	
					}
					new ColaboradorController().cadastrarColaborador(colaborador);
					JOptionPane.showMessageDialog(null, "Colaborador Cadastrado com Sucesso");
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
					Colaborador colaborador = new Colaborador();
					colaborador.setNome(txtNomeColaborador.getText());
					colaborador.setPossuiHabilitacao(chkPossuiHabilitacao.isSelected());
					if(colaborador.getPossuiHabilitacao()) {
						colaborador.setTipoHabilitacao(txtTipoHabilitacao.getText());	
					}
					new ColaboradorController().cadastrarColaborador(colaborador);
					JOptionPane.showMessageDialog(null, "Colaborador Cadastrado com Sucesso");
					txtNomeColaborador.setText("");
					txtTipoHabilitacao.setText("");
					chkPossuiHabilitacao.setSelected(false);
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
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSalvaProximo, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 558, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnSalvaProximo)
						.addComponent(btnSalvar))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		
		JLabel lblNomeColaborador = new JLabel("Nome: ");
		lblNomeColaborador.setVerticalAlignment(SwingConstants.TOP);
		lblNomeColaborador.setHorizontalAlignment(SwingConstants.LEFT);
		
		txtNomeColaborador = new JTextField();
		txtNomeColaborador.setColumns(10);
		
		chkPossuiHabilitacao = new JCheckBox("Possui Habilita\u00E7\u00E3o?");
		
		JLabel lblTipoHabilitacao = new JLabel("Tipo de Habilita\u00E7\u00E3o:");
		lblTipoHabilitacao.setVerticalAlignment(SwingConstants.TOP);
		lblTipoHabilitacao.setHorizontalAlignment(SwingConstants.LEFT);
		
		txtTipoHabilitacao = new JTextField();
		txtTipoHabilitacao.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(chkPossuiHabilitacao, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNomeColaborador, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtNomeColaborador, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblTipoHabilitacao)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtTipoHabilitacao, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(70, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNomeColaborador)
						.addComponent(txtNomeColaborador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(chkPossuiHabilitacao)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblTipoHabilitacao))
						.addComponent(txtTipoHabilitacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);

	}
}
