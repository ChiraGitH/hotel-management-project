package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener{
	JTextField t1, t2, t3, t4, t5, t6;
	JRadioButton r1, r2;
	JComboBox c1;
	JButton b1;
	
	AddEmployee(){
		JLabel name = new JLabel("Name");
		name.setBounds(60,30, 120, 30);
		name.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(name);
		
		t1 = new JTextField(); 
		t1.setBounds(200,30,150,30);
		add(t1);
		
		JLabel age = new JLabel("Age");
		age.setBounds(60,80, 120, 30);
		age.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(age);
		
		t2 = new JTextField(); 
		t2.setBounds(200,80,150,30);
		add(t2);
		
		JLabel gender = new JLabel("Gender");
		gender.setBounds(60,130, 120, 30);
		gender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(gender);
		
		r1 = new JRadioButton("Male");
		r1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		r1.setBounds(200, 130, 70, 30);
		r1.setBackground(Color.LIGHT_GRAY);
		add(r1);
		r2 = new JRadioButton("Female");
		r2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		r2.setBounds(270, 130, 90, 30);
		r2.setBackground(Color.LIGHT_GRAY);
		add(r2);
		
		
		JLabel job = new JLabel("Job");
		job.setBounds(60,180, 120, 30);
		job.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(job);
		
		String options[] = {"Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Staff", "Room Services", "Waiter/Waitresses", "Manager", "Accountant", "Chef"};
		c1 = new JComboBox(options);
		c1.setBounds(200, 180, 150, 30);
		add(c1);
 		
		JLabel salary = new JLabel("Salary");
		salary.setBounds(60,230, 120, 30);
		salary.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(salary);
		
		t3 = new JTextField(); 
		t3.setBounds(200,230,150,30);
		add(t3);
		
		JLabel phone = new JLabel("Phone");
		phone.setBounds(60,280, 120, 30);
		phone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(phone);
		
		t4 = new JTextField(); 
		t4.setBounds(200,280,150,30);
		add(t4);
		
		JLabel aadhar = new JLabel("Aadhar");
		aadhar.setBounds(60,330, 120, 30);
		aadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(aadhar);
		
		t5 = new JTextField(); 
		t5.setBounds(200,330,150,30);
		add(t5);
		
		JLabel email = new JLabel("Email");
		email.setBounds(60,380, 120, 30);
		email.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(email);
		
		t6 = new JTextField(); 
		t6.setBounds(200,380,150,30);
		add(t6);
		
		b1 = new JButton("Submit");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(130, 440, 100, 30);
		b1.addActionListener(this);
		add(b1);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tenth.jpg"));
		Image img = i1.getImage().getScaledInstance(500, 530, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(img);
		JLabel l1 = new JLabel(i2);
		l1.setBounds(380, 0, 500, 530);
		add(l1);
		
		JLabel l2 = new JLabel("Add EMPLOYEE DETAILS");
		l2.setForeground(Color.blue);
		l2.setBounds(160, 20,400,30);
		l2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		l1.add(l2);
		
		getContentPane().setBackground(Color.LIGHT_GRAY);
		
		setLayout(null);
		setBounds(200,130,900,530);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		String name = t1.getText();
		String age = t2.getText();
		String salary = t3.getText();
		String phone = t4.getText();
		String aadhar = t5.getText();
		String email = t6.getText();
		String gender = null;
	
		if(r1.isSelected()) {
			gender = "Male";
		}
		else if(r2.isSelected()) {
			gender = "Female"; 
		}
		
		String job = (String)c1.getSelectedItem();
		
		conn c = new conn();
		String str = "INSERT INTO employee VALUES('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+aadhar+"','"+email+"');";
		
		try {
			c.s.executeUpdate(str);
			JOptionPane.showMessageDialog(null, "New Employee Added");
			this.setVisible(false);
		}catch(Exception e) {
			e.getMessage();
		}
	}
	
	
	public static void main(String[] args) {
		new AddEmployee();
	}
}