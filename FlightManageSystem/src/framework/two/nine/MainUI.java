package framework.two.nine;
import javax.swing.*;

import code.*;

import java.awt.*;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Iterator;
public class MainUI extends JFrame {
	private JRadioButton rButton1,rButton2,rButton3,rButton4,rButton5,rButton6;
	private JButton button1,button2,button3,button4;
	private ButtonGroup group;
	private JTextField field;
	private JTextArea area;
	private JPanel panel1,panel2;
	private JLabel label1;
	MainUI(UserDB users,FlightDB flights,String str,Load run){
		this.setLayout(new BorderLayout());
		label1=new JLabel();
		rButton1=new JRadioButton("航班编号");
		rButton2=new JRadioButton("价钱范围");
		rButton3=new JRadioButton("目的地");
		rButton4=new JRadioButton("出发地点");
		rButton5=new JRadioButton("出发时间");
		rButton6=new JRadioButton("到达时间");
		group=new ButtonGroup();
		group.add(rButton1);
		group.add(rButton2);
		group.add(rButton3);
		group.add(rButton4);
		group.add(rButton5);
		group.add(rButton6);
		panel1=new JPanel();
		panel2=new JPanel();
		panel1.setLayout(new GridLayout(1,7));
		panel2.setLayout(new GridLayout(7,1));
		this.add(panel1,BorderLayout.NORTH);
		panel1.add(rButton1);
		panel1.add(rButton2);
		panel1.add(rButton3);
		panel1.add(rButton4);
		panel1.add(rButton5);
		panel1.add(rButton6);
		button1=new JButton("查询");
		button2=new JButton("我的机票");
		button3=new JButton("购票");
		button4=new JButton("退票");
		field=new JTextField(30);
		panel1.add(field);
		area=new JTextArea();
		area.setFont(new Font("宋体",Font.BOLD,30));
		JScrollPane pane = new JScrollPane(area);
		panel1.add(field);
		this.add(panel2,BorderLayout.EAST);
		panel2.add(button1);
		panel2.add(button2);
		panel2.add(button3);
		panel2.add(button4);
		panel2.add(label1);
		Double total=users.getUser(str).geTotalCost();
		label1.setText(total.toString());
		area.setEditable(false);
		this.add(pane,BorderLayout.CENTER);
		this.setTitle(str);
		this.setIconImage(new ImageIcon("image/happy.png").getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		class ButtonListener1 implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if(rButton1.isSelected()) {
					area.setText(null);
					area.append(flights.getFlightByCode(field.getText()).toString()+"\n");
				}
				if(rButton2.isSelected()) {
					String[] group;
					group=field.getText().split("-");
					Iterator<Flight> it=flights.getFlightByPrice(Double.valueOf(group[0]),Double.valueOf(group[1])).iterator();
					area.setText(null);
					while(it.hasNext()) {
						area.append(it.next().toString()+"\n");
					}
				}
				if(rButton3.isSelected()) {
					Iterator<Flight> it=flights.getFlightByEndPlace(field.getText()).iterator();
					area.setText(null);
					while(it.hasNext()) {
						area.append(it.next().toString()+"\n");
					}
				}
				if(rButton4.isSelected()) {
					Iterator<Flight> it=flights.getFlightByStartPlace(field.getText()).iterator();
					area.setText(null);
					while(it.hasNext()) {
						area.append(it.next().toString()+"\n");
					}
				}
				if(rButton5.isSelected()) {
					try {
						Iterator<Flight> it=flights.getFlightByStartTime(field.getText()).iterator();
						area.setText(null);
						while(it.hasNext()) {
							area.append(it.next().toString()+"\n");
						}
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
				}
				if(rButton6.isSelected()) {
					try {
						Iterator<Flight> it=flights.getFlightByEndTime(field.getText()).iterator();
						area.setText(null);
						while(it.hasNext()) {
							area.append(it.next().toString()+"\n");
						}
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
		class ButtonListener2 implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				Iterator it=users.getUser(str).getIterator();
				area.setText(users.getUser(MainUI.this.getTitle()).displayPepaid());
//				while(it.hasNext()) {
//					area.append(it.next().toString());
//				}
			}
		}
		class ButtonListener3 implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				new BoughtTicketUI(users,flights,str,run);
			}
		}
		class ButtonListener4 implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				new CancelTicketUI(users,flights,str,run);
			}
		}
		class RadioButtonListener1 implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if(rButton1.isSelected()) {
					field.setText("航班编号");
				}
				if(rButton2.isSelected()) {
					field.setText("最低金额-最高金额");
				}
				if(rButton3.isSelected()) {
					field.setText("目的地");
				}
				if(rButton4.isSelected()) {
					field.setText("出发地");
				}
				if(rButton5.isSelected()) {
					field.setText("YYYY-MM-DD HH:MM:00");
				}
				if(rButton6.isSelected()) {
					field.setText("YYYY-MM-DD HH:MM:00");
				}
			}
			
		}
		ButtonListener1 bl1=new ButtonListener1();
		button1.addActionListener(bl1);
		ButtonListener2 bl2=new ButtonListener2();
		button2.addActionListener(bl2);
		ButtonListener3 bl3=new ButtonListener3();
		button3.addActionListener(bl3);
		ButtonListener4 bl4=new ButtonListener4();
		button4.addActionListener(bl4);
		RadioButtonListener1 rbl1=new RadioButtonListener1();
		rButton1.addActionListener(rbl1);
		rButton2.addActionListener(rbl1);
		rButton3.addActionListener(rbl1);
		rButton4.addActionListener(rbl1);
		rButton5.addActionListener(rbl1);
		rButton6.addActionListener(rbl1);
		this.pack();
		this.setSize(1097,748);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}
