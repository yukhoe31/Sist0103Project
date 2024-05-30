package boot.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}