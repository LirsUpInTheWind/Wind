package tan.Demo.MannagerUi;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Util.JDBC_Ui;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class updatecai extends JFrame {
	
	private JPanel contentPane;
	private JTextField textField;//客户房间编号
	private JLabel lblNewLabel_1;
	private JTextField textField_1;//客户姓名
	private JLabel lblNewLabel_2;
	private JTextField textField_2;//客户性别
	private JLabel lblNewLabel_4;
	private JTextField textField_4;//客户联系方式
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_5;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	public Object[][] rowData;
	/**
	 * @wbp.nonvisual location=107,437
	 */
	private final JLabel label = new JLabel("New label");
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTable table;
	private JButton button_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updatecai frame = new updatecai();
					frame.setTitle("客户入住信息修改");
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
	public updatecai() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 725, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//输入客户证件号
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u83DC\u7CFB\u540D:");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setBounds(37, 28, 106, 21);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(166, 28, 150, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("确定");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String st1 =textField.getText();
				if(st1.length()==0||st1.matches("[0-9]{1,33}")){
					JOptionPane.showMessageDialog(null, "请输入正确的菜名", "提示", JOptionPane.PLAIN_MESSAGE);			
					//new myDialog(null, "请输入证件号:");
				}else{
					querycai(st1);
				}
			}
		});
		button.setBounds(377, 27, 93, 23);
		contentPane.add(button);
		
		lblNewLabel_1 = new JLabel("\u7CD6\u7C7B\u542B\u91CF:");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(47, 80, 65, 15);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(142, 77, 74, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel_2 = new JLabel("\u6CB9\u8102\u542B\u91CF:");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(47, 128, 65, 15);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(143, 125, 74, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		lblNewLabel_4 = new JLabel("\u86CB\u767D\u8D28\u542B\u91CF:");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(47, 176, 86, 15);
		contentPane.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(143, 173, 74, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		lblNewLabel_3 = new JLabel("\u65E0\u673A\u76D0\u542B\u91CF:\r\n");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(47, 221, 85, 15);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_5 = new JLabel("\u7EF4\u751F\u7D20\u542B\u91CF:");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(47, 265, 86, 15);
		contentPane.add(lblNewLabel_5);
		
		btnNewButton = new JButton("一键修改");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lblNewLabel_14.getText()==null){
					JOptionPane.showMessageDialog(null, "查不到有效菜名", "提示", JOptionPane.PLAIN_MESSAGE);	
				}else{
					update();
				}
				}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 14));
		btnNewButton.setBounds(142, 328, 93, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("退出");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();	
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 14));
		btnNewButton_1.setBounds(245, 328, 93, 23);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel_13 = new JLabel("\u83DC\u7CFB\u7F16\u53F7:");
		lblNewLabel_13.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_13.setBounds(302, 83, 65, 15);
		contentPane.add(lblNewLabel_13);
		//客户证件
		lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_14.setBounds(377, 83, 140, 15);
		contentPane.add(lblNewLabel_14);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(143, 218, 74, 21);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(143, 259, 74, 21);
		contentPane.add(textField_6);
		
		JButton button_1 = new JButton("\u5220\u9664");
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				delete();
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 14));
		button_1.setBounds(37, 328, 93, 23);
		contentPane.add(button_1);
		
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
		 scrollPane.setBounds(227, 108, 472, 173);
		 getContentPane().add(scrollPane);
		/*JScrollPane scrollPane = new JScrollPane();
		 scrollPane.setBounds(0, 0, 588, 158);
		 contentPane.add(scrollPane);*/
		 JTable table=new JTable(rowData,columnNames);
		 scrollPane.setViewportView(table);
		 
		 button_2 = new JButton("\u66F4\u65B0");
		 button_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				updatecai();
				
			}
		});
		 button_2.setFont(new Font("宋体", Font.PLAIN, 14));
		 button_2.setBounds(348, 328, 93, 23);
		 contentPane.add(button_2);
		
		
		
	}
	
	public void updatecai(){
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
		 scrollPane.setBounds(227, 108, 472, 173);
		 getContentPane().add(scrollPane);
		/*JScrollPane scrollPane = new JScrollPane();
		 scrollPane.setBounds(0, 0, 588, 158);
		 contentPane.add(scrollPane);*/
		 JTable table=new JTable(rowData,columnNames);
		 scrollPane.setViewportView(table);
		 
		 button_2 = new JButton("\u66F4\u65B0");
		 button_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		 button_2.setFont(new Font("宋体", Font.PLAIN, 14));
		 button_2.setBounds(348, 328, 93, 23);
		 contentPane.add(button_2);
		
		
		
	}
	
	 
	
	
	
	
	
	public void delete(){
		String st1;
		st1 = textField.getText();
		//判断有没有输入数据
		if(st1.length()==0||st1.matches("[0-9]{1,9}")){
			JOptionPane.showMessageDialog(null, "菜名输入有误", "提示", JOptionPane.PLAIN_MESSAGE);	
		}else{
			//链接数据库
			Connection conn =null;
			PreparedStatement ps =null;
			ResultSet rs = null;
		try {
			conn = JDBC_Ui.getConnection();
			//先查询有没有这个编号
			String sql1= "select * from cai where cainame=?";
			ps = conn.prepareStatement(sql1);
			ps.setString(1,st1);
			rs = ps.executeQuery();
			//有这个号
			if(rs.next()==true){
				//删除员工表
					String sql = "delete from cai where cainame=?";
					ps=conn.prepareStatement(sql);
					ps.setString(1,st1);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "删除成功", "提示", JOptionPane.PLAIN_MESSAGE);	
			}else{
				JOptionPane.showMessageDialog(null, "输入有误", "提示", JOptionPane.PLAIN_MESSAGE);	
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
			try {
				conn.close();
				ps.close();
				rs.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
	}
		
}
	
	
	
	
	
	
	//将菜品查询出来
	private void querycai(String a){
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		try {
			conn = JDBC_Ui.getConnection();
			String sql ="select * from cai where cainame=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, a);
			rs = ps.executeQuery();
			if(rs.next()==true){
				//如果查到了，就将查到的值传给对应的文本框
			
				textField_1.setText(rs.getString("suger"));//String改动处
				textField_2.setText(rs.getString("oil"));
				textField_4.setText(rs.getString("danbaizhi"));
				textField_5.setText(rs.getString("wujiyan"));
				textField_6.setText(rs.getString("weishengsu"));
				lblNewLabel_14.setText(String.valueOf(rs.getInt("id")));
				
			}else{
				JOptionPane.showMessageDialog(null, "没有这个菜", "提示", JOptionPane.PLAIN_MESSAGE);	
			
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
	//更新
	@SuppressWarnings("resource")
	
	
	public void update(){
		String t1,t2,t3,t4,t5,t6,t7,t8;
		t1 = textField_1.getText();//糖
		t2 = textField_2.getText();//由
		//t3 = textField_3.getText();//菜编号
		t4 = textField_4.getText();//蛋白质
		t5 = textField_5.getText();//无机盐
		t6 = textField_6.getText();//维生素
		t7 = textField.getText();//菜名
		t8 = lblNewLabel_14.getText();
		if(t5.length()==0||!t5.matches("[0-9]{1,5}")){
		JOptionPane.showMessageDialog(null, "无机盐输入有误", "提示", JOptionPane.PLAIN_MESSAGE);	
		}else if(t1.length()==0||!t1.matches("[0-9]{1,5}")){
			JOptionPane.showMessageDialog(null, "糖类输入有误", "提示", JOptionPane.PLAIN_MESSAGE);	
		}else if(t2.length()==0||!t2.matches("[0-9]{1,5}")){
			JOptionPane.showMessageDialog(null, "油脂输入有误", "提示", JOptionPane.PLAIN_MESSAGE);	
		}else if(t4.length()==0){
			JOptionPane.showMessageDialog(null, "蛋白质输入有误", "提示", JOptionPane.PLAIN_MESSAGE);	
		}else if(t6.length()==0||!t6.matches("[0-9]{1,5}")){
			JOptionPane.showMessageDialog(null, "维生素输入有误", "提示", JOptionPane.PLAIN_MESSAGE);	
		}else if(t7.length()==0){
			JOptionPane.showMessageDialog(null, "检查不到有效菜名", "提示", JOptionPane.PLAIN_MESSAGE);	
		}
		else{
			//链接数据库进行修改
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
					//写修改
					conn = JDBC_Ui.getConnection();
					String sql3 = "update cai set id=?,suger=?,oil=?,wujiyan=?,weishengsu=?,danbaizhi=?,cainame=? where id=?";
					ps =conn.prepareStatement(sql3);
						ps.setInt(1,Integer.parseInt(t8));
					ps.setString(2, t1);
					ps.setString(3, t2);
					ps.setString(4, t5);
					ps.setString(5, t6);
					ps.setString(6, t4);
					ps.setString(7,t7);
					ps.setInt(8, Integer.parseInt(t8));
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "更新成功", "提示", JOptionPane.ERROR_MESSAGE);
					
				}
			catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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
			