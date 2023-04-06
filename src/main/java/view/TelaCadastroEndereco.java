package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import model.vo.telefonia.Endereco;

import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JButton;

public class TelaCadastroEndereco {

	private JFrame frmCadastroDeEndereco;
	private Label lbCep;
	private Label lbRua;
	private Label lbBairro;
	private Label lbNumero;
	private Label lbCidade;
	private Label lbEstado;
	
	//TODO chamar API ou backend futuramente
	private String[] estados = {"Paraná", "Rio Grande do Sul", "Santa Catarina"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroEndereco window = new TelaCadastroEndereco();
					window.frmCadastroDeEndereco.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroEndereco() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDeEndereco = new JFrame();
		frmCadastroDeEndereco.setTitle("Cadastro de endereço");
		frmCadastroDeEndereco.setBounds(100, 100, 400, 280);
		frmCadastroDeEndereco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroDeEndereco.getContentPane().setLayout(null);
		
		lbCep = new Label("CEP:");
		lbCep.setBounds(15, 15, 36, 14);
		frmCadastroDeEndereco.getContentPane().add(lbCep);
		
		lbRua = new Label("Rua:");
		lbRua.setBounds(15, 40, 36, 22);
		frmCadastroDeEndereco.getContentPane().add(lbRua);
		
		TextField textCep = new TextField();
		textCep.setBounds(62, 10, 306, 22);
		frmCadastroDeEndereco.getContentPane().add(textCep);
		
		lbBairro = new Label("Bairro:");
		lbBairro.setBounds(15, 65, 36, 22);
		frmCadastroDeEndereco.getContentPane().add(lbBairro);
		
		lbNumero = new Label("Número:");
		lbNumero.setBounds(15, 90, 46, 22);
		frmCadastroDeEndereco.getContentPane().add(lbNumero);
		
		lbCidade = new Label("Cidade:");
		lbCidade.setBounds(15, 115, 46, 22);
		frmCadastroDeEndereco.getContentPane().add(lbCidade);
		
		lbEstado = new Label("Estado:");
		lbEstado.setBounds(15, 140, 46, 22);
		frmCadastroDeEndereco.getContentPane().add(lbEstado);
		
		TextField textRua = new TextField();
		textRua.setBounds(62, 35, 306, 22);
		frmCadastroDeEndereco.getContentPane().add(textRua);
		
		TextField textBairro = new TextField();
		textBairro.setBounds(62, 65, 306, 22);
		frmCadastroDeEndereco.getContentPane().add(textBairro);
		
		TextField textNumero = new TextField();
		textNumero.setBounds(62, 90, 306, 22);
		frmCadastroDeEndereco.getContentPane().add(textNumero);
		
		TextField textCidade = new TextField();
		textCidade.setBounds(62, 115, 306, 22);
		frmCadastroDeEndereco.getContentPane().add(textCidade);
		
		JComboBox cbEstado = new JComboBox(estados);
		cbEstado.setToolTipText("Selecione");
		cbEstado.setSelectedIndex(-1);
		cbEstado.setBounds(62, 140, 306, 22);
		frmCadastroDeEndereco.getContentPane().add(cbEstado);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(153, 173, 89, 23);
		frmCadastroDeEndereco.getContentPane().add(btnSalvar);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Endereco endereco = new Endereco();
				endereco.setCep(txtCep.getText());
			}
		});
		
	}
}
