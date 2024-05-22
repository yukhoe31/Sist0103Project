package boot.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import boot.data.BookDto;
import boot.data.BookMapperInter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class BookController {

	@Autowired
	BookMapperInter mapper;

	@GetMapping("/")
	public String start()
	{
		return "redirect:book/list";
	}

	@GetMapping("/book/list")
	public ModelAndView list()
	{
		ModelAndView mview=new ModelAndView();

		//db로부터 총갯수얻기
		int totalCount=mapper.getTotalCount();

		//저장
		mview.addObject("totalCount", totalCount);

		//리스트로 보여주기
		List<BookDto> list = mapper.getAllDatas();

		mview.addObject("list", list);
		//포워드
		mview.setViewName("book/booklist");
		return mview;
	}
	

	@GetMapping("/book/addform")
	public String form() {
		return "book/addform";
	}

	@PostMapping("/book/insert")
	public String insert(@ModelAttribute BookDto dto,
			@RequestParam MultipartFile photo,
			HttpServletRequest request) {
		
		String path = request.getServletContext().getRealPath("/bookimage");
		System.out.println(path);

		if(photo.getOriginalFilename().equals("")) {
			dto.setBookimage("no");
		}else {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String photoname = sdf.format(new Date())+photo.getOriginalFilename();
			dto.setBookimage(photoname);

			try {
				photo.transferTo(new File(path+"\\"+photoname));
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		// db에 insert
		mapper.insertBook(dto);

		return "redirect:list";

	}


	//수정버튼 누르면 수정폼 나오게
	@GetMapping("/book/updateform")
	public ModelAndView uform(@RequestParam String num) {

		ModelAndView mview = new ModelAndView();

		BookDto dto = mapper.getData(num);

		mview.addObject("dto",dto);
		mview.setViewName("market/updateform");

		return mview;
	}


	@PostMapping("/book/update")
	public String update(@ModelAttribute BookDto dto,
			@RequestParam MultipartFile photo,
			HttpServletRequest request) {

		String path = request.getServletContext().getRealPath("/bookimage");
		System.out.println(path);

		if(photo.getOriginalFilename().equals("")) {
			dto.setBookimage("no");
		}else {
			
			//수정 전에 이전 사진 지우기
			String pre_photo = mapper.getData(dto.getNum()).getBookimage();
			File file = new File(path + "\\" + pre_photo);
			
			if(file.exists()) {
				file.delete();
			}

			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String photoname = sdf.format(new Date())+photo.getOriginalFilename();
			dto.setBookimage(photoname);

			try {
				photo.transferTo(new File(path+"\\"+photoname));
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		// db에 update
		mapper.updateBook(dto);

		return "redirect:list";
	}

	//삭제:delete
	@GetMapping("/book/delete")
	public String delete(@RequestParam String num, HttpSession session) {
		
		//삭제시 photo 폴더 내의 사진도 지우기
		String photo = mapper.getData(num).getBookimage();
		
		if(!photo.equals(null)) {
			
			String path = session.getServletContext().getRealPath("/bookimage");
			
			File file = new File(path +"\\" +photo);
		
			if(file.exists()) {
				file.delete();
			}
		
		}

		mapper.deleteBook(num);

		return "redirect:list";
	}



}
