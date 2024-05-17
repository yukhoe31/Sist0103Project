package board.data;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {

	@Autowired
	BoardDao dao;

	@GetMapping("/")
	public String home() {
		return "redirect:board/list";
	}

	@GetMapping("/board/list")
	public ModelAndView list() {
		ModelAndView model = new ModelAndView();
		List<BoardDto> list = dao.getAllDatas();
		model.addObject("list", list);
		model.addObject("count", list.size());
		model.setViewName("board/boardlist");
		return model;
	}

	@GetMapping("/board/addform")
	public String form() {
		return "board/writeform";
	}

	@PostMapping("/board/add")
	public String insert(@ModelAttribute BoardDto dto,
			@RequestParam MultipartFile upload,
			HttpSession session) {
		// 실제경로
		String realPath = session.getServletContext().getRealPath("/save");
		System.out.println(realPath);

		String uploadName = upload.getOriginalFilename();

		if (upload.isEmpty())
			dto.setPhoto("no");
		else {
			dto.setPhoto(uploadName);
			// 실제업로드
			try {
				upload.transferTo(new File(realPath + "\\" + uploadName));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}

		// db에저장
		dao.insertBoard(dto);
		return "redirect:list";
	}

	@GetMapping("/board/detail")
	public ModelAndView todetail(@RequestParam long num) {
		ModelAndView model = new ModelAndView();
		BoardDto dto = dao.getData(num);
		model.addObject("dto", dto);
		model.addObject("subject", dto.getSubject());
		model.addObject("writer", dto.getWriter());
		model.addObject("writeday", dto.getWriteday());
		model.addObject("content", dto.getContent());
		model.addObject("photo", dto.getPhoto());
		model.setViewName("board/detail");
		return model;
	}

	@GetMapping("/board/updateform")
	public ModelAndView updateForm(@RequestParam long num) {
		ModelAndView model = new ModelAndView();
		BoardDto dto = dao.getData(num);
		model.addObject("dto", dto);
		model.setViewName("board/updateform");
		return model;
	}

	@PostMapping("/board/update")
	public String update(@ModelAttribute BoardDto dto,
			@RequestParam MultipartFile upload,
			HttpSession session) {
		// 실제경로
		String realPath = session.getServletContext().getRealPath("/save");
		String uploadName = upload.getOriginalFilename();

		if (!upload.isEmpty()) {
			dto.setPhoto(uploadName);
			try {
				upload.transferTo(new File(realPath + "\\" + uploadName));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		} else {
			// If no new image is uploaded, retain the existing image
			BoardDto existingDto = dao.getData(dto.getNum()); // Fetch existing data
			dto.setPhoto(existingDto.getPhoto()); // Set existing image path
		}

		dao.updateBoard(dto);
		return "redirect:list";
	}


	@GetMapping("/board/delete")
	public String delete(@RequestParam long num) {
		dao.deleteBoard(num);
		return "redirect:list";
	}



}
