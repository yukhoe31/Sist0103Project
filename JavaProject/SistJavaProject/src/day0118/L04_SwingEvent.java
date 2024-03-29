package day0118;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class L04_SwingEvent extends JFrame implements ActionListener {

	Container cp;
	JButton btn1,btn2,btn3;

	public L04_SwingEvent(String title) {

		super(title);	
		cp = this.getContentPane();

		//this.setBounds(EXIT_ON_CLOSE, ABORT, WIDTH, HEIGHT);
		this.setBounds(300,100,300,300);
		cp.setBackground(new Color(000,255,204));
		
		initDesign();		
		this.setVisible(true);
	}
	
	public void initDesign() {
		
		//Layout의 종류: FlowLayout()
		//레이아웃 변경
		this.setLayout(new FlowLayout());
		
		//버튼 3개 생성
		btn1 = new JButton("버튼 #1");
		btn2 = new JButton("버튼 #2");
		btn3 = new JButton("버튼 #3");
		
		//버튼 배경색 바꾸기
		btn1.setBackground(Color.PINK);
		btn2.setBackground(Color.lightGray);
		btn3.setBackground(Color.orange);
		
		//버튼에 이벤트 발생/.. 이벤트 핸들러와 이벤트 발생객체 연결
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		
		//프레임에 추가
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		
	
	}
	
	
	//implements ActionListener 위에 있는 이 구문 덕분에
	//여기 위에서 아래 내용을 가져온 것이다.
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Object ob = e.getSource(); 
		//버튼의 어떤 메서드 호출인지 정확히 지정해주세요.
		
		//메세지를 다이얼로그형태로 보여준다.
		//JOptionPane.showMessageDialog(this, "버튼클릭!!!");
		
		//버튼마다 다른 메세지 출력하려면?
		if(ob==btn1) {
			JOptionPane.showMessageDialog(this, "1번째 버튼 클릭");
		}else if(ob==btn2) {
			JOptionPane.showMessageDialog(this, "2번째 버튼 클릭");
		}else if(ob==btn3) {
			JOptionPane.showMessageDialog(this, "3번째 버튼 클릭");
		}
		
	}

	

	public static void main(String[] args) {
		
		new L04_SwingEvent("버튼★이벤트");
		
	}

	
}
