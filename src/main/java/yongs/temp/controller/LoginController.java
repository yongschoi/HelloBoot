package yongs.temp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping("/loginPage")
    public String prelogin(HttpServletRequest req) {	
    	return "loginPage";
    }
}
