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
import org.springframework.web.bind.annotation.RestController;
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

	//bookupload는 addform.jsp에서 받아온 file입니다.
	//arguments값이 dto, bookupload, request가 있는데, 각각의 역할은
	//dto: BookDto 데이터베이스에 저장하기 위해
	//bookupload: bookphoto폴더에 이미지 파일을 저장하기 위해(저장할 사진 파일이야!)
	//request: 
	@PostMapping("/book/insert")
	public String insert(@ModelAttribute BookDto dto,
			@RequestParam MultipartFile bookupload, 
			HttpServletRequest request) {

		String path = request.getServletContext().getRealPath("/bookphoto");
		System.out.println(path);

		if(bookupload.getOriginalFilename().equals("")) {
			dto.setBookimage("no");
		}else {

			//이건 저장할 사진의 이름을 정하기 위한 sdf야!
			//시간을 정확히 해서 이름짓기를 하고 파일에 저장하면
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			
			//
			String photoname = sdf.format(new Date())+bookupload.getOriginalFilename();
			dto.setBookimage(photoname);

			try {
				bookupload.transferTo(new File(path+"\\"+photoname));
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		// db에 insert
		mapper.insertBook(dto);

		return "redirect:list";

	}



}
