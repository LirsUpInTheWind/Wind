package tan.DemoUserUi;



import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Util.JDBC_Ui;

import tan.Demo.Ui.LoginUi;

import javax.swing.JTable;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;

public class miximixi extends JFrame {
	private float charge;
	private JTable table;
	public Object[][] rowData;
	public Object[][] rowData2;
	private String type,type1;//ʳƷ�����ѡ��
	private String countt;//ʳƷ������ѡ��
	private JTextField textField;//�ͻ������
	private JLabel lblNewLabel_11;//�ͻ���סʱ��
	private JLabel lblNewLabel_19;//��������������ֵ
	private JLabel lblNewLabel_21,label_1;//���ѽ�ֵ 
	private JTable table_2;
	private JTable table_3;
	private JTable table_4;
	private JTextField textField_1;
	public String username;
	public int id;
	private JTextField textField_2;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					miximixi frame = new miximixi();
					frame.setTitle("����ϵͳ");
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
	public miximixi() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//���õ�����ڹر��޲���
		
	
		setTitle("\u70B9\u9910\u754C\u9762");
		
		getContentPane().setFont(new Font("����", Font.PLAIN, 14));
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 860, 469);
		
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
		 getContentPane().setLayout(null);
		 
		 JScrollPane scrollPane = new JScrollPane();
		 scrollPane.setBounds(24, 10, 543, 148);
		 getContentPane().add(scrollPane);
		 
		 JTable table_1=new JTable(rowData,columnNames);
		 scrollPane.setViewportView(table_1);
		 
		 JScrollPane scrollPane_1 = new JScrollPane();
		 scrollPane.setRowHeaderView(scrollPane_1);
		 
		 
		 JLabel lblNewLabel = new JLabel("\u9009\u62E9\u65E5\u671F\u987A\u5E8F\u67E5\u8BE2:");
		 lblNewLabel.setBounds(24, 196, 159, 15);
		 lblNewLabel.setFont(new Font("����", Font.PLAIN, 14));
		 getContentPane().add(lblNewLabel);
		 
		
	
		 //�ͻ���סʱ���ǩ
		 JLabel lblNewLabel_10 = new JLabel("\u70B9\u9910\u65F6\u95F4:");
		 lblNewLabel_10.setBounds(414, 289, 75, 15);
		 lblNewLabel_10.setFont(new Font("����", Font.PLAIN, 14));
		 getContentPane().add(lblNewLabel_10);
		 //�ͻ���סʱ�丳ֵ��ǩ
		  lblNewLabel_11 = new JLabel("");
		  lblNewLabel_11.setBounds(480, 289, 159, 15);
		 lblNewLabel_11.setFont(new Font("����", Font.PLAIN, 14));
		 getContentPane().add(lblNewLabel_11);
		 
		 JLabel lblNewLabel_14 = new JLabel("��ѡ��ʳƷ����:");
		 lblNewLabel_14.setBounds(414, 196, 120, 15);
		 lblNewLabel_14.setFont(new Font("����", Font.PLAIN, 14));
		 getContentPane().add(lblNewLabel_14);
		 //ʳƷ����ѡ���
		 JComboBox<String> comboBox = new JComboBox<String>();
		 comboBox.setBounds(530, 193, 65, 21);
		 	Connection conn2=null;
		 	PreparedStatement ps2 = null;
		 	ResultSet rs2 = null ;
			try {
				conn2 = JDBC_Ui.getConnection();
				String sql2 ="select * from cai";
				 ps2 = conn2.prepareStatement(sql2);
				 rs2 = ps2.executeQuery();
				while(rs2.next()){
					comboBox.addItem(String.valueOf(rs2.getInt("id")));
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				conn.close();
			    ps2.close();
				rs2.close();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		 getContentPane().add(comboBox);
		
		 //ȷ����ť����
		 JLabel lblNewLabel_15 = new JLabel("��ѡ��ʳƷ����:");
		 lblNewLabel_15.setBounds(414, 243, 120, 15);
		 lblNewLabel_15.setFont(new Font("����", Font.PLAIN, 14));
		 getContentPane().add(lblNewLabel_15);
		 
		 JComboBox<String> comboBox_1 = new JComboBox<String>();
		 comboBox_1.setBounds(544, 240, 40, 21);
		 comboBox_1.addItem("1"); comboBox_1.addItem("2");
		 comboBox_1.addItem("3"); comboBox_1.addItem("4");
		 getContentPane().add(comboBox_1);
		 JButton btnNewButton_1 = new JButton("\u786E\u5B9A\u70B9\u9910");
		 btnNewButton_1.setBounds(429, 401, 93, 23);
		 btnNewButton_1.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 type = comboBox.getSelectedItem().toString();
				 buy();
				
			 }
		 });
		 //����ť
		 btnNewButton_1.setFont(new Font("����", Font.PLAIN, 14));
		 getContentPane().add(btnNewButton_1);
		 //�˳���ť
		 JButton btnNewButton_2 = new JButton("�˳�");
		 btnNewButton_2.setBounds(546, 401, 93, 23);
		 btnNewButton_2.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		dispose();
			 	}
			 });
		 btnNewButton_2.setFont(new Font("����", Font.PLAIN, 14));
		 getContentPane().add(btnNewButton_2);
		 //�������Ʊ�ǩ
		 JLabel lblNewLabel_16 = new JLabel("\u7528\u6237:");
		 lblNewLabel_16.setBounds(609, 39, 65, 15);
		 lblNewLabel_16.setFont(new Font("����", Font.PLAIN, 14));
		 getContentPane().add(lblNewLabel_16);
		 //��������
		 JLabel lblNewLabel_18 = new JLabel("\u6027\u522B:");
		 lblNewLabel_18.setBounds(609, 87, 65, 15);
		 lblNewLabel_18.setFont(new Font("����", Font.PLAIN, 14));
		 getContentPane().add(lblNewLabel_18);
		 //����������ֵ
		 lblNewLabel_19 = new JLabel("");
		 lblNewLabel_19.setBounds(663, 87, 75, 15);
		 getContentPane().add(lblNewLabel_19);
		 //���ѽ��
		 JLabel lblNewLabel_20 = new JLabel("\u4E13\u4E1A:");
		 lblNewLabel_20.setBounds(609, 143, 65, 22);
		 lblNewLabel_20.setFont(new Font("����", Font.PLAIN, 14));
		 getContentPane().add(lblNewLabel_20);
		 //���ѽ���ǩ
		  lblNewLabel_21 = new JLabel("");
		  lblNewLabel_21.setBounds(663, 143, 139, 15);
		 getContentPane().add(lblNewLabel_21);
		 
		 
		 
		/* JComboBox<String> comboBox_2 = new JComboBox<String>();
		 comboBox_2.setBounds(139, 193, 114, 21);
		 
		 Connection conn4=null ;
		 	PreparedStatement ps4=null;
		 	ResultSet rs4 =null;
		 	 
		 try {
				conn4 = JDBC_Ui.getConnection();
			 	String sql2 ="select * from record";
				 ps4 = conn4.prepareStatement(sql2);
				 rs4 = ps4.executeQuery();
				while(rs4.next()){
					comboBox_2.addItem(rs4.getString("time"));
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		 try {
			conn4.close();
			ps4.close();
			rs4.close();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		 getContentPane().add(comboBox_2);
		 */
		 
		 
		 
		 JButton btnNewButton = new JButton("ȷ��");
		 btnNewButton.setBounds(263, 192, 93, 23);
		 //��ť�����¼�
		 btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// type1 = comboBox_2.getSelectedItem().toString();
				// query(type1);
				}
				
		});
		 getContentPane().add(btnNewButton);
		 	
		 
		 /*	String columnNames2[] = {"�û����","�û���","��ϵ���","��ϵ��","����ʱ��"};
			Connection conn3=null;
			PreparedStatement ps3 =null;
			ResultSet rs3 =null;
			try {
		 		conn3 =JDBC_Ui.getConnection();
				String sql3 ="select * from record";
				ps3= conn3.prepareStatement(sql3);
				rs3 = ps3.executeQuery();
				int count2 =0;
				while(rs3.next()){
					count2++;
				}
				rs3 = ps3.executeQuery();
				rowData2=new Object[count2][5]; //�������
				count2=0;
				while(rs3.next()){
					count2++;  
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				conn3.close();
				ps3.close();
				rs3.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/
		 
			
			
			textField_2 = new JTextField();
			textField_2.setText(LoginUi.username);
			textField_2.setBounds(653, 36, 66, 21);
			getContentPane().add(textField_2);
			textField_2.setColumns(10);
			
			JButton btnNewButton_4 = new JButton("����");
			btnNewButton_4.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String s = textField_2.getText();
					if(s==null){
						 JOptionPane.showMessageDialog(null, "���ֵ����Ϊ��", "��ʾ", JOptionPane.PLAIN_MESSAGE);
					}else{
					check2(s);
					query();
				}
				}
			});
			btnNewButton_4.setBounds(741, 35, 93, 23);
			getContentPane().add(btnNewButton_4);
			
			JLabel label = new JLabel("\u59D3\u540D:");
			label.setFont(new Font("����", Font.PLAIN, 14));
			label.setBounds(609, 118, 65, 15);
			getContentPane().add(label);
			
			label_1 = new JLabel("");
			label_1.setBounds(663, 118, 91, 15);
			getContentPane().add(label_1);
			
			JComboBox<String> comboBox_2 = new JComboBox<String>();
			comboBox_2.setBounds(144, 193, 109, 21);
			comboBox_2.addItem("ʱ�併��");
			comboBox_2.addItem("ʱ������");
			getContentPane().add(comboBox_2);
			
			
	}
	
	
	//query()
	public void query(){
		String columnNames2[] = {"�û����","�û���","��ϵ���","��ϵ��","����ʱ��"};
		Connection conn3=null;
		PreparedStatement ps3 =null;
		ResultSet rs3 =null;
		try {
	 		conn3 =JDBC_Ui.getConnection();
			String sql3 ="select * from record where id=?";
			ps3= conn3.prepareStatement(sql3);
			ps3.setInt(1, Integer.parseInt(textField_2.getText()));
			rs3 = ps3.executeQuery();
			int count2 =0;
			while(rs3.next()){
				count2++;
			}
			rs3 = ps3.executeQuery();
			rowData2=new Object[count2][5]; //�������
			count2=0;
			while(rs3.next()){
				rowData2[count2][0]=rs3.getInt("id");
				rowData2[count2][1]=rs3.getString("name"); //
				rowData2[count2][2]=rs3.getInt("caiid");
				rowData2[count2][3]=rs3.getString("cainame");
				rowData2[count2][4]=rs3.getString("time");
				count2++;  
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			conn3.close();
			ps3.close();
			rs3.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	 
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 227, 385, 193);
		getContentPane().add(scrollPane_2);
		
		table_4 = new JTable(rowData2,columnNames2);
		scrollPane_2.setViewportView(table_4);
		
		
	}
	
	
	//chack2
	public void check2(String a){
		Connection conn =null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		try {
			conn = JDBC_Ui.getConnection();
			String sql ="select * from user3 where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(a));
			rs = ps.executeQuery();
			if(rs.next()){
				 lblNewLabel_19.setText(rs.getString("sex"));
				 lblNewLabel_21.setText(rs.getString("majoy"));
				 label_1.setText(rs.getString("name"));
				 username = rs.getString("name");
			}else{
				 JOptionPane.showMessageDialog(null, "û�д�ͬѧ", "��ʾ", JOptionPane.PLAIN_MESSAGE);
			}
				
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		
	}
	

	
	//���򷽷�
	@SuppressWarnings("resource")
	public void buy(){
		//�õ���ѡ��ʳƷ
	String cainame1 =null;
		;
		Connection conn =null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		try {
			conn = JDBC_Ui.getConnection();
			String sql2="select * from cai where id=?";
			ps = conn.prepareStatement(sql2);
			ps.setInt(1, Integer.parseInt(type));
			rs = ps.executeQuery();
			if(rs.next()){
				cainame1 = rs.getString("cainame");
			}
			conn.close();
			ps.close();
			rs.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	try {
			conn = JDBC_Ui.getConnection();
			String sql ="insert into record values(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,Integer.parseInt(textField_2.getText()));
			ps.setString(2, label_1.getText());
			ps.setInt(3, Integer.parseInt(type));
			//���ղ˵ı���ҵ�����
			
			ps.setString(4,cainame1);
			SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
			String str=sdf2.format(new Date());
			ps.setString(5, str);
			ps.executeUpdate();
			lblNewLabel_11.setText(str); 
			 JOptionPane.showMessageDialog(null, "���óɹ�", "��ʾ", JOptionPane.PLAIN_MESSAGE);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
