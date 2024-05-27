package boot.data.mapper;

import org.apache.ibatis.annotations.Mapper;

import boot.data.dto.IpgoDto;

@Mapper
public interface IpgoMapperInter {

	public int getTotalCount();//이 메서드명이 sql의 아이디가 된다.
	
	public void insertIpgo(IpgoDto dto);
	
	
	
}
