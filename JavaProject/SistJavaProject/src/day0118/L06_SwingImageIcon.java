package day0118;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class L06_SwingImageIcon extends JFrame implements ActionListener{

	Container cp;
	
	//이미지 아이콘 가져온다.
	ImageIcon icon1 = new ImageIcon("C:\\sist0103\\image\\swingimage\\LEFT.gif");
	ImageIcon icon2 = new ImageIcon("C:\\sist0103\\image\\swingimage\\leftDown.gif");
	ImageIcon icon3 = new ImageIcon("C:\\sist0103\\image\\swingimage\\leftRollover.gif");
	ImageIcon icon4 = new ImageIcon("C:\\sist0103\\image\\swingimage\\chick.gif");
	ImageIcon icon5 = new ImageIcon("C:\\sist0103\\image\\swingimage\\img1.gif");
	
	JButton btn1,btn2,btn3,btn4;
	
	
	public L06_SwingImageIcon(String title) {
		// TODO Auto-generated constructor stub
		
		super(title);	
		cp = this.getContentPane();
		
		this.setBounds(300,100,300,300);
		cp.setBackground(new Color(000,255,204));
		initDesign();
		this.setVisible(true);
	}
	
	public void initDesign() {
		
		// 2행2열:레이아웃의 종류->GridLayout
		this.setLayout(new GridLayout(2,2));
		
		//버튼1
		btn1 = new JButton("hello", icon1);
		btn1.setHorizontalTextPosition(JButton.CENTER); //텍스트 가로방향
		btn1.setVerticalTextPosition(JButton.BOTTOM); //텍스트 세로위치
		this.add(btn1);
		
		btn1.setRolloverIcon(icon2); //버튼 위에 올리기만 해도 색 변환
		btn1.setPressedIcon(icon3); //버튼 클릭 시에 색 변환
			
		//버튼2
		btn2 = new JButton(icon4);
		this.add(btn2);
		
		//버튼3
		btn3 = new JButton("스윙버튼");
		this.add(btn3);
		
		//버튼4
		btn4 = new JButton("안녕", icon5);
		this.add(btn4);
		
		//
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob = e.getSource();
		
		if(ob == btn1) {
			JOptionPane.showMessageDialog(this, "버튼1을 클릭했습니다.");
		}else if(ob == btn2) {
			JOptionPane.showMessageDialog(this, "병아리를 클릭했습니다.");
		}else if(ob == btn3) {
			JOptionPane.showMessageDialog(this, "스윙버튼을 클릭했습니다.");
		}else if(ob == btn4) {
			JOptionPane.showMessageDialog(this, "안녕을 클릭했습니다.");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new L06_SwingImageIcon("이미지 버튼 ★ 6");
	}

}
