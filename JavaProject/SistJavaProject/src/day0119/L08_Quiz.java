package day0119;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

/*
[0119 주말 과제물]

체크박스 남자    
라디오버튼: 색깔 3개를 배치한다  (타이블보더: 색상)
체크박스: 나라 4개국가 배치한다 (타이틀보더: 내가가본나라 )


아래부분에 메세지 결과 를 배치한후 출력한다


남자 체크를 누르면 결과창에
남자입니다...풀면 여자입니다
색상을 누르면 현재결과창의 색상이 바뀝니다
체크박스 누르면
내가 가본나라는 [이탈리아] [미국] 입니다
아무것도 체크 안할시
내가 가본나라는 없습니다

*/


public class L08_Quiz extends JFrame implements ActionListener,ItemListener{
	
	Container cp;
	JCheckBox cbMale;
	JCheckBox [] cbCountry = new JCheckBox[4];
	JRadioButton [] rb = new JRadioButton[3];
	
	
	Color [] colors = {Color.RED, Color.GREEN, Color.YELLOW};
	
	
	public L08_Quiz(String title) {
		// TODO Auto-generated constructor stub
		super(title);	
		cp = this.getContentPane();
		
		this.setBounds(300,100,500,500);
		cp.setBackground(new Color(221,200,245));
		
		initDesign();
		this.setVisible(true);
	}
	
	public void initDesign() {
		// TODO Auto-generated method stub\
		this.setLayout(null);
		
		//남자 체크박스
		cbMale = new JCheckBox("남성");
		cbMale.setBounds(20,50,80,30);
		cbMale.setOpaque(false);
		this.add(cbMale);
		
		//국가체크박스
		String [] countries = {"일본","미국","싱가폴","태국"};
		int xpos = 20;
		
		for(int i=0; i<cbCountry.length; i++) {
			cbCountry[i] = new JCheckBox(countries[i]);
			cbCountry[i].setBounds(xpos, 100, 80, 30);
			cbCountry[i].setOpaque(false);
			this.add(cbCountry[i]);
			xpos += 80;
		}
		
		
		//색상라디오버튼
		//상단패널 보더로 감싼 4개의 라디오버튼
		String [] str1 = {"Red","Green","Yellow"};
		JPanel pTop = new JPanel();
		//pTop.setBorder(new TitledBorder("글자색"));
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

	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new L08_Quiz("0119주말과제 ★ 8");

	}



}
