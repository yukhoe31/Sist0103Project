package day0115;

public class L09_Board {

	private String writer;
	private String subject;
	private String content;
	
	//디폴트 생성자
	public L09_Board() {
		// TODO Auto-generated constructor stub
	}
	
	//명시적 생성자
	public L09_Board(String writer, String subject, String content) {
		// TODO Auto-generated constructor stub
		this.writer = writer;
		this.subject = subject;
		this.content = content;
	}
	
	//getter setter
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}


