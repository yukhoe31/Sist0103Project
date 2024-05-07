package spring.day0507.rainy;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board")
public class PhotoUploadController {

	//���ε���1�� ����
	@GetMapping("/uploadform1")
	public String uploadform1() {
		
		return "board/uploadform1";
	}
	
	@PostMapping("/upload1")
	public ModelAndView read1(
			@RequestParam String title,
			@RequestParam MultipartFile photo,
			HttpServletRequest request) 
	{	
		ModelAndView mview = new ModelAndView();
		
		//���ε��� ���� ��� ���ϱ�
		String path = request.getSession().getServletContext().getRealPath("/WEB-INF/image");
		System.out.println(path);
		String fileName = photo.getOriginalFilename();//���ε��� ���ϸ�
		
		//���糯¥�� �ð��� �̿��� ���ϸ� ����
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");		
		
		//���ϸ��� ������� ���� ���� �����Ѵ�!
		if(!fileName.equals("")) {
			fileName = sdf.format(new Date()) + "_" +fileName;
			//path�� ���ε��ϱ�
			try {
				photo.transferTo(new File(path + "\\"+fileName));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			
			fileName = "no"; //���ε� ���������
			
		}
		
		mview.addObject("fileName", fileName);
		mview.addObject("title",title);
		mview.addObject("path", path);
		
		mview.setViewName("board/uploadresult1");
				
		return mview;
	}
	
	
	//���ε���2�� ����
	@GetMapping("/uploadform2")
	public String uploadform2() {
		
		return "board/uploadform2";
	}
	
	@PostMapping("/upload2")
	public ModelAndView read2(
			@RequestParam String title,
			@RequestParam ArrayList<MultipartFile> photo,
			HttpServletRequest request) 
	{	
		ModelAndView mview = new ModelAndView();
		
		//���ε��� ���� ��� ���ϱ�
		String path = request.getSession().getServletContext().getRealPath("/WEB-INF/image");
		
		//���糯¥�� �ð��� �̿��� ���ϸ� ����
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		ArrayList<String> files = new ArrayList<String>();
		
		//���ϸ� ���
		for(MultipartFile f:photo) {
			
			String fileName = sdf.format(new Date()) +"_"+f.getOriginalFilename();
			files.add(fileName);
			
			//�������ε�
			try {
				f.transferTo(new File(path+"\\"+fileName));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		mview.addObject("files", files); // Add the list of file names instead of fileName
		mview.addObject("title", title);
		mview.addObject("path", path);

		mview.setViewName("board/uploadresult2");
				
		return mview;
	}
	
	
	
	
}
