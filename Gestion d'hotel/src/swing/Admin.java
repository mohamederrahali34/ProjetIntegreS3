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


public class Admin extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Statement stm ;
	static int id_exemp ;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public Admin() {
		setType(Type.UTILITY);
		setTitle("Page d'accueil");
		
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
		
		JButton btnAfficher = new JButton("Gestion des clients");
		btnAfficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Customer c =new Customer();
				c.setVisible(true);
				
			}
		});
		btnAfficher.setBounds(10, 175, 174, 56);
		
		btnAfficher.setForeground(new Color(255, 255, 224));
		btnAfficher.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAfficher.setBackground(new Color(0, 176, 214));
		panel.add(btnAfficher);
		
		JButton btnAfficher_1 = new JButton("Gestion des reservation");
		btnAfficher_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Reservation r = new Reservation();
				r.setVisible(true);
	
				
			}
		});
		btnAfficher_1.setBounds(10, 236, 174, 54);
		btnAfficher_1.setForeground(new Color(255, 255, 224));
		btnAfficher_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAfficher_1.setBackground(new Color(0, 176, 214));
		panel.add(btnAfficher_1);
		
		JButton btnAfficher_2 = new JButton("Gestions des chambres");
		btnAfficher_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Room c =new Room();
				c.setVisible(true);
			}
		});
		btnAfficher_2.setBounds(10, 293, 174, 54);
		btnAfficher_2.setForeground(new Color(255, 255, 224));
		btnAfficher_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAfficher_2.setBackground(new Color(0, 176, 214));
		panel.add(btnAfficher_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Admin.class.getResource("/images/Icons/Admin-icon.png")));
		lblNewLabel.setBounds(0, 427, 48, 48);
		panel.add(lblNewLabel);
		
		Login nom=new Login();
		String user = nom.getNom() + " " + nom.getPrenom(); 
		
		JLabel lblNewLabel_1 = new JLabel(user);
		lblNewLabel_1.setFont(new Font("Modern No. 20", Font.BOLD, 20));
		lblNewLabel_1.setBounds(55, 427, 164, 71);
		panel.add(lblNewLabel_1);
		
		Label label = new Label("");
		label.setBackground(new Color(169,169,169));
		label.setBounds(10, 504, 174, 2);
		panel.add(label);
		
		JButton btnOut = new JButton("Sign Out");
		btnOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new Login().frmlogin.setVisible(true);
			}
		});
		btnOut.setBackground(new Color(244, 244, 244));
		btnOut.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 18));
		btnOut.setBorder(null);
		
		Cursor cursor = btnOut.getCursor();
        btnOut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnOut.setHorizontalAlignment(SwingConstants.LEFT);
		btnOut.setBounds(39, 509, 125, 48);
		panel.add(btnOut);
		
		
		Panel panel_2 = new Panel();
		panel_2.setBounds(200, 0, 908, 111);
		panel_2.setBackground(new Color(0, 51, 102));
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		Label label_1 = new Label("");
		label_1.setBackground(new Color(169, 169, 169));
		label_1.setBounds(0, 52, 911, 2);
		panel_2.add(label_1);
		
		Label label_2 = new Label("Welcome"+" " +user);
		label_2.setForeground(new Color(247, 248, 250));
		label_2.setFont(new Font("Calibri Light", Font.BOLD, 18));
		label_2.setBounds(257, 0, 389, 46);
		panel_2.add(label_2);
		
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(200, 105, 908, 507);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Admin.class.getResource("/images/Icons/ciudad-maderas-MXbM1NrRqtI-unsplash (1).jpg")));
		lblNewLabel_2.setBounds(0, 0, 908, 507);
		panel_4.add(lblNewLabel_2);
		
		
		
		
	}
}