package view;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.ClienteController;
import controller.TelefoneController;
import model.vo.telefonia.Cliente;
import model.vo.telefonia.Telefone;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroTelefone {

	private JFrame frmNovoTelefone;
	private JTextField txtDdd;
	private JTextField txtNum;
	private JLabel lblDdd;
	private JLabel lblNumero;
	private JLabel lblMovel;
	private JCheckBox checkBoxMovel;
	private JLabel lblDono;
	private JComboBox cbDono;
	private JButton btnSalvar;
	private List<Cliente> cliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroTelefone window = new TelaCadastroTelefone();
					window.frmNovoTelefone.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroTelefone() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNovoTelefone = new JFrame();
		frmNovoTelefone.setTitle("Novo Telefone");
		frmNovoTelefone.setBounds(100, 100, 315, 235);
		frmNovoTelefone.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNovoTelefone.getContentPane().setLayout(null);
		
		lblDdd = new JLabel("DDD:");
		lblDdd.setBounds(10, 11, 46, 14);
		frmNovoTelefone.getContentPane().add(lblDdd);
		
		txtDdd = new JTextField();
		txtDdd.setBounds(42, 8, 86, 20);
		frmNovoTelefone.getContentPane().add(txtDdd);
		txtDdd.setColumns(10);
		
		lblNumero = new JLabel("Número:");
		lblNumero.setBounds(10, 36, 76, 14);
		frmNovoTelefone.getContentPane().add(lblNumero);
		
		txtNum = new JTextField();
		txtNum.setBounds(72, 33, 116, 20);
		frmNovoTelefone.getContentPane().add(txtNum);
		txtNum.setColumns(10);
		
		lblMovel = new JLabel("Móvel");
		lblMovel.setBounds(10, 61, 46, 14);
		frmNovoTelefone.getContentPane().add(lblMovel);
		
		checkBoxMovel = new JCheckBox("");
		checkBoxMovel.setBounds(42, 57, 97, 23);
		frmNovoTelefone.getContentPane().add(checkBoxMovel);
		
		lblDono = new JLabel("Dono:");
		lblDono.setBounds(10, 86, 46, 14);
		frmNovoTelefone.getContentPane().add(lblDono);
		
		ClienteController controller = new ClienteController();
		List<Cliente> clienteCadastrados = controller.consultarTodosPorId();
		
		cbDono = new JComboBox(clienteCadastrados.toArray());
		cbDono.setSelectedIndex(-1);
		cbDono.setBounds(52, 86, 200, 22);
		frmNovoTelefone.getContentPane().add(cbDono);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Telefone telefone = new Telefone();
			telefone.setDdd(txtDdd.getText());
			telefone.setNumero(txtNum.getText());
			telefone.setMovel(checkBoxMovel.isSelected());
			telefone.setId((Integer) cbDono.getSelectedItem());
			
			TelefoneController controller = new TelefoneController();
			
				controller.inserir(telefone);
			 
			
			}
		});
		btnSalvar.setBounds(99, 136, 89, 23);
		frmNovoTelefone.getContentPane().add(btnSalvar);
		
		
	}
}
