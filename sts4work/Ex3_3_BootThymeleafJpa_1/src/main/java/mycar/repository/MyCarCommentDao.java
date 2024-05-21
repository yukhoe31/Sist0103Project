package mycar.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import mycar.data.MyCarCommentDto;

@Repository
@AllArgsConstructor
public class MyCarCommentDao {

	private MyCarCommentDaoInter commentDaoInter;
	
	//댓글저장
	public void insertCommentMyCar(MyCarCommentDto dto)
	{
		commentDaoInter.save(dto);
	}
	
	//댓글목록
	public List<MyCarCommentDto> getMyCarCommentList(Long num)
	{
		return commentDaoInter.getMyCarCommentList(num);
	}
}