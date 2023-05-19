package view;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import controller.EnderecoController;
import model.exception.CampoInvalidoException;
import model.vo.telefonia.Endereco;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PainelCadastroEndereco extends JPanel {
	private JTextField txtCep;
	private JTextField txtRua;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtNumero;
	private JLabel lblEstado;
	private JComboBox cbEndereco;
	private JLabel lblNumero;
	private JLabel lblCidade;
	private JLabel lblBairro;
	private JLabel lblRua;
	private JLabel lblCep;

	private Endereco endereco;
	
	
	private String[] estados = {"PR", "RS", "SC"};
	
	/**
	 * Create the panel.
	 */
	public PainelCadastroEndereco() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:default:grow"),},
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
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		lblCep = new JLabel("CEP:");
		add(lblCep, "6, 4, right, default");
		
		txtCep = new JTextField();
		add(txtCep, "8, 4, 9, 1, fill, default");
		txtCep.setColumns(10);
		
		lblRua = new JLabel("Rua:");
		add(lblRua, "6, 6, right, default");
		
		txtRua = new JTextField();
		add(txtRua, "8, 6, 9, 1, fill, default");
		txtRua.setColumns(10);
		
		lblBairro = new JLabel("Bairro:");
		add(lblBairro, "6, 8, right, default");
		
		txtBairro = new JTextField();
		add(txtBairro, "8, 8, 9, 1, fill, default");
		txtBairro.setColumns(10);
		
		lblCidade = new JLabel("Cidade:");
		add(lblCidade, "6, 10, right, default");
		
		txtCidade = new JTextField();
		add(txtCidade, "8, 10, 9, 1, fill, default");
		txtCidade.setColumns(10);
		
		lblNumero = new JLabel("Numero:");
		add(lblNumero, "6, 12, right, default");
		
		txtNumero = new JTextField();
		add(txtNumero, "8, 12, 9, 1, fill, default");
		txtNumero.setColumns(10);
		
		lblEstado = new JLabel("Estado:");
		add(lblEstado, "6, 14, right, default");
		
		cbEndereco = new JComboBox(estados);
		cbEndereco.setSelectedIndex(-1);
		add(cbEndereco, "8, 14, fill, default");
	
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean edicao = false;
				if(endereco == null) {
					//Cadastro de novo endereço
					endereco = new Endereco();
				}else {
					//Edição de endereço passado por parâmetro no construtor
					edicao = true;
				}
				
				endereco.setCep(txtCep.getText());
				endereco.setRua(txtRua.getText());
				endereco.setNumero(txtNumero.getText());
				endereco.setCidade(txtCidade.getText());
				endereco.setEstado((String) cbEndereco.getSelectedItem());
				endereco.setBairro(txtBairro.getText());
				
				EnderecoController controller = new EnderecoController();
				try {
					//Alterado aqui para contemplar tanto edição quanto cadastro de endereço
					if(edicao) {
						controller.atualizar(endereco);
					}else {
						controller.inserir(endereco);
						limparTela();
					}
					JOptionPane.showMessageDialog(null, "Endereço:" + (edicao ? " atualizado " : " criado ") + "com sucesso!",
														"Sucesso", JOptionPane.INFORMATION_MESSAGE);
				} catch (CampoInvalidoException e1) {
					JOptionPane.showMessageDialog(null,  "Preencha os seguintes campos: \n" + e1.getMessage(), 
														 "Atenção", JOptionPane.WARNING_MESSAGE);
				}
			}

			
			
		});
		add(btnSalvar, "10, 16, 3, 1");

		
		if(endereco != null) {
			txtCep.setText(endereco.getCep());
			txtRua.setText(endereco.getRua());
			txtNumero.setText(endereco.getNumero());
			txtCidade.setText(endereco.getCidade());
			txtBairro.setText(endereco.getBairro());
			
			cbEndereco.setSelectedItem(endereco.getEstado());
		}
		
	}
	
	private void limparTela() {
		this.endereco = null;
		txtCep.setText("");
		txtRua.setText("");
		txtNumero.setText("");
		txtCidade.setText("");
		txtBairro.setText("");
		cbEndereco.setSelectedItem(null);
		
	}	
}
