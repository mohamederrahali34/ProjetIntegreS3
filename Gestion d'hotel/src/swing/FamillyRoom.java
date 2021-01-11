package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;

public class FamillyRoom extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FamillyRoom frame = new FamillyRoom();
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
	public FamillyRoom() {
		setBackground(Color.PINK);
		setTitle("Chambre familiale");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 907, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFamillyRoom = new JLabel("New label");
		lblFamillyRoom.setIcon(new ImageIcon(FamillyRoom.class.getResource("/images/Icons/test.png")));
		lblFamillyRoom.setBounds(10, 11, 614, 538);
		contentPane.add(lblFamillyRoom);
		
		JTextArea txtrLaChambreDite = new JTextArea();
		txtrLaChambreDite.setEditable(false);
		txtrLaChambreDite.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		txtrLaChambreDite.setText("La chambre dite familiale \r\nest en fait qu'une chambre \r\ndouble dans laquelle \r\non a ouvert le canap\u00E9 pour \r\navoir un canap\u00E9-lit et ou \r\nun lit enfant tr\u00E8s basique\r\n a \u00E9t\u00E9 coinc\u00E9 entre le lit \r\ndouble et le mur ! La \r\nsalle de bain,  suffisante pour \r\nun couple avec un enfant,\r\n est totalement  insuffisante \r\npour 5 personnes !");
		txtrLaChambreDite.setBounds(634, 109, 247, 331);
		contentPane.add(txtrLaChambreDite);
	}
}
