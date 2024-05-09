package spring.db.carmember;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/carmember")
public class CarMemberController {
	
	@Autowired
	CarMemberDaoInter memberInter;
	
	@GetMapping("/memberlist")
	public String list(Model model)
	{
		//dao로 부터 총갯수 저장
		int totalCount=memberInter.getTotalCount();
		
		//목록가져오기
		List<CarMemberDto> memberlist=memberInter.getAllCarMemberDatas();
		
		//request에 저장
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("memberlist", memberlist);
		
		return "carmember/memberlist";
	}
	
	@GetMapping("/writememberform")
	public String carform()
	{
		return "carmember/memberform";
	}
	
	@PostMapping("/writemember")
	public String insert(@ModelAttribute("dto") CarMemberDto dto)
	{
		memberInter.insertCarMember(dto);
		return "redirect:memberlist";
	}
	
	@GetMapping("/updatememberform")
	public String updateForm(@RequestParam("num") String num, Model model) {
	    CarMemberDto dto = memberInter.getMemberData(num);
	    model.addAttribute("dto", dto);
	    return "carmember/memberupdateform";
	}
	
	@PostMapping("/updatemember")
	public String update(@ModelAttribute CarMemberDto dto)
	{
		memberInter.updateCarMember(dto);
		return "redirect:memberlist";
	}
	
	@GetMapping("/deletemember")
	public String delete(@RequestParam("num") String num) {
	    memberInter.deleteCarMember(num);
	    return "redirect:memberlist";
	}


}
