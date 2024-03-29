package day0116;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/*
**과일입고목록**

번호	과일명	수량	단가	총금액
1		바나나	10		2000	20000원
2		포도	20		15000 	

*/

public class L15_QuizFileException {

	public static void fileRead(){
		// TODO Auto-generated method stub
		String fName = "C:\\sist0103\\file\\fruitshop.txt";
		FileReader fr =null;
		BufferedReader br =null;
		int count = 0;
		
		try {
			fr = new FileReader(fName);
			br = new BufferedReader(fr);
			System.out.println("**과일입고목록**");
			System.out.println("번호\t과일명\t\t수량\t단가\t총금액");
			System.out.println("------------------------------------------------");
			
			while(true) {
				String s =br.readLine();
				count++;
				//종료
				if(s==null) {
					break;
				}
				//방법1: split으로 분리
				String [] data = s.split(",");
				//배열갯수만큼만 출력
				int total = Integer.parseInt(data[1])*Integer.parseInt(data[2]);
				System.out.println(count+"\t"+data[0]+"\t"+data[1]+"\t"+data[2]+"\t"+total+"원");
				
				//방법2: StringTokenizer를 이용하여 분리
				//StringTokenizer st = new StringTokenizer(s,",");
				//System.out.println(count+"\t"+st.nextToken()+"\t"+st.nextToken()+"\t"+st.nextToken()+);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(IOException e) {
			
		}finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
	}

	
	public static void main(String[] args) {
		fileRead();
	}

}
