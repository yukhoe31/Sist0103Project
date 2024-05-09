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
	
	//전체 회원 목록 가져와서 보여주기:select * 
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
	
	//신규 회원 등록 폼 가져오기
	@GetMapping("/writememberform")
	public String carform()
	{
		return "carmember/memberform";
	}
	
	//신규 회원 등록 폼에서 신규 회원 등록하기(db로 데이터 post):insert
	@PostMapping("/writemember")
	public String insert(@ModelAttribute("dto") CarMemberDto dto)
	{
		memberInter.insertCarMember(dto);
		return "redirect:memberlist";
	}
	
	//기존 회원 수정 폼 가져오기
	//:carmember테이블에 num값을 보내고-> 그 num값에 맞는 회원 데이터들을 dto형태로 가져오기
	@GetMapping("/updatememberform")
	public String updateForm(@RequestParam("num") String num, Model model) {
	    CarMemberDto dto = memberInter.getMemberData(num);
	    model.addAttribute("dto", dto);
	    return "carmember/memberupdateform";
	}
	
	//수정된 회원데이터를 저장하기(db에 post)
	@PostMapping("/updatemember")
	public String update(@ModelAttribute CarMemberDto dto)
	{
		memberInter.updateCarMember(dto);
		return "redirect:memberlist";
	}
	
	@GetMapping("/deletemember")
	public String delete(@RequestParam String num) {
	    memberInter.deleteCarMember(num);
	    return "redirect:memberlist";
	}


}
