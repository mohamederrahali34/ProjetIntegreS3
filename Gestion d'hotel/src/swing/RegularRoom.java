package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;

public class RegularRoom extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegularRoom frame = new RegularRoom();
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
	
	public RegularRoom() {
		setResizable(false);
		setTitle("Chambres r\u00E9guli\u00E8res");
		setBounds(100, 100, 858, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegularRoom = new JLabel("New label");
		lblRegularRoom.setIcon(new ImageIcon(Room.class.getResource("/images/Icons/similar.png")));
		lblRegularRoom.setBounds(0, 0, 614, 456);
		contentPane.add(lblRegularRoom);
		
		JTextArea txtrDfgdgdfgGjtyyt = new JTextArea();
		txtrDfgdgdfgGjtyyt.setEditable(false);
		txtrDfgdgdfgGjtyyt.setText("Des chambres modernes \r\net spacieuses qui vous \r\noffrent le confort que \r\nvous recherchez\r\n, \u00E0 prix abordable :\r\n-Deux lits Queen\r\n-Salle de bain compl\u00E8te \r\ndans la chambre incluant\r\n s\u00E8che-cheveux\r\n-Bureau\r\n-T\u00E9l\u00E9viseur \u00E0 \u00E9cran plat\r\n haute-d\u00E9finition\r\n-R\u00E9frig\u00E9rateur compact\r\n-Cafeti\u00E8re filtre\r\n-Four \u00E0 micro-ondes\r\n-Table ronde et fauteuils");
		txtrDfgdgdfgGjtyyt.setBounds(624, 117, 208, 273);
		contentPane.add(txtrDfgdgdfgGjtyyt);
		
		JLabel lblNewLabel = new JLabel("LES CHAMBRES R\u00C9GULI\u00C8RES");
		lblNewLabel.setBackground(Color.PINK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(622, 52, 195, 54);
		contentPane.add(lblNewLabel);
	}
}
