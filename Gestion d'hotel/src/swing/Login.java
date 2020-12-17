package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 1082, 622);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
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
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField.setColumns(10);
		textField.setBounds(44, 287, 309, 37);
		panel_1.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(44, 395, 309, 37);
		panel_1.add(passwordField);
		
		JButton btnConnecter = new JButton("Connecter");
		btnConnecter.setBackground(new Color(54, 83, 175));
        
		btnConnecter.setForeground(new Color(161, 164, 185));
		btnConnecter.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		btnConnecter.setBounds(44, 508, 129, 46);
		panel_1.add(btnConnecter);
		
		JButton btnCr = new JButton(" Cr\u00E9er un compte");
		btnCr.setForeground(new Color(161, 164, 185));
		btnCr.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCr.setBackground(new Color(54, 83, 175));
		btnCr.setBounds(197, 508, 225, 46);
		panel_1.add(btnCr);
	}
}
