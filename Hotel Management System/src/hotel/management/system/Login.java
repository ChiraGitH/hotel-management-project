package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
	JLabel l1, l2;
	JTextField t1;
	JPasswordField t2;
	JButton b1, b2;
	Login(){
		l1 = new JLabel("Username");
		l1.setBounds(40, 20, 60, 30);
		add(l1);
		
		l2 = new JLabel("Password");
		l2.setBounds(40, 70, 60, 30);
		add(l2);
		
		t1 = new JTextField();
		t1.setBounds(120, 25, 100, 20);
		add(t1);
		
		t2 = new JPasswordField();
		t2.setBounds(120, 75, 100, 20);
		add(t2);
		
		b1 = new JButton("Login");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(40, 120, 80, 20);
		add(b1);
		b1.addActionListener(this);
		
		b2 = new JButton("Cancel");
		b2.setBounds(140, 120, 80, 20);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.white);
		b2.addActionListener(this);
		add(b2);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/second.jpg"));
		Image i2 = i1.getImage().getScaledInstance(140, 160, Image.SCALE_DEFAULT);		//To change the dimensions of imageicon
		ImageIcon i3 = new ImageIcon(i2);                          // because JLabel only takes ImageIcon as parameter.
		JLabel l3 = new JLabel(i3);
		l3.setBounds(240,20, 100,140);
		add(l3);
		
		
		getContentPane().setBackground(Color.white);             //to match the image bg color with color of JFrame.
		setLayout(null);
		setBounds(500, 270, 370, 230);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
			String username = t1.getText();
			String password = t2.getText();
			conn c = new conn();
			
			String str = "SELECT * FROM login WHERE username = '"+username+"' and password = '"+password+"'";
			try{
				ResultSet rs = c.s.executeQuery(str);
				if(rs.next()) {
					new Dashboard().setVisible(true);
					this.setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid credentials");
					this.setVisible(true);
				}
			}catch(Exception e) {}
		}
		else if(ae.getSource() == b2) {
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		new Login();
	}
}