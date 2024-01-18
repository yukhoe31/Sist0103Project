package day0118;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class L07_SwingEvent extends JFrame{
	
	Container cp;
	JButton btn1, btn2;
	
	public L07_SwingEvent(String title) {
		
		super(title);	
		cp = this.getContentPane();
		
		this.setBounds(300,100,300,300);
		cp.setBackground(new Color(000,255,204));
		initDesign();
		this.setVisible(true);

	}
	
	public void initDesign() {
		
		//레이아웃의 종류:FlowLayout
		// Flow 레이아웃으로 버튼 2개 생성
		// 버튼색상 그레이로 변경, 버튼색상 그린으로 변경
		
		this.setLayout(new FlowLayout());
		
		btn1 = new JButton("◀");
		btn2 = new JButton("▶");
		
		btn1.setBackground(Color.gray);
		btn2.setBackground(Color.green);
		
		this.add(btn1);
		this.add(btn2);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new L07_SwingEvent("버튼이벤트★7");
	}

}
