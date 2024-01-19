package day0119;

import java.awt.Color;
import java.awt.Container;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class L04_SwingTable extends JFrame{

	Container cp;
	
	JTable table;
	JLabel lblTitle, lblOut;
	
	
	public L04_SwingTable(String title) {
		// TODO Auto-generated constructor stub
		super(title);	
		cp = this.getContentPane();
		
		this.setBounds(300,100,300,300);
		cp.setBackground(new Color(221,200,245));
		initDesign();
		this.setVisible(true);
		
		
	}
	
	public void initDesign() {
		
		//배열 data, title
		String [][] data = {
				{"송혜교","서울","010-1112-4444"},
				{"전지현","인천","010-1111-2222"},
				{"이효리","부산","010-7777-9999"}
		};
		
		String [] title = {"이름", "주소", "연락처"};
		
		//JLabel생성		
		lblTitle = new JLabel("JTable연습", JLabel.CENTER);
		lblOut = new JLabel("결과출력하는곳", JLabel.CENTER);
		
		//JTable생성
		table = new JTable(data,title);
		//생성된 table을 JScrollPane 안에 집어 넣어서,
		//테이블 크기가 맞지 않은 경우 스크롤 사용을 가능하게 만든다.
		JScrollPane pane = new JScrollPane(table);
		
		//테이블에 마우스 이벤트 추가=>테이블 위를 클릭하면 이벤트가 발생한다.
		table.addMouseListener(new TableEvent());
		//아래의 TableEvent가 다중상속을 받은 것과 같은 효과 있다.
	
		this.add("North",lblTitle);
		this.add("Center", pane);
		this.add("South", lblOut);
		
	}
	
	class TableEvent extends MouseAdapter{
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseClicked(e);
			
			//System.out.println("테이블 출력!!");
			//"클릭"해서 선택한 행번호 얻기
			int rowNum = table.getSelectedRow();
			//rowNum: 클릭해서 선택한 행번호
			
			//this가 안먹을때는 this앞에 class. 도 적어준다.
			//JOptionPane.showMessageDialog(L04_SwingTable.this,"행번호: "+rowNum);
			String str = "이름: " + table.getValueAt(rowNum, 0) //선택한 행번호의 "이름"
					    + ", 주소: " + table.getValueAt(rowNum, 1) ///선택한 행번호의 "주소"
					    + ", 핸드폰: " + table.getValueAt(rowNum, 2); //선택한 행번호의 "핸드폰"
			
			lblOut.setText(str);//위의 str을 출력
		
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new L04_SwingTable("스윙테이블 ★ 4");
	}

}
