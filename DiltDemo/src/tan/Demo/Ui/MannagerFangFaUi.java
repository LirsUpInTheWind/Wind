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
	    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//���õ�����ڹر��޲���
		
		
        MenuBar m = new MenuBar();
		Menu m1 = new Menu("Ա�������˵�");
		m1.add(new MenuItem("��Ӳ�ϵ"));
		m1.add(new MenuItem("ɾ����ϵ"));
		m1.add(new MenuItem("�޸Ĳ�ϵ"));
		m1.add(new MenuItem("�����ѯ��ϵ"));
		m1.add(new MenuItem("�˳�ϵͳ"));
		m.add(m1);
		//���˵������뵽����
		setMenuBar(m);
		//�������岢���밴ť
		
		//��������ӵ����ڵײ�
	   	
		 Panel ps = new Panel();
		 ps.setFont(new Font("����",Font.PLAIN,30));
		 ps.add(new Label("��ӭʹ��Ա������ϵͳ"));
		 add(ps);
		 //���ô��ڱ���
		 setTitle("Ա������ϵͳ");
		 //�Ǵ��ڿɼ�
		
		//���ý��水ť�ļ����¼�
		
	}
	
	public boolean handleEvent(Event e){
		if(e.id==Event.ACTION_EVENT){
			if(("��Ӳ�ϵ").equals(e.arg)){
				billlook a = new billlook();
				a.setVisible(true);
			}
			if(("�����ѯ��ϵ").equals(e.arg)){
			CheckCai c = new CheckCai();
			c.setVisible(true);
			}
			if(("�޸Ĳ�ϵ").equals(e.arg)){
				
				updatecai u= new updatecai();
				u.setVisible(true);
			}
			if(("ɾ����ϵ").equals(e.arg)){
				//new queryEmployeeUi();
			}
			if(("�˳�ϵͳ").equals(e.arg)){
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