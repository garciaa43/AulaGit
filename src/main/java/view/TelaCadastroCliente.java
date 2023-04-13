package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import model.exception.CampoInvalidoException;
import model.exception.CpfJaUtilizadoException;
import model.exception.EnderecoInvalidoException;
import controller.ClienteController;
import controller.EnderecoController;
import model.dao.telefonia.EnderecoDAO;
import model.vo.telefonia.Cliente;
import model.vo.telefonia.Endereco;
import java.awt.Color;

public class TelaCadastroCliente {

	private JFrame frmTelaDeCadastramento;
	private JTextField txtNome;
	private JLabel lblNome;
	private JLabel lblCPF;
	private JFormattedTextField formattedTxtCPF;
	private JLabel lblEndereco;
	private JComboBox cbEndereco;
	
	private List<Endereco> enderecos;
	private MaskFormatter mascaraCpf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroCliente window = new TelaCadastroCliente();
					window.frmTelaDeCadastramento.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaDeCadastramento = new JFrame();
		frmTelaDeCadastramento.getContentPane().setBackground(new Color(128, 128, 255));
		frmTelaDeCadastramento.setTitle("Tela de cadastramento de cliente");
		frmTelaDeCadastramento.setBounds(100, 100, 365, 260);
		frmTelaDeCadastramento.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaDeCadastramento.getContentPane().setLayout(null);
		
			try {
				mascaraCpf = new MaskFormatter("###.###.###-##");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mascaraCpf.setValueContainsLiteralCharacters(false);
			
			
			lblNome = new JLabel("Nome:");
			lblNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNome.setBounds(10, 11, 46, 14);
			frmTelaDeCadastramento.getContentPane().add(lblNome);
			
			lblCPF = new JLabel("CPF:");
			lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblCPF.setBounds(10, 56, 46, 14);
			frmTelaDeCadastramento.getContentPane().add(lblCPF);
			
			txtNome = new JTextField();
			txtNome.setBounds(54, 9, 285, 20);
			frmTelaDeCadastramento.getContentPane().add(txtNome);
			txtNome.setColumns(10);
			
			formattedTxtCPF = new JFormattedTextField(mascaraCpf);
			formattedTxtCPF.setBounds(54, 54, 104, 20);
			frmTelaDeCadastramento.getContentPane().add(formattedTxtCPF);
			
			lblEndereco = new JLabel("Endereço:");
			lblEndereco.setBounds(10, 97, 59, 14);
			frmTelaDeCadastramento.getContentPane().add(lblEndereco);
			
			EnderecoController controller = new EnderecoController();
			List<Endereco> enderecosCadastrados = controller.consultarTodos();
			
			cbEndereco = new JComboBox(enderecosCadastrados.toArray());
			cbEndereco.setSelectedIndex(-1);
			cbEndereco.setBounds(79, 93, 260, 22);
			frmTelaDeCadastramento.getContentPane().add(cbEndereco);
			
			JButton btnSalvar = new JButton("Salvar");
			btnSalvar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Cliente novoCliente = new Cliente();
					novoCliente.setNome(txtNome.getText());
					try {
						String cpfSemMascara = (String) mascaraCpf.stringToValue(formattedTxtCPF.getText());
						novoCliente.setCpf(cpfSemMascara);
					} catch (ParseException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					novoCliente.setEndereco((Endereco) cbEndereco.getSelectedItem());
					ClienteController controller = new ClienteController();
					try {
						controller.inserir(novoCliente);
						
						JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!");
					} catch (CpfJaUtilizadoException | EnderecoInvalidoException | CampoInvalidoException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
						e1.printStackTrace();
					}
				}
			});
			btnSalvar.setBackground(new Color(255, 255, 255));
			btnSalvar.setBounds(111, 168, 89, 23);
			btnSalvar.setOpaque(true);
			frmTelaDeCadastramento.getContentPane().add(btnSalvar);
			
		
	}
}
