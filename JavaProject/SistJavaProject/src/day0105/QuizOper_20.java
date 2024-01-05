package day0105;
import java.util.Scanner;
public class QuizOper_20 {
	public static void main(String[] args) {
		/* (상품을 5개 이상 구매시 10% 할인하여 계산된다.)
		 * 상품명: 키보드
		 * 수량: 3
		 * 가격: 20000
		 * 
		 * =================================
		 * **5개 이상 구매시 10% 할인됩니다.
		 * 키보드 3개는 총 60000원 입니다.
		 * 할인된 금액: 10000원
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("상품명: ");
		String name = sc.nextLine();
		
		System.out.print("수량: ");
		int num = Integer.parseInt(sc.nextLine());
		
		System.out.print("가격: ");
		int price = Integer.parseInt(sc.nextLine());
		
		int total = num*price;
		int sale = total;
		
		if (num>=5) {
			sale *= 0.9;
		}		
		System.out.println("==============================");
		System.out.println("**5개 이상 구매시 10%할인됩니다.");
		System.out.println(name+" "+num+"개는 총 "+ sale +"원 입니다.");
	}
}
