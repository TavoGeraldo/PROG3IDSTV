package idstv;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import idstv.Ventana.Circle;
import idstv.Ventana.MyPoint;
import idstv.Ventana.Rectangle;
import idstv.Ventana.Triangle;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;

public class Pacman extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DrawingPanel panel_2;
	private int x = 200, y = 100;
	private int direccion = 3; // 0=arriba 1=izquierda 2=abajo 3=derecha


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pacman frame = new Pacman();
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
	public Pacman() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 255));
		contentPane.add(panel, BorderLayout.NORTH);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 255));
		contentPane.add(panel_1, BorderLayout.SOUTH);

		panel_2 = new DrawingPanel();
		panel_2.setBackground(new Color(0, 0, 0));
		contentPane.add(panel_2, BorderLayout.CENTER);

		panel_2.addKeyListener(this);
		panel_2.setFocusable(true);

		JButton reiniciar = new JButton("Reiniciar");
		reiniciar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				x = 200;
				y = 100;

				panel_2.repaint();

				panel_2.requestFocus();

			}
		});
		panel_1.add(reiniciar);



	}

	class DrawingPanel extends JPanel {
		public DrawingPanel() {
			setBackground(Color.WHITE);
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;

			g2d.setColor(Color.YELLOW);
			int angulo = 0;

			switch (direccion) {
			case 0:
				angulo = 135;
				break; 
			case 1:
				angulo = 225;
				break; 
			case 2:
				angulo = 315;
				break; 
			case 3:
				angulo = 45;
				break; 
			}

			g2d.fillArc(x, y, 30, 30, angulo, 270); 

		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(y);
		// W para arriba
		if (e.getKeyCode() == 87) { // W
			y -= 5;
			direccion = 0;
			if (y <= -35) {
				y = 475;
			}
		}
		// S para abajo
		if (e.getKeyCode() == 83) { 
			y += 5;
			direccion = 2;
			if (y >= 480) {
				y = -25;
			}
		}
		// A para izquierda
		if (e.getKeyCode() == 65) { 
			x -= 5;
			direccion = 1;
			if (x <= -30) {
				x = 475;
			}
		}
		// D para derecha
		if (e.getKeyCode() == 68) { 
			x += 5;
			direccion = 3;
			if (x >= 475) {
				x = -25;
			}
		}

		panel_2.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
