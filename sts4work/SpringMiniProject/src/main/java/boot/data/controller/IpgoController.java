package boot.data.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import boot.data.dto.IpgoDto;
import boot.data.mapper.IpgoMapperInter;

@Controller
public class IpgoController {

    @Autowired
    IpgoMapperInter mapper;

    @GetMapping("/")
    public String start() {
        return "/layout/main";
    }

    @GetMapping("/ipgo/list")
    public ModelAndView list() {
        ModelAndView mview = new ModelAndView();

        int totalCount = mapper.getTotalCount();
        List<IpgoDto> list = mapper.getAllDatas();

        mview.addObject("totalCount", totalCount);
        mview.addObject("list", list);

        mview.setViewName("/sub2/ipgo/ipgolist"); // tiles
        return mview;
    }

    @GetMapping("/ipgo/writeform")
    public String form() {
        return "/sub2/ipgo/ipgoform";
    }

    @PostMapping("/ipgo/insert")
    public String insert(@ModelAttribute IpgoDto dto, @RequestParam ArrayList<MultipartFile> upload, HttpSession session) {

        String path = session.getServletContext().getRealPath("/ipgoimage");

        String uploadName = "";

        if (upload.get(0).getOriginalFilename().equals(""))
            uploadName = "no";
        else {
            for (MultipartFile f : upload) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

                String fName = sdf.format(new Date()) + "_" + f.getOriginalFilename();
                uploadName += fName + ",";

                try {
                    f.transferTo(new File(path + "\\" + fName));
                } catch (IllegalStateException | IOException e) {
                    e.printStackTrace();
                }
            }

            // Remove the last comma
            uploadName = uploadName.substring(0, uploadName.length() - 1);
        }

        dto.setPhotoname(uploadName);

        mapper.insertIpgo(dto);
        return "redirect:list";
    }

    @GetMapping("/ipgo/updateform")
    public String updateform(@RequestParam String num, Model model) {
        IpgoDto dto = mapper.getData(num);
        model.addAttribute("dto", dto);
        return "/sub2/ipgo/updateform";
    }

    @PostMapping("/ipgo/update")
    public String update(@ModelAttribute IpgoDto dto, @RequestParam ArrayList<MultipartFile> upload, HttpSession session) {

        String path = session.getServletContext().getRealPath("/ipgoimage");

        String uploadName = "";

        if (upload.get(0).getOriginalFilename().equals(""))
            uploadName = null;
        else {
            for (MultipartFile f : upload) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

                String fName = sdf.format(new Date()) + "_" + f.getOriginalFilename();
                uploadName += fName + ",";

                try {
                    f.transferTo(new File(path + "\\" + fName));
                } catch (IllegalStateException | IOException e) {
                    e.printStackTrace();
                }
            }

            // Remove the last comma
            uploadName = uploadName.substring(0, uploadName.length() - 1);
        }

        dto.setPhotoname(uploadName);

        mapper.updateIpgo(dto);
        return "redirect:list";
    }

    @GetMapping("/ipgo/detail")
    public String detail(@RequestParam String num, Model model) {
        IpgoDto dto = mapper.getData(num);
        model.addAttribute("dto", dto);
        return "/sub2/ipgo/ipgodetail.jsp?num=" + num;
    }

    @PostMapping("/ipgo/delete")
    public String delete(@RequestParam String num, HttpSession session) {
        // Get the details of the item to delete
        IpgoDto dto = mapper.getData(num);

        // Delete the files from the server if they exist
        if (dto.getPhotoname() != null && !dto.getPhotoname().equals("no")) {
            String path = session.getServletContext().getRealPath("/ipgoimage");
            String[] fileNames = dto.getPhotoname().split(",");
            for (String fileName : fileNames) {
                File file = new File(path + "\\" + fileName);
                if (file.exists()) {
                    file.delete();
                }
            }
        }

        // Delete the record from the database
        mapper.deleteIpgo(num);

        return "redirect:list";
    }
}
