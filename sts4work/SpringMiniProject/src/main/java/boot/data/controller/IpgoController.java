package boot.data.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import boot.data.dto.IpgoDto;
import boot.data.mapper.IpgoMapperInter;
import javax.servlet.http.HttpSession;

@Controller
public class IpgoController {

	@Autowired
	IpgoMapperInter mapper;

	@GetMapping("/")
	public String start() {

		return "redirect:ipgo/list";
	}

	@GetMapping("/ipgo/list")
	public ModelAndView list() {

		ModelAndView mview = new ModelAndView();

		int totalCount = mapper.getTotalCount();

		mview.addObject("totalCount",totalCount);
		mview.setViewName("ipgo/ipgolist");


		return mview;
	}

	@GetMapping("/ipgo/writeform")
	public String form() {

		return "ipgo/ipgoform";
	}

	@PostMapping("/ipgo/insert")
	public String insert(@ModelAttribute IpgoDto dto,
			@RequestParam ArrayList<MultipartFile> upload,
			HttpSession session) {

		String path = session.getServletContext().getRealPath("/ipgoimage");

		String uploadName = "";

		if(upload.get(0).getOriginalFilename().equals("")) {
			uploadName = "no";
		}else {
			for(MultipartFile f:upload) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

				String fName = sdf.format(new Date())+"_"+f.getOriginalFilename();

				uploadName += fName+",";

				try {

					f.transferTo(new File(path+"\\"+fName));

				} catch (IllegalStateException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			//마지막 컴마 제거
			uploadName = uploadName.substring(0, uploadName.length()-1);


		}

		dto.setPhotoname(uploadName);

		mapper.insertIpgo(dto);
		
		
		return "redirect:list";
	}

}
