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
			
			db.dbClose(rs,stmt,conn);//만들어둔 DbConnect클래스를 닫기.
		}
		
	}
	
	
	
	public static void main(String[] args) {

		//생성
		L02_HelloCrud hello = new L02_HelloCrud();
			
		//1.insert,4.update를 위한 Scanner
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
			}else if(n==9){
				System.out.println("종료합니다.");
				break;
			}
			
			System.out.println();
			
		}
		
	}

}
