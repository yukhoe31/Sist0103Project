package boot.data.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import boot.data.dto.AnswerMboardDto;
import boot.data.dto.MemBoardDto;
import boot.data.service.AnsMboardService;
import boot.data.service.MemberService;

@RestController
public class AnswerBoardRestController {

	@Autowired
	AnsMboardService service;
	
	@Autowired
	MemberService mservice;
	
	//insert
	@PostMapping("/board/ainsert")
	public void insert(@ModelAttribute AnswerMboardDto dto, HttpSession session) {
		
		//글쓴사람 id아니고, 로그인한 id
		String myid = (String)session.getAttribute("myid");
		
		//작성자이름
		String name = mservice.getName(myid);
		
		//dto에 넣기
		dto.setMyid(myid);
		dto.setName(name);
		
		//insert
		service.insertAnswer(dto);

	}
	
	//전체출력
	@GetMapping("/board/alist")
	public List<AnswerMboardDto> alist(String num){
		
		return service.getAllAnswer(num);
	}
	
	
	//수정:데이터 받기
	
	
	//수정:수정
	@PostMapping("/board/aupdate")
	public void update(@ModelAttribute AnswerMboardDto dto, HttpSession session) {
		
		//글쓴사람 id아니고, 로그인한 id
		String myid = (String)session.getAttribute("myid");
		
		//작성자이름
		String name = mservice.getName(myid);
		
		//dto에 넣기
		dto.setMyid(myid);
		dto.setName(name);
		
		//insert
		service.updateAnswer(dto);

	}
	
	

	//삭제
	@PostMapping("/board/adelete")
	public void delete(String idx) {
		
		service.deleteAnswer(idx);
	}
}