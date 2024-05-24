package boot.guest.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import boot.guest.dto.GuestDto;
import boot.guest.service.GuestService;

@Controller
public class GuestInsertController {

	@Autowired
	private GuestService gService;
	
	String photo;
	
	@PostMapping("/guest/insert")
	@ResponseBody
	public Map<String, String> insert(@ModelAttribute GuestDto dto){
		
		dto.setPhoto(photo);
		gService.insertGuest(dto);
		
		Map<String, String> map = new HashMap<>();
		
		//호출한 곳으로 일단 메세지 보낵
		map.put("msg", "insert성공");
		
		return map;
		
	}
	
	
}
