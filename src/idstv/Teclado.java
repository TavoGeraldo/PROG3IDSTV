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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.awt.Font;

public class Teclado extends JFrame implements KeyListener {

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
		setBounds(100, 100, 798, 556);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.addKeyListener(this);

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 255, 128));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Esperando");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		lblNewLabel.setHorizontalAlignment(JLabel.LEFT);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.decode("#f9dcc4"));
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Espacio");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 22));
		lblNewLabel_1.setHorizontalAlignment(JLabel.LEFT);
		lblNewLabel_1.setBorder(new  EmptyBorder(0, 180, 0, 0));
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Borrando");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 22));
		lblNewLabel_2.setBorder(new  EmptyBorder(0, 0, 0, 180));
		lblNewLabel_2.setHorizontalAlignment(JLabel.RIGHT);
		
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		
		
        for (int i = 0; i < teclado.length; i++) {
        	labels[i] = new JLabel(teclado[i]);
        	labels[i].setOpaque(true);
        	labels[i].setForeground(Color.BLACK);
        	labels[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
        	labels[i].setHorizontalAlignment(JLabel.CENTER);
        	labels[i].setBackground(Color.decode("#bcb8b1"));
        	labels[i].setFont(new Font("Arial", Font.PLAIN, 12));
            panel_2.add(labels[i]);
        }
		
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(3, 9, 0, 0));
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		char tecla = Character.toUpperCase(e.getKeyChar());
		
		Random rand = new Random();
		float r = rand.nextFloat();
		float g = rand.nextFloat();
		float b = rand.nextFloat();
		Color randomColor = new Color(r, g, b);
		 
	        for (int i = 0; i < teclado.length; i++) {
	        	if(teclado[i].charAt(0) == tecla) {
	        		labels[i].setBackground(randomColor);
	        	}
	        	
	        }
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		 char tecla = Character.toUpperCase(e.getKeyChar());
		 
        for (int i = 0; i < teclado.length; i++) {
        	if(teclado[i].charAt(0) ==tecla) {
        		labels[i].setBackground(Color.decode("#bcb8b1"));
        	}
        	
            
        }
		
	}

}
