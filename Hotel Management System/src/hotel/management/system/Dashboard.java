package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{
	JMenuBar mb;
	JMenu m1, m2;
	JMenuItem i1, i2, i3, i4;
	
	Dashboard(){
		mb = new JMenuBar();
		add(mb);
		
		m1 = new JMenu("Hotel Management");
		m1.setForeground(Color.red);
		mb.add(m1);
		
		m2 = new JMenu("Admin");
		m2.setForeground(Color.blue);
		mb.add(m2);
		mb.setBounds(0, 0, 1400, 30);
		
		i1 = new JMenuItem("Reception");
		i1.addActionListener(this);
		m1.add(i1);
		
		i2 = new JMenuItem("Add Employee");
		i2.addActionListener(this);
		m2.add(i2);
		
		i3 = new JMenuItem("Add Rooms");
		i3.addActionListener(this);
		m2.add(i3);
		
		i4 = new JMenuItem("Add Drivers");
		i4.addActionListener(this);
		m2.add(i4);
		
		ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("Hotel/Management/System/icons/third.jpg"));
		JLabel j1 = new JLabel(image1);
		j1.setBounds(0, 0, 1200, 700);
		add(j1);
		
		JLabel j2 = new JLabel("THE TAJ GROUP WELCOMES YOU");
		j2.setForeground(Color.WHITE);
		j2.setFont(new Font("tahoma", Font.PLAIN, 40));
		j1.add(j2);
		j2.setBounds(310, 50, 900, 60);
		
		setLayout(null);
		setBounds(40, 0, 1200, 700);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("Reception")) {
			new Reception();
		}else if(ae.getActionCommand().equals("Add Employee")) {
			new AddEmployee();
		}else if(ae.getActionCommand().equals("Add Rooms")) {
			new AddRooms();
		}else if(ae.getActionCommand().equals("Add Drivers")) {
			new AddDriver();
		}
	}
	
	public static void main(String[] args) {
		new Dashboard();
	}
}