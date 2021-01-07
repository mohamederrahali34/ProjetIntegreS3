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
import com.toedter.calendar.JDateChooser;


public class AjoutReservation extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField find;
	private JTable table;
	private Statement stm ;
	static int id_exemp ;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_6;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjoutReservation frame = new AjoutReservation();
					frame.setResizable(false);
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

	
	public AjoutReservation() {
		setType(Type.UTILITY);
		setTitle("Customer");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1102, 637);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 101, 581, 511);
		panel.setBackground(new Color(244, 244, 244));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnAfficher = new JButton("Reserver");
		btnAfficher.setBounds(335, 429, 174, 56);
		
		btnAfficher.setForeground(new Color(255, 255, 224));
		btnAfficher.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAfficher.setBackground(new Color(0, 176, 214));
		panel.add(btnAfficher);
		
		JButton btnOut = new JButton("Sign Out");
		btnOut.setBackground(new Color(244, 244, 244));
		btnOut.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 18));
		btnOut.setBorder(null);
		
		Cursor cursor = btnOut.getCursor();
        btnOut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnOut.setHorizontalAlignment(SwingConstants.LEFT);
		btnOut.setBounds(39, 509, 125, 48);
		panel.add(btnOut);
		
		JButton btnAfficher_1_1 = new JButton("Annuler");
		btnAfficher_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAfficher_1_1.setForeground(new Color(255, 255, 224));
		btnAfficher_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAfficher_1_1.setBackground(new Color(0, 176, 214));
		btnAfficher_1_1.setBounds(102, 430, 153, 54);
		panel.add(btnAfficher_1_1);
		
		find = new JTextField("");
		find.setBounds(122, 145, 133, 37);
		panel.add(find);
		
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
		find.setHorizontalAlignment(JTextField.CENTER);
		find.setColumns(10);
		
		textField_2 = new JTextField("");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(436, 136, 133, 37);
		panel.add(textField_2);
		
		textField_3 = new JTextField("");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_3.setColumns(10);
		textField_3.setBounds(440, 215, 133, 37);
		panel.add(textField_3);
		
		textField = new JTextField("");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField.setColumns(10);
		textField.setBounds(122, 215, 133, 37);
		panel.add(textField);
		
		textField_1 = new JTextField("");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(122, 285, 133, 37);
		panel.add(textField_1);
		
		textField_6 = new JTextField("");
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_6.setColumns(10);
		textField_6.setBounds(122, 349, 133, 37);
		panel.add(textField_6);
		
		Label label_2_1_1 = new Label("No de Chambre");
		label_2_1_1.setForeground(Color.BLACK);
		label_2_1_1.setFont(new Font("Calibri Light", Font.BOLD, 10));
		label_2_1_1.setBounds(27, 44, 125, 28);
		panel.add(label_2_1_1);
		
		Label label_2_1_1_1 = new Label("500");
		label_2_1_1_1.setForeground(Color.BLACK);
		label_2_1_1_1.setFont(new Font("Calibri Light", Font.BOLD, 10));
		label_2_1_1_1.setBounds(158, 35, 71, 37);
		panel.add(label_2_1_1_1);
		
		Label label_2_1_1_2 = new Label("Nom");
		label_2_1_1_2.setForeground(Color.BLACK);
		label_2_1_1_2.setFont(new Font("Calibri Light", Font.BOLD, 10));
		label_2_1_1_2.setBounds(27, 145, 86, 37);
		panel.add(label_2_1_1_2);
		
		Label label_2_1_1_2_1 = new Label("Prenom");
		label_2_1_1_2_1.setForeground(Color.BLACK);
		label_2_1_1_2_1.setFont(new Font("Calibri Light", Font.BOLD, 10));
		label_2_1_1_2_1.setBounds(27, 215, 86, 37);
		panel.add(label_2_1_1_2_1);
		
		Label label_2_1_1_2_1_1 = new Label("Adresse");
		label_2_1_1_2_1_1.setForeground(Color.BLACK);
		label_2_1_1_2_1_1.setFont(new Font("Calibri Light", Font.BOLD, 10));
		label_2_1_1_2_1_1.setBounds(27, 285, 86, 37);
		panel.add(label_2_1_1_2_1_1);
		
		Label label_2_1_1_2_1_2 = new Label("CIN");
		label_2_1_1_2_1_2.setForeground(Color.BLACK);
		label_2_1_1_2_1_2.setFont(new Font("Calibri Light", Font.BOLD, 10));
		label_2_1_1_2_1_2.setBounds(27, 349, 86, 37);
		panel.add(label_2_1_1_2_1_2);
		
		Label label_2_1_1_2_1_3 = new Label("No Tele");
		label_2_1_1_2_1_3.setForeground(Color.BLACK);
		label_2_1_1_2_1_3.setFont(new Font("Calibri Light", Font.BOLD, 10));
		label_2_1_1_2_1_3.setBounds(322, 215, 86, 37);
		panel.add(label_2_1_1_2_1_3);
		
		Label label_2_1_1_2_1_4 = new Label("Montant");
		label_2_1_1_2_1_4.setForeground(Color.BLACK);
		label_2_1_1_2_1_4.setFont(new Font("Calibri Light", Font.BOLD, 10));
		label_2_1_1_2_1_4.setBounds(323, 51, 86, 37);
		panel.add(label_2_1_1_2_1_4);
		
		Label label_2_1_1_2_1_5 = new Label("Date de reservation");
		label_2_1_1_2_1_5.setForeground(Color.BLACK);
		label_2_1_1_2_1_5.setFont(new Font("Calibri Light", Font.BOLD, 10));
		label_2_1_1_2_1_5.setBounds(285, 281, 146, 46);
		panel.add(label_2_1_1_2_1_5);
		
		Label label_2_1_1_2_1_6 = new Label("Date Fin");
		label_2_1_1_2_1_6.setForeground(Color.BLACK);
		label_2_1_1_2_1_6.setFont(new Font("Calibri Light", Font.BOLD, 10));
		label_2_1_1_2_1_6.setBounds(331, 349, 86, 37);
		panel.add(label_2_1_1_2_1_6);
		
		Label label_2_1_1_1_1 = new Label("500");
		label_2_1_1_1_1.setForeground(Color.BLACK);
		label_2_1_1_1_1.setFont(new Font("Calibri Light", Font.BOLD, 10));
		label_2_1_1_1_1.setBounds(432, 51, 71, 37);
		panel.add(label_2_1_1_1_1);
		
		Label label_2_1_1_1_1_1 = new Label("DH");
		label_2_1_1_1_1_1.setForeground(Color.BLACK);
		label_2_1_1_1_1_1.setFont(new Font("Calibri Light", Font.BOLD, 10));
		label_2_1_1_1_1_1.setBounds(503, 53, 60, 37);
		panel.add(label_2_1_1_1_1_1);
		
		Label label_2_1_1_2_1_3_1 = new Label("Ville");
		label_2_1_1_2_1_3_1.setForeground(Color.BLACK);
		label_2_1_1_2_1_3_1.setFont(new Font("Calibri Light", Font.BOLD, 10));
		label_2_1_1_2_1_3_1.setBounds(312, 134, 86, 37);
		panel.add(label_2_1_1_2_1_3_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(441, 299, 130, 37);
		panel.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(441, 362, 130, 37);
		panel.add(dateChooser_1);
		
		
		Panel panel_2 = new Panel();
		panel_2.setBounds(0, 0, 1108, 99);
		panel_2.setBackground(new Color(0, 51, 102));
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		Label label_1 = new Label("");
		label_1.setBackground(new Color(169, 169, 169));
		label_1.setBounds(0, 72, 1098, 3);
		panel_2.add(label_1);
		
		Label label_2 = new Label("Reservation");
		label_2.setForeground(new Color(247, 248, 250));
		label_2.setFont(new Font("Calibri Light", Font.BOLD, 18));
		label_2.setBounds(417, 10, 238, 36);
		panel_2.add(label_2);
		
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(589, 200, 489, 412);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(1, 6, 487, 393);
		panel_4.add(scrollPane);
		
		
		Object[][] donnees = {
                {"1", "1"},
                {"2", "2"},
                {"3", "3"},
                {"4", "4"},
                {"5", "5"},
                {"6", "6"},
                {"7", "7"},
                {"8", "8"},
                {"9", "9"},
                {"10", "10"},
                {"11", "11"},
                {"12", "12"},
                {"13", "13"},
                {"14", "14"},
                {"15", "15"},
                {"16", "16"},
                {"17", "17"},
                {"18", "8"},
                {"11", "11"},
                {"12", "12"},
                {"13", "13"},
                {"14", "14"},
                {"15", "15"},
                {"16", "16"},
                {"17", "17"},
                {"18", "8"},
                {"11", "11"},
                {"12", "12"},
                {"13", "13"},
                {"14", "14"},
                {"15", "15"},
                {"16", "16"},
                {"17", "17"},
                {"18", "8"}
        };
 
        String[] entetes = {"No", "RoomNo"};
       
		
		table=new JTable(donnees, entetes);
		scrollPane.setViewportView(table);
		
		Label label_2_1 = new Label("Les chambres libres");
		label_2_1.setForeground(Color.BLACK);
		label_2_1.setFont(new Font("Calibri Light", Font.BOLD, 15));
		label_2_1.setBounds(698, 93, 238, 36);
		contentPane.add(label_2_1);
		
		Label label_2_1_1_2_1_3_1_1 = new Label("Type");
		label_2_1_1_2_1_3_1_1.setForeground(Color.BLACK);
		label_2_1_1_2_1_3_1_1.setFont(new Font("Calibri Light", Font.BOLD, 10));
		label_2_1_1_2_1_3_1_1.setBounds(621, 150, 51, 37);
		contentPane.add(label_2_1_1_2_1_3_1_1);
		String st = "hamza";
		
		
		
	}
}