package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddDriver extends JFrame implements ActionListener{

	JTextField t1, t2, t3, t4, t5;
	JComboBox c1, c2;
	JButton b1, b2;
	
	AddDriver(){
		
		JLabel title = new JLabel("Add Driver");
		title.setBounds(110, 10, 150, 30);
		title.setFont(new Font("tahoma", Font.BOLD, 18));
		add(title);
		
		
		JLabel name = new JLabel("Name");
		name.setBounds(60, 70, 100, 30);
		name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(name);
		
		t1 = new JTextField();
		t1.setBounds(160, 75, 100, 20);
		add(t1);
		
		JLabel age = new JLabel("Age");
		age.setBounds(60, 110, 100, 30);
		age.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(age);
		
		t2 = new JTextField();
		t2.setBounds(160, 115, 100, 20);
		add(t2);
		
		JLabel gender = new JLabel("Gender");
		gender.setBounds(60, 150, 100, 30);
		gender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(gender);
		
		c1 = new JComboBox(new String[] {"Male", "Female"});
		c1.setBounds(160, 155, 100, 20);
		c1.setBackground(Color.white);
		add(c1);
		
		JLabel car = new JLabel("Car Company");
		car.setBounds(60, 190, 100, 30);
		car.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(car);
		
		t3 = new JTextField();
		t3.setBounds(160, 195, 100, 20);
		add(t3);
		
		JLabel model = new JLabel("Car Model");
		model.setBounds(60, 230, 100, 30);
		model.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(model);
		
		t4 = new JTextField();
		t4.setBounds(160, 235, 100, 20);
		add(t4);
		
		JLabel available = new JLabel("Available");
		available.setBounds(60, 270, 100, 30);
		available.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(available);
		
		c2 = new JComboBox(new String[] {"Yes", "No"});
		c2.setBounds(160, 275, 100, 20);
		c2.setBackground(Color.white);
		add(c2);
		
		JLabel location = new JLabel("Location");
		location.setBounds(60, 310, 100, 30);
		location.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(location);
		
		t5 = new JTextField();
		t5.setBounds(160, 315, 100, 20);
		add(t5);
		
		b1 = new JButton("Submit");
		b1.setBounds(60, 370, 80, 25);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Cancel");
		b2.setBounds(180, 370, 80, 25);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		add(b2);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eleven.jpg"));
		Image img = i1.getImage().getScaledInstance(600, 450, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(img);
		JLabel l1 = new JLabel(i2);
		l1.setBounds(300, 0, 600, 450);
		add(l1);
		
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		setBounds(210,160,900, 450);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			
			String name = t1.getText();
			String age = t2.getText();
			String gender = (String)c1.getSelectedItem();
			String company = t3.getText();
			String model = t4.getText();
			String available = (String)c2.getSelectedItem();
			String location = t5.getText();
			
			conn c = new conn();
			String str = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+model+"','"+available+"','"+location+"');";
			try {
				c.s.executeUpdate(str);
				JOptionPane.showMessageDialog(null, "Driver Added Succesfully");
			}catch(Exception e) {}
			
		}else if(ae.getSource() == b2) 
			this.setVisible(false);
	}
	
	public static void main(String[] args)
	{
		new AddDriver();
	}
}