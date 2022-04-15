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

import controller.ChamadoController;
import controller.ColaboradorController;
import model.Chamado;
import model.Colaborador;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class CadastroChamadosUI extends JInternalFrame {
	private JTextArea txtDescricao;
	private JTextField txtNomeSolicitante;
	private JTextField txtEnderecoSolicitante;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroChamadosUI frame = new CadastroChamadosUI();
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
	public CadastroChamadosUI() {
		setClosable(true);
		setTitle("Cadastro de Chamados");
		setBounds(100, 100, 604, 289);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Chamado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
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
					Chamado chamado = new Chamado();
					chamado.setDescricao(txtDescricao.getText());
					chamado.setNomeSolicitante(txtNomeSolicitante.getText());
					chamado.setEnderecoAtendimento(txtEnderecoSolicitante.getText());
					new ChamadoController().criarChamado(chamado);
					JOptionPane.showMessageDialog(null, "Chamado Cadastrado com Sucesso");
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
					Chamado chamado = new Chamado();
					chamado.setDescricao(txtDescricao.getText());
					chamado.setNomeSolicitante(txtNomeSolicitante.getText());
					chamado.setEnderecoAtendimento(txtEnderecoSolicitante.getText());
					new ChamadoController().criarChamado(chamado);
					JOptionPane.showMessageDialog(null, "Chamado Cadastrado com Sucesso");
					txtDescricao.setText("");
					txtNomeSolicitante.setText("");
					txtEnderecoSolicitante.setText("");
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
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnSalvaProximo)
						.addComponent(btnSalvar))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o: ");
		lblDescricao.setVerticalAlignment(SwingConstants.TOP);
		lblDescricao.setHorizontalAlignment(SwingConstants.LEFT);
		
		txtDescricao = new JTextArea();
		txtDescricao.setLineWrap(true);
		
		JLabel lblNomeSolicitante = new JLabel("Nome do Solicitante: ");
		
		txtNomeSolicitante = new JTextField();
		txtNomeSolicitante.setColumns(10);
		
		JLabel lblEnderecoSolicitante = new JLabel("Endere\u00E7o do Solicitante:");
		
		txtEnderecoSolicitante = new JTextField();
		txtEnderecoSolicitante.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDescricao, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDescricao, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEnderecoSolicitante, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNomeSolicitante, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
							.addGap(41)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(txtNomeSolicitante)
								.addComponent(txtEnderecoSolicitante, GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDescricao)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtDescricao, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNomeSolicitante)
						.addComponent(txtNomeSolicitante, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnderecoSolicitante)
						.addComponent(txtEnderecoSolicitante, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
	}
}
