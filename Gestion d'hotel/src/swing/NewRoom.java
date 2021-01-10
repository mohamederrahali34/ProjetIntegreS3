package swing;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JToggleButton;
import javax.swing.JSlider;

import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;


public class NewRoom extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTextField txtCoutEnMad;
	private JTextField txtNbreChambre;
	
	private JButton btnEnregistrer ;
	private JButton btnReinitialiser ;
	private JButton btnAnnuler ;
	private JComboBox cmbTypeChambre;
	private JSlider sliderNbrePersonne;
	private JComboBox cmbEtat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewRoom frame = new NewRoom();
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
	public NewRoom() {
		setTitle("Enregistrer une chambre");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 951, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 1102, 611);
		contentPane.add(panel);
		
		btnEnregistrer=new JButton("Enregistrer");
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Room r=new Room();
					Connection conn=r.connect();
					
					 int no_chambre=Integer.parseInt(txtNbreChambre.getText());
					 String type_chambre= (String) cmbTypeChambre.getSelectedItem();
					 int nb_personne=sliderNbrePersonne.getValue();
					 int etat= cmbEtat.getSelectedIndex();
					 float cost=Float.parseFloat(txtCoutEnMad.getText());
					 
					 
					 String requete="insert into chambres value("+no_chambre+",'"+type_chambre+"',"+nb_personne+",'"+etat+"',"+cost+")";
					 // create a Statement from the connection
					 Statement statement = conn.createStatement();
					 	
					 // insert the data
					
					 statement.executeUpdate(requete);
					  
					 
					 JOptionPane.showMessageDialog(null,"la chambre "+no_chambre+" a été bien ajoutée !", "Confirmation :",JOptionPane.INFORMATION_MESSAGE);
						  
					  
					//step5 close the connection object  
					
					conn.close();
				}catch(Exception e1){ JOptionPane.showMessageDialog(null, e1.getMessage());}
			}
		});
		btnEnregistrer.setForeground(Color.WHITE);
		btnEnregistrer.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEnregistrer.setBackground(SystemColor.textHighlight);
		btnEnregistrer.setBounds(309, 364, 132, 36);
		panel.add(btnEnregistrer);
		
		btnReinitialiser = new JButton("Reinitialiser");
		btnReinitialiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 txtNbreChambre.setText("");
				 cmbTypeChambre.setSelectedIndex(0);
				 sliderNbrePersonne.setValue(1);
				 cmbEtat.setSelectedIndex(0);
				 txtCoutEnMad.setText("");
			}
		});
		btnReinitialiser.setForeground(Color.WHITE);
		btnReinitialiser.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnReinitialiser.setBackground(SystemColor.textHighlight);
		btnReinitialiser.setBounds(475, 364, 132, 36);
		panel.add(btnReinitialiser);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnAnnuler.setForeground(Color.WHITE);
		btnAnnuler.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAnnuler.setBackground(SystemColor.textHighlight);
		btnAnnuler.setBounds(636, 364, 132, 36);
		panel.add(btnAnnuler);
		
		txtCoutEnMad = new JTextField("");
		txtCoutEnMad.setHorizontalAlignment(SwingConstants.CENTER);
		txtCoutEnMad.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtCoutEnMad.setColumns(10);
		txtCoutEnMad.setBounds(601, 155, 256, 36);
		panel.add(txtCoutEnMad);
		
		JLabel label = new JLabel("Etat");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setBounds(555, 65, 60, 25);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Cout");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_1.setBounds(544, 170, 75, 25);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Nombre de personne");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_2.setBounds(215, 261, 163, 19);
		panel.add(label_2);
		
		 cmbTypeChambre = new JComboBox();
		cmbTypeChambre.setModel(new DefaultComboBoxModel(new String[] {"R\u00E9guli\u00E8re", "Familiale", "Suite (luxe)"}));
		cmbTypeChambre.setFont(new Font("Tahoma", Font.BOLD, 13));
		cmbTypeChambre.setBounds(167, 165, 296, 36);
		panel.add(cmbTypeChambre);
		
		txtNbreChambre = new JTextField("");
		txtNbreChambre.setHorizontalAlignment(SwingConstants.CENTER);
		txtNbreChambre.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtNbreChambre.setColumns(10);
		txtNbreChambre.setBounds(171, 61, 292, 36);
		panel.add(txtNbreChambre);
		
		JLabel label_3 = new JLabel("No de chambre");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_3.setBackground(Color.BLACK);
		label_3.setBounds(26, 72, 163, 25);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Type de chambre");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_4.setBounds(10, 162, 679, 25);
		panel.add(label_4);
		
		sliderNbrePersonne = new JSlider();
		sliderNbrePersonne.setToolTipText("");
		sliderNbrePersonne.setValue(1);
		sliderNbrePersonne.setMinorTickSpacing(1);
		sliderNbrePersonne.setMinimum(1);
		sliderNbrePersonne.setMaximum(4);
		sliderNbrePersonne.setBounds(407, 254, 200, 26);
		panel.add(sliderNbrePersonne);
		
		 cmbEtat = new JComboBox();
		 cmbEtat.setModel(new DefaultComboBoxModel(new String[] {"Libre", "Reserver", "Oucuper"}));
		cmbEtat.setBounds(625, 65, 183, 36);
		panel.add(cmbEtat);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(NewRoom.class.getResource("/images/Icons/alexander-kaunas-Fk9d0cxYqC4-unsplash (1).jpg")));
		lblNewLabel.setBounds(0, 0, 1103, 499);
		panel.add(lblNewLabel);
		
		
	}
}
