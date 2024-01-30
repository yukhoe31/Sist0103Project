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
import javax.swing.JOptionPane;
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

	L01_AddStuInfo addForm = new L01_AddStuInfo("★성적 추가★");
	L01_UpdateStuInfo updateForm = new L01_UpdateStuInfo("★성적 수정★");
	//데이터 삭제의 경우 다이알로그 창을 쓰기 때문에 새로운
	//클래스가 불필요하다.	

	

	//생성자
	public L01_SwingJdbcScore(String title){

		super(title);
		cp = this.getContentPane();
		this.setBounds(200,100,400,300);
		cp.setBackground(new Color(240,210,240));
		initDesign();
		this.setVisible(true);

	}


	//테이블에 DB의 데이터 전체를 출력하는 메서드
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


				//Q. ArrayList가 아니라 Vector를 쓰는 이유?
				//A. 일단 연습용으로 Vector쓰는것이고, 
				//   나중에는 더 편한 ArrayList사용한다.

				Vector<String> data = new Vector<String>();
				//전부 String 형태로 담아야한다.
				//1.Vector로 우선 String들을 묶을 공간을 만들고,

				//2.String 묶음 내에 들어갈 데이터를 하나하나 추가하기.
				data.add(rs.getString("num"));//num의 스트링화
				data.add(rs.getString("name"));//위에서 String으로 묶었으므로,
				data.add(rs.getString("ban"));
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


	//insert메서드
	//stuinfo2 테이블의 DB와 연결하여
	//새로운 학생 데이터를 insert하는 메서드
	public void insertData() {

		String name = addForm.tfName.getText();
		String java = addForm.tfJava.getText();
		String jsp = addForm.tfJsp.getText();
		String spring = addForm.tfSpring.getText();
		String ban = (String)addForm.cbBan.getSelectedItem();
		//(String)하는 이유: 기존의 데이터타입이 Object였으므로

		int tot = Integer.parseInt(java) + Integer.parseInt(jsp) + Integer.parseInt(spring);
		double avg = tot/3.0;

		//여기서 stuinfo 테이블이 아니라 stuinfo2 테이블임에 유의할것.
		String sql = "insert into stuinfo2 values(seq1.nextval,?,?,?,?,?,?,?)";

		//DB연결
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);

			//?를 순서대로 바인딩하기.
			pstmt.setString(1, name);
			pstmt.setString(2, java);
			pstmt.setString(3, jsp);
			pstmt.setString(4, spring);
			pstmt.setInt(5, tot);
			pstmt.setDouble(6, avg);
			pstmt.setString(7, ban);

			//업데이트
			pstmt.execute();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}


	//delete메서드
	//stuinfo2 테이블의 DB와 연결하여
	//삭제할 학생 data를 delete 하는 메서드
	public void deleteData(String num) {

		//삭제할 데이터의 시퀀스 받아오기
		String sql = "delete from stuinfo2 where num ="+num;

		//sql문 실행후 해당번호가 없으면 메세지가 삭제되면 tableWrite()호출


		//DB연결
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);

			//업데이트
			int a = pstmt.executeUpdate();

			if(a==1) {
				JOptionPane.showMessageDialog(this, "삭제가 성공했습니다.");
				tableWrite();
			}else {
				JOptionPane.showMessageDialog(this, "없는 시퀀스 번호입니다.");
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}

	
	//update메서드
	public void updateData() {
		
		String num = updateForm.num;
		
		String name = updateForm.tfName.getText();
		String java = updateForm.tfJava.getText();
		String jsp = updateForm.tfJsp.getText();
		String spring = updateForm.tfSpring.getText();
		String ban = (String)updateForm.cbBan.getSelectedItem();
		
		int tot = Integer.parseInt(java) + Integer.parseInt(jsp) + Integer.parseInt(spring);
		double avg = tot/3.0;

		String sql = "update stuinfo2 set name=?,java=?,jsp=?,spring=?,total="
		             +tot+",average="+avg+",ban=? where num=?";
		
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;

		try {

			pstmt = conn.prepareStatement(sql);

			//?차례대로 바인딩
			pstmt.setString(1, name);
			pstmt.setString(2, java);
			pstmt.setString(3, jsp);
			pstmt.setString(4, spring);
			pstmt.setString(5, ban);
			pstmt.setInt(6, Integer.parseInt(num));
	
			//업데이트
			pstmt.execute();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}

		updateForm.setVisible(false);
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
		//추가폼에 있는 추가버튼에 액션을 추가
		addForm.btnAdd.addActionListener(this);

		//삭제버튼
		btnDel = new JButton("삭제");
		btnDel.addActionListener(this);
		pTop.add(btnDel);

		//수정버튼		
		btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(this);
		pTop.add(btnUpdate);
		//수정폼에 있는 수정버튼에 액션을 추가
		updateForm.btnMod.addActionListener(this);
	}


	//버튼 클릭하면 액션 발생시키는 메서드
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		Object ob = e.getSource();

		if(ob==btnAdd) {
			//콘솔창에 출력해서 제대로 버튼 클릭이 이루어지는지 
			//테스트하는 용도의 syso
			//System.out.println("add");
			//실제 코드는 아래서....

			addForm.setVisible(true);
			//버튼 btnAdd를 누르면 
			//실제 생성한 addForm이 보여지도록 하겠다.

		}else if(ob == addForm.btnAdd) {//학생추가폼의 버튼이벤트

			//입력하는 데이터를 읽어서 db추가
			insertData();//db에 들어간거 확인

			//테이블 다시 출력
			this.tableWrite();

			//초기화하면서 추가 폼(addForm)은 사라져야 한다.=>보기에 좋다.
			addForm.tfName.setText("");
			addForm.tfJava.setText("");
			addForm.tfJsp.setText("");
			addForm.tfSpring.setText("");

			addForm.setVisible(false);

		}else if(ob == btnDel) {

			//System.out.println("del");

			//삭제 버튼 클릭 시 다이얼로그 입력창에서 시퀀스 입력 받기
			String num = JOptionPane.showInputDialog("삭제할 시퀀스는?");

			//삭제메서드 호출
			deleteData(num);

		}else if(ob == btnUpdate) {
			//System.out.println("update");
			String num = JOptionPane.showInputDialog("수정할 시퀀스는?");
			String sql = "select * from stuinfo2 where num = "+num;

			Connection conn = db.getOracle();
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();

				//데이타 하나 조회 if
				if(rs.next()) {
					updateForm.num = num;
					updateForm.tfName.setText(rs.getString("name"));
					updateForm.tfJava.setText(rs.getString("java"));
					updateForm.tfJsp.setText(rs.getString("jsp"));
					updateForm.tfSpring.setText(rs.getString("spring"));
					updateForm.cbBan.setSelectedItem(rs.getString("ban"));

					updateForm.setVisible(true);

				}else {
					JOptionPane.showMessageDialog(this, "존재하지 않는 데이터입니다.");
				}

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally {
				db.dbClose(rs, pstmt, conn);
			}


		}else if(ob == updateForm.btnMod) {//학생추가폼의 수정 버튼 이벤트
			updateData();
		}	


		//테이블 다시 출력
		this.tableWrite();

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new L01_SwingJdbcScore("★학생성적관리 DB★");

	}



}
