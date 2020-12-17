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
import javax.swing.border.Border;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


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
		
		btnAfficher.setForeground(new Color(255, 255, 224));
		btnAfficher.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAfficher.setBackground(new Color(0, 176, 214));
		btnAfficher.setBounds(10, 175, 174, 56);
		panel.add(btnAfficher);
		
		JButton btnAfficher_1 = new JButton("Reservation");
		btnAfficher_1.setForeground(new Color(255, 255, 224));
		btnAfficher_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAfficher_1.setBackground(new Color(0, 176, 214));
		btnAfficher_1.setBounds(10, 236, 174, 54);
		panel.add(btnAfficher_1);
		
		JButton btnAfficher_2 = new JButton("Reservation");
		btnAfficher_2.setForeground(new Color(255, 255, 224));
		btnAfficher_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAfficher_2.setBackground(new Color(0, 176, 214));
		btnAfficher_2.setBounds(10, 293, 174, 54);
		panel.add(btnAfficher_2);
		
		
		Icon icon = new ImageIcon(Customer.class.getResource("/images/Icons/585e4bf3cb11b227491c339a_a8u_icon.ico"));
		JLabel lblNewLabel = new JLabel(icon);
		
		lblNewLabel.setBounds(29, 492, 80, 36);
		panel.add(lblNewLabel);
		
		
		Panel panel_2 = new Panel();
		panel_2.setBounds(200, 0, 908, 152);
		panel_2.setBackground(new Color(0, 51, 102));
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		find = new JTextField();
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
		find.setBounds(32, 36, 153, 37);
		find.setHorizontalAlignment(JTextField.CENTER);
		panel_2.add(find);
		find.setColumns(10);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField.setColumns(10);
		textField.setBounds(212, 36, 153, 37);
		panel_2.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(400, 36, 153, 37);
		panel_2.add(textField_1);
		
		JButton search = new JButton("Search");
		search.setForeground(new Color(255, 255, 224));
		search.setFont(new Font("Tahoma", Font.BOLD, 12));
		search.setBackground(new Color(113, 202, 216));
		search.setBounds(607, 36, 130, 37);
		

		panel_2.add(search);
		
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