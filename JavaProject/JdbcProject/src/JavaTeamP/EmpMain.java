package JavaTeamP;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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

public class EmpMain extends JFrame implements ActionListener{

	DbConnect db = new DbConnect();
	Container cp;

	//테이블에 대한 삭제를 하려면 DefaultTableModel이 필요하다.
	DefaultTableModel model;
	JTable table;
	JButton btnAdd, btnDel, btnUpdate, btnSearch;

	EmpAdd addForm = new EmpAdd("★사원 추가★");
	EmpUpdate updateForm = new EmpUpdate("★사원정보 수정★");
	//데이터 삭제의 경우 다이알로그 창을 쓰기 때문에 새로운
	//클래스가 불필요하다.	



	//생성자
	public EmpMain(String title){

		super(title);
		cp = this.getContentPane();
		this.setBounds(700, 220, 480, 320);
		cp.setBackground(new Color(240,210,240));
		initDesign();
		//this.setVisible(true);

	}


	//테이블에 DB의 데이터 전체를 출력하는 메서드
	public void tableWrite() {

		//테이블 초기화:0을 적자. (테이블에 행 하나도 없다는 뜻)
		model.setRowCount(0);

		//db연결
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from emp order by emp_id";//////////////////////////////////////////////////////////

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
				data.add(rs.getString("emp_id"));//num의 스트링화
				data.add(rs.getString("emp_name"));
				data.add(rs.getString("dept_id"));

				data.add(rs.getString("birth_date"));
				data.add(rs.getString("hire_date"));//아래 column들도 모두 String으로 묶기

				data.add(rs.getString("position"));
				data.add(rs.getString("salary"));
				data.add(rs.getString("email"));
				data.add(rs.getString("phone_number"));

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

		// 이름, 생일,입사일,직급,월급,이메일,핸드폰, 부서명 콤보박스
		String name = addForm.tfName.getText();
		String dept_id = (String)addForm.cbDeptName.getSelectedItem();
		String birth = addForm.tfBirth.getText();
		String hire = addForm.tfHire.getText();
		String position = addForm.tfPosition.getText();
		String salary = addForm.tfSalary.getText();
		String email = addForm.tfEmail.getText();
		String phone = addForm.tfPhone.getText();

		//(String)하는 이유: 기존의 데이터타입이 Object였으므로


		//여기서 stuinfo 테이블이 아니라 stuinfo2 테이블임에 유의할것.
		String sql = "insert into emp values(seq_emp.nextval,?,?,?,?,?,?,?,?)";

		//DB연결
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);

			//?를 순서대로 바인딩하기.
			pstmt.setString(1, name);

			pstmt.setString(2, birth);
			pstmt.setString(3, hire);
			pstmt.setString(4, dept_id);
			pstmt.setString(5, position);
			pstmt.setString(6, salary);
			pstmt.setString(7, email);
			pstmt.setString(8, phone);


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
		String sql = "delete from emp where emp_id ="+num;

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
		String birth = updateForm.tfBirth.getText();
		String hire = updateForm.tfHire.getText();
		String position = updateForm.tfPosition.getText();
		String salary = updateForm.tfSalary.getText();
		String email = updateForm.tfEmail.getText();
		String phone = updateForm.tfPhone.getText();
		String dept_id = (String)updateForm.cbDeptName.getSelectedItem();//

		String sql = "update emp set emp_name=?, birth_date=?, hire_date=?, dept_id=?, position=?, salary=?, email=?, phone_number=? where emp_id=?";

		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;

		try {

			pstmt = conn.prepareStatement(sql);

			//?차례대로 바인딩
			pstmt.setString(1, name);

			pstmt.setString(2, birth);
			pstmt.setString(3, hire);
			pstmt.setString(4, dept_id);
			pstmt.setString(5, position);
			pstmt.setString(6, salary);
			pstmt.setString(7, email);
			pstmt.setString(8, phone);
			pstmt.setString(9, num);

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

		String [] title = {"사원번호", "이름", "부서명", "생년월일", "입사일","직급","월급","이메일", "휴대폰번호"};

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
		addForm.btnInsert.addActionListener(this);

		//삭제버튼
		btnDel = new JButton("삭제");
		btnDel.addActionListener(this);
		pTop.add(btnDel);

		//수정버튼		
		btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(this);
		pTop.add(btnUpdate);
		//수정폼에 있는 수정버튼에 액션을 추가
		updateForm.btnUpdate.addActionListener(this);
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

		}else if(ob == addForm.btnInsert) {//학생추가폼의 버튼이벤트

			//입력하는 데이터를 읽어서 db추가
			insertData();//db에 들어간거 확인

			//테이블 다시 출력
			this.tableWrite();

			//초기화하면서 추가 폼(addForm)은 사라져야 한다.=>보기에 좋다.
			addForm.tfName.setText("");
			addForm.tfBirth.setText("");
			addForm.tfHire.setText("");
			addForm.tfPosition.setText("");
			addForm.tfSalary.setText("");
			addForm.tfEmail.setText("");
			addForm.tfPhone.setText("");

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
			String sql = "select * from emp where emp_id = "+num;

			Connection conn = db.getOracle();
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();

				//데이타 하나 조회 if
				if(rs.next()) {
					updateForm.num = num;

					updateForm.tfName.setText(rs.getString("emp_name"));
					updateForm.tfBirth.setText(rs.getString("birth_date"));
					updateForm.tfHire.setText(rs.getString("hire_date"));
					updateForm.cbDeptName.setSelectedItem(rs.getString("dept_id"));
					updateForm.tfPosition.setText(rs.getString("position"));
					updateForm.tfSalary.setText(rs.getString("salary"));
					updateForm.tfEmail.setText(rs.getString("email"));
					updateForm.tfPhone.setText(rs.getString("phone_number"));


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

		}
		else if(ob == updateForm.btnUpdate) {//학생추가폼의 수정 버튼 이벤트
			updateData();
		}	


		//테이블 다시 출력
		this.tableWrite();

	}

/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

		new EmpMain("★인사관리 DB★");

	}
*/


}
