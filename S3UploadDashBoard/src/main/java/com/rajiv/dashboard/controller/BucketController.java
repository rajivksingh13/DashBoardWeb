/**
 * 
 */
package com.rajiv.dashboard.controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author rajk0517
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.rajiv.dashboard.common.DashboardConstants;
import com.rajiv.dashboard.enitity.ResourceURL;
import com.rajiv.dashboard.repository.ResourceURLRepository;
import com.rajiv.dashboard.services.AmazonClient;

@RestController
//@RequestMapping("/storage/")
public class BucketController {

	@Autowired
	ResourceURLRepository resourceURLRepository;
	
    private AmazonClient amazonClient;

    @Autowired
    BucketController(AmazonClient amazonClient) {
        this.amazonClient = amazonClient;
    }

//    @PostMapping("/uploadFile")
//    public String uploadFile(@RequestPart(value = "file") MultipartFile file) {
//        return this.amazonClient.uploadFile(file);
//    }
    @RequestMapping(DashboardConstants.DASHBOARD_HOME_REQUEST)
    public ModelAndView getRTest() {
		ModelAndView mv= new ModelAndView();
		mv.setViewName(DashboardConstants.DASHBOARD_HOME_VIEW);
		return mv;
	}
    @PostMapping(DashboardConstants.DASHBOARD_UPLOAD_REQUEST)
    public ModelAndView uploadFileMV(@RequestPart(value = "file") MultipartFile file) {
    	ModelAndView mv= new ModelAndView();
    	String fileURL= this.amazonClient.uploadFile(file);
    	if(fileURL.equalsIgnoreCase("")) {
    		mv.addObject("errorMsg","Resource Value Cann't be Empty !!! Please Select Valid Resource ");
    	}else {
    		ResourceURL resourceURL = new ResourceURL(fileURL);
    		resourceURLRepository.save(resourceURL);
    	    mv.addObject("fileURL", fileURL);
    	}
    	mv.setViewName(DashboardConstants.DASHBOARD_HOME_VIEW);
    	return mv;
  }

    @GetMapping(DashboardConstants.DASHBOARD_MESSAGE_REQUEST)
    public @ResponseBody List<ResourceURL> getMessage() throws Exception{
		List<ResourceURL> messageList = new ArrayList<>();
		messageList=resourceURLRepository.findAll();
		return messageList;
	}
//    @GetMapping(DashboardConstants.DASHBOARD_DELETE_REQUEST)
//    public ModelAndView deleteFile(@RequestPart(value = "url") String fileUrl) {
//    	ModelAndView mv= new ModelAndView();
//    	//resourceURLRepository.deleteById(messageId);
//    	String message = this.amazonClient.deleteFileFromS3Bucket(fileUrl);
//    	mv.addObject("message", message);
//    	mv.setViewName(DashboardConstants.DASHBOARD_HOME_VIEW);
//        return mv;
//    }
    
    @GetMapping(DashboardConstants.DASHBOARD_DELETE_REQUEST)
	public String deleteMessage(HttpServletRequest request,
			HttpServletResponse response,@PathVariable Long messageId) throws Exception {
    	ResourceURL resourceURL = new ResourceURL();
    	resourceURL = resourceURLRepository.getOne(messageId);
    	String fileUrl = resourceURL.getResourceURL().toString();
    	System.out.println("Rajiv :: "+resourceURL.getResourceURL().toString());
    	String message = this.amazonClient.deleteFileFromS3Bucket(fileUrl);
    	resourceURLRepository.deleteById(messageId);
    	response.setHeader("Location", "/manageS3");
    	response.setStatus(302);
		return message;		
	}
    
//    @DeleteMapping("deleteFile")
//    public String deleteFile(@RequestPart(value = "url") String fileUrl) {
//        return this.amazonClient.deleteFileFromS3Bucket(fileUrl);
//    }
}
