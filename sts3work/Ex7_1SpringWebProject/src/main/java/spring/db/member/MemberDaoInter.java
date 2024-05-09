package spring.db.member;

import java.util.List;

public interface MemberDaoInter {

	public int getIdCheck(String id);
	public void insertMember(MemberDto dto);
	public int getTotalCount();
	public List<MemberDto> getAllMemberDatas();
	
}
