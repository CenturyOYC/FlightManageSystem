package framework.two.nine;
import javax.swing.*;

import code.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
public class RegisterUI extends JFrame{
	private JLabel label,label1,label2,label3;
	private JButton button1,button2,button3;
	private JTextField field1;
	private JPasswordField password1,password2;
	private JPanel panel1,panel2;
	RegisterUI(UserDB users,FlightDB flights,Load run){
		panel1=new JPanel();
		panel2=new JPanel();
		label=new JLabel(new ImageIcon("image/happy.png"));
		this.add(label,BorderLayout.NORTH);
		this.add(panel1,BorderLayout.CENTER);
		this.add(panel2,BorderLayout.SOUTH);
		panel1.setLayout(new GridLayout(3,3));
		label1=new JLabel("用户名");
		label2=new JLabel("密码");
		label3=new JLabel("再次输入密码");
		field1=new JTextField();
		password1 = new JPasswordField();
		password2 = new JPasswordField();
		panel1.add(label1);
		panel1.add(field1);
		panel1.add(label2);
		panel1.add(password1);
		panel1.add(label3);
		panel1.add(password2);
		button1=new JButton("注册");
		button2=new JButton("清除");
		button3=new JButton("返回");
		panel2.add(button1);
		panel2.add(button2);
		panel2.add(button3);
		this.setIconImage((new ImageIcon("image/happy.png").getImage()));
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		class ButtonListener1 implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if(password1.getText().equals(password2.getText())){
					String str;
					String str1;
					str=field1.getText();
					str1=password1.getText();
					users.addUser(new User(str,str1,flights,10000));
					try {
						run.putInformation();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					new Warning("注册成功！");
					RegisterUI.this.dispose();
					new LoginUI(users,flights,run);
				}
				else {
					new Warning("密码不一致！");
					field1.setText("wrong");
				}
			}
		}
		class ButtonListener2 implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				field1.setText(null);
				password1.setText(null);
				password2.setText(null);
			}
		}
		class ButtonListener3 implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				RegisterUI.this.dispose();
				new LoginUI(users,flights,run);
			}
		}
		ButtonListener1 bl1=new ButtonListener1();
		button1.addActionListener(bl1);
		ButtonListener2 bl2=new ButtonListener2();
		button2.addActionListener(bl2);
		ButtonListener3 bl3=new ButtonListener3();
		button3.addActionListener(bl3);
		this.setLocationRelativeTo(null);
	}
}
