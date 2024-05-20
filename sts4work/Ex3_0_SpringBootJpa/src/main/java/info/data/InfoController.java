package info.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import myshop.data.MyShopDto;

@Controller
public class InfoController {

	@Autowired
	InfoDao dao;
	
	@GetMapping("/info/list")
	public ModelAndView list() {
		ModelAndView model = new ModelAndView();
		
		List<InfoDto> list = dao.getAllDatas();
		
		model.addObject("list",list);
		model.addObject("count",list.size());
		
		model.setViewName("info/infolist");
		return model;
	}
	
	//폼
	@GetMapping("/info/addform")
	public String form() {
		
		return "info/addform";
	}
	
	//insert
	@PostMapping("/info/insert")
	public String add(@ModelAttribute InfoDto dto) {
		
		dao.insertInfo(dto);
		
		return "redirect:list";
	}
	
	//update폼
	@GetMapping("/info/updateform")
	public String uform() {
		
		return "info/updateform";
	}
	
	
	//update
	@PostMapping("/info/update")
	public String update(@ModelAttribute InfoDto dto) {
		
		dao.updateInfo(dto);
		
		return "redirect:list";
	}
	
	
	//삭제:delete
	@GetMapping("/info/delete")
	public String delete(Integer num) {
		
		dao.deleteInfo(num);
		
		return "redirect:list";
	}



}
