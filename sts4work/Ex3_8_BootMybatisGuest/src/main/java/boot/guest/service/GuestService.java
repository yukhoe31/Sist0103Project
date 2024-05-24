package boot.guest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.guest.dto.GuestDto;
import boot.guest.mapper.GuestMapper;

@Service
public class GuestService {
	
	@Autowired
	GuestMapper mapper;
	
	public int getTotalCount() {
		
		return mapper.getTotalCount();
	}
	
	public void insertGuest(GuestDto dto) {
		
		mapper.insertGuest(dto);
	}
	
	public List<GuestDto> getAllDatas(){
		
		return mapper.getAllDatas();
	}

    public boolean deleteGuest(int num, String pass) {
        String storedPass = mapper.getPasswordById(num);
        if (storedPass != null && storedPass.equals(pass)) {
        	mapper.deleteGuest(num);
            return true;
        }

        return false;
    }
	
	
}
