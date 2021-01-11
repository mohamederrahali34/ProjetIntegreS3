package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;

public class MAJ_Client extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JTextField cin;
	private JTextField tel;
	private JTextField ville;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel ad;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JButton btnSauvegarde;
	private JButton btnReinitialiser;
	private JButton btnReinitialiser_1;
	private JTextField nom;
	private JTextField prenom;
	private JTextField adresse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MAJ_Client frame = new MAJ_Client();
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.tt
	 */
	public MAJ_Client() {
		setTitle("Modifier la chambre");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 886, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 1102, 496);
		contentPane.add(panel);
		
		btnReinitialiser = new JButton("Reinitialiser");
		btnReinitialiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nom.setText("");
				cin.setText("");
				prenom.setText("");
				tel.setText("");
				ville.setText("");
				adresse.setText("");
				
			}
		});
		btnReinitialiser.setBackground(SystemColor.textHighlight);
		btnReinitialiser.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnReinitialiser.setForeground(SystemColor.text);
		btnReinitialiser.setBounds(333, 347, 132, 36);
		panel.add(btnReinitialiser);
		
		btnSauvegarde = new JButton("Enregistrer");
		btnSauvegarde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


				
				try{
					 
					int CIN = Integer.parseInt(cin.getText().toString());
					String name = nom.getText().toString();
					String sname = prenom.getText().toString();  
					String tele = tel.getText().toString();
					String city = ville.getText().toString();
					String adr = adresse.getText().toString();
				         
					DbConnect conn=new DbConnect() ;
				        
						 PreparedStatement stm=null;
			           	stm=conn.getConn().prepareStatement("UPDATE `client` SET  `CIN` = ?, `Nom` = ?, `prenom` = ?, `tel` = ?, `ville` = ?, `adresse` = ? WHERE `client`.`CIN` = ? ");  
						 
			           	stm.setInt(1,CIN);
			           	stm.setString(2, name);
			         	stm.setString(3, sname);
			         	stm.setString(4, tele);
			         	stm.setString(5, city);
			         	stm.setString(6, adr);
			         	stm.setString(7, new Customer().getCIN());
						 
				        stm.executeUpdate();

				         JOptionPane.showMessageDialog(null, "le client est modifie !");
				         stm.close();
						 conn.getConn().close();
						 setVisible(false);
						 new Customer().setVisible(true);
				        }  
				    catch(Exception er)
				    {
				        JOptionPane.showMessageDialog(null,er);
				    } 
				
			}
		});
		btnSauvegarde.setBackground(SystemColor.textHighlight);
		btnSauvegarde.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSauvegarde.setForeground(SystemColor.text);
		btnSauvegarde.setBounds(167, 347, 132, 36);
		panel.add(btnSauvegarde);
		
		btnReinitialiser_1 = new JButton("Annuler");
		btnReinitialiser_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnReinitialiser_1.setForeground(Color.WHITE);
		btnReinitialiser_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnReinitialiser_1.setBackground(SystemColor.textHighlight);
		btnReinitialiser_1.setBounds(494, 347, 132, 36);
		panel.add(btnReinitialiser_1);
		
		lblNewLabel_5 = new JLabel("Prenom");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(43, 267, 104, 36);
		panel.add(lblNewLabel_5);
		
		prenom = new JTextField(new Customer().getPrenom());
		prenom.setHorizontalAlignment(SwingConstants.CENTER);
		prenom.setFont(new Font("Tahoma", Font.BOLD, 12));
		prenom.setColumns(10);
		prenom.setBounds(167, 277, 224, 36);
		panel.add(prenom);
		nom = new JTextField(new Customer().getNom());
		nom.setHorizontalAlignment(SwingConstants.CENTER);
		nom.setFont(new Font("Tahoma", Font.BOLD, 12));
		nom.setColumns(10);
		nom.setBounds(173, 153, 218, 36);
		panel.add(nom);
		
		lblNewLabel_4 = new JLabel("Tel");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(522, 55, 67, 25);
		panel.add(lblNewLabel_4);
		
		ad = new JLabel("Adresse");
		ad.setFont(new Font("Tahoma", Font.BOLD, 15));
		ad.setForeground(Color.WHITE);
		ad.setBounds(522, 281, 75, 25);
		panel.add(ad);
		
		JLabel ad_1 = new JLabel("Ville");
		ad_1.setForeground(Color.WHITE);
		ad_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		ad_1.setBounds(522, 157, 75, 25);
		panel.add(ad_1);
		
		adresse = new JTextField(new Customer().getAdresse());
		adresse.setHorizontalAlignment(SwingConstants.CENTER);
		adresse.setFont(new Font("Tahoma", Font.BOLD, 12));
		adresse.setColumns(10);
		adresse.setBounds(610, 267, 218, 36);
		panel.add(adresse);
		
		lblNewLabel_2 = new JLabel("Nom");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(43, 160, 75, 25);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_1 = new JLabel("CIN");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setBounds(57, 55, 104, 25);
		panel.add(lblNewLabel_1);
		
		cin = new JTextField(new Customer().getCIN());
		cin.setHorizontalAlignment(SwingConstants.CENTER);
		cin.setFont(new Font("Tahoma", Font.BOLD, 12));
		cin.setColumns(10);
		cin.setBounds(171, 51, 220, 36);
		panel.add(cin);
		
		tel = new JTextField(new Customer().getTel());
		tel.setHorizontalAlignment(SwingConstants.CENTER);
		tel.setFont(new Font("Tahoma", Font.BOLD, 12));
		tel.setColumns(10);
		tel.setBounds(608, 50, 210, 37);
		panel.add(tel);
		
		ville = new JTextField(new Customer().getVille());
		ville.setHorizontalAlignment(SwingConstants.CENTER);
		ville.setFont(new Font("Tahoma", Font.BOLD, 12));
		ville.setColumns(10);
		ville.setBounds(610, 153, 218, 36);
		panel.add(ville);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MAJ_Client.class.getResource("/images/Icons/alexander-kaunas-Fk9d0cxYqC4-unsplash (1).jpg")));
		lblNewLabel.setBounds(-114, 0, 991, 507);
		panel.add(lblNewLabel);
		
		
		
		
	}
}
