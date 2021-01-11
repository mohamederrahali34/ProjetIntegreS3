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

public class RoomLuxe extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoomLuxe frame = new RoomLuxe();
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
	public RoomLuxe() {
		setResizable(false);
		setBackground(Color.PINK);
		setTitle("Chambre familiale");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 907, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFamillyRoom = new JLabel("");
		lblFamillyRoom.setIcon(new ImageIcon(RoomLuxe.class.getResource("/images/Icons/luxe.png")));
		lblFamillyRoom.setBounds(10, 11, 614, 538);
		contentPane.add(lblFamillyRoom);
		
		JTextArea txtrLaChambreDite = new JTextArea();
		txtrLaChambreDite.setEditable(false);
		txtrLaChambreDite.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		txtrLaChambreDite.setText(" les chambres de luxe rappellent \r\ndes appartements ou des petites \r\nsuites, avec des coins salons \r\nconfortables, une t\u00E9l\u00E9vision\r\n \u00E0 \u00E9cran plasma g\u00E9ante et \r\nparfois des \u00E9quipements tels qu'un\r\n jacuzzi dans la salle de bain.\r\n Les suppl\u00E9ments varient\r\n \u00E9norm\u00E9ment d'une offre \u00E0 l'autre.");
		txtrLaChambreDite.setBounds(634, 109, 247, 331);
		contentPane.add(txtrLaChambreDite);
		
		JLabel lblNewLabel = new JLabel("Chambre luxe");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(676, 38, 143, 34);
		contentPane.add(lblNewLabel);
	}
}
