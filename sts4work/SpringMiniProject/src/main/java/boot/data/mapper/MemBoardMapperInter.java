package boot.data.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import boot.data.dto.MemBoardDto;

@Mapper
public interface MemBoardMapperInter {

	public int getTotalCount();
	public void insertMemBoard(MemBoardDto dto);
	public List<MemBoardDto> getList(HashMap<String, Integer> map);
	public MemBoardDto getData(String num);
	public void updateReadCount(String num);
	public int getMaxNum();	
	
}