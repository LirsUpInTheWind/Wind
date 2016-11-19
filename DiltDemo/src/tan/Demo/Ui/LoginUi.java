 package tan.Demo.Ui;
import javax.swing.JFrame;


import javax.swing.JLabel;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.awt.Container;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JTextField;
import java.awt.Checkbox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;

import Util.JDBC_Ui;
import java.awt.Dimension;

public class LoginUi extends JFrame{
	private static final long serialVersionUID = -8141067384396141624L;
	public static void main(String[] args) {
		new LoginUi();
	}
	Container ct;
	//创建背景面板。
	BackgroundPanel bgp;
	public JTextField t1;
	public JTextField t2;
	public int yonghu;
	public static String username;
	
	public LoginUi() {
		setResizable(false);
		super.setTitle("食堂智能系统");
		Toolkit tk=Toolkit.getDefaultToolkit();
		Image image=tk.createImage("C:\\logo.jpg");
		this.setIconImage(image);
		ct=this.getContentPane();
		getContentPane().setLayout(null);
		bgp=new BackgroundPanel((new ImageIcon("C:\\shitang.jpg")).getImage());
		bgp.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionForeground"));
		bgp.setBounds(0,10,739,457);
		ct.add(bgp);
		bgp.setLayout(null);
		
		Button button = new Button("登陆");
		button.setBackground(new Color(0, 204, 255));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login();
			}
		});
		button.setBounds(321, 317, 38, 23);
		bgp.add(button);
		
		Button button_1 = new Button("重置");
		button_1.setBackground(new Color(0, 204, 255));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t1.setText(null);
				t2.setText(null);
			}
		});
		button_1.setBounds(384, 317, 38, 23);
		bgp.add(button_1);
		
		JLabel lblNewLabel = new JLabel("账 号");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setBounds(267, 213, 54, 18);
		bgp.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("密 码");
		lblNewLabel_1.setForeground(Color.YELLOW);
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(267, 257, 49, 15);
		bgp.add(lblNewLabel_1);
		//账号
		t1 = new JTextField("");
		t1.setBounds(321, 213, 145, 21);
		bgp.add(t1);
		t1.setColumns(10);
		t1.setBorder(new LineBorder(Color.green));
		t1.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyChar()==KeyEvent.VK_ENTER)   //按回车键执行相应操作; 
				{
					t2.requestFocus();
				} 
			}
		});
		//密码
		t2 = new JPasswordField();
		bgp.add(t2);
		t2.setColumns(10);
		t2.setBounds(322, 249, 144, 23);
		t2.setBorder(new LineBorder(Color.green));
		t2.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar()==KeyEvent.VK_ENTER)
				{
					
				}
			}
		});
		Checkbox checkbox = new Checkbox("");
		checkbox.setBounds(325, 284, 12, 13);
		bgp.add(checkbox);
		
		Checkbox checkbox_1 = new Checkbox("");
		checkbox_1.setBounds(400, 284, 12, 13);
		bgp.add(checkbox_1);
 
		JLabel label = new JLabel("记住密码");
		label.setForeground(Color.RED);
		label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				if(!checkbox.getState()){
					checkbox.setState(true);
				}else{
					checkbox.setState(false);
					checkbox_1.setState(false);
				}
			}
		});	
		label.setFont(new Font("宋体", Font.PLAIN, 12));
		
		label.setBounds(343, 282, 54, 15);
		bgp.add(label);
		
		JLabel label_1 = new JLabel("\u81EA\u52A8\u767B\u5F55");
		label_1.setForeground(Color.RED);
		label_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(!checkbox_1.getState()){
					checkbox.setState(true);
					checkbox_1.setState(true);
				}else{
					checkbox.setState(false);
					checkbox_1.setState(false);
				}
			}
		});
		label_1.setFont(new Font("宋体", Font.PLAIN, 12));
		label_1.setBounds(418, 282, 54, 15);
		bgp.add(label_1);
		
		/*JSeparator separator = new JSeparator();
		separator.setBounds(216, 77, 305, 2);
		bgp.add(separator);
		*/
		Button button_2 = new Button("管理员登陆");
		button_2.setForeground(Color.MAGENTA);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//点击响应事件;
				new MannagerUi();
				
				dispose();
			}
		});
		button_2.setBounds(620, 401, 93, 31);
		bgp.add(button_2);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(278, 353, 188, 15);
		bgp.add(lblNewLabel_2);
		
		Button button_3 = new Button("\u6CE8\u518C");
		button_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				zhuce z= new zhuce();
				z.setVisible(true);
			}
		});
		button_3.setBackground(new Color(0, 204, 255));
		button_3.setBounds(446, 317, 38, 23);
		bgp.add(button_3);
		
		this.setSize(745,485);
		this.setLocation(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		int windowWidth = this.getWidth();
	    int windowHeight = this.getHeight();
	    Toolkit kit = Toolkit.getDefaultToolkit();
	    Dimension screenSize = kit.getScreenSize();
	    int screenWidth = screenSize.width;
	    int screenHeight = screenSize.height;
	    this.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);
	}
	
	//注册方法
	
	
	//界面的登陆方法
	 public void login(){
		String st1 = t1.getText();
		String st2 = t2.getText();
		//匹配数字五位
		if(st1.length()==0||!st1.matches("[0-9]{1,10}")){
			JOptionPane.showMessageDialog(null, "请输入正确的账号！", "提示", JOptionPane.PLAIN_MESSAGE);
		}else if(st2.length()==0||!st2.matches("[0-9]{1,9}")){
			JOptionPane.showMessageDialog(null, "请输入正确的密码！", "提示", JOptionPane.PLAIN_MESSAGE);
		}else{
			//链接数据库
			Connection conn=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			int a = Integer.parseInt(st1);
			try {
				conn = JDBC_Ui.getConnection();
				String sql ="select * from user3 where id=?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, Integer.parseInt(st1));
				rs = ps.executeQuery();
				if(rs.next()==true){
					String password = rs.getString("password");
					String name = rs.getString("name");
					//String st3 = new String(st2);
						if(st2.equals(password)){
						//登陆ss
							username = t1.getText();
					new SystemUi();
						
					}else{
						JOptionPane.showMessageDialog(null, "输入的密码错误，请重新输入！", "提示", JOptionPane.ERROR_MESSAGE);
						t2.setText(null);
					}
				}else{
					JOptionPane.showMessageDialog(null, "账号不存在，请重新输入！", "提示", JOptionPane.ERROR_MESSAGE);
					t1.setText(null);
					t2.setText(null);
				}
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				conn.close();
				ps.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
	
class BackgroundPanel extends JPanel {
	private static final long serialVersionUID = -1634490154446875285L;
	Image im;
	public BackgroundPanel(Image im) {
		this.im=im;
		this.setOpaque(true);
	}
	//Draw the back ground.
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);
	}
}
