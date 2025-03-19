package idstv;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JOptionPane;
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
		this.setSize(700, 700);
		// this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		
		ImageIcon iconoVentana = new ImageIcon("icono.png");
		this.setIconImage(iconoVentana.getImage());

		
		 this.add(this.login());
		 

		

		
		  JMenuBar barra = new JMenuBar();
		  
		  JMenu file = new JMenu("Usuarios"); barra.add(file);
		  
		  JMenuItem alta = new JMenuItem("Alta");
		  
		  alta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				router("alta");
				
			}
		});
		  
		  file.add(alta);
		  
		  JMenuItem baja = new JMenuItem("Baja");
		  
		  baja.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				router("baja");
				
			}
		});
		  
		  file.add(baja);
		  
		  JMenuItem consultar = new JMenuItem("Consultar"); 
		  
		  consultar.addActionListener(new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent e) {
				router("consultar");
				
			}
		});
		  
		  file.add(consultar);
		  
		  
		  
		  
		  JMenu help = new JMenu("Ayuda"); 
		  barra.add(help);
		  
		  JMenuItem crearUsuario = new JMenuItem("¿Cómo crear un usuario?");
		  
		  crearUsuario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				router("crear usuario");
				
			}
		});
		  
		  help.add(crearUsuario);
		  
		  JMenuItem acceder = new JMenuItem("¿Cómo acceder al sistema?");
		  
		  acceder.addActionListener(new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent e) {
				router("acceder");
				
			}
		});
		  
		  help.add(acceder);
		  
		  JMenuItem olvideContra = new JMenuItem("¿Qué pasa si olvidé mi contraseña?");
		  
		  olvideContra.addActionListener(new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent e) {
				router("contraseña olvidada");
				
			}
		});
		  
		  help.add(olvideContra);
		  
		  
		  
		  
		  
		  JMenu cuenta = new JMenu("Cuenta");
			barra.add(cuenta);

			JMenuItem registro = new JMenuItem("Registrar");
			
			registro.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					router("registro");
					
				}
			});
			
			cuenta.add(registro);

			JMenuItem datos = new JMenuItem("login");
			
			datos.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					router("login");
					
				}
			});
			
			cuenta.add(datos);
			
			JMenuItem recuperar = new JMenuItem("Recuperación de cuenta");
			
			recuperar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					router("recuperacion");
					
				}
			});
			
			cuenta.add(recuperar);
		  
			
			
			
		  this.setJMenuBar(barra);
		 
		this.repaint();
		 this.revalidate();

		this.setVisible(true);

	}

	public JPanel login() {

		JPanel panel1 = new JPanel();

		panel1.setOpaque(true);
		panel1.setSize(500, 700);
		panel1.setLocation(500, 0);
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
		boton.setBackground(Color.decode("#28a745"));
		boton.setForeground(Color.WHITE);
		boton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		
		boton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				boolean flag1 = false, flag2 = false;
				
				if(usuario.getText().equals("")) {
					usuario.setBorder(BorderFactory.createLineBorder(Color.RED,3));
				}else {
					usuario.setBorder(BorderFactory.createLineBorder(Color.GREEN,3));
					flag1= true;
				}
				
				String miContra = new String(contrasena.getPassword());
				
				if(miContra.equals("")) {
					contrasena.setBorder(BorderFactory.createLineBorder(Color.RED,3));
				}else {
					contrasena.setBorder(BorderFactory.createLineBorder(Color.GREEN,3));
					flag2 = true;
				}
				
				if(flag1 && flag2) {
					if(usuario.getText().equals("octavio.uabcs.mx")) { 
						if(miContra.equals("contraseña123")) {
							JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");
					}else
						JOptionPane.showMessageDialog(null, "Error");
					}else 
						JOptionPane.showMessageDialog(null, "Error");
					
					
					
				}
			}
			
			
		});
		
		panel1.add(boton);
		
		JButton irRegistro = new JButton("Ir a registro");
		irRegistro.setBounds(220, 370, 170, 50);
		irRegistro.setFont(new Font("Arial", Font.BOLD, 18));
		irRegistro.setBackground(Color.decode("#00829B"));
		irRegistro.setForeground(Color.WHITE);
		irRegistro.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		
		irRegistro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				router("registro");
				
			}
		});
		
		panel1.add(irRegistro);

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
		fondo.setSize(700, 600);
		fondo.setLocation(0, 0);
		panel1.add(fondo);

		return panel1;
	}

	public JPanel registro() {
		JPanel panel2 = new JPanel();

		panel2.setBackground(Color.decode("#adb5bd"));
		panel2.setOpaque(true);
		panel2.setSize(1000, 700);
		panel2.setLocation(0, 0);
		panel2.setLayout(null);

		JLabel etiqueta1 = new JLabel("Nombre de usuario:");
		etiqueta1.setSize(150, 30);
		etiqueta1.setLocation(180, 40);
		etiqueta1.setFont(new Font("Georgia", Font.BOLD, 14));
		panel2.add(etiqueta1);

		JTextField usuario = new JTextField();
		usuario.setSize(300, 30);
		usuario.setLocation(180, 70);
		usuario.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		panel2.add(usuario);

		JLabel etiqueta2 = new JLabel("Descripción personal:");
		etiqueta2.setSize(170, 30);
		etiqueta2.setLocation(180, 110);
		etiqueta2.setFont(new Font("Georgia", Font.BOLD, 14));

		panel2.add(etiqueta2);

		JTextArea bioArea = new JTextArea();
		bioArea.setSize(300, 60);
		bioArea.setLocation(180, 140);
		bioArea.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));

		panel2.add(bioArea);

		JLabel etiqueta3 = new JLabel("Preferencias");
		etiqueta3.setSize(150, 30);
		etiqueta3.setLocation(270, 210);
		etiqueta3.setFont(new Font("Georgia", Font.BOLD, 14));
		panel2.add(etiqueta3);

		JCheckBox caja1 = new JCheckBox("Dulce");
		caja1.setSize(60, 30);
		caja1.setLocation(180, 240);
		caja1.setBackground(null);
		panel2.add(caja1);

		JCheckBox caja2 = new JCheckBox("Salado");
		caja2.setSize(80, 30);
		caja2.setLocation(260, 240);
		caja2.setBackground(null);
		panel2.add(caja2);

		JCheckBox caja3 = new JCheckBox("Amargo");
		caja3.setSize(80, 30);
		caja3.setLocation(350, 240);
		caja3.setBackground(null);
		panel2.add(caja3);

		String[] col = { "Centro", "Camino Real", "Pedregal", "Diana Laura" };
		JComboBox colonias = new JComboBox(col);
		colonias.setSize(300, 30);
		colonias.setFont(new Font("Georgia", Font.PLAIN, 14));
		colonias.setLocation(180, 280);
		panel2.add(colonias);

		JLabel etiqueta4 = new JLabel("Términos");
		etiqueta4.setSize(150, 30);
		etiqueta4.setLocation(280, 320);
		etiqueta4.setFont(new Font("Georgia", Font.BOLD, 14));
		panel2.add(etiqueta4);

		JRadioButton aceptar = new JRadioButton("Acepto los términos");
		aceptar.setSize(150, 30);
		aceptar.setLocation(180, 340);
		aceptar.setBackground(null);
		panel2.add(aceptar);

		JRadioButton noAceptar = new JRadioButton("No acepto los términos");
		noAceptar.setSize(160, 30);
		noAceptar.setLocation(330, 340);
		noAceptar.setBackground(null);
		panel2.add(noAceptar);

		ButtonGroup group = new ButtonGroup();
		group.add(aceptar);
		group.add(noAceptar);

		JButton boton = new JButton("Crear");
		boton.setSize(190, 50);
		boton.setLocation(230, 380);
		boton.setFont(new Font("Arial", Font.BOLD, 18));
		boton.setBackground(Color.decode("#28a745"));
		boton.setForeground(Color.WHITE);
		boton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		
		boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				boolean flag1 = false, flag2 = false;
				
				if(usuario.getText().equals("")) {
					usuario.setBorder(BorderFactory.createLineBorder(Color.RED,3));
				}else {
					usuario.setBorder(BorderFactory.createLineBorder(Color.GREEN,3));
					flag1 = true;
				}
				if(bioArea.getText().equals("")) {
					bioArea.setBorder(BorderFactory.createLineBorder(Color.RED,3));
				}else {
					bioArea.setBorder(BorderFactory.createLineBorder(Color.GREEN,3));
					flag2 = true;
				}
				
				
				
			}
		});
		
		panel2.add(boton);
		
		JButton irLogin = new JButton("Ir al login");
		irLogin.setSize(190, 50);
		irLogin.setLocation(230, 470);
		irLogin.setFont(new Font("Arial", Font.BOLD, 18));
		irLogin.setBackground(Color.decode("#00829B"));
		irLogin.setForeground(Color.WHITE);
		irLogin.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		
		irLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				router("login");
				
			}
		});
		
		panel2.add(irLogin);

		return panel2;
	}
	
	public JPanel recuperacion() {
		
		JPanel panel1 = new JPanel();

		panel1.setOpaque(true);
		panel1.setSize(500, 700);
		panel1.setLocation(500, 0);
		panel1.setBackground(Color.decode("#adb5bd"));
		panel1.setLayout(null);

		// Título
	    JLabel titulo = new JLabel("Recuperación de Cuenta");
	    titulo.setSize(360, 30);
	    titulo.setLocation(170, 80);
	    titulo.setForeground(Color.BLACK);
	    titulo.setFont(new Font("Georgia", Font.BOLD, 28));
	    panel1.add(titulo);

	    // Campo de texto para el correo electrónico
	    JLabel etiquetaEmail = new JLabel("Correo electrónico:");
	    etiquetaEmail.setSize(150, 30);
	    etiquetaEmail.setLocation(170, 160);
	    etiquetaEmail.setForeground(Color.BLACK);
	    etiquetaEmail.setFont(new Font("Georgia", Font.BOLD, 14));
	    panel1.add(etiquetaEmail);

	    JTextField campoEmail = new JTextField();
	    campoEmail.setSize(270, 30);
	    campoEmail.setLocation(170, 190);
	    campoEmail.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
	    panel1.add(campoEmail);

	    // Botón de recuperación
	    JButton botonRecuperar = new JButton("Recuperar");
	    botonRecuperar.setBounds(220, 270, 170, 50);
	    botonRecuperar.setFont(new Font("Arial", Font.BOLD, 18));
	    botonRecuperar.setBackground(Color.decode("#28a745"));
	    botonRecuperar.setForeground(Color.WHITE);
	    botonRecuperar.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
	    
	    botonRecuperar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean flag1 = false;
				
				if( campoEmail.getText().equals("")) {
					 campoEmail.setBorder(BorderFactory.createLineBorder(Color.RED,3));
				}else {
					 campoEmail.setBorder(BorderFactory.createLineBorder(Color.GREEN,3));
					flag1= true;
				}
				
				
				
			}
		});
	    
	    panel1.add(botonRecuperar);

	    // Botón de volver
	    JButton botonVolver = new JButton("Volver");
	    botonVolver.setBounds(220, 370, 170, 50);
	    botonVolver.setFont(new Font("Arial", Font.BOLD, 18));
	    botonVolver.setBackground(Color.decode("#a4c3b2"));
	    botonVolver.setForeground(Color.WHITE);
	    botonVolver.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
	    botonVolver.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            router("login");
	        }
	    });
	    panel1.add(botonVolver);
		
		
		return panel1;
	}
 	
	public JPanel alta() {
		
		JPanel panel1 = new JPanel();

		panel1.setOpaque(true);
		panel1.setSize(500, 700);
		panel1.setLocation(500, 0);
		panel1.setBackground(Color.decode("#a3cef1"));
		panel1.setLayout(null);

		// Título
	    JLabel titulo = new JLabel("Alta de Usuario");
	    titulo.setSize(360, 30);
	    titulo.setLocation(170, 80);
	    titulo.setForeground(Color.BLACK);
	    titulo.setFont(new Font("Georgia", Font.BOLD, 28));
	    panel1.add(titulo);

	    // Campo de texto para el nombre de usuario
	    JLabel etiquetaUsuario = new JLabel("Nombre de usuario:");
	    etiquetaUsuario.setSize(150, 30);
	    etiquetaUsuario.setLocation(170, 160);
	    etiquetaUsuario.setForeground(Color.BLACK);
	    etiquetaUsuario.setFont(new Font("Georgia", Font.BOLD, 14));
	    panel1.add(etiquetaUsuario);

	    JTextField campoUsuario = new JTextField();
	    campoUsuario.setSize(270, 30);
	    campoUsuario.setLocation(170, 190);
	    campoUsuario.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
	    panel1.add(campoUsuario);

	    // Campo de texto para la contraseña
	    JLabel etiquetaContrasena = new JLabel("Contraseña:");
	    etiquetaContrasena.setSize(150, 30);
	    etiquetaContrasena.setLocation(170, 230);
	    etiquetaContrasena.setForeground(Color.BLACK);
	    etiquetaContrasena.setFont(new Font("Georgia", Font.BOLD, 14));
	    panel1.add(etiquetaContrasena);

	    JPasswordField campoContrasena = new JPasswordField();
	    campoContrasena.setSize(270, 30);
	    campoContrasena.setLocation(170, 260);
	    campoContrasena.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
	    panel1.add(campoContrasena);
	    
	 // Campo de texto para la contraseña
	    JLabel etiquetaContrasena2 = new JLabel("Confirmar contraseña:");
	    etiquetaContrasena2.setSize(180, 30);
	    etiquetaContrasena2.setLocation(170, 300);
	    etiquetaContrasena2.setForeground(Color.BLACK);
	    etiquetaContrasena2.setFont(new Font("Georgia", Font.BOLD, 14));
	    panel1.add(etiquetaContrasena2);

	    JPasswordField campoContrasena2 = new JPasswordField();
	    campoContrasena2.setSize(270, 30);
	    campoContrasena2.setLocation(170, 330);
	    campoContrasena2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
	    panel1.add(campoContrasena2);

	    // Botón de alta
	    JButton botonAlta = new JButton("Dar de Alta");
	    botonAlta.setBounds(220, 380, 170, 50);
	    botonAlta.setFont(new Font("Arial", Font.BOLD, 18));
	    botonAlta.setBackground(Color.decode("#28a745"));
	    botonAlta.setForeground(Color.WHITE);
	    botonAlta.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
	    
	    botonAlta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean flag1 = false, flag2 = false, flag3 = false;
				
				if(campoUsuario.getText().equals("")) {
					campoUsuario.setBorder(BorderFactory.createLineBorder(Color.RED,3));
				}else {
					campoUsuario.setBorder(BorderFactory.createLineBorder(Color.GREEN,3));
					flag1= true;
				}
				
				String miContra = new String(campoContrasena.getPassword());
				
				if(miContra.equals("")) {
					campoContrasena.setBorder(BorderFactory.createLineBorder(Color.RED,3));
				}else {
					campoContrasena.setBorder(BorderFactory.createLineBorder(Color.GREEN,3));
					flag2 = true;
				}
				
				String miContra2 = new String(campoContrasena2.getPassword());
				
				if(miContra2.equals("")) {
					campoContrasena2.setBorder(BorderFactory.createLineBorder(Color.RED,3));
				}else {
					campoContrasena2.setBorder(BorderFactory.createLineBorder(Color.GREEN,3));
					flag3 = true;
				}
				
			}
		});
	    
	    panel1.add(botonAlta);

	    // Botón de volver
	    JButton botonVolver = new JButton("Volver");
	    botonVolver.setBounds(220, 480, 170, 50);
	    botonVolver.setFont(new Font("Arial", Font.BOLD, 18));
	    botonVolver.setBackground(Color.decode("#a4c3b2"));
	    botonVolver.setForeground(Color.WHITE);
	    botonVolver.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
	    botonVolver.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            router("login");
	        }
	    });
	    panel1.add(botonVolver);
		
		
		return panel1;
	}

	public JPanel baja() {
		
		JPanel panel1 = new JPanel();

		panel1.setOpaque(true);
		panel1.setSize(500, 700);
		panel1.setLocation(500, 0);
		panel1.setBackground(Color.decode("#a3cef1"));
		panel1.setLayout(null);

	    // Título
	    JLabel titulo = new JLabel("Baja de Usuario");
	    titulo.setSize(360, 30);
	    titulo.setLocation(170, 80);
	    titulo.setForeground(Color.BLACK);
	    titulo.setFont(new Font("Georgia", Font.BOLD, 28));
	    panel1.add(titulo);

	    // Campo de texto para el nombre de usuario
	    JLabel etiquetaUsuario = new JLabel("Nombre de usuario:");
	    etiquetaUsuario.setSize(150, 30);
	    etiquetaUsuario.setLocation(170, 160);
	    etiquetaUsuario.setForeground(Color.BLACK);
	    etiquetaUsuario.setFont(new Font("Georgia", Font.BOLD, 14));
	    panel1.add(etiquetaUsuario);

	    JTextField campoUsuario = new JTextField();
	    campoUsuario.setSize(270, 30);
	    campoUsuario.setLocation(170, 190);
	    campoUsuario.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
	    panel1.add(campoUsuario);
	    
	    // Campo de texto para la contraseña
	    JLabel etiquetaContrasena = new JLabel("Contraseña:");
	    etiquetaContrasena.setSize(150, 30);
	    etiquetaContrasena.setLocation(170, 230);
	    etiquetaContrasena.setForeground(Color.BLACK);
	    etiquetaContrasena.setFont(new Font("Georgia", Font.BOLD, 14));
	    panel1.add(etiquetaContrasena);

	    JPasswordField campoContrasena = new JPasswordField();
	    campoContrasena.setSize(270, 30); 
	    campoContrasena.setLocation(170, 260);
	    campoContrasena.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
	    panel1.add(campoContrasena);

	    // Botón de baja
	    JButton botonBaja = new JButton("Dar de Baja");
	    botonBaja.setBounds(220, 320, 170, 50);
	    botonBaja.setFont(new Font("Arial", Font.BOLD, 18));
	    botonBaja.setBackground(Color.decode("#28a745"));
	    botonBaja.setForeground(Color.WHITE);
	    botonBaja.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
	    
	    botonBaja.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean flag1 = false, flag2 = false;
				
				if(campoUsuario.getText().equals("")) {
					campoUsuario.setBorder(BorderFactory.createLineBorder(Color.RED,3));
				}else {
					campoUsuario.setBorder(BorderFactory.createLineBorder(Color.GREEN,3));
					flag1= true;
				}
				
				String miContra = new String(campoContrasena.getPassword());
				
				if(miContra.equals("")) {
					campoContrasena.setBorder(BorderFactory.createLineBorder(Color.RED,3));
				}else {
					campoContrasena.setBorder(BorderFactory.createLineBorder(Color.GREEN,3));
					flag2 = true;
				}
				
			}
		});
	    
	    panel1.add(botonBaja);

	    // Botón de volver
	    JButton botonVolver = new JButton("Volver");
	    botonVolver.setBounds(220, 420, 170, 50);
	    botonVolver.setFont(new Font("Arial", Font.BOLD, 18));
	    botonVolver.setBackground(Color.decode("#a4c3b2"));
	    botonVolver.setForeground(Color.WHITE);
	    botonVolver.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
	    botonVolver.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            router("login");
	        }
	    });
	    panel1.add(botonVolver);
		
	    
		return panel1;
	}

	public JPanel crearUsuario() {
		
		JPanel panel1 = new JPanel();

		panel1.setOpaque(true);
		panel1.setSize(500, 700);
		panel1.setLocation(500, 0);
		panel1.setBackground(Color.decode("#ffe6a7"));
		panel1.setLayout(null);

	    // Título
	    JLabel titulo = new JLabel("Crear Usuario");
	    titulo.setSize(360, 30);
	    titulo.setLocation(170, 80);
	    titulo.setForeground(Color.BLACK);
	    titulo.setFont(new Font("Georgia", Font.BOLD, 28));
	    panel1.add(titulo);

	    // Texto de ayuda
	    JTextArea textoAyuda = new JTextArea("Para crear un usuario, sigue los siguientes pasos:\n\n" +
	            "1. Ingresa un nombre de usuario único.\n" +
	            "2. Proporciona una contraseña segura.\n" +
	            "3. Completa los campos adicionales si es necesario.\n" +
	            "4. Haz clic en 'Crear' para finalizar.");
	    textoAyuda.setSize(400, 200);
	    textoAyuda.setLocation(100, 160);
	    textoAyuda.setEditable(false);
	    textoAyuda.setLineWrap(true);
	    textoAyuda.setWrapStyleWord(true);
	    textoAyuda.setFont(new Font("Arial", Font.BOLD, 16));
	    textoAyuda.setBackground(Color.decode("#ffe6a7"));
	    panel1.add(textoAyuda);

	    // Botón de volver
	    JButton botonVolver = new JButton("Volver");
	    botonVolver.setBounds(220, 400, 170, 50);
	    botonVolver.setFont(new Font("Arial", Font.BOLD, 18));
	    botonVolver.setBackground(Color.decode("#a4c3b2"));
	    botonVolver.setForeground(Color.WHITE);
	    botonVolver.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
	    botonVolver.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            router("login");
	        }
	    });
	    panel1.add(botonVolver);
		
		return panel1;
	}

	public JPanel accederSistema() {
		
		JPanel panel1 = new JPanel();

		panel1.setOpaque(true);
		panel1.setSize(500, 700);
		panel1.setLocation(500, 0);
		panel1.setBackground(Color.decode("#ffe6a7"));
		panel1.setLayout(null);

		  // Título
	    JLabel titulo = new JLabel("Acceso al Sistema");
	    titulo.setSize(360, 30);
	    titulo.setLocation(170, 80);
	    titulo.setForeground(Color.BLACK);
	    titulo.setFont(new Font("Georgia", Font.BOLD, 28));
	    panel1.add(titulo);

	    // Texto de ayuda
	    JTextArea textoAyuda = new JTextArea("Para acceder al sistema, sigue los siguientes pasos:\n\n" +
	            "1. Ingresa tu nombre de usuario.\n" +
	            "2. Proporciona tu contraseña.\n" +
	            "3. Haz clic en 'Acceder' para ingresar al sistema.");
	    textoAyuda.setSize(400, 200);
	    textoAyuda.setLocation(100, 160);
	    textoAyuda.setEditable(false);
	    textoAyuda.setLineWrap(true);
	    textoAyuda.setWrapStyleWord(true);
	    textoAyuda.setFont(new Font("Arial", Font.BOLD, 16));
	    textoAyuda.setBackground(Color.decode("#ffe6a7"));
	    panel1.add(textoAyuda);

	    // Botón de volver
	    JButton botonVolver = new JButton("Volver");
	    botonVolver.setBounds(220, 400, 170, 50);
	    botonVolver.setFont(new Font("Arial", Font.BOLD, 18));
	    botonVolver.setBackground(Color.decode("#a4c3b2"));
	    botonVolver.setForeground(Color.WHITE);
	    botonVolver.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
	    botonVolver.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            router("login");
	        }
	    });
	    panel1.add(botonVolver);
		
		
		return panel1;
	}
	
	public JPanel olvidoContra() {
		
		JPanel panel1 = new JPanel();

		panel1.setOpaque(true);
		panel1.setSize(500, 700);
		panel1.setLocation(500, 0);
		panel1.setBackground(Color.decode("#ffe6a7"));
		panel1.setLayout(null);

		 // Título
	    JLabel titulo = new JLabel("Recuperar Contraseña");
	    titulo.setSize(360, 30);
	    titulo.setLocation(100, 80);
	    titulo.setForeground(Color.BLACK);
	    titulo.setFont(new Font("Georgia", Font.BOLD, 28));
	    panel1.add(titulo);

	    // Texto de ayuda
	    JTextArea textoAyuda = new JTextArea("Si olvidaste tu contraseña, sigue estos pasos:\n\n" +
	            "1. Ingresa tu correo electrónico registrado.\n" +
	            "2. Haz clic en 'Recuperar'.\n" +
	            "3. Sigue las instrucciones que recibirás en tu correo.");
	    textoAyuda.setSize(400, 200);
	    textoAyuda.setLocation(100, 160);
	    textoAyuda.setEditable(false);
	    textoAyuda.setLineWrap(true);
	    textoAyuda.setWrapStyleWord(true);
	    textoAyuda.setFont(new Font("Arial", Font.BOLD, 16));
	    textoAyuda.setBackground(Color.decode("#ffe6a7"));
	    panel1.add(textoAyuda);

	    // Botón de volver
	    JButton botonVolver = new JButton("Volver");
	    botonVolver.setBounds(220, 400, 170, 50);
	    botonVolver.setFont(new Font("Arial", Font.BOLD, 18));
	    botonVolver.setBackground(Color.decode("#a4c3b2"));
	    botonVolver.setForeground(Color.WHITE);
	    botonVolver.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
	    botonVolver.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            router("login");
	        }
	    });
	    panel1.add(botonVolver);
		
		
		return panel1;
	}
	
	public void router(String route) {
		
		this.getContentPane().removeAll();
		
		if (route.equals("registro")) {
			this.add(this.registro());
		}
		
		if (route.equals("login")) {
			this.add(this.login());
		}
		
		
		if (route.equals("recuperacion")) {
			this.add(this.recuperacion());
		}
		
		if (route.equals("alta")) {
			this.add(this.alta());
		}
		
		if (route.equals("baja")) {
			this.add(this.baja());
		}
		
		if (route.equals("consultar")) {
			this.add(this.tabla());
		}
		
		if (route.equals("crear usuario")) {
			this.add(this.crearUsuario());
		}
		
		if (route.equals("acceder")) {
			this.add(this.accederSistema());
		}
		
		if (route.equals("contraseña olvidada")) {
			this.add(this.olvidoContra());
		}
		
		
		this.repaint();
		this.revalidate();
	}
	
	public JPanel tabla() {

		JPanel panel1 = new JPanel();

		panel1.setBackground(Color.decode("#a3cef1"));
		panel1.setOpaque(true);
		panel1.setSize(1000, 600);
		panel1.setLocation(0, 0);
		panel1.setLayout(null);

		String[] titles = { "ID", "Nombre", "Correo electrónico", "Edad", "Estado" };

		Object[][] datos = {

			    { "12345", "Juan", "juan123@gmail.com", "25", "Activo" },
			    { "67890", "Ana", "ana456@gmail.com", "32", "Inactivo" },
			    { "11223", "Carlos", "carlos789@gmail.com", "27", "Activo" },
			    { "44556", "Sofia", "sofia234@gmail.com", "21", "Pendiente" },
			    { "78901", "David", "david567@gmail.com", "35", "Activo" },
			    { "23456", "Pedro", "pedro678@gmail.com", "29", "Inactivo" },
			    { "34567", "Marta", "marta123@gmail.com", "23", "Activo" },
			    { "45678", "Luis", "luis987@gmail.com", "41", "Pendiente" },
			    { "56789", "Maria", "maria654@gmail.com", "36", "Activo" },
			    { "67812", "Julian", "julian321@gmail.com", "31", "Inactivo" },
			    { "78923", "Ricardo", "ricardo876@gmail.com", "28", "Activo" },
			    { "89034", "Beatriz", "beatriz999@gmail.com", "22", "Pendiente" },
			    { "90145", "Gabriel", "gabriel654@gmail.com", "33", "Activo" },
			    { "12367", "Paula", "paula432@gmail.com", "27", "Inactivo" },
			    { "23478", "Emanuel", "emanuel765@gmail.com", "38", "Activo" },
			    { "34589", "Isabel", "isabel123@gmail.com", "26", "Pendiente" },
			    { "45690", "Victor", "victor321@gmail.com", "32", "Activo" },
			    { "56701", "Laura", "laura432@gmail.com", "24", "Inactivo" },
			    { "67813", "Fernando", "fernando654@gmail.com", "37", "Activo" },
			    { "78934", "Sandra", "sandra876@gmail.com", "30", "Pendiente" },
			    { "89045", "Javier", "javier123@gmail.com", "33", "Activo" },
			    { "90156", "Cristina", "cristina987@gmail.com", "25", "Inactivo" },
			    { "12378", "Antonio", "antonio432@gmail.com", "29", "Activo" },
			    { "23489", "Elena", "elena543@gmail.com", "34", "Pendiente" },
			    { "34590", "Raul", "raul654@gmail.com", "26", "Activo" }

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
		
		 // Botón de volver
	    JButton botonVolver = new JButton("Volver");
	    botonVolver.setBounds(220, 440, 170, 50);
	    botonVolver.setFont(new Font("Arial", Font.BOLD, 18));
	    botonVolver.setBackground(Color.decode("#a4c3b2"));
	    botonVolver.setForeground(Color.WHITE);
	    botonVolver.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
	    
	    botonVolver.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            router("login");
	        }
	    });
	    panel1.add(botonVolver);
		

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
	
	
/*	@Override
	public void paint(Graphics g) {
		
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D) g.create();
		
				//fondo
				g2d.setColor(Color.decode("#0077b6"));
				g2d.fillRect(0, 0, 900, 650);
				
				
				
				//suelo
				g2d.setColor(Color.decode("#eda268"));
				g2d.fillRect(0, 630, 900, 70);
				
				g2d.setColor(Color.decode("#70e000"));
				g2d.fillRect(0, 600, 900, 30);
				
				
				// Nube 3
				g2d.setColor(Color.WHITE);
				
				g2d.fillRoundRect(250, 470, 120, 30, 40, 40);
				
				// Nube 4
				g2d.setColor(Color.WHITE);
				
				g2d.fillRoundRect(170, 510, 120, 30, 40, 40);


				// Nube 5
				g2d.setColor(Color.WHITE);
				
				g2d.fillRoundRect(250, 550, 120, 30, 40, 40);
				
				// Nube 7
				g2d.setColor(Color.WHITE);
				
				g2d.fillRoundRect(530, 280, 190, 30, 40, 40);
				
				//montañas clara1
				g2d.setColor(Color.decode("#A9B5DF"));
				g2d.fillRect(35, 330, 150, 270);
				g2d.fillOval(35, 275, 150, 110);
				
				
				
				// Nube 1
				g2d.setColor(Color.WHITE);
				
				g2d.fillRoundRect(-10, 360, 160, 30, 40, 40);
				
				//montañas clara2
				g2d.setColor(Color.decode("#A9B5DF"));
				g2d.fillRect(345, 330, 150, 270);
				g2d.fillOval(345, 275, 150, 110);
				
				//montañas clara3
				g2d.setColor(Color.decode("#A9B5DF"));
				g2d.fillRect(495, 250, 150, 350);
				g2d.fillOval(495, 195, 150, 110);
				
				// Nube 2
				g2d.setColor(Color.WHITE);
				
				g2d.fillRoundRect(190, 400, 190, 30, 40, 40);
				
				// Nube 6
				g2d.setColor(Color.WHITE);
				
				g2d.fillRoundRect(470, 400, 190, 30, 40, 40);
				
				// Nube 8
				g2d.setColor(Color.WHITE);
				
				g2d.fillRoundRect(640, 249, 110, 30, 40, 40);
				
				// Nube 2
				g2d.setColor(Color.WHITE);
				
				g2d.fillRoundRect(700, 470, 190, 50, 40, 40);
				
				//puntos
				g2d.setColor(Color.WHITE);
				g2d.fillOval(120, 320, 20, 30);
				g2d.fillOval(90, 430, 20, 30);
				g2d.fillOval(130, 390, 20, 30);

				g2d.fillOval(360, 370, 15, 25);
				g2d.fillOval(360, 430, 15, 25);
				g2d.fillOval(430, 340, 15, 25);

				g2d.fillOval(580, 220, 15, 25);
				g2d.fillOval(510, 320, 15, 25);
				
				
				
				//otras montañas
				g2d.setColor(Color.decode("#0096c7"));
				g2d.fillRect(0, 530, 150, 70);
				g2d.fillOval(0, 475, 150, 110);
				
				g2d.setColor(Color.decode("#0096c7"));
				g2d.fillRect(345, 490, 190, 110);
				g2d.fillOval(345, 425, 190, 150);
				
				g2d.setColor(Color.decode("#0096c7"));
				g2d.fillRect(535, 380, 190, 220);
				g2d.fillOval(535, 305, 190, 150);
				
				g2d.setColor(Color.decode("#0096c7"));
				g2d.fillRect(845, 420, 190, 170);
				g2d.fillOval(845, 355, 190, 150);
				
				g2d.setColor(Color.WHITE);
				g2d.fillOval(580, 370, 15, 25);
				g2d.fillOval(660, 480, 15, 25);
				
				g2d.fillArc(700, 550, 210, 100, 0, 180);
				
				//cuadros grises
				g2d.setColor(Color.decode("#000000"));
				g2d.fillRect(783, 545, 54, 54);
				
				g2d.setColor(Color.decode("#e5e5e5"));
				g2d.fillRect(785, 547, 50, 50);
					
				g2d.setColor(Color.decode("#000000"));
				g2d.fillRect(783, 495, 54, 54);
				
				g2d.setColor(Color.decode("#e5e5e5"));
				g2d.fillRect(785, 497, 50, 50);
				
				g2d.setColor(Color.decode("#000000"));
				g2d.fillRect(783, 445, 54, 54);
				
				g2d.setColor(Color.decode("#e5e5e5"));
				g2d.fillRect(785, 447, 50, 50);
				
				g2d.setColor(Color.decode("#000000"));
				g2d.fillRect(783, 395, 54, 54);
				
				g2d.setColor(Color.decode("#e5e5e5"));
				g2d.fillRect(785, 397, 50, 50);
				
				//cuadros amarillos
				g2d.setColor(Color.decode("#000000"));
				g2d.fillRect(835, 395, 54, 54);
				
				g2d.setColor(Color.decode("#ffee32"));
				g2d.fillRect(837, 397, 50, 50);
				
				g2d.setColor(Color.decode("#000000"));
				g2d.fillRect(887, 395, 54, 54);
				
				g2d.setColor(Color.decode("#ffee32"));
				g2d.fillRect(889, 397, 50, 50);
				
				g2d.setColor(Color.decode("#000000"));
				g2d.fillOval(853, 413, 4, 15);
				g2d.fillOval(864, 413, 4, 15);
				
			    // Tubo 1
			    g2d.setColor(Color.decode("#000000"));
			    g2d.fillRect(375, 500, 94, 100);

			    g2d.setColor(Color.decode("#8367c7"));
			    g2d.fillRect(380, 508, 85, 90);

			    g2d.setColor(Color.decode("#000000"));
			    g2d.fillRect(370, 458, 109, 50);

			    g2d.setColor(Color.decode("#8367c7"));
			    g2d.fillRect(375, 460, 100, 40);
			    
			    
			    // Tubo 2
			    g2d.setColor(Color.decode("#000000"));
			    g2d.fillRect(845, 500, 94, 100);

			    g2d.setColor(Color.decode("#8367c7"));
			    g2d.fillRect(850, 548, 85, 50);

			    g2d.setColor(Color.decode("#000000"));
			    g2d.fillRect(840, 498, 109, 50);

			    g2d.setColor(Color.decode("#8367c7"));
			    g2d.fillRect(845, 500, 100, 40);
			    
			    
			    
			    
	 			
				
	}*/
}
