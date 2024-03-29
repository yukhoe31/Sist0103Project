package day0115;

abstract class Game{
	abstract public void play();
	abstract public void stop();
	
}
//////////////////
class Kim extends Game{

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("kim게임 시작");
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("kim게임 중단");
	}
	
	
}
//////////////////
class Lee extends Game{

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("lee게임 시작");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("lee게임 중단");
	}
	
}
///////////////////
class Choi extends Game{

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("choi게임 시작");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("choi게임 중단");
	}
	
}


///////////////////
public class L02_AbstractReview {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Game game = null;//선언만
		
		game = new Kim();//생성
		game.play();
		game.stop();
		
		game = new Lee();//생성
		game.play();
		game.stop();
		
		game = new Choi();//생성
		game.play();
		game.stop();
		
		System.out.println("***************");
		
		
		Game[] game2 = new Game[3]; //선언만
		game2[0] = new Kim();//생성
		game2[1] = new Lee();
		game2[2] = new Choi();
		
		for(int i=0; i<game2.length; i++) {
			game2[i].play();
		}
		System.out.println("================");
		
		for(int i=game2.length-1; i>=0 ;i--) {
			game2[i].stop();
		}

	}

}
