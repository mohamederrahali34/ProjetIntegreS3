package swing;


import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;
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
import javax.swing.border.Border;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Label;
import java.awt.SystemColor;
import java.awt.Canvas;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Customer extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField find;
	private JTable table;
	private Statement stm ;
	static int id_exemp ;
	private JTextField textField;
	private JTextField textField_1;
	
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

	
	public Customer() {
		setType(Type.UTILITY);
		setTitle("Customer");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1102, 637);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 208, 612);
		panel.setBackground(new Color(244, 244, 244));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnAfficher = new JButton("Reservation");
		btnAfficher.setBounds(10, 175, 174, 56);
		
		btnAfficher.setForeground(new Color(255, 255, 224));
		btnAfficher.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAfficher.setBackground(new Color(0, 176, 214));
		panel.add(btnAfficher);
		
		JButton btnAfficher_1 = new JButton("Reservation");
		btnAfficher_1.setBounds(10, 236, 174, 54);
		btnAfficher_1.setForeground(new Color(255, 255, 224));
		btnAfficher_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAfficher_1.setBackground(new Color(0, 176, 214));
		panel.add(btnAfficher_1);
		
		JButton btnAfficher_2 = new JButton("Reservation");
		btnAfficher_2.setBounds(10, 293, 174, 54);
		btnAfficher_2.setForeground(new Color(255, 255, 224));
		btnAfficher_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAfficher_2.setBackground(new Color(0, 176, 214));
		panel.add(btnAfficher_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Customer.class.getResource("/images/Icons/Admin-icon.png")));
		lblNewLabel.setBounds(0, 427, 48, 48);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Hamza Moukrim");
		lblNewLabel_1.setFont(new Font("Modern No. 20", Font.BOLD, 20));
		lblNewLabel_1.setBounds(55, 427, 164, 71);
		panel.add(lblNewLabel_1);
		
		Label label = new Label("");
		label.setBackground(new Color(169,169,169));
		label.setBounds(10, 504, 174, 2);
		panel.add(label);
		
		JButton btnOut = new JButton("Sign Out");
		btnOut.setBackground(new Color(244, 244, 244));
		btnOut.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 18));
		btnOut.setBorder(null);
		
		Cursor cursor = btnOut.getCursor();
        btnOut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnOut.setHorizontalAlignment(SwingConstants.LEFT);
		btnOut.setBounds(39, 509, 125, 48);
		panel.add(btnOut);
		
		
		Panel panel_2 = new Panel();
		panel_2.setBounds(200, 0, 908, 152);
		panel_2.setBackground(new Color(0, 51, 102));
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		find = new JTextField("");
		
		find.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				DefaultTableModel dm ;
				dm=(DefaultTableModel) table.getModel();
				
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dm);
				table.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(find.getText().toString()));
			}
		});
		find.setFont(new Font("Tahoma", Font.BOLD, 12));
		find.setBounds(31, 81, 153, 37);
		find.setHorizontalAlignment(JTextField.CENTER);
		panel_2.add(find);
		find.setColumns(10);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField.setColumns(10);
		textField.setBounds(253, 81, 153, 37);
		panel_2.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(452, 81, 153, 37);
		panel_2.add(textField_1);
		
		JButton search = new JButton("Search");
		search.setForeground(new Color(255, 255, 224));
		search.setFont(new Font("Tahoma", Font.BOLD, 12));
		search.setBackground(new Color(113, 202, 216));
		search.setBounds(697, 81, 130, 37);
		
		
	
		

		panel_2.add(search);
		
		Label label_1 = new Label("");
		label_1.setBackground(new Color(169, 169, 169));
		label_1.setBounds(0, 52, 911, 2);
		panel_2.add(label_1);
		
		Label label_2 = new Label("Customer List");
		label_2.setForeground(new Color(247, 248, 250));
		label_2.setFont(new Font("Calibri Light", Font.BOLD, 18));
		label_2.setBounds(336, 0, 238, 36);
		panel_2.add(label_2);
		
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(200, 151, 920, 461);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 0, 883, 505);
		panel_4.add(scrollPane);
		
		
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
       
		
		table=new JTable(donnees, entetes);
		scrollPane.setViewportView(table);
		String st = "hamza";
		
		
		
	}
}