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
	//����������塣
	BackgroundPanel_1 bgp;
	public JTextField t1;
	public JPasswordField t2;
	
	
	
	
	public SystemUi(){
		
		super();

	    setSize(521,316);
	    setTitle("ʳ����ʳ���ܹ滮ϵͳ");
	    
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
	    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//���õ�����ڹر��޲���
		addWindowListener(new WindowAdapter(){
			//��Ӵ����ڹر��¼��ķ���
			public void windowClosing(WindowEvent e) {
				int var=JOptionPane.showConfirmDialog(SystemUi.this, "ȷ���رոô��ڣ�");
				if(var==JOptionPane.YES_OPTION){
					System.exit(0);
				}
			}
		});
	
	
		MenuBar m = new MenuBar();
		Menu m1 = new Menu("ʳ��ҵ��˵�");
		m1.add(new MenuItem("���ϵͳ"));
		m1.add(new MenuItem("��ѯ�����"));//���ʳ��(һ�� һ��) �ۺϷ��� �Ƽ�
		m1.add(new MenuItem("�˻ص�½"));
		m.add(m1);
		//���˵������뵽����
		setMenuBar(m);
		//�������岢���밴ť
		//���Ա����ť,�������ð�ť�����¼�
		//���ý��水ť�ļ����¼�
		//��������ӵ����ڵײ�
	
		JLabel lblNewLabel_2 = new JLabel("��ӭʹ��ʳ�����ܹ滮ϵͳ");
		lblNewLabel_2.setForeground(new Color(153, 50, 204));
		lblNewLabel_2.setFont(new Font("������", Font.BOLD, 35));
		lblNewLabel_2.setBounds(102, 48, 800, 80);
		bgp.add(lblNewLabel_2);
		 
		 
	// add(ps);
		 //���ô��ڱ���
		 setTitle("ʳ����ʳ���ܹ滮ϵͳ");
		 //�Ǵ��ڿɼ�
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
			if(("���ϵͳ").equals(e.arg)){
				miximixi m = new miximixi();
				m.setVisible(true);
			}
			if(("��ѯ�����").equals(e.arg)){
				canyinfenxi c = new canyinfenxi();
				c.setVisible(true);
			}
			if(("�ҵ��˵�").equals(e.arg)){
			
			}
			if(("").equals(e.arg)){
				
			}
			if(("ɾ������ͷ���¼").equals(e.arg)){
				//new deleteErroRuZhu();
			}
			if(("������").equals(e.arg)){
				//new foodlist();
			}
			if(("�ܲ�ѯ").equals(e.arg)){
				//new queryUiFrame();
			}
			if(("����ϵͳ").equals(e.arg)){
				//bookfood a = new bookfood();
				//a.setVisible(true);
			}
			if(("�ͷ�Ԥ��ϵͳ").equals(e.arg)){
			//	advanceBook a = 	new advanceBook();
				//a.setVisible(true);
			}
			if(("�ͻ��˵�Ԥ��").equals(e.arg)){
				//billlook b = new billlook();
				//b.setVisible(true);
			}if(("�޸��ҵĸ�������").equals(e.arg)){
			//	changePassword c = new changePassword();
				//c.setVisible(true);
			}
			if(("�˻ص�½").equals(e.arg)){
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



