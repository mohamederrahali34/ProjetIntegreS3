package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;

public class MAJ_Room extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JButton btnSauvegarde;
	private JButton btnReinitialiser;
	private JButton btnSupprimer;
	private JComboBox comboBox;

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
		setBounds(100, 100, 1091, 635);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 1102, 611);
		contentPane.add(panel);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"la norme ", "Sup\u00E9rieur ", "Suite   ;", "Mini suite  ", "Suite junior   ", "Suite Senior .", "Suite King   ", "La salle a manger  ", "Chambre ar un nive ", "Appartements   ", "Ex\u00E9cutif  ", "Studio  ", "Chambre lune de miel  ", "Suite Lune de Miel   ", "Duplex "}));
		comboBox.setBounds(167, 188, 163, 31);
		panel.add(comboBox);
		
		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSupprimer.setForeground(SystemColor.text);
		btnSupprimer.setBounds(555, 388, 121, 23);
		panel.add(btnSupprimer);
		
		btnReinitialiser = new JButton("Reinitialiser");
		btnReinitialiser.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnReinitialiser.setForeground(SystemColor.text);
		btnReinitialiser.setBounds(393, 388, 121, 23);
		panel.add(btnReinitialiser);
		
		btnSauvegarde = new JButton("Enregistrer");
		btnSauvegarde.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSauvegarde.setForeground(SystemColor.text);
		btnSauvegarde.setBounds(235, 388, 112, 23);
		panel.add(btnSauvegarde);
		
		lblNewLabel_5 = new JLabel("Nombre de personne");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(526, 188, 163, 19);
		panel.add(lblNewLabel_5);
		
		lblNewLabel_4 = new JLabel("Etat");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(660, 95, 60, 25);
		panel.add(lblNewLabel_4);
		
		lblNewLabel_3 = new JLabel("Cout");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(320, 271, 75, 25);
		panel.add(lblNewLabel_3);
		
		lblNewLabel_2 = new JLabel("Type de chambre");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(10, 185, 679, 25);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_1 = new JLabel("No de chambre");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setBounds(26, 95, 663, 25);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField("");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField.setColumns(10);
		textField.setBounds(171, 84, 153, 37);
		panel.add(textField);
		
		textField_2 = new JTextField("");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(393, 266, 153, 37);
		panel.add(textField_2);
		
		textField_3 = new JTextField("");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_3.setColumns(10);
		textField_3.setBounds(699, 88, 153, 37);
		panel.add(textField_3);
		
		textField_4 = new JTextField("");
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_4.setColumns(10);
		textField_4.setBounds(699, 178, 153, 37);
		panel.add(textField_4);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MAJ_Room.class.getResource("/images/Icons/alexander-kaunas-Fk9d0cxYqC4-unsplash (1).jpg")));
		lblNewLabel.setBounds(-11, 0, 1103, 600);
		panel.add(lblNewLabel);
	}
}
