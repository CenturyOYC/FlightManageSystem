package framework.two.nine;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;
import code.*;
public class CancelTicketUI extends JFrame {
	private JButton button1;
	private JTextField field1;
	private JLabel label1;
	CancelTicketUI(UserDB users,FlightDB flights,String str,Load run){
		this.setLayout(new GridLayout(2,2));
		field1=new JTextField();
		label1=new JLabel("航班编号");
		label1.setFont(new Font("宋体",Font.PLAIN,16));
		label1.setForeground(Color.RED);
		button1=new JButton("确认");
		button1.setForeground(Color.RED);
		this.add(label1);
		this.add(field1);
		this.add(button1);
		this.setIconImage(new ImageIcon("image/happy.png").getImage());
		class ButtonListener1 implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				System.out.println(users.getUser(str).cancelFlight(field1.getText()));
				CancelTicketUI.this.setVisible(false);
				try {
					run.putInformation();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				new Warning("退票成功！");
				dispose();
			}
		}
		ButtonListener1 bl1=new ButtonListener1();
		button1.addActionListener(bl1);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.pack();
	}
}
