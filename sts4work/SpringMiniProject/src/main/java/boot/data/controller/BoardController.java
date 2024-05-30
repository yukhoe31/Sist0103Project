package boot.data.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import boot.data.dto.MemBoardDto;
import boot.data.dto.MemberDto;
import boot.data.service.MemBoardService;
import boot.data.service.MemberService;

@Controller
public class BoardController {

	@Autowired
	MemBoardService service;
	
	@Autowired
	MemberService mservice;
	
	@GetMapping("/board/list")
	public ModelAndView list()
	{
		ModelAndView mview=new ModelAndView();
		
		int totalCount=service.getTotalCount();
		int maxnum = service.getMaxNum();
		
		List<MemBoardDto> list=service.getList(totalCount, maxnum);
		mview.addObject("list", list);
		
		mview.addObject("totalCount", totalCount);
		mview.setViewName("/board/boardlist");
		return mview;
	}
	
	@GetMapping("/board/form")
	public String form()
	{
		return "/board/writeform";
	}
	
	@PostMapping("/board/insert")
	public String insert(@ModelAttribute MemBoardDto dto,HttpSession session)
	{
		String path=session.getServletContext().getRealPath("/boardphoto");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		
		if(dto.getUpload().getOriginalFilename().equals(""))
			dto.setUploadfile("no");
		else {
			String uploadfile=sdf.format(new Date())+dto.getUpload().getOriginalFilename();
			dto.setUploadfile(uploadfile);
			
			try {
				dto.getUpload().transferTo(new File(path+"\\"+uploadfile));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		//세션에서 아이디 얻어서 dto저장
		String myid=(String)session.getAttribute("myid");
		dto.setMyid(myid);
		
		//이름
		String name=mservice.getName(myid);
		dto.setName(name);
		
		//insert
		service.insertMemBoard(dto);
		
		
		
		return "redirect:list";
	}
}