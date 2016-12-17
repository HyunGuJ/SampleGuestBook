package com.cnu.GuestBook.Controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cnu.GuestBook.MessageDAO;
import com.cnu.GuestBook.MessageVO;

@Controller
public class MessageController {
	
	private static final Logger logger = LoggerFactory.getLogger(MessageController.class);

	@Resource(name = "MessageDAO")
    private MessageDAO messageDAO;
	
	
	@RequestMapping(value = "/getAllMessage", method = RequestMethod.GET)
	public String message(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		List<MessageVO> allMessage = this.messageDAO.select();
		for(MessageVO message : allMessage)
		{
			System.out.println(message);
		}

		
		return "message";
	}
	
    @RequestMapping(value = "/insertMessage", method = RequestMethod.GET)
    public ModelAndView logoff(HttpServletRequest request, Model model){
        
    	return new ModelAndView("guestBookPage");
    	

    }

}
