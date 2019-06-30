package framework.two.nine;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.concurrent.*;
import javax.swing.*;
import code.*;
public class ManagerUI extends JFrame{
	private JLabel label,label1,label2,label3,label4,label5,label6,label7,label8,label9;
	private JTextField field1,field2,field3,field4,field5,field6,field7,field8,field9;
	private JButton button1;
	private JTabbedPane pane;
	private JPanel panel1,panel2;
	
	private JLabel label11,label12,label13,label14,label15;
	private JButton button2;
	private JTextField field11;
	ManagerUI(UserDB users,FlightDB flights,Load run){
		final Manager man=new Manager(flights,users);
		this.setIconImage(new ImageIcon("image/happy.png").getImage());
		pane=new JTabbedPane();
		panel1=new JPanel();
		panel2=new JPanel();
		button1=new JButton("ȷ��");
		label=new JLabel();
		label1=new JLabel("������");
		label2=new JLabel("����ʱ��");
		label3=new JLabel("����ʱ��");
		label4=new JLabel("��ʼ��");
		label5=new JLabel("Ŀ�ĵ�");
		label6=new JLabel("ͷ�Ȳ���λ����");
		label7=new JLabel("�������λ����");
		label8=new JLabel("ͷ�Ȳռ۸�");
		label9=new JLabel("����ռ۸�");
		field1=new JTextField();
		field2=new JTextField();
		field3=new JTextField();
		field4=new JTextField();
		field5=new JTextField();
		field6=new JTextField();
		field7=new JTextField();
		field8=new JTextField();
		field9=new JTextField();
		pane.add(panel1,"��Ӻ���");
		pane.add(panel2,"ɾ������/��ѯ����/�û�����");
		pane.setSize(1097, 748);
		this.add(pane);
		panel1.setLayout(new GridLayout(10,2));
		panel2.setLayout(new GridLayout(4,2));
		panel1.add(label1);
		panel1.add(field1);
		panel1.add(label2);
		panel1.add(field2);
		panel1.add(label3);
		panel1.add(field3);
		panel1.add(label4);
		panel1.add(field4);
		panel1.add(label5);
		panel1.add(field5);
		panel1.add(label6);
		panel1.add(field6);
		panel1.add(label7);
		panel1.add(field7);
		panel1.add(label8);
		panel1.add(field8);
		panel1.add(label9);
		panel1.add(field9);
		panel1.add(button1);
		
		button2=new JButton("ȷ��");
		label11=new JLabel("������");
		label12=new JLabel("�û�����");
		label13=new JLabel();
		label14=new JLabel("������");
		label15=new JLabel();
		field11=new JTextField();
		panel2.add(label11);
		panel2.add(field11);
		panel2.add(label12);
		panel2.add(label13);
		panel2.add(label14);
		panel2.add(label15);
		panel2.add(button2);
		class ButtonListener1 implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				try {
					man.addFlight(field1.getText(), field2.getText(), field3.getText(), field4.getText(), field5.getText(), field6.getText(), field7.getText(), field8.getText(), field9.getText());
					run.putInformation();
					run.LoadedFlightDB();
					run.LoadedUserDB();
				} catch (ParseException | IOException e1) {
					e1.printStackTrace();
				}
				new Warning("��ӳɹ���");
			}
			
		}
		class ButtonListener2 implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				try {
					if(man.removeFlight(field11.getText())) {
						new Warning("�Ƴ��ɹ���");
					}
					else {
						new Warning("�Ƴ�ʧ�ܣ�");
					}
					run.putInformation();
					run.LoadedFlightDB();
					run.LoadedUserDB();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				Integer i=man.getNumberOfuser();
				Double d=man.getIncome();
				label13.setText(i.toString());
				label15.setText(d.toString());
				
			}
			
		}
		ButtonListener1 bl1=new ButtonListener1();
		button1.addActionListener(bl1);
		ButtonListener2 bl2=new ButtonListener2();
		button2.addActionListener(bl2);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(1097,748);
		this.setLocationRelativeTo(null);
	}
}
