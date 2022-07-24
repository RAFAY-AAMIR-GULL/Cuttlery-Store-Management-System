package MainPackage;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Customer extends employee
{
	private	String name,phno,city,country,idno,psize;
	private double bill=0;private int quant=1;
	public Customer()
	{
		JFrame cs=new JFrame("Customer's Window");
		cs.setLayout(new FlowLayout());
		cs.setBackground(Color.white);
		cs.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		productinfo(cs);
		customerinfo(cs);
		
	}
	public Customer(JFrame cs)
	{
	
		customerinfo2(cs);
		
		
	}
	public void productinfo(JFrame cs)
	{
		
		JLabel l1=new JLabel("<html> <font color='red'>Detalied List of Our Products</font></html>");
		l1.setBackground(Color.white);
		TextArea plist=new TextArea(20,220);
		plist.setBackground(Color.white);
		
		cs.add(l1);
		cs.add(plist);
		cs.setVisible(true);
		try
		{
			BufferedReader b=new BufferedReader(new FileReader("FILE\\product-info-forc.csv"));
			String fdata=b.readLine();
			while(fdata!=null)
			{
				String[] data=fdata.split(",");
				//String s = String.format( "%-15s %30s %65s%65s %35s %35s %65s%60s",data[0],data[1],data[2],data[3],data[4],data[5],data[6],data[7] );
				String divider="------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"
						+ "-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------";
				String oneline=padString(data[0],10)+padString(data[1],30)+padString(data[2],55)+padString(data[3],50)+
						padString(data[4],55)+padString(data[5],55)+padString(data[6],55)+padString(data[7],50)+"\n";
				plist.append(oneline+divider+"\n");
				fdata=b.readLine();
			}
			b.close();
			plist.setEditable(false);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
}
	
	
	
	public String padString(String str, int n)
	{
	    if(str.length() < n)
	    {
	        for(int i = str.length(); i <= n; i++)
	        {
	            str +=" ";
	        }
	    } 
	    return str;
	} 
	
	
	public void customerinfo(JFrame cs)
	{
		JLabel cinfo=new JLabel("Customer's info    ");
		cinfo.setBackground(Color.white);
		JLabel l2=new JLabel("Name: ");
		JLabel l3=new JLabel("Contact Number # : ");
		JLabel spaces=new JLabel("                                                                                         ");
		TextArea ta2=new TextArea(1,20);
		TextArea ta3=new TextArea(1,13);
		ta2.setBackground(Color.white);
		ta3.setBackground(Color.white);
		JButton confirm=new JButton("Confirm");
		confirm.setBackground(Color.yellow);
		confirm.setIcon(new ImageIcon("FILE\\icons8-confirm-64.png"));
		Label l4=new Label("City ");
		Label l5=new Label("Country");
		TextArea ta4=new TextArea(1,15);
		TextArea ta5=new TextArea(1,15);
		ta4.setBackground(Color.white);
		ta5.setBackground(Color.white);
		cs.add(cinfo);
		cs.add(l2);
		cs.add(ta2);
		cs.add(l3);
		cs.add(ta3);
		cs.add(l4);
		cs.add(ta4);
		cs.add(l5);
		cs.add(ta5);
		cs.add(confirm);
		cs.add(spaces);
		cs.setVisible(true);
		
		File f=new File("FILE\\Customer-info.csv");
		ActionListener listener1=new ActionListener()
				{
			public void actionPerformed(ActionEvent e)
			{
				name=ta2.getText();
				phno=ta3.getText();
				city=ta4.getText();
				country=ta5.getText();
				String info=name+","+phno+","+city+","+country+",";
				
				try
				{
				FileOutputStream fos=new FileOutputStream(f,true);
				customercart(cs,fos,info);
				
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		};
		confirm.addActionListener(listener1);
		
	}
	
	
	
	
	public void customerinfo2(JFrame cs)
	{
		JLabel cinfo=new JLabel("                                                                                                                            Customer's info    ");
		cinfo.setBackground(Color.white);
		JLabel l2=new JLabel("Name: ");
		JLabel l3=new JLabel("Contact Number # : ");
		JLabel spaces=new JLabel("                                                                                                                                     ");
		TextArea ta2=new TextArea(1,20);
		TextArea ta3=new TextArea(1,13);
		ta2.setBackground(Color.white);
		ta3.setBackground(Color.white);
		JButton confirm=new JButton("Confirm");
		confirm.setBackground(Color.yellow);confirm.setIcon(new ImageIcon("FILE\\icons8-confirm-64.png"));
		cs.add(cinfo);
		cs.add(l2);
		cs.add(ta2);
		cs.add(l3);
		cs.add(ta3);
		cs.add(confirm);
		cs.add(spaces);
		cs.setVisible(true);
		
		File f=new File("FILE\\Customer-info.csv");
		ActionListener listener1=new ActionListener()
				{
			public void actionPerformed(ActionEvent e)
			{
				name=ta2.getText();
				phno=ta3.getText();
				String info=name+","+phno+","+"Lahore"+","+"Pakistan"+",";
				
				try
				{
				FileOutputStream fos=new FileOutputStream(f,true);	
				customercart1(cs,fos,info);
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		};
		confirm.addActionListener(listener1);
		
	}
	public void customercart(JFrame cs,FileOutputStream fos,String info)
	{
		JLabel l7=new JLabel("Product ID: ");
		JLabel l8=new JLabel("Size: ");
		TextArea ta7=new TextArea(1,10);ta7.setBackground(Color.white);
		TextArea ta8=new TextArea(1,10);ta8.setBackground(Color.white);
		JLabel l9=new JLabel("Quantity: ");
		TextArea ta9=new TextArea(1,3);ta7.setBackground(Color.white);
		TextArea cart=new TextArea(6,210);ta7.setBackground(Color.white);
		JLabel l6=new JLabel();l6.setText("                                                                                   Enter the Deatails here:                                   ");
		JButton addtocart=new JButton("Add to cart");
		addtocart.setBackground(Color.ORANGE);addtocart.setIcon(new ImageIcon("FILE\\icons8-add-shopping-cart-48.png"));
		JLabel spaces=new JLabel("                                                                                                                                         ");
		cs.add(l6);
		cs.add(l7);
		cs.add(ta7);
		cs.add(l8);
		cs.add(ta8);
		cs.add(l9);
		cs.add(ta9);
		cs.add(addtocart);
		cs.add(spaces);
		cs.setVisible(true);
		String divider="------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"
				+ "------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------";
		JButton remove=new JButton("Remove");
		remove.setBackground(Color.white);
		remove.setIcon(new ImageIcon("FILE\\icons8-remove-100.png"));
		Font font = new Font("Jokerman", Font.PLAIN, 35);Font font1 = new Font("arial", Font.PLAIN, 35);
		JLabel l11=new JLabel(name+"'s Cart",SwingConstants.CENTER);
		l11.setFont(font);
		JLabel total=new JLabel("Net Total: ");
		TextArea ta=new TextArea(2,15);
		ta.setBackground(Color.white);
		JButton ptpay=new JButton("Proceed to Pay");ptpay.setFont(font1);	ptpay.setBackground(Color.white);
		ptpay.setIcon(new ImageIcon("FILE\\icons8-click-&-collect-48.png"));
		
		
		ActionListener listener2=new ActionListener()
				{
				public void actionPerformed(ActionEvent e2)
				{
					cs.add(l11);
					cs.add(cart);
					cs.add(remove);
					cs.add(total);
					cs.add(ta);
					cs.setVisible(true);
					int quant=Integer.parseInt(ta9.getText());
					int id=Integer.parseInt(ta7.getText());
					String size=ta8.getText().toLowerCase();

					if(id<=12)
					{
						cart.append("ID: "+ta7.getText()+"		Size: "+ta8.getText()+"			Quantity: "+ta9.getText()+"		Total: "+total(quant,id,size)+"\n");
					}
					else
					{
						cart.append("ID: "+ta7.getText()+"		Size: Small + Medium + Large"+"			Quantity: "+ta9.getText()+"		Total: "+total(quant,id,size)+"\n");
					}
						CartTotalBill(id,size,quant); 
					
					String tbill=bill+"";
					ta.setText(tbill);cs.add(ptpay);
					cs.setVisible(true);
					
					ta7.setText("");ta8.setText("");ta9.setText("");
				cs.setVisible(true);
				cart.setEditable(false);
				}
				
				};
				addtocart.addActionListener(listener2);
				
				
				
				
				
				ActionListener listener3=new ActionListener()
				{
				public void actionPerformed(ActionEvent e3)
				{
					cart.setText("");
					ta.setText("");
					bill=0;
				}
				};
				remove.addActionListener(listener3);
	
				
				
				ActionListener listener4=new ActionListener()
						{
						public void actionPerformed(ActionEvent e4)
						{
							proceed(cart,fos,info,cs);
						
						}
						};
						ptpay.addActionListener(listener4);
				
	}
	public void customercart1(JFrame cs,FileOutputStream fo,String inf)
	{
		JLabel l7=new JLabel("Product ID: ");
		JLabel l8=new JLabel("Size: ");
		TextArea ta7=new TextArea(1,10);ta7.setBackground(Color.white);
		TextArea ta8=new TextArea(1,10);ta8.setBackground(Color.white);
		JLabel l9=new JLabel("Quantity: ");
		TextArea ta9=new TextArea(1,3);ta7.setBackground(Color.white);
		TextArea cart=new TextArea(20,210);cart.setBackground(Color.white);
		JLabel l6=new JLabel();l6.setText("                                                             Enter the Deatails here:     ");
		JButton addtocart=new JButton("Add to cart");
		addtocart.setBackground(Color.ORANGE);
		addtocart.setIcon(new ImageIcon("FILE\\icons8-add-shopping-cart-48.png"));
		JLabel spaces=new JLabel("                                                                                                                                                                                                  ");
		cs.add(l6);
		cs.add(l7);
		cs.add(ta7);
		cs.add(l8);
		cs.add(ta8);
		cs.add(l9);
		cs.add(ta9);
		cs.add(addtocart);
		cs.add(spaces);
		cs.setVisible(true);
		String divider="------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"
				+ "------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------";
		JButton remove=new JButton("Remove");
		remove.setBackground(Color.white);remove.setIcon(new ImageIcon("FILE\\icons8-remove-100.png"));
		Font font = new Font("Jokerman", Font.PLAIN, 35);Font font1 = new Font("arial", Font.PLAIN, 35);
		JLabel l11=new JLabel(name+"'s Cart",SwingConstants.CENTER);
		l11.setFont(font);
		JLabel total=new JLabel("Net Total: ");
		TextArea ta=new TextArea(2,15);
		ta.setBackground(Color.white);
		JButton ptpay=new JButton("Proceed to Pay");ptpay.setFont(font1);
		ptpay.setIcon(new ImageIcon("FILE\\icons8-click-&-collect-48.png"));
		String updateddata="";
		
		ActionListener listener2=new ActionListener()
				{
				public void actionPerformed(ActionEvent e2)
				{
					cs.add(l11);
					cs.add(cart);
					cs.add(remove);
					cs.add(total);
					cs.add(ta);
					cs.setVisible(true);
					int quant=Integer.parseInt(ta9.getText());
					int id=Integer.parseInt(ta7.getText());
					
					String size=ta8.getText().toLowerCase();
					if(check(id,quant)==true)
					{
					if(id<=12)
					{
						cart.append("ID:"+ta7.getText()+"          Size:"+ta8.getText()+"          Quantity:"+ta9.getText()+"          Total:"+total(quant,id,size)+"\n");
					}
					else
					{
						cart.append("ID:"+ta7.getText()+"          Size:Small + Medium + Large"+"          Quantity:"+ta9.getText()+"          Total:"+total(quant,id,size)+"\n");
					}
						CartTotalBill(id,size,quant); 
					
					String tbill=bill+"";
					ta.setText(tbill);cs.add(ptpay);
					cs.setVisible(true);
					ta7.setText("");ta8.setText("");ta9.setText("");
				cs.setVisible(true);
				}

					if(check(id,quant)==false)
					{
						JFrame jf=new JFrame("Limited Stock");
						jf.setLayout(new FlowLayout());
						jf.setSize(300,100);
						jf.add(new JLabel("Limited Stock Available. Please Reduce your quantity "));
						jf.setVisible(true);
					}
					cart.setEditable(false);
				}
				
				};
				addtocart.addActionListener(listener2);
				
			
				
				
				ActionListener listener3=new ActionListener()
				{
				public void actionPerformed(ActionEvent e3)
				{
					cart.setText("");
					ta.setText("");
					bill=0;
				}
				};
				remove.addActionListener(listener3);
	
				
				ActionListener listener4=new ActionListener()
						{
						public void actionPerformed(ActionEvent e4)
						{
							forbilling(cart,fo,inf,cs);
							}
						};
						ptpay.addActionListener(listener4);
					
				
	}
	public double CartTotalBill(int i,String s,int q)
	{

		try
		{

			BufferedReader br=new BufferedReader(new FileReader("FILE\\product-info-forc.csv"));
			String fdata=br.readLine();
			fdata=br.readLine();
			while(fdata!=null)
			{
				
				String[] data=fdata.split(",");
				String[] size=data[2].split("/");
				String[] price=data[5].split("/");
				fdata=br.readLine();
				if(i<=12)
				{
					if(i==Integer.parseInt(data[0]))
					{
					if(s.equals("small"))
					{
						bill=bill+q*Double.parseDouble(price[0]);
						break;
					}
					if(s.equals("medium"))
					{
						bill=bill+q*Double.parseDouble(price[1]);
						break;
					}
					if(s.equals("large"))
					{
						bill=bill+q*Double.parseDouble(price[2]);
						break;
					}
					}
				}
				if(i>=13)
				{
					if(i==Integer.parseInt(data[0]))
					{
				bill=bill+q*Double.parseDouble(price[0]);
				
					break;
					}
				}
				
			}
				
			br.close();
			
	
			
			
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return 0;
	}
	public double total(int q,int i,String s)
	{
		try
		{

			BufferedReader br=new BufferedReader(new FileReader("FILE\\product-info-forc.csv"));
			String fdata=br.readLine();
			fdata=br.readLine();
			while(fdata!=null)
			{
				
				String[] data=fdata.split(",");
				String[] size=data[2].split("/");
				String[] price=data[5].split("/");
	int p=0;
				fdata=br.readLine();
				if(i<=12)
				{
					if(i==Integer.parseInt(data[0]))
					{
					if(s.equals("small"))
					{
						return q*Double.parseDouble(price[0]);
					
					}
					if(s.equals("medium"))
					{
						return +q*Double.parseDouble(price[1]);
					
					}
					if(s.equals("large"))
					{
						return q*Double.parseDouble(price[2]);
					
					}
					}
				}
				if(i>=13)
				{
					if(i==Integer.parseInt(data[0]))
					{
				return q*Double.parseDouble(price[0]);
				
					}
				}
			
			}
				
			
			
	
			
			
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		
		
		
	return 0;	
	}
	
	public void proceed(TextArea ta,FileOutputStream fos,String info,JFrame cf)
	{
	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	    LocalDateTime now = LocalDateTime.now();  
	    String time=dtf.format(now);
	    info=info+bill+","+time+"\n";
		try
		{
			fos.write(info.getBytes());
		}
		catch(Exception er)
		{er.printStackTrace();}
JFrame f1=new JFrame("Bill Recipt");
		f1.setSize(700,600);
		f1.setLayout(new FlowLayout());
		JLabel l1=new JLabel("Name:       "+name+"                    "+"Contact#:       "+phno);
		f1.add(l1);
		JLabel l2=new JLabel("---------------------------------------------------------------------------------------------------------------------------------------------------------");
		f1.add(l2);
		JLabel g=new JLabel("This order has been saved.");JLabel g1=new JLabel(" You can get it shortly.");g.setFont(new Font("arial",Font.PLAIN,46));g1.setFont(new Font("arial",Font.PLAIN,46));
		f1.add(g);f1.add(g1);
		JLabel c=new JLabel("Please pay Rs: "+bill+" ");c.setFont(new Font("arial",Font.PLAIN,44));
		f1.add(c);	
		JButton b=new JButton("Back to Home Screen");
		b.setBackground(Color.cyan);Font font1 = new Font("arial", Font.PLAIN, 46);b.setFont(font1);b.setIcon(new ImageIcon("FILE\\icons8-home-page-48.png"));
JLabel t=new JLabel("Thank you very much");t.setFont(new Font("arial",Font.PLAIN,60));
	f1.add(t);
	f1.add(b);
		f1.setVisible(true);
		ActionListener lo=new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				cf.dispose();
				Customer c=new Customer();
				f1.dispose();
				
			}
		};b.addActionListener(lo);
	}
	
	
	public void forbilling(TextArea ta,FileOutputStream fos,String info,JFrame cf)
	{
		
		String cdata=ta.getText();
		String[] line=cdata.split("\n");
		
		for(int i=0;i<line.length;i++)
		{
			String filedata="";
			String[] ssdata=line[i].split("          ");
			String[] id=ssdata[0].split(":");
			String[] q=ssdata[2].split(":");
			//System.out.println(id[1]+"		"+q[1]);
			try
			{
				BufferedReader br=new BufferedReader(new FileReader("FILE\\product-info-foremployee.csv"));
				String fdata=br.readLine();filedata+=fdata+"\n";
				fdata=br.readLine();
				while(fdata!=null)
				{
					String[] data=fdata.split(",");
					int input=Integer.parseInt(q[1]);
					int availabel=Integer.parseInt(data[8]);
					if(id[1].equals(data[0]))
					{
						if(input<=availabel)
						{
							data[8]=(availabel-input)+"";
							filedata+=data[0]+","+data[1]+","+data[2]+","+data[3]+","+data[4]+","+data[5]+","+data[6]+","+data[7]+","+data[8]+"\n";
						}
					}
					else
					{
					filedata+=data[0]+","+data[1]+","+data[2]+","+data[3]+","+data[4]+","+data[5]+","+data[6]+","+data[7]+","+data[8]+"\n";
					}
					fdata=br.readLine();
				}
				br.close();
				
			
			}
		catch(Exception r)
			{
			r.printStackTrace();
			}
	
		try
		{
		FileOutputStream fs=new FileOutputStream("FILE\\\\product-info-foremployee.csv");
		fs.write(filedata.getBytes());
	//	System.out.println(filedata);
		}
catch(Exception e)
		{
	e.printStackTrace();
		}
	}
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	    LocalDateTime now = LocalDateTime.now();  
	    String time=dtf.format(now);
	    info=info+bill+","+time+"\n";
		try
		{
			fos.write(info.getBytes());
		}
		catch(Exception er)
		{er.printStackTrace();}
JFrame f1=new JFrame("Bill Recipt");
		f1.setSize(700,600);
		f1.setLayout(new FlowLayout());
		JLabel l1=new JLabel("Name:       "+name+"                    "+"Contact#:       "+phno);
		f1.add(l1);
		JLabel l2=new JLabel("---------------------------------------------------------------------------------------------------------------------------------------------------------");
		f1.add(l2);
		JLabel g=new JLabel("This order has been saved.");g.setFont(new Font("arial",Font.PLAIN,46));
		f1.add(g);
		JLabel c=new JLabel("Please Collect  Rs: "+bill+" ");c.setFont(new Font("arial",Font.PLAIN,44));
		f1.add(c);	JButton b=new JButton("Back to Home Screen");
		b.setBackground(Color.cyan);Font font1 = new Font("arial", Font.PLAIN, 46);b.setFont(font1);b.setIcon(new ImageIcon("FILE\\icons8-home-page-48.png"));
JLabel t=new JLabel("Thank you very much");t.setFont(new Font("arial",Font.PLAIN,60));
	f1.add(t);
	f1.add(b);
		f1.setVisible(true);
		ActionListener lo=new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				cf.dispose();
				JFrame cs=new JFrame("Cashier's: Window");
				cs.setLayout(new FlowLayout());
				cs.setBackground(Color.white);
				cs.setExtendedState(JFrame.MAXIMIZED_BOTH);
				JLabel l1=new JLabel("<html>!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!          <font color='red'>----- Have a great day----- </font>          !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!</html>");
				l1.setFont(new Font("Serif", Font.PLAIN, 20));
				cs.add(l1);
				Customer c=new Customer(cs);
				f1.dispose();
				
			}
		};b.addActionListener(lo);
		
	}
public Boolean check(int i,int no)
{
	try
	{
		BufferedReader br=new BufferedReader(new FileReader("FILE\\product-info-foremployee.csv"));
		String line=br.readLine();line=br.readLine();
	while(line!=null)
	{
		String[] data=line.split(",");
	if(i==(Integer.parseInt(data[0])))
	{
		int available=Integer.parseInt(data[8]);
		if(no<=available)
		{
				return true;
				}
		}
	line=br.readLine();
		}
	br.close();

}
catch(Exception ew)
{
	ew.printStackTrace();
	}
	return false;
}

}
