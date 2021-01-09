package swing;

import java.awt.BorderLayout;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Login extends JFrame {
	
	
	
	JFrame frmlogin;

	private JPanel contentPane;
	private JTextField loginText;
	private JPasswordField motpasse;
	private DbConnect conn ;
	
	static String nom;
	static String prenom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.frmlogin.setResizable(false);
					frame.frmlogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public String getNom() {
		  return nom;
	  }
	  public String getPrenom() {
		  return prenom;
	  }
	  
	
	public Login() {
		
		conn=new DbConnect();
		frmlogin=new JFrame();
		frmlogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frmlogin.setBounds(100, 100, 1082, 622);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmlogin.setContentPane(contentPane);
	    contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(-16, 0, 645, 596);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/images/Icons/login.jpg")));
		lblNewLabel.setBounds(10, 0, 635, 596);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(44, 67, 147));
		panel_1.setBounds(624, 0, 472, 585);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nom d'utilisateur");
		lblNewLabel_1.setForeground(new Color(161, 164, 185));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1.setBounds(44, 247, 274, 46);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(Login.class.getResource("/images/Icons/585e4bf3cb11b227491c339a (3).png")));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1_1.setBounds(167, 30, 225, 187);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Mot se passe");
		lblNewLabel_1_2.setForeground(new Color(161, 164, 185));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1_2.setBounds(44, 353, 287, 46);
		panel_1.add(lblNewLabel_1_2);
		
		loginText = new JTextField();
		loginText.setHorizontalAlignment(SwingConstants.CENTER);
		loginText.setFont(new Font("Tahoma", Font.BOLD, 12));
		loginText.setColumns(10);
		loginText.setBounds(44, 287, 309, 37);
		panel_1.add(loginText);
		
		motpasse = new JPasswordField();
		motpasse.setBounds(44, 395, 309, 37);
		panel_1.add(motpasse);
		
		JButton btnConnecter = new JButton("Connecter");
		btnConnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					if(loginText.getText().equals("") || motpasse.getText().equals("") )
					 {
				            JOptionPane.showMessageDialog(null, "Certains champs sont vides");
				        }
					 else {
						
					
					String user=loginText.getText().toString();
					String password=motpasse.getText().toString();
					
					 ResultSet rs;
					 PreparedStatement stm=null;
					 stm=conn.getConn().prepareStatement("select * from admin where username = ? and password = ? ");  
					 stm.setString(1,user);
					 stm.setString(2,password);
					 rs=stm.executeQuery();	
					 
					 int count=0;
					 while(rs.next()) {
//						 
						 nom=rs.getObject(4).toString();
						 prenom=rs.getObject(5).toString();
						 
						 count++;
					 }
					 
					if(count==0)
					 JOptionPane.showMessageDialog(null, "user or password wrong ");
					else {
						
						 
						     frmlogin.setVisible(false);
							 new Admin().setVisible(true); 
							 stm.close();
							 conn.getConn().close();
						 }
					
					
					  
					//step5 close the connection object  
					
						 
					 }
		 		}catch(Exception e){ System.out.println(e);} 
				
			}
		});
		btnConnecter.setBackground(new Color(54, 83, 175));
        
		btnConnecter.setForeground(new Color(161, 164, 185));
		btnConnecter.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		btnConnecter.setBounds(44, 508, 274, 46);
		panel_1.add(btnConnecter);
	}
}
