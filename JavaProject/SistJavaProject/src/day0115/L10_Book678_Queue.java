package day0115;

import java.util.LinkedList;
import java.util.Queue;

class Message{
	
	public String command;
	public String to;
	
	public Message(String command, String to) {
		// TODO Auto-generated constructor stub
		this.command = command;
		this.to = to;
	}
}

//인터페이스라고해서 클래스보다 덩치가 큰게 아니다!
//Set,Map,List는 인터페이스이고, 
//List내부에는 ArrayList,Vector,LinkedList 클래스 등이 존재하는데
//Queue 인터페이스는 LinkedList 클래스 내에 존재한다.
//인터페이스와 클래스는 종류가 다를뿐, 누가 더 범위가 크거나 작거나 하는 문제가 아니다.

public class L10_Book678_Queue {

	public static void main(String[] args) {
		
		//Queue 컬렉션 생성
		//Queue는 LinkedList 클래스 내의 인터페이스이다.
		Queue<Message> messageQueue = new LinkedList<>();
		
		//메세지 넣기
		messageQueue.offer(new Message("sendMail","홍길동"));
		messageQueue.offer(new Message("sendSMS","신용권"));
		messageQueue.offer(new Message("sendKakaotalk","감자바"));
		
		//메세지를 하나씩 꺼내어 처리
		while(!messageQueue.isEmpty()) {
			Message message = messageQueue.poll();
			switch(message.command) {
			case "sendMail":
				System.out.println(message.to + "님에게 메일을 보냅니다.");
				break;
			case "sendSMS":
				System.out.println(message.to + "님에게 메일을 보냅니다.");
				break;
			case "sendKakaotalk":
				System.out.println(message.to + "님에게 메일을 보냅니다.");
				break;
			}
		}
		
	}
}
