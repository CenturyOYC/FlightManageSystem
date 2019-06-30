package framework.two.nine;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;
import code.*;
public class BoughtTicketUI extends JFrame{
	private JButton button1;
	private JTextField field1;
	private JLabel label1,label2;
	private JRadioButton rButton1,rButton2;
	private ButtonGroup group;
	BoughtTicketUI(UserDB users,FlightDB flights,String str,Load run){
		this.setLayout(new GridLayout(3,3));
		label2 =new JLabel();
		button1=new JButton("����");
		rButton1=new JRadioButton("ͷ�Ȳ�");
		rButton2=new JRadioButton("�����");
		group=new ButtonGroup();
		group.add(rButton1);
		group.add(rButton2);
		field1=new JTextField();
		label1=new JLabel("������");
		label1.setFont(new Font("����",Font.PLAIN,16));
		label1.setForeground(Color.RED);
		this.add(label1);
		this.add(field1);
		this.add(rButton1);
		this.add(rButton2);
		this.add(button1);
		this.setIconImage(new ImageIcon("image/happy.png").getImage());
		class ButtonListener1 implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				String code;
				code=field1.getText();
				if(rButton1.isSelected()) {
					if(users.getUser(str).addFlight(code, "ͷ�Ȳ�")==0) {
						new Warning("��Ʊ�ɹ���");
					}
					else if(users.getUser(str).addFlight(code, "ͷ�Ȳ�")==1) {
						new Warning("����");
					}
					else if(users.getUser(str).addFlight(code, "ͷ�Ȳ�")==2){
						new Warning("û������");
					}
				}
				if(rButton2.isSelected()) {
					if(users.getUser(str).addFlight(code, "�����")==0) {
						new Warning("��Ʊ�ɹ�");
					}
					else if(users.getUser(str).addFlight(code, "�����")==1) {
						new Warning("����");
					}
					else if(users.getUser(str).addFlight(code, "�����")==2){
						new Warning("û������");
					}
				}
				try {
					run.putInformation();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
			
		}
		ButtonListener1 bl1=new ButtonListener1();
		button1.addActionListener(bl1);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.pack();
	}
}
