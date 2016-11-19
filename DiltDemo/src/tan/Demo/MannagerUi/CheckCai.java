package tan.Demo.MannagerUi;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.Scrollable;

import java.awt.Choice;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Button;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import Util.JDBC_Ui;


import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class CheckCai extends JFrame{
	private static final long serialVersionUID = -7437139956046676655L;
	public static void main(String[] args) {
		new CheckCai();
	}
	Container ct;
	//BackgroundPanel bgp;
	public Object[][] rowData;
	private JTable table;
	private JScrollPane scrollPane;
	public CheckCai() {
		setResizable(false);
		this.setTitle("查询");
		getContentPane().setFont(new Font("宋体", Font.PLAIN, 12));
		setAlwaysOnTop(true);
		this.setSize(601,519);//601,519
		this.setLocation(400,300);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		int windowWidth = this.getWidth();
	    int windowHeight = this.getHeight();
	    Toolkit kit = Toolkit.getDefaultToolkit();
	    Dimension screenSize = kit.getScreenSize();
	    int screenWidth = screenSize.width;
	    int screenHeight = screenSize.height;
	    this.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);
	    getContentPane().setLayout(null);
	    
	    Button button = new Button("糖类含量");
	    button.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		checksuger();
	    	}
	    });
	    button.setBounds(151, 386, 88, 44);
	    getContentPane().add(button);
	    
	    Button button_1 = new Button("油脂含量");
	    button_1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		Checkoil();
	    	}
	    });
	    button_1.setBounds(245, 386, 88, 44);
	    getContentPane().add(button_1);
	    
	    Button button_2 = new Button("蛋白质含量");
	    button_2.setBounds(339, 386, 88, 44);
	    getContentPane().add(button_2);
	    button_2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		Checkdanbaizhi();
	    	}
	    });
	    
	    Button button_3 = new Button("维生素含量");
	    button_3.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		Checkweishengsu();
	    	}
	    });
	    button_3.setBounds(57, 386, 88, 44);
	    getContentPane().add(button_3);
	    
	    Button button_4 = new Button("无机盐含量");
	    button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Checkwujiyan();
			}
		});
	    button_4.setBounds(57, 436, 88, 40);
	    getContentPane().add(button_4);
	    
	    Button button_8 = new Button("\u9000\u51FA");
	    button_8.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		dispose();
	    		//new SystemUi2();
	    	}
	    });
	    button_8.setBounds(445, 412, 99, 42);
	    getContentPane().add(button_8);
	    
	    JPanel panel_1 = new JPanel();
	    panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	    panel_1.setBounds(21, 20,550, 346);//550, 346
	    getContentPane().add(panel_1);
	    panel_1.setLayout(null);
	    
	    scrollPane = new JScrollPane();
	    scrollPane.setBounds(10, 10,530, 326);//530, 326
	    panel_1.add(scrollPane);
	    /*table.getColumnModel().getColumn(3).setCellRenderer(new TableCellRenderer(){
	    	public Component getTableCellRendererComponent(JTable table,
	    	Object value, boolean isSelected, boolean hasFocus,
	    	int row, int column) {
	    	JCheckBox ck = new JCheckBox();
	    	ck.setSelected(isSelected);
	    	ck.setHorizontalAlignment((int) 0.5f);
	    	return ck;
	    	}});*/
	}

	
	
	
	
	
	
	
	
	
	//按照糖类的查询
	public void checksuger(){
		String columnNames[] = {"糖类/毫克/份","食品编号","食品名称","油脂/毫克/份","蛋白质/毫克/份","维生素/毫克/份","无机盐/毫克/份"};
    	Connection conn = null;
    	PreparedStatement ps = null;
    	ResultSet rs = null;
 	 try {
 		 
		conn =JDBC_Ui.getConnection();
		String sql ="select * from cai order by suger desc";
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
			rowData[count][0]=rs.getString("suger");
			rowData[count][1]=rs.getInt("id");
			rowData[count][2]=rs.getString("cainame"); //
			rowData[count][3]=rs.getString("oil");
			rowData[count][4]=rs.getString("danbaizhi");
			rowData[count][5]=rs.getString("weishengsu");
			rowData[count][6]=rs.getString("wujiyan");
			
			count++;  
		}
	} catch (Exception e) {
		e.printStackTrace();
 	 }try {
		conn.close();
		ps.close();
		rs.close();
 	 } catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
 	table = new JTable(rowData,columnNames){
		private static final long serialVersionUID = -5138220304384254938L;
		public boolean isCellEditable(int rowIndex, int ColIndex){
			return false;
		}
	};
	table.getTableHeader().setReorderingAllowed(true);
	table.getTableHeader().setResizingAllowed(true);
	scrollPane.setViewportView(table);
	
	//table.getColumn("姓名").setMaxWidth(55);
	}

	
	
	//维生素的查询
	
	//按照糖类的查询
		public void Checkweishengsu(){
			String columnNames[] = {"维生素/毫克/份","食品编号","食品名称","油脂/毫克/份","蛋白质/毫克/份","糖类/毫克/份","无机盐/毫克/份"};
	    	Connection conn = null;
	    	PreparedStatement ps = null;
	    	ResultSet rs = null;
	 	 try {
	 		 
			conn =JDBC_Ui.getConnection();
			String sql ="select * from cai order by weishengsu desc";
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
				rowData[count][0]=rs.getString("weishengsu");
				rowData[count][1]=rs.getInt("id");
				rowData[count][2]=rs.getString("cainame"); //
				rowData[count][3]=rs.getString("oil");
				rowData[count][4]=rs.getString("danbaizhi");
				rowData[count][5]=rs.getString("suger");
				rowData[count][6]=rs.getString("wujiyan");
				
				count++;  
			}
		} catch (Exception e) {
			e.printStackTrace();
	 	 }try {
			conn.close();
			ps.close();
			rs.close();
	 	 } catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	 	table = new JTable(rowData,columnNames){
			private static final long serialVersionUID = -5138220304384254938L;
			public boolean isCellEditable(int rowIndex, int ColIndex){
				return false;
			}
		};
		table.getTableHeader().setReorderingAllowed(true);
		table.getTableHeader().setResizingAllowed(true);
		scrollPane.setViewportView(table);
		
		//table.getColumn("姓名").setMaxWidth(55);
		}

	
	//按照油脂的查询
		public void Checkoil(){
			String columnNames[] = {"油脂/毫克/份","食品编号","食品名称","维生素/毫克/份","蛋白质/毫克/份","糖类/毫克/份","无机盐/毫克/份"};
	    	Connection conn = null;
	    	PreparedStatement ps = null;
	    	ResultSet rs = null;
	 	 try {
	 		 
			conn =JDBC_Ui.getConnection();
			String sql ="select * from cai order by oil desc";
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
				rowData[count][0]=rs.getString("oil");
				rowData[count][1]=rs.getInt("id");
				rowData[count][2]=rs.getString("cainame"); //
				rowData[count][3]=rs.getString("weishengsu");
				rowData[count][4]=rs.getString("danbaizhi");
				rowData[count][5]=rs.getString("suger");
				rowData[count][6]=rs.getString("wujiyan");
				
				count++;  
			}
		} catch (Exception e) {
			e.printStackTrace();
	 	 }try {
			conn.close();
			ps.close();
			rs.close();
	 	 } catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	 	table = new JTable(rowData,columnNames){
			private static final long serialVersionUID = -5138220304384254938L;
			public boolean isCellEditable(int rowIndex, int ColIndex){
				return false;
			}
		};
		table.getTableHeader().setReorderingAllowed(true);
		table.getTableHeader().setResizingAllowed(true);
		scrollPane.setViewportView(table);
		
		//table.getColumn("姓名").setMaxWidth(55);
		}

	
	
	
	
	//蛋白质
		public void Checkdanbaizhi(){
			String columnNames[] = {"蛋白质/毫克/份","食品编号","食品名称","维生素/毫克/份","油脂/毫克/份","糖类/毫克/份","无机盐/毫克/份"};
	    	Connection conn = null;
	    	PreparedStatement ps = null;
	    	ResultSet rs = null;
	 	 try {
	 		 
			conn =JDBC_Ui.getConnection();
			String sql ="select * from cai order by danbaizhi desc";
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
				rowData[count][0]=rs.getString("danbaizhi");
				rowData[count][1]=rs.getInt("id");
				rowData[count][2]=rs.getString("cainame"); //
				rowData[count][3]=rs.getString("weishengsu");
				rowData[count][4]=rs.getString("oil");
				rowData[count][5]=rs.getString("suger");
				rowData[count][6]=rs.getString("wujiyan");
				
				count++;  
			}
		} catch (Exception e) {
			e.printStackTrace();
	 	 }try {
			conn.close();
			ps.close();
			rs.close();
	 	 } catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	 	table = new JTable(rowData,columnNames){
			private static final long serialVersionUID = -5138220304384254938L;
			public boolean isCellEditable(int rowIndex, int ColIndex){
				return false;
			}
		};
		table.getTableHeader().setReorderingAllowed(true);
		table.getTableHeader().setResizingAllowed(true);
		scrollPane.setViewportView(table);
		
		//table.getColumn("姓名").setMaxWidth(55);
		}

	
	
	
	
	//按照蛋白质查询
		public void Checkwujiyan(){
			String columnNames[] = {"无机盐/毫克/份","食品编号","食品名称","维生素/毫克/份","油脂/毫克/份","糖类/毫克/份","蛋白质/毫克/份"};
	    	Connection conn = null;
	    	PreparedStatement ps = null;
	    	ResultSet rs = null;
	 	 try {
	 		 
			conn =JDBC_Ui.getConnection();
			String sql ="select * from cai order by wujiyan desc";
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
				rowData[count][0]=rs.getString("wujiyan");
				rowData[count][1]=rs.getInt("id");
				rowData[count][2]=rs.getString("cainame"); //
				rowData[count][3]=rs.getString("weishengsu");
				rowData[count][4]=rs.getString("oil");
				rowData[count][5]=rs.getString("suger");
				rowData[count][6]=rs.getString("danbaizhi");
				
				count++;  
			}
		} catch (Exception e) {
			e.printStackTrace();
	 	 }try {
			conn.close();
			ps.close();
			rs.close();
	 	 } catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	 	table = new JTable(rowData,columnNames){
			private static final long serialVersionUID = -5138220304384254938L;
			public boolean isCellEditable(int rowIndex, int ColIndex){
				return false;
			}
		};
		table.getTableHeader().setReorderingAllowed(true);
		table.getTableHeader().setResizingAllowed(true);
		scrollPane.setViewportView(table);
		
		//table.getColumn("姓名").setMaxWidth(55);
		}

	
	
	//在店宾客查
	public void queryCurrentMessege(){
		String[] columnNames={"客户ID","客户姓名","客户性别","房间号","房间等级","入住时间","客户电话"}; // 列名
    	Connection conn = null;
    	PreparedStatement ps = null;
    	ResultSet rs = null;
 	 try {
 		 
		conn =JDBC_Ui.getConnection();
		String sql ="select * from room where customerid is not null";
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
			rowData[count][0]=rs.getString("customerid");
			rowData[count][1]=rs.getString("name"); //
			rowData[count][2]=rs.getString("sex"); 
			rowData[count][3]=rs.getInt("roomID"); 
			rowData[count][4]=rs.getString("leve"); 
			rowData[count][5]=rs.getString("tim");
			rowData[count][6]=rs.getLong("phone");
			
			count++;
		}
		
 	 } catch (Exception e) {
		e.printStackTrace();
 	 }try {
		conn.close();
		ps.close();
		rs.close();
 	 } catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
 	table = new JTable(rowData,columnNames){
		private static final long serialVersionUID = -5138220304384254938L;
		public boolean isCellEditable(int rowIndex, int ColIndex){
			return false;
		}
	};
	table.getTableHeader().setReorderingAllowed(true);
	table.getTableHeader().setResizingAllowed(true);
	scrollPane.setViewportView(table);
/*	table.getColumn("房间号").setMaxWidth(50);
	table.getColumn("房间等级").setMaxWidth(65);
	table.getColumn("客户姓名").setMaxWidth(55);
	table.getColumn("客户性别").setMaxWidth(50);
	table.getColumn("入住时间").setMaxWidth(150);*/
	table.getColumn("客户ID").setMaxWidth(150);
	}
	
}
	
	

//背景类
class BackgroundP8 extends JPanel {
	private static final long serialVersionUID = 591214718188546560L;
	Image im;
	public BackgroundP8(Image im) {
		this.im=im;
		this.setOpaque(true);
	}
	//Draw the back ground.
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);
		
	}
}
