package tan.Demo.Ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import Util.JDBC_Ui;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MannagerUi extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8934117190976715841L;
	/**
	 * Launch the application.
	 */
	public  JTextField t1;
	public JTextField t2;
	public static void main(String[] args) {
		new MannagerUi();
	}

	/**
	 * Create the application.
	 */
	Container ct;
	BackgroundPanel bgp;
	public MannagerUi() {
		setTitle("\u540E\u53F0\u7BA1\u7406");
		setResizable(false);
		Toolkit tk=Toolkit.getDefaultToolkit();
		Image image=tk.createImage("C:\\logo.jpg");
		this.setIconImage(image);
		ct=this.getContentPane();
		getContentPane().setLayout(null);
		bgp=new BackgroundPanel((new ImageIcon("C:\\222.jpg")).getImage());
		bgp.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		bgp.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionForeground"));
		bgp.setBounds(0,0,600,400);//477,328
		ct.add(bgp);
		bgp.setLayout(null);
		
		t1 = new JTextField();
		t1.addMouseListener(new MouseAdapter() {
			
		});
		t1.setBounds(168, 120, 183, 21);
		bgp.add(t1);
		t1.setColumns(10);
		t1.setBorder(new LineBorder(Color.green));
		t1.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyChar()==KeyEvent.VK_ENTER)
				{
					t2.requestFocus();
				} 
			}
		});
		
		t2 = new JPasswordField();
		t2.setBounds(168, 151, 183, 21);
		bgp.add(t2);
		t2.setBorder(new LineBorder(Color.green));
		t2.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar()==KeyEvent.VK_ENTER)
				{
					login();
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("\u8D26 \u53F7");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 13));
		lblNewLabel.setBounds(122, 121, 58, 18);
		bgp.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6 \u7801");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 13));
		lblNewLabel_1.setBounds(122, 152, 58, 18);
		bgp.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("\u767B\u9646");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login();
			}
		});
		btnNewButton.setBackground(new Color(0, 191, 255));
		btnNewButton.setBounds(126, 211, 60, 23);
		bgp.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t1.setText(null);
				t2.setText(null);
			}
		});
		btnNewButton_1.setBackground(new Color(0, 191, 255));
		btnNewButton_1.setBounds(209, 211, 60, 23);
		bgp.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u7528\u6237\u767B\u9646");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginUi();
			}
		});
		btnNewButton_2.setBackground(new Color(0, 191, 255));
		btnNewButton_2.setBounds(291, 211, 90, 23);
		bgp.add(btnNewButton_2);
		
		Checkbox checkbox = new Checkbox();
		checkbox.setBounds(178, 180, 12, 13);
		bgp.add(checkbox);
		
		Checkbox checkbox_1 = new Checkbox();
		checkbox_1.setBounds(269, 180, 12, 13);
		bgp.add(checkbox_1);
		
		JLabel label = new JLabel("\u8BB0\u4F4F\u5BC6\u7801");
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
		label.setBounds(196, 180, 54, 15);
		bgp.add(label);
		
		JLabel label_1 = new JLabel("\u81EA\u52A8\u767B\u5F55");
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
		label_1.setBounds(293, 180, 54, 15);
		bgp.add(label_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u7BA1\u7406\u5458\u767B\u9646");
		lblNewLabel_2.setForeground(new Color(153, 50, 204));
		lblNewLabel_2.setFont(new Font("新宋体", Font.BOLD, 15));
		lblNewLabel_2.setBounds(207, 28, 89, 36);
		bgp.add(lblNewLabel_2);
		
		this.setSize(483,356);
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
	
	
	//验证登陆方法
	
	
	public void login(){
		String st1 = t1.getText();
		String st2 = t2.getText();
		if(st1.length()==0||!st1.matches("[0-9]{1,5}")){
			JOptionPane.showMessageDialog(null, "请输入正确的账号！", "提示", JOptionPane.PLAIN_MESSAGE);
		}else if(st2.length()==0||!st2.matches("[0-9]{1,9}")){
			JOptionPane.showMessageDialog(null, "请输入正确的密码！", "提示", JOptionPane.PLAIN_MESSAGE);
		}else{
			//链接数据库
			Connection conn=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			try {
				conn = JDBC_Ui.getConnection();
				String sql="select password from DemoMannager where userNumber=?";
				 ps = conn.prepareStatement(sql);
				ps.setString(1, st1);
				rs = ps.executeQuery();
				if(rs.next()==true){
					String password = rs.getString("password");
					if(st2.equals(password)){
						new MannagerFangFaUi();
						//登陆
					//	new employeeCURDUi();
						dispose();
					}else{
						JOptionPane.showMessageDialog(null, "密码错误，请重新输入！", "提示", JOptionPane.ERROR_MESSAGE);
					}
				}else{
					JOptionPane.showMessageDialog(null, "账号不存在，请重新输入！", "提示", JOptionPane.ERROR_MESSAGE);
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
class BackgroundP extends JPanel {
	private static final long serialVersionUID = 1L;
	Image im;
	public BackgroundP(Image im) {
		this.im=im;
		this.setOpaque(true);
	}
	//Draw the back ground.
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);
	}
}


