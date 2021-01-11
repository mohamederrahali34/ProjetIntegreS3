package swing;



import javax.swing.JFrame;



import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import net.proteanit.sql.DbUtils;

import javax.swing.border.Border;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Label;
import java.awt.SystemColor;
import java.awt.Canvas;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


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
	
	
	private static String nom;
    private static String prenom;
    private static String cin;
    private static String adresse;
    private static String tel;
    private static String ville;
    
	
	
	
	public String getCIN() {
		return cin;
	}




	public String getNom() {
		return nom;
	}


	


	public String getPrenom() {
		return prenom;
	}




	public String getVille() {
		return ville;
	}


	public String getAdresse() {
		return adresse;
	}



	public String getTel() {
		return tel;
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer frame = new Customer();
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
	public Customer() {
		
		table=new JTable();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				try {
					 DbConnect conn=new DbConnect();
					 stm= conn.getConn().createStatement();
					 ResultSet rs;
					 rs=stm.executeQuery("select * from client");  
					 
					 table.setModel(DbUtils.resultSetToTableModel(rs)); 
						  
					  
					 //step5 close the connection object  
					 stm.close();
					 conn.getConn().close();    
				}catch(Exception e1){ JOptionPane.showMessageDialog(null, e1.getMessage());}
			}                      
		});                                                                                    
		setType(Type.UTILITY);
		setTitle("Customer");
															
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1102, 637);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAfficher = new JButton("Modifier");
		JButton btnAfficher_1 = new JButton("Supprimer");
		
	   Cursor modify = btnAfficher.getCursor();
       btnAfficher.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       
       Cursor sup = btnAfficher_1.getCursor();
       btnAfficher_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnAfficher.setEnabled(false);
		btnAfficher_1.setEnabled(false);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				 
				 btnAfficher.setEnabled(true);
				 btnAfficher_1.setEnabled(true);
			} 
		});
	
		btnAfficher.setEnabled(false);
		btnAfficher_1.setEnabled(false);

		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 208, 612);
		panel.setBackground(new Color(244, 244, 244));
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		btnAfficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int row = table.getSelectedRow();
				cin = table.getModel().getValueAt(row, 0).toString();
				nom = table.getModel().getValueAt(row, 1).toString();
				prenom = table.getModel().getValueAt(row, 2).toString();
			    tel = table.getModel().getValueAt(row, 3).toString();
				ville = table.getModel().getValueAt(row, 4).toString();
				adresse = table.getModel().getValueAt(row, 5).toString();
				
				new MAJ_Client().setVisible(true);
				
			}
		});
		btnAfficher.setEnabled(false);
		btnAfficher.setBounds(10, 195, 174, 56);
		
		btnAfficher.setForeground(new Color(255, 255, 224));
		btnAfficher.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAfficher.setBackground(new Color(0, 176, 214));
		panel.add(btnAfficher);
		
		
		btnAfficher_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					 
		 			int row = table.getSelectedRow();
					int cin = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
				        
				         DbConnect conn=new DbConnect() ;
				        
						 PreparedStatement stm=null;
			           	stm=conn.getConn().prepareStatement("delete from client where CIN=? ");  
						 stm.setInt(1,cin);
						 
				        stm.executeUpdate();

				         JOptionPane.showMessageDialog(null, "Supprimer !");
				         stm.close();
						 conn.getConn().close();
				        }  
				    catch(Exception er)
				    {
				        JOptionPane.showMessageDialog(null,er);
				    } 
		 	}
		 });
				
			
		btnAfficher_1.setBounds(10, 262, 174, 54);
		btnAfficher_1.setForeground(new Color(255, 255, 224));
		btnAfficher_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAfficher_1.setBackground(new Color(0, 176, 214));
		panel.add(btnAfficher_1);
		
		JButton btnAfficher_2 = new JButton("Retour");
		
		Cursor retour = btnAfficher_2.getCursor();
	       btnAfficher_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnAfficher_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new Admin().setVisible(true);
			}
		});
		btnAfficher_2.setBounds(10, 327, 174, 54);
		btnAfficher_2.setForeground(new Color(255, 255, 224));
		btnAfficher_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAfficher_2.setBackground(new Color(0, 176, 214));
		panel.add(btnAfficher_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Customer.class.getResource("/images/Icons/Admin-icon.png")));
		lblNewLabel.setBounds(0, 427, 48, 48);
		panel.add(lblNewLabel);
		
		String admin = new Login().getNom() + " " + new Login().getPrenom();
		JLabel lblNewLabel_1 = new JLabel(admin);
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
				new Login().setVisible(true);
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
		find.setBounds(360, 81, 257, 37);
		find.setHorizontalAlignment(JTextField.CENTER);
		panel_2.add(find);
		find.setColumns(10);
		
		Label label_1 = new Label("");
		label_1.setBackground(new Color(169, 169, 169));
		label_1.setBounds(0, 52, 911, 2);
		panel_2.add(label_1);
		
		Label label_2 = new Label("Customer List");
		label_2.setForeground(new Color(247, 248, 250));
		label_2.setFont(new Font("Calibri Light", Font.BOLD, 18));
		label_2.setBounds(336, 0, 238, 36);
		panel_2.add(label_2);
		
		btnAfficher.setEnabled(false);
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(200, 151, 920, 461);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 0, 883, 505);
		panel_4.add(scrollPane);
		
		
       
		
		
		scrollPane.setViewportView(table);
		
		
		
		
	}
}