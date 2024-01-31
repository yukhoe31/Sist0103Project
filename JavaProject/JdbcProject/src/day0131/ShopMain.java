package day0131;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import day0130.L01_SwingJdbcScore;

public class ShopMain extends JFrame implements ActionListener{

	//인터페이스 창 위의 버튼 4개(CRUD)
	JButton btnAdd,btnDel,btnUpdate,btnList;
	
	//생성자
	public ShopMain() {
		
		super("ShopMain");
		this.setBounds(200,100,400,400);
		initDesign();
		this.setVisible(true);

	}
	
	public void initDesign() {
		
		this.setLayout(new GridLayout(2,2));//2행2열
		
		btnAdd = new JButton("상품추가");
		btnDel = new JButton("상품삭제");
		btnUpdate = new JButton("상품수정");
		btnList = new JButton("상품목록");
		
		this.add(btnAdd);
		this.add(btnDel);
		this.add(btnUpdate);
		this.add(btnList);
		
		//이벤트
		btnAdd.addActionListener(this);
		btnDel.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnList.addActionListener(this);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Object ob = e.getSource();
		
		if(ob == btnAdd) {
			System.out.println("add");//콘솔창 확인용
			ShopAddForm add  = new ShopAddForm();
			
		}else if(ob == btnDel) {
			System.out.println("del");
			//삭제는 num값 넘겨서 처리하는걸로...
			//class 따로 만들지 말고 그냥 메인액션에서 처리하는걸로 해보세요.
			
		}else if(ob == btnUpdate) {
			System.out.println("update");
			
		}else if(ob == btnList) {
			System.out.println("list");
			ShopListForm listForm = new ShopListForm();		
		}
		
	}
	
	//스타트 지점이 되는 메인함수
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		new ShopMain();
		
	}

}
