package spring.db.board;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardDaoInter dao;
	
	@GetMapping("/list")
	public ModelAndView list()
	{
		ModelAndView mview=new ModelAndView();
		
		//�Ѱ��� ���ϱ�
		int totalCount=dao.getTotalCount();
		//����Ʈ
		List<BoardDto> list=dao.getAllList();
		
		//����
		mview.addObject("totalCount", totalCount);
		mview.addObject("list", list);
		
		//������
		mview.setViewName("board/boardlist");
		
		return mview;
	}
	
	//�۾��� ��
	@GetMapping("/addform")
	public String addform()
	{
		
		return "board/writeform";
	}
	
	
	//insert
	@PostMapping("/insert")
	public String insert(@ModelAttribute BoardDto dto,
			@RequestParam ArrayList<MultipartFile> upload,
			HttpSession session)
	{
		//�̹����� ���ε�� ����
		String path=session.getServletContext().getRealPath("/WEB-INF/photo");
		System.out.println(path);
		
		//�̹��� ���ε� ��������� null or "no"
		String photo="";
		
		//���������� �ϸ� ,�γ���
		if(upload.get(0).getOriginalFilename().equals(""))
			photo="no";
		else {
			
			for(MultipartFile f:upload)
			{
				String fName=f.getOriginalFilename();
				photo+=fName+",";
				
				//���ε�
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
			
			//photo���� ������ �ĸ�����
			photo=photo.substring(0, photo.length()-1);
		}
		
		//dto�� photo�� �־��ֱ�
		dto.setPhoto(photo);
		
		//insert
		dao.insertBoard(dto);
		
		return "redirect:list";
	}
}
