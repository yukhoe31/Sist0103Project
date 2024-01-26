package day0126;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import oracleDb.DbConnect;

public class L02_HelloCrud {

	DbConnect db = new DbConnect();
	
	//1.insert메서드
	public void insert() {
		
		Scanner sc = new Scanner(System.in);
		String name,addr;
		String sql = "";
		
		System.out.println("이름을 입력하세요.");
		name = sc.nextLine();
		
		System.out.println("주소를 입력하세요");
		addr=sc.nextLine();
		
		//hello테이블은 dragon계정에 만든 테이블이므로
		//DbConnect.java 내에서 
		//conn = DriverManager.getConnection(ORACLE_DB, "dragon","a1234");
		//라고 계정 명을 'dragon'으로 바꿔줘야한다.
		sql = "insert into hello values (seq1.nextval,'"+name+"','"+addr+"', sysdate)";
		System.out.println(sql);
		
		//1.db연결
		Connection conn = null;//sql문 객체 전송에 필요한 API
		//2.statement
		Statement stmt = null;
		
		conn = db.getOracle();
		
		try {
			stmt=conn.createStatement();
			//그 API를 createStatement();객체를 통해서 이어준다
			
			//3.sql문 실행
			stmt.execute(sql);
			System.out.println("**데이터 추가됨**");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(stmt, conn);
		}
		
	}
	
	
	//2.select메서드
	public void select() {
		
		//제목 나열 용 syso
		System.out.println("시퀀스\t이름\t주소\t\t가입날짜");
		System.out.println("------------------------"
				+ "---------------------------------");
	
		//필요한 sql문 작성(sql문을 전송하기 전에만 쓰면 된다.)
		String sql = "select * from hello order by num";
				
		//연결용
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		conn = db.getOracle();//만들어둔 DbConnect클래스와 연결
		
		try {
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);//쿼리문에 이 sql문을 전달한다.
			
			//2개 이상의 데이터를 출력하므로 while문을 쓰자!
			//출력할 데이터 리스트를 while문으로 출력하기.
			while(rs.next()) {
				
				//출력 방법1. 변수 있게
				/*
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				String sdate = rs.getString("sdate");

				System.out.println(num+"\t"+name+"\t"+addr
						+"\t"+sdate);
			    */
				
				//출력 방법2. 변수 없이 바로
				System.out.println(rs.getInt("num")
						+"\t"+ rs.getString("name")
						+"\t"+ rs.getString("addr")
						+"\t"+ rs.getString("sdate"));
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//select문이므로 rs가 들어간다.
			db.dbClose(rs,stmt,conn);//만들어둔 DbConnect클래스를 닫기.
		}
		
	}
	
	
	//3.delete 메서드
	public void delete() {
		
		//삭제할 번호 입력후 삭제
		Scanner sc = new Scanner(System.in);
		String num;
		String sql="";
		
		System.out.println("삭제할 번호 입력");
		num = sc.nextLine();
		
		sql="delete from hello where num = " +num;
		System.out.println(sql);
		
		Connection conn = null;
		Statement stmt = null;
		
		conn = db.getOracle();
		
		try {
			stmt=conn.createStatement();
			
			//a:성공한 레코드의 갯수(하나 삭제하면 1)
			int a = stmt.executeUpdate(sql);
			
			//없는 번호 입력시 실제 삭제 안되므로
			//0이 반환된다.
			if(a==0) {
				System.out.println("없는 데이터 번호입니다.");
			}else {
				System.out.println("**삭제되었습니다.**");
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(stmt, conn);
		}
	}
	
	//수정할 데이터 5번이 없음에도 ...수정할 데이터 입력이 뜬다.
	//따라서, update함수는 2개있어야...? ..이건 아니고 그냥 없는 숫자 썼는지 조회하는 함수 필
	//수정하려는 데이터 조회할때,
	//조회한다고 입력한 데이터가 존재하지 않을 때를 위하여
	//만든 메소드
	//기능 : 없는 번호의 데이터 조회한다고 내가 입력하면
	//"수정할 데이터가 존재하지 않습니다." 라고 알려주기.
	//아래()안에 들어가는 값:파라미터 or 인자
	public boolean getOneDate(String num) {
		
		boolean flag = false;
		//num에 해당하는 데이터가 있으면 true반환,없으면 false반환
		
		String sql = "select * from hello where num=" +num;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		conn = db.getOracle();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			//한개만 조회할경우는 if문
			if(rs.next()) {//데이터가 있는경우
				flag = true;
			}else {
				flag = false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, stmt, conn);
		}

		
		return flag;
	}
	
	
	//4.update 메서드
	public void update() {
		
		//수정할 시퀀스를 입력후 이름,주소 입력
		Scanner sc = new Scanner(System.in);
		String num,name,addr;
		
		System.out.println("수정할 번호를 입력:");
		num=sc.nextLine();
		
		//만약에 내가 집어넣은 번호가 존재하지 않을뗴
		//위에서 만든 getOneDate()함수 내에
		//num을 파라미터값으로 넣는다.
		if(!this.getOneDate(num)) {
			System.out.println("해당번호는 존재하지 않습니다.");
			return;
		}
		
		
		System.out.println("수정할 이름으로 변경해주세요.");
		name = sc.nextLine();
		System.out.println("수정할 주소로 변경해주세요.");
		addr = sc.nextLine();
		
		String sql="update hello set name='"+name+"',addr='"+addr+"' where num="+num;
		System.out.println(sql);
		
		
		//DB연결
		Connection conn = null;
		Statement stmt = null;
		
		conn = db.getOracle();
		try {
			stmt = conn.createStatement();	
			
			//update된 것들을 a라는 변수로 받아서
			int a = stmt.executeUpdate(sql);
			
			if(a==0) {
				System.out.println("수정할 데이터가 존재하지 않습니다.");
			}else {
				System.out.println("**수정되었습니다.**");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(stmt, conn);
		}
		
	}
	
	
	public static void main(String[] args) {

		//생성
		L02_HelloCrud hello = new L02_HelloCrud();
			
		//1.2.3.4 선택지 중 하나 번호 고르기할때 쓰는 용도의 스캐너
		Scanner sc = new Scanner(System.in);
		int n;
		
		
		while(true) {
			
			System.out.println("**hello db 연습**");
			System.out.println("1.insert  2.select  3.delete  4.update  9.exit");
			
			n=Integer.parseInt(sc.nextLine());
			
			if(n==1) {
				hello.insert();
			}else if(n==2) {
				hello.select();
			}else if(n==3) {
				hello.delete();
			}else if(n==4) {
				hello.update();
			}else if(n==9){
				System.out.println("종료합니다.");
				break;
			}
			
			System.out.println();
			
		}
		
	}

}
