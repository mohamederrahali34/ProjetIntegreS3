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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Reservation extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Statement stm ;
	static int id_exemp ;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JTextField NoReserv;
	private JTextField CINReserv;
	private JTextField Date_Resrv;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reservation frame = new Reservation();
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

	
	public Reservation() {
		setType(Type.UTILITY);
		setTitle("Liste des r\u00E9servations\r\n\r\n");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1102, 637);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 239, 598);
		panel.setBackground(new Color(244, 244, 244));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnAfficher = new JButton("Modifier");
		
		btnAfficher.setForeground(new Color(255, 255, 224));
		btnAfficher.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAfficher.setBackground(new Color(0, 176, 214));
		btnAfficher.setBounds(10, 175, 222, 56);
		panel.add(btnAfficher);
		
		JButton btnAfficher_1 = new JButton("Annuler");
		btnAfficher_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAfficher_1.setForeground(new Color(255, 255, 224));
		btnAfficher_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAfficher_1.setBackground(new Color(0, 176, 214));
		btnAfficher_1.setBounds(10, 236, 222, 54);
		panel.add(btnAfficher_1);
		
		
		Icon icon = new ImageIcon(Reservation.class.getResource("/images/Icons/585e4bf3cb11b227491c339a_a8u_icon.ico"));
		JLabel lblNewLabel = new JLabel(icon);
		
		lblNewLabel.setBounds(29, 492, 80, 36);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Retour au Menu");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(10, 294, 222, 56);
		panel.add(btnNewButton);
		
		
		Panel panel_2 = new Panel();
		panel_2.setFont(new Font("Dialog", Font.ITALIC, 15));
		panel_2.setBounds(238, 0, 848, 155);
		panel_2.setBackground(new Color(0, 51, 102));
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton search = new JButton("Rechercher"); 
		search.setForeground(new Color(255, 255, 255));
		search.setFont(new Font("Tahoma", Font.BOLD, 12));
		search.setBackground(new Color(113, 202, 216));
		search.setBounds(627, 63, 130, 37);
		

		panel_2.add(search);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"No", "No chambre", "Name", "DateReservation", "NbrDeJour", "NbrDeJour", ""};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(140, 63, 140, -17);
		panel_2.add(list);
		
		JLabel lblNewLabel_1 = new JLabel("No");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(140, 38, 44, 14);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CIN");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(140, 73, 46, 14);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Date_R");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(140, 118, 46, 14);
		panel_2.add(lblNewLabel_3);
		
		NoReserv = new JTextField();
		NoReserv.setBounds(217, 32, 140, 27);
		panel_2.add(NoReserv);
		NoReserv.setColumns(10);
		
		CINReserv = new JTextField();
		CINReserv.setBounds(217, 69, 140, 27);
		panel_2.add(CINReserv);
		CINReserv.setColumns(10);
		
		Date_Resrv = new JTextField();
		Date_Resrv.setBounds(217, 110, 140, 27);
		panel_2.add(Date_Resrv);
		Date_Resrv.setColumns(10);
		
		table = new JTable();
		table.setBounds(200, 600, 886, -447);
		contentPane.add(table);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table_1.setBounds(347, 370, 1, 1);
		contentPane.add(table_1);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"No", "CIN", "NB_Nuits", "Date_R", "Date_A", "Date_F", "New column"
			}
		));
		table_2.setBounds(425, 207, 1, 1);
		contentPane.add(table_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(238, 161, 856, 437);
		contentPane.add(scrollPane);
		
		table_3 = new JTable();
		scrollPane.setViewportView(table_3);
		table_3.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"No", "CIN", "Date_R", "NB_Nuits", "Date_A", "Date_D", "NB_Pers"
			}
		));
		
		
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