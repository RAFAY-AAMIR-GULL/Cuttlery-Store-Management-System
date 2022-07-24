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


public class manager extends employee
{

	public manager()
	{

		
		JFrame cs=new JFrame("Manager's Login: page ");
		cs.setLayout(new FlowLayout());
		cs.setBackground(Color.white);
		cs.setSize(400, 200);
		JLabel l1=new JLabel("ID: ") ;JLabel l2=new JLabel("Password: ") ;
		TextArea i=new TextArea(1,15);i.setBackground(Color.white);TextArea p=new TextArea(1,15);p.setBackground(Color.white);
		cs.add(l1);cs.add(i);
		cs.add(l2);cs.add(p);
		JButton login=new JButton("Login");login.setBackground(Color.white);login.setIcon(new ImageIcon("FILE\\icons8-login-as-user-96 (1).png"));
		cs.add(login);
		cs.setVisible(true);
		ActionListener log=new ActionListener()
				{
			public void actionPerformed(ActionEvent e2)
			{
		
		if(LOGIN(cs,i,p)==true)
		{
			JFrame cs=new JFrame("Manager's: Window");
		cs.setLayout(new FlowLayout());
		cs.setBackground(Color.white);
		cs.setSize(1200,350);
		JLabel l1=new JLabel("<html>*****************************************          <font color='red'>----- Have a nice day----- </font>          ****************************************</html>");
		l1.setFont(new Font("Serif", Font.PLAIN, 20));
		cs.add(l1);
		cs.setVisible(true);
		JButton gei=new JButton("Get Employee Info");Font font1 = new Font("arial", Font.PLAIN, 40);gei.setFont(font1);
		gei.setBackground(Color.green);gei.setIcon(new ImageIcon("FILE\\icons8-more-48.png"));
		
		JButton adde=new JButton("Add Employee");adde.setFont(font1);
		adde.setBackground(Color.MAGENTA);adde.setIcon(new ImageIcon("FILE\\icons8-add-user-group-woman-man-skin-type-7-48.png"));
		
		JButton rem=new JButton("Rmove Employee");rem.setFont(font1);
		rem.setBackground(Color.red);rem.setIcon(new ImageIcon("FILE\\icons9-trash-48.png"));
		
		JButton editemployee=new JButton("Edit Employee");editemployee.setFont(font1);
		editemployee.setBackground(Color.orange);editemployee.setIcon(new ImageIcon("FILE\\icons8-edit-property-48.png"));
		
		JButton vendor=new JButton("Vendor Info");vendor.setFont(font1);
		vendor.setBackground(Color.yellow);vendor.setIcon(new ImageIcon("FILE\\icons8-more-48.png"));
		
		JButton addvendor=new JButton("Add Vendor");addvendor.setFont(font1);
		addvendor.setBackground(Color.lightGray);addvendor.setIcon(new ImageIcon("FILE\\icons8-add-property-48.png"));
		
		JButton removevendor=new JButton("Remove Vendor");removevendor.setFont(font1);
		removevendor.setBackground(Color.cyan);removevendor.setIcon(new ImageIcon("FILE\\icons8-trash-50.png"));
	
		cs.add(vendor);cs.add(gei);
		cs.add(addvendor);cs.add(adde);
		cs.add(editemployee);
		cs.add(removevendor);cs.add(rem);	
		
		cs.setVisible(true);
		
		
		
		ActionListener listener1=new ActionListener()
				{
				public void actionPerformed(ActionEvent e)
				{
					getemployeeinfo();	
				}
				};
				gei.addActionListener(listener1);
				
				
				ActionListener listener2=new ActionListener()
				{
				public void actionPerformed(ActionEvent e)
				{
					addemployee();	
				}
				};
				adde.addActionListener(listener2);
				
				ActionListener listener3=new ActionListener()
				{
				public void actionPerformed(ActionEvent e)
				{
					removeemployee();	
				}
				};
				rem.addActionListener(listener3);
				
				ActionListener listener4=new ActionListener()
				{
				public void actionPerformed(ActionEvent e)
				{
					editemployee();	
				}
				};
				editemployee.addActionListener(listener4);

				ActionListener listener5=new ActionListener()
				{
				public void actionPerformed(ActionEvent e)
				{
					vendor v=new vendor();
					v.vendorinfo();	
				}
				};
				vendor.addActionListener(listener5);
				
				
				ActionListener listener6=new ActionListener()
				{
				public void actionPerformed(ActionEvent e)
				{
					vendor v=new vendor();
					v.addvendor();	
				}
				};
				addvendor.addActionListener(listener6);
				
				
				ActionListener listener7=new ActionListener()
				{
				public void actionPerformed(ActionEvent e)
				{
					vendor v=new vendor();
					v.removevendor();	
				}
				};
				removevendor.addActionListener(listener7);
			
				
				
				
				
		}
		
	
		if(LOGIN(cs,i,p)==false)
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
	
	public Boolean LOGIN(JFrame cs,TextArea i,TextArea p)
	{
		
							try
							{
							BufferedReader b=new BufferedReader(new FileReader("FILE\\employee.csv"));
							String data=b.readLine();data=b.readLine();
							while(data!=null)
							{
								String[] sdata=data.split(",");
								if((sdata[4].equals(i.getText()))&&sdata[5].equals(p.getText())&&sdata[3].equals("manager"))
								{
									name=sdata[0];gender=sdata[1];post="manager";id=sdata[4];password=sdata[5];
									cs.dispose();
									return true;
								}
								data=b.readLine();
							}
							}
							catch(Exception e)
							{e.printStackTrace();}
							return false;
}
	
	public void addproduct()
	{
		JFrame f=new JFrame("Add Product");
		f.setLayout(new FlowLayout());
		f.setSize(380,600);
		JLabel l1=new JLabel("Name:  ");
		f.add(l1);
		TextArea a1=new TextArea(2,35);
			a1.setBackground(Color.white);
			f.add(a1);
			JLabel l2=new JLabel("Material: ");
			f.add(l2);
			TextArea a2=new TextArea(2,35);
				a2.setBackground(Color.white);
				f.add(a2);
				JLabel l3=new JLabel("Type:  ");
				f.add(l3);
				TextArea a3=new TextArea(2,35);
					a3.setBackground(Color.white);
					f.add(a3);JLabel l4=new JLabel("Price:      ");
					f.add(l4);
					TextArea a4=new TextArea(2,35);
						a4.setBackground(Color.white);
						f.add(a4);JLabel l5=new JLabel("Weightage: ");
						f.add(l5);
						TextArea a5=new TextArea(2,35);
							a5.setBackground(Color.white);
							f.add(a5);
							JLabel l6=new JLabel("Description:");
							f.add(l6);
							TextArea a6=new TextArea(2,35);
								a6.setBackground(Color.white);
								f.add(a6);
								JLabel l7=new JLabel("Stock:");
								f.add(l7);
								TextArea a7=new TextArea(2,35);
									a7.setBackground(Color.white);
									f.add(a7);
								JButton add=new JButton("Add");add.setBackground(Color.cyan);
								add.setFont(new Font("Serif", Font.PLAIN, 30));add.setIcon(new ImageIcon("FILE\\icons8-add-property-48.png"));f.add(add);
								
								
								ActionListener listener4=new ActionListener()
										{
											public void actionPerformed(ActionEvent e) 
											{
												int j=0;
												Vector v2=new Vector();
												try
												{
												BufferedReader b1=new BufferedReader(new FileReader("FILE\\product-info-foremployee.csv"));
												String data=b1.readLine();
												while(data!=null)
												{
													String sdata[]=data.split(",");
													v2.add(sdata[0]+","+sdata[1]+","+sdata[2]+","+sdata[3]+","+sdata[4]+","+sdata[5]+","+sdata[6]+","+sdata[7]+","+sdata[8]+"\n");
													j++;
													data=b1.readLine();
												}
												v2.add(j+","+a1.getText()+","+"Standard"+","+a2.getText()+","+a3.getText()+","+a4.getText()+","+a5.getText()+","+a6.getText()+","+a7.getText()+"\n");
												
												
												
												}
												
												catch(Exception er)
												{
													er.printStackTrace();
												}

												try
												{
													FileOutputStream file=new FileOutputStream("FILE\\product-info-foremployee.csv");
													int q=0;
													String ve=(String) v2.elementAt(q);
													while(q<j)
													{
														System.out.print((String) v2.elementAt(q));
														String[] mydata=ve.split(",");
														String newd=mydata[0]+","+mydata[1]+","+mydata[2]+","+mydata[3]+","+mydata[4]+","+mydata[5]+","+mydata[6]+","+mydata[7]+","+mydata[8];
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
												
												JLabel l9=new JLabel("Product Added Successfuly:   press the close Button:");
												f.add(l9);
												f.setVisible(true);
											}
										
											};
									add.addActionListener(listener4);
								
								
								
								
			
			f.setVisible(true);
			
			
			

			JButton n=new JButton("Close");
			n.setBackground(Color.white);n.setFont(new Font("Serif", Font.PLAIN, 40));
			n.setIcon(new ImageIcon("FILE\\icons8-close-window-96.png"));f.add(n);
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
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	f.add(a);
	JButton n=new JButton("Close");
	n.setBackground(Color.white);n.setFont(new Font("Serif", Font.PLAIN, 40));
	n.setIcon(new ImageIcon("FILE\\icons8-close-window-96.png"));f.add(n);
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


public void addemployee()
{
	
	JFrame f=new JFrame("Add an Employee");
	f.setLayout(new FlowLayout());
	f.setSize(380,570);
	JLabel l1=new JLabel("Name:  ");
	f.add(l1);
	TextArea a1=new TextArea(2,35);
		a1.setBackground(Color.white);
		f.add(a1);
		JLabel l2=new JLabel("Gender: ");
		f.add(l2);
		TextArea a2=new TextArea(2,35);
			a2.setBackground(Color.white);
			f.add(a2);JLabel l3=new JLabel("Salary:  ");
			f.add(l3);
			TextArea a3=new TextArea(2,35);
				a3.setBackground(Color.white);
				f.add(a3);JLabel l4=new JLabel("Post:      ");
				f.add(l4);
				TextArea a4=new TextArea(2,35);
					a4.setBackground(Color.white);
					f.add(a4);JLabel l5=new JLabel("ID:          ");
					f.add(l5);
					TextArea a5=new TextArea(2,35);
						a5.setBackground(Color.white);
						f.add(a5);
						JLabel l6=new JLabel("Password:");
						f.add(l6);
						TextArea a6=new TextArea(2,35);
							a6.setBackground(Color.white);
							f.add(a6);
							JButton add=new JButton("Add");add.setBackground(Color.cyan);
							add.setFont(new Font("Serif", Font.PLAIN, 30));add.setIcon(new ImageIcon("FILE\\icons8-add-user-group-woman-man-skin-type-7-48.png"));f.add(add);
							
							
							ActionListener listener4=new ActionListener()
									{
										public void actionPerformed(ActionEvent e) 
										{
											name=a1.getText();
											gender=a2.getText();
											salary=a3.getText();
											post=a4.getText();
											id=a5.getText();
											password=a6.getText();int j=0;
											Vector v2=new Vector();
											try
											{
											BufferedReader b1=new BufferedReader(new FileReader("FILE\\employee.csv"));
											String data=b1.readLine();
											while(data!=null)
											{
												String sdata[]=data.split(",");
												v2.add(sdata[0]+","+sdata[1]+","+sdata[2]+","+sdata[3]+","+sdata[4]+","+sdata[5]+"\n");
												j++;
												data=b1.readLine();
											}
											
											v2.add(name+","+gender+","+salary+","+post+","+id+","+password+"\n");
											j++;
											
											
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
												
												
												
											}
											catch(Exception e2)
											{
												e2.printStackTrace();
												}
											
											JLabel l9=new JLabel("Employee Added Successfuly:   press the close Button:");
											f.add(l9);
											f.setVisible(true);
										}
									
										};
								add.addActionListener(listener4);
							
							
							
							
		
		f.setVisible(true);
		
		
		

		JButton n=new JButton("Close");
		n.setBackground(Color.white);n.setFont(new Font("Serif", Font.PLAIN, 40));
		n.setIcon(new ImageIcon("FILE\\icons8-close-window-96.png"));f.add(n);
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


public void removeemployee()
	{
	JFrame f=new JFrame("Romove an Employee");
	f.setLayout(new FlowLayout());
	f.setSize(340,230);
	JLabel idno=new JLabel("Enter Employee ID:");
	f.add(idno);
	TextArea a=new TextArea(2,10);a.setBackground(Color.white);
	f.add(a);
	JButton re=new JButton("Remove");re.setFont(new Font("Serif", Font.PLAIN, 30));re.setBackground(Color.white);
	re.setIcon(new ImageIcon("FILE\\icons8-remove-100.png"));f.add(re);
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
					String data=b1.readLine();v2.add(data+"\n");data=b1.readLine();
					while(data!=null)
					{
						String[] sdata=data.split(",");
						if(a.getText().equals(sdata[4]))
						{
							j--;	
							data=b1.readLine();
							if(data==null)
							{
								j++;
								break;
							}
							sdata=data.split(",");
							
						}
						else
						{
							v2.add(sdata[0]+","+sdata[1]+","+sdata[2]+","+sdata[3]+","+sdata[4]+","+sdata[5]+"\n");
							data=b1.readLine();
						}
							
							j++;
				}
					j++;
					
					
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
			}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
			};
	re.addActionListener(listener1);
	
	
	}

public void editemployee()
{
	JFrame f=new JFrame("Edit an Employee");
	f.setLayout(new FlowLayout());
	f.setSize(360,500);
	JLabel l1=new JLabel("Name:  ");
	f.add(l1);
	TextArea a1=new TextArea(2,35);
		a1.setBackground(Color.white);
		f.add(a1);
		JLabel l2=new JLabel("Gender: ");
		f.add(l2);
		TextArea a2=new TextArea(2,35);
			a2.setBackground(Color.white);
			f.add(a2);JLabel l3=new JLabel("Salary:  ");
			f.add(l3);
			TextArea a3=new TextArea(2,35);
				a3.setBackground(Color.white);
				f.add(a3);JLabel l4=new JLabel("Post:      ");
				f.add(l4);
				TextArea a4=new TextArea(2,35);
					a4.setBackground(Color.white);
					f.add(a4);JLabel l5=new JLabel("ID:          ");
					f.add(l5);
					TextArea a5=new TextArea(2,35);
						a5.setBackground(Color.white);
						f.add(a5);
						JLabel l6=new JLabel("Password:");
						f.add(l6);
						TextArea a6=new TextArea(2,35);
							a6.setBackground(Color.white);
							f.add(a6);
							JButton edit=new JButton("Edit");edit.setBackground(Color.cyan);
							edit.setFont(new Font("Serif", Font.PLAIN, 30));	edit.setIcon(new ImageIcon("FILE\\icons8-edit-property-48.png"));
							f.add(edit);
							
							
							ActionListener listener4=new ActionListener()
									{
										public void actionPerformed(ActionEvent e) 
										{
											name=a1.getText();
											gender=a2.getText();
											salary=a3.getText();
											post=a4.getText();
											id=a5.getText();
											password=a6.getText();int j=0;
											Vector v2=new Vector();
											try
											{
											BufferedReader b1=new BufferedReader(new FileReader("FILE\\employee.csv"));
											String data=b1.readLine();
											while(data!=null)
											{
												String sdata[]=data.split(",");
												if(id.equals(sdata[4]))
												{
													v2.add(name+","+gender+","+salary+","+post+","+id+","+password+"\n");j++;
													data=b1.readLine();
													if(data==null)
													{
														break;
													}
													sdata=data.split(",");
												}
												else
												{
												v2.add(sdata[0]+","+sdata[1]+","+sdata[2]+","+sdata[3]+","+sdata[4]+","+sdata[5]+"\n");
												}
												j++;
												data=b1.readLine();
											}
											
											//v2.add(name+","+gender+","+salary+","+post+","+id+","+password+"\n")
											
											
											}
											
											catch(Exception er)
											{
												er.printStackTrace();
											}

											try
											{
												FileOutputStream file=new FileOutputStream("FILE\\\\employee.csv");
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
												
												
												
											}
											catch(Exception e2)
											{
												e2.printStackTrace();
												}
											
											JLabel l9=new JLabel("Employee Edited Successfuly:   press the close Button:");
											f.add(l9);
											f.setVisible(true);
										}
									
										};
								edit.addActionListener(listener4);
							
							
							
							
		
		f.setVisible(true);
		
		
		

		JButton n=new JButton("Colse");
		n.setBackground(Color.white);n.setFont(new Font("Serif", Font.PLAIN, 40));n.setIcon(new ImageIcon("FILE\\icons8-close-window-48.png"));
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
}
