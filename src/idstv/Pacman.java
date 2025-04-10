package idstv;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
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
	private int direccion = 3; // 0=arriba 1=izquierda 2=abajo 3=derecha
	private Player pacman;
	private List<Player> paredes = new ArrayList<>();
	Timer timer;
	Timer timer2;
	private int lastPress = 0;
	private int anguloBoca = 270; 
	private boolean bocaAbierta = true;
	private int contadorBoca = 0;




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
		
		pacman = new Player(100, 200, 30, 30, Color.YELLOW);
		
		paredes.add(new Player(120, 300, 200, 30, Color.ORANGE));
		
		paredes.add(new Player(120, 100, 200, 30, Color.blue));
		
		paredes.add(new Player(400, 100, 20, 170, Color.PINK));

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
				pacman.x = 100;
				pacman.y = 200;
				
				
				lastPress = 0;
				timer.stop();
				
				panel_2.repaint();

				panel_2.requestFocus();

			}
		});
		panel_1.add(reiniciar);

		ActionListener taskPerformer = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				update();
				contadorBoca++;
				if (contadorBoca >= 15) { 
				    bocaAbierta = !bocaAbierta;
				    if (bocaAbierta) {
				        anguloBoca = 270;
				    } else {
				        anguloBoca = 360;
				    }

				    contadorBoca = 0;
				}
				panel_2.repaint();


					
			}
		};
		timer = new Timer(3,taskPerformer);
		

	}

	class DrawingPanel extends JPanel {
		public DrawingPanel() {
			setBackground(Color.WHITE);
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;

			g2d.setColor(pacman.c);
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

			g2d.fillArc(pacman.x, pacman.y, pacman.w, pacman.h, angulo, anguloBoca);
			
			for (Player pared : paredes) {
				g2d.setColor(pared.c);
				g2d.fillRect(pared.x, pared.y, pared.w, pared.h);
				
			}

		}
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		lastPress = e.getKeyCode();
		timer.start();
		update();
	}
	
	public void update() {
		Boolean colision = false;
		
		for (Player pared : paredes) {
			if(pacman.colision(pared)) {
				colision = true;
			}
			
			
		}
		
		// W para arriba
		if (lastPress == 87) { // W
			direccion = 0;
			if(!colision) {
				pacman.y-=1;
			}else {
				pacman.y+=2;
				lastPress =  0; 
			}
			if (pacman.y <= -35) {
				pacman.y = 470;
			}


		}
		// S para abajo
		if (lastPress == 83) { 
			direccion = 2;
			if(!colision) {
				pacman.y+=1;
			}else {
				pacman.y-=2;
				lastPress =  0;
			}
			if (pacman.y >= 480) {
				pacman.y = -20;
			}
		}
		// A para izquierda
		if (lastPress == 65) {
			direccion = 1;
			if(!colision) {
				pacman.x-=1;
			}else {
				pacman.x+=2;
				lastPress =  0;
			}
			if (pacman.x <= -30) {
				pacman.x = 475;
			}
		}
		// D para derecha
		if (lastPress == 68) {
			direccion = 3;
			if(!colision) {
				pacman.x+=1;
			}else {
				pacman.x-=2;
				lastPress =  0;
			}
			if (pacman.x >= 475) {
				pacman.x = -25;
			}

		}

		panel_2.repaint();
	}
	
	class Player{
		int x,y,w,h;
		Color c;
		public Player(int x,int y, int w, int h, Color c) {
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
			this.c = c;
		}
		
		public boolean colision(Player target) {
			
			
			if(this.x < target.x + target.w &&

					this.x + this.w > target.x &&

					this.y < target.y + target.h &&

					this.y + this.h > target.y) {

					return true;

					}
			
			
			return false;
		}
	}
	
	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
