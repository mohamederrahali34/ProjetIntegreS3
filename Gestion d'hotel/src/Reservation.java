import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.DropMode;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JScrollPane;

public class Reservation {

	private JFrame frmReservation;
	/**
	 * @wbp.nonvisual location=-28,119
	 */
	private final JTextField textField = new JTextField();
	private JTextField txtNom;
	private JTextField txtPrnom;
	private JTextField txtCin;
	private JTextField txtTlephone;
	private JTable table;
	/**
	 * @wbp.nonvisual location=-38,129
	 */
	private final JTextField textField_1 = new JTextField();
	private JTextField textField_2;
	private JTextField textField_3;

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
		textField_1.setColumns(10);
		textField.setColumns(10);
		frmReservation = new JFrame();
		frmReservation.setTitle("Reservation");
		frmReservation.getContentPane().setBackground(new Color(0, 0, 255));
		frmReservation.setBounds(100, 100, 791, 480);
		frmReservation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{120, 136, 108, 0, 104, 0};
		gridBagLayout.rowHeights = new int[]{40, 0, 0, 0, 0, 0, 0, 249, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmReservation.getContentPane().setLayout(gridBagLayout);
		
		JButton btnNewButton = new JButton("Reservation");
		btnNewButton.setForeground(SystemColor.controlText);
		btnNewButton.setBackground(SystemColor.activeCaptionText);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JLabel lblNewLabel_6 = new JLabel("Reservation");
		lblNewLabel_6.setBackground(SystemColor.textHighlight);
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.gridwidth = 5;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 0;
		frmReservation.getContentPane().add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		JLabel lblNewLabel = new JLabel("Nom");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		frmReservation.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		txtNom = new JTextField();
		GridBagConstraints gbc_txtNom = new GridBagConstraints();
		gbc_txtNom.insets = new Insets(0, 0, 5, 5);
		gbc_txtNom.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNom.gridx = 2;
		gbc_txtNom.gridy = 1;
		frmReservation.getContentPane().add(txtNom, gbc_txtNom);
		txtNom.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Pr\u00E9nom");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.gridx = 3;
		gbc_lblNewLabel_2.gridy = 1;
		frmReservation.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txtPrnom = new JTextField();
		GridBagConstraints gbc_txtPrnom = new GridBagConstraints();
		gbc_txtPrnom.insets = new Insets(0, 0, 5, 0);
		gbc_txtPrnom.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPrnom.gridx = 4;
		gbc_txtPrnom.gridy = 1;
		frmReservation.getContentPane().add(txtPrnom, gbc_txtPrnom);
		txtPrnom.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CIN");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		frmReservation.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txtCin = new JTextField();
		GridBagConstraints gbc_txtCin = new GridBagConstraints();
		gbc_txtCin.insets = new Insets(0, 0, 5, 5);
		gbc_txtCin.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCin.gridx = 2;
		gbc_txtCin.gridy = 2;
		frmReservation.getContentPane().add(txtCin, gbc_txtCin);
		txtCin.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("T\u00E9lephone");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.gridx = 3;
		gbc_lblNewLabel_3.gridy = 2;
		frmReservation.getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		txtTlephone = new JTextField();
		GridBagConstraints gbc_txtTlephone = new GridBagConstraints();
		gbc_txtTlephone.insets = new Insets(0, 0, 5, 0);
		gbc_txtTlephone.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTlephone.gridx = 4;
		gbc_txtTlephone.gridy = 2;
		frmReservation.getContentPane().add(txtTlephone, gbc_txtTlephone);
		txtTlephone.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Nombre de nuits");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 3;
		frmReservation.getContentPane().add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 3;
		frmReservation.getContentPane().add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Nombre de personnes");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 3;
		gbc_lblNewLabel_5.gridy = 3;
		frmReservation.getContentPane().add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 4;
		gbc_textField_3.gridy = 3;
		frmReservation.getContentPane().add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Valider");
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.gridwidth = 4;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_3.gridx = 1;
		gbc_btnNewButton_3.gridy = 4;
		frmReservation.getContentPane().add(btnNewButton_3, gbc_btnNewButton_3);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 5;
		frmReservation.getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Rooms");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 6;
		frmReservation.getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 5;
		frmReservation.getContentPane().add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setCellSelectionEnabled(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", "Morad", "Hamdi", "0674839923", "1", "1"},
				{"2", "Hicham", "Abir", "0673485395", "2", "2"},
				{"3", "Karim", "Idrissi", "0634782387", "1", null},
				{"4", null, null, null, null, null},
				{"5", null, null, null, null, null},
				{"6", null, null, null, null, null},
				{"7", null, null, null, null, null},
				{"8", null, null, null, null, null},
				{"9", null, null, null, null, null},
				{"10", null, null, null, null, null},
				{"11", null, null, null, null, null},
				{"12", null, null, null, null, null},
				{"13", null, null, null, null, null},
				{"14", null, null, null, null, null},
				{"15", null, null, null, null, null},
				{"16", null, null, null, null, null},
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
				"ID", "Nom", "Pr\u00E9nom", "T\u00E9lephone", "Nombre de nuits", "Nombre de personnes"
			}
		));
		
		JButton btnNewButton_2 = new JButton("Customer List");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_2.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 7;
		frmReservation.getContentPane().add(btnNewButton_2, gbc_btnNewButton_2);
	}

}
