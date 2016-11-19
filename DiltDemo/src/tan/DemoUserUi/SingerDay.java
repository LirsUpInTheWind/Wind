package tan.DemoUserUi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Util.JDBC_Ui;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SingerDay extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	public JTextField textField_5;
	public Object[][] rowData;
	public static int[][] caiidshuzu;
	public String c = canyinfenxi.c;
	private JTable table;
	private JLabel lblNewLabel_1; 
	private int n;
	public static String bb;
	private JLabel lblmg_1;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JButton button_1;
	public static int sumsuger2;
	public static int sumoil2;
	public static int sumdanbaizhi2;
	public static int sumwujiyan2;
	public static int sumweishengsu2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SingerDay frame = new SingerDay();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SingerDay() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//设置点击窗口关闭无操作
		setTitle("\u8425\u517B\u6210\u5206");
		Object a =  canyinfenxi.a;
		
		setBounds(100, 100, 702, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("\u4E3B\u98DF\u540D\u79F0:");
		lblNewLabel.setBounds(20, 26, 70, 15);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(100, 26, 98, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblmg = new JLabel("\u8425\u517B\u6210\u5206\u5206\u5E03\uFF1Amg/\u4EFD");
		lblmg.setBounds(20, 68, 153, 15);
		lblmg.setFont(new Font("宋体", Font.PLAIN, 14));
		contentPane.add(lblmg);
		
		JLabel lblNewLabel_2 = new JLabel("\u7CD6\u7C7B\uFF1A");
		lblNewLabel_2.setBounds(20, 112, 70, 15);
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_2);
		
		JLabel label_1 = new JLabel("\u6CB9\u8102\uFF1A");
		label_1.setBounds(20, 148, 70, 15);
		label_1.setFont(new Font("宋体", Font.PLAIN, 14));
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u86CB\u767D\u8D28\uFF1A");
		label_2.setBounds(20, 188, 70, 15);
		label_2.setFont(new Font("宋体", Font.PLAIN, 14));
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u65E0\u673A\u76D0\uFF1A");
		label_3.setBounds(20, 224, 70, 15);
		label_3.setFont(new Font("宋体", Font.PLAIN, 14));
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\u7EF4\u751F\u7D20\uFF1A");
		label_4.setBounds(20, 261, 70, 15);
		label_4.setFont(new Font("宋体", Font.PLAIN, 14));
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(20, 296, 54, 15);
		contentPane.add(label_5);
		
		textField = new JTextField();
		textField.setBounds(98, 109, 66, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(98, 145, 66, 21);
		textField_1.setColumns(10);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(98, 185, 66, 21);
		textField_2.setColumns(10);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(98, 221, 66, 21);
		textField_3.setColumns(10);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(98, 258, 66, 21);
		textField_4.setColumns(10);
		contentPane.add(textField_4);
		
		JButton btnNewButton = new JButton("\u67E5\u770B\u6B64\u65E5\u76F8\u5173");
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				singerDay();
				
			}
		});
			
			
			
		btnNewButton.setBounds(207, 64, 125, 23);
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 14));
		contentPane.add(btnNewButton);
		
		textField_5 = new JTextField();
		textField_5.setBounds(208, 24, 189, 21);
		textField_5.setText(String.valueOf(a));
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JButton button = new JButton("\u6B64\u65E5\u5BF9\u5E94\u8425\u517B\u6444\u5165");
		button.addActionListener(new  ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yingyangsheru();
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 14));
		button.setBounds(342, 64, 153, 23);
		contentPane.add(button);
		
		lblmg_1 = new JLabel("\u603B\u8425\u517B\u6444\u5165/mg:");
		lblmg_1.setFont(new Font("宋体", Font.PLAIN, 14));
		lblmg_1.setBounds(81, 311, 98, 15);
		contentPane.add(lblmg_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(309, 311, 66, 21);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(385, 311, 66, 21);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(461, 311, 66, 21);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(539, 311, 66, 21);
		contentPane.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(615, 311, 66, 21);
		contentPane.add(textField_10);
		
		button_1 = new JButton("\u67E5\u770B\u8BC4\u4EF7");
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Result r = new Result();
				r.setVisible(true);
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 14));
		button_1.setBounds(517, 64, 125, 23);
		contentPane.add(button_1);
		
		
		Connection conn= null;
		PreparedStatement ps,ps2 =null;
		ResultSet rs,rs2 = null;
		String t2 = textField_5.getText();
		try {
			conn = JDBC_Ui.getConnection();
			//默认升序
			String sql = "select * from record where time=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1,t2);
			rs = ps.executeQuery();
			if(rs.next()){
				n = rs.getInt("caiid");
				lblNewLabel_1.setText(rs.getString("cainame")); 
				 
					String sql2="select * from cai where id=?";
					ps2 = conn.prepareStatement(sql2);
					ps2.setInt(1,n);
					rs2=ps2.executeQuery();
						while(rs2.next()){
							textField.setText(rs2.getString("suger"));
							textField_1.setText(rs2.getString("oil"));
							textField_2.setText(rs2.getString("danbaizhi"));
							textField_3.setText(rs2.getString("wujiyan"));
							textField_4.setText(rs2.getString("weishengsu"));
						}
			}
			conn.close();
			ps.close();
			rs.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	public void yingyangsheru(){
		Connection conn,conn1= null;
		PreparedStatement ps,ps1=null;
		ResultSet rs,rs1 = null;
		String t1 = textField.getText();
		String t2 = textField_5.getText();
	    String t3 = t2.substring(0, 10);
	    int sugerzong = 0,sumsuger=0;
	    int danbaizhizong=0,sumdanbaizhi=0;
	    int oilzong=0,sumoil=0;
	    int wujiyanzong=0,sumwujiyan=0;
	    int weishengsuzong=0,sumweishengsu=0;
	   
	    
		String columnNames[] = {"菜品名","糖类","脂质","蛋白质","无机盐","维生素"};
		try {
			conn = JDBC_Ui.getConnection();
			//默认升序
			String sql = "select * from record where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,Integer.valueOf(c));
			rs = ps.executeQuery();
			int count =0;
			while(rs.next()){
				String time = rs.getString("time");
				if(time.substring(0,10).equals(t3)){
					count++;					
				}
			}
			rs = ps.executeQuery();
			rowData=new Object[count][6]; //表格数据
			count=0;
			while(rs.next()){
				String time = rs.getString("time");
				if(time.substring(0, 10).equals(t3)){
						int a =rs.getInt("caiid");
							//根据菜的名字尽心查询
								conn1 = JDBC_Ui.getConnection();
								String sql2="select * from cai where id=?";
								ps1 = conn1.prepareStatement(sql2);
								ps1.setInt(1,a);
								rs1 = ps1.executeQuery();
								if(rs1.next()){
									rowData[count][0]=rs1.getString("cainame"); //
									rowData[count][1]=rs1.getString("suger");
									rowData[count][2]=rs1.getString("oil");
									rowData[count][3]=rs1.getString("danbaizhi");
									rowData[count][4]=rs1.getString("wujiyan");
									rowData[count][5]=rs1.getString("weishengsu");
									
									 sugerzong= Integer.parseInt(rs1.getString("suger"));
									   danbaizhizong=Integer.parseInt(rs1.getString("danbaizhi"));
									   oilzong=Integer.parseInt(rs1.getString("oil"));
									   wujiyanzong=Integer.parseInt(rs1.getString("wujiyan"));
									   weishengsuzong=Integer.parseInt(rs1.getString("weishengsu"));
									
								}
								
								sumsuger=sugerzong+sumsuger;
								sumdanbaizhi=danbaizhizong+sumdanbaizhi;
								sumoil=sumoil+oilzong;
								sumwujiyan=wujiyanzong+sumwujiyan;
								sumweishengsu=sumweishengsu+weishengsuzong;
								
								
								conn1.close();
								ps1.close();
								rs1.close();
						count++;
				
				}
				
					
			}

			textField_6.setText(String.valueOf(sumsuger));
			textField_7.setText(String.valueOf(sumoil));
			textField_8.setText(String.valueOf(sumdanbaizhi));
			textField_9.setText(String.valueOf(sumwujiyan));
			textField_10.setText(String.valueOf(sumweishengsu));
			
			sumsuger2 = Integer.parseInt(textField_6.getText());
			sumoil2=Integer.parseInt(textField_7.getText());
		    sumdanbaizhi2=Integer.parseInt(textField_8.getText());
		    sumwujiyan2=Integer.parseInt(textField_9.getText());
			sumweishengsu2=Integer.parseInt(textField_10.getText());
			
			conn.close();
			ps.close();
			rs.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JScrollPane scrollPane = new JScrollPane();
		 scrollPane.setBounds(217, 112, 459, 167);
		 getContentPane().add(scrollPane);
		 
		 JTable table_1=new JTable(rowData,columnNames);
		 scrollPane.setViewportView(table_1);
		 
		 JScrollPane scrollPane_1 = new JScrollPane();
		 scrollPane.setRowHeaderView(scrollPane_1);
		 table_1.getTableHeader().setReorderingAllowed(true);
		 table_1.getTableHeader().setResizingAllowed(true);
	}
	//总摄入量赋值
	public void zongsheruliang(){
		
	}
	
	
	//赋值框框
	public void fuzhi(){
		Connection conn = null;
		PreparedStatement ps,ps2 =null;
		ResultSet rs,rs2 = null;
		String t2 = textField_5.getText();
		try {
			conn = JDBC_Ui.getConnection();
			//默认升序
			String sql = "select * from record where time=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1,t2);
			rs = ps.executeQuery();
			while(rs.next()){
				int caiid = rs.getInt("caiid");
				lblNewLabel_1.setText(rs.getString("cainame")); 
					String sql2="select * from cai where caiid=?";
					ps2 = conn.prepareStatement(sql2);
					rs2=ps2.executeQuery();
						while(rs2.next()){
							textField.setText(rs2.getString("suger"));
							textField_1.setText(rs2.getString("oil"));
							textField_2.setText(rs2.getString("danbaizhi"));
							textField_3.setText(rs2.getString("wujiyan"));
							textField_4.setText(rs2.getString("weishengsu"));
						}
			}
			conn.close();
			ps.close();
			rs.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	public void singerDay(){
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		String t1 = textField.getText();
		String t2 = textField_5.getText();
	    String t3 = t2.substring(0, 10);
		String columnNames[] = {"姓名","菜系编号","菜品名","食用时间"};
		try {
			conn = JDBC_Ui.getConnection();
			//默认升序
			String sql = "select * from record where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,Integer.valueOf(c));
			rs = ps.executeQuery();
			int count =0;
			while(rs.next()){
				String time = rs.getString("time");
				if(time.substring(0,10).equals(t3)){
					count++;					
				}
			}
			rs = ps.executeQuery();
			rowData=new Object[count][4]; //表格数据
			count=0;
			while(rs.next()){
				String time = rs.getString("time");
				if(time.substring(0, 10).equals(t3)){
						rowData[count][0]=rs.getString("name"); //
						rowData[count][1]=rs.getInt("caiid");
						rowData[count][2]=rs.getString("cainame");
						rowData[count][3]=rs.getString("time");;
						count++;
				}
			}
			conn.close();
			ps.close();
			rs.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JScrollPane scrollPane = new JScrollPane();
		 scrollPane.setBounds(217, 112, 459, 167);
		 getContentPane().add(scrollPane);
		 
		 JTable table_1=new JTable(rowData,columnNames);
		 scrollPane.setViewportView(table_1);
		 
		 JScrollPane scrollPane_1 = new JScrollPane();
		 scrollPane.setRowHeaderView(scrollPane_1);
		 table_1.getTableHeader().setReorderingAllowed(true);
		 table_1.getTableHeader().setResizingAllowed(true);
	}
}
