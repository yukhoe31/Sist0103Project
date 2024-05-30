package boot.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import boot.data.service.MemBoardService;

@Controller
public class BoardController {

	@Autowired
	MemBoardService service;
	
	@GetMapping("/board/list")
	public ModelAndView list()
	{
		ModelAndView mview=new ModelAndView();
		
		int totalCount=service.getTotalCount();
		
		mview.addObject("totalCount", totalCount);
		mview.setViewName("/board/boardlist");
		return mview;
	}
	
	@GetMapping("/board/form")
	public String form()
	{
		return "/board/writeform";
	}
}