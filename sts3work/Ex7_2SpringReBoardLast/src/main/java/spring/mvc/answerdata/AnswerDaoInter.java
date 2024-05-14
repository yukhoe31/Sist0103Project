package spring.mvc.answerdata;

import java.util.List;

public interface AnswerDaoInter {
	
	public void insertAnswer(AnswerDto dto);
	public List<AnswerDto> getAnswerList(int num);

}
