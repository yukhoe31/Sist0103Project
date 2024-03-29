package day0111;

class Artist{
	
	//변수명
	private String groupName;
	private String groupSong;
	
	static String agency;//소속사는 공통사항이라서.
	static int count = 0;
	//※ count가 static인 이유: 
	//생성자(bts,뉴진스...와는 무관하게
	//Artist 내에서 자동으로 세어야 하는 내용이므로)
	
	//명시적 생성자(디폴트 생성자 필요x)
	//※생성자는 메서드와 다르게 void같은거 안쓴다!->헷갈리지 말것!!
	public Artist(String name, String song) {
		this.groupName = name;
		this.groupSong = song;
	}
	
	//출력메서드 한번에 만들기
	public void writeArtistInfo() {
		count++;
		System.out.println("***아티스트 정보_"+count+"***");
		System.out.println("소속기획사: "+ Artist.agency);//앞에 Artist없이 그냥 agency라고 써도 된다.
		System.out.println("그룹명: "+this.groupName);
		System.out.println("대표곡: "+this.groupSong);
		System.out.println("--------------------------");
	}
	
}

//////////////
public class L06_QuizInstance {

	public static void main(String[] args) {
		
		Artist a1 = new Artist("bts", "버터");
		Artist a2 = new Artist("뉴진스","어텐션");
		
		Artist.agency = "하이브";//소속사는 둘다 공통이라.
		
		a1.writeArtistInfo();
		a2.writeArtistInfo();

	}

}
