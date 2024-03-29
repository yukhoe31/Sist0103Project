package day0118;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class L03_SwingLay extends JFrame{
	
	Container cp;
	JButton btn1;

	
	public L03_SwingLay(String title) {
		
		super(title);	
		
		cp = this.getContentPane();
		
		this.setBounds(300,100,300,300);
		cp.setBackground(new Color(000,255,204));
		
		//버튼생성
		btn1 = new JButton("버튼1");
		
		//프레임에 버튼 추가
		//프레임에 기본이 BorderLayout
		//이 경우는 위치지정필수
		
		this.add("North",btn1);//첫글자는 무조건 대문자
		
		this.add("South",new JButton("아래쪽"));
		
		this.add("East",new JButton("오른쪽"));
				
		this.add("West",new JButton("왼쪽"));
		
		this.add("Center", new JButton("가운데"));
		
		//버튼1에 속성추가
		btn1.setBackground(Color.YELLOW);//버튼1의 배경색
		btn1.setForeground(Color.GREEN);//버튼1의 글씨색
		
		this.setVisible(true);
		
	}

	public static void main(String[] args) {
		
		new L03_SwingLay("기본레이아웃");

	}

}
