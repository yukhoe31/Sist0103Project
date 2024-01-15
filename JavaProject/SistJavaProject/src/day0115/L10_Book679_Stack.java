package day0115;

import java.util.Stack;

//같은 페이지에는 public 두개이상 안된다.
//따라서 책과는 다르게 class Coin앞의 public을 없애라.
class Coin{
	
	private int value;
	
	//디폴트 생성자
	public Coin() {
		// TODO Auto-generated constructor stub
	}
	
	//명시적 생성자
	public Coin(int value) {
		// TODO Auto-generated constructor stub
		this.value = value;
	}

	//getter setter
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	
}


public class L10_Book679_Stack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Stack 컬렉션 생성
		Stack<Coin> coinBox = new Stack<Coin>();
		
		//동전 넣기
		coinBox.push(new Coin(100));
		coinBox.push(new Coin(50));
		coinBox.push(new Coin(500));
		coinBox.push(new Coin(10));
		
		//동전을 하나씩 꺼내기
		while(!coinBox.isEmpty()) {
			Coin coin = coinBox.pop();
			System.out.println("꺼내온동전: "+coin.getValue() + "원");
		}
	}

}
