package day0130;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
메인 인터페이스에서 "삭제"버튼 누르면
다이얼로그창이 나타난다.
String num = JOptionPane.showInputDialog("삭제할 시퀀스는?");

num을 호출한 삭제메서드의 인자값에 넣어준다.
*/

public class L01_DeleteStuInfo extends JFrame {
	
	Container cp;
	JButton btnDel;
	
	//생성자
	public L01_DeleteStuInfo(String title) {
		// TODO Auto-generated constructor stub
		
		super(title);	
		
		cp = this.getContentPane();
		this.setBounds(200,100,250,250);
		cp.setBackground(new Color(240,210,240));
		initDesign();
	}
	
	//디자인
	public void initDesign() {
		
		String num = JOptionPane.showInputDialog("삭제할 시퀀스는?");
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		
	}

}
