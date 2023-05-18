package view;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import controller.ClienteController;
import controller.EnderecoController;
import model.exception.CampoInvalidoException;
import model.exception.CpfJaUtilizadoException;
import model.exception.EnderecoInvalidoException;
import model.vo.telefonia.Cliente;
import model.vo.telefonia.Endereco;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;

import java.text.ParseException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.event.ActionEvent;

public class PainelCadastroCliente extends JPanel {
	private Cliente cliente;
	private JTextField txtNome;
	private JButton btnVoltar;
	private JButton btnSalvar;
	private JComboBox cbEndereco;
	private JLabel lblEndereco;
	private JFormattedTextField ftxtCpf;
	private MaskFormatter mascaraCpf;
	private JLabel lblCpf;
	private JLabel lblNome;
	private JLabel lblNovoCliente;

	/**
	 * Create the panel.
	 */
	public PainelCadastroCliente(Cliente clienteParaEditar) {
		if(clienteParaEditar != null) {
			this.cliente = clienteParaEditar;
		}else {
			this.cliente = new Cliente();
		}
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mascaraCpf.setValueContainsLiteralCharacters(false);
		
		lblNovoCliente = new JLabel(cliente.getId() == 0 ? "NOVO CLIENTE": "EDIÇÃO DE CLIENTE");
		lblNovoCliente.setFont(new Font("Calibri", Font.BOLD, 18));
		lblNovoCliente.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblNovoCliente, "4, 2, 9, 1, center, default");
		
		lblNome = new JLabel("Nome:");
		add(lblNome, "8, 4, right, default");
		
		txtNome = new JTextField();
		add(txtNome, "10, 4, 3, 1, fill, default");
		txtNome.setColumns(10);
		
		lblCpf = new JLabel("CPF:");
		add(lblCpf, "8, 6, right, default");
		
		ftxtCpf = new JFormattedTextField(mascaraCpf);
		add(ftxtCpf, "10, 6, 3, 1, fill, default");
		
		lblEndereco = new JLabel("Endereço:");
		add(lblEndereco, "8, 8, right, default");
		
		EnderecoController controller = new EnderecoController();
		
		cbEndereco = new JComboBox(controller.consultarTodos().toArray());
		add(cbEndereco, "10, 8, 3, 1, fill, default");
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente novoCliente = new Cliente();
				novoCliente.setNome(txtNome.getText());
				
				try {
					String cpfSemMascara = (String) mascaraCpf.stringToValue(
							ftxtCpf.getText());
					novoCliente.setCpf(cpfSemMascara);
				} catch (ParseException e1) {
					JOptionPane.showMessageDialog(null, "Erro ao converter o CPF", 
							"Erro", JOptionPane.ERROR_MESSAGE); 
				}
				novoCliente.setEndereco((Endereco) cbEndereco.getSelectedItem());
				
				ClienteController controller = new ClienteController();
			
				try {
					controller.inserir(novoCliente);
					
					JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!", 
							"Sucesso", JOptionPane.INFORMATION_MESSAGE);
				} catch (CpfJaUtilizadoException | EnderecoInvalidoException | CampoInvalidoException excecao) {
					JOptionPane.showMessageDialog(null, excecao.getMessage(), 
							"Erro", JOptionPane.ERROR_MESSAGE); 
				}
			}
		});
		add(btnSalvar, "10, 12");
		
		btnVoltar = new JButton("Voltar");
		add(btnVoltar, "12, 12");

		if(this.cliente.getId() != 0) {
			preencherCamposDaTela();
		}
	}
	
	public JButton getBtnVoltar() {
		return btnVoltar;
	}
	private void preencherCamposDaTela() {
		this.ftxtCpf.setText(this.cliente.getCpf());
		this.txtNome.setText(this.cliente.getNome());
		this.cbEndereco.setSelectedItem(this.cliente.getEndereco());
	}

}
