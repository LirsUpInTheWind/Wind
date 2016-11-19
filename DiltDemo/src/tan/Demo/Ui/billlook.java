package tan.Demo.Ui;

import java.awt.EventQueue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import Util.JDBC_Ui;
import tan.DemoUserUi.tuijian;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
public class billlook extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String st1;
	public Object[][] rowData;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;//����
	private JTextField textField_1;//�Ա�
	private JTextField textField_2;//ID
	private JTextField textField_3;//��ϵ��ʽ
	private JTextField textField_4;//��סʱ��
	private JTextField textField_5;//��ס������ֵ��
	private float charge;
	private int tianl;
	private JLabel lblNewLabel_19;//���������
	private JLabel label;//���
	private JLabel label_1;//���
	private JLabel label_2;//���
	private JLabel label_3;//����ę́
	private JLabel label_4;//�л���
	private JLabel label_5;//��ȫ��
	private JLabel lblNewLabel_24;//����
	private JLabel lblNewLabel_20;
	private JTextField textField_6;
	private JButton button;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					billlook frame = new billlook();
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
	public billlook() {
		super();
		
	    setSize(521,316);
	    setTitle("���ϵͳ");
	    
	    this.setVisible(true);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);;//���õ�����ڹر��޲���
		
		
	
		setBounds(100, 100, 866, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//���췽���и�������ʼֵ
		String columnNames[] = {"ʳƷ���","ʳƷ����","����/����/��","��֬/����/��","������/����/��","ά����/����/��","�޻���/����/��"};
		Connection conn=null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		try {
	 		conn =JDBC_Ui.getConnection();
			String sql ="select * from cai";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			int count =0;
			while(rs.next()){
				count++;
			}
			rs = ps.executeQuery();
			rowData=new Object[count][7]; //�������
			count=0;
			while(rs.next()){
				rowData[count][0]=rs.getInt("id");
				rowData[count][1]=rs.getString("cainame"); //
				rowData[count][2]=rs.getString("suger");
				rowData[count][3]=rs.getString("oil");
				rowData[count][4]=rs.getString("danbaizhi");
				rowData[count][5]=rs.getString("weishengsu");
				rowData[count][6]=rs.getString("wujiyan");
				
				count++;  
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			conn.close();
			ps.close();
			rs.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 JScrollPane scrollPane = new JScrollPane();
		 scrollPane.setBounds(10, 10, 830, 169);
		 getContentPane().add(scrollPane);
		/*JScrollPane scrollPane = new JScrollPane();
		 scrollPane.setBounds(0, 0, 588, 158);
		 contentPane.add(scrollPane);*/
		 JTable table_1=new JTable(rowData,columnNames);
		 scrollPane.setViewportView(table_1);
		 
		 
		/* table = new JTable(rowData,columnNames);
		 scrollPane.setColumnHeaderView(table);
		 scrollPane.setViewportView(table);*/
		
		
		
		 
		 JLabel lblNewLabel = new JLabel("\u83DC\u54C1\u7F16\u53F7");
		 lblNewLabel.setFont(new Font("����", Font.PLAIN, 14));
		 lblNewLabel.setBounds(10, 197, 105, 15);
		 contentPane.add(lblNewLabel);
		 
		 JButton btnNewButton = new JButton("\u67E5\u8BE2");
		 btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		check();
			}
		});
		 btnNewButton.setFont(new Font("����", Font.PLAIN, 14));
		 btnNewButton.setBounds(206, 237, 93, 23);
		 contentPane.add(btnNewButton);
		 
		 JLabel lblNewLabel_1 = new JLabel("\u83DC\u54C1\u540D:");
		 lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 14));
		 lblNewLabel_1.setBounds(10, 241, 70, 15);
		 contentPane.add(lblNewLabel_1);
		 //��Ʒ��
		 textField = new JTextField();
		 textField.setBounds(94, 238, 81, 21);
		 contentPane.add(textField);
		 textField.setColumns(10);
		 
		 JLabel lblNewLabel_2 = new JLabel("\u7CD6\u7C7B:");
		 lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 14));
		 lblNewLabel_2.setBounds(10, 289, 54, 15);
		 contentPane.add(lblNewLabel_2);
		 //����
		 textField_1 = new JTextField();
		 textField_1.setBounds(94, 286, 81, 21);
		 contentPane.add(textField_1);
		 textField_1.setColumns(10);
		 
		 JLabel lblNewLabel_3 = new JLabel("\u6CB9\u8102:");
		 lblNewLabel_3.setFont(new Font("����", Font.PLAIN, 14));
		 lblNewLabel_3.setBounds(10, 330, 55, 15);
		 contentPane.add(lblNewLabel_3);
		 //��֬
		 textField_2 = new JTextField();
		 textField_2.setBounds(94, 327, 81, 21);
		 contentPane.add(textField_2);
		 textField_2.setColumns(10);
		 
		 JLabel lblNewLabel_4 = new JLabel("\u86CB\u767D\u8D28:");
		 lblNewLabel_4.setFont(new Font("����", Font.PLAIN, 14));
		 lblNewLabel_4.setBounds(10, 370, 70, 15);
		 contentPane.add(lblNewLabel_4);
		 //������
		 textField_3 = new JTextField();
		 textField_3.setBounds(94, 367, 105, 21);
		 contentPane.add(textField_3);
		 textField_3.setColumns(10);
		 
		 JLabel lblNewLabel_5 = new JLabel("\u7EF4\u751F\u7D20:");
		 lblNewLabel_5.setFont(new Font("����", Font.PLAIN, 14));
		 lblNewLabel_5.setBounds(10, 414, 70, 15);
		 contentPane.add(lblNewLabel_5);
		 //ά����
		 textField_4 = new JTextField();
		 textField_4.setBounds(94, 411, 105, 21);
		 contentPane.add(textField_4);
		 textField_4.setColumns(10);
		 //����������ǩ
		 JLabel lblNewLabel_6 = new JLabel("\u65E0\u673A\u76D0:");
		 lblNewLabel_6.setFont(new Font("����", Font.PLAIN, 14));
		 lblNewLabel_6.setBounds(201, 289, 70, 15);
		 contentPane.add(lblNewLabel_6);
		 //�޻���
		 textField_5 = new JTextField();
		 textField_5.setBounds(281, 286, 54, 21);
		 contentPane.add(textField_5);
		 textField_5.setColumns(10);
		 
		 JLabel lblNewLabel_7 = new JLabel("\u8425\u517B\u5143\u7D20\u5355\u4F4D:\u6BEB\u514B/\u4EFD");
		 lblNewLabel_7.setFont(new Font("����", Font.PLAIN, 14));
		 lblNewLabel_7.setBounds(346, 189, 203, 30);
		 contentPane.add(lblNewLabel_7);
		 
		 JButton btnNewButton_1 = new JButton("\u6DFB\u52A0");
		 btnNewButton_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		insert();
		 	
		 	}
		 });
		 btnNewButton_1.setFont(new Font("����", Font.PLAIN, 14));
		 btnNewButton_1.setBounds(419, 264, 93, 23);
		 contentPane.add(btnNewButton_1);
		 
		 JButton btnNewButton_2 = new JButton("�˳�");
		 btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		 btnNewButton_2.setFont(new Font("����", Font.PLAIN, 14));
		 btnNewButton_2.setBounds(419, 326, 93, 23);
		 contentPane.add(btnNewButton_2);
		 
		 JButton btnNewButton_3 = new JButton("���");
		 btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
			}
		});
		 btnNewButton_3.setFont(new Font("����", Font.PLAIN, 14));
		 btnNewButton_3.setBounds(419, 391, 93, 23);
		 contentPane.add(btnNewButton_3);
		 //������ѷ���:
		  lblNewLabel_19 = new JLabel("");
		 lblNewLabel_19.setFont(new Font("����", Font.PLAIN, 13));
		 lblNewLabel_19.setBounds(708, 56, 54, 15);
		 contentPane.add(lblNewLabel_19);
		 //������ѷ���
		 label = new JLabel("");
		 label.setFont(new Font("����", Font.PLAIN, 13));
		 label.setBounds(708, 81, 54, 15);
		 contentPane.add(label);
		 //������ѷ���
		 label_1 = new JLabel("");
		 label_1.setFont(new Font("����", Font.PLAIN, 13));
		 label_1.setBounds(708, 106, 54, 15);
		 contentPane.add(label_1);
		 //������ѷ���
		 label_2 = new JLabel("");
		 label_2.setFont(new Font("����", Font.PLAIN, 13));
		 label_2.setBounds(708, 131, 54, 15);
		 contentPane.add(label_2);
		 //ţ��
		 label_3 = new JLabel("");
		 label_3.setFont(new Font("����", Font.PLAIN, 13));
		 label_3.setBounds(708, 172, 54, 15);
		 contentPane.add(label_3);
		 //�л�������
		 label_4 = new JLabel("");
		 label_4.setFont(new Font("����", Font.PLAIN, 13));
		 label_4.setBounds(708, 197, 54, 15);
		 contentPane.add(label_4);
		 //��ȫ������
		 label_5 = new JLabel("");
		 label_5.setFont(new Font("����", Font.PLAIN, 13));
		 label_5.setBounds(708, 222, 54, 15);
		 contentPane.add(label_5);
		 //��Ħ����
		  lblNewLabel_20 = new JLabel("");
		 lblNewLabel_20.setBounds(708, 247, 54, 15);
		 contentPane.add(lblNewLabel_20);
		 
		  lblNewLabel_24 = new JLabel("");
		 lblNewLabel_24.setBounds(708, 289, 54, 15);
		 contentPane.add(lblNewLabel_24);
		 //���
		 textField_6 = new JTextField();
		 textField_6.setColumns(10);
		 textField_6.setBounds(94, 189, 81, 21);
		 contentPane.add(textField_6);
		 
		 button = new JButton("\u66F4\u65B0");
		 button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			gengxing();
			}
		});
		 button.setFont(new Font("����", Font.PLAIN, 14));
		 button.setBounds(419, 436, 93, 23);
		 contentPane.add(button);
		 
		 JTextArea textArea = new JTextArea();
		 textArea.setBounds(587, 285, 253, 157);
		 contentPane.add(textArea);
		 
	}
	
	//�˵ĸ��·���
	public void gengxing(){
		String columnNames[] = {"ʳƷ���","ʳƷ����","����/����/��","��֬/����/��","������/����/��","ά����/����/��","�޻���/����/��"};
		Connection conn=null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		try {
	 		conn =JDBC_Ui.getConnection();
			String sql ="select * from cai";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			int count =0;
			while(rs.next()){
				count++;
			}
			rs = ps.executeQuery();
			rowData=new Object[count][7]; //�������
			count=0;
			while(rs.next()){
				rowData[count][0]=rs.getInt("id");
				rowData[count][1]=rs.getString("cainame"); //
				rowData[count][2]=rs.getString("suger");
				rowData[count][3]=rs.getString("oil");
				rowData[count][4]=rs.getString("danbaizhi");
				rowData[count][5]=rs.getString("weishengsu");
				rowData[count][6]=rs.getString("wujiyan");
				
				count++;  
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			conn.close();
			ps.close();
			rs.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 JScrollPane scrollPane = new JScrollPane();
		 scrollPane.setBounds(10, 10, 830, 169);
		 getContentPane().add(scrollPane);
		/*JScrollPane scrollPane = new JScrollPane();
		 scrollPane.setBounds(0, 0, 588, 158);
		 contentPane.add(scrollPane);*/
		 JTable table_1=new JTable(rowData,columnNames);
		 scrollPane.setViewportView(table_1);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	//���뷽��insert()
	public void insert(){
		String st1,st2,st3,st4,st5,st6,St7;
	//��Ʒ
		st1 = textField.getText();
		//����
		st2 = textField_1.getText();
		//��֬
		st3 = textField_2.getText();
		//������
		st4 = textField_3.getText();
		//ά����
		st5 = textField_4.getText();
		//�޻���
		st6 = textField_5.getText();
		//��ϵ���
		St7 = textField_6.getText();
		if(st1.length()==0){
			JOptionPane.showMessageDialog(null, "��������ȷ�Ĳ�����", "��ʾ", JOptionPane.PLAIN_MESSAGE);
		}else if(st2.length()==0){
			JOptionPane.showMessageDialog(null, "�������Ƿֺ���", "��ʾ", JOptionPane.PLAIN_MESSAGE);
		}else if(st3.length()==0){
			JOptionPane.showMessageDialog(null, "��������֬������", "��ʾ", JOptionPane.PLAIN_MESSAGE);
		}else if(st4.length()==0){
			JOptionPane.showMessageDialog(null, "�����뵰���ʺ�����", "��ʾ", JOptionPane.PLAIN_MESSAGE);
		}else if(st5.length()==0){
			JOptionPane.showMessageDialog(null, "������ά���غ�����", "��ʾ", JOptionPane.PLAIN_MESSAGE);
		}else if(st6.length()==0){
			JOptionPane.showMessageDialog(null, "�������޻��κ�����", "��ʾ", JOptionPane.PLAIN_MESSAGE);
		}else if(St7.length()==0){
			JOptionPane.showMessageDialog(null, "�������ţ�", "��ʾ", JOptionPane.PLAIN_MESSAGE);
		}
		else{
			try {
			Connection conn = JDBC_Ui.getConnection();
			String sql2 = "select * from cai where id=?";
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.setInt(1,Integer.parseInt(St7));
			ResultSet rs = ps2.executeQuery();
			if(rs.next()){
				JOptionPane.showMessageDialog(null, "�Ѵ��ڴ˱�Ų�ϵ", "��ʾ", JOptionPane.PLAIN_MESSAGE);
			}else{
			
			String sql = "insert into cai(cainame,suger,oil,danbaizhi,weishengsu,wujiyan,id) values(?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, String.valueOf(st1));
			ps.setString(2, String.valueOf(st2));
			ps.setString(3, String.valueOf(st3));
			ps.setString(4, String.valueOf(st4));
			ps.setString(5, String.valueOf(st5));
			ps.setString(6, String.valueOf(st6));
			ps.setInt(7, Integer.parseInt(St7));
			
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "��ӳɹ�", "��ʾ", JOptionPane.PLAIN_MESSAGE);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
	}
		

	//check����
public void check(){
	String st1,st2,st3,st4,st5,st6,St7;
//�õ���Ա����
	//��Ʒ
	st1 = textField.getText();
	//����
	st2 = textField_1.getText();
	//��֬
	st3 = textField_2.getText();
	//������
	st4 = textField_3.getText();
	//ά����
	st5 = textField_4.getText();
	//�޻���
	st6 = textField_5.getText();
	//��ϵ���
	St7 = textField_6.getText();;
//�ж��������ݵĺϷ���
Connection conn = null;
PreparedStatement ps =null;
ResultSet rs = null;

try {
	conn = JDBC_Ui.getConnection();
		String sql = "select * from cai where cainame=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, st1);
			rs = ps.executeQuery();
		if(rs.next()){
			textField_1.setText(rs.getString("suger"));
			textField_2.setText(rs.getString("oil"));
			textField_3.setText(rs.getString("danbaizhi"));
			textField_4.setText(rs.getString("weishengsu"));
			textField_5.setText(rs.getString("wujiyan"));
			textField_6.setText(String.valueOf(rs.getInt("id")));
			
			//new myDialog(null,"�Ѵ���Ա����");
		}else{
			JOptionPane.showMessageDialog(null, "��β�ϵ��", "��ʾ", JOptionPane.PLAIN_MESSAGE);
			
		     }
}catch (Exception e) {
			e.printStackTrace();
		}
	
}	
}
