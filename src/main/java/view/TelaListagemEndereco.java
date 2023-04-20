package view;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.EnderecoController;
import model.exception.EnderecoInvalidoException;
import model.vo.telefonia.Endereco;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class TelaListagemEndereco {

	private JFrame frame;
	private String[] nomesColunas = { "#", "CEP", "Rua", "Número", "Bairro", "Cidade", "Estado" };
	private JButton btnEditar;
	private JButton btnExcluir;
	private JButton btnBuscarTodos;
	private JTable tblEnderecos;

	private ArrayList<Endereco> enderecos;
	

	private Endereco enderecoSelecionado;
	
	private EnderecoController enderecoController = new EnderecoController();
	
	private void limparTabela() {
		tblEnderecos.setModel(new DefaultTableModel(new Object[][] { nomesColunas, }, nomesColunas));
	}
	
	private void atualizarTabelaEnderecos() {
		
		EnderecoController controller = new EnderecoController();
		controller.consultarTodos();
		this.limparTabela();

		DefaultTableModel model = (DefaultTableModel) tblEnderecos.getModel();
		//Preenche os valores na tabela linha a linha
		for (Endereco e : enderecos) {
			Object[] novaLinhaDaTabela = new Object[7];
			
			novaLinhaDaTabela[0] = e.getId();
			novaLinhaDaTabela[1] = e.getCep();
			novaLinhaDaTabela[2] = e.getRua();
			novaLinhaDaTabela[3] = e.getNumero();
			novaLinhaDaTabela[4] = e.getBairro();
			novaLinhaDaTabela[5] = e.getCidade();
			novaLinhaDaTabela[6] = e.getEstado();

			model.addRow(novaLinhaDaTabela);
		}
	}	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListagemEndereco window = new TelaListagemEndereco();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaListagemEndereco() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 525);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroEndereco telaEdicaoEndereco = new TelaCadastroEndereco(enderecoSelecionado);
				
			}
		});
		btnEditar.setBounds(194, 434, 127, 41);
		frame.getContentPane().add(btnEditar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcao = JOptionPane.showConfirmDialog(null, "Confirma a exclusão do endereço selecionado?");
				
				if(opcao == JOptionPane.YES_OPTION) {
					try {
						enderecoController.excluir(enderecoSelecionado.getId());
						JOptionPane.showMessageDialog(null, "Endereço excuido", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
					} catch (EnderecoInvalidoException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Atenção", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnExcluir.setBounds(352, 434, 127, 41);
		frame.getContentPane().add(btnExcluir);
		
		btnBuscarTodos = new JButton("Buscar Todos");
		btnBuscarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				atualizarTabelaEnderecos();
			}
		});
		btnBuscarTodos.setBounds(274, 11, 114, 41);
		frame.getContentPane().add(btnBuscarTodos);
		
		tblEnderecos = new JTable();
		tblEnderecos.setBounds(15, 70, 655, 350);
		frame.getContentPane().add(tblEnderecos);
		
		tblEnderecos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int indiceSelecionado = tblEnderecos.getSelectedRow();
				
				if (indiceSelecionado > 0) {
					//Primeira linha da tabela contém o cabeçalho, por isso o '+1' 
					enderecoSelecionado = enderecos.get(indiceSelecionado - 1); 
					btnEditar.setEnabled(true);
					btnExcluir.setEnabled(true);
				} else {
					btnEditar.setEnabled(false);
					btnExcluir.setEnabled(false);
				}
			}
		});
	}
}
