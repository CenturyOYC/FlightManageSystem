package framework.two.nine;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;
public class Warning extends JFrame{
	private JButton button1;
	private JLabel label1;
	private JPanel p1;
	private JPanel p2;
	Warning(String s){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		setBounds(200, 300, 500, 300);
		setLayout(new GridLayout(2, 1));
		 p1=new JPanel();
		 p2=new JPanel();
		label1=new JLabel(s);
		label1.setFont(new Font("ÀŒÃÂ", Font.PLAIN, 40));
		button1=new JButton("»∑»œ");
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();		
			}
		});
		p1.add(label1);
		p2.add(button1);
		add(p1);
		add(p2);
	}

}
