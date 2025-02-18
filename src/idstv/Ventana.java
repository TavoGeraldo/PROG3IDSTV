package idstv;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Ventana extends JFrame {
	
	public Ventana(){
		this.setTitle("Login");
		this.setVisible(true);
		this.setSize(500, 500);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setResizable(true);
		
		this.add(this.login());
		this.repaint();
		
	}
	
	public JPanel login() {
		
		JPanel panel1 = new JPanel();
		
		panel1.setBackground(Color.decode("#faedcd"));
		panel1.setOpaque(true);
		panel1.setSize(500, 500);
		panel1.setLocation(0, 0);
		panel1.setLayout(null);
		
		//Etiquetas
		JLabel etiqueta1 = new JLabel("Nombre de usuario:");
		etiqueta1.setSize(150, 30);
		etiqueta1.setLocation(100, 80);
		etiqueta1.setFont(new Font("Arial", Font.BOLD, 14));
		panel1.add(etiqueta1);
		
		JLabel etiqueta2 = new JLabel("Contraseña:");
		etiqueta2.setSize(150, 30);
		etiqueta2.setLocation(100, 160);
		etiqueta2.setFont(new Font("Arial", Font.BOLD, 14));
		panel1.add(etiqueta2);
		
		JLabel etiqueta3 = new JLabel("Recordarme");
		etiqueta3.setSize(150, 30);
		etiqueta3.setLocation(120, 220);
		etiqueta3.setFont(new Font("Arial", Font.ITALIC, 12));
		panel1.add(etiqueta3);
		
		JLabel etiqueta4 = new JLabel("¿Olvido su contraseña?");
		etiqueta4.setSize(150, 30);
		etiqueta4.setLocation(220, 220);
		etiqueta4.setFont(new Font("Arial", Font.ITALIC, 12));
		panel1.add(etiqueta4);
		
		JCheckBox caja = new JCheckBox();
		caja.setSize(20, 30);
		caja.setLocation(100, 220);
		panel1.add(caja);
		
		//Campos de texto
		JPasswordField contrasena = new JPasswordField();
		contrasena.setSize(270, 30);
		contrasena.setLocation(100, 190);
		panel1.add(contrasena);
		
		JTextField usuario = new JTextField();
		usuario.setSize(270, 30);
		usuario.setLocation(100, 110);
		panel1.add(usuario);
		
		//Botones
		JButton boton = new JButton("Acceder");
		boton.setBounds(150, 270, 170, 50);
		boton.setFont(new Font("Arial", Font.BOLD, 18));
		panel1.add(boton);
		
		return panel1;
	}
	
	

}
