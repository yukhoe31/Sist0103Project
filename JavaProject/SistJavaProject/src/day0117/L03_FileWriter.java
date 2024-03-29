package day0117;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class L03_FileWriter {

	//메서드1: 새 파일을 생성하는 메서드
	public static void fileWrite() {
		FileWriter fw = null;
		String fileName = "C:\\sist0103\\file\\test1.txt";
		
		try {
			//★파일새로생성(같은 이름이 있어도 새로생성)
			fw = new FileWriter(fileName);
			//파일에 내용추가
			fw.write("Have a Nice Day~~\n");//메모장 줄 넘김
			fw.write("오늘은 수요일\n");
			
			//문자열을 써야하는데 Date()까지만 있으면 날짜라서 오류난다.
			//=>Date().toString()해주면 문자열로 변하니까 ok!!
			fw.write(new Date().toString());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//메서드2: 파일에 내용을 추가(append)하는 메서드
	public static void fileWrite2() {
		FileWriter fw = null;
		String fileName = "C:\\sist0103\\file\\test1.txt";
		
		try {
			//아래서 ,true를 적어주지 않으면 메서드1과 같이 파일 새로 생성하는 역할이다.
			//따라서 ,true를 적어줘야 내용을 추가하는 모드로 바뀌는 것이다.
			
			fw = new FileWriter(fileName);
			
			fw.write("내이름은 이수연\n");
			fw.write("---------------------------");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally {
			
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fileWrite();
		fileWrite2();

	}

}
