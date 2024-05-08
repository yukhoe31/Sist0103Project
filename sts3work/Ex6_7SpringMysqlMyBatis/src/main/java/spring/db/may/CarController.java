package spring.db.may;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/samsung")
public class CarController {

	@Autowired
	SpringCarDaoInter carInter;
	
	@GetMapping("/list")
	public String list(Model model)
	{
		//dao로 부터 총갯수 저장
		int totalCount=carInter.getTotalCount();
		
		//목록가져오기
		List<SpringCarDto> list=carInter.getAllCarDatas();
		
		//request에 저장
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", list);
		
		return "car/carlist";
	}
	
	@GetMapping("/writeform")
	public String carform()
	{
		return "car/addform";
	}
	
	@PostMapping("/write")
	public String insert(@ModelAttribute("dto") SpringCarDto dto)
	{
		carInter.insertCar(dto);
		return "redirect:list";
	}
}
