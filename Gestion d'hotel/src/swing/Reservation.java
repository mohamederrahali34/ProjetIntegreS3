package swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.ScrollPane;
import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Label;
import java.awt.Button;
import javax.swing.JScrollPane;

public class Reservation {

	private JFrame frmReservation;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtPrnom;
	private JTextField textField_2;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reservation window = new Reservation();
					window.frmReservation.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Reservation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmReservation = new JFrame();
		frmReservation.getContentPane().setBackground(Color.WHITE);
		frmReservation.setTitle("Reservation");
		frmReservation.setBounds(100, 100, 729, 498);
		frmReservation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmReservation.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("max(78dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(107dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(78dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
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
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(155dlu;default)"),}));
		
		Label label = new Label("Reservation");
		frmReservation.getContentPane().add(label, "3, 2");
		
		JLabel lblNewLabel = new JLabel("Nom");
		frmReservation.getContentPane().add(lblNewLabel, "3, 4, right, default");
		
		textField = new JTextField();
		frmReservation.getContentPane().add(textField, "5, 4, fill, default");
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Pr\u00E9nom");
		frmReservation.getContentPane().add(lblNewLabel_2, "7, 4, right, default");
		
		txtPrnom = new JTextField();
		frmReservation.getContentPane().add(txtPrnom, "9, 4, fill, default");
		txtPrnom.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CIN");
		frmReservation.getContentPane().add(lblNewLabel_1, "3, 6, right, default");
		
		textField_1 = new JTextField();
		frmReservation.getContentPane().add(textField_1, "5, 6, fill, default");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("T\u00E9lephone");
		frmReservation.getContentPane().add(lblNewLabel_3, "7, 6, right, default");
		
		textField_2 = new JTextField();
		frmReservation.getContentPane().add(textField_2, "9, 6, fill, default");
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Valider");
		frmReservation.getContentPane().add(btnNewButton, "5, 8");
		
		JButton btnNewButton_1 = new JButton("Reservation");
		frmReservation.getContentPane().add(btnNewButton_1, "1, 10");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		frmReservation.getContentPane().add(scrollPane_1, "3, 10, 7, 5, fill, fill");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", "Hachimi", "Ahmed", "0637428846", "3", "2"},
				{"2", "Idrissi", "Anouar", "0674885278", "2", "1"},
				{"3", "Mosaid", "Mohamed", "0623781348", "1", null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"CIN", "Nom", "Pr\u00E9nom", "T\u00E9lephone", "Nombre de nuits", "Nombre de personnes"
			}
		));
		
		JButton btnNewButton_2 = new JButton("Rooms");
		frmReservation.getContentPane().add(btnNewButton_2, "1, 12");
		
		JButton btnNewButton_3 = new JButton("Custemer List");
		frmReservation.getContentPane().add(btnNewButton_3, "1, 14, default, top");
	}

}
