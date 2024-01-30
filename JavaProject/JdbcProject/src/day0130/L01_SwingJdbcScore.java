package day0130;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import oracle.jdbc.proxy.annotation.Pre;
import oracleDb.DbConnect;

public class L01_SwingJdbcScore extends JFrame implements ActionListener{

	DbConnect db = new DbConnect();
	Container cp;
	
	//테이블에 대한 삭제를 하려면 DefaultTableModel이 필요하다.
	DefaultTableModel model;
	JTable table;
	JButton btnAdd,btnDel,btnUpdate;
	
	
	//생성자
	public L01_SwingJdbcScore(String title){
		
		super(title);
		cp = this.getContentPane();
		this.setBounds(200,100,400,300);
		cp.setBackground(new Color(240,210,240));
		initDesign();
		this.setVisible(true);
		
	}
	
	
	//테이블에 출력하는 메서드
	public void tableWrite() {
		
		//테이블 초기화:0을 적자. (테이블에 행 하나도 없다는 뜻)
		model.setRowCount(0);
		
		//db연결
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from stuinfo2 order by num";
		
		conn = db.getOracle();
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				
				//ArrayList가 아니라 Vector를 쓰는 이유?
				//둘다 가변적인데,왜인가요??
				//=> 일단 연습용으로 Vector쓰는것이고, 
				//   나중에는 더 편한 ArrayList사용한다.
				Vector<String> data = new Vector<String>();
				//전부 String 형태로 담아야한다.
				//1.Vector로 우선 String들을 묶을 공간을 만들고,
				
				//2.String 묶음 내에 들어갈 데이터를 하나하나 추가하기.
				data.add(rs.getString("num"));//num의 스트링화
				data.add(rs.getString("name"));//위에서 String으로 묶었으므로,
				data.add(rs.getString("java"));//아래 column들도 모두 String으로 묶기
				data.add(rs.getString("jsp"));
				data.add(rs.getString("spring"));
				data.add(rs.getString("total"));
				data.add(rs.getString("average"));
				
				//3.테이블에 위에 데이터들을 한꺼번에 추가
				model.addRow(data);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
	}
	
	
	//디자인
	public void initDesign() {
		
		String [] title = {"번호", "이름", "반", "Java", "Jsp", "Spring","총점","평균"};
		
		//DefaultTableModel 시작시 항상 ABORT는 0으로 시작해야
		model = new DefaultTableModel(title,0);
		table = new JTable(model);
		this.add( "Center", new JScrollPane(table));
		
		//테이블에 DB데이터 출력
		tableWrite();		
		
		//버튼 3개 올릴 패널
		JPanel pTop = new JPanel();
		this.add("North",pTop);
		
		//추가버튼
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pTop.add(btnAdd);
		
		btnDel = new JButton("삭제");
		btnDel.addActionListener(this);
		pTop.add(btnDel);
		
		btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(this);
		pTop.add(btnUpdate);

	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Object ob = e.getSource();
		
		if(ob==btnAdd) {
			//콘솔창에 출력해서 제대로 버튼 클릭이 이루어지는지 
			//테스트하는 용도의 syso
			System.out.println("add");
			//실제 코드는 여기서...
			
		}else if(ob == btnDel) {
			System.out.println("del");
		}else if(ob == btnUpdate) {
			System.out.println("update");
		}
		
	}

	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new L01_SwingJdbcScore("★학생성적관리 DB★");

	}



}
