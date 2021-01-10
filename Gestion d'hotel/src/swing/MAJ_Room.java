package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

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
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;

public class MAJ_Room extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JTextField txtCout;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JButton btnSauvegarde;
	private JButton btnReinitialiser;
	private JComboBox cmbTypeChambre;
	private JButton btnReinitialiser_1;
	private JSlider sliderNbrePersonne;
	private JComboBox cmbEtat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MAJ_Room frame = new MAJ_Room();
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
	public MAJ_Room() {
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
		
		cmbTypeChambre = new JComboBox();
		cmbTypeChambre.setFont(new Font("Tahoma", Font.BOLD, 13));
		cmbTypeChambre.setModel(new DefaultComboBoxModel(new String[] {"R\u00E9guli\u00E8re", "Familiale", "Suite (luxe)"}));
		cmbTypeChambre.setBounds(169, 55, 296, 36);
		panel.add(cmbTypeChambre);
		
		btnReinitialiser = new JButton("Reinitialiser");
		btnReinitialiser.setBackground(SystemColor.textHighlight);
		btnReinitialiser.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnReinitialiser.setForeground(SystemColor.text);
		btnReinitialiser.setBounds(313, 302, 132, 36);
		panel.add(btnReinitialiser);
		
		btnSauvegarde = new JButton("Enregistrer");
		btnSauvegarde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Room r=new Room();
					Connection conn=r.connect();
					
					
					 String type_chambre= (String) cmbTypeChambre.getSelectedItem();
					 int nb_personnes=sliderNbrePersonne.getValue();
					 int etat= cmbEtat.getSelectedIndex();
					 float cout=Float.parseFloat(txtCout.getText());
					 
					 
					// create the java mysql update preparedstatement
				      String query = "update chambres set type_chambre = ?, nb_personnes=? , etat= ? , cout=? where no_chambre = ?";
				      PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);
				      preparedStmt.setString(1,type_chambre);
				      preparedStmt.setInt(2,nb_personnes);
				      preparedStmt.setInt(3, etat);
				      preparedStmt.setFloat(4, cout);
				      preparedStmt.setInt(5,Room.num_chambre_modifier);
				      // execute the java preparedstatement
				      preparedStmt.executeUpdate();
					 
					 
					 JOptionPane.showMessageDialog(null,"la chambre "+Room.num_chambre_modifier+" a été bien modifier !", "Confirmation :",JOptionPane.INFORMATION_MESSAGE);
						  
					  
					//step5 close the connection object  
					
					conn.close();
				}catch(Exception e1){ JOptionPane.showMessageDialog(null, e1.getMessage());}
			}
		});
		btnSauvegarde.setBackground(SystemColor.textHighlight);
		btnSauvegarde.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSauvegarde.setForeground(SystemColor.text);
		btnSauvegarde.setBounds(147, 302, 132, 36);
		panel.add(btnSauvegarde);
		
		btnReinitialiser_1 = new JButton("Annuler");
		btnReinitialiser_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new Room().setVisible(true);
			}
		});
		btnReinitialiser_1.setForeground(Color.WHITE);
		btnReinitialiser_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnReinitialiser_1.setBackground(SystemColor.textHighlight);
		btnReinitialiser_1.setBounds(482, 302, 132, 36);
		panel.add(btnReinitialiser_1);
		
		lblNewLabel_5 = new JLabel("Nombre de personne");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(79, 163, 163, 19);
		panel.add(lblNewLabel_5);
		
		lblNewLabel_4 = new JLabel("Etat");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(555, 55, 60, 25);
		panel.add(lblNewLabel_4);
		
		lblNewLabel_3 = new JLabel("Cout");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(544, 160, 75, 25);
		panel.add(lblNewLabel_3);
		
		lblNewLabel_2 = new JLabel("Type de chambre");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(0, 60, 163, 25);
		panel.add(lblNewLabel_2);
		
		txtCout = new JTextField("");
		txtCout.setHorizontalAlignment(SwingConstants.CENTER);
		txtCout.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtCout.setColumns(10);
		txtCout.setBounds(601, 145, 226, 36);
		panel.add(txtCout);
		
		sliderNbrePersonne = new JSlider();
		sliderNbrePersonne.setValue(1);
		sliderNbrePersonne.setToolTipText("");
		sliderNbrePersonne.setMinorTickSpacing(1);
		sliderNbrePersonne.setMinimum(1);
		sliderNbrePersonne.setMaximum(4);
		sliderNbrePersonne.setBounds(252, 160, 200, 26);
		panel.add(sliderNbrePersonne);
		
		 cmbEtat = new JComboBox();
		cmbEtat.setModel(new DefaultComboBoxModel(new String[] {"Libre", "Reserver"}));
		cmbEtat.setBounds(601, 55, 207, 36);
		panel.add(cmbEtat);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MAJ_Room.class.getResource("/images/Icons/alexander-kaunas-Fk9d0cxYqC4-unsplash (1).jpg")));
		lblNewLabel.setBounds(-112, 0, 991, 507);
		panel.add(lblNewLabel);
		
		
	}
}
