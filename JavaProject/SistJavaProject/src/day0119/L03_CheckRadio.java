package day0119;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class L03_CheckRadio extends JFrame implements ActionListener, ItemListener{

	Container cp;
	JCheckBox [] cbHobby = new JCheckBox[4];
	JCheckBox cbDriver;
	JCheckBox cbFont;
	JButton btnHobby;
	JLabel lblResult;
	
	
	public L03_CheckRadio(String title) {
	
		super(title);	
		cp = this.getContentPane();
		
		this.setBounds(300,100,500,500);
		cp.setBackground(new Color(221,200,245));
		
		initDesign();
		this.setVisible(true);
	}
	
	public void initDesign() {

		this.setLayout(null);
		
		//운전면허 체크박스
		cbDriver = new JCheckBox("운전면허");
		cbDriver.setBounds(20, 20, 100, 30);
		cbDriver.setOpaque(false);
		
		//글꼴굵게 체크박스
		cbFont = new JCheckBox("라벨을 굵게");
		cbFont.setBounds(200, 20, 100, 30);
		cbFont.setOpaque(false);
		
		
		//ItemListener이벤트 핸들러 객체와 연결
		cbDriver.addItemListener(this);
		this.add(cbDriver);
		
		cbFont.addItemListener(this);
		this.add(cbFont);
		
		lblResult = new JLabel("Have a Nice Day!!!", JLabel.CENTER);
		lblResult.setBounds(20, 200, 300, 50);
		lblResult.setBorder(new LineBorder(Color.GREEN,5));//테두리 굵기:5
		this.add(lblResult);		
		
		//취미체크박스
		String [] hobbys = {"여행","게임","넷플릭스감상","코딩"};
		int xpos = 20;
		
		for(int i=0; i<cbHobby.length; i++) {
			cbHobby[i] = new JCheckBox(hobbys[i]);
			cbHobby[i].setBounds(xpos, 100, 80, 30);
			cbHobby[i].setOpaque(false);
			this.add(cbHobby[i]);
			xpos += 80;
		}
		
		
		
		//버튼
		btnHobby = new JButton("나의취미출력");
		btnHobby.setBounds(60,140,200,30);
		this.add(btnHobby);
		
		btnHobby.addActionListener(this); //버튼에 이벤트 추가
		cbDriver.addItemListener(this);
	}
	
	//implements ActionListener,
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object ob = e.getSource();
		
		if(ob == btnHobby) {
			
			String s = "나의 취미는 ";
			int select_cnt = 0;
			
			for(int i=0; i<cbHobby.length;i++) {
				if(cbHobby[i].isSelected()) {
					select_cnt++;
					s += "[" + cbHobby[i].getText() + "]";
				}
			}
			
			//체크박스 취미 칸에 아무것도 체크하지 않았을때
			if(select_cnt == 0) {
				s += "없습니다.";
			}else {
				s += "입니다.";
			}
			
			
			//라벨에 출력
			lblResult.setText(s);
		}
		
	
	}
	
	//implements ItemListener,
	@Override
	public void itemStateChanged(ItemEvent e) {
		
		Object ob = e.getSource();
		
		if(ob == cbDriver) {
			String s = "체크상태: " + cbDriver.isSelected()+ " ,텍스트: " + cbDriver.getText();
			lblResult.setText(s);
		}else if(ob == cbFont) {
			if(cbFont.isSelected()) {
				lblResult.setFont(new Font("",Font.BOLD, 20));
			}else {
				lblResult.setFont(new Font("",Font.PLAIN, 13));
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		new L03_CheckRadio("체크박스 ★ 3");
	}

}
