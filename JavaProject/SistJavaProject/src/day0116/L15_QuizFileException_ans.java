package day0116;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class L15_QuizFileException_ans {

	public static void fileRead() {
		
		String fileName = "C:\\sist0103\\file\\fruitshop.txt";
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			System.out.println("**과일입고목록**");
			System.out.println("번호\t과일명\t\t수량\t단가\t총금액");
			System.out.println("---------------------------------------------------");
		
			int count=0;
			
			while(true) {
				String s = br.readLine();
				
				//종료
				if(s==null) {
					break;
				}
				
				
				/*
				//분리방법1: Tokenizer
				StringTokenizer st = new StringTokenizer(s,",");
				
				//배열의 갯수만큼 반복해서 출력
				String sang = st.nextToken();
				int su = Integer.parseInt(st.nextToken().trim());
				int dan = Integer.parseInt(st.nextToken().trim());
				int total = su*dan;
				*/
				
				
				//분리방법2: split
				String [] data = s.split(",");
				String sang = data[0];
				int su = Integer.parseInt(data[1].trim());
				int dan = Integer.parseInt(data[2].trim());
				int total = su*dan;
				
				//출력
				System.out.println(++count +"\t"+sang+"\t"+su+"개\t"+dan+"원\t"+total+"원");
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException e) {
			
		}finally {
			try {
				fr.close();
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fileRead();
	}

}
