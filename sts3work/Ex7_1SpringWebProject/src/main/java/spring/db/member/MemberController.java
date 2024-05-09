package spring.db.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberDaoInter memInter;

	//회원 목록 보기
	@GetMapping("list")
	public String list(Model model)
	{
		//dao로 부터 총갯수 저장
		int totalCount=memInter.getTotalCount();

		//목록가져오기
		List<MemberDto> list=memInter.getAllMemberDatas();

		//request에 저장
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", list);

		return "member/memberlist";
	}

	//회원가입 폼 가져오기
	@GetMapping("writeform")
	public String form()
	{
		return "member/addform";
	}

	//아이디 중복 확인하기
	@GetMapping("/idcheck")
	@ResponseBody
	public Map<String, Integer> idcheck(@RequestParam String id)
	{
		Map<String, Integer> map=new HashMap<String, Integer>();
		int count=memInter.getIdCheck(id);
		System.out.println(count);
		map.put("count", count);
		return map;
	}

	//회원가입하기(db저장)
	@PostMapping("/insert")
	public String insert(@ModelAttribute("dto") MemberDto dto)
	{
		memInter.insertMember(dto);
		return "redirect:list";
	}



}
