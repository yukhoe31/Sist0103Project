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

	//ȸ�� ��� ����
	@GetMapping("list")
	public String list(Model model)
	{
		//dao�� ���� �Ѱ��� ����
		int totalCount=memInter.getTotalCount();

		//��ϰ�������
		List<MemberDto> list=memInter.getAllMemberDatas();

		//request�� ����
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", list);

		return "member/memberlist";
	}

	//ȸ������ �� ��������
	@GetMapping("writeform")
	public String form()
	{
		return "member/addform";
	}

	//���̵� �ߺ� Ȯ���ϱ�
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

	//ȸ�������ϱ�(db����)
	@PostMapping("/insert")
	public String insert(@ModelAttribute("dto") MemberDto dto)
	{
		memInter.insertMember(dto);
		return "redirect:list";
	}



}
