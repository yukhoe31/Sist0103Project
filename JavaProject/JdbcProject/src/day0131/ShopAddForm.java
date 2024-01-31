package day0131;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import oracle.net.ano.SupervisorService;

public class ShopAddForm extends JFrame implements ActionListener{
	
	JTextField tfSang,tfSu,tfDan;
	JLabel lblPhoto;
	String imageName;
	JButton btnImage,btnInsert;
	
	//db모델 생성
	ShopDbModel model = new ShopDbModel();
	//내부클래스
	PhotoDraw photoDraw = new PhotoDraw();
	
	
	public ShopAddForm() {
		// TODO Auto-generated constructor stub
		
		super("상품추가폼");
		this.setBounds(200,100,400,350);
		initDesign();
		this.setVisible(true);
	}
	
	public void initDesign(){
		
		this.setLayout(null);
		
		JLabel lbl1 = new JLabel("상품명");
		lbl1.setBounds(30,10,60,30);
		this.add(lbl1);
		
		tfSang = new JTextField();
		tfSang.setBounds(110,10,100,30);
		this.add(tfSang);
		
		JLabel lbl2 = new JLabel("사진선택");
		lbl2.setBounds(30,60,60,30);
		this.add(lbl2);
		
		btnImage = new JButton("사진선택");
		btnImage.setBounds(110,60,100,30);
		this.add(btnImage);
		btnImage.addActionListener(this);
		
		//이미지 추가
		photoDraw.setBounds(250,10,80,90);
		this.add(photoDraw);
		
		//이미지명
		lblPhoto = new JLabel("이미지명");
		lblPhoto.setBorder(new LineBorder(Color.cyan));
		lblPhoto.setBounds(20,120,300,30);
		this.add(lblPhoto);
		
		//수량
		JLabel lbl3 = new JLabel("수량");
		lbl3.setBounds(30,150,50,30);
		this.add(lbl3);
		
		tfSu = new JTextField();
		tfSu.setBounds(110,150,50,30);
		this.add(tfSu);
		
		//단가
		JLabel lbl4 = new JLabel("단가");
		lbl4.setBounds(30,180,50,30);
		this.add(lbl4);
		
		tfDan = new JTextField();
		tfDan.setBounds(110,180,50,30);
		this.add(tfDan);
		
		//db추가버튼
		btnInsert = new JButton("DB추가");
		btnInsert.setBounds(180,210,100,30);
		btnInsert.addActionListener(this);
		this.add(btnInsert);
		
		
	}
	
	//내부클래스..이미지삽입 => 클래스는 상속을 받을 수 있다.
	class PhotoDraw extends Canvas{
		
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			
			if(imageName != null) {
				Image image = new ImageIcon(imageName).getImage();
				g.drawImage(image, 10, 10, 60, 70, this);
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
			
			//라벨에 이미지명 출력
			lblPhoto.setText(imageName);
			
			//이미지 출력
			photoDraw.repaint();

		}else if(ob == btnInsert) {
			
			//ShopDto 생성
			ShopDto dto = new ShopDto();
			
			//dto에 4개의 데이터를 넣는다.
			dto.setSangpum(tfSang.getText());
			dto.setPhoto(imageName);
			dto.setSu(Integer.parseInt(tfSu.getText()));
			dto.setDan(Integer.parseInt(tfDan.getText()));	
			
			//위에서 넣은 데이터를 한번에 insert로 DB에 추가.
			//db모델에서 insert메서드 호출
			model.insertShop(dto);
			
			//제대로 insert하고 나면 화면 끄기
			this.setVisible(false);
		}
		
	}
	
	
	//main메서드 필요없으므로 지우기
	/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new ShopAddForm();					
	}
	*/


}
