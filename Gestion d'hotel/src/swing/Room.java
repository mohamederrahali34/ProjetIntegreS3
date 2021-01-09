package swing;


import javax.swing.JFrame;



import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Panel;

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

import java.sql.*;


public class Room extends JFrame {

	
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
					Room frame = new Room();
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

	
	public Room() {
		initialize_Components();
		connect();
		
	}
	
	public Connection  connect() {
		Connection con=null;
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_hotel","root","");
			System.out.println("you are connected to db successfully !");
		}catch(Exception e){
			System.out.println("We can not connect to database ! retry !");
		}
		return con ;
	}
	
	private void initialize_Components() {

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
		
		JButton btnAfficher = new JButton("Ajouter");
		int numRow=0;
		btnAfficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			
				new NewRoom().setVisible(true);
			}
		});
		btnAfficher.setBounds(10, 175, 174, 56);
		
		btnAfficher.setForeground(new Color(255, 255, 224));
		btnAfficher.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAfficher.setBackground(new Color(0, 176, 214));
		panel.add(btnAfficher);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setEnabled(false);
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new MAJ_Room().setVisible(true);
			}
		});
		btnModifier.setBounds(10, 236, 174, 54);
		btnModifier.setForeground(new Color(255, 255, 224));
		btnModifier.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnModifier.setBackground(new Color(0, 176, 214));
		panel.add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setEnabled(false);
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selected_row=table.getSelectedRow();
				String num_chambre=(String) table.getValueAt(selected_row, 0);
				JOptionPane jOptionPane1 = null;
				String message="voullez-vous supprimer la chambre "+num_chambre+" ?";
				int n = jOptionPane1.showConfirmDialog(null,message ,"confirmation", JOptionPane.YES_NO_OPTION);
				if(n==0) {
					Connection con =connect(); 
					try {
						PreparedStatement stm=con.prepareStatement("Delete from chambres where no_chambre="+num_chambre);
						stm.execute() ;
							JOptionPane.showInternalMessageDialog(null, "la chambre "+num_chambre+" a été bien suprimmer !","information", JOptionPane.INFORMATION_MESSAGE);
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		btnSupprimer.setBounds(10, 293, 174, 54);
		btnSupprimer.setForeground(new Color(255, 255, 224));
		btnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSupprimer.setBackground(new Color(0, 176, 214));
		panel.add(btnSupprimer);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Room.class.getResource("/images/Icons/Admin-icon.png")));
		lblNewLabel.setBounds(0, 427, 48, 48);
		panel.add(lblNewLabel);
		
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
		
		JButton btnAfficher_2_1 = new JButton("Retour");
		btnAfficher_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new Admin().setVisible(true);
			}
		});
		btnAfficher_2_1.setForeground(new Color(255, 255, 224));
		btnAfficher_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAfficher_2_1.setBackground(new Color(0, 176, 214));
		btnAfficher_2_1.setBounds(10, 358, 174, 54);
		panel.add(btnAfficher_2_1);
		
		
		Panel panel_2 = new Panel();
		panel_2.setBounds(208, 0, 900, 152);
		panel_2.setBackground(new Color(0, 51, 102));
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		Label label_2 = new Label("Room");
		label_2.setForeground(new Color(247, 248, 250));
		label_2.setFont(new Font("Calibri Light", Font.BOLD, 18));
		label_2.setBounds(336, 0, 238, 36);
		panel_2.add(label_2);
		
		JLabel lblNewLabel_2 = new JLabel("Etat");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(45, 87, 46, 14);
		panel_2.add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Libre", "Reserver", "Oucuper", "Toute les chambres"}));
		comboBox.setBounds(84, 76, 160, 36);
		panel_2.add(comboBox);
		
		JButton btnChercher = new JButton("Chercher");
		btnChercher.setBackground(SystemColor.textHighlight);
		btnChercher.setBounds(482, 76, 109, 36);
		panel_2.add(btnChercher);
		
		JButton btnReinitialiser = new JButton("R\u00E9initialiser");
		btnReinitialiser.setBackground(SystemColor.textHighlight);
		btnReinitialiser.setBounds(314, 75, 109, 39);
		panel_2.add(btnReinitialiser);
		
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(200, 151, 920, 461);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 0, 883, 505);
		panel_4.add(scrollPane);
		
		
 
        String[] entetes = {"Room No", "Room type", "Cost", "Maximum People", "MaximumExtraBed", "availability"};
        String data[][] = null;
		try {
        Connection con=connect();
        
        String query = "SELECT * FROM chambres";
      
        Statement stm = con.createStatement();
        ResultSet res = stm.executeQuery(query);
         data= new String[10][5];
      
        int i = 0;
        while (res.next()) {
          int no_chambre = res.getInt("no_chambre");
          String type_chambre = res.getString("type_chambre");
          String nb_personnes = res.getString("nb_personnes");
          String cout = res.getString("cout");
          String etat = res.getString("etat");
          data[i][0] = no_chambre+"" ;
          data[i][1] = type_chambre;
          data[i][2] = nb_personnes;
          data[i][3] = cout;
          data[i][4] = etat;
          i++;
        }
		}
		catch(Exception e) {
			
		}
       
		table=new JTable();
		table.setModel(new DefaultTableModel(data,entetes));
		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); 
		
		
		
		ListSelectionModel list_slct_model =table.getSelectionModel();
		 list_slct_model.addListSelectionListener(new ListSelectionListener() {
			//test
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int selectedRow=table.getSelectedRow();
				if(selectedRow !=-1) {
					btnSupprimer.setEnabled(true);
					btnModifier.setEnabled(true);
				}
			}
		});
		
		
		
		
		Label label_1 = new Label("");
		scrollPane.setRowHeaderView(label_1);
		label_1.setBackground(new Color(169, 169, 169));
		
		
	}
}
