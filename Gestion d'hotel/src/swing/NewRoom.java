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

public class NewRoom extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JTextField textField;
	private JButton btnSave;
	private JButton btnSave_1;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel lblNewLabel;

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
		
		textField = new JTextField("");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField.setColumns(10);
		textField.setBounds(171, 84, 153, 37);
		panel.add(textField);
		
		btnSave = new JButton("Save");
		btnSave.setForeground(new Color(255, 255, 224));
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSave.setBackground(new Color(0, 176, 214));
		btnSave.setBounds(200, 500, 230, 52);
		panel.add(btnSave);
		
		btnSave_1 = new JButton("Save");
		btnSave_1.setForeground(new Color(255, 255, 224));
		btnSave_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSave_1.setBackground(new Color(0, 176, 214));
		btnSave_1.setBounds(543, 499, 230, 54);
		panel.add(btnSave_1);
		
		textField_1 = new JTextField("");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(172, 178, 153, 37);
		panel.add(textField_1);
		
		textField_2 = new JTextField("");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(172, 290, 153, 37);
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
		
		textField_5 = new JTextField("");
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_5.setColumns(10);
		textField_5.setBounds(699, 290, 153, 37);
		panel.add(textField_5);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(NewRoom.class.getResource("/images/Icons/alexander-kaunas-Fk9d0cxYqC4-unsplash (1).jpg")));
		lblNewLabel.setBounds(-11, 0, 1103, 600);
		panel.add(lblNewLabel);
	}
}
