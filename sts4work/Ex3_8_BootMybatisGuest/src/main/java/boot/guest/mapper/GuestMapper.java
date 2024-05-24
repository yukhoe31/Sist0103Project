package boot.guest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import boot.guest.dto.GuestDto;

@Mapper
public interface GuestMapper {

	public int getTotalCount();
	public void insertGuest(GuestDto dto);
	public List<GuestDto> getAllDatas();
	@Select("select pass from guest where num = #{num}")
    String getPasswordById(@Param("num") int num);
    @Delete("delete from guest where num = #{num}")
    void deleteGuest(@Param("num") int num);
}
	

