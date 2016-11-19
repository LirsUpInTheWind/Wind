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
		 this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//���õ�����ڹر��޲���
		
		
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
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 16));
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
	
	//��������
	
		//������ 70g
		//֬��100g
		//̼ˮ������300g
		//ά����1g
		//�޻���20g
		if(ss<300){
			textArea.setText("���յ�̼ˮ������������ƫ��,̼ˮ��������������ȱ�٣�������Ų�õ����ʹ��ܣ��Ӷ����������ʵ���Ҫ������ܣ�����"
					+ "������٣����������ͣ����ߺϳ�Ѫ�����������������շ�ˮ�ף�̼ˮ��������Ϊ���������������Ҫ�ı���Ӫ�����ʣ����������������������������");
		}
		if(ss>300){
			textArea.setText("���յ�̼ˮ����������ƫ�̰࣬˯������������࣬�������������֪�ķ��֣�ȣ�ݵȸ����ã��������ʳ�����׶������������������");
		}
		if(oo<100){
			textArea_1.setText("���յ�֬��������٣�֬���е�֬�������������ߴ�Ԫ��֮һ��֬��������������Ҫ��Դ���ֿ��԰�������ά���أ���֬�����ڹ�������");
		}
		if(oo>100){
			textArea_1.setText("���յ�֬��������࣬֬������Ĺ���������ɷ���֢����Ѫ֬����Ѫ�ǵȵ�");
		}
		if(dd>70){
			textArea_2.setText("���յ���������ƫ�ߣ���������ƫ�ߵĵ�����������ɿڳ���Ӱ�������������������࣬����θ�����⣬��������");
		}
		if(dd<70){
			textArea_2.setText("���յ�����������٣�����������ٵĵ����ʣ�����ٻ�����л�Ĵ����������������ë��ƶѪ�������ݣ������ٻ��ȣ���ʱ���ػ����������Ӫ����ˮ��");
		}
		
		if(wei>1){
			textArea_3.setText("ά�������������࣬����������ά���ز������ƻ��������������ڻ������ȶ����������ᷢ���ж���������ɸ�к��Ż�µȵ�");
		}
		if(wei<1){
			textArea_3.setText("ά�������������٣�����������ٵ�ά������������ڻ���ʧ����ȱ��ά����A1�����ҹä֢��B2��ȱʧ����ɽ�������ƶѪ�ȵ�");
		}
		if(ww<20){
			textArea_4.setText("�޻���������ȱ�����ᵼ���������ʧ�� ����ᵼ��ƶѪ ��ʱ������ɳ鴤");
		}
		if(ww>20){
			textArea_4.setText("�޻������볬�꣬���������з�ĸ��ʣ��ᵼ��Ѫ��ƫ�ߣ����־����ϰ�����Ѫ��֢�������������������ɼ�״���״� �����ᵼ�½����ж��ȵ�");
		}
	}
}
