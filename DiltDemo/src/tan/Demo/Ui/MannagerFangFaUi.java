package tan.Demo.Ui;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tan.Demo.MannagerUi.CheckCai;
import tan.Demo.MannagerUi.updatecai;

import java.awt.Button;
import java.awt.Event;
import java.awt.Font;
import java.awt.Frame;
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

public class MannagerFangFaUi extends JFrame{
	public MannagerFangFaUi(){
		super();
			pack();
			
		 setSize(600,400);
	    this.setVisible(true);
	    
	    
	    
	    
	    
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//设置点击窗口关闭无操作
		
		
        MenuBar m = new MenuBar();
		Menu m1 = new Menu("员工操作菜单");
		m1.add(new MenuItem("添加菜系"));
		m1.add(new MenuItem("删除菜系"));
		m1.add(new MenuItem("修改菜系"));
		m1.add(new MenuItem("分类查询菜系"));
		m1.add(new MenuItem("退出系统"));
		m.add(m1);
		//将菜单栏加入到窗口
		setMenuBar(m);
		//创建画板并加入按钮
		
		//讲画板添加到窗口底部
	   	
		 Panel ps = new Panel();
		 ps.setFont(new Font("宋体",Font.PLAIN,30));
		 ps.add(new Label("欢迎使用员工管理系统"));
		 add(ps);
		 //设置窗口标题
		 setTitle("员工管理系统");
		 //是窗口可见
		
		//设置界面按钮的监听事件
		
	}
	
	public boolean handleEvent(Event e){
		if(e.id==Event.ACTION_EVENT){
			if(("添加菜系").equals(e.arg)){
				billlook a = new billlook();
				a.setVisible(true);
			}
			if(("分类查询菜系").equals(e.arg)){
			CheckCai c = new CheckCai();
			c.setVisible(true);
			}
			if(("修改菜系").equals(e.arg)){
				
				updatecai u= new updatecai();
				u.setVisible(true);
			}
			if(("删除菜系").equals(e.arg)){
				//new queryEmployeeUi();
			}
			if(("退出系统").equals(e.arg)){
				dispose();
				//new EmployeeUserFrame();
			}
		}
		return false;
	}
	public static void main(String[] args) {
		
		MannagerFangFaUi em = new MannagerFangFaUi();
			em.setVisible(true);
}
}