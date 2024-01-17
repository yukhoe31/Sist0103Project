package day0117;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class L07_MyShopList {
	
	static final String FILENAME = "C:\\sist0103\\file\\myshop.txt";
	List<L07_MyShop> list = new ArrayList<L07_MyShop>();
	
	Scanner sc = new Scanner(System.in);
	
	//생성자
	public L07_MyShopList() {
		shopFileRead();
	}
	
	//파일 읽기
	public void shopFileRead() {
		
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			
			while(true) {
				String shop = br.readLine();
				
				if(shop == null) {
					break;
				}
				
				String [] d= shop.split(",");
				String sang = d[0];
				int su = Integer.parseInt(d[1].trim());
				int price = Integer.parseInt(d[2].trim());
				int total = su*price;
				
				//MyShop클래스에 저장 #1
				/*
				L07_MyShop s = new L07_MyShop(); //디폴트 생성
				
				s.setSangpum(sang);
				s.setSu(su);
				s.setPrice(price);
				s.setTotal(total);
				*/
				
				//MyShop클래스에 저장 #2
				L07_MyShop s = new L07_MyShop(sang,su,price);
				//s.setTotal(total);
				
				//리스트에 추가
				list.add(s);
				
			}
			
			System.out.println("파일에서 총 "+ list.size()+"개의 상품목록 가져왔음!!");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	//파일 쓰기
	public void shopFileWrite() {
		
		FileWriter fw = null;
		
		try {
			fw = new FileWriter(FILENAME);
			
			//MyShop클래스의 내용을 얻어서 출력
			for(L07_MyShop shop:list) {
				String s = shop.getSangpum() +","+shop.getSu() +","+ shop.getPrice();
				fw.write(s);	
			}
			
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
	
	
	//MyShop입력
	public void showAdd() {
		System.out.println("추가할 상품명은?");
		String sang = sc.nextLine();
		System.out.println("수량은?");
		int su = Integer.parseInt(sc.nextLine());
		System.out.println("가격은?");
		int price = Integer.parseInt(sc.nextLine());
		
		//MyShop클래스가 생성
		L07_MyShop shop = new L07_MyShop(sang, su, price);
		
		//list에 shop추가
		list.add(shop);
		System.out.println("***상품정보가 추가됨.***");
			
	}
	
	
	//파일전체출력
	public void shopAllDatas() {
		
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
