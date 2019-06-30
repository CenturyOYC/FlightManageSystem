package framework.two.nine;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

import code.*;

public class LoginUI extends JFrame {
	private JLabel label1;
	private JButton button1, button2,button3;
	private JPanel panel1;
	private JTabbedPane tabBedPane;
	private JPanel panel2, panel3, panel4;
	private JLabel label2, label3, label4, label5;
	private JTextField field;
    
	private JPanel panel5;
	private JPasswordField password;
	private JLabel label6, label7, label8;
	private JTextField field1;
	private JPasswordField password1;
    private int a,b,c,count,count1;
    
    private Random rand=new Random();
    private JTextField field2;
    
    private JTextField field3;
    public LoginUI(UserDB users,FlightDB flights,Load run) {
        count=0;count1=0;
        label2 = new JLabel("账号", JLabel.CENTER);
        label3 = new JLabel("密码", JLabel.CENTER);
        label4 = new JLabel("", JLabel.CENTER);
        label4.setFont(new Font("宋体", Font.PLAIN, 16));// 设置字体样式
        label4.setForeground(Color.BLUE);// 设置字体颜色

        label6 = new JLabel("管理员账号", JLabel.CENTER);
        label7 = new JLabel("密码", JLabel.CENTER);
        label8 = new JLabel("", JLabel.CENTER);
        label8.setFont(new Font("宋体", Font.PLAIN, 16));// 设置字体样式
        label8.setForeground(Color.BLUE);// 设置字体颜色
        
        field = new JTextField();
        field1=new JTextField();
        password = new JPasswordField();
        password1 = new JPasswordField();
        // 北部区域
        label1 = new JLabel(new ImageIcon("image/happy.png"));

        // 南部区域
        panel1 = new JPanel();
        button1 = new JButton("登录");
        button2 = new JButton("清除");
        button3=new JButton("注册");
        // 中部区域
        tabBedPane = new JTabbedPane();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel4.setBackground(new Color(0, 0, 255));
        
        field2=new JTextField();
        field3=new JTextField();

        tabBedPane.add("普通用户", panel2);
        tabBedPane.add("管理员", panel3);
        panel2.setLayout(new GridLayout(3,3));
        panel3.setLayout(new GridLayout(3,3));
        panel1.add(button1);
        panel1.add(button2);
        panel1.add(button3);

        panel2.add(label2);
        panel2.add(field);
        panel2.add(label3);
        panel2.add(password);
        panel2.add(label4);
        panel2.add(field2);
        field2.setVisible(false);
        field3.setVisible(false);
        
        panel3.add(label6);
        panel3.add(field1);
        panel3.add(label7);
        panel3.add(password1);
        panel3.add(label8);
        panel3.add(field3);
        this.add(panel1, BorderLayout.SOUTH);
        this.add(label1, BorderLayout.NORTH);
        this.add(tabBedPane, BorderLayout.CENTER);

        ImageIcon icon = new ImageIcon("image/happy.png");
        this.setIconImage(icon.getImage());
        this.setSize(400, 380);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.pack();
        class ButtonListener1 implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if(tabBedPane.getSelectedIndex()==0) {
					String str=field.getText();
					String str1=password.getText();
					if(users.getUser(str)!=null) {
					if((users.getUser(str).getPassword()).equals(str1)&&count<=2) {
						LoginUI.this.dispose();
						new MainUI(users,flights,str,run);
					}
					else if(!(users.getUser(str).getPassword()).equals(str1)&&count<=2){
						count++;
						new Warning("密码或账户错误！");
					}
					else if(!(users.getUser(str).getPassword()).equals(str1)&&count==3){
						count++;
						new Warning("登录次数过多！");
						a=rand.nextInt(100);
						b=rand.nextInt(100);
						c=a+b;
						label4.setText(a+"+"+b+"="+"?");
						field2.setVisible(true);
					}
					else if(count>3&&field2.getText()!=null)	{
					   if(Integer.valueOf(field2.getText())==c&&
									(users.getUser(str).getPassword()).equals(str1)) {
								LoginUI.this.dispose();
								new MainUI(users,flights,str,run);
						}	
						else if(Integer.valueOf(field2.getText())!=c){
							new Warning("验证码错误！");
	                       //System.exit(0);
						}
						else if(!(users.getUser(str).getPassword()).equals(str1)) {
							new Warning("密码或账户错误!");
						}
					    a=rand.nextInt(100);
						b=rand.nextInt(100);
						c=a+b;
						label4.setText(a+"+"+b+"="+"?");
						field2.setVisible(true);
					}
				}
					else
					{
						new Warning("用户不存在！");
					}
				}
				
				if(tabBedPane.getSelectedIndex()==1) {
					String str="Manager";
					String str1="123456";
					if(field1.getText().equals(str)&&password1.getText().equals(str1)&&count1<=2) {
						LoginUI.this.dispose();
						new ManagerUI(users,flights,run);
					}
					else if(!(field1.getText().equals(str)&&password1.getText().equals(str1))&&count1<=2){
						count1++;
						new Warning("密码或账户错误！");
					}
					else if(!(field1.getText().equals(str)&&password1.getText().equals(str1))&&count1==3){
						count1++;
						new Warning("登录次数过多！");
						a=rand.nextInt(100);
						b=rand.nextInt(100);
						c=a+b;
						label8.setText(a+"+"+b+"="+"?");
						field3.setVisible(true);
					}
					else if(count1>3&&field3.getText()!=null)	{
					   if(Integer.valueOf(field3.getText())==c&&
							   (field1.getText().equals(str)&&password1.getText().equals(str1))) {
								LoginUI.this.dispose();
								new ManagerUI(users,flights,run);
						}	
						else if(Integer.valueOf(field3.getText())!=c){
							new Warning("验证码错误！");
	                       //System.exit(0);
						}
						else if(!(field1.getText().equals(str)&&password1.getText().equals(str1))) {
							new Warning("密码或账户错误!");
						}
					    a=rand.nextInt(100);
						b=rand.nextInt(100);
						c=a+b;
						label4.setText(a+"+"+b+"="+"?");
						field3.setVisible(true);
					}
				}
				
			}	
        }
        class ButtonListener2 implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if(tabBedPane.getSelectedIndex()==0) {
					field.setText(null);
					password.setText(null);
				}
				if(tabBedPane.getSelectedIndex()==1) {
					field1.setText(null);
					password1.setText(null);
				}
			}
        }
        class ButtonListener3 implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				LoginUI.this.setVisible(false);
				new RegisterUI(users,flights,run);
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