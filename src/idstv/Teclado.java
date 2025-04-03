package idstv;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;

public class Teclado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	String teclado [] = {  
		    "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P",
		    "A", "S", "D", "F", "G", "H", "J", "K", "L", "Ñ",
		    "Z", "X", "C", "V", "B", "N", "M"	
	};
	
	JLabel[] labels = new JLabel [teclado.length];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teclado frame = new Teclado();
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
	public Teclado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 697, 457);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 255, 128));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Esperando");
		lblNewLabel.setHorizontalAlignment(JLabel.LEFT);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_1 = new JLabel("Espacio");
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Borrando");
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		
		
        for (int i = 0; i < teclado.length; i++) {
        	labels[i] = new JLabel(teclado[i]);
        	labels[i].setOpaque(true);
        	labels[i].setForeground(Color.BLACK);
        	labels[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
        	labels[i].setHorizontalAlignment(JLabel.CENTER);
        	labels[i].setBackground(Color.GRAY);
            panel_2.add(labels[i]);
        }
		
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(3, 9, 0, 0));
	}

}
