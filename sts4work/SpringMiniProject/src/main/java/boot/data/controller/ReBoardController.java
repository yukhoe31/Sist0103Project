package boot.data.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import boot.data.dto.MemBoardDto;
import boot.data.dto.ReBoardDto;
import boot.data.service.MemberService;
import boot.data.service.ReBoardService;

@Controller
public class ReBoardController {

	@Autowired
	ReBoardService boardService;
	
	@Autowired
	MemberService mservice;
	
	@GetMapping("/reboard/list")
	public ModelAndView list(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage,
			@RequestParam(value = "searchcolumn",required = false) String sc,
			@RequestParam(value = "searchword",required = false) String sw)
	{
		ModelAndView mview=new ModelAndView();
		
		//페이징에 필요한 변수
				int totalCount=boardService.getTotalCount(sc, sw);
				int perPage=3; //한페이지당 보여질 글의 갯수
				int perBlock=5; //한블럭당 보여질 페이지 갯수
				int start; //db에서 가져올 글의 시작번호(mysql은 첫글이0번,오라클은 1번);
				int startPage; //각블럭당 보여질 시작페이지
				int endPage; //각블럭당 보여질 끝페이지
				int totalPage; //총페이지수
				int no; //각페이지당 출력할 시작번호

				//총페이지수 구한다
				//총글갯수/한페이지당보여질갯수로 나눔(7/5=1)
				//나머지가 1이라도 있으면 무조건 1페이지 추가(1+1=2페이지가 필요)
				totalPage=totalCount/perPage+(totalCount%perPage==0?0:1);

				//각블럭당 보여질 시작페이지
				//perBlock=5일경우 현재페이지가 1~5일경우 시작페이지가1,끝페이지가 5
				//현재가 13일경우 시작:11 끝:15
				startPage=(currentPage-1)/perBlock*perBlock+1;
				endPage=startPage+perBlock-1;

				//총페이지가 23일경우 마지막블럭은 끝페이지가 25가 아니라 23
				if(endPage>totalPage)
					endPage=totalPage;

				//각페이지에서 보여질 시작번호
				//1페이지:0, 2페이지:5 3페이지: 10.....
				start=(currentPage-1)*perPage;

				//각페이지당 출력할 시작번호 구하기
				//총글개수가 23  , 1페이지:23 2페이지:18  3페이지:13
				no=totalCount-(currentPage-1)*perPage;

				//리스트
				List<ReBoardDto> list=boardService.getPagingList(sc, sw, start, perPage);
				
				//저장
				mview.addObject("totalCount", totalCount);
				mview.addObject("list", list);
				mview.addObject("no", no);
				mview.addObject("startPage", startPage);
				mview.addObject("endPage", endPage);
				mview.addObject("currentPage", currentPage);
				mview.addObject("totalPage", totalPage);
		
		
				mview.setViewName("/reboard/boardlist");
		
		
				return mview;
	}
	
	
	@GetMapping("/reboard/form")
	public String form(
			@RequestParam(defaultValue = "0") int num,
			@RequestParam(defaultValue = "0") int regroup,
			@RequestParam(defaultValue = "0") int restep,
			@RequestParam(defaultValue = "0") int relevel,
			@RequestParam(defaultValue = "1") int currentPage,
			Model model)
	{
		//답글일 경우에만 넘어오는 값들이다
		//새글일경우는 모두 null이므로 defaultValue값으로 전달
		
		model.addAttribute("num", num);
		model.addAttribute("regroup", regroup);
		model.addAttribute("restep", restep);
		model.addAttribute("relevel", relevel);
		model.addAttribute("currentPage", currentPage);
		
		//제목에 새글인경우는 "", 답글인경우는 해당제목을 넣기
		String subject="";
		if(num>0) {
			subject=boardService.getData(num).getSubject();
		}
		
		model.addAttribute("subject", subject);
		
		return "/reboard/boardform";
	}
	
	@PostMapping("/reboard/insert")
	public String insert(ReBoardDto dto,int currentPage,List<MultipartFile> upload,
			HttpSession session)
	{
		String path=session.getServletContext().getRealPath("/boardphoto");
		
		if(upload.get(0).getOriginalFilename().equals("")) {
			dto.setPhoto("no");
		}else {
			
			String photo="";
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
			
			for(MultipartFile multi:upload) {
				
				String newName=sdf.format(new Date())+multi.getOriginalFilename();
				photo+=newName+",";
				
				try {
					multi.transferTo(new File(path+"\\"+newName));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			photo=photo.substring(0, photo.length()-1);
			
			dto.setPhoto(photo);
		}
		
	
		
		boardService.insertReBoard(dto);
		return "redirect:list?currentPage="+currentPage;
	}
	
	@GetMapping("/reboard/detail")
	public ModelAndView detail(int num,int currentPage)
	{
		ModelAndView mview=new ModelAndView();
		
		//조회수 증가
		boardService.updateReadCount(num);
		//dto
		ReBoardDto dto=boardService.getData(num);
		
		mview.addObject("dto", dto);
		mview.addObject("currentPage", currentPage);
		mview.setViewName("/reboard/content");
		return mview;
	}
	
	//좋아요
	@GetMapping("/reboard/likes")
	@ResponseBody
	public Map<String, Integer> likes(int num)
	{
		boardService.likesUpdate(num); 
		int likes=boardService.getData(num).getLikes();
		
		Map<String, Integer> map=new HashMap<>();
		map.put("likes", likes);
		return map;
	}
}