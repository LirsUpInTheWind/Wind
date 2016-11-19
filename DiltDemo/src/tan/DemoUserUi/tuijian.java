package tan.DemoUserUi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import Util.JDBC_Ui;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class tuijian extends JFrame {

	private JPanel contentPane;
	public int ss;
	public int oo;
	public int ww;
	public int wei;
	public int dd;
	public Object[][] rowData,rowData1,rowData2,rowData3,rowData4,rowData5;
	JLabel lblNewLabel_1;
	private JTable table;
	private JTable table_2;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JTable table_3;
	private JTable table_4;
	private JLabel label_3;
	private JTable table_5;
	private JTable table_6;
	private JTable table_7;
	private JTable table_8;
	private JTable table_9;
	private JTable table_10;
	private JTable table_11;
	private JTable table_12;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tuijian frame = new tuijian();
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
	public tuijian() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//设置点击窗口关闭无操作
		ss = SingerDay.sumsuger2;
		oo = SingerDay.sumoil2;
		ww = SingerDay.sumwujiyan2;
		wei = SingerDay.sumweishengsu2;
		dd = SingerDay.sumdanbaizhi2;
		
		
		setBounds(100, 100, 801, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u6839\u636E\u60A8\u6B64\u65E5\u7684\u996E\u98DF\u60C5\u51B5\uFF0C\u505A\u51FA\u5982\u4E0B\u63A8\u8350\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setBounds(23, 10, 252, 26);
		contentPane.add(lblNewLabel);
		
		 lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(33, 46, 207, 26);
		contentPane.add(lblNewLabel_1);
		
		label = new JLabel("New label");
		label.setBounds(23, 190, 231, 26);
		contentPane.add(label);
		
		label_1 = new JLabel("New label");
		label_1.setBounds(266, 46, 207, 26);
		contentPane.add(label_1);
		
		label_2 = new JLabel("New label");
		label_2.setBounds(266, 190, 207, 26);
		contentPane.add(label_2);
		
		label_3 = new JLabel("New label");
		label_3.setBounds(568, 46, 207, 26);
		contentPane.add(label_3);
		
		
		
		
		
				//蛋白质 70g
				//脂肪100g
				//碳水化合物300g
				//维生素1g
				//无机盐20g
			if(ss<300){
					lblNewLabel_1.setText("碳水化合物摄入偏少,推荐菜系");
					String columnNames[] = {"菜系编号","菜系名称","含糖量"};
					Connection conn = null;
					PreparedStatement ps =null;
					ResultSet rs = null;
					try {
						conn = JDBC_Ui.getConnection();
						String sql ="select * from cai where suger<?";
						ps = conn.prepareStatement(sql);
						ps.setInt(1,4);
						rs = ps.executeQuery();
						int count =0;
						while(rs.next()){
							count++;
						}
						rowData=new Object[count][3];
						 count=0;
						 rs = ps.executeQuery();
						while(rs.next()){
							rowData[count][0]=rs.getInt("id");
							rowData[count][1]=rs.getString("cainame");
							rowData[count][2]=rs.getString("suger");
							count++;
						}
						conn.close();
						ps.close();
						rs.close();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				  
					JScrollPane scrollPane = new JScrollPane();
					 scrollPane.setBounds(23, 87, 182, 93);
					 getContentPane().add(scrollPane);
					
					 JTable table_1=new JTable(rowData,columnNames);
					 scrollPane.setViewportView(table_1);
					
	}

				if(ss>300){
					lblNewLabel_1.setText("碳水化合物摄入偏少,推荐菜系");
					String columnNames[] = {"菜系编号","菜系名称","含糖量"};
					
					Connection conn = null;
					PreparedStatement ps =null;
					ResultSet rs = null;
					
					try {
						conn = JDBC_Ui.getConnection();
						String sql ="select * from cai where suger>?";
						ps = conn.prepareStatement(sql);
						ps.setInt(1,50);
						rs = ps.executeQuery();
						int count =0;
						while(rs.next()){
							count++;
						}
						rowData=new Object[count][3];
						 count=0;
						 rs = ps.executeQuery();
						while(rs.next()){
							rowData[count][0]=rs.getInt("id"); //
							rowData[count][1]=rs.getString("cainame");
							rowData[count][2]=rs.getString("suger");
							count++;
						}
						conn.close();
						ps.close();
						rs.close();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				  
					JScrollPane scrollPane = new JScrollPane();
					 scrollPane.setBounds(23, 87, 182, 93);
					 getContentPane().add(scrollPane);
					
					 JTable table_1=new JTable(rowData,columnNames);
					 scrollPane.setViewportView(table_1);
				}
			
				if(oo<100){
					label.setText("您的脂质内摄入量缺少，推荐菜系");
					String columnNames2[] = {"菜系编号","菜系名称","脂质量"};
					Connection conn2 = null;
					PreparedStatement ps2 =null;
					ResultSet rs2 = null;
					
					try {
						conn2 = JDBC_Ui.getConnection();
						String sql2 ="select * from cai where oil>?";
						ps2 = conn2.prepareStatement(sql2);
						ps2.setInt(1,30);
						rs2 = ps2.executeQuery();
						int count =0;
						while(rs2.next()){
							count++;
						}
						rowData2=new Object[count][3];
						 count=0;
						 rs2 = ps2.executeQuery();
						while(rs2.next()){
							rowData2[count][0]=rs2.getInt("id");
							rowData2[count][1]=rs2.getString("cainame");
							rowData2[count][2]=rs2.getString("oil");
							count++;
						}
						conn2.close();
						ps2.close();
						rs2.close();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
					JScrollPane scrollPane2 = new JScrollPane();
					 scrollPane2.setBounds(23, 242, 173, 92);
					 getContentPane().add(scrollPane2);
					
					 JTable table_2=new JTable(rowData2,columnNames2);
					 scrollPane2.setViewportView(table_2);
					
				}
				
				if(oo>100){
					label.setText("您的脂质内摄入量过多，不推荐菜系");
					String columnNames2[] = {"菜系编号","菜系名称","含糖量"};
					
					Connection conn2 = null;
					PreparedStatement ps2 =null;
					ResultSet rs2 = null;
					
					try {
						conn2 = JDBC_Ui.getConnection();
						String sql2 ="select * from cai where oil>?";
						ps2 = conn2.prepareStatement(sql2);
						ps2.setInt(1,30);
						rs2 = ps2.executeQuery();
						int count2 =0;
						while(rs2.next()){
							count2++;
						}
						rowData2=new Object[count2][3];
						 count2=0;
						 rs2 = ps2.executeQuery();
						while(rs2.next()){
							rowData2[count2][0]=rs2.getInt("id"); //
							rowData2[count2][1]=rs2.getString("cainame");
							rowData2[count2][2]=rs2.getString("oil");
							count2++;
						}
						conn2.close();
						ps2.close();
						rs2.close();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				  
					JScrollPane scrollPane2 = new JScrollPane();
					 scrollPane2.setBounds(23, 242, 173, 92);
					 getContentPane().add(scrollPane2);
					
					 JTable table_2=new JTable(rowData2,columnNames2);
					 scrollPane2.setViewportView(table_2);
				}
				if(dd>70){
					label_1.setText("蛋白质摄入偏多,不推荐菜系");
					String columnNames3[] = {"菜系编号","菜系名称","蛋白质"};
					
					Connection conn3 = null;
					PreparedStatement ps3=null;
					ResultSet rs3 = null;
					
					try {
						conn3 = JDBC_Ui.getConnection();
						String sql3 ="select * from cai where danbaizhi>?";
						ps3 = conn3.prepareStatement(sql3);
						ps3.setInt(1,30);
						rs3 = ps3.executeQuery();
						int count3 =0;
						while(rs3.next()){
							count3++;
						}
						rowData3=new Object[count3][3];
						 count3=0;
						 rs3 = ps3.executeQuery();
						while(rs3.next()){
							rowData3[count3][0]=rs3.getInt("id"); 
							rowData3[count3][1]=rs3.getString("cainame");
							rowData3[count3][2]=rs3.getString("danbaizhi");
							count3++;
						}
						conn3.close();
						ps3.close();
						rs3.close();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				  
					JScrollPane scrollPane3 = new JScrollPane();
					 scrollPane3.setBounds(237, 87, 182, 93);
					 getContentPane().add(scrollPane3);
					
					 JTable table_3=new JTable(rowData3,columnNames3);
					 scrollPane3.setViewportView(table_3);
					
				}
				if(dd<70){
					label_1.setText("蛋白质摄入偏少,推荐菜系");
					String columnNames3[] = {"菜系编号","菜系名称","蛋白质量"};
					
					Connection conn3 = null;
					PreparedStatement ps3=null;
					ResultSet rs3 = null;
					
					try {
						conn3 = JDBC_Ui.getConnection();
						String sql3 ="select * from cai where danbaizhi>?";
						ps3 = conn3.prepareStatement(sql3);
						ps3.setInt(1,30);
						rs3 = ps3.executeQuery();
						int count3 =0;
						while(rs3.next()){
							count3++;
						}
						rowData3=new Object[count3][3];
						 count3=0;
						 rs3 = ps3.executeQuery();
						while(rs3.next()){
							rowData3[count3][0]=rs3.getInt("id"); //
							rowData3[count3][1]=rs3.getString("cainame");
							rowData3[count3][2]=rs3.getString("danbaizhi");
							count3++;
						}
						conn3.close();
						ps3.close();
						rs3.close();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				  
					JScrollPane scrollPane3 = new JScrollPane();
					 scrollPane3.setBounds(237, 87, 182, 93);
					 getContentPane().add(scrollPane3);
					
					 JTable table_3=new JTable(rowData3,columnNames3);
					 scrollPane3.setViewportView(table_3);
					
				}
				
				if(wei>5){
					label_2.setText("摄入的维生素过多，不推荐菜系");
					String columnNames4[] = {"菜系编号","菜系名称","维生素"};
					Connection conn4 = null;
					PreparedStatement ps4 =null;
					ResultSet rs4 = null;
					
					try {
						conn4 = JDBC_Ui.getConnection();
						String sql4 ="select * from cai where weishengsu>?";
						ps4 = conn4.prepareStatement(sql4);
						ps4.setInt(1,2);
						rs4 = ps4.executeQuery();
						int count4 =0;
						while(rs4.next()){
							count4++;
						}
						rowData4=new Object[count4][3];
						 count4=0;
						 rs4 = ps4.executeQuery();
						while(rs4.next()){
							rowData4[count4][0]=rs4.getInt("id"); //
							rowData4[count4][1]=rs4.getString("cainame");
							rowData4[count4][2]=rs4.getString("weishengsu");
							count4++;
						}
						conn4.close();
						ps4.close();
						rs4.close();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					JScrollPane scrollPane4 = new JScrollPane();
					 scrollPane4.setBounds(237, 240, 182, 93);
					 getContentPane().add(scrollPane4);
					
					 JTable table_4=new JTable(rowData4,columnNames4);
					 scrollPane4.setViewportView(table_4);
				}
				if(wei<5){
					label_2.setText("摄入的维生素过少，建议菜系");
					String columnNames4[] = {"菜系编号","菜系名称","维生素量"};
					Connection conn4 = null;
					PreparedStatement ps4 =null;
					ResultSet rs4 = null;
					
					try {
						conn4 = JDBC_Ui.getConnection();
						String sql4 ="select * from cai where weishengsu>?";
						ps4 = conn4.prepareStatement(sql4);
						ps4.setInt(1,2);
						rs4 = ps4.executeQuery();
						int count4 =0;
						while(rs4.next()){
							count4++;
						}
						rowData4=new Object[count4][3];
						 count4=0;
						 rs4 = ps4.executeQuery();
						while(rs4.next()){
							rowData4[count4][0]=rs4.getInt("id"); //
							rowData4[count4][1]=rs4.getString("cainame");
							rowData4[count4][2]=rs4.getString("weishengsu");
							count4++;
						}
						conn4.close();
						ps4.close();
						rs4.close();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					JScrollPane scrollPane4 = new JScrollPane();
					 scrollPane4.setBounds(237, 240, 182, 93);
					 getContentPane().add(scrollPane4);
					
					 JTable table_4=new JTable(rowData4,columnNames4);
					 scrollPane4.setViewportView(table_4);
				}
				
				if(ww<20){
					label_3.setText("无机盐摄入偏少,推荐菜系");
					String columnNames5[] = {"菜系编号","菜系名称","无机盐量"};
					
					Connection conn5 = null;
					PreparedStatement ps5=null;
					ResultSet rs5 = null;
					
					try {
						conn5 = JDBC_Ui.getConnection();
						String sql5 ="select * from cai where wujiyan>?";
						ps5 = conn5.prepareStatement(sql5);
						ps5.setInt(1,10);
						rs5 = ps5.executeQuery();
						int count5 =0;
						while(rs5.next()){
							count5++;
						}
						rowData5=new Object[count5][3];
						 count5=0;
						 rs5 = ps5.executeQuery();
						while(rs5.next()){
							rowData5[count5][0]=rs5.getInt("id"); //
							rowData5[count5][1]=rs5.getString("cainame");
							rowData5[count5][2]=rs5.getString("wujiyan");
							count5++;
						}
						conn5.close();
						ps5.close();
						rs5.close();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				  
					JScrollPane scrollPane5 = new JScrollPane();
					 scrollPane5.setBounds(501, 87, 182, 93);
					 getContentPane().add(scrollPane5);
					
					 JTable table_5=new JTable(rowData5,columnNames5);
					 scrollPane5.setViewportView(table_5);
					
				}
				if(ww>20){
					label_3.setText("无机盐摄入偏多,不推荐菜系");
            String columnNames5[] = {"菜系编号","菜系名称","无机盐"};
					
					Connection conn5 = null;
					PreparedStatement ps5=null;
					ResultSet rs5 = null;
					
					try {
						conn5 = JDBC_Ui.getConnection();
						String sql5 ="select * from cai where wujiyan>?";
						ps5 = conn5.prepareStatement(sql5);
						ps5.setInt(1,10);
						rs5 = ps5.executeQuery();
						int count5 =0;
						while(rs5.next()){
							count5++;
						}
						rowData5=new Object[count5][3];
						 count5=0;
						 rs5 = ps5.executeQuery();
						while(rs5.next()){
							rowData5[count5][0]=rs5.getInt("id"); //
							rowData5[count5][1]=rs5.getString("cainame");
							rowData5[count5][2]=rs5.getString("wujiyan");
							count5++;
						}
						conn5.close();
						ps5.close();
						rs5.close();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				  
					JScrollPane scrollPane5 = new JScrollPane();
					 scrollPane5.setBounds(501, 87, 182, 93);
					 getContentPane().add(scrollPane5);
					
					 JTable table_5=new JTable(rowData5,columnNames5);
					 scrollPane5.setViewportView(table_5);
					
					
				}
		}
}
