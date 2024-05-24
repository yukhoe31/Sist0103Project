package boot.guest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import boot.guest.dto.GuestDto;
import boot.guest.service.GuestService;

@Controller
public class GuestListController {

	@Autowired
	private GuestService gService;
	
	//이렇게하면 그냥 localhost:9001만 적어도 알아서
	//http://localhost:9001/guest/list 로 매핑된다.
	@GetMapping("/")
	public String start() {
		
		return "redirect:guest/list";
	}
	
	@GetMapping("/guest/list")
	public String list(Model model) {

		int totalCount = gService.getTotalCount();
		
		List<GuestDto> list = gService.getAllDatas();
		
		model.addAttribute("totalCount",totalCount);
		model.addAttribute("list",list);
		
		return "guest/guestlist";
	}
	
	
	
}
