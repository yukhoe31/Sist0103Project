package boot.guest.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import boot.guest.dto.GuestDto;

@Mapper
public interface GuestMapper {

	public int getTotalCount();
	public void insertGuest(GuestDto dto);
	public List<GuestDto> getAllDatas();
	public int isEqualPassCheck(int num,String pass);
	public void deleteGuest(int num);
}
