package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener{
	
	JTextField t1, t2;
	JComboBox c1, c2, c3;
	JButton b1, b2;
	
	AddRooms(){
		
		JLabel l1 = new JLabel("Add Rooms");
		l1.setBounds(115,10,120,20);
		l1.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(l1);
		
		JLabel room = new JLabel("Room number");
		room.setBounds(60, 60, 100, 30);
		room.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(room);
		
		t1 = new JTextField();
		t1.setBounds(180, 65, 105, 20);
		add(t1);
		
		JLabel available = new JLabel("Available");
		available.setBounds(60, 100, 100, 30);
		available.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(available);
		
		c1 = new JComboBox(new String[] {"Available", "Occupied"});
		c1.setBounds(180, 105, 105, 20);
		c1.setBackground(Color.WHITE);
		add(c1);
		
		JLabel status = new JLabel("Cleaning Status");
		status.setBounds(60, 140, 100, 30);
		status.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(status);
		
		c2 = new JComboBox(new String[] {"Clean", "Dirty"});
		c2.setBackground(Color.WHITE);
		c2.setBounds(180, 145, 105, 20);
		add(c2);
		
		JLabel price = new JLabel("Price");
		price.setBounds(60, 180, 100, 30);
		price.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(price);
		
		t2 = new JTextField();
		t2.setBounds(180, 185, 105, 20);
		add(t2);
		
		JLabel type = new JLabel("Bed Type");
		type.setBounds(60, 220, 100, 30);
		type.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(type);
		
		c3 = new JComboBox(new String[] {"Single", "Double"});
		c3.setBackground(Color.WHITE);
		c3.setBounds(180, 225, 105, 20);
		add(c3);
		
		b1 = new JButton("Add Room");
		b1.setBounds(60, 280, 100, 20);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		add(b1);
		b1.addActionListener(this);
		
		b2 = new JButton("Cancel");
		b2.setBounds(180, 280, 100, 20);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		add(b2);
		b2.addActionListener(this);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/twelve.jpg"));
		Image img = i1.getImage().getScaledInstance(500, 350, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(img);
		JLabel imglabel = new JLabel(i2);
		imglabel.setBounds(300, 0, 500, 380);
		add(imglabel);
		
		getContentPane().setBackground(Color.WHITE);
		setBounds(240,150,800,400);
		setLayout(null);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
			String room = t1.getText();
			String available = (String)c1.getSelectedItem();
			String status = (String)c2.getSelectedItem();
			String price = t2.getText();
			String type = (String)c3.getSelectedItem();
			
			conn c = new conn();
			try {
				String str = "insert into room values('"+room+"','"+available+"','"+status+"','"+price+"','"+type+"');";
				c.s.executeUpdate(str);
				
				JOptionPane.showMessageDialog(null, "New Room Added");
			}catch(Exception e) {}
			
		}else if(ae.getSource() == b2) {
			this.setVisible(false);
		}
	}
	
	public static void main(String[] args) 
	{
		new AddRooms();
	}
}