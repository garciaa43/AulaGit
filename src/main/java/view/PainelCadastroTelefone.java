package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.privatejgoodies.forms.layout.ColumnSpec;
import com.privatejgoodies.forms.layout.FormLayout;
import com.privatejgoodies.forms.layout.FormSpecs;
import com.privatejgoodies.forms.layout.RowSpec;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class PainelCadastroTelefone extends JPanel {

	/**
	 * Create the panel.
	 */
	public PainelCadastroTelefone() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
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
		
		JLabel lblTipo = new JLabel("Tipo:");
		add(lblTipo, "6, 4");
		
		JRadioButton rdbtnFixo = new JRadioButton("Fixo");
		add(rdbtnFixo, "10, 4, 2, 1");
		
		JRadioButton tdbtnMovel = new JRadioButton("Móvel");
		add(tdbtnMovel, "12, 4");
		
		JLabel lblNumero = new JLabel("Número:");
		add(lblNumero, "6, 6, right, default");
		
		JFormattedTextField txtMovel = new JFormattedTextField();
		add(txtMovel, "8, 6, 5, 1, fill, default");
		
		JLabel lblCliente = new JLabel("Cliente:");
		add(lblCliente, "6, 8, right, default");
		
		JComboBox comboBox = new JComboBox();
		add(comboBox, "8, 8, 5, 1, fill, default");
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnSalvar, "10, 12");

	}

}
