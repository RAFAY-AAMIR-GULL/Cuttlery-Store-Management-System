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

public class vendor
{public String name;
public String Location;
public String duration;
public String Phoneno;


public void vendorinfo()
{
	
	JFrame f=new JFrame("Vendor  info");
	f.setLayout(new FlowLayout());
	f.setSize(800,500);
	JLabel l=new JLabel("Vendors  are: ");
	f.add(l);
	TextArea a=new TextArea(20,100);
		a.setBackground(Color.white);
		f.add(a);
		f.setVisible(true);
		try
		{
		BufferedReader b=new BufferedReader(new FileReader("FILE\\vendorinfo.csv"));
		String data=b.readLine();
		while(data!=null)
		{
			String sdata[]=data.split(",");
			a.append(sdata[0]+"	     	     "+sdata[1]+"	     	     "+sdata[2]+"	     	     "+sdata[3]+"\n");
			data=b.readLine();
			
		}
		b.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		f.add(a);
		JButton n=new JButton("Colse");
		n.setBackground(Color.white);n.setFont(new Font("Serif", Font.PLAIN, 40));n.setIcon(new ImageIcon(("FILE\\icons8-close-window-48.png")));
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


public void addvendor()
{

	JFrame f=new JFrame("Add a Vendor");
	f.setLayout(new FlowLayout());
	f.setSize(500,350);
	JLabel l1=new JLabel("Name:                   ");
	f.add(l1);
	TextArea a1=new TextArea(2,50);
		a1.setBackground(Color.white);
		f.add(a1);
		JLabel l2=new JLabel("Office Location:  ");
		f.add(l2);
		TextArea a2=new TextArea(2,50);
			a2.setBackground(Color.white);
			f.add(a2);
			JLabel l3=new JLabel("Contact No:          ");
			f.add(l3);
			TextArea a3=new TextArea(2,50);
				a3.setBackground(Color.white);
				f.add(a3);
		
							JButton add=new JButton("Add");add.setBackground(Color.cyan);
							add.setFont(new Font("Serif", Font.PLAIN, 46)); add.setIcon(new ImageIcon(("FILE\\icons8-add-property-48.png")));f.add(add);
							
							
							ActionListener listener4=new ActionListener()
									{
										public void actionPerformed(ActionEvent e) 
										{
											name=a1.getText();
											Location=a2.getText();
											Phoneno=a3.getText();
											int j=0;
											Vector v2=new Vector();
											try
											{
											BufferedReader b1=new BufferedReader(new FileReader("FILE\\vendorinfo.csv"));
											String data=b1.readLine();
											while(data!=null)
											{
												String sdata[]=data.split(",");
												v2.add(sdata[0]+","+sdata[1]+","+sdata[2]+","+sdata[3]+"\n");
												j++;
												data=b1.readLine();
											}
											
											v2.add(name+","+Location+","+Phoneno+",0"+"\n");
											j++;
											
											
											}
											
											catch(Exception er)
											{
												er.printStackTrace();
											}

											try
											{
												FileOutputStream file=new FileOutputStream("FILE\\vendorinfo.csv");
												int q=0;
												String ve=(String) v2.elementAt(q);
												while(q<j)
												{
													String[] mydata=ve.split(",");
													String newd=mydata[0]+","+mydata[1]+","+mydata[2]+","+mydata[3];
													file.write(newd.getBytes());
													
													q++;
													if(q<j)
													ve=(String) v2.elementAt(q);
													
													
												}
												
												
												
											}
											catch(Exception e2)
											{
												e2.printStackTrace();
												}
											
											JLabel l9=new JLabel("Vendor Added Successfuly:   press the close Button:");
											f.add(l9);
											f.setVisible(true);
										}
									
										};
								add.addActionListener(listener4);
							
							
							
							
		
		f.setVisible(true);
		
		
		

		JButton n=new JButton("Colse");
		n.setBackground(Color.white);n.setFont(new Font("Serif", Font.PLAIN, 40));add.setIcon(new ImageIcon(("FILE\\icons8-close-window-96.png")));
		f.add(n);
		f.setVisible(true);
		ActionListener L3=new ActionListener()
				{
					public void actionPerformed(ActionEvent e1)
					{
						f.dispose();
					}
				};
				n.addActionListener(L3);
	
	}


public void removevendor()
{
JFrame f=new JFrame("Remove a Vendor");
f.setLayout(new FlowLayout());
f.setSize(400,230);
JLabel l1=new JLabel("Name:  ");
f.add(l1);
TextArea a1=new TextArea(2,35);
	a1.setBackground(Color.white);
	f.add(a1);
	
						JButton remove=new JButton("Remove");remove.setBackground(Color.cyan);
						remove.setFont(new Font("Serif", Font.PLAIN, 30));remove.setIcon(new ImageIcon(("FILE\\icons8-remove-100.png")));f.add(remove);
f.setVisible(true);
Vector v2=new Vector(); 
ActionListener listener1=new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
			int j=0;
			try
			{
				
				BufferedReader b1=new BufferedReader(new FileReader("FILE\\vendorinfo.csv"));
				String data=b1.readLine();v2.add(data+"\n");data=b1.readLine();
				while(data!=null)
				{
					String[] sdata=data.split(",");
					if(a1.getText().equals(sdata[0]))
					{
						j--;//47q-works
					}
					else
					{
						v2.add(sdata[0]+","+sdata[1]+","+sdata[2]+","+sdata[3]+"\n");
					}
					j++;
					data=b1.readLine();

				}
				
				j++;
				
				
				}
				
				catch(Exception er)
				{
					er.printStackTrace();
				}

				try
				{
					FileOutputStream file=new FileOutputStream("FILE\\vendorinfo.csv");
					int q=0;
					String ve=(String) v2.elementAt(q);
					while(q<j)
					{
						String[] mydata=ve.split(",");
						String newd=mydata[0]+","+mydata[1]+","+mydata[2]+","+mydata[3];
						file.write(newd.getBytes());
						
						q++;
						if(q<j)
						ve=(String) v2.elementAt(q);
						}
	
				JLabel l9=new JLabel("Vendor has been Removed Successfuly: ");
				f.add(l9);
				f.setVisible(true);
		}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
		}
		};
remove.addActionListener(listener1);


	
}
}
