package myshop.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyShopController {

	@Autowired
	MyShopDao dao;
	
	@GetMapping("/")
	public String start() {
		
		return "redirect:shop/list";
	}
	
	@GetMapping("/shop/list")
	public ModelAndView list()
	{
		ModelAndView mview = new ModelAndView();
		
		List<MyShopDto> list = dao.getAllSangpums();
		
		mview.addObject("list", list);
		mview.addObject("totalCount",list.size());
		
		mview.setViewName("myshop/shoplist");
		return mview;
	}
	
	//입력폼
	@GetMapping("/shop/writeform")
	public String addform() {
		return "myshop/addform";
	}
	
	//insert
	@PostMapping("/shop/insert")
	public String add(@ModelAttribute MyShopDto dto) {
		
		dao.insertShop(dto);
		
		return "redirect:list";
	}
	
	//수정폼:updateform
	@GetMapping("/shop/updateform")
	public ModelAndView uform(Long num) {
		
		ModelAndView model = new ModelAndView();
		
		MyShopDto dto = dao.getData(num);
		
		model.addObject("dto",dto);
		model.setViewName("myshop/updateform");
		
		return model;
		
	}
	
	
	//수정:update
	@PostMapping("/shop/update")
	public String update(@ModelAttribute MyShopDto dto) {
		
		dao.updateShop(dto);
		
		return "redirect:list";
	}
	
	
	//삭제:delete
	@GetMapping("/shop/delete")
	public String delete(Long num) {
		
		dao.deleteShop(num);
		
		return "redirect:list";
	}


}
