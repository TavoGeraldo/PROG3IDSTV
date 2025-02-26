package idstv;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
		this.setTitle("Login");
		this.setVisible(true);
		this.setSize(1000, 600);
		this.setLayout(null);
		this.setLocationRelativeTo(null);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setResizable(true);

		this.add(this.login());
		this.repaint();

		// this.add(this.registro());
		// this.repaint();

		// this.add(this.tabla());
		// this.repaint();

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
		//Aqui se crea la imagen ya redimencionada
		JLabel iconoUsuario = new JLabel(iconoNuevo);
		iconoUsuario.setSize(30, 30); 
		iconoUsuario.setLocation(130, 110); 
		panel1.add(iconoUsuario);
		
		//Imagen contraseña
		ImageIcon icon2 = new ImageIcon("padlock.png");
		//aqui igual se redimenciona
		Image imagen2 = icon2.getImage(); 
		Image imagenNueva2 = imagen2.getScaledInstance(30, 30, Image.SCALE_SMOOTH); 
		ImageIcon iconoNuevo2 = new ImageIcon(imagenNueva2);
		
		JLabel iconoPassword = new JLabel(iconoNuevo2);
		iconoPassword.setSize(30, 30); 
		iconoPassword.setLocation(130, 190); 
		panel1.add(iconoPassword);
		
		//fondo
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

}
