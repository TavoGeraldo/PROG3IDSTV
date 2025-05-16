package views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.UsersController;
import models.UsersModel;

public class RegisterView {
	 private UsersModel userModel;
	 
	 public RegisterView() {
			userModel = new UsersModel();
	 }
	 
	 public void register() {
		 
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

	       
	        JLabel NameLbl = new JLabel("Nombre:");
	        NameLbl.setBounds(50, 50, 100, 25);
	        panel.add(NameLbl);

	        JTextField NameText = new JTextField();
	        NameText.setBounds(150, 50, 200, 25);
	        panel.add(NameText);

	        JLabel EmailLbl = new JLabel("Email:");
	        EmailLbl.setBounds(50, 100, 100, 25);
	        panel.add(EmailLbl);

	        JTextField EmailText = new JTextField();
	        EmailText.setBounds(150, 100, 200, 25);
	        panel.add(EmailText);

	        JLabel RolLbl = new JLabel("Rol:");
	        RolLbl.setBounds(50, 150, 100, 25);
	        panel.add(RolLbl);

	        JTextField RoleText = new JTextField();
	        RoleText.setBounds(150, 150, 200, 25);
	        panel.add(RoleText);

	        JLabel PhoneLbl = new JLabel("Teléfono:");
	        PhoneLbl.setBounds(50, 200, 100, 25);
	        panel.add(PhoneLbl);

	        JTextField Phonetext = new JTextField();
	        Phonetext.setBounds(150, 200, 200, 25);
	        panel.add(Phonetext);

	        
	        JButton RegisterButton = new JButton("Registrar");
	        RegisterButton.setBounds(150, 250, 200, 30);
	        RegisterButton.setBackground(Color.BLUE);
	        RegisterButton.setForeground(Color.WHITE);

	        RegisterButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					 	String name = NameText.getText();
		                String email = EmailText.getText();
		                String role = RoleText.getText();
		                String phone = Phonetext.getText();
		                
		                userModel.insert(name, email, role, phone);
		                
		                ventana.dispose();
		                UsersController uc = new UsersController();
						uc.index();
					
				}
			});

	        panel.add(RegisterButton);

	        
	        ventana.add(panel);
	        ventana.setVisible(true);
	        ventana.repaint();
			ventana.revalidate();
	   }
		 
		 
	 
}
