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
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JToggleButton;
import javax.swing.JSlider;

public class NewRoom extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTextField txtCoutEnMad;
	private JTextField textField_9;

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
		
		JButton button = new JButton("Enregistrer");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 13));
		button.setBackground(SystemColor.textHighlight);
		button.setBounds(309, 364, 132, 36);
		panel.add(button);
		
		JButton button_1 = new JButton("Reinitialiser");
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		button_1.setBackground(SystemColor.textHighlight);
		button_1.setBounds(475, 364, 132, 36);
		panel.add(button_1);
		
		JButton button_2 = new JButton("Annuler");
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		button_2.setBackground(SystemColor.textHighlight);
		button_2.setBounds(636, 364, 132, 36);
		panel.add(button_2);
		
		txtCoutEnMad = new JTextField("cout en MAD");
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"R\u00E9guli\u00E8re", "Familiale", "Suite (luxe)"}));
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox.setBounds(167, 165, 296, 36);
		panel.add(comboBox);
		
		textField_9 = new JTextField("");
		textField_9.setHorizontalAlignment(SwingConstants.CENTER);
		textField_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_9.setColumns(10);
		textField_9.setBounds(171, 61, 292, 36);
		panel.add(textField_9);
		
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
		
		JSlider slider = new JSlider();
		slider.setToolTipText("");
		slider.setValue(1);
		slider.setMinorTickSpacing(1);
		slider.setMinimum(1);
		slider.setMaximum(4);
		slider.setBounds(407, 254, 200, 26);
		panel.add(slider);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(625, 65, 183, 36);
		panel.add(comboBox_1);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(NewRoom.class.getResource("/images/Icons/alexander-kaunas-Fk9d0cxYqC4-unsplash (1).jpg")));
		lblNewLabel.setBounds(0, 0, 1103, 499);
		panel.add(lblNewLabel);
	}
}
