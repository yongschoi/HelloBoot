package yongs.temp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import yongs.temp.common.SecurityUtil;
import yongs.temp.db.vo.User;
import yongs.temp.exception.InsufficientException;
import yongs.temp.exception.NoIdentityException;
import yongs.temp.service.UserService;

@Controller
public class LoginController {
	private Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private UserService userService;
	
    @RequestMapping("/loginPage")
    public String prelogin(HttpServletRequest req) {	
    	return "loginPage";
    }
    
    @RequestMapping("/login")
    public String login(HttpServletRequest req, Model model) throws Exception {  	
    	String username = req.getParameter("username");
    	String password = req.getParameter("password");     
    	
    	logger.debug("username=> " + username);
    	logger.debug("password=> " + password);

    	User user = null;
    	try {
    		user = userService.findUser(username);
    	} catch (Exception e) {
    		logger.debug(e.toString());
    		throw new InsufficientException();
    	}
    	// password 암호화 후 일치여부 확인
    	String sPassword = SecurityUtil.encryptSHA256(password);	
    	if(!sPassword.equals(user.getPassword())) {
    		throw new NoIdentityException();
    	}
 
        HttpSession session = req.getSession(false);
    	session.setAttribute("SESSION_USER", user);
    	
    	logger.debug("SESSION ID ==>|" + session.getId() + "|");
    	model.addAttribute("out", username);
   	
        return "login";
    }
    
	@ExceptionHandler({InsufficientException.class}) 
	public String userError(HttpServletRequest request, Model model) { 
		// Nothing to do. Returns the logical view name of an error page, passed to 
		// the view-resolver(s) in usual way. 
		// Note that the exception is _not_ available to this view (it is not added to 
		// the model) but see "Extending ExceptionHandlerExceptionResolver" below. 
		String username = request.getParameter("username");
       
		model.addAttribute("out", username+"는 존재하지 않는 사용자입니다.");
		return "loginPage";
	} 
	
	@ExceptionHandler({NoIdentityException.class}) 
	public String noIdentity(HttpServletRequest request, Model model) { 
		// Nothing to do. Returns the logical view name of an error page, passed to 
		// the view-resolver(s) in usual way. 
		// Note that the exception is _not_ available to this view (it is not added to 
		// the model) but see "Extending ExceptionHandlerExceptionResolver" below. 
		model.addAttribute("out", "Password가 틀립니다.");
		return "loginPage";
	} 
}
