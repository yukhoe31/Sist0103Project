package day0118;

import java.awt.Color;

import javax.swing.JFrame;

public class L01_SwingGibon extends JFrame{
	
	//아래 main함수의 title인 "스윙기본★" 이 아래 title로 들어간다.
	//따라서 main함수에서 객체생성이 되면서 동시에
	//아래 생성자 내의 String title에 "스윙기본*"이 들어가면,
	//JFrame으로부터 상속받은 내용에 String title을 집어넣어서 생성한다.
	
	public L01_SwingGibon(String title) {
		
		super(title);
		
		//시작위치, 너비, 높이
		this.setBounds(500, 100, 300, 300);
		
		//배경색=>getContentPane()을 반드시 얻어야한다.
		//방법1.
		//this.getContentPane().setBackground(Color.CYAN);//static상수를 이용한 색상
		//방법2.
		this.getContentPane().setBackground(new Color(188,240,207));//RGB컬러를 이용한 색상
		
		//프레임에 보이게
		this.setVisible(true);
		
	}	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new L01_SwingGibon("스윙기본★");
		
	}

}
