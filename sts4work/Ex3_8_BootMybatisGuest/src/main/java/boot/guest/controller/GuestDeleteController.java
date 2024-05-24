package boot.guest.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import boot.guest.dto.GuestDto;
import boot.guest.service.GuestService;

@Controller
public class GuestDeleteController {

	@Autowired
	private GuestService gService;


    @PostMapping("/guest/delete")
    @ResponseBody
    public Map<String, Object> deletePost(@RequestParam int num, @RequestParam String pass) {
        Map<String, Object> result = new HashMap<>();
        
        //삭제성공여부 : success
        boolean success = gService.deleteGuest(num, pass);

        if (success) {
            result.put("success", true);
            result.put("msg", "삭제되었습니다.");
        } else {
            result.put("success", false);
            result.put("msg", "비밀번호가 일치하지 않습니다.");
        }

        return result;
    }
	

}
