package swing;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Panel;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import javafx.scene.control.ComboBox;

import javax.swing.border.Border;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;
import com.toedter.calendar.JDateChooser;


public class NewResevation extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Statement stm ;
	static int id_exemp ;
	private JTextField textField_1;
	private JTextField textField_6;
	private JTextField textField_7;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer frame = new Customer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public int getId_exemplaire() {
		return id_exemp;
	}

	
	public NewResevation() {
		setType(Type.UTILITY);
		setTitle("Nouvelle R\u00E9servation");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 901, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 230, 467);
		panel.setBackground(new Color(244, 244, 244));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnAfficher = new JButton("Liste des R\u00E9servations");
		
		btnAfficher.setForeground(new Color(255, 255, 224));
		btnAfficher.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAfficher.setBackground(new Color(0, 176, 214));
		btnAfficher.setBounds(10, 184, 210, 56);
		panel.add(btnAfficher);
		
		
		Icon icon = new ImageIcon(Customer.class.getResource("/images/Icons/585e4bf3cb11b227491c339a_a8u_icon.ico"));
		JLabel lblNewLabel = new JLabel(icon);
		
		lblNewLabel.setBounds(29, 492, 80, 36);
		panel.add(lblNewLabel);
		
		
		Panel panel_2 = new Panel();
		panel_2.setBounds(236, 0, 658, 457);
		panel_2.setBackground(Color.WHITE);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(113, 30, 153, 37);
		panel_2.add(textField_1);
		
		JButton search = new JButton("Enregistrer");
		search.setForeground(new Color(255, 255, 224));
		search.setFont(new Font("Tahoma", Font.BOLD, 12));
		search.setBackground(new Color(113, 202, 216));
		search.setBounds(287, 323, 130, 37);
		

		panel_2.add(search);
		
		JLabel lblNewLabel_1 = new JLabel("CIN");
		lblNewLabel_1.setBounds(28, 42, 46, 14);
		panel_2.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Régulier");
		comboBox.addItem("Familiale");
		comboBox.addItem("Suite");
		comboBox.setSelectedIndex(3);
		comboBox.setBounds(113, 78, 153, 37);
		panel_2.add(comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("Chambre");
		lblNewLabel_3.setBounds(28, 89, 46, 14);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Date d'arriv\u00E9e");
		lblNewLabel_4.setBounds(377, 137, 85, 14);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Date de d\u00E9part");
		lblNewLabel_5.setBounds(28, 137, 85, 14);
		panel_2.add(lblNewLabel_5);
		
		textField_6 = new JTextField();
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_6.setColumns(10);
		textField_6.setBounds(495, 30, 153, 37);
		panel_2.add(textField_6);
		
		JLabel lblNewLabel_8 = new JLabel("Nombre de personnes");
		lblNewLabel_8.setForeground(Color.BLACK);
		lblNewLabel_8.setBounds(377, 37, 130, 25);
		panel_2.add(lblNewLabel_8);
		
		textField_7 = new JTextField();
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_7.setColumns(10);
		textField_7.setBounds(495, 78, 153, 37);
		panel_2.add(textField_7);
		
		JLabel lblNewLabel_9 = new JLabel("Nombre de jours");
		lblNewLabel_9.setBounds(377, 83, 113, 26);
		panel_2.add(lblNewLabel_9);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(495, 126, 153, 37);
		panel_2.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(113, 126, 153, 37);
		panel_2.add(dateChooser_1);
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setIcon(new ImageIcon(NewResevation.class.getResource("/hotele4-triangle.jpg")));
		lblNewLabel_10.setBounds(0, 0, 658, 432);
		panel_2.add(lblNewLabel_10);
		
		
		Object[][] donnees = {
                {"1", "1", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"2", "2", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"3", "3", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"4", "4", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"5", "5", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"6", "6", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"7", "7", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"8", "8", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"9", "9", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"10", "10", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"11", "11", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"12", "12", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"13", "13", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"14", "14", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"15", "15", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"16", "16", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"17", "17", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"18", "8", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"11", "11", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"12", "12", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"13", "13", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"14", "14", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"15", "15", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"16", "16", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"17", "17", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"18", "8", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"11", "11", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"12", "12", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"13", "13", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"14", "14", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"15", "15", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"16", "16", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"17", "17", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"18", "8", "Name", "17/12/2020","3","18/12/2020","21/12/2020"}
        };
 
        String[] entetes = {"No", "RoomNo", "Name", "DateReservation","NbrDeJour", "DateDebut","DateFin"};
		String st = "hamza";
		
		
		
	}
}
