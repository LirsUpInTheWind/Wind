package tan.DemoUserUi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class Result extends JFrame {

	private JPanel contentPane;
	public int ss;
	public int oo;
	public int ww;
	public int wei;
	public int dd;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JScrollPane scrollPane_1;
	private JTextArea textArea_1;
	
	private JTextArea textArea_2;
	private JScrollPane scrollPane_3;
	private JTextArea textArea_3;
	private JScrollPane scrollPane_4;
	private JTextArea textArea_4;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Result frame = new Result();
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
	public Result() {
		 this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//设置点击窗口关闭无操作
		
		
		ss = SingerDay.sumsuger2;
		oo = SingerDay.sumoil2;
		ww = SingerDay.sumwujiyan2;
		wei = SingerDay.sumweishengsu2;
		dd = SingerDay.sumdanbaizhi2;
		
		setBounds(100, 100, 643, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7CFB\u7EDF\u5206\u6790:");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel.setBounds(20, 22, 92, 19);
		contentPane.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(102, 51, 440, 73);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(102, 125, 440, 73);
		contentPane.add(scrollPane_1);
		
		textArea_1 = new JTextArea();
		textArea_1.setLineWrap(true);;
		scrollPane_1.setViewportView(textArea_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(102, 197, 440, 73);
		contentPane.add(scrollPane_2);
		
		textArea_2 = new JTextArea();
		textArea_2.setLineWrap(true);
		scrollPane_2.setViewportView(textArea_2);
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(102, 268, 440, 74);
		contentPane.add(scrollPane_3);
		
		textArea_3 = new JTextArea();
		textArea_3.setLineWrap(true);;
		scrollPane_3.setViewportView(textArea_3);
		
		scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(102, 0, 440, 51);
		contentPane.add(scrollPane_4);
		
		textArea_4 = new JTextArea();
		textArea_4.setLineWrap(true);
		scrollPane_4.setViewportView(textArea_4);
		
		JButton btnNewButton = new JButton("\u63A8\u8350\u7CFB\u7EDF");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tuijian t = new tuijian();
				t.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 65, 93, 23);
		contentPane.add(btnNewButton);
	
	//分析方法
	
		//蛋白质 70g
		//脂肪100g
		//碳水化合物300g
		//维生素1g
		//无机盐20g
		if(ss<300){
			textArea.setText("此日的碳水化化合物摄入偏少,碳水化合物在身体内缺少，机体便会挪用蛋白质功能，从而消弱蛋白质的重要审理机能，例如"
					+ "抗体减少，抗病力降低，或者合成血浆蛋白能力减弱，诱发水肿，碳水化合物作为我们人体机能所需要的必须营养物质，对体格发育与智力发育有严重作用");
		}
		if(ss>300){
			textArea.setText("次日的碳水化和无摄入偏多，贪睡化合物摄入过多，容易造成人们熟知的肥胖，龋齿等副作用，过多的糖食还容易对身体造成免疫力削减");
		}
		if(oo<100){
			textArea_1.setText("此日的脂质摄入过少，脂质中的脂肪是人体必须的七大元素之一，脂肪既是热量的主要来源，又可以帮助吸收维生素，若脂肪长期供给不足");
		}
		if(oo>100){
			textArea_1.setText("此日的脂质摄入过多，脂质摄入的过多容易造成肥胖症，高血脂，高血糖等等");
		}
		if(dd>70){
			textArea_2.setText("此日蛋白质摄入偏高，长期摄入偏高的蛋白质容易造成口臭，影响自身情绪，损伤肾脏，引起肠胃道问题，体重增加");
		}
		if(dd<70){
			textArea_2.setText("次日蛋白质摄入过少，长期摄入过少的蛋白质，会减少基础代谢的次数，还会伴随着脱毛，贫血明显消瘦，生长迟缓等，有时严重患者容易造成营养性水肿");
		}
		
		if(wei>1){
			textArea_3.setText("维生素摄入量过多，过量的摄入维生素不仅会破坏人体生长发育内环境的稳定，甚至还会发生中毒，容易造成腹泻，呕吐等等");
		}
		if(wei<1){
			textArea_3.setText("维生素摄入量多少，长期摄入过少的维生素容易造成内环境失调，缺少维生素A1会造成夜盲症，B2的缺失会造成脚气病，贫血等等");
		}
		if(ww<20){
			textArea_4.setText("无机盐摄入量缺乏，会导致体内酸碱失衡 另外会导致贫血 有时还会造成抽搐");
		}
		if(ww>20){
			textArea_4.setText("无机盐摄入超标，容易增加中风的概率，会导致血钙偏高，出现精神障碍，高血钾症，如果碘摄入增多已造成甲状腺肿大 甚至会导致金属中毒等等");
		}
	}
}
