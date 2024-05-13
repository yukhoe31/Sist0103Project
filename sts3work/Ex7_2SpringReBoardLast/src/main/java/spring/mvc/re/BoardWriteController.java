package spring.mvc.re;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.data.BoardDaoInter;
import spring.mvc.data.BoardDto;

@Controller
public class BoardWriteController {

	@Autowired
	BoardDaoInter dao;
	
	//새글 답글 모두 해당
	
	@GetMapping("/board/writeform")
	public ModelAndView form(@RequestParam Map<String, String> map)
	{
		ModelAndView mview=new ModelAndView();
		
		//아래 5개의 값은 답글일경우에만 넘어옴(새글은 안넘어옴)
		String currentPage=map.get("currentPage");
		String num=map.get("num");
		String regroup=map.get("regroup");
		String restep=map.get("restep");
		String relevel=map.get("relevel");
		
		System.out.println(currentPage+","+num);
		
		//입력폼에 hidden으로 넣어줘야함..답글일때를 대비
		
		mview.addObject("currentPage", currentPage==null?"1":currentPage);
		mview.addObject("num", num==null?"0":num);
		mview.addObject("regroup", regroup==null?"0":regroup);
		mview.addObject("restep", restep==null?"0":restep);
		mview.addObject("relevel", relevel==null?"0":relevel);
		
		//0으로 넣어야 dao에서 새글로 인식
		
		
		mview.setViewName("board/writeform");
		return mview;
	}
	
	@PostMapping("/board/insert")
	public String insert(@ModelAttribute BoardDto dto,
			@RequestParam ArrayList<MultipartFile> upload,
			HttpSession session)
	{
		String path=session.getServletContext().getRealPath("/WEB-INF/photo");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		System.out.println(path);
		
		String photo="";
		if(upload.get(0).getOriginalFilename().equals(""))
			photo="no";
		else {
			
			for(MultipartFile f:upload)
			{
				String fName=sdf.format(new Date())+f.getOriginalFilename();
				photo+=fName+",";
				
				//업로드
				try {
					f.transferTo(new File(path+"\\"+fName));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			photo=photo.substring(0, photo.length()-1);
			
		}
		
		dto.setPhoto(photo);
		dao.insertBoard(dto);
		
		return "redirect:list";
	}
}
