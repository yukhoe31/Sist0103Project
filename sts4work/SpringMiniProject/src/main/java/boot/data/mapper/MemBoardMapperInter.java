package boot.data.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemBoardMapperInter {

	public int getTotalCount();
}