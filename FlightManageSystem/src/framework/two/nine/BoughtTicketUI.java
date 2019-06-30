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
		button1=new JButton("购买");
		rButton1=new JRadioButton("头等舱");
		rButton2=new JRadioButton("商务舱");
		group=new ButtonGroup();
		group.add(rButton1);
		group.add(rButton2);
		field1=new JTextField();
		label1=new JLabel("航班编号");
		label1.setFont(new Font("宋体",Font.PLAIN,16));
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
					if(users.getUser(str).addFlight(code, "头等舱")==0) {
						new Warning("购票成功！");
					}
					else if(users.getUser(str).addFlight(code, "头等舱")==1) {
						new Warning("余额不足");
					}
					else if(users.getUser(str).addFlight(code, "头等舱")==2){
						new Warning("没有余座");
					}
				}
				if(rButton2.isSelected()) {
					if(users.getUser(str).addFlight(code, "商务舱")==0) {
						new Warning("购票成功");
					}
					else if(users.getUser(str).addFlight(code, "商务舱")==1) {
						new Warning("余额不足");
					}
					else if(users.getUser(str).addFlight(code, "商务舱")==2){
						new Warning("没有余座");
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
