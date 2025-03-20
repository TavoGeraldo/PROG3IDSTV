package idstv;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Memorama extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Memorama frame = new Memorama();
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
	public Memorama() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 754, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton_16 = new JButton("Jugar de nuevo");
		panel_1.add(btnNewButton_16);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 128, 128));
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(192, 192, 192));
		panel_2.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Puntuación:");
		panel_3.add(lblNewLabel_1, BorderLayout.WEST);
		
		JLabel lblNewLabel = new JLabel("Memorama");
		lblNewLabel.setBackground(new Color(192, 192, 192));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		panel_3.add(lblNewLabel, BorderLayout.CENTER);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(192, 192, 192));
		panel_2.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(4, 4, 10, 10));
		
		JButton btnNewButton = new JButton("?");
		btnNewButton.setSelectedIcon(new ImageIcon(Memorama.class.getResource("/idstv/signoDePregunta.png")));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(Color.decode("#f25c54"));
		panel_4.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("?");
		btnNewButton_1.setSelectedIcon(new ImageIcon(Memorama.class.getResource("/idstv/signoDePregunta.png")));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(Color.decode("#f25c54"));
		panel_4.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("?");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(Color.decode("#f25c54"));
		panel_4.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("?");
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(Color.decode("#f25c54"));
		panel_4.add(btnNewButton_3);
		
		JButton btnNewButton_12 = new JButton("?");
		btnNewButton_12.setForeground(new Color(255, 255, 255));
		btnNewButton_12.setBackground(Color.decode("#f25c54"));
		panel_4.add(btnNewButton_12);
		
		JButton btnNewButton_4 = new JButton("?");
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setBackground(Color.decode("#f25c54"));
		panel_4.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("?");
		btnNewButton_5.setForeground(new Color(255, 255, 255));
		btnNewButton_5.setBackground(Color.decode("#f25c54"));
		panel_4.add(btnNewButton_5);
		
		JButton btnNewButton_9 = new JButton("?");
		btnNewButton_9.setForeground(new Color(255, 255, 255));
		btnNewButton_9.setBackground(Color.decode("#f25c54"));
		panel_4.add(btnNewButton_9);
		
		JButton btnNewButton_6 = new JButton("?");
		btnNewButton_6.setForeground(new Color(255, 255, 255));
		btnNewButton_6.setBackground(Color.decode("#f25c54"));
		panel_4.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("?");
		btnNewButton_7.setForeground(new Color(255, 255, 255));
		btnNewButton_7.setBackground(Color.decode("#f25c54"));
		panel_4.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("?");
		btnNewButton_8.setForeground(new Color(255, 255, 255));
		btnNewButton_8.setBackground(Color.decode("#f25c54"));
		panel_4.add(btnNewButton_8);
		
		JButton btnNewButton_10 = new JButton("?");
		btnNewButton_10.setForeground(new Color(255, 255, 255));
		btnNewButton_10.setBackground(Color.decode("#f25c54"));
		panel_4.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("?");
		btnNewButton_11.setForeground(new Color(255, 255, 255));
		btnNewButton_11.setBackground(Color.decode("#f25c54"));
		panel_4.add(btnNewButton_11);
		
		JButton btnNewButton_13 = new JButton("?");
		btnNewButton_13.setForeground(new Color(255, 255, 255));
		btnNewButton_13.setBackground(Color.decode("#f25c54"));
		panel_4.add(btnNewButton_13);
		
		JButton btnNewButton_14 = new JButton("?");
		btnNewButton_14.setForeground(new Color(255, 255, 255));
		btnNewButton_14.setBackground(Color.decode("#f25c54"));
		panel_4.add(btnNewButton_14);
		
		JButton btnNewButton_15 = new JButton("?");
		btnNewButton_15.setForeground(new Color(255, 255, 255));
		btnNewButton_15.setBackground(Color.decode("#f25c54"));
		panel_4.add(btnNewButton_15);
	}

}
