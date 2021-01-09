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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;

public class MAJ_Room extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JTextField textField;
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
	private JComboBox comboBox;
	private JButton btnReinitialiser_1;
	private JSlider slider;

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
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"la norme ", "Sup\u00E9rieur ", "Suite   ;", "Mini suite  ", "Suite junior   ", "Suite Senior .", "Suite King   ", "La salle a manger  ", "Chambre ar un nive ", "Appartements   ", "Ex\u00E9cutif  ", "Studio  ", "Chambre lune de miel  ", "Suite Lune de Miel   ", "Duplex "}));
		comboBox.setBounds(167, 155, 296, 36);
		panel.add(comboBox);
		
		btnReinitialiser = new JButton("Reinitialiser");
		btnReinitialiser.setBackground(SystemColor.textHighlight);
		btnReinitialiser.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnReinitialiser.setForeground(SystemColor.text);
		btnReinitialiser.setBounds(333, 347, 132, 36);
		panel.add(btnReinitialiser);
		
		btnSauvegarde = new JButton("Enregistrer");
		btnSauvegarde.setBackground(SystemColor.textHighlight);
		btnSauvegarde.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSauvegarde.setForeground(SystemColor.text);
		btnSauvegarde.setBounds(167, 347, 132, 36);
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
		btnReinitialiser_1.setBounds(494, 347, 132, 36);
		panel.add(btnReinitialiser_1);
		
		lblNewLabel_5 = new JLabel("Nombre de personne");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(215, 251, 163, 19);
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
		lblNewLabel_2.setBounds(10, 160, 163, 25);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_1 = new JLabel("No de chambre");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setBounds(26, 62, 163, 25);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField("");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField.setColumns(10);
		textField.setBounds(171, 51, 292, 36);
		panel.add(textField);
		
		textField_3 = new JTextField("");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_3.setColumns(10);
		textField_3.setBounds(601, 50, 256, 37);
		panel.add(textField_3);
		
		textField_4 = new JTextField("");
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_4.setColumns(10);
		textField_4.setBounds(601, 145, 256, 36);
		panel.add(textField_4);
		
		slider = new JSlider();
		slider.setValue(1);
		slider.setToolTipText("");
		slider.setMinorTickSpacing(1);
		slider.setMinimum(1);
		slider.setMaximum(4);
		slider.setBounds(379, 244, 200, 26);
		panel.add(slider);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MAJ_Room.class.getResource("/images/Icons/alexander-kaunas-Fk9d0cxYqC4-unsplash (1).jpg")));
		lblNewLabel.setBounds(-112, 0, 991, 507);
		panel.add(lblNewLabel);
		
		
	}
}
