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
import java.awt.Font;

public class Reservation {

	private JFrame frmReservation;     
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtPrnom;
	private JTextField textField_2;
	private JTable table;
	private JTextField textField_3;
	private JTextField textField_4;

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
	 * Create the application.h
	 */
	public Reservation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmReservation =  new JFrame();
		frmReservation.getContentPane().setBackground(new Color(102, 0, 255));
		frmReservation.setBounds(100, 100, 853, 498);
		frmReservation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmReservation.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("max(6dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(78dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(107dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(80dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(109dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(129dlu;default):grow"),},
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
				RowSpec.decode("max(155dlu;default)"),}));
		
		Label label = new Label("Reservation");
		label.setFont(new Font("Dialog", Font.PLAIN, 15));
		frmReservation.getContentPane().add(label, "5, 2, right, default");
		
		JLabel lblNewLabel = new JLabel("Nom");
		frmReservation.getContentPane().add(lblNewLabel, "5, 4, right, default");
		
		textField = new JTextField();
		frmReservation.getContentPane().add(textField, "7, 4, fill, default");
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Pr\u00E9nom");
		frmReservation.getContentPane().add(lblNewLabel_2, "9, 4, right, default");
		
		txtPrnom = new JTextField();
		frmReservation.getContentPane().add(txtPrnom, "11, 4, left, default");
		txtPrnom.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CIN");
		frmReservation.getContentPane().add(lblNewLabel_1, "5, 6, right, default");
		
		textField_1 = new JTextField();
		frmReservation.getContentPane().add(textField_1, "7, 6, fill, default");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("T\u00E9lephone");
		frmReservation.getContentPane().add(lblNewLabel_3, "9, 6, right, default");
		
		textField_2 = new JTextField();
		frmReservation.getContentPane().add(textField_2, "11, 6, left, default");
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Nombre de nuits");
		frmReservation.getContentPane().add(lblNewLabel_4, "5, 8, right, default");
		
		textField_3 = new JTextField();
		frmReservation.getContentPane().add(textField_3, "7, 8, fill, default");
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Nombre de personnes");
		frmReservation.getContentPane().add(lblNewLabel_5, "9, 8, right, default");
		
		textField_4 = new JTextField();
		frmReservation.getContentPane().add(textField_4, "11, 8, left, default");
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("Valider");
		frmReservation.getContentPane().add(btnNewButton, "7, 10");
		
		JButton btnNewButton_1 = new JButton("Reservation");
		frmReservation.getContentPane().add(btnNewButton_1, "3, 12");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		frmReservation.getContentPane().add(scrollPane_1, "5, 12, 7, 5, fill, fill");
		
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
		frmReservation.getContentPane().add(btnNewButton_2, "3, 14");
		
		JButton btnNewButton_3 = new JButton("Custemer List");
		frmReservation.getContentPane().add(btnNewButton_3, "3, 16, default, top");
	}

}
