package idstv;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class Ventana extends JFrame {

	public Ventana() {
		this.setTitle("calcular interés");
		this.setSize(800, 600);
		// this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		
		ImageIcon iconoVentana = new ImageIcon("icono.png");
		this.setIconImage(iconoVentana.getImage());

		//this.add(calcularInteres());
		//this.add(this.calculadora());
		 //this.add(this.login());
		// this.add(this.registro());
		// this.add(this.tabla());

		// this.add(this.registro());

		/*
		 * JMenuBar barra = new JMenuBar();
		 * 
		 * JMenu file = new JMenu("Archivo"); barra.add(file);
		 * 
		 * JMenuItem open = new JMenuItem("Abir"); file.add(open);
		 * 
		 * JMenuItem item1 = new JMenuItem("Guardar"); file.add(item1);
		 * 
		 * JMenuItem item2 = new JMenuItem("Cerrar"); file.add(item2);
		 * 
		 * JMenu help = new JMenu("Ayuda"); barra.add(help);
		 * 
		 * JMenuItem search = new JMenuItem("Buscar"); help.add(item2);
		 * 
		 * JMenuItem i1 = new JMenuItem("Bienvenido"); help.add(i1);
		 * 
		 * this.setJMenuBar(barra);
		 */
		this.repaint();
		// this.revalidate();

		this.setVisible(true);

	}

	public JPanel login() {

		JPanel panel1 = new JPanel();

		panel1.setOpaque(true);
		panel1.setSize(1000, 600);
		panel1.setLocation(0, 0);
		panel1.setLayout(null);

		// Etiquetas
		JLabel etiqueta1 = new JLabel("Nombre de usuario:");
		etiqueta1.setSize(150, 30);
		etiqueta1.setLocation(170, 80);
		etiqueta1.setForeground(Color.WHITE);
		etiqueta1.setFont(new Font("Georgia", Font.BOLD, 14));
		panel1.add(etiqueta1);

		JLabel etiqueta2 = new JLabel("Contraseña:");
		etiqueta2.setSize(150, 30);
		etiqueta2.setLocation(170, 160);
		etiqueta2.setForeground(Color.WHITE);
		etiqueta2.setFont(new Font("Georgia", Font.BOLD, 14));
		panel1.add(etiqueta2);

		JLabel etiqueta4 = new JLabel("¿Olvido su contraseña?");
		etiqueta4.setSize(150, 30);
		etiqueta4.setLocation(290, 220);
		etiqueta4.setForeground(Color.WHITE);
		panel1.add(etiqueta4);

		JCheckBox caja = new JCheckBox("Recordarme");
		caja.setSize(110, 30);
		caja.setLocation(170, 220);
		caja.setForeground(Color.WHITE);
		caja.setContentAreaFilled(false);
		panel1.add(caja);

		// Campos de texto
		JPasswordField contrasena = new JPasswordField();
		contrasena.setSize(270, 30);
		contrasena.setLocation(170, 190);
		contrasena.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		panel1.add(contrasena);

		JTextField usuario = new JTextField();
		usuario.setSize(270, 30);
		usuario.setLocation(170, 110);
		usuario.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		panel1.add(usuario);

		// Botones
		JButton boton = new JButton("Acceder");
		boton.setBounds(220, 270, 170, 50);
		boton.setFont(new Font("Arial", Font.BOLD, 18));
		boton.setBackground(Color.decode("#00829B"));
		boton.setForeground(Color.WHITE);
		boton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		panel1.add(boton);

		// Imagen usuario
		ImageIcon icon = new ImageIcon("user.png");

		// Con esto se redimenciona la imagen para que quede bien
		Image imagen = icon.getImage();
		Image imagenNueva = imagen.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon iconoNuevo = new ImageIcon(imagenNueva);
		// Aqui se crea la imagen ya redimencionada
		JLabel iconoUsuario = new JLabel(iconoNuevo);
		iconoUsuario.setSize(30, 30);
		iconoUsuario.setLocation(130, 110);
		panel1.add(iconoUsuario);

		// Imagen contraseña
		ImageIcon icon2 = new ImageIcon("padlock.png");
		// aqui igual se redimenciona
		Image imagen2 = icon2.getImage();
		Image imagenNueva2 = imagen2.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon iconoNuevo2 = new ImageIcon(imagenNueva2);

		JLabel iconoPassword = new JLabel(iconoNuevo2);
		iconoPassword.setSize(30, 30);
		iconoPassword.setLocation(130, 190);
		panel1.add(iconoPassword);

		// fondo
		JLabel fondo = new JLabel(new ImageIcon("fondo.jpg"));
		fondo.setSize(1000, 600);
		fondo.setLocation(0, 0);
		panel1.add(fondo);

		return panel1;
	}

	public JPanel registro() {
		JPanel panel2 = new JPanel();

		panel2.setBackground(Color.decode("#adb5bd"));
		panel2.setOpaque(true);
		panel2.setSize(500, 500);
		panel2.setLocation(500, 0);
		panel2.setLayout(null);

		JLabel etiqueta1 = new JLabel("Nombre de usuario:");
		etiqueta1.setSize(150, 30);
		etiqueta1.setLocation(100, 40);
		etiqueta1.setFont(new Font("Georgia", Font.BOLD, 14));
		panel2.add(etiqueta1);

		JTextField usuario = new JTextField();
		usuario.setSize(300, 30);
		usuario.setLocation(100, 70);
		usuario.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		panel2.add(usuario);

		JLabel etiqueta2 = new JLabel("Descripción personal:");
		etiqueta2.setSize(170, 30);
		etiqueta2.setLocation(100, 110);
		etiqueta2.setFont(new Font("Georgia", Font.BOLD, 14));

		panel2.add(etiqueta2);

		JTextArea bioArea = new JTextArea();
		bioArea.setSize(300, 60);
		bioArea.setLocation(100, 140);
		bioArea.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));

		panel2.add(bioArea);

		JLabel etiqueta3 = new JLabel("Preferencias");
		etiqueta3.setSize(150, 30);
		etiqueta3.setLocation(190, 210);
		etiqueta3.setFont(new Font("Georgia", Font.BOLD, 14));
		panel2.add(etiqueta3);

		JCheckBox caja1 = new JCheckBox("Dulce");
		caja1.setSize(60, 30);
		caja1.setLocation(100, 240);
		caja1.setBackground(null);
		panel2.add(caja1);

		JCheckBox caja2 = new JCheckBox("Salado");
		caja2.setSize(80, 30);
		caja2.setLocation(180, 240);
		caja2.setBackground(null);
		panel2.add(caja2);

		JCheckBox caja3 = new JCheckBox("Amargo");
		caja3.setSize(80, 30);
		caja3.setLocation(270, 240);
		caja3.setBackground(null);
		panel2.add(caja3);

		String[] col = { "Centro", "Camino Real", "Pedregal", "Diana Laura" };
		JComboBox colonias = new JComboBox(col);
		colonias.setSize(300, 30);
		colonias.setFont(new Font("Georgia", Font.PLAIN, 14));
		colonias.setLocation(100, 280);
		panel2.add(colonias);

		JLabel etiqueta4 = new JLabel("Términos");
		etiqueta4.setSize(150, 30);
		etiqueta4.setLocation(200, 320);
		etiqueta4.setFont(new Font("Georgia", Font.BOLD, 14));
		panel2.add(etiqueta4);

		JRadioButton aceptar = new JRadioButton("Acepto los términos");
		aceptar.setSize(150, 30);
		aceptar.setLocation(100, 340);
		aceptar.setBackground(null);
		panel2.add(aceptar);

		JRadioButton noAceptar = new JRadioButton("No acepto los términos");
		noAceptar.setSize(160, 30);
		noAceptar.setLocation(250, 340);
		noAceptar.setBackground(null);
		panel2.add(noAceptar);

		ButtonGroup group = new ButtonGroup();
		group.add(aceptar);
		group.add(noAceptar);

		JButton boton = new JButton("Crear");
		boton.setSize(190, 50);
		boton.setLocation(150, 380);
		boton.setFont(new Font("Arial", Font.BOLD, 18));
		boton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		panel2.add(boton);

		return panel2;
	}

	public JPanel tabla() {

		JPanel panel1 = new JPanel();

		panel1.setBackground(Color.decode("#e0e1dd"));
		panel1.setOpaque(true);
		panel1.setSize(1000, 600);
		panel1.setLocation(0, 0);
		panel1.setLayout(null);

		String[] titles = { "ID", "Nombre", "Correo electrónico", "Edad", "Estado" };

		Object[][] datos = {

				{ "23454", "Juan", "Juan@gmail.mx", "18", "Activo" },
				{ "23454", "Juan", "Juan@gmail.mx", "18", "Activo" },
				{ "23454", "Juan", "Juan@gmail.mx", "18", "Activo" },
				{ "23454", "Juan", "Juan@gmail.mx", "18", "Activo" },
				{ "23454", "Juan", "Juan@gmail.mx", "18", "Activo" },
				{ "23454", "Juan", "Juan@gmail.mx", "18", "Activo" },
				{ "23454", "Juan", "Juan@gmail.mx", "18", "Activo" },
				{ "23454", "Juan", "Juan@gmail.mx", "18", "Activo" },
				{ "23454", "Juan", "Juan@gmail.mx", "18", "Activo" },
				{ "23454", "Juan", "Juan@gmail.mx", "18", "Activo" },
				{ "23454", "Juan", "Juan@gmail.mx", "18", "Activo" },
				{ "23454", "Juan", "Juan@gmail.mx", "18", "Activo" },
				{ "23454", "Juan", "Juan@gmail.mx", "18", "Activo" },
				{ "23454", "Juan", "Juan@gmail.mx", "18", "Activo" },
				{ "23454", "Juan", "Juan@gmail.mx", "18", "Activo" },
				{ "23454", "Juan", "Juan@gmail.mx", "18", "Activo" },
				{ "23454", "Juan", "Juan@gmail.mx", "18", "Activo" },
				{ "23454", "Juan", "Juan@gmail.mx", "18", "Activo" },
				{ "23454", "Juan", "Juan@gmail.mx", "18", "Activo" },
				{ "23454", "Juan", "Juan@gmail.mx", "18", "Activo" },
				{ "23454", "Juan", "Juan@gmail.mx", "18", "Activo" },
				{ "23454", "Juan", "Juan@gmail.mx", "18", "Activo" },
				{ "23454", "Juan", "Juan@gmail.mx", "18", "Activo" },
				{ "23454", "Juan", "Juan@gmail.mx", "18", "Activo" },

		};

		JTable tabla = new JTable(datos, titles);
		JScrollPane scroll_pane = new JScrollPane(tabla);
		scroll_pane.setSize(550, 200);
		scroll_pane.setLocation(60, 220);
		panel1.add(scroll_pane);

		JButton boton = new JButton("Descargar");

		boton.setSize(100, 50);
		boton.setLocation(360, 150);
		boton.setFont(new Font("Arial", Font.BOLD, 18));
		boton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		panel1.add(boton);

		JButton boton2 = new JButton("Añadir");

		boton2.setSize(100, 50);
		boton2.setLocation(480, 150);
		boton2.setFont(new Font("Arial", Font.BOLD, 18));
		boton2.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		panel1.add(boton2);

		JLabel etiqueta1 = new JLabel("Usuarios");
		etiqueta1.setSize(150, 30);
		etiqueta1.setLocation(60, 80);
		etiqueta1.setFont(new Font("Georgia", Font.BOLD, 18));
		etiqueta1.setBackground(Color.BLUE);
		panel1.add(etiqueta1);

		JLabel etiqueta2 = new JLabel("30");
		etiqueta2.setSize(150, 30);
		etiqueta2.setLocation(90, 100);
		etiqueta2.setFont(new Font("Georgia", Font.BOLD, 18));
		etiqueta2.setBackground(Color.BLUE);
		panel1.add(etiqueta2);

		return panel1;
	}

	public JPanel calculadora() {

		

		JPanel panelPrincipal = new JPanel(new BorderLayout());

		JLabel campoTexto = new JLabel("20.00");
		campoTexto.setFont(new Font("Arial", Font.BOLD, 70));
		campoTexto.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
		campoTexto.setHorizontalAlignment(JTextField.RIGHT);
		panelPrincipal.add(campoTexto, BorderLayout.NORTH);

		JPanel panelBotones = new JPanel(new GridLayout(5, 4, 7, 10));
		

		
		
		String[] botones = { 
				"CE", "", "", "",
				"7", "8", "9", "/", 
				"4", "5","6", "*",
				"1", "2", "3", "-", 
				"0", ".", "=", "+" 
				};
		
		for (String guardarBotones : botones) {
			 JButton boton = new JButton( guardarBotones);
			 panelBotones.add(boton);
		}
		
	

		panelPrincipal.add(panelBotones, BorderLayout.CENTER);

		return panelPrincipal;
	}
	
	public JPanel calcularInteres(){

		JPanel panel1 = new JPanel(new BorderLayout());
		
		JLabel campoTexto = new JLabel("Interés");
		campoTexto.setFont(new Font("Arial", Font.BOLD, 24));
		panel1.add(campoTexto, BorderLayout.NORTH);
		
		
		//panel Centro
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.magenta); 

        JLabel texto1 = new JLabel(" Calcular interés");
        texto1.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 310, Color.magenta));

        texto1.setFont(new Font("Arial", Font.BOLD, 16));
        panel2.add(texto1, BorderLayout.NORTH);
		
		  
        JPanel contenedor = new JPanel(new GridLayout(4, 2, 5, 5));
        contenedor.setBackground(Color.magenta);

        JLabel texto4 = new JLabel("Capital:");
        texto4.setBorder(BorderFactory.createMatteBorder(0, 100, 0, 0, Color.magenta));
        contenedor.add(texto4);
        JTextField tew1 = new JTextField("1500");
        tew1.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 70, Color.magenta));
        contenedor.add(tew1);

        JLabel texto2 = new JLabel("Tiempo:");
        texto2.setBorder(BorderFactory.createMatteBorder(0, 100, 0, 0, Color.magenta));
        contenedor.add(texto2);
        JTextField tew2 = new JTextField("2");
        tew2.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 70, Color.magenta));
        contenedor.add(tew2);
        
        JLabel texto3 = new JLabel("Tasa interés:");
        texto3.setBorder(BorderFactory.createMatteBorder(0, 100, 0, 0, Color.magenta));
        contenedor.add(texto3);
        JTextField tew3 = new JTextField("0.1");
        tew3.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 70, Color.magenta));
        contenedor.add(tew3);

        
        JPanel botones = new JPanel();
        botones.setLayout(new FlowLayout());
        JButton btnCalcular = new JButton("Calcular");
        JButton btnCancelar = new JButton("Cancelar");
        botones.add(btnCalcular);
        botones.add(btnCancelar);

        contenedor.add(botones);
        panel2.add(contenedor);

        panel1.add(panel2, BorderLayout.CENTER);
		
		
		
		
		//panel asta abajo 
		JPanel panel3 = new JPanel();
		panel3.setPreferredSize(new Dimension(400, 150));
		panel3.setOpaque(true);
		panel3.setBackground(Color.cyan);
		panel3.setLayout(new GridLayout(2,2));
		
		JLabel t1 = new JLabel("Interés:");
		t1.setBorder(BorderFactory.createMatteBorder(1, 180, 1, 1, Color.cyan));
		panel3.add(t1);
		
		JTextField tw1 = new JTextField("180.00000");
		tw1.setBorder(BorderFactory.createMatteBorder(20, 0, 20, 70, Color.cyan));
		panel3.add(tw1);
		
		JLabel t2 = new JLabel("monto:");
		t2.setBorder(BorderFactory.createMatteBorder(1, 180, 1, 1, Color.cyan));
		panel3.add(t2);
		
		JTextField tw2 = new JTextField("1380.00000");
		tw2.setBorder(BorderFactory.createMatteBorder(20, 0, 20, 70, Color.cyan));
		panel3.add(tw2);
		
		panel1.add(panel3, BorderLayout.SOUTH);
		
		return panel1;
	}
	
	
	@Override
	public void paint(Graphics g) {
		
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D) g.create();
		
		g2d.drawRect(100, 100, 80, 80);
		
		g2d.setColor(Color.YELLOW);
		
		g2d.fillRect(150, 150, 80, 80);
		
		g2d.setColor(Color.RED);
		
		g2d.drawLine(0, 0, 300, 300);
		
		g2d.setColor(Color.ORANGE);
		
		g2d.drawOval(200, 350, 80, 90);
		
		g2d.fillOval(240, 350, 80, 90);
		
		try {
			BufferedImage image = ImageIO.read(new File("vaca.png"));
			g2d.drawImage(image, 400, 40, null);

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		g2d.setColor(Color.GREEN);
		
		g2d.setFont(new Font("Arial", Font.BOLD, 70));
		g2d.drawString("Hola", 500, 500);
		
		g2d.drawArc(450, 280, 100, 100, 0, 180);
		
		g2d.setColor(Color.BLUE);
		g2d.fillArc(450, 300, 100, 100, 20, -180);
		
		int xs []= {400, 350, 250};
		int ys []= {300, 200, 250};
		
		g2d.drawPolygon(xs, ys, 3);
		
		int xs2 []= {450, 250, 250};
		int ys2 []= {350, 200, 250};
		
		g2d.fillPolygon(xs2, ys2, 3);
	}
}
