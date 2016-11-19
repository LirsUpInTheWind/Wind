package tan.Demo.Ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import tan.DemoUserUi.canyinfenxi;
import tan.DemoUserUi.miximixi;


public class SystemUi extends JFrame{
	Container ct;
	//创建背景面板。
	BackgroundPanel_1 bgp;
	public JTextField t1;
	public JPasswordField t2;
	
	
	
	
	public SystemUi(){
		
		super();

	    setSize(521,316);
	    setTitle("食堂饮食智能规划系统");
	    
	    Toolkit tk=Toolkit.getDefaultToolkit();
		Image image=tk.createImage("C:\\logo.jpg");
		this.setIconImage(image);
		ct=this.getContentPane();
		getContentPane().setLayout(null);
		bgp=new BackgroundPanel_1((new ImageIcon("C:\\222.jpg")).getImage());
		bgp.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionForeground"));
		bgp.setBounds(0,0,739,457);
		ct.add(bgp);
		bgp.setLayout(null);
	    
	    
	    
	    
	    this.setVisible(true);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//设置点击窗口关闭无操作
		addWindowListener(new WindowAdapter(){
			//添加处理窗口关闭事件的方法
			public void windowClosing(WindowEvent e) {
				int var=JOptionPane.showConfirmDialog(SystemUi.this, "确定关闭该窗口？");
				if(var==JOptionPane.YES_OPTION){
					System.exit(0);
				}
			}
		});
	
	
		MenuBar m = new MenuBar();
		Menu m1 = new Menu("食堂业务菜单");
		m1.add(new MenuItem("点餐系统"));
		m1.add(new MenuItem("查询与分析"));//最近食谱(一周 一月) 综合分析 推荐
		m1.add(new MenuItem("退回登陆"));
		m.add(m1);
		//将菜单栏加入到窗口
		setMenuBar(m);
		//创建画板并加入按钮
		//添加员工按钮,并且设置按钮监听事件
		//设置界面按钮的监听事件
		//讲画板添加到窗口底部
	
		JLabel lblNewLabel_2 = new JLabel("欢迎使用食堂智能规划系统");
		lblNewLabel_2.setForeground(new Color(153, 50, 204));
		lblNewLabel_2.setFont(new Font("新宋体", Font.BOLD, 35));
		lblNewLabel_2.setBounds(102, 48, 800, 80);
		bgp.add(lblNewLabel_2);
		 
		 
	// add(ps);
		 //设置窗口标题
		 setTitle("食堂饮食智能规划系统");
		 //是窗口可见
		 setVisible(true);
		 
		 
		 
		 
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
	public boolean handleEvent(Event e){
		if(e.id==Event.ACTION_EVENT){
			if(("点餐系统").equals(e.arg)){
				miximixi m = new miximixi();
				m.setVisible(true);
			}
			if(("查询与分析").equals(e.arg)){
				canyinfenxi c = new canyinfenxi();
				c.setVisible(true);
			}
			if(("我的账单").equals(e.arg)){
			
			}
			if(("").equals(e.arg)){
				
			}
			if(("删除错误客房记录").equals(e.arg)){
				//new deleteErroRuZhu();
			}
			if(("餐饮表").equals(e.arg)){
				//new foodlist();
			}
			if(("总查询").equals(e.arg)){
				//new queryUiFrame();
			}
			if(("餐饮系统").equals(e.arg)){
				//bookfood a = new bookfood();
				//a.setVisible(true);
			}
			if(("客房预订系统").equals(e.arg)){
			//	advanceBook a = 	new advanceBook();
				//a.setVisible(true);
			}
			if(("客户账单预览").equals(e.arg)){
				//billlook b = new billlook();
				//b.setVisible(true);
			}if(("修改我的个人密码").equals(e.arg)){
			//	changePassword c = new changePassword();
				//c.setVisible(true);
			}
			if(("退回登陆").equals(e.arg)){
				dispose();
				new LoginUi();
			}
		}
		return false;
	}
	public static void main(String[] args) {
	SystemUi s2 = new SystemUi();
	s2.setVisible(true);
	}
}





class BackgroundPanel_1 extends JPanel {
	private static final long serialVersionUID = -1634490154446875285L;
	Image im;
	public BackgroundPanel_1(Image im) {
		this.im=im;
		this.setOpaque(true);
	}
	//Draw the back ground.
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);
	}
}



