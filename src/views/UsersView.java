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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import models.User;
import models.UsersModel;
import views.RegisterView;

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
		
		JButton NewUserButton = new JButton("Registrar usuario");
		NewUserButton.setBounds(80, 30, 150, 25);
		NewUserButton.setBackground(Color.BLUE);
		NewUserButton.setForeground(Color.WHITE);
		
		
		NewUserButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 ventana.dispose();
				
				RegisterView rvi = new RegisterView();
				rvi.register();

			}
		});
		
		panel.add(NewUserButton);
		
		 String[] columnas = { "ID", "Nombre", "Correo" };
		 DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);
		 JTable tabla = new JTable(modeloTabla) {
			 @Override
			    public boolean isCellEditable(int row, int column) {
			        return false; 
			    }
		 };
		 
		 
		 JScrollPane scrollPane = new JScrollPane(tabla);
		 scrollPane.setBounds(20, 60, 400, 200);
		 panel.add(scrollPane);
		
		    
		  for (User usuario : usuarios) {
		        Object[] fila = { usuario.id, usuario.name, usuario.email };
		        modeloTabla.addRow(fila);
		    }  
			
			
		
		  JButton btnEliminar = new JButton("Eliminar seleccionado");
		    btnEliminar.setBounds(240, 280, 180, 30);
		    btnEliminar.setBackground(Color.RED);
		    btnEliminar.setForeground(Color.WHITE);
		    
		    btnEliminar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					int filaSeleccionada = tabla.getSelectedRow();
			    	if (filaSeleccionada >= 0) {
			    	    int idUsuario = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
			    	    if (userModel.delete(idUsuario)) {
			    	        modeloTabla.removeRow(filaSeleccionada);
			    	    }
			    	}
				}
			});
		    
		    panel.add(btnEliminar);
		    
		    JButton btnEditar = new JButton("Editar");
		    btnEditar.setBounds(20, 280, 180, 30);
		    btnEditar.setBackground(Color.darkGray);
		    btnEditar.setForeground(Color.WHITE);
		    
		    btnEditar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					 int filaSeleccionada = tabla.getSelectedRow();
				        if (filaSeleccionada >= 0) {
				            int idUsuario = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
				            String nombreActual = (String) modeloTabla.getValueAt(filaSeleccionada, 1);
				            String correoActual = (String) modeloTabla.getValueAt(filaSeleccionada, 2);
				            
				            mostrarFormularioEdicion(idUsuario, nombreActual, correoActual, filaSeleccionada, modeloTabla);
				        } else {
				            System.out.println("Selecciona un usuario para editar.");
				        }
					
				}
			});
		    
		    panel.add(btnEditar);
			
		
		ventana.add(panel);
		ventana.setVisible(true);
		ventana.repaint();
		ventana.revalidate();
	}
	
	private void mostrarFormularioEdicion(int id, String nombreActual, String correoActual, int fila, DefaultTableModel modelo) {
	    JFrame Ventana = new JFrame("Editar Usuario");
	    Ventana.setSize(930, 600);
	    Ventana.setLayout(null);
	    Ventana.setLocationRelativeTo(null);

	    JLabel lblNombre = new JLabel("Nombre:");
	    lblNombre.setBounds(50, 50, 100, 25);
	    Ventana.add(lblNombre);
	    
	    JTextField txtNombre = new JTextField(nombreActual);
	    txtNombre.setBounds(150, 50, 225, 25);
	    Ventana.add(txtNombre);

	    JLabel lblCorreo = new JLabel("Correo:");
	    lblCorreo.setBounds(50, 100, 100, 25);
	    Ventana.add(lblCorreo);
	    
	    JTextField txtCorreo = new JTextField(correoActual);
	    txtCorreo.setBounds(150, 100, 225, 25);
	    Ventana.add(txtCorreo);

	    JButton btnGuardar = new JButton("Guardar");
	    btnGuardar.setBounds(90, 170, 100, 30);
	    btnGuardar.setBackground(Color.GREEN);
	    btnGuardar.setForeground(Color.WHITE);
	    
	    btnGuardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String nuevoNombre = txtNombre.getText();
		        String nuevoCorreo = txtCorreo.getText();

		        
		        boolean actualizado = userModel.edit(id, nuevoNombre, nuevoCorreo);
		           
		        modelo.setValueAt(nuevoNombre, fila, 1);
		        modelo.setValueAt(nuevoCorreo, fila, 2);
		        Ventana.dispose();
		        
				
			}
		});
	    
	    Ventana.add(btnGuardar);
	    
	    JButton btnCancelar = new JButton("Cancelar");
	    btnCancelar.setBounds(250, 170, 100, 30);
	    btnCancelar.setBackground(Color.RED);
	    btnCancelar.setForeground(Color.WHITE);
	    btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Ventana.dispose();
			}
		});
	    Ventana.add(btnCancelar);


	    Ventana.setVisible(true);
		Ventana.repaint();
		Ventana.revalidate();
	    
	}


}
