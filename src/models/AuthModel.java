package models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class AuthModel {

	public AuthModel() {

	}

	public boolean login(String email, String password) {

		BufferedReader reader;

		try {
			String url = this.getClass().getResource("/files/users.txt").getPath();
			reader = new BufferedReader(new FileReader(url));
			String line = reader.readLine();

			while (line != null) {
				
				String[] data = line.split(",");
				
				
				line = reader.readLine();
				
				if(email.equals(data[2])) {
					if(password.equals(data[3])) {
						return true;
					}
				}
			}

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
