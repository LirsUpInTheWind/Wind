package tan.Demo.Ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Util.JDBC_Ui;
import tan.DemoUserUi.tuijian;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class zhuce extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private  JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					zhuce frame = new zhuce();
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
	public zhuce() {
		super();
		
	    setSize(521,316);
	    setTitle("注册");
	    
	    this.setVisible(true);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//设置点击窗口关闭无操作
		
	
		setBounds(100, 100, 480, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u4F60\u7684\u59D3\u540D:");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setBounds(37, 35, 105, 15);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u4F60\u7684\u5B66\u53F7:");
		label.setFont(new Font("宋体", Font.PLAIN, 14));
		label.setBounds(37, 71, 105, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u8BF7\u8F93\u5165\u4F60\u7684\u4E13\u4E1A:");
		label_1.setFont(new Font("宋体", Font.PLAIN, 14));
		label_1.setBounds(37, 113, 105, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u8BF7\u8BBE\u7F6E\u4F60\u7684\u5BC6\u7801:");
		label_2.setFont(new Font("宋体", Font.PLAIN, 14));
		label_2.setBounds(37, 149, 105, 15);
		contentPane.add(label_2);
		
		textField = new JTextField();
		textField.setBounds(172, 32, 122, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(172, 68, 122, 21);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(172, 110, 122, 21);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(172, 146, 122, 21);
		contentPane.add(textField_3);
		
		JButton btnNewButton = new JButton("\u6CE8\u518C"); 
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				zhuceMain();
			}
		});
		
		btnNewButton.setBounds(47, 210, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("\u6E05\u7A7A");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
			}
		});
		button.setBounds(187, 210, 93, 23);
		contentPane.add(button);
		
		JLabel lblNewLabel_1 = new JLabel("\u6027\u522B");
		lblNewLabel_1.setBounds(341, 35, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		 comboBox = new JComboBox();
		 comboBox.addItem("男");
		 comboBox.addItem("女");
		comboBox.setBounds(351, 68, 44, 21);
		contentPane.add(comboBox);
	}
	public void zhuceMain(){
		String t1  =textField.getText();
		String t2  =textField_1.getText();
		String t3  =textField_2.getText();
		String t4  =textField_3.getText();
		if(t1.length()==0&&t1.matches("[0-9]{1,10}")){
			JOptionPane.showMessageDialog(null, "姓名输入有误！", "提示", JOptionPane.PLAIN_MESSAGE);
		}else if(t2.length()==0&&!t2.matches("[0-9]{1,10}")){
			JOptionPane.showMessageDialog(null, "学号输入有误", "提示", JOptionPane.PLAIN_MESSAGE);
		}else if(t3.length()==0){
			JOptionPane.showMessageDialog(null, "专业输入有误！", "提示", JOptionPane.PLAIN_MESSAGE);
		}else if(t4.length()==0&&!t1.matches("[0-9]{1,10}")){
			JOptionPane.showMessageDialog(null, "密码输入有误！", "提示", JOptionPane.PLAIN_MESSAGE);
		}else{
		Connection conn =null;
		PreparedStatement ps=null;
		ResultSet rs =null;
		try {
			conn = JDBC_Ui.getConnection();
			String sql = "select * from user3 where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(t2));
			rs = ps.executeQuery();
			if(rs.next()){
				JOptionPane.showMessageDialog(null, "已存在此学号", "提示", JOptionPane.PLAIN_MESSAGE);
			}else{
				String sql2 = "insert into user3 (id,name,sex,majoy,password) values(?,?,?,?,?)";
				ps = conn.prepareStatement(sql2);
				ps.setInt(1,Integer.parseInt(t2));
				ps.setString(2,t1);
				ps.setString(3,String.valueOf(comboBox.getSelectedItem()));
				ps.setString(4,t3);
				ps.setInt(5,Integer.parseInt(t4));
				ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "注册成功", "提示", JOptionPane.PLAIN_MESSAGE);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
}
