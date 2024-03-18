package simpleboard.model;

import java.sql.Timestamp;

public class SimpleBoardDto {

	private String num;
	private String writer;
	private String pass;
	private String subject;
	private String content;
	private int readcount;
	private Timestamp writeday;
	private int answercount; //댓글개수
	
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
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
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public Timestamp getWriteday() {
		return writeday;
	}
	public void setWriteday(Timestamp writeday) {
		this.writeday = writeday;
	}
	
	//댓글개수저장
	public int getAnswercount() {
		return answercount;
	}
	
	public void setAnswercount(int answercount) {
		this.answercount = answercount;
	}
	
	
	
	
}