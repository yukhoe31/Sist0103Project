package day0130;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

//L01_SwingJdbcScore의 메인 화면에서 btnAdd("추가버튼")을 누르면
//L01_AddStuInfo의 "학생정보 추가프레임"이 나타나게 한다.

public class L01_UpdateStuInfo extends JFrame {
	
	Container cp;
	JTextField tfName,tfJava,tfJsp,tfSpring;
	JComboBox<String> cbBan;
	JButton btnMod;
	String num;//수정할 시퀀스 번호
	
	
	public L01_UpdateStuInfo(String title) {
		
		super(title);	
		
		cp = this.getContentPane();
		this.setBounds(200,100,250,250);
		cp.setBackground(new Color(204,204,155));
		initDesign();
		//this.setVisible(true);
		//이걸 주석처리한 이유: initDesign화면은 
		//L02_SwingJdbcScore의 메인 인터페이스 화면에서
		//"추가 버튼"(btnAdd)를 눌렀을 때만 나타나도록 하기 위함.
		
		
	}
	
	
	public void initDesign() {
		
		this.setLayout(null);
		
		JLabel lblTitle1 = new JLabel("이름");
		JLabel lblTitle2 = new JLabel("반");
		JLabel lblTitle3 = new JLabel("JAVA");
		JLabel lblTitle4 = new JLabel("JSP");
		JLabel lblTitle5 = new JLabel("SPRING");

		tfName = new JTextField(4);
		tfJava = new JTextField(3);
		tfJsp = new JTextField(3);
		tfSpring = new JTextField(3);
		
		String [] ban = {"aws반","front반","backend반","design반"};
		cbBan = new JComboBox<String>(ban);
		btnMod = new JButton("데이터 수정");
		
		//라벨 5개 위치선정
		lblTitle1.setBounds(30,10,60,30);
		this.add(lblTitle1);
		lblTitle2.setBounds(30,40,60,30);
		this.add(lblTitle2);
		lblTitle3.setBounds(30,70,60,30);
		this.add(lblTitle3);
		lblTitle4.setBounds(30,100,60,30);
		this.add(lblTitle4);
		lblTitle5.setBounds(30,130,60,30);
		this.add(lblTitle5);
		
		//이름,반,java,jsp,spring 순으로
		tfName.setBounds(80,15,70,22);	
		this.add(tfName);
		
		cbBan.setBounds(80,45,70,22);	
		this.add(cbBan);
		
		tfJava.setBounds(80,75,70,22);	
		this.add(tfJava);
		
		tfJsp.setBounds(80,105,70,22);	
		this.add(tfJsp);
		
		tfSpring.setBounds(80,135,70,22);	
		this.add(tfSpring);
		
		//"데이터 추가" 버튼
		btnMod.setBounds(70, 165, 110, 30);
		this.add(btnMod);
		
		
	}
	
	
	//메인 함수는 전체 class묶음에서 하나만 필요하므로
	//updateForm에서는 불필요하다.
	/*
	public static void main(String[] args) {
		
		new L01_UpdateStuInfo("학생정보 수정창");
		
	}
	*/

}
