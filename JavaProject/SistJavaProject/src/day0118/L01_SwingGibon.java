package day0118;

import java.awt.Color;

import javax.swing.JFrame;

public class L01_SwingGibon extends JFrame{
	
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
