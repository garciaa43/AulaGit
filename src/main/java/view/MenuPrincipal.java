package view;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				MenuPrincipal frame = new MenuPrincipal();
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				try {
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
	public MenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JMenu mnCliente = new JMenu("Cadastro Cliente");
		mnCliente.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/icones/Hopstarter-Soft-Scraps-User-Coat-Red.48.png")));
		menuBar.add(mnCliente);
		
		JMenuItem mntmListarCliente = new JMenuItem("Listar");
		mntmListarCliente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));
		mntmListarCliente.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/icones/Colebemis-Feather-List.24.png")));
		mnCliente.add(mntmListarCliente);
		
		JMenuItem mntmCadastroCliente = new JMenuItem("Cadastro");
		mntmCadastroCliente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0));
		mntmCadastroCliente.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/icones/Colebemis-Feather-Edit-3.24.png")));
		mnCliente.add(mntmCadastroCliente);
		
		JMenu mnTelefone = new JMenu("Telefone");
		mnTelefone.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/icones/Hopstarter-Mp3-Player-Creative-Zen-Micro-Black.48.png")));
		menuBar.add(mnTelefone);
		
		JMenuItem mntmListarTel = new JMenuItem("Listar");
		mntmListarTel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));
		mntmListarTel.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/icones/Colebemis-Feather-List.24.png")));
		mnTelefone.add(mntmListarTel);
		
		JMenuItem mntmCadastroTel = new JMenuItem("Cadastro");
		mntmCadastroTel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0));
		mntmCadastroTel.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/icones/Colebemis-Feather-Edit-3.24.png")));
		mnTelefone.add(mntmCadastroTel);
		
		JMenu mnEndereco = new JMenu("Endereço");
		mnEndereco.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/icones/Hopstarter-Sleek-Xp-Basic-Home.48.png")));
		menuBar.add(mnEndereco);
		
		JMenuItem mntmListarEnd = new JMenuItem("Listar");
		mntmListarEnd.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F7, 0));
		mntmListarEnd.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/icones/Colebemis-Feather-List.24.png")));
		mnEndereco.add(mntmListarEnd);
		
		JMenuItem mntmCadastroEnd = new JMenuItem("Cadastro");
		mntmCadastroEnd.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F8, 0));
		mntmCadastroEnd.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/icones/Colebemis-Feather-Edit-3.24.png")));
		mnEndereco.add(mntmCadastroEnd);
		
		JMenu mnNewMenu = new JMenu("Sobre");
		mnNewMenu.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/icones/Oxygen-Icons.org-Oxygen-Actions-help-about.48.png")));
		menuBar.add(mnNewMenu);
	
		
		setContentPane(contentPane);
	}

}
