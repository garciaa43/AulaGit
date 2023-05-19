package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class MenuPrincipal {

	private JFrame frmSistemaDeTelefonia;
	private PainelListagemCliente painelListagemCliente = new PainelListagemCliente();
	private PainelCadastroCliente painelCadastroCliente = new PainelCadastroCliente(null);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal window = new MenuPrincipal();
					//Comando para iniciar a tela maximizada
					window.frmSistemaDeTelefonia.setExtendedState(JFrame.MAXIMIZED_BOTH);
					window.frmSistemaDeTelefonia.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSistemaDeTelefonia = new JFrame();
		frmSistemaDeTelefonia.setTitle("Sistema de Telefonia");
		frmSistemaDeTelefonia.setBounds(100, 100, 450, 300);
		frmSistemaDeTelefonia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmSistemaDeTelefonia.setJMenuBar(menuBar);
		
		JMenu mnCliente = new JMenu("Cliente");
		mnCliente.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/icones/Hopstarter-Soft-Scraps-User-Coat-Red.48.png")));
		menuBar.add(mnCliente);
		
		JMenuItem mntmCadastroCliente = new JMenuItem("Cadastro");
		mntmCadastroCliente.addActionListener(new ActionListener() {
			//Evento de clique no botão -> instancia o painel e troca
			//TODO arrumar bug, pois não aparece a tela
			public void actionPerformed(ActionEvent e) {
				painelCadastroCliente = new PainelCadastroCliente(null);
				painelCadastroCliente.setVisible(true);
				frmSistemaDeTelefonia.setContentPane(painelCadastroCliente);
				frmSistemaDeTelefonia.revalidate();
			}
		});
		mntmCadastroCliente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));
		mntmCadastroCliente.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/icones/Colebemis-Feather-Edit-3.24.png")));
		mnCliente.add(mntmCadastroCliente);
		
		JMenuItem mntmListarCliente = new JMenuItem("Listagem");
		mntmListarCliente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0));
		mntmListarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelListagemCliente = new PainelListagemCliente();
				painelListagemCliente.getBtnEditar().addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						painelCadastroCliente = new PainelCadastroCliente(painelListagemCliente.getClienteSelecionado());
						painelCadastroCliente.setVisible(true);
						frmSistemaDeTelefonia.setContentPane(painelCadastroCliente);
						frmSistemaDeTelefonia.revalidate();
						registrarCliqueVoltarPainelCadastroCliente();
					}
				});
				painelListagemCliente.setVisible(true);
				frmSistemaDeTelefonia.setContentPane(painelListagemCliente);
			}
		});
		mntmListarCliente.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/icones/Colebemis-Feather-List.24.png")));
		mnCliente.add(mntmListarCliente);
		
		JMenu mnTelefone = new JMenu("Telefone");
		mnTelefone.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/icones/Hopstarter-Mp3-Player-Creative-Zen-Micro-Black.48.png")));
		menuBar.add(mnTelefone);
		
		JMenuItem mntmCadastroTelefone = new JMenuItem("Cadastro");
		mntmCadastroTelefone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mntmCadastroTelefone.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));
		mntmCadastroTelefone.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/icones/Colebemis-Feather-Edit-3.24.png")));
		mnTelefone.add(mntmCadastroTelefone);
		
		JMenuItem mntmListagemTelefone = new JMenuItem("Listagem");
		mntmListagemTelefone.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0));
		mntmListagemTelefone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Evento de clique no botão -> instancia o painel e troca
				PainelListagemTelefone painelListagemTelefone = new PainelListagemTelefone();
				frmSistemaDeTelefonia.setContentPane(painelListagemTelefone);
			}
		});
		mntmListagemTelefone.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/icones/Colebemis-Feather-List.24.png")));
		mnTelefone.add(mntmListagemTelefone);
		
		JMenu mnEndereco = new JMenu("Endereço");
		mnEndereco.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/icones/Hopstarter-Sleek-Xp-Basic-Home.48.png")));
		menuBar.add(mnEndereco);
		
		JMenuItem mntmCadastroEndereco = new JMenuItem("Cadastro");
		mntmCadastroEndereco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PainelCadastroEndereco painelCadastroEndereco = new PainelCadastroEndereco();
				painelCadastroEndereco.setVisible(true);
				frmSistemaDeTelefonia.setContentPane(painelCadastroEndereco);
				painelCadastroEndereco.revalidate();
			}
		});
		mntmCadastroEndereco.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F7, 0));
		mntmCadastroEndereco.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/icones/Colebemis-Feather-Edit-3.24.png")));
		mnEndereco.add(mntmCadastroEndereco);
		
		JMenuItem mntmListagemEndereco = new JMenuItem("Listagem");
		mntmListagemEndereco.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F8, 0));
		mntmListagemEndereco.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/icones/Colebemis-Feather-List.24.png")));
		mnEndereco.add(mntmListagemEndereco);
		
		JMenu mnSobre = new JMenu("Sobre");
		mnSobre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//TODO chamar TelaSobreAutor
				JOptionPane.showMessageDialog(null, "Olá");
			}
		});
		
		
		mnSobre.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/icones/Oxygen-Icons.org-Oxygen-Actions-help-about.48.png")));
		menuBar.add(mnSobre);
		registrarCliqueVoltarPainelCadastroCliente();
	}
	
	public void registrarCliqueVoltarPainelCadastroCliente() {
		painelCadastroCliente.getBtnVoltar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				painelListagemCliente.setVisible(true);
				frmSistemaDeTelefonia.setContentPane(painelListagemCliente);
				frmSistemaDeTelefonia.revalidate();
			}
		});
	}
}
