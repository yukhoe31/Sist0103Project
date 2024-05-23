package myshop.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import myshop.dto.ShopDto;
import myshop.service.MyShopService;

@Controller
@RequiredArgsConstructor
public class MyShopController {
	


	private final MyShopService shopService;
	
	@GetMapping("/")
	public String list(Model model) {
		
		int totalCount = shopService.getTotalCount();
		
		List<ShopDto> list = shopService.getAllSangpums();
		
		model.addAttribute("totalCount",totalCount);
		model.addAttribute("list",list);
		
		return "myshop/shoplist";
	}
	
	@GetMapping("/addform")
	public String form() {
		
		return "myshop/shopform";
	}
	

	//bookupload는 addform.jsp에서 받아온 file입니다.
	//arguments값이 dto, bookupload, request가 있는데, 각각의 역할은
	//dto: BookDto 데이터베이스에 저장하기 위해
	//bookupload: bookphoto폴더에 이미지 파일을 저장하기 위해(저장할 사진 파일이야!)
	//request: 
	@PostMapping("/insert")
	public String insert(@ModelAttribute ShopDto dto,
			@RequestParam MultipartFile upload, 
			HttpServletRequest request) {

		String realPath = request.getServletContext().getRealPath("/photo");
		System.out.println(realPath);

		if(upload.getOriginalFilename().equals("")) {
			dto.setPhoto("no");
		}else {

			//이건 저장할 사진의 이름을 정하기 위한 sdf야!
			//시간을 정확히 해서 이름짓기를 하고 파일에 저장하면
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			
			//
			String photoname = sdf.format(new Date())+upload.getOriginalFilename();
			dto.setPhoto(photoname);

			try {
				upload.transferTo(new File(realPath+"\\"+photoname));
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		// db에 insert
		shopService.insertShop(dto);

		return "redirect:./";

	}
	
}
