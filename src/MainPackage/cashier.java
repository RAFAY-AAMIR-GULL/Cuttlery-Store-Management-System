package MainPackage;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class cashier extends employee
{

public cashier()
{
	
	JFrame cs=new JFrame("Cashier's Login: page ");
	cs.setLayout(new FlowLayout());
	cs.setBackground(Color.white);
	cs.setSize(400, 200);
	JLabel l1=new JLabel("ID: ") ;JLabel l2=new JLabel("Password: ") ;
	TextArea i=new TextArea(1,15);i.setBackground(Color.white);TextArea p=new TextArea(1,15);p.setBackground(Color.white);
	cs.add(l1);cs.add(i);
	cs.add(l2);cs.add(p);
	JButton login=new JButton("Login ");login.setBackground(Color.white);login.setFont(new Font("arial",Font.BOLD,36));
	
	login.setIcon(new ImageIcon("FILE\\icons8-login-as-user-96 (1).png"));
	cs.add(login);
	cs.setVisible(true);
	ActionListener log=new ActionListener()
			{
		public void actionPerformed(ActionEvent e2)
		{
				if(login(cs,i,p)==true)
			{JFrame cs=new JFrame("Cashier's: Window");
								cs.setLayout(new FlowLayout());
								cs.setBackground(Color.white);
								cs.setExtendedState(JFrame.MAXIMIZED_BOTH);
								JLabel l1=new JLabel("<html>!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!          <font color='red'>----- Have a great day----- </font>          !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!</html>");
								l1.setFont(new Font("Serif", Font.PLAIN, 20));
								cs.add(l1);
								
								Customer c=new Customer(cs);
								
								
								cs.setVisible(true);
							}
				if(login(cs,i,p)==false)
				{
					JFrame cs=new JFrame("LoginFailed");
					cs.setLayout(new FlowLayout());
					cs.setBackground(Color.white);
					cs.setSize(300,200);
					JLabel l1=new JLabel("Login Failed ");l1.setFont(new Font("Serif", Font.PLAIN, 40));
					cs.add(l1);
					JLabel l2=new JLabel("Try Again ");l2.setFont(new Font("Serif", Font.PLAIN, 30));
					cs.add(l2);
					cs.setVisible(true);
						}
		}
			};
	login.addActionListener(log);
	
	
}
public boolean login(JFrame cs,TextArea i,TextArea p)
{
	try
	{
	BufferedReader b=new BufferedReader(new FileReader("FILE\\employee.csv"));
	String data=b.readLine();data=b.readLine();
	while(data!=null)
	{
		String[] sdata=data.split(",");
		if((sdata[4].equals(i.getText()))&&sdata[5].equals(p.getText())&&sdata[3].equals("cashier"))
		{
			name=sdata[0];gender=sdata[1];post="cashier";id=sdata[4];password=sdata[5];
			cs.dispose();
			return true;
		}
		data=b.readLine();
	}
	}
	 catch(Exception e)
	{
		 e.printStackTrace();
	}
return false;
}


}
