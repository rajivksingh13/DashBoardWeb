/**
 * 
 */
package com.rajiv.dashboard.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.rajiv.dashboard.common.NcDashboardConstants;
import com.rajiv.dashboard.entity.Message;
import com.rajiv.dashboard.entity.MessageRepository;
import com.rajiv.dashboard.exception.ResourceNotFoundException;


/**
 * @author rajk0517
 *
 */
@Controller
public class WelComeController {
	
//	@Autowired
//	MessageDAOService messageService;
	
	@Autowired
	MessageRepository messageRepository;
	
	@RequestMapping(NcDashboardConstants.DASHBOARD_WELCOME_REQUEST)
    public ModelAndView welcome() {
		ModelAndView mv= new ModelAndView();
		mv.setViewName(NcDashboardConstants.DASHBOARD_WELCOME_VIEW);
		return mv;
	}
	
	@RequestMapping(NcDashboardConstants.DASHBOARD_ADMIN_REQUEST)
    public ModelAndView dashboardAdmin() {
		ModelAndView mv= new ModelAndView();
		mv.setViewName(NcDashboardConstants.DASHBOARD_ADMIN_VIEW);
		return mv;
	}

//	@RequestMapping(NcDashboardConstants.DASHBOARD_WELCOME_REQUEST_TEST)
//    public ModelAndView welcome1() {
//		ModelAndView mv= new ModelAndView();
//		mv.setViewName(NcDashboardConstants.DASHBOARD_WELCOME_VIEW_TEST);
//		return mv;
//	}
	
	@RequestMapping(NcDashboardConstants.DASHBOARD_HOME_REQUEST)
    public ModelAndView dashboard() {
		String message = "WelCome to NC DashBoard";
		ModelAndView mv= new ModelAndView();
		mv.addObject("message",message);
		mv.setViewName(NcDashboardConstants.DASHBOARD_HOME_VIEW);
		return mv;
	}
	
	@GetMapping(NcDashboardConstants.DASHBOARD_MESSAGE_REQUEST)
    public @ResponseBody List<Message> getMessage() throws Exception{
		List<Message> messageList = new ArrayList<>();
		messageList=messageRepository.findAll();
		return messageList;
	}
//	@PostMapping(NcDashboardConstants.DASHBOARD_ADD_REQUEST)
//	public Message addMessage(@ModelAttribute Message message) {
//		return messageRepository.save(message);
//	}
	
	@GetMapping(NcDashboardConstants.DASHBOARD_ADD_URL_REQUEST)
	public ModelAndView addURLView() {
		ModelAndView mv= new ModelAndView();
		mv.setViewName(NcDashboardConstants.DASHBOARD_ADD_VIEW);
		return mv;
	}
	
	@PostMapping(NcDashboardConstants.DASHBOARD_ADD_REQUEST)
	public ModelAndView addMessage(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mv= new ModelAndView();
		String messageUrl = request.getParameter("message");
		if (messageUrl.equalsIgnoreCase("")) {
			mv.addObject("errorMsg","Resource URL Value Cann't be Empty !!! Please Enter Valid URL");
		}else {
			Message message = new Message(messageUrl);
			messageRepository.save(message);
			mv.addObject("sucessMsg","Resource URL ::"+messageUrl +" Added");
		}
		mv.setViewName(NcDashboardConstants.DASHBOARD_ADD_VIEW);
		return mv;
				
	}
	
	@GetMapping(NcDashboardConstants.DASHBOARD_DELETE_REQUEST)
	public String deleteMessage(HttpServletRequest request,
			HttpServletResponse response,@PathVariable Long messageId) throws Exception {
		messageRepository.deleteById(messageId);
		return "redirect:/addURL";		
	}
	
	/*@PutMapping(NcDashboardConstants.DASHBOARD_UPDATE_REQUEST)
	public ResponseEntity<Message> updateMessage(HttpServletRequest request,
			HttpServletResponse response,@PathVariable Long messageId,@RequestBody Message messageURL) throws ResourceNotFoundException  {
		ModelAndView mv= new ModelAndView();
		//String messageUrl = request.getParameter("message");
		Message message = new Message();
		message = messageRepository.findById(messageId).orElseThrow(() -> new ResourceNotFoundException("Message Resource not found on :: " + messageId));;
		System.out.println("Rajiv message ID is ::"+messageId);
		message.setMessage(messageURL.getMessage());
		//mv.setViewName(NcDashboardConstants.DASHBOARD_ADD_VIEW);
		final Message updatedMessage = messageRepository.save(message);
	    return ResponseEntity.ok(updatedMessage);
				
	}*/
	
	@GetMapping(NcDashboardConstants.DASHBOARD_UPDATE_REQUEST)
	public String updateMessage(HttpServletRequest request,
			HttpServletResponse response,@RequestParam(value = "id", required = false) Long messageId,@RequestParam(value = "message", required = false) String messageUrl ) throws ResourceNotFoundException  {
		ModelAndView mv= new ModelAndView();
		//String messageUrl = request.getParameter("Save");
		System.out.println("Rajiv messageUrl is ::"+messageUrl);
		Message message = new Message();
		message = messageRepository.findById(messageId).orElseThrow(() -> new ResourceNotFoundException("Message Resource not found on :: " + messageId));;
		System.out.println("Rajiv message ID is ::"+messageId);
		message.setMessage(messageUrl);
		//mv.setViewName(NcDashboardConstants.DASHBOARD_ADD_VIEW);
		messageRepository.save(message);
	    return "redirect:/addURL";
				
	}
}
