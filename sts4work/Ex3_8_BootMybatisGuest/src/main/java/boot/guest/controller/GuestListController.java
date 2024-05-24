package boot.guest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import boot.guest.service.GuestService;

@Controller
public class GuestListController {

	@Autowired
	private GuestService gService;
	
	@GetMapping("/")
	public String start() {
		
		return "redirect:guest/list";
	}
	
	@GetMapping("/guest/list")
	public String list(Model model) {

		int totalCount = gService.getTotalCount();
		
		model.addAttribute("totalCount",totalCount);
		
		
		
		return "guest/guestlist";
	}
}
