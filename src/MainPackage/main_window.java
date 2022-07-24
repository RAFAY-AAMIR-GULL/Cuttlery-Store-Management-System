package MainPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class main_window extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main_window frame = new main_window();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public main_window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		setSize(800,600);
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("The Cutlery chain");
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel_1.setBackground(new Color(153, 153, 153));
		lblNewLabel_1.setBounds(286, 11, 333, 48);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Customer\r\n");
		btnNewButton.addActionListener(new ActionListener() 
		{
	public void actionPerformed(ActionEvent e) 
			{
		
		Customer c=new Customer();
		
		
		
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton.setBackground(UIManager.getColor("ToggleButton.foreground"));
		btnNewButton.setIcon(new ImageIcon("D:\\JAVA\\Cutlery-Store-Management-System\\FILE\\icons8-customer-skin-type-7-96.png"));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(10, 172, 229, 95);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CEO\r\n");
		btnNewButton_1.addActionListener(new ActionListener()
				{
				public void actionPerformed(ActionEvent er)
				{
					boss b=new boss();
				}
				});
		btnNewButton_1.setBackground(UIManager.getColor("ToggleButton.focus"));
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_1.setIcon(new ImageIcon("D:\\JAVA\\Cutlery-Store-Management-System\\FILE\\boss.png"));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBounds(249, 172, 229, 95);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cashier\r\n");
		btnNewButton_2.addActionListener(new ActionListener()
				{
				public void actionPerformed(ActionEvent ec)
				{
					cashier c=new cashier();
				}
				});
		btnNewButton_2.setBackground(UIManager.getColor("ToggleButton.foreground"));
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_2.setIcon(new ImageIcon("D:\\JAVA\\Cutlery-Store-Management-System\\FILE\\icons8-person-96.png"));
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setBounds(10, 338, 229, 95);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Manager");
		btnNewButton_3.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent ec)
		{
			manager m=new manager();
		}
		});
		btnNewButton_3.setForeground(new Color(0, 0, 0));
		btnNewButton_3.setBackground(UIManager.getColor("ToggleButton.focus"));
		btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_3.setIcon(new ImageIcon("D:\\JAVA\\Cutlery-Store-Management-System\\FILE\\icons8-manager-100.png"));
		btnNewButton_3.setBounds(249, 339, 229, 93);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\JAVA\\Cutlery-Store-Management-System\\FILE\\wallpaperflare.com_wallpaper (1).jpg"));
		lblNewLabel.setBounds(0, 0, 796, 561);
		contentPane.add(lblNewLabel);
		
		
		
	}
		
	
	
	
	
	
	}

