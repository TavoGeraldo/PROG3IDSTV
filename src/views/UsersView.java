package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import models.User;
import models.UsersModel;

public class UsersView {
	
	private UsersModel userModel;

	public UsersView() {
		userModel = new UsersModel();
	}
	
	
	public void index(List<User> usuarios)
	{
		JFrame ventana = new JFrame();
		
		ventana.setVisible(true);
		ventana.setSize(930, 600);
		ventana.setLocationRelativeTo(null); 
		ventana.setTitle("Login"); 
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		ventana.setResizable(true);  
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setLocation(0, 0);
		panel.setLayout(null);
		panel.setSize(1000, 600); 
		
        
		int x = 100;
		for (Iterator iterator = usuarios.iterator(); iterator.hasNext();) {
			User usuario = (User) iterator.next();
			
			JLabel user = new JLabel(usuario.name);
			user.setForeground(new Color(0, 0, 0)); 
			user.setBounds(50, x, 210, 26);
			user.setHorizontalAlignment(JLabel.CENTER);
			panel.add(user);
			
			JButton btnEliminar = new JButton("Eliminar " + usuario.id);
		    btnEliminar.setBounds(260, x, 120, 25);
		    btnEliminar.setBackground(Color.RED);
		    btnEliminar.setForeground(Color.WHITE);

		    btnEliminar.addActionListener(e -> {
		        if (userModel.delete(usuario.id)) {
		            panel.remove(user);
		            panel.remove(btnEliminar);
		            panel.repaint();
		            panel.revalidate();
		        }
		    });
		    
		    panel.add(btnEliminar);
			
			x+= 35;
			 
		} 
		
		ventana.add(panel);
		ventana.setVisible(true);
		ventana.repaint();
		ventana.revalidate();
	}

}
