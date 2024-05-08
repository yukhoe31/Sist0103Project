package spring.db.carmember;

import java.util.List;

public interface CarMemberDaoInter {
	
	public int getTotalCount();
	public void insertCarMember(CarMemberDto dto);
	public List<CarMemberDto> getAllCarMemberDatas();
	public CarMemberDto getMemberData(String num);
	public void updateCarMember(CarMemberDto dto);
	public void deleteCarMember(String num);

}
