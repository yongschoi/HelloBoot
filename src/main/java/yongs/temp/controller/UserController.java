package yongs.temp.controller;

import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import yongs.temp.common.SecurityUtil;
import yongs.temp.db.vo.User;
import yongs.temp.service.UserService;
	
@Controller
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);	
	@Autowired
	private UserService userService;
    
	@RequestMapping("/user/createPage")
	public String createPage(HttpServletRequest req) {
		return "user/createPage";
	}

	@RequestMapping("/user/create")
	public String create(HttpServletRequest req, Model model) throws Exception {
    	String username = req.getParameter("username");
    	String password = req.getParameter("password");

    	logger.debug("username=> " + username);
    	logger.debug("password=> " + password);

		// password 암호화
		String sPassword = SecurityUtil.encryptSHA256(password);
    	logger.debug("sPassword=> " + sPassword);	
    	
		User user = new User(username, sPassword, 1);
		userService.createUser(user);
		model.addAttribute("out", "정상적으로 등록되었습니다. 로그인이 가능합니다.");

		return "result";
	}

	@RequestMapping("/user/retrieve")
	public String retrieve(HttpServletRequest req, Model model, @RequestParam("userNameParam") String username) throws Exception {

		User user = userService.findUser(username);
		model.addAttribute("user", user);

		return "user/userInfo";
	}
	
	@ExceptionHandler({SQLIntegrityConstraintViolationException.class}) 
	public String duplicate(HttpServletRequest request, Model model) { 
		// Nothing to do. Returns the logical view name of an error page, passed to 
		// the view-resolver(s) in usual way. 
		// Note that the exception is _not_ available to this view (it is not added to 
		// the model) but see "Extending ExceptionHandlerExceptionResolver" below. 
		String username = request.getParameter("username");

		model.addAttribute("out", username+"는 이미 사용중인 Username입니다. 다른 Username을 사용하세요.");
		return "user/createPage";
	} 
}