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
import java.util.Iterator;
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
 	private List<MyPoint> points = new ArrayList<>();
 	
	private List<Rectangle> Rectangulos = new ArrayList<>();
	
	private List<Circle> Circulo = new ArrayList<>();
	
    private List<Triangle> Triangulo = new ArrayList<>();
 	
    List<List<MyPoint>> listaDePuntos = new ArrayList<>();
	
    private DrawingPanel drawingPanel;
    
    private int method = 1;
    
    private Color colorActual = Color.BLACK;
    
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
        rectButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				method = 2;
				
			}
		});
        panel1.add(rectButton);
        
        JButton circleButton = new JButton("Círculo");
        circleButton.setFocusPainted(false);
        circleButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				method = 3;
				
			}
		});
        panel1.add(circleButton);
        
        JButton triangleButton = new JButton("Triángulo");
        triangleButton.setFocusPainted(false);
        triangleButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				method = 4;
				
			}
		});
        
        panel1.add(triangleButton);
        
        JButton lineButton = new JButton("Línea");
        lineButton.setFocusPainted(false);
        panel1.add(lineButton);

        //opciones
        JLabel optionsLabel = new JLabel("Opciones");
        optionsLabel.setFont(new Font("Arial", Font.BOLD, 14));
        panel1.add(optionsLabel);
        
        JButton brushButton = new JButton("Pincel");
       
        brushButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				method = 1;
				
			}
		});
        panel1.add(brushButton);
        

        
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
        redButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				colorActual = Color.RED;
				
			}
		});
        colorPanel.add(redButton);
        
        JButton blueButton = new JButton();
        blueButton.setBackground(Color.BLUE);
        blueButton.setPreferredSize(new Dimension(20, 20));
        blueButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				colorActual = Color.BLUE;
				
			}
		});
        colorPanel.add(blueButton);
        
        JButton greenButton = new JButton();
        greenButton.setBackground(Color.GREEN);
        greenButton.setPreferredSize(new Dimension(20, 20));
        greenButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				colorActual = Color.GREEN;
				
			}
		});
        colorPanel.add(greenButton);
        
        JButton yellowButton = new JButton();
        yellowButton.setBackground(Color.YELLOW);
        yellowButton.setPreferredSize(new Dimension(20, 20));
        yellowButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				colorActual = Color.YELLOW;
				
			}
		});
        colorPanel.add(yellowButton);
        
        JButton blackButton = new JButton();
        blackButton.setBackground(Color.BLACK);
        blackButton.setPreferredSize(new Dimension(20, 20));
        blackButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				colorActual = Color.BLACK;
				
			}
		});
        colorPanel.add(blackButton);
         
        
        JButton clearButton = new JButton("Limpiar");
        clearButton.setFocusPainted(false);
        clearButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		        listaDePuntos.clear();  
		        points.clear();
		        Rectangulos.clear();
		        Circulo.clear();
		        Triangulo.clear();
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
		if(method==2) {
 			Rectangle tmp = new Rectangle(e.getX(),e.getY(),100,100,colorActual, grosorPincel );
 			Rectangulos.add(tmp);
 		}else if (method == 3) {
            Circulo.add(new Circle(e.getX(), e.getY(), 50,colorActual, grosorPincel));
        } else if (method == 4) {
            Triangulo.add(new Triangle(e.getX(), e.getY(), 50,colorActual, grosorPincel));
        }
		
 		
 		
 		drawingPanel.repaint();
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		lastPoint = e.getPoint();
        points.add(new MyPoint(e.getX(), e.getY(),colorActual, grosorPincel)); // Añadir el primer punto
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		ArrayList<MyPoint> listaCopiada = (ArrayList<MyPoint>) (((ArrayList<MyPoint>) points).clone());
 		
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
 		 
		if(method==1)
			 points.add(new MyPoint(e.getX(), e.getY(), colorActual, grosorPincel));  
 	        
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
 	        for (List<MyPoint> trazo : listaDePuntos) {
 	            if (trazo.size() > 1) {
 	                for (int i = 1; i < trazo.size(); i++) {
 	                    MyPoint p1 = trazo.get(i - 1);
 	                    MyPoint p2 = trazo.get(i);
 	                    g2d.setColor(p1.color);
 	                    g2d.setStroke(new BasicStroke(p1.grosor));
 	                    g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
 	                }
 	            }
 	        }
 	        
 	        // Dibujar el trazo actual (points) mientras se arrastra el mouse
 	        if (points.size() > 1) {
 	            for (int i = 1; i < points.size(); i++) {
 	                MyPoint p1 = points.get(i - 1);
 	                MyPoint p2 = points.get(i);
 	                g2d.setColor(p1.color);
 	                g2d.setStroke(new BasicStroke(p1.grosor));
 	                g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
 	            }
 	        }
 	        
 	        g2d.setColor(colorActual);
 	        g2d.setStroke(new BasicStroke(grosorPincel));
 	        
	        for (Iterator iterator = Rectangulos.iterator(); iterator.hasNext();) {
 				Rectangle rectangle = (Rectangle) iterator.next();
 				g2d.setColor(rectangle.color);
 		        g2d.setStroke(new BasicStroke(rectangle.grosor));
 				g2d.drawRect(rectangle.x, rectangle.y, rectangle.w, rectangle.h);
 				
 			}
	        
	        for (Iterator iterator = Circulo.iterator(); iterator.hasNext();) {
	            Circle circle = (Circle) iterator.next();
	            g2d.setColor(circle.color);
 		        g2d.setStroke(new BasicStroke(circle.grosor));
	            g2d.drawOval(circle.x - circle.radius, circle.y - circle.radius, circle.radius * 2, circle.radius * 2);
	        }
	        
	        for (Iterator iterator = Triangulo.iterator(); iterator.hasNext();) {
	            Triangle triangle = (Triangle) iterator.next();
	            int[] xPoints = {triangle.x, triangle.x - triangle.size, triangle.x + triangle.size};
	            int[] yPoints = {triangle.y - triangle.size, triangle.y + triangle.size, triangle.y + triangle.size};
	            g2d.setColor(triangle.color);
 		        g2d.setStroke(new BasicStroke(triangle.grosor));
	            g2d.drawPolygon(xPoints, yPoints, 3);
	        }
 	    }
 	}
	
	class Rectangle{
 		
 		private int x,y,w,h;
 		Color color;
    	int grosor;
 		
 		public Rectangle(int x, int y,int w, int h,Color color,int grosor)
 		{
 			this.x = x;
 			this.y = y;
 			this.w = w;
 			this.h = h;
 			this.color = color;
 			this.grosor = grosor;
 		}
 	}
	
    class Circle {
        private int x, y, radius;
        Color color;
    	int grosor;
        
        public Circle(int x, int y, int radius,Color color,int grosor) {
            this.x = x;
            this.y = y;
            this.radius = radius;
            this.color = color;
 			this.grosor = grosor;
        }
    }
    
    class Triangle {
        private int x, y, size;
        Color color;
    	int grosor;
        
        public Triangle(int x, int y, int size,Color color,int grosor) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.color = color;
 			this.grosor = grosor;
        }
    }
    
    class MyPoint extends Point{
    	int x,y;
    	Color color;
    	int grosor;
    	
    	public MyPoint (int x,int y,Color color,int grosor) {
    		this.x = x;
    		this.y = y;
    		this.color = color;
    		this.grosor = grosor;
    	}
    }



	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}
