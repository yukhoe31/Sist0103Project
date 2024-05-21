package mycar.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import mycar.data.MyCarDto;
import mycar.repository.MyCarDao;

@Controller
@RequiredArgsConstructor
public class MyCarController {

	private final MyCarDao dao;
	
	
	@GetMapping("/")
	public String start()
	{
		return "redirect:list";
	}
	@GetMapping("/list")
	public String list(Model model)
	{
		
		List<MyCarDto> list=dao.getAllCars();
		
		model.addAttribute("list", list);
		model.addAttribute("totalcount", list.size());
		
		return "mycar/mycarlist";
	}
	
	@GetMapping("/writeform")
	public String form()
	{
		return "mycar/mycarform";
	}
	
	@PostMapping("/insert")
	public String insert(@ModelAttribute MyCarDto dto,@RequestParam MultipartFile carupload,
			HttpSession session)
	{
		
		String realPath=session.getServletContext().getRealPath("/save");
		System.out.println(realPath);
		
		String uploadName=carupload.getOriginalFilename();
		
		dto.setCarphoto(uploadName);
		
		//실제업로드
		try {
			carupload.transferTo(new File(realPath+"\\"+uploadName));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//db에 저장
		dao.insertMyCar(dto);
		
		return "redirect:list";
	}
	
	//상세보기
	@GetMapping("/detail")
	public String detail(@RequestParam Long num,Model model)
	{
		MyCarDto dto=dao.getData(num);
		model.addAttribute("dto", dto);
		return "mycar/mycardetail";
	}
	
	//수정폼
	@GetMapping("/updateform")
	public String uform(@RequestParam Long num,Model model)
	{
		MyCarDto dto=dao.getData(num);
		
		model.addAttribute("dto", dto);
		
		return "mycar/updateform";
	}
	
	//삭제
	@GetMapping("/delete")
	public String delete(@RequestParam Long num,HttpSession session)
	{
		//파일사진부터 삭제
		String carphoto=dao.getData(num).getCarphoto();
		String realPath=session.getServletContext().getRealPath("/save");
		
		//파일객체생성후 삭제
		File file=new File(realPath+"\\"+carphoto);
		if(file.exists())
			file.delete();
		
		//db삭제
		dao.deleteMycar(num);
		
		//목록
		return "redirect:list";
	}
	
	
	//수정
	@PostMapping("/update")
	public String update(@ModelAttribute MyCarDto dto,
			@RequestParam MultipartFile upload,HttpSession session)
	{
		if(upload.getOriginalFilename().equals("")) {
			dao.updateMycarNoPhoto(dto);
		}else {
			String realPath=session.getServletContext().getRealPath("/save");
			
			String uploadName=upload.getOriginalFilename();
			
			dto.setCarphoto(uploadName);
			//실제업로드
			try {
				upload.transferTo(new File(realPath+"\\"+uploadName));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			dao.updateMyCar(dto);
		}
		
		//수정후 상세보기
		return "redirect:detail?num="+dto.getNum();
	}
	
}