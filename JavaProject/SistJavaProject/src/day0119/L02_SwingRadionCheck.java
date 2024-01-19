package day0119;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class L02_SwingRadionCheck extends JFrame implements ActionListener{

	Container cp;
	//라디오버튼 : 여러개 중 하나만 선택할 때
	JRadioButton [] rb = new JRadioButton[4]; 
	//체크박스 : 여러개 중 여러개 선택할 때
	JCheckBox [] cb = new JCheckBox[4];
	
	Color [] colors = {Color.RED, Color.GREEN, Color.MAGENTA, Color.CYAN};
	//글씨 쓰기(라벨링)
	JLabel lblMessage;
	
	public L02_SwingRadionCheck() {
		
		super("스윙 라디오 체크박스 ★ 2");	
		cp = this.getContentPane();
	
		this.setBounds(300,100,500,500);
		cp.setBackground(new Color(194,212,221));
		initDesign();
		this.setVisible(true);
		
	}
	
	public void initDesign() {
		
		//상단패널 보더로 감싼 4개의 라디오버튼
		String [] str1 = {"Red","Green","핫핑크","연파랑"};
		JPanel pTop = new JPanel();
		pTop.setBorder(new TitledBorder("글자색"));
		this.add("North", pTop);
		
		//라디오버튼 하나만 선택되도록 하려면 그룹을 지어줘야함
		ButtonGroup bg = new ButtonGroup();
		
		for(int i =0; i<rb.length; i++) {
			
			//라디오 버튼 생성(텍스트, 기본체크)//여기서는 i==2가 기본이다.
			rb[i] = new JRadioButton(str1[i], i==2?true:false);
			pTop.add(rb[i]); //탑패널에 추가
			bg.add(rb[i]); //버튼 그룹에 추가
			rb[i].addActionListener(this); //액션 추가

		}
		
		//가운데 라벨
		lblMessage = new JLabel("안녕하세요~~즐거운 금요일", JLabel.CENTER);
		this.add("Center", lblMessage);
		lblMessage.setBorder(new LineBorder(Color.RED, 3));	//라인굵기	
	
		//하단패널에 보더로 감싼 4개의 체크박스
		JPanel pBottom = new JPanel();
		pBottom.setBorder(new TitledBorder("가능언어"));
		this.add("South", pBottom);
		
		String [] str2 = {"자바", "오라클", "HTML", "JSP"};
		
		for(int i=0; i<cb.length; i++) {
			
			cb[i] = new JCheckBox(str2[i]);
			pBottom.add(cb[i]);
			
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob = e.getSource();
		
		//라디오버튼 호출처리, 메세지 출력이 컬러별로 출력되도록
		for(int i=0; i<rb.length; i++) {
			if(ob == rb[i]) {
	
				//라디오 버튼 누르면 lblMessage의 색이 달라진다.
				lblMessage.setForeground(colors[i]);
				//라디오 버튼 누르면 lblMessage의 Font도 달라진다.
				lblMessage.setFont(new Font("",Font.BOLD,22));
				
				this.setTitle("라디오버튼 색: "+colors[i]);
			}
		}
		
		
		//체크박스 호출처리(다중선택: 자바 JSP)
		String msg = "";
		
		for(int i=0; i<cb.length; i++) {
			if(cb[i].isSelected() ==true) {
				msg+= cb[i].getText() +" ";
			}
		}
		lblMessage.setText(msg);
		lblMessage.setFont(new Font("",Font.BOLD,22));
		
		
	}
	

	
	public static void main(String[] args) {
		
		new L02_SwingRadionCheck();
	}

}
