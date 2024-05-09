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
	
	//��ü ȸ�� ��� �����ͼ� �����ֱ�:select * 
	@GetMapping("/memberlist")
	public String list(Model model)
	{
		//dao�� ���� �Ѱ��� ����
		int totalCount=memberInter.getTotalCount();
		
		//��ϰ�������
		List<CarMemberDto> memberlist=memberInter.getAllCarMemberDatas();
		
		//request�� ����
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("memberlist", memberlist);
		
		return "carmember/memberlist";
	}
	
	//�ű� ȸ�� ��� �� ��������
	@GetMapping("/writememberform")
	public String carform()
	{
		return "carmember/memberform";
	}
	
	//�ű� ȸ�� ��� ������ �ű� ȸ�� ����ϱ�(db�� ������ post):insert
	@PostMapping("/writemember")
	public String insert(@ModelAttribute("dto") CarMemberDto dto)
	{
		memberInter.insertCarMember(dto);
		return "redirect:memberlist";
	}
	
	//���� ȸ�� ���� �� ��������
	//:carmember���̺� num���� ������-> �� num���� �´� ȸ�� �����͵��� dto���·� ��������
	@GetMapping("/updatememberform")
	public String updateForm(@RequestParam("num") String num, Model model) {
	    CarMemberDto dto = memberInter.getMemberData(num);
	    model.addAttribute("dto", dto);
	    return "carmember/memberupdateform";
	}
	
	//������ ȸ�������͸� �����ϱ�(db�� post)
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
