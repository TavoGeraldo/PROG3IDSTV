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

public class UsersView {

	public UsersView() {
		
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
		
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Email");
        model.addColumn("Rol");
        model.addColumn("Teléfono");
        
        for (User usuario : usuarios) {
            model.addRow(new Object[]{usuario.id, usuario.name,usuario.email,usuario.role,usuario.phone});
        }

       
        JTable table = new JTable(model);
        table.setEnabled(false); 
  
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 100, 800, 400);  

        panel.add(scrollPane);  
				 
		
		ventana.add(panel);
		ventana.setVisible(true);
		ventana.repaint();
		ventana.revalidate();
	}

}
