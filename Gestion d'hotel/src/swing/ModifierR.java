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
import java.sql.Connection;
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
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ModifierR extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Statement stm ;
	static int id_exemp ;
	private JTextField txtCIN;
	private JTextField txtNB_Nuits;
	private JTextField txt_nb_personnes;
	private JDateChooser date_R ;
	JDateChooser date_A ;
	JDateChooser date_D;
	
	
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

	
	public ModifierR() {
		setType(Type.UTILITY);
		setTitle("Modifier");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 841, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		Icon icon = new ImageIcon(Customer.class.getResource("/images/Icons/585e4bf3cb11b227491c339a_a8u_icon.ico"));
		
		
		Panel panel_2 = new Panel();
		panel_2.setBounds(0, 0, 894, 477);
		panel_2.setBackground(Color.WHITE);    
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		txtCIN = new JTextField();
		txtCIN.setText("JB12345");
		txtCIN.setHorizontalAlignment(SwingConstants.CENTER);
		txtCIN.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtCIN.setColumns(10);
		txtCIN.setBounds(117, 36, 153, 37);
		panel_2.add(txtCIN);
		
		JButton search = new JButton("Enregistrer");
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
try {
					
					Room r=new Room();
					Connection conn=r.connect();
					
					
					String CIN=txtCIN.getText();
					String date_res=date_R.getDateFormatString();
					int nb_jours=Integer.parseInt(txt_nb_personnes.getText());
					String date_d=date_D.getDateFormatString();
					String date_f=date_A.getDateFormatString();
					 
					 
					// create the java mysql update preparedstatement
				      String query = "update reservation set CIN = ?, date_reservation=? , nb_jours= ? , date_debut=? ,date_fin=? where no_chambre = ?";
				      java.sql.PreparedStatement preparedStmt =  conn.prepareStatement(query);
				      preparedStmt.setString(1,CIN);
				     preparedStmt.setString(2,date_res);
				      preparedStmt.setInt(3, nb_jours);
				      preparedStmt.setString(4, date_d);
				      preparedStmt.setString(5, date_f);
				      preparedStmt.setInt(6,Reservation.No_reservation_modifier);
				      // execute the java preparedstatement
				      preparedStmt.executeUpdate();
					 
					 
					 JOptionPane.showMessageDialog(null,"la reservation "+Reservation.No_reservation_modifier+" a été bien modifier !", "Confirmation :",JOptionPane.INFORMATION_MESSAGE);
						  
					  
					//step5 close the connection object  
					
					conn.close();
				}catch(Exception e1){ JOptionPane.showMessageDialog(null, e1.getMessage());}
				
			}
		});
		search.setForeground(new Color(255, 255, 224));
		search.setFont(new Font("Tahoma", Font.BOLD, 12));
		search.setBackground(new Color(113, 202, 216));
		search.setBounds(287, 324, 130, 37);
		

		panel_2.add(search);
		
		txtNB_Nuits = new JTextField();
		txtNB_Nuits.setText("3");
		txtNB_Nuits.setHorizontalAlignment(SwingConstants.CENTER);
		txtNB_Nuits.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtNB_Nuits.setColumns(10);
		txtNB_Nuits.setBounds(117, 132, 153, 37);
		panel_2.add(txtNB_Nuits);
		
		JLabel lblNewLabel_2 = new JLabel("CIN");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(44, 48, 46, 14);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Date_R");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(44, 96, 46, 14);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("NB_Nuits");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(44, 143, 63, 14);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Date_A");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(393, 47, 68, 14);
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Date_D");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(393, 95, 96, 14);
		panel_2.add(lblNewLabel_6);
		
		txt_nb_personnes = new JTextField();
		txt_nb_personnes.setText("2");
		txt_nb_personnes.setHorizontalAlignment(SwingConstants.CENTER);
		txt_nb_personnes.setFont(new Font("Tahoma", Font.BOLD, 12));
		txt_nb_personnes.setColumns(10);
		txt_nb_personnes.setBounds(484, 133, 153, 37);
		panel_2.add(txt_nb_personnes);
		
		JLabel lblNewLabel_7 = new JLabel("NB_Personnes");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(393, 144, 96, 14);
		panel_2.add(lblNewLabel_7);
		
		date_R = new JDateChooser();
		date_R.setBounds(117, 84, 153, 37);
		panel_2.add(date_R);
		
		 date_A = new JDateChooser();
		date_A.setBounds(484, 36, 153, 37);
		panel_2.add(date_A);
		
		 date_D = new JDateChooser();
		date_D.setBounds(484, 84, 153, 37);
		panel_2.add(date_D);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setIcon(new ImageIcon(ModifierR.class.getResource("/hotele4-triangle.jpg")));
		lblNewLabel_8.setBounds(0, 0, 834, 434);
		panel_2.add(lblNewLabel_8);
		
		
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