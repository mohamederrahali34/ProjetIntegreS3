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
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.swing.*;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
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
import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class AjoutReservation extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nom;
	private JTable table;
	private Statement stm ;
	static int id_exemp ;
	private JTextField ville;
	private JTextField tele;
	private JTextField prenom;
	private JTextField adresse;
	private JTextField cin;
	
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
	
	public static java.sql.Date convertUtilDateToSqlDate(java.util.Date date){
	    if(date != null) {
	        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	        return sqlDate;
	    }
	    return null;
	}

	
	public AjoutReservation() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				try {
					 DbConnect conn=new DbConnect();
					 stm= conn.getConn().createStatement();
					 ResultSet rs;
					 rs=stm.executeQuery("select no_chambre,type_chambre,nb_personnes,cout from chambres where etat = 0");  
					 
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
		panel.setBounds(0, 101, 581, 511);
		panel.setBackground(new Color(244, 244, 244));
		contentPane.add(panel);
		panel.setLayout(null);
		Label numRoom = new Label();
		Label montant = new Label();
		
		JDateChooser date_fin = new JDateChooser();
		JDateChooser date_reservation = new JDateChooser();
		JButton btnAfficher = new JButton("Reserver");
		btnAfficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { ///
				
				
				
				try{
					 if( nom.getText().equals("") 
					     || prenom.getText().equals("") || ville.getText().equals("")
					     || adresse.getText().equals("") || date_reservation.equals("") || tele.getText().equals("")
					      ||     cin.equals("") || date_fin.equals("")
					        
							 )
					 {
				            JOptionPane.showMessageDialog(null, "Certains champs sont vides");
				        }
					 else {
						 
						 
						 
						 
						 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						 SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
					        String d = sdf.format(date_reservation.getDate());
					        String f = sd.format(date_fin.getDate());
					
				        int no =Integer.parseInt(numRoom.getText().toString());
				        String name=nom.getText().toString();
				        String pren=prenom.getText().toString();
				     
				        String city=ville.getText().toString();
				        String adress=adresse.getText().toString();
				        String te=tele.getText().toString();
				        String mont =montant.getText().toString();
				        int cIn =Integer.parseInt(cin.getText().toString());
				       
				     
				       
				        
				
				        DbConnect conn=new DbConnect() ;
				        
						 PreparedStatement stm=null;
			          	stm=conn.getConn().prepareStatement("INSERT INTO reservation VALUES(?,?,?,?,?)  ");  
						 
						
				         
						 stm.setInt(1,no);
						 stm.setInt(2,cIn);
				         stm.setDate(3,convertUtilDateToSqlDate(date_reservation.getDate()));
				         
				         LocalDateTime from = LocalDateTime.ofInstant(date_reservation.getDate().toInstant(), ZoneId.systemDefault());
				         LocalDateTime to = LocalDateTime.ofInstant(date_fin.getDate().toInstant(), ZoneId.systemDefault());

				         Duration s = Duration.between(from, to);
				         
				        stm.setInt(4,(int) s.toDays());
				        stm.setDate(5,convertUtilDateToSqlDate(date_fin.getDate()));
				       
				        
				        
//				        stm.setString(7,te);
//				        stm.setString(8,motpass);
//				        stm.setString(9,users);
//				        stm.setString(10,"non");
//				        stm.executeUpdate();
				        
				        stm.close();
				        conn.getConn().close();
				        JOptionPane.showMessageDialog(null, "Added") ;
				        
				          
					 }
				}catch(Exception er)
				    {
				        JOptionPane.showMessageDialog(null,er);
				    }
				
				
				
				
			}
		});
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
		
		nom = new JTextField("");
		nom.setBounds(122, 145, 133, 37);
		panel.add(nom);
		
		nom.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				DefaultTableModel dm ;
				dm=(DefaultTableModel) table.getModel();
				
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dm);
				table.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(nom.getText().toString()));
			}
		});
		nom.setFont(new Font("Tahoma", Font.BOLD, 12));
		nom.setHorizontalAlignment(JTextField.CENTER);
		nom.setColumns(10);
		
		ville = new JTextField("");
		ville.setHorizontalAlignment(SwingConstants.CENTER);
		ville.setFont(new Font("Tahoma", Font.BOLD, 12));
		ville.setColumns(10);
		ville.setBounds(436, 136, 133, 37);
		panel.add(ville);
		
		tele = new JTextField("");
		tele.setHorizontalAlignment(SwingConstants.CENTER);
		tele.setFont(new Font("Tahoma", Font.BOLD, 12));
		tele.setColumns(10);
		tele.setBounds(440, 215, 133, 37);
		panel.add(tele);
		
		prenom = new JTextField("");
		prenom.setHorizontalAlignment(SwingConstants.CENTER);
		prenom.setFont(new Font("Tahoma", Font.BOLD, 12));
		prenom.setColumns(10);
		prenom.setBounds(122, 215, 133, 37);
		panel.add(prenom);
		
		adresse = new JTextField("");
		adresse.setHorizontalAlignment(SwingConstants.CENTER);
		adresse.setFont(new Font("Tahoma", Font.BOLD, 12));
		adresse.setColumns(10);
		adresse.setBounds(122, 285, 133, 37);
		panel.add(adresse);
		
		cin = new JTextField("");
		cin.setHorizontalAlignment(SwingConstants.CENTER);
		cin.setFont(new Font("Tahoma", Font.BOLD, 12));
		cin.setColumns(10);
		cin.setBounds(122, 349, 133, 37);
		panel.add(cin);
		
		Label label_2_1_1 = new Label("No de Chambre");
		label_2_1_1.setForeground(Color.BLACK);
		label_2_1_1.setFont(new Font("Calibri Light", Font.BOLD, 10));
		label_2_1_1.setBounds(27, 44, 125, 28);
		panel.add(label_2_1_1);
		
		
		numRoom.setForeground(Color.BLACK);
		numRoom.setFont(new Font("Calibri Light", Font.BOLD, 10));
		numRoom.setBounds(158, 35, 71, 37);
		panel.add(numRoom);
		
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
		
		Label montant1 = new Label();
		montant1.setForeground(Color.BLACK);
		montant1.setFont(new Font("Calibri Light", Font.BOLD, 10));
		montant1.setBounds(432, 51, 71, 37);
		panel.add(montant1);
		
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
		
		JDateChooser date_reservation1 = new JDateChooser();
		date_reservation1.setBounds(441, 299, 130, 37);
		panel.add(date_reservation1);
		
		
		date_fin.setBounds(441, 362, 130, 37);
		panel.add(date_fin);
		
		
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
		
		
		
       
		
		table=new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				 
				int row = table.getSelectedRow();
				String no = table.getModel().getValueAt(row, 0).toString();
				String cout = table.getModel().getValueAt(row, 3).toString();
				numRoom.setText(no);
				montant1.setText(cout);
				
				 btnAfficher.setEnabled(true);
				 
			} 
		});
		
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
		
		
		
	}
}