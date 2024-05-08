package spring.db.carmember;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarMemberDao implements CarMemberDaoInter {

	@Autowired
	private SqlSession session;
	
	@Override
	public int getTotalCount() {
		
		return session.selectOne("totalCountOfCarMember");
	}
	
	@Override
	public void insertCarMember(CarMemberDto dto) {
		
		session.insert("insertOfMyCarMember", dto);
	}
	
	@Override
	public List<CarMemberDto> getAllCarMemberDatas(){
		
		return session.selectList("getAllOfMyCarMember");
	}
	
	@Override
	public CarMemberDto getMemberData(String num) {
		
		return session.selectOne("selectOneOfCarMember",num);
	}
	
	@Override
	public void updateCarMember(CarMemberDto dto) {
		
		session.update("updateOfCarMember", dto);
	}
	
	@Override
	public void deleteCarMember(String num) {
		
		session.delete("deleteOfCarMember", num);
	}
}
