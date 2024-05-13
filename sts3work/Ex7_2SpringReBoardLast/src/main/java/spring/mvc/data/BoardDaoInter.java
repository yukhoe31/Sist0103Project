package spring.mvc.data;

import java.util.List;

public interface BoardDaoInter {

	public int getTotalCount();
	public int getMaxNum();
	public void updateRestep(int regroup,int restep);
	public void insertBoard(BoardDto dto);
	public List<BoardDto> getList(int start,int perpage);
	public void updateReadCount(int num);
	public BoardDto getOneData(int num);
}
