package swing;


import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
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

import java.sql.*;


public class RoomsList extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private Statement stm ;
	static int id_exemp ;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoomsList frame = new RoomsList();
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

	
	public RoomsList() {
		initialize_Components();
		connect();
	}
	
	public void  connect() {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_gestion_hotel","root","");
			System.out.println("you are connected to db successfully !");
		}catch(Exception e){
			System.out.println("We can not connect to database ! retry !");
		}
	}
	
	private void initialize_Components() {

		setType(Type.UTILITY);
		setTitle("Customer");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1102, 636);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 208, 612);
		panel.setBackground(new Color(244, 244, 244));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnApercu = new JButton("Apercu");
		btnApercu.setBounds(10, 175, 174, 56);
		
		btnApercu.setForeground(new Color(255, 255, 224));
		btnApercu.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnApercu.setBackground(new Color(0, 176, 214));
		panel.add(btnApercu);
		
		JButton btnReserver = new JButton("Reserver");
		btnReserver.setBounds(10, 236, 174, 54);
		btnReserver.setForeground(new Color(255, 255, 224));
		btnReserver.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnReserver.setBackground(new Color(0, 176, 214));
		panel.add(btnReserver);
		
		JButton Retour = new JButton("Retour");
		Retour.setBounds(10, 293, 174, 54);
		Retour.setForeground(new Color(255, 255, 224));
		Retour.setFont(new Font("Tahoma", Font.BOLD, 12));
		Retour.setBackground(new Color(0, 176, 214));
		panel.add(Retour);
		
		
		JLabel lblNewLabel_1 = new JLabel("errahali@gmail.com");
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
		
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(200, 151, 920, 461);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 0, 883, 505);
		panel_4.add(scrollPane);
		
		
		Object[][] donnees = {
				{"1", "101", "Family Room", "2000", "2", "2", "available"},
				{"2", "102", "Party favor", "8000", "6", "5", ""},
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
        };
 
        String[] entetes = {"No", "Room No", "Room type", "Cost", "Maximum People", "MaximumExtraBed", "availability"};
       
		
		table=new JTable(donnees, entetes);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"101", "", "2000", "2"},
				{"102", "", "8000", ""},
				{null, "Chambre r\u00E9guli\u00E8re", null, null},
				{null, "Chambre familiale", null, null},
				{null, "Suite", null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"No du chambre", "Type de chambre", "Cout", "Nombre de personnes"
			}
		));
		scrollPane.setViewportView(table);
		
		Label label_1 = new Label("");
		scrollPane.setRowHeaderView(label_1);
		label_1.setBackground(new Color(169, 169, 169));
		
		
	}
}
