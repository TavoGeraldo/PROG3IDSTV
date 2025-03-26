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
		this.setTitle("Paint Chino");
		this.setSize(900, 700);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		this.getContentPane().setBackground(Color.decode("#4a99f8"));
		
		ImageIcon iconoVentana = new ImageIcon("paint.png");
		this.setIconImage(iconoVentana.getImage());

		
		this.add(this.Herramientas());
		this.add(this.lienzo());
		 
		this.repaint();
		this.revalidate();

		this.setVisible(true);

	}
	
	public JPanel Herramientas() {
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.WHITE);
        panel1.setLayout(new GridLayout(12, 1, 5, 5));
        panel1.setLocation(30, 50);
        panel1.setSize(190, 550);
        panel1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        //formas
        JLabel shapesLabel = new JLabel("Figuras");
        shapesLabel.setFont(new Font("Arial", Font.BOLD, 14));
        panel1.add(shapesLabel);
        
        JButton rectButton = new JButton("Rectángulo");
        rectButton.setFocusPainted(false);
        panel1.add(rectButton);
        
        JButton circleButton = new JButton("Círculo");
        circleButton.setFocusPainted(false);
        panel1.add(circleButton);
        
        JButton triangleButton = new JButton("Triángulo");
        triangleButton.setFocusPainted(false);
        panel1.add(triangleButton);
        
        JButton lineButton = new JButton("Línea");
        lineButton.setFocusPainted(false);
        panel1.add(lineButton);

        //opciones
        JLabel optionsLabel = new JLabel("Opciones");
        optionsLabel.setFont(new Font("Arial", Font.BOLD, 14));
        panel1.add(optionsLabel);
        
        JRadioButton brushButton = new JRadioButton("Pincel", true);
        brushButton.setBackground(Color.WHITE);
        panel1.add(brushButton);
        
        JRadioButton eraserButton = new JRadioButton("Borrador");
        eraserButton.setBackground(Color.WHITE);
        panel1.add(eraserButton);
        
        JCheckBox fillColor = new JCheckBox("Rellenar");
        fillColor.setBackground(Color.WHITE);
        panel1.add(fillColor);
        
        ButtonGroup toolsGroup = new ButtonGroup();
        toolsGroup.add(brushButton);
        toolsGroup.add(eraserButton);
        
        //colores
        JLabel colorLabel = new JLabel("Colores");
        colorLabel.setFont(new Font("Arial", Font.BOLD, 14));
        panel1.add(colorLabel);
        
        JPanel colorPanel = new JPanel();
        colorPanel.setBackground(Color.WHITE);
        colorPanel.setLayout(new FlowLayout());
        panel1.add(colorPanel);
        
        JButton redButton = new JButton();
        redButton.setBackground(Color.RED);
        redButton.setPreferredSize(new Dimension(20, 20));
        colorPanel.add(redButton);
        
        JButton blueButton = new JButton();
        blueButton.setBackground(Color.BLUE);
        blueButton.setPreferredSize(new Dimension(20, 20));
        colorPanel.add(blueButton);
        
        JButton greenButton = new JButton();
        greenButton.setBackground(Color.GREEN);
        greenButton.setPreferredSize(new Dimension(20, 20));
        colorPanel.add(greenButton);
        
        JButton yellowButton = new JButton();
        yellowButton.setBackground(Color.YELLOW);
        yellowButton.setPreferredSize(new Dimension(20, 20));
        colorPanel.add(yellowButton);
        
         
        
        JButton clearButton = new JButton("Limpiar");
        clearButton.setFocusPainted(false);
        panel1.add(clearButton);
        
		
		return panel1;
	}
	
	public JPanel lienzo() {
		JPanel panel1 = new JPanel();
		
		panel1.setBackground(Color.WHITE);
		panel1.setLocation(240, 50);
		panel1.setSize(610, 550);
		panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		
		
		return panel1;
	}


}
