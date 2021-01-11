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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import net.proteanit.sql.DbUtils;

import javax.swing.border.Border;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Label;
import java.awt.SystemColor;
import java.awt.Canvas;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Reservation extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField find;
	private JTable table;
	private Statement stm ;
	static int id_exemp ;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reservation frame = new Reservation();
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

	
	public Reservation() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				try {
					 DbConnect conn=new DbConnect();
					 stm= conn.getConn().createStatement();
					 ResultSet rs;
					 rs=stm.executeQuery("select * from reservation");  
					 
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
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 208, 612);
		panel.setBackground(new Color(244, 244, 244));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnAfficher = new JButton("Modifier");
		btnAfficher.setBounds(10, 195, 174, 56);
		
		btnAfficher.setForeground(new Color(255, 255, 224));
		btnAfficher.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAfficher.setBackground(new Color(0, 176, 214));
		panel.add(btnAfficher);
		
		JButton btnAfficher_1 = new JButton("Supprimer");
		btnAfficher_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					 
		 			int row = table.getSelectedRow();
					int cin = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
				        
				         DbConnect conn=new DbConnect() ;
				        
						 PreparedStatement stm=null;
			           	stm=conn.getConn().prepareStatement("delete from reservation where No= ? ");  
						 stm.setInt(1,cin);
						 
				        stm.executeUpdate();

				         JOptionPane.showMessageDialog(null, "La reservation est Supprimee !");
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
		lblNewLabel.setIcon(new ImageIcon(Reservation.class.getResource("/images/Icons/Admin-icon.png")));
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
		
		JButton btnAfficher_1_1 = new JButton("Ajouter  reservation");
		btnAfficher_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				new AjoutReservation().setVisible(true);
			}
		});
		btnAfficher_1_1.setForeground(new Color(255, 255, 224));
		btnAfficher_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAfficher_1_1.setBackground(new Color(0, 176, 214));
		btnAfficher_1_1.setBounds(10, 130, 174, 56);
		panel.add(btnAfficher_1_1);
		
		
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
		find.setBounds(421, 81, 153, 37);
		find.setHorizontalAlignment(JTextField.CENTER);
		panel_2.add(find);
		find.setColumns(10);
		
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
		
		Label label_2 = new Label("Reservation");
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
		
		
 ;
       
		
		table=new JTable();
		scrollPane.setViewportView(table);
		
		
		
	}
}