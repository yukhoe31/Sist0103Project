package day0112;

//다른 패키지에서 받아온다.(import)
//SWING으로 안드로이드를 간접체험이 가능하다.
//익명내부 클래스 방식
//메서드 방식
//SWING 3-4일 정도 들여서 배울 예정.
//생성개념 


import javax.swing.JFrame;

public class SwingFrame extends JFrame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingFrame sw = new SwingFrame();
	
	}
	
	public SwingFrame() {
		// TODO Auto-generated constructor stub
		super("프레임연습");
		this.setBounds(300, 100, 300, 300);
		this.setVisible(true);
		
	}

}
