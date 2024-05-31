package boot.data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import boot.data.dto.AnswerMboardDto;

@Mapper
public interface AnsMboardMapperInter {

	public void insertAnswer(AnswerMboardDto dto);
	public List<AnswerMboardDto> getAllAnswer(String num);
	public AnswerMboardDto getAnswer(String idx);
	public void updateAnswer(AnswerMboardDto dto);
	public void deleteAnswer(String idx);
}