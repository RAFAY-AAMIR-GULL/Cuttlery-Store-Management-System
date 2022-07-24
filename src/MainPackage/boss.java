package MainPackage;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class boss 
{
	private String name;
	private String password;
	public boss()
	{

JFrame cs=new JFrame("I'm THE BOSS ");
cs.setLayout(new FlowLayout());
cs.setBackground(Color.white);
cs.setSize(500, 200);
JLabel l1=new JLabel("Name: ") ;JLabel l2=new JLabel("Password: ") ;
TextArea i=new TextArea(1,20);i.setBackground(Color.white);TextArea p=new TextArea(1,20);p.setBackground(Color.white);
cs.add(l1);cs.add(i);
cs.add(l2);cs.add(p);
JButton login=new JButton("Login");login.setBackground(Color.white);login.setFont(new Font("arial",Font.BOLD,36));login.setIcon(new ImageIcon(("FILE\\icons8-login-as-user-96.png")));
cs.add(login);
cs.setVisible(true);
ActionListener log=new ActionListener()
		{
	public void actionPerformed(ActionEvent e2)
	{

if(LOGIN(cs,i,p)==true)
{
	JFrame cs=new JFrame("BOSS");
cs.setLayout(new FlowLayout());
cs.setBackground(Color.white);
cs.setSize(600,500);
JLabel l1=new JLabel("<html>*****************************************          <font color='red'>----- Be a LEADER not a BOSS----- </font>          ****************************************</html>");
l1.setFont(new Font("Serif", Font.PLAIN, 20));
cs.add(l1);
cs.setVisible(true);



JButton gei=new JButton("Employee Info");Font font1 = new Font("arial", Font.PLAIN, 40);gei.setFont(font1);
gei.setBackground(Color.cyan);gei.setIcon(new ImageIcon(("FILE\\icons8-info-48.png")));
JButton vendor=new JButton("Vendor Info");vendor.setFont(font1);
vendor.setBackground(Color.green);vendor.setIcon(new ImageIcon(("FILE\\icons8-info-48.png")));
cs.add(vendor);
JButton product=new JButton("Products Info");product.setFont(font1);
product.setBackground(Color.magenta);product.setIcon(new ImageIcon(("FILE\\icons8-info-48.png")));
cs.add(product);
cs.add(gei);
JButton customer=new JButton("Customers Info");customer.setFont(font1);
customer.setBackground(Color.yellow);customer.setIcon(new ImageIcon(("FILE\\icons8-info-48.png")));
cs.add(customer);
JButton removeemployee=new JButton("Remove An Employee");removeemployee.setFont(font1);
removeemployee.setBackground(Color.red);removeemployee.setIcon(new ImageIcon(("FILE\\icons8-remove-100.png")));
cs.add(removeemployee);
cs.setVisible(true);



ActionListener listener1=new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
			getemployeeinfo();	
		}
		};
		gei.addActionListener(listener1);
		
		

		ActionListener listener5=new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
			vendor v=new vendor();
			v.vendorinfo();	
		}
		};
		vendor.addActionListener(listener5);
		
		


		ActionListener listener4=new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
			productinfo();
		}
		};
		product.addActionListener(listener4);
		
		


		ActionListener listener3=new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
			customersinfo();
		}
		};
		customer.addActionListener(listener3);
		


		ActionListener listener2=new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
			removeemployee();
		}
		};
		removeemployee.addActionListener(listener2);
		
}


if(LOGIN(cs,i,p)==false)
{
	JFrame cs=new JFrame("LoginFailed");
	cs.setLayout(new FlowLayout());
	cs.setBackground(Color.white);
	cs.setSize(300,200);
	JLabel l11=new JLabel("Login Failed ");l11.setFont(new Font("Serif", Font.PLAIN, 40));
	cs.add(l11);
	JLabel l2=new JLabel("Try Again ");l2.setFont(new Font("Serif", Font.PLAIN, 30));
	cs.add(l2);
	cs.setVisible(true);
}
	
	}
		};
	login.addActionListener(log);

	
	
	
		
		
	}

	public Boolean LOGIN(JFrame cs,TextArea i,TextArea p)
	{
		
							try
							{
							BufferedReader b=new BufferedReader(new FileReader("FILE\\BOSS.csv"));
							String data=b.readLine();data=b.readLine();
							while(data!=null)
							{
								String[] sdata=data.split(",");
								if((sdata[0].equals(i.getText())&&sdata[1].equals(p.getText())))
								{
									name=sdata[0];password=sdata[1];
									cs.dispose();
									return true;
								}
								data=b.readLine();
							}
							b.close();
							}
							catch(Exception e)
							{e.printStackTrace();}
							
							return false;
}

	public void getemployeeinfo()
	{
	JFrame f=new JFrame("Employee info");
	f.setLayout(new FlowLayout());
	f.setSize(1000,500);
	JLabel l=new JLabel("Employees are: ");
	f.add(l);
	TextArea a=new TextArea(20,130);
		a.setBackground(Color.white);
		f.add(a);
		f.setVisible(true);
		try
		{
		BufferedReader b=new BufferedReader(new FileReader("FILE\\employee.csv"));
		String data=b.readLine();
		while(data!=null)
		{
			String sdata[]=data.split(",");
			a.append(sdata[0]+"	     	     "+sdata[1]+" 	         "+sdata[2]+" 	         "+sdata[3]+" 	         "+sdata[4]+"  	        "+sdata[5]+"\n");
			data=b.readLine();
			
		}
		b.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		f.add(a);
		JButton n=new JButton("Close");
		n.setBackground(Color.white);n.setFont(new Font("Serif", Font.PLAIN, 40));n.setIcon(new ImageIcon(("FILE\\icons8-close-window-96.png")));
		f.add(n);
		f.setVisible(true);
		ActionListener l1=new ActionListener()
				{
					public void actionPerformed(ActionEvent e1)
					{
						f.dispose();
					}
				};
				n.addActionListener(l1);
		
		
	}
	public void productinfo()
	{
	JFrame f=new JFrame("Products Info");
	f.setLayout(new FlowLayout());
	f.setSize(1500,500);
	JLabel l=new JLabel("Products are: ");
	f.add(l);
	TextArea a=new TextArea(20,200);
		a.setBackground(Color.white);
		f.add(a);
		f.setVisible(true);
		try
		{
		BufferedReader b=new BufferedReader(new FileReader("FILE\\product-info-foremployee.csv"));
		String data=b.readLine();
		while(data!=null)
		{
			String sdata[]=data.split(",");
			a.append(sdata[0]+"	     	     "+sdata[1]+" 	         "+sdata[2]+" 	         "+sdata[3]+" 	         "+sdata[4]+"  	        "+sdata[5]+"  	        "+sdata[6]+"  	        "+sdata[7]+"  	        "+sdata[8]+"\n");
			data=b.readLine();
			
		}
		b.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		f.add(a);
		JButton n=new JButton("Close");
		n.setBackground(Color.white);n.setFont(new Font("Serif", Font.PLAIN, 40));n.setIcon(new ImageIcon(("FILE\\icons8-close-window-96.png")));
		f.add(n);
		f.setVisible(true);
		ActionListener l1=new ActionListener()
				{
					public void actionPerformed(ActionEvent e1)
					{
						f.dispose();
					}
				};
				n.addActionListener(l1);
		
		
	}

public void customersinfo()
{
	

	JFrame f=new JFrame("Customers Info");
	f.setLayout(new FlowLayout());
	f.setSize(1000,600);
	JLabel l=new JLabel("Customers are:  ");
	f.add(l);
	TextArea a=new TextArea(25,130);
		a.setBackground(Color.white);
		f.add(a);
		f.setVisible(true);
		try
		{
		BufferedReader b=new BufferedReader(new FileReader("FILE\\Customer-info.csv"));
		String data=b.readLine();
		while(data!=null)
		{
			String sdata[]=data.split(",");
			a.append(sdata[0]+"	     	     "+sdata[1]+" 	         "+sdata[2]+" 	         "+sdata[3]+" 	         "+sdata[4]+" 	         "+sdata[5]+"\n");
			data=b.readLine();
			
		}
		b.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		f.add(a);
		JButton n=new JButton("Close");
		n.setBackground(Color.white);n.setFont(new Font("Serif", Font.PLAIN, 40));n.setIcon(new ImageIcon(("FILE\\icons8-close-window-96.png")));
		f.add(n);
		f.setVisible(true);
		ActionListener l1=new ActionListener()
				{
					public void actionPerformed(ActionEvent e1)
					{
						f.dispose();
					}
				};
				n.addActionListener(l1);
}

public void removeemployee()
{
JFrame f=new JFrame("Romove an Employee");
f.setLayout(new FlowLayout());
f.setSize(310,250);
JLabel idno=new JLabel("Enter Employee ID:");
f.add(idno);
TextArea a=new TextArea(2,10);a.setBackground(Color.white);
f.add(a);
JButton re=new JButton("Remove");re.setFont(new Font("Serif", Font.PLAIN, 30));re.setBackground(Color.white);re.setIcon(new ImageIcon(("FILE\\icons8-remove-100.png")));
f.add(re);
f.setVisible(true);
Vector v2=new Vector(); 
ActionListener listener1=new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
			int j=0;
			try
			{
				
				BufferedReader b1=new BufferedReader(new FileReader("FILE\\employee.csv"));
				String data=b1.readLine(); v2.add(data+"\n");data=b1.readLine();
				while(data!=null)
				{
					String[] sdata=data.split(",");
					if(a.getText().equals(sdata[4]))
					{
						j--;	data=b1.readLine();sdata=data.split(",");
					}
					if(a.getText()!=(sdata[4]))
					{
						v2.add(sdata[0]+","+sdata[1]+","+sdata[2]+","+sdata[3]+","+sdata[4]+","+sdata[5]+"\n");	data=b1.readLine();
					j++;
					}		
				

					
				}
				
				j++;
				b1.close();
				
				}
				
				catch(Exception er)
				{
					er.printStackTrace();
				}

				try
				{
					FileOutputStream file=new FileOutputStream("FILE\\employee.csv");
					int q=0;
					String ve=(String) v2.elementAt(q);
					while(q<j)
					{
						//System.out.print((String) v2.elementAt(q));
						String[] mydata=ve.split(",");
						String newd=mydata[0]+","+mydata[1]+","+mydata[2]+","+mydata[3]+","+mydata[4]+","+mydata[5];
						file.write(newd.getBytes());
						
						q++;
						if(q<j)
						ve=(String) v2.elementAt(q);
						
						
					}
					
				
				JLabel l9=new JLabel("Employee has been Removed Successfuly:");
				f.add(l9);
				f.setVisible(true);
				file.close();
						
		}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
		}
		};
re.addActionListener(listener1);
}

}
