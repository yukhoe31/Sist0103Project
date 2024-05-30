package boot.data.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.data.dto.MemBoardDto;
import boot.data.mapper.MemBoardMapperInter;

@Service
public class MemBoardService implements MemBoardServiceInter {

	@Autowired
	MemBoardMapperInter mapperInter;
	
	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return mapperInter.getTotalCount();
	}
	
	@Override
	public MemBoardDto getData(String num) {
		// TODO Auto-generated method stub
		return mapperInter.getData(num);
	}
	
	@Override
	public List<MemBoardDto> getList(int start, int perpage) {
		// TODO Auto-generated method stub
		
		HashMap<String, Integer> map = new HashMap<>();
		map.put("start", start);
		map.put("perpage", perpage);
		
		
		return null;
	}
	@Override
	public int getMaxNum() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public void insertMemBoard(MemBoardDto dto) {
		// TODO Auto-generated method stub
		mapperInter.insertMemBoard(dto);
	}
	
	@Override
	public void updateReadCount(String num) {
		// TODO Auto-generated method stub
		mapperInter.updateReadCount(num);
	}

}