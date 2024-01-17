package day0117;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class P01_FileReadWriter {
	
	Scanner sc = new Scanner(System.in);
	static final String fileName = "C:\\sist0103\\file\\practice01.txt";
	
	//파일에서 읽을때
	FileReader fr = null;
	BufferedReader br = null;
	//파일에 쓸때
	FileWriter fw = null;
	
	public int getMenu() {
		// TODO Auto-generated method stub
		System.out.println("[메뉴]");
		System.out.println("1.상품추가  2.전체상품출력  3.전체데이터삭제  5.종료");
		
		int num = Integer.parseInt(sc.nextLine());
		
		return num;
		
	}
	
	//1.상품추가(입력후 파일에 저장)
	public void sangpumAdd() {
		
		System.out.println("상품정보를 입력합니다.");
		System.out.println("상품명 입력:");
		String name = sc.nextLine();
		System.out.println("수량 입력: ");
		int su = Integer.parseInt(sc.nextLine());
		System.out.println("단가 입력: ");
		int dan = Integer.parseInt(sc.nextLine());
		
		try {
			fw = new FileWriter(fileName, true);
			fw.write(name + "," + su+ "," + dan);
			System.out.println("**추가되었습니다.**");
			
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
	
	//2.전체상품출력
	public void fileAllDatas() {
		
		int num=1;
		
		System.out.println("번호\t상품명\t수량\t단가\t금액");
		System.out.println("-------------------------------------------");
		
		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			
			while(true) {
				String s = br.readLine();
				
				if(s==null) {
					break;
				}
				
				String [] data = s.split(",");
				String name = data[0];
				int su = Integer.parseInt(data[1].trim());
				int dan = Integer.parseInt(data[2].trim());
				
				
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("저장된 파일이 없습니다.");
			
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
	
	
	//3.전체데이터삭제
	public void deleteShop() {
		
		
	}
	
	
	
	
	public void process() {
		
		int n = this.getMenu();
		
		switch(n) {
		case 1:
			System.out.println("**상품정보를 입력합니다.");
			sangpumAdd();
			break;
		case 2:
			System.out.println("**전체상품을 출력합니다.**");
			fileAllDatas();
			break;
		case 3:
			System.out.println("**파일을 삭제합니다.**");
			deleteShop();
			break;
		case 5:
			System.out.println("**프로그램을 종료합니다.**");
			System.exit(0);
		}
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

	}

}
