package JavaTeamP;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import JavaTeamP.EmpAdd.PhotoDraw;
import day0131.ShopDto;

//L01_SwingJdbcScore의 메인 화면에서 btnAdd("추가버튼")을 누르면
//L01_AddStuInfo의 "학생정보 추가프레임"이 나타나게 한다.

public class EmpUpdate extends JFrame implements ActionListener {

	Container cp;
	JTextField tfName, tfBirth, tfHire, tfPosition, tfSalary, tfEmail, tfPhone;
	JComboBox<String> cbDeptName;
	JButton btnUpdate,btnImage;
	String num;//수정할 시퀀스 번호

	String imageName;

	//내부클래스
	PhotoDraw photoDraw = new PhotoDraw();




	public EmpUpdate(String title) {

		super(title);	

		cp = this.getContentPane();
		this.setBounds(200,100,400,400);
		cp.setBackground(new Color(234,234,234));
		initDesign();
		//this.setVisible(true);
		//이걸 주석처리한 이유: initDesign화면은 
		//L02_SwingJdbcScore의 메인 인터페이스 화면에서
		//"추가 버튼"(btnAdd)를 눌렀을 때만 나타나도록 하기 위함.


	}


	public void initDesign() {

		this.setLayout(null);

		JLabel lblTitle1 = new JLabel("이름");
		JLabel lblTitle2 = new JLabel("부서");
		JLabel lblTitle3 = new JLabel("생년월일");
		JLabel lblTitle4 = new JLabel("입사일");
		JLabel lblTitle5 = new JLabel("직급");
		JLabel lblTitle6 = new JLabel("임금");
		JLabel lblTitle7 = new JLabel("이메일");
		JLabel lblTitle8 = new JLabel("휴대폰번호");

		tfName = new JTextField(10);
		tfBirth = new JTextField(10);
		tfHire = new JTextField(10);
		tfPosition = new JTextField(10);
		tfSalary = new JTextField(10);
		tfEmail = new JTextField(10);
		tfPhone = new JTextField(10);

		//부서이름
		String [] dept = {"개발팀","인사팀","재무팀","마케팅팀"};



		cbDeptName = new JComboBox<String>(dept);

		btnUpdate = new JButton("데이터 수정");

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
		lblTitle6.setBounds(30,160,60,30);
		this.add(lblTitle6);
		lblTitle7.setBounds(30,190,60,30);
		this.add(lblTitle7);
		lblTitle8.setBounds(30,220,60,30);
		this.add(lblTitle8);

		//이름,생일,입사일,직급,월급,이메일,핸드폰
		tfName.setBounds(100,15,70,22);	
		this.add(tfName);

		cbDeptName.setBounds(100,45,70,22);	
		this.add(cbDeptName);

		tfBirth.setBounds(100,75,70,22);	
		this.add(tfBirth);

		tfHire.setBounds(100,105,70,22);	
		this.add(tfHire);

		tfPosition.setBounds(100,135,70,22);	
		this.add(tfPosition);

		tfSalary.setBounds(100,165,70,22);	
		this.add(tfSalary);

		tfEmail.setBounds(100,195,70,22);	
		this.add(tfEmail);

		tfPhone.setBounds(100,225,70,22);	
		this.add(tfPhone);

		//"데이터 추가" 버튼
		btnUpdate.setBounds(70, 290, 110, 30);
		this.add(btnUpdate);

		//////이미지

		btnImage = new JButton("사진선택");
		btnImage.setBounds(225,15,100,30);
		this.add(btnImage);
		btnImage.addActionListener(this);

		//이미지 추가
		photoDraw.setBounds(170,10,300,400);
		this.add(photoDraw);


	}
	
	class PhotoDraw extends Canvas{

		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);

			if(imageName != null) {
				Image image = new ImageIcon(imageName).getImage();
				g.drawImage(image, 30, 50, 150,200, this);
			}
		}

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		Object ob = e.getSource();

		if(ob == btnImage) {
			FileDialog dlg=new FileDialog(this, "이미지 가져오기", FileDialog.LOAD);
			dlg.setVisible(true);

			//취소누르면 메서드 종료
			if(dlg.getDirectory() == null) {
				return;
			}

			//이미지명 얻기
			imageName = dlg.getDirectory() + dlg.getFile();

			//this.setPhoto(imageName);


			//이미지 출력
			photoDraw.repaint();

		}

	}


	//메인 함수는 전체 class묶음에서 하나만 필요하므로
	//updateForm에서는 불필요하다.
	/*
	public static void main(String[] args) {

		new L01_UpdateStuInfo("학생정보 수정창");

	}
	 */

}
