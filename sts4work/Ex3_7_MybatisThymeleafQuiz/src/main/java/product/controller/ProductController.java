package product.controller;

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
import product.dto.ProductDto;
import product.service.ProductService;


@Controller
@RequiredArgsConstructor
public class ProductController {
	
	private final ProductService proService;
	
	@GetMapping("/product/list")
	public String list(Model model)
	{
		int totalCount=proService.getTotalCount();
		List<ProductDto> list=proService.getAllProducts();
		
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", list);
		
		
		return "product/productlist";
	}
	
	
	@GetMapping("product/form")
	public String form()
	{
		return "product/addform";
	}
	
	@PostMapping("product/insert")
	public String insert(@ModelAttribute ProductDto dto,
			@RequestParam MultipartFile upload,
			HttpSession session)
	{
		String realPath=session.getServletContext().getRealPath("/productimage");
		
		String photoname=upload.getOriginalFilename();
		dto.setPro_image(photoname);
		
		try {
			upload.transferTo(new File(realPath+"\\"+photoname));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//db insert
		proService.insertProduct(dto);
		
		return "redirect:/product/list";
	}
	
	
	@GetMapping("product/detail")
	public String detail(@RequestParam int pro_num,Model model)
	{
		ProductDto dto=proService.getData(pro_num);
		model.addAttribute("dto", dto);
		return "product/productdetail";
	}
	
	@GetMapping("product/delete")
	public String delete(@RequestParam int pro_num,HttpSession session)
	{
		String oldFileName=proService.getData(pro_num).getPro_image();
		String realPath=session.getServletContext().getRealPath("/productimage");
		
		File file=new File(realPath+"\\"+oldFileName);
		if(file.exists())
			file.delete();
		
		//db delete
		proService.deleteProduct(pro_num);
		
		return "redirect:/product/list";
	}
	

}
