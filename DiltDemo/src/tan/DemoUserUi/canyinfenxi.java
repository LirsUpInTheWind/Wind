package tan.DemoUserUi;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Util.JDBC_Ui;
import tan.Demo.Ui.LoginUi;
import tan.Demo.Ui.SystemUi;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;

public class canyinfenxi extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public Object[][] rowData,rowData1,rowData2,rowData3;
	private JTextField textField;
	private  JComboBox<String> comboBox_1;
	public static Object a;
	public static String c;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					canyinfenxi frame = new canyinfenxi();
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
	public canyinfenxi() {
		
	    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//设置点击窗口关闭无操作
	
		setBounds(100, 100, 762, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		 
		 JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		 lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		 lblNewLabel.setBounds(10, 10, 56, 15);
		 contentPane.add(lblNewLabel);
		 
		 textField = new JTextField();
		 textField.setText(LoginUi.username);
		 textField.setBounds(76, 7, 101, 21);
		 contentPane.add(textField);
		 textField.setColumns(10);
		 
		 JComboBox<String> comboBox = new JComboBox<String>();
		 comboBox.setFont(new Font("宋体", Font.PLAIN, 14));
		 comboBox.setBounds(10, 50, 93, 21);
		 comboBox.addItem("最近10次点菜"); 
		 comboBox.addItem("最近20次点菜"); 
		 comboBox.addItem("最近30次点菜");
		 contentPane.add(comboBox);
		 
		 JButton btnNewButton = new JButton("\u98DF\u7269\u8BB0\u5F55");
		 btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a = textField.getText();
				Object b = comboBox.getSelectedItem();
				if(a==null||!a.matches("[0-9]{1,9}")){
					 JOptionPane.showMessageDialog(null, "用户名输入有误", "提示", JOptionPane.PLAIN_MESSAGE);
				}else{ 
					if(b.equals("最近10餐")){
							tablemake(3);
						}else if(b.equals("最近20餐")){
							tablemake(7);
						}else{
							tablemake(30);
						}
					
				}
				
			}
		});
		 btnNewButton.setFont(new Font("宋体", Font.PLAIN, 14));
		 btnNewButton.setBounds(113, 49, 93, 23);
		 contentPane.add(btnNewButton);
		 
		 JLabel lblNewLabel_1 = new JLabel("\u5355\u5929\u5206\u6790\uFF1A");
	
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		 lblNewLabel_1.setBounds(10, 91, 70, 15);
		 contentPane.add(lblNewLabel_1);
		 
		 comboBox_1 = new JComboBox();
		  comboBox_1.setBounds(10, 150, 132, 21);
		 contentPane.add(comboBox_1);
		 
		 JButton btnNewButton_1 = new JButton("\u786E\u8BA4");
		 btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a =  comboBox_1.getSelectedItem();
				c = textField.getText();
				if(a==null){
					 JOptionPane.showMessageDialog(null, "时间未选择", "提示", JOptionPane.PLAIN_MESSAGE);
				}else{
				SingerDay b = new SingerDay();
				b.setVisible(true);
			}
				}
		});
		 btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 14));
		 btnNewButton_1.setBounds(145, 149, 93, 23);
		 contentPane.add(btnNewButton_1);
		 
		 JButton button = new JButton("\u65F6\u95F4\u5347\u5E8F\u6392\u5217");
		 button.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				String a = textField.getText();
				if(a==null||!a.matches("[0-9]{1,9}")){
					 JOptionPane.showMessageDialog(null, "用户名输入有误", "提示", JOptionPane.PLAIN_MESSAGE);
				}else{ 
					timeLed(a);
				}	
			}
		});
		 button.setFont(new Font("宋体", Font.PLAIN, 14));
		 button.setBounds(10, 117, 116, 23);
		 contentPane.add(button);
		
		
	}
	//表格生成方法，
	public void tablemake(int t){
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		String t1 = textField.getText();
		String columnNames[] = {"姓名","菜系编号","菜品名","食用时间"};
		try {
			conn = JDBC_Ui.getConnection();
			//默认升序
			String sql = "select * from record where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,Integer.valueOf(t1));
			rs = ps.executeQuery();
			int count =0;
			while(rs.next()){
				count++;
			}
			rs = ps.executeQuery();
			rowData=new Object[count][4]; //表格数据
			count=0;
			if(!rs.next()){
				JOptionPane.showMessageDialog(null, "用户不存在", "提示", JOptionPane.PLAIN_MESSAGE);
			}
			
		if(t==3){
			while(rs.next()&&count<10){
				rowData[count][0]=rs.getString("name"); //
				rowData[count][1]=rs.getInt("caiid");
				rowData[count][2]=rs.getString("cainame");
				rowData[count][3]=rs.getString("time");
				count++;
			}
		}else if(t==7){
			while(rs.next()&&count<20){
				rowData[count][0]=rs.getString("name"); //
				rowData[count][1]=rs.getInt("caiid");
				rowData[count][2]=rs.getString("cainame");
				rowData[count][3]=rs.getString("time");
				count++;
			}
		}else{
			while(rs.next()){
				rowData[count][0]=rs.getString("name"); //
				rowData[count][1]=rs.getInt("caiid");
				rowData[count][2]=rs.getString("cainame");
				rowData[count][3]=rs.getString("time");
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
		 scrollPane.setBounds(10, 195, 726, 188);
		 getContentPane().add(scrollPane);
		
		 JTable table_1=new JTable(rowData,columnNames);
		 scrollPane.setViewportView(table_1);
	}
	
	
	public void timeLed(String a){
	
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		String t1 = textField.getText();
		try {
			conn = JDBC_Ui.getConnection();
			String sql ="select time from record where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(t1));
			rs = ps.executeQuery();
			while(rs.next()){
				comboBox_1.addItem(rs.getString("time"));
				
			}
			conn.close();
			ps.close();
			rs.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	  
	}
	

	
	
}
