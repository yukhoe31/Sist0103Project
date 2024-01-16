package day0116;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//BufferReader: 버퍼를 사용해서 파일읽기
//FileReader: 경로에 있는 파일을 로드 : 반드시 Exception발생

public class L11_FileException {

	public static void read() {
		String fileName = "C:\\sist0103\\file\\memo.txt";
		BufferedReader br = null;
		FileReader fr = null; //문자단위

		//읽기 위해서 파일열기
		//파일이 없을 때를 대비해서 무조건 try catch사용
		try {
			fr = new FileReader(fileName);//파일생성
			System.out.println("파일을 열었어요!!");

			//파일을 버퍼 안에 넣어준다.
			br = new BufferedReader(fr);//생성된 fr을 넣어.

			//여러줄을 읽어야 하므로 while문 읽는다.
			while(true) {
				String s =	br.readLine();

				//마지막 줄일 경우 null값을 읽는다.
				//null값일 경우 while문 빠져나간다.
				if(s ==null) {
					break;
				}
				System.out.println(s);
			}


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("파일이 없어요. :" +e.getMessage());
		}catch(IOException e) {

		}finally {
			try {
				br.close();//생성한 반대순으로 닫아준다.
				fr.close();
				
				System.out.println("파일에 대한 자원을 모두 닫았어요!!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}


	}
	public static void main(String[] args) {
		
		read();
		System.out.println("**정상종료**");

	}
}
