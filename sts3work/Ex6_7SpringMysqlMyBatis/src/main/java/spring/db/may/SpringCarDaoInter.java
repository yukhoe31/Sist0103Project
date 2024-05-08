package spring.db.may;

import java.util.List;

public interface SpringCarDaoInter {

	public int getTotalCount();
	public void insertCar(SpringCarDto dto);
	public List<SpringCarDto> getAllCarDatas();
	
}
