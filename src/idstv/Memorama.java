package idstv;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;

public class Memorama extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public int cartas [] = {1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8};
	
	int c1 = -1, c2=-1;
	int paresEncontrados = 0;
	
	ArrayList<JButton> cartas2 = new ArrayList<JButton>();
	
	
    public void verificarPar() {
        if (c1 != -1 && c2 != -1) { 
            if (cartas[c1] == cartas[c2]) { 
                cartas2.get(c1).setEnabled(false); 
                cartas2.get(c2).setEnabled(false); 
                paresEncontrados++; 
                if (paresEncontrados == cartas.length / 2) {
                    
                    JOptionPane.showMessageDialog(this, "Encontraste todos los pares.", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                }
            } else { 
                
                JOptionPane.showMessageDialog(this, "No es par", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                
                cartas2.get(c1).setIcon(new ImageIcon(Memorama.class.getResource("/idstv/signoInterrogacion.png")));
                cartas2.get(c2).setIcon(new ImageIcon(Memorama.class.getResource("/idstv/signoInterrogacion.png")));
            }
            c1 = -1; 
            c2 = -1; 
        }
    }
	
	
	public void barajarCartas() {
	    Random rand = new Random();
	    for (int i = cartas.length - 1; i > 0; i--) {
	        int j = rand.nextInt(i + 1);
	        int temp = cartas[i];
	        cartas[i] = cartas[j];
	        cartas[j] = temp;
	    }
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Memorama frame = new Memorama();
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
	public Memorama() {
		barajarCartas();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 754, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(106, 168, 190));
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton_16 = new JButton("Jugar de nuevo");
		btnNewButton_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        barajarCartas(); 
		        paresEncontrados = 0; 
		        c1 = -1;
		        c2 = -1;
		        for (int i = 0; i < cartas2.size(); i++) {
		            cartas2.get(i).setEnabled(true); 
		            cartas2.get(i).setIcon(new ImageIcon(Memorama.class.getResource("/idstv/signoInterrogacion.png"))); 
		        }
			}
		});
		btnNewButton_16.setFocusPainted(false);
		panel_1.add(btnNewButton_16);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 128, 128));
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(106, 168, 190));
		panel_2.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Puntuación:");
		panel_3.add(lblNewLabel_1, BorderLayout.WEST);
		
		JLabel lblNewLabel = new JLabel("Memorama");
		lblNewLabel.setBackground(new Color(42, 58, 136));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		panel_3.add(lblNewLabel, BorderLayout.CENTER);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(106, 168, 190));
		panel_2.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(4, 4, 15, 15));
		panel_4.setBorder(BorderFactory.createMatteBorder(18, 18, 18, 18,Color.decode("#6aa8be")));
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton.setIcon(new ImageIcon(Memorama.class.getResource("/idstv/"+cartas[0]+".png")));
				
				 if (c1 == -1) {
	                    c1 = 0;
	                } else if (c2 == -1 && 0 != c1) {
	                    c2 = 0;
	                    verificarPar();
	                }
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(Memorama.class.getResource("/idstv/signoInterrogacion.png")));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(221, 221, 220));
		panel_4.add(btnNewButton);
		cartas2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_1.setIcon(new ImageIcon(Memorama.class.getResource("/idstv/"+cartas[1]+".png")));
				
				 if (c1 == -1) {
	                    c1 = 1;
	                } else if (c2 == -1 && 1 != c1) {
	                    c2 = 1;
	                    verificarPar();
	                }
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(Memorama.class.getResource("/idstv/signoInterrogacion.png")));
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(221, 221, 220));
		panel_4.add(btnNewButton_1);
		cartas2.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_2.setIcon(new ImageIcon(Memorama.class.getResource("/idstv/"+cartas[2]+".png")));
				
				 if (c1 == -1) {
	                    c1 = 2;
	                } else if (c2 == -1 && 2 != c1) {
	                    c2 = 2;
	                    verificarPar();
	                }
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(Memorama.class.getResource("/idstv/signoInterrogacion.png")));
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(221, 221, 220));
		panel_4.add(btnNewButton_2);
		cartas2.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_3.setIcon(new ImageIcon(Memorama.class.getResource("/idstv/"+cartas[3]+".png")));
				
				 if (c1 == -1) {
	                    c1 = 3;
	                } else if (c2 == -1 && 3 != c1) {
	                    c2 = 3;
	                    verificarPar();
	                }
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(Memorama.class.getResource("/idstv/signoInterrogacion.png")));
		btnNewButton_3.setFocusPainted(false);
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(221, 221, 220));
		panel_4.add(btnNewButton_3);
		cartas2.add(btnNewButton_3);
		
		JButton btnNewButton_12 = new JButton("");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_12.setIcon(new ImageIcon(Memorama.class.getResource("/idstv/"+cartas[4]+".png")));
				
				 if (c1 == -1) {
	                    c1 = 4;
	                } else if (c2 == -1 && 4 != c1) {
	                    c2 = 4;
	                    verificarPar();
	                }
			}
		});
		btnNewButton_12.setIcon(new ImageIcon(Memorama.class.getResource("/idstv/signoInterrogacion.png")));
		btnNewButton_12.setFocusPainted(false);
		btnNewButton_12.setForeground(new Color(255, 255, 255));
		btnNewButton_12.setBackground(new Color(221, 221, 220));
		panel_4.add(btnNewButton_12);
		cartas2.add(btnNewButton_12);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_4.setIcon(new ImageIcon(Memorama.class.getResource("/idstv/"+cartas[5]+".png")));
				
				 if (c1 == -1) {
	                    c1 = 5;
	                } else if (c2 == -1 && 5 != c1) {
	                    c2 = 5;
	                    verificarPar();
	                }
			}
		});
		btnNewButton_4.setIcon(new ImageIcon(Memorama.class.getResource("/idstv/signoInterrogacion.png")));
		btnNewButton_4.setFocusPainted(false);
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setBackground(new Color(221, 221, 220));
		panel_4.add(btnNewButton_4);
		cartas2.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_5.setIcon(new ImageIcon(Memorama.class.getResource("/idstv/"+cartas[6]+".png")));
				
				 if (c1 == -1) {
	                    c1 = 6;
	                } else if (c2 == -1 && 6 != c1) {
	                    c2 = 6;
	                    verificarPar();
	                }
			}
		});
		btnNewButton_5.setIcon(new ImageIcon(Memorama.class.getResource("/idstv/signoInterrogacion.png")));
		btnNewButton_5.setFocusPainted(false);
		btnNewButton_5.setForeground(new Color(255, 255, 255));
		btnNewButton_5.setBackground(new Color(221, 221, 220));
		panel_4.add(btnNewButton_5);
		cartas2.add(btnNewButton_5);
		
		JButton btnNewButton_9 = new JButton("");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_9.setIcon(new ImageIcon(Memorama.class.getResource("/idstv/"+cartas[7]+".png")));
				
				 if (c1 == -1) {
	                    c1 = 7;
	                } else if (c2 == -1 && 7 != c1) {
	                    c2 = 7;
	                    verificarPar();
	                }
			}
		});
		btnNewButton_9.setIcon(new ImageIcon(Memorama.class.getResource("/idstv/signoInterrogacion.png")));
		btnNewButton_9.setFocusPainted(false);
		btnNewButton_9.setForeground(new Color(255, 255, 255));
		btnNewButton_9.setBackground(new Color(221, 221, 220));
		panel_4.add(btnNewButton_9);
		cartas2.add(btnNewButton_9);
		
		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_6.setIcon(new ImageIcon(Memorama.class.getResource("/idstv/"+cartas[8]+".png")));
				
				 if (c1 == -1) {
	                    c1 = 8;
	                } else if (c2 == -1 && 8 != c1) {
	                    c2 = 8;
	                    verificarPar();
	                }
			}
		});
		btnNewButton_6.setIcon(new ImageIcon(Memorama.class.getResource("/idstv/signoInterrogacion.png")));
		btnNewButton_6.setFocusPainted(false);
		btnNewButton_6.setForeground(new Color(255, 255, 255));
		btnNewButton_6.setBackground(new Color(221, 221, 220));
		panel_4.add(btnNewButton_6);
		cartas2.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_7.setIcon(new ImageIcon(Memorama.class.getResource("/idstv/"+cartas[9]+".png")));
				
				 if (c1 == -1) {
	                    c1 = 9;
	                } else if (c2 == -1 && 9 != c1) {
	                    c2 = 9;
	                    verificarPar();
	                }
			}
		});
		btnNewButton_7.setIcon(new ImageIcon(Memorama.class.getResource("/idstv/signoInterrogacion.png")));
		btnNewButton_7.setFocusPainted(false);
		btnNewButton_7.setForeground(new Color(255, 255, 255));
		btnNewButton_7.setBackground(new Color(221, 221, 220));
		panel_4.add(btnNewButton_7);
		cartas2.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_8.setIcon(new ImageIcon(Memorama.class.getResource("/idstv/"+cartas[10]+".png")));
				
				 if (c1 == -1) {
	                    c1 = 10;
	                } else if (c2 == -1 && 10 != c1) {
	                    c2 = 10;
	                    verificarPar();
	                }
			}
		});
		btnNewButton_8.setIcon(new ImageIcon(Memorama.class.getResource("/idstv/signoInterrogacion.png")));
		btnNewButton_8.setFocusPainted(false);
		btnNewButton_8.setForeground(new Color(255, 255, 255));
		btnNewButton_8.setBackground(new Color(221, 221, 220));
		panel_4.add(btnNewButton_8);
		cartas2.add(btnNewButton_8);
		
		JButton btnNewButton_10 = new JButton("");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_10.setIcon(new ImageIcon(Memorama.class.getResource("/idstv/"+cartas[11]+".png")));
				
				 if (c1 == -1) {
	                    c1 = 11;
	                } else if (c2 == -1 && 11 != c1) {
	                    c2 = 11;
	                    verificarPar();
	                }
			}
		});
		btnNewButton_10.setIcon(new ImageIcon(Memorama.class.getResource("/idstv/signoInterrogacion.png")));
		btnNewButton_10.setFocusPainted(false);
		btnNewButton_10.setForeground(new Color(255, 255, 255));
		btnNewButton_10.setBackground(new Color(221, 221, 220));
		panel_4.add(btnNewButton_10);
		cartas2.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_11.setIcon(new ImageIcon(Memorama.class.getResource("/idstv/"+cartas[12]+".png")));
				
				 if (c1 == -1) {
	                    c1 = 12;
	                } else if (c2 == -1 && 12 != c1) {
	                    c2 = 12;
	                    verificarPar();
	                }
			}
		});
		btnNewButton_11.setIcon(new ImageIcon(Memorama.class.getResource("/idstv/signoInterrogacion.png")));
		btnNewButton_11.setFocusPainted(false);
		btnNewButton_11.setForeground(new Color(255, 255, 255));
		btnNewButton_11.setBackground(new Color(221, 221, 220));
		panel_4.add(btnNewButton_11);
		cartas2.add(btnNewButton_11);
		
		JButton btnNewButton_13 = new JButton("");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_13.setIcon(new ImageIcon(Memorama.class.getResource("/idstv/"+cartas[13]+".png")));
				
				 if (c1 == -1) {
	                    c1 = 13;
	                } else if (c2 == -1 && 13 != c1) {
	                    c2 = 13;
	                    verificarPar();
	                }
			}
		});
		btnNewButton_13.setIcon(new ImageIcon(Memorama.class.getResource("/idstv/signoInterrogacion.png")));
		btnNewButton_13.setFocusPainted(false);
		btnNewButton_13.setForeground(new Color(255, 255, 255));
		btnNewButton_13.setBackground(new Color(221, 221, 220));
		panel_4.add(btnNewButton_13);
		cartas2.add(btnNewButton_13);
		
		JButton btnNewButton_14 = new JButton("");
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_14.setIcon(new ImageIcon(Memorama.class.getResource("/idstv/"+cartas[14]+".png")));
				
				 if (c1 == -1) {
	                    c1 = 14;
	                } else if (c2 == -1 && 14 != c1) {
	                    c2 = 14;
	                    verificarPar();
	                }
			}
		});
		btnNewButton_14.setIcon(new ImageIcon(Memorama.class.getResource("/idstv/signoInterrogacion.png")));
		btnNewButton_14.setFocusPainted(false);
		btnNewButton_14.setForeground(new Color(255, 255, 255));
		btnNewButton_14.setBackground(new Color(221, 221, 220));
		panel_4.add(btnNewButton_14);
		cartas2.add(btnNewButton_14);
		
		JButton btnNewButton_15 = new JButton("");
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_15.setIcon(new ImageIcon(Memorama.class.getResource("/idstv/"+cartas[15]+".png")));
				
				 if (c1 == -1) {
	                    c1 = 15;
	                } else if (c2 == -1 && 15 != c1) {
	                    c2 = 15;
	                    verificarPar();
	                }
			}
		});
		btnNewButton_15.setIcon(new ImageIcon(Memorama.class.getResource("/idstv/signoInterrogacion.png")));
		btnNewButton_15.setFocusPainted(false);
		btnNewButton_15.setForeground(new Color(255, 255, 255));
		btnNewButton_15.setBackground(new Color(221, 221, 220));
		panel_4.add(btnNewButton_15);
		cartas2.add(btnNewButton_15);
	}

}
