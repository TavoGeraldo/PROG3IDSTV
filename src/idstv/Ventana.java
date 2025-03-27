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
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

public class Ventana extends JFrame implements MouseListener, MouseMotionListener {

	
 	
 	private Point lastPoint; // Para almacenar la última posición del mouse
      // Para almacenar los puntos dibujados
 	private List<Point> points = new ArrayList<>();
 	
    List<List<Point>> listaDePuntos = new ArrayList<>();
	
    private DrawingPanel drawingPanel;
    
    int  grosorPincel = 3;
    int grosorMin = 1;
    int grosorMax = 18;  
     
     
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
        panel1.setLayout(new GridLayout(14, 1, 5, 5));
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
        
        JLabel grosorLabel = new JLabel("Grosor: "+ grosorPincel);
        panel1.add(grosorLabel);
        
        JPanel grosorPanel = new JPanel(new FlowLayout());
        grosorPanel.setBackground(Color.WHITE);
        panel1.add(grosorPanel);
        
        JButton menosButton = new JButton("-");
        menosButton.setFocusPainted(false);
        menosButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(grosorPincel > grosorMin) {
					grosorPincel--;
					grosorLabel.setText("Grosor: " + grosorPincel);
				}
				
			}
		});
        grosorPanel.add(menosButton);
        
        JButton masButton = new JButton("+");
        masButton.setFocusPainted(false);
        masButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(grosorPincel < grosorMax) {
					grosorPincel++;
					grosorLabel.setText("Grosor: " + grosorPincel);
				}
				
			}
		});
        grosorPanel.add(masButton);
        
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
        clearButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		        listaDePuntos.clear();  
		        points.clear();        
		        drawingPanel.repaint(); 
				
			}
		});
        
        
        panel1.add(clearButton);
        
		
		return panel1;
	}
	
	public JPanel lienzo() {

		JPanel panel1 = new JPanel();
	    panel1.setBackground(Color.WHITE);
	    panel1.setLayout(new BorderLayout()); // Asegura que el DrawingPanel se expanda
	    panel1.setLocation(240, 50);
	    panel1.setSize(610, 550);
	    panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));

	    drawingPanel = new DrawingPanel();
	    drawingPanel.setPreferredSize(new Dimension(610, 550)); // Asegura que ocupe el espacio completo
	    drawingPanel.addMouseListener(this); // Agregar eventos
	    drawingPanel.addMouseMotionListener(this);

	    panel1.add(drawingPanel, BorderLayout.CENTER);
	    
	    return panel1;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		lastPoint = e.getPoint();
        points.add(lastPoint); // Añadir el primer punto
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		ArrayList<Point> listaCopiada = (ArrayList<Point>) (((ArrayList<Point>) points).clone());
 		
 		listaDePuntos.add(listaCopiada); 
 		points.clear();
 		
 		System.out.println(listaDePuntos);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
 Point newPoint = e.getPoint(); 
 		 
 		 points.add(newPoint);  
 	        
 	     drawingPanel.repaint();
 	        
 	     lastPoint = newPoint;
		
	}
	
	class DrawingPanel extends JPanel {
 	    public DrawingPanel() {
 	        setBackground(Color.WHITE);
 	    }
 
 	    @Override
 	    protected void paintComponent(Graphics g) {
 	        super.paintComponent(g);
 	        Graphics2D g2d = (Graphics2D) g;
 	        
 	        // Configuración del dibujo
 	        g2d.setColor(Color.BLACK);
 	        g2d.setStroke(new BasicStroke(grosorPincel));
 	        
 	        // Dibujar todos los trazos guardados (listaDePuntos)
 	        for (List<Point> trazo : listaDePuntos) {
 	            if (trazo.size() > 1) {
 	                for (int i = 1; i < trazo.size(); i++) {
 	                    Point p1 = trazo.get(i - 1);
 	                    Point p2 = trazo.get(i);
 	                    g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
 	                }
 	            }
 	        }
 	        
 	        // Dibujar el trazo actual (points) mientras se arrastra el mouse
 	        if (points.size() > 1) {
 	            for (int i = 1; i < points.size(); i++) {
 	                Point p1 = points.get(i - 1);
 	                Point p2 = points.get(i);
 	                g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
 	            }
 	        }
 	    }
 	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}
