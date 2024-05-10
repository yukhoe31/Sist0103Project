package spring.db.member;

import java.util.HashMap;
import java.util.List;

public interface MemberDaoInter {

	public int getIdCheck(String id);
	public void insertMember(MemberDto dto);
	public List<MemberDto> getAllMembers();
	public MemberDto getMember(String num);
	public int passCheck(String num,String pass);
	public void updateMember(MemberDto dto);
}
