package data.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import data.dto.MarketDto;
import data.mapper.MarketMapperInter;
import jakarta.servlet.http.HttpServletRequest;


@Controller
public class MarketController {

	@Autowired
	MarketMapperInter mapper;

	@GetMapping("/")
	public String start()
	{
		return "redirect:market/list";
	}

	@GetMapping("/market/list")
	public ModelAndView list()
	{
		ModelAndView mview=new ModelAndView();

		//db로부터 총갯수얻기
		int totalCount=mapper.getTotalCount();

		//저장
		mview.addObject("totalCount", totalCount);

		//리스트로 보여주기
		List<MarketDto> list = mapper.getAllDatas();

		mview.addObject("list", list);
		//포워드
		mview.setViewName("market/marketlist");
		return mview;
	}

	
	@GetMapping("/market/addform")
	public String form() {
		return "market/addform";
	}

	@PostMapping("/market/insert")
	public String insert(@ModelAttribute MarketDto dto,
			@RequestParam MultipartFile photo,
			HttpServletRequest request) {

		String path = request.getServletContext().getRealPath("/photo");
		System.out.println(path);

		if(photo.getOriginalFilename().equals("")) {
			dto.setPhotoname(null);
		}else {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String photoname = sdf.format(new Date())+photo.getOriginalFilename();
			dto.setPhotoname(photoname);

			try {
				photo.transferTo(new File(path+"\\"+photoname));
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		// db에 insert
		mapper.insertMarket(dto);

		return "redirect:list";

	}


	//수정버튼 누르면 수정폼 나오게
	@GetMapping("/market/updateform")
	public ModelAndView uform(@RequestParam String num) {
		
		ModelAndView mview = new ModelAndView();
		
		MarketDto dto = mapper.getData(num);
		
		mview.addObject("dto",dto);
		mview.setViewName("market/updateform");
		
		return mview;
	}
	

	@PostMapping("/market/update")
	public String update(@ModelAttribute MarketDto dto,
	                     @RequestParam MultipartFile photo,
	                     HttpServletRequest request) {

	    String path = request.getServletContext().getRealPath("/photo");
	    System.out.println(path);

	    if (!photo.getOriginalFilename().isEmpty()) {
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	        String photoname = sdf.format(new Date()) + photo.getOriginalFilename();
	        dto.setPhotoname(photoname);

	        try {
	            photo.transferTo(new File(path + "\\" + photoname));
	        } catch (IllegalStateException | IOException e) {
	            e.printStackTrace();
	        }
	    } else {
	        // Keep the existing photo name if no new photo is uploaded
	        MarketDto existingDto = mapper.getData(dto.getNum());
	        dto.setPhotoname(existingDto.getPhotoname());
	    }

	    // Update the database with the new or existing photo name
	    mapper.updateMarket(dto);

	    return "redirect:list";
	}
	
	//삭제:delete
	@GetMapping("/market/delete")
	public String delete(@RequestParam String num) {
		
		mapper.deleteMarket(num);
		
		return "redirect:list";
	}


}