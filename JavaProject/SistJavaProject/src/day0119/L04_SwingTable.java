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
		//단색 배경은 주석처리하기.
		cp.setBackground(new Color(221,200,245));
		
		initDesign();
		this.setVisible(true);
		
		
	}
	
	public void initDesign() {
		
		String [][] data = {
				{"송혜교","서울","010-1112-4444"},
				{"전지현","인천","010-1111-2222"},
				{"이효리","부산","010-7777-9999"}
		};
		
		String [] title = {"이름", "주소", "연락처"};
		
		lblTitle = new JLabel("JTable연습", JLabel.CENTER);
		lblOut = new JLabel("결과출력하는곳", JLabel.CENTER);
		
		table = new JTable(data,title);
		JScrollPane pane = new JScrollPane(table);
		
		//테이블에 마우스 이벤트 추가
		table.addMouseListener(new TableEvent());
		//위의 TableEvent가 다중상속을 받은 것과 같은 효과 있다.
	
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
			//선택한 행번호 얻기
			int rowNum = table.getSelectedRow();
			
			//this가 안먹을때는 this앞에 class. 도 적어준다.
			//JOptionPane.showMessageDialog(L04_SwingTable.this,"행번호: "+rowNum);
			String str = "이름: " + table.getValueAt(rowNum, 0)
					    + ", 주소: " + table.getValueAt(rowNum, 1)
					    + ", 핸드폰: " + table.getValueAt(rowNum, 2);
		
			
			lblOut.setText(str);
		
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new L04_SwingTable("스윙테이블 ★ 4");
	}


}
