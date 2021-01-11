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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;

import com.mysql.jdbc.PreparedStatement;
import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

import java.sql.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Room extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private Statement stm ;
	static int id_exemp ;
	static int num_chambre_modifier=-1 ;
	private JTextField txtRechercheRapide;
	
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
		setResizable(false);
		
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
		setTitle("Gestion des chambres ");
		
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
		btnAfficher.setBounds(10, 125, 174, 56);
		
		btnAfficher.setForeground(new Color(255, 255, 224));
		btnAfficher.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAfficher.setBackground(new Color(0, 176, 214));
		panel.add(btnAfficher);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setEnabled(false);
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selected_row=table.getSelectedRow();
			num_chambre_modifier=(Integer) table.getValueAt(selected_row, 0);
				new MAJ_Room().setVisible(true);
			}
		});
		btnModifier.setBounds(10, 186, 174, 54);
		btnModifier.setForeground(new Color(255, 255, 224));
		btnModifier.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnModifier.setBackground(new Color(0, 176, 214));
		panel.add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setEnabled(false);
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selected_row=table.getSelectedRow();
				String num_chambre=table.getValueAt(selected_row, 0).toString();
				JOptionPane jOptionPane1 = null;
				String message="voullez-vous supprimer la chambre "+num_chambre+" ?";
				int n = jOptionPane1.showConfirmDialog(null,message ,"confirmation", JOptionPane.YES_NO_OPTION);
				if(n==0) {
					Connection con =connect(); 
					try {
						PreparedStatement stm=(PreparedStatement) con.prepareStatement("Delete from chambres where no_chambre="+num_chambre);
						stm.execute() ;
						JOptionPane.showInternalMessageDialog(null, "la chambre "+num_chambre+" a été bien suprimmer !","information", JOptionPane.INFORMATION_MESSAGE);
						load_chambres(table);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		btnSupprimer.setBounds(10, 243, 174, 54);
		btnSupprimer.setForeground(new Color(255, 255, 224));
		btnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSupprimer.setBackground(new Color(0, 176, 214));
		panel.add(btnSupprimer);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Room.class.getResource("/images/Icons/Admin-icon.png")));
		lblNewLabel.setBounds(58, 386, 48, 48);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("errahali@gmail.com");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Modern No. 20", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 427, 164, 71);
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
		btnAfficher_2_1.setBounds(10, 308, 174, 54);
		panel.add(btnAfficher_2_1);
		
		JButton btnDetailChambre = new JButton("Detail Chambre");
		btnDetailChambre.setVisible(false);
		btnDetailChambre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selected_row=table.getSelectedRow();
			 
				String value=(String)table.getValueAt(selected_row, 1);
				switch(value) {
				case "R\u00E9guli\u00E8re" :{
					RegularRoom regularRoom=new RegularRoom();
					regularRoom.setVisible(true);
				break ;
				}
				case  "Familiale": {
					FamillyRoom famillyRoom=new FamillyRoom();
					famillyRoom.setVisible(true);
				break ;
				}
				case  "Suite (luxe)": {
					RoomLuxe roomLuxe=new RoomLuxe();
					roomLuxe.setVisible(true);
				break ;
				}
				
				}
			}
		});
		btnDetailChambre.setForeground(new Color(255, 255, 224));
		btnDetailChambre.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDetailChambre.setBackground(new Color(0, 176, 214));
		btnDetailChambre.setBounds(10, 65, 174, 56);
		panel.add(btnDetailChambre);
		
		
		Panel panel_2 = new Panel();
		panel_2.setBounds(214, 0, 900, 152);
		panel_2.setBackground(new Color(0, 51, 102));
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		Label label_2 = new Label("Gestion des chambres ");
		label_2.setForeground(new Color(247, 248, 250));
		label_2.setFont(new Font("Calibri Light", Font.BOLD, 18));
		label_2.setBounds(336, 0, 238, 36);
		panel_2.add(label_2);
		
		JLabel lblRechercheRapide = new JLabel("Recherche rapide");
		lblRechercheRapide.setForeground(Color.WHITE);
		lblRechercheRapide.setBounds(53, 82, 169, 25);
		panel_2.add(lblRechercheRapide);
		
		txtRechercheRapide = new JTextField();
		txtRechercheRapide.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				DefaultTableModel dm ;
				dm=(DefaultTableModel) table.getModel();
				
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dm);
				table.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(txtRechercheRapide.getText().toString()));
			}
		});
		txtRechercheRapide.setBounds(262, 76, 312, 36);
		panel_2.add(txtRechercheRapide);
		txtRechercheRapide.setColumns(10);
		
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(200, 151, 920, 461);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 0, 883, 505);
		panel_4.add(scrollPane);
		
		
		
		
		table=new JTable();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				try {
					Connection conn=connect();
					stm= conn.createStatement();
					 ResultSet rs;
					 rs=stm.executeQuery("select * from chambres");  
					 
					table.setModel(DbUtils.resultSetToTableModel(rs)); 
						  
					  
					//step5 close the connection object  
					stm.close();
					conn.close();
				}catch(Exception e1){ JOptionPane.showMessageDialog(null, e1.getMessage());}

				scrollPane.setViewportView(table);
				table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			}
		});
		JScrollPane scrollPane1=new JScrollPane();
		scrollPane1.setViewportView(table);
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
					btnDetailChambre.setVisible(true);
				}
			}
		});		
		
		
		
		Label label_1 = new Label("");
		scrollPane1.setRowHeaderView(label_1);
		label_1.setBackground(new Color(169, 169, 169));
		
		
	}
	public void load_chambres(JTable table,int etat) {
		try {
			Connection conn=connect();
			String query=null;
			PreparedStatement preparedStmt=null ;
			if(etat<2) {query = "select * from chambres where etat=?";
			 preparedStmt = (PreparedStatement) conn.prepareStatement(query);
			preparedStmt.setInt(1, etat);
			}
			else if(etat==2) {
				query = "select * from chambres ";
				 preparedStmt = (PreparedStatement) conn.prepareStatement(query);
			    }
		      
		     
		      // execute the java preparedstatement
			 ResultSet rs;
			 rs=preparedStmt.executeQuery();  
			 
			table.setModel(DbUtils.resultSetToTableModel(rs)); 
				  
			  
			//step5 close the connection object  
			stm.close();
			conn.close();
		}catch(Exception e1){ JOptionPane.showMessageDialog(null, e1.getMessage());}
	}
	public void load_chambres(JTable table) {
		try {
			Connection conn=connect();
			
			 String query = "select * from chambres";
		      PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);
		      // execute the java preparedstatement
			 ResultSet rs;
			 rs=preparedStmt.executeQuery();  
			table.setModel(DbUtils.resultSetToTableModel(rs)); 
			//step5 close the connection object  
			stm.close();
			conn.close();
		}catch(Exception e1){ JOptionPane.showMessageDialog(null, e1.getMessage());}
	}
}
