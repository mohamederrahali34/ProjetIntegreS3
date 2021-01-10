package swing;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Panel;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.border.Border;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import com.toedter.calendar.JDateChooser;


public class ModifierR extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField NoRm;
	private Statement stm ;
	static int id_exemp ;
	private JTextField CINRm;
	private JTextField NB_NuitsRm;
	private JTextField NB_PersonnesRm;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer frame = new Customer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public int getId_exemplaire() {
		return id_exemp;
	}

	
	public ModifierR() {
		setType(Type.UTILITY);
		setTitle("Modifier");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 910, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 252, 435);
		panel.setBackground(new Color(244, 244, 244));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnAfficher = new JButton("Listes des r\u00E9servations");
		
		btnAfficher.setForeground(new Color(255, 255, 224));
		btnAfficher.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAfficher.setBackground(new Color(0, 176, 214));
		btnAfficher.setBounds(10, 175, 232, 56);
		panel.add(btnAfficher);
		
		
		Icon icon = new ImageIcon(Customer.class.getResource("/images/Icons/585e4bf3cb11b227491c339a_a8u_icon.ico"));
		JLabel lblNewLabel = new JLabel(icon);
		
		lblNewLabel.setBounds(29, 492, 80, 36);
		panel.add(lblNewLabel);
		
		
		Panel panel_2 = new Panel();
		panel_2.setBounds(252, 0, 642, 477);
		panel_2.setBackground(Color.WHITE);    
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		NoRm = new JTextField();
		NoRm.setText("1");
		NoRm.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				DefaultTableModel dm ;
		   		JTable table = null;
				dm=(DefaultTableModel) table.getModel();
				
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dm);
		 		table.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(NoRm.getText().toString()));
			}
		});
		NoRm.setFont(new Font("Tahoma", Font.BOLD, 12));
		NoRm.setBounds(120, 36, 153, 37);
		NoRm.setHorizontalAlignment(JTextField.CENTER);
		panel_2.add(NoRm);
		NoRm.setColumns(10);
		
		CINRm = new JTextField();
		CINRm.setText("JB12345");
		CINRm.setHorizontalAlignment(SwingConstants.CENTER);
		CINRm.setFont(new Font("Tahoma", Font.BOLD, 12));
		CINRm.setColumns(10);
		CINRm.setBounds(120, 84, 153, 37);
		panel_2.add(CINRm);
		
		JButton search = new JButton("Enregistrer");
		search.setForeground(new Color(255, 255, 224));
		search.setFont(new Font("Tahoma", Font.BOLD, 12));
		search.setBackground(new Color(113, 202, 216));
		search.setBounds(287, 324, 130, 37);
		

		panel_2.add(search);
		
		NB_NuitsRm = new JTextField();
		NB_NuitsRm.setText("3");
		NB_NuitsRm.setHorizontalAlignment(SwingConstants.CENTER);
		NB_NuitsRm.setFont(new Font("Tahoma", Font.BOLD, 12));
		NB_NuitsRm.setColumns(10);
		NB_NuitsRm.setBounds(120, 180, 153, 37);
		panel_2.add(NB_NuitsRm);
		
		JLabel lblNewLabel_1 = new JLabel("No");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(47, 48, 46, 14);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CIN");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(47, 96, 46, 14);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Date_R");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(47, 144, 46, 14);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("NB_Nuits");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(47, 191, 63, 14);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Date_A");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(393, 47, 68, 14);
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Date_D");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(393, 95, 96, 14);
		panel_2.add(lblNewLabel_6);
		
		NB_PersonnesRm = new JTextField();
		NB_PersonnesRm.setText("2");
		NB_PersonnesRm.setHorizontalAlignment(SwingConstants.CENTER);
		NB_PersonnesRm.setFont(new Font("Tahoma", Font.BOLD, 12));
		NB_PersonnesRm.setColumns(10);
		NB_PersonnesRm.setBounds(484, 133, 153, 37);
		panel_2.add(NB_PersonnesRm);
		
		JLabel lblNewLabel_7 = new JLabel("NB_Personnes");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(393, 144, 96, 14);
		panel_2.add(lblNewLabel_7);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(120, 132, 153, 37);
		panel_2.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(484, 36, 153, 37);
		panel_2.add(dateChooser_1);
		
		JDateChooser dateChooser_2 = new JDateChooser();
		dateChooser_2.setBounds(484, 84, 153, 37);
		panel_2.add(dateChooser_2);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setIcon(new ImageIcon(ModifierR.class.getResource("/hotele4-triangle.jpg")));
		lblNewLabel_8.setBounds(0, -12, 642, 465);
		panel_2.add(lblNewLabel_8);
		
		
		Object[][] donnees = {
                {"1", "1", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"2", "2", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"3", "3", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"4", "4", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"5", "5", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"6", "6", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"7", "7", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"8", "8", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"9", "9", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"10", "10", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"11", "11", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"12", "12", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"13", "13", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"14", "14", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"15", "15", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"16", "16", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"17", "17", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"18", "8", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"11", "11", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"12", "12", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"13", "13", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"14", "14", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"15", "15", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"16", "16", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"17", "17", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"18", "8", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"11", "11", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"12", "12", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"13", "13", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"14", "14", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"15", "15", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"16", "16", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"17", "17", "Name", "17/12/2020","3","18/12/2020","21/12/2020"},
                {"18", "8", "Name", "17/12/2020","3","18/12/2020","21/12/2020"}
        };
 
        String[] entetes = {"No", "RoomNo", "Name", "DateReservation","NbrDeJour", "DateDebut","DateFin"};
		String st = "hamza";
		
		
		
	}
}