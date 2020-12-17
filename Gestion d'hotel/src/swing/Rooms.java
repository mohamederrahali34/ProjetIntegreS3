package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JProgressBar;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Rooms extends JFrame {

	private JPanel panelright;
	
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rooms frame = new Rooms();
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
	
	public Rooms() {
		setTitle("Rooms");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 891, 497);
		panelright = new JPanel();
		panelright.setBackground(new Color(65, 105, 225));
		panelright.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelright);
		panelright.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(183, 139, 692, 416);
		panelright.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", "101", "Family Room", "2000", "2", "2", "available"},
				{"2", "102", "Party favor", "8000", "6", "5", ""},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"No", "Room No", "Room type", "Cost", "Maximum People", "MaximumExtraBed", "availability"
			}
		));
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(55);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(99);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(5).setPreferredWidth(101);
		table.getColumnModel().getColumn(6).setResizable(false);
		table.getColumnModel().getColumn(6).setPreferredWidth(86);
		scrollPane.setViewportView(table);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setBackground(SystemColor.textHighlight);
		btnSearch.setBounds(739, 43, 113, 23);
		panelright.add(btnSearch);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBackground(SystemColor.textHighlight);
		btnReset.setForeground(SystemColor.text);
		btnReset.setBounds(739, 90, 113, 23);
		panelright.add(btnReset);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 182, 555);
		panelright.add(panel);
		panel.setLayout(null);
		
		JButton btnSignOut = new JButton("Sign Out");
		btnSignOut.setBounds(38, 427, 89, 23);
		panel.add(btnSignOut);
		
		JLabel lblNewLabel = new JLabel("mohamederrahali34@gmail.com");
		lblNewLabel.setBounds(10, 377, 162, 14);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(30, 144, 255));
		panel_1.setBounds(10, 173, 162, 42);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnReservation = new JButton("Reservation");
		btnReservation.setBackground(new Color(100, 149, 237));
		btnReservation.setBounds(24, 11, 117, 23);
		panel_1.add(btnReservation);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(30, 144, 255));
		panel_2.setLayout(null);
		panel_2.setBounds(10, 226, 162, 42);
		panel.add(panel_2);
		
		JButton btnRooms = new JButton("Rooms");
		btnRooms.setBackground(new Color(100, 149, 237));
		btnRooms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRooms.setBounds(24, 11, 117, 23);
		panel_2.add(btnRooms);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(30, 144, 255));
		panel_3.setLayout(null);
		panel_3.setBounds(10, 279, 162, 42);
		panel.add(panel_3);
		
		Header head = new Header();
		head.setBackground(new Color(30, 144, 255));
		head.setBounds(183, 0, 692, 60);
		panelright.add(head);
		
		JButton btnCustumerList = new JButton("Custumer List");
		btnCustumerList.setBackground(new Color(100, 149, 237));
		btnCustumerList.setBounds(24, 11, 117, 23);
		panel_3.add(btnCustumerList);
		
		
	}
}
