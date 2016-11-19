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
	private JTextField textField;//姓名
	private JTextField textField_1;//性别
	private JTextField textField_2;//ID
	private JTextField textField_3;//联系方式
	private JTextField textField_4;//入住时间
	private JTextField textField_5;//入住天数赋值框
	private float charge;
	private int tianl;
	private JLabel lblNewLabel_19;//早餐消费数
	private JLabel label;//午餐
	private JLabel label_1;//晚餐
	private JLabel label_2;//红酒
	private JLabel label_3;//贵州茅台
	private JLabel label_4;//叫花鸡
	private JLabel label_5;//烤全羊
	private JLabel lblNewLabel_24;//房费
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
	    setTitle("点餐系统");
	    
	    this.setVisible(true);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);;//设置点击窗口关闭无操作
		
		
	
		setBounds(100, 100, 866, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//构造方法中给表格赋予初始值
		String columnNames[] = {"食品编号","食品名称","糖类/毫克/份","油脂/毫克/份","蛋白质/毫克/份","维生素/毫克/份","无机盐/毫克/份"};
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
			rowData=new Object[count][7]; //表格数据
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
		 lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		 lblNewLabel.setBounds(10, 197, 105, 15);
		 contentPane.add(lblNewLabel);
		 
		 JButton btnNewButton = new JButton("\u67E5\u8BE2");
		 btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		check();
			}
		});
		 btnNewButton.setFont(new Font("宋体", Font.PLAIN, 14));
		 btnNewButton.setBounds(206, 237, 93, 23);
		 contentPane.add(btnNewButton);
		 
		 JLabel lblNewLabel_1 = new JLabel("\u83DC\u54C1\u540D:");
		 lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		 lblNewLabel_1.setBounds(10, 241, 70, 15);
		 contentPane.add(lblNewLabel_1);
		 //菜品名
		 textField = new JTextField();
		 textField.setBounds(94, 238, 81, 21);
		 contentPane.add(textField);
		 textField.setColumns(10);
		 
		 JLabel lblNewLabel_2 = new JLabel("\u7CD6\u7C7B:");
		 lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 14));
		 lblNewLabel_2.setBounds(10, 289, 54, 15);
		 contentPane.add(lblNewLabel_2);
		 //糖类
		 textField_1 = new JTextField();
		 textField_1.setBounds(94, 286, 81, 21);
		 contentPane.add(textField_1);
		 textField_1.setColumns(10);
		 
		 JLabel lblNewLabel_3 = new JLabel("\u6CB9\u8102:");
		 lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 14));
		 lblNewLabel_3.setBounds(10, 330, 55, 15);
		 contentPane.add(lblNewLabel_3);
		 //油脂
		 textField_2 = new JTextField();
		 textField_2.setBounds(94, 327, 81, 21);
		 contentPane.add(textField_2);
		 textField_2.setColumns(10);
		 
		 JLabel lblNewLabel_4 = new JLabel("\u86CB\u767D\u8D28:");
		 lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 14));
		 lblNewLabel_4.setBounds(10, 370, 70, 15);
		 contentPane.add(lblNewLabel_4);
		 //蛋白质
		 textField_3 = new JTextField();
		 textField_3.setBounds(94, 367, 105, 21);
		 contentPane.add(textField_3);
		 textField_3.setColumns(10);
		 
		 JLabel lblNewLabel_5 = new JLabel("\u7EF4\u751F\u7D20:");
		 lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 14));
		 lblNewLabel_5.setBounds(10, 414, 70, 15);
		 contentPane.add(lblNewLabel_5);
		 //维生素
		 textField_4 = new JTextField();
		 textField_4.setBounds(94, 411, 105, 21);
		 contentPane.add(textField_4);
		 textField_4.setColumns(10);
		 //属猪天数标签
		 JLabel lblNewLabel_6 = new JLabel("\u65E0\u673A\u76D0:");
		 lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 14));
		 lblNewLabel_6.setBounds(201, 289, 70, 15);
		 contentPane.add(lblNewLabel_6);
		 //无机盐
		 textField_5 = new JTextField();
		 textField_5.setBounds(281, 286, 54, 21);
		 contentPane.add(textField_5);
		 textField_5.setColumns(10);
		 
		 JLabel lblNewLabel_7 = new JLabel("\u8425\u517B\u5143\u7D20\u5355\u4F4D:\u6BEB\u514B/\u4EFD");
		 lblNewLabel_7.setFont(new Font("宋体", Font.PLAIN, 14));
		 lblNewLabel_7.setBounds(346, 189, 203, 30);
		 contentPane.add(lblNewLabel_7);
		 
		 JButton btnNewButton_1 = new JButton("\u6DFB\u52A0");
		 btnNewButton_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		insert();
		 	
		 	}
		 });
		 btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 14));
		 btnNewButton_1.setBounds(419, 264, 93, 23);
		 contentPane.add(btnNewButton_1);
		 
		 JButton btnNewButton_2 = new JButton("退出");
		 btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		 btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 14));
		 btnNewButton_2.setBounds(419, 326, 93, 23);
		 contentPane.add(btnNewButton_2);
		 
		 JButton btnNewButton_3 = new JButton("清空");
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
		 btnNewButton_3.setFont(new Font("宋体", Font.PLAIN, 14));
		 btnNewButton_3.setBounds(419, 391, 93, 23);
		 contentPane.add(btnNewButton_3);
		 //早餐消费费用:
		  lblNewLabel_19 = new JLabel("");
		 lblNewLabel_19.setFont(new Font("宋体", Font.PLAIN, 13));
		 lblNewLabel_19.setBounds(708, 56, 54, 15);
		 contentPane.add(lblNewLabel_19);
		 //午餐消费费用
		 label = new JLabel("");
		 label.setFont(new Font("宋体", Font.PLAIN, 13));
		 label.setBounds(708, 81, 54, 15);
		 contentPane.add(label);
		 //晚餐消费费用
		 label_1 = new JLabel("");
		 label_1.setFont(new Font("宋体", Font.PLAIN, 13));
		 label_1.setBounds(708, 106, 54, 15);
		 contentPane.add(label_1);
		 //红酒消费费用
		 label_2 = new JLabel("");
		 label_2.setFont(new Font("宋体", Font.PLAIN, 13));
		 label_2.setBounds(708, 131, 54, 15);
		 contentPane.add(label_2);
		 //牛排
		 label_3 = new JLabel("");
		 label_3.setFont(new Font("宋体", Font.PLAIN, 13));
		 label_3.setBounds(708, 172, 54, 15);
		 contentPane.add(label_3);
		 //叫花鸡消费
		 label_4 = new JLabel("");
		 label_4.setFont(new Font("宋体", Font.PLAIN, 13));
		 label_4.setBounds(708, 197, 54, 15);
		 contentPane.add(label_4);
		 //烤全羊消费
		 label_5 = new JLabel("");
		 label_5.setFont(new Font("宋体", Font.PLAIN, 13));
		 label_5.setBounds(708, 222, 54, 15);
		 contentPane.add(label_5);
		 //按摩消费
		  lblNewLabel_20 = new JLabel("");
		 lblNewLabel_20.setBounds(708, 247, 54, 15);
		 contentPane.add(lblNewLabel_20);
		 
		  lblNewLabel_24 = new JLabel("");
		 lblNewLabel_24.setBounds(708, 289, 54, 15);
		 contentPane.add(lblNewLabel_24);
		 //编号
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
		 button.setFont(new Font("宋体", Font.PLAIN, 14));
		 button.setBounds(419, 436, 93, 23);
		 contentPane.add(button);
		 
		 JTextArea textArea = new JTextArea();
		 textArea.setBounds(587, 285, 253, 157);
		 contentPane.add(textArea);
		 
	}
	
	//菜的更新方法
	public void gengxing(){
		String columnNames[] = {"食品编号","食品名称","糖类/毫克/份","油脂/毫克/份","蛋白质/毫克/份","维生素/毫克/份","无机盐/毫克/份"};
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
			rowData=new Object[count][7]; //表格数据
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
	
	
	
	
	
	
	
	
	
	
	//插入方法insert()
	public void insert(){
		String st1,st2,st3,st4,st5,st6,St7;
	//菜品
		st1 = textField.getText();
		//糖类
		st2 = textField_1.getText();
		//油脂
		st3 = textField_2.getText();
		//蛋白质
		st4 = textField_3.getText();
		//维生素
		st5 = textField_4.getText();
		//无机盐
		st6 = textField_5.getText();
		//菜系编号
		St7 = textField_6.getText();
		if(st1.length()==0){
			JOptionPane.showMessageDialog(null, "请输入正确的菜名！", "提示", JOptionPane.PLAIN_MESSAGE);
		}else if(st2.length()==0){
			JOptionPane.showMessageDialog(null, "请输入糖分含量", "提示", JOptionPane.PLAIN_MESSAGE);
		}else if(st3.length()==0){
			JOptionPane.showMessageDialog(null, "请输入油脂含量！", "提示", JOptionPane.PLAIN_MESSAGE);
		}else if(st4.length()==0){
			JOptionPane.showMessageDialog(null, "请输入蛋白质含量！", "提示", JOptionPane.PLAIN_MESSAGE);
		}else if(st5.length()==0){
			JOptionPane.showMessageDialog(null, "请输入维生素含量！", "提示", JOptionPane.PLAIN_MESSAGE);
		}else if(st6.length()==0){
			JOptionPane.showMessageDialog(null, "请输入无机盐含量！", "提示", JOptionPane.PLAIN_MESSAGE);
		}else if(St7.length()==0){
			JOptionPane.showMessageDialog(null, "请输入编号！", "提示", JOptionPane.PLAIN_MESSAGE);
		}
		else{
			try {
			Connection conn = JDBC_Ui.getConnection();
			String sql2 = "select * from cai where id=?";
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.setInt(1,Integer.parseInt(St7));
			ResultSet rs = ps2.executeQuery();
			if(rs.next()){
				JOptionPane.showMessageDialog(null, "已存在此编号菜系", "提示", JOptionPane.PLAIN_MESSAGE);
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
			JOptionPane.showMessageDialog(null, "添加成功", "提示", JOptionPane.PLAIN_MESSAGE);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
	}
		

	//check方法
public void check(){
	String st1,st2,st3,st4,st5,st6,St7;
//拿到成员变量
	//菜品
	st1 = textField.getText();
	//糖类
	st2 = textField_1.getText();
	//油脂
	st3 = textField_2.getText();
	//蛋白质
	st4 = textField_3.getText();
	//维生素
	st5 = textField_4.getText();
	//无机盐
	st6 = textField_5.getText();
	//菜系编号
	St7 = textField_6.getText();;
//判断输入数据的合法性
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
			
			//new myDialog(null,"已存在员工号");
		}else{
			JOptionPane.showMessageDialog(null, "五次菜系！", "提示", JOptionPane.PLAIN_MESSAGE);
			
		     }
}catch (Exception e) {
			e.printStackTrace();
		}
	
}	
}
