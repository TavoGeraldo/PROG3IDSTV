package idstv;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class Ventana2 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana2 window = new Ventana2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 713, 542);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 697, 33);
		panel.setBackground(new Color(128, 255, 128));
		frame.getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Registro de usuario");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBackground(new Color(0, 255, 128));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 255, 128));
		panel_1.setBounds(0, 31, 697, 472);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(2, 2, 10, 10));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 128, 128));
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Datos Generales");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 5, 126, 14);
		lblNewLabel_1.setHorizontalAlignment(JLabel.LEFT);
		panel_3.add(lblNewLabel_1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 128, 128));
		panel_6.setBounds(0, 22, 319, 206);
		panel_3.add(panel_6);
		panel_6.setLayout(new GridLayout(7, 2, 10, 10));
		
		JLabel lblNewLabel_2 = new JLabel("Nombres:");
		lblNewLabel_2.setBackground(new Color(255, 128, 128));
		lblNewLabel_2.setBorder(BorderFactory.createMatteBorder(0, 70, 0, 0, new Color(255, 128, 128)));
		panel_6.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 30, new Color(255, 128, 128)));
		panel_6.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Apellido Paterno:");
		lblNewLabel_4.setBorder(BorderFactory.createMatteBorder(0, 50, 0, 0, new Color(255, 128, 128)));
		panel_6.add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 50, new Color(255, 128, 128)));
		panel_6.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Apellido Paterno:");
		lblNewLabel_6.setBorder(BorderFactory.createMatteBorder(0, 50, 0, 0, new Color(255, 128, 128)));
		panel_6.add(lblNewLabel_6);
		
		textField_2 = new JTextField();
		textField_2.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 50, new Color(255, 128, 128)));
		panel_6.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Fecha Nacimiento:");
		lblNewLabel_8.setBorder(BorderFactory.createMatteBorder(0, 50, 0, 0, new Color(255, 128, 128)));
		panel_6.add(lblNewLabel_8);
		
		textField_3 = new JTextField();
		textField_3.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 30, new Color(255, 128, 128)));
		panel_6.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Sexo:");
		lblNewLabel_10.setBorder(BorderFactory.createMatteBorder(0, 90, 0, 0, new Color(255, 128, 128)));
		panel_6.add(lblNewLabel_10);
		
		
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Masculino");
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setBackground(new Color(255, 128, 128));
		panel_6.add(rdbtnNewRadioButton);
		
		JLabel lblNewLabel_12 = new JLabel("");
		panel_6.add(lblNewLabel_12);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Femenino");
		rdbtnNewRadioButton_1.setBackground(new Color(255, 128, 128));
		panel_6.add(rdbtnNewRadioButton_1);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_14 = new JLabel("Nacionalidad:");
		lblNewLabel_14.setBorder(BorderFactory.createMatteBorder(0, 70, 0, 0, new Color(255, 128, 128)));
		panel_6.add(lblNewLabel_14);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"México", "Perú", "Argentina"}));
		comboBox.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 40, new Color(255, 128, 128)));
		panel_6.add(comboBox);
		
		//Segundo Panel
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(128, 255, 255));
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		
		JLabel lblNewLabel_3 = new JLabel("Datos Generales");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 0, 132, 29);
		lblNewLabel_3.setHorizontalAlignment(JLabel.LEFT);
		panel_2.add(lblNewLabel_3);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 255, 255));
		panel_7.setBounds(83, 38, 132, 119);
		panel_2.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Imagen");
		lblNewLabel_5.setBounds(44, 51, 46, 14);
		panel_7.add(lblNewLabel_5);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Mostrar foto de perfil");
		chckbxNewCheckBox.setBackground(new Color(128, 255, 255));
		chckbxNewCheckBox.setBounds(83, 166, 145, 23);
		panel_2.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Mostrar fecha de nacimiento");
		chckbxNewCheckBox_1.setBackground(new Color(128, 255, 255));
		chckbxNewCheckBox_1.setBounds(67, 192, 193, 23);
		panel_2.add(chckbxNewCheckBox_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(128, 255, 255));
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Datos opcionales");
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_7.setBounds(10, 11, 139, 14);
		panel_4.add(lblNewLabel_7);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(159, 77, 150, 113);
		panel_4.add(scrollPane);
		
		JTextArea txtrCantarEscucharMsica = new JTextArea();
		txtrCantarEscucharMsica.setFont(new Font("Arial", Font.PLAIN, 13));
		txtrCantarEscucharMsica.setText("Cantar\nEscuchar música\nLeer\nDeportes\nOtros");
		scrollPane.setViewportView(txtrCantarEscucharMsica);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(23, 77, 126, 113);
		panel_4.add(scrollPane_1);
		
		JTextArea txtrHolaAmigosDe = new JTextArea();
		txtrHolaAmigosDe.setFont(new Font("Arial", Font.PLAIN, 13));
		scrollPane_1.setViewportView(txtrHolaAmigosDe);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		txtrHolaAmigosDe.setText("Hola amigos \r\nde youtube\r\ngracias por \r\ncompartir mi videos\r\n");
		
		JLabel lblNewLabel_9 = new JLabel("Descripción");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_9.setBounds(23, 52, 69, 14);
		panel_4.add(lblNewLabel_9);
		
		JLabel lblNewLabel_11 = new JLabel("Preferencias");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_11.setBounds(159, 52, 81, 14);
		panel_4.add(lblNewLabel_11);
		
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 128, 128));
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		
		
		
		
		JButton btnNewButton_1 = new JButton("Guardar");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 0, 64));
		btnNewButton_1.setBounds(107, 88, 89, 23);
		panel_5.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Salir");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(0, 0, 64));
		btnNewButton_2.setBounds(107, 122, 89, 23);
		panel_5.add(btnNewButton_2);
		
		JButton btnNewButton_1_1 = new JButton("Nuevo");
		btnNewButton_1_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1_1.setBackground(new Color(0, 0, 64));
		btnNewButton_1_1.setBounds(107, 54, 89, 23);
		panel_5.add(btnNewButton_1_1);
	}
}
