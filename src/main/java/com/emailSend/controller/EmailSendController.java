package com.emailSend.controller;




import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.emailSend.util.EmailUtil;



@Controller
public class EmailSendController {
	
	//Save the uploaded file to this folder
    private static String path = "C://";
	
	@Autowired
	private EmailUtil emailUtil;
	
	@RequestMapping("/contact")
	public String contact() {
		return "contact";
	}
	
	@RequestMapping("/contactDAF")
	public String contactUAF() {
		return "contactDAF";
	}
	
	@RequestMapping("/contactUAF")
	public String contactDAF() {
		return "contactUAF";
	}
	
	@RequestMapping("/emailSend")
	public String saveLocationInfo(@RequestParam("email") String email, @RequestParam("subject") String subject, @RequestParam("message") String message, ModelMap modelMap) {
		
		System.out.println(email);
		System.out.println(subject);
		System.out.println(message);

		emailUtil.sendEmail(email, subject, message);
		modelMap.addAttribute("msg", "Mail is send");
		return "contact";
	}	
	
	@RequestMapping("/attachedEmailSend")
	public String defaultAttachedEmailSend(@RequestParam("email") String email, @RequestParam("subject") String subject, @RequestParam("message") String message, ModelMap modelMap) {
		
		System.out.println(email);
		System.out.println(subject);
		System.out.println(message);

		emailUtil.sendDefaultAttachedEmail(email, subject, message);
		modelMap.addAttribute("msg", "Mail is send with attachment file");
		return "contactDAF";
	}
	@RequestMapping("/uploadFileEmailSend")
	public String uploadAttachedEmailSend(@RequestParam("email") String email, @RequestParam("subject") String subject, @RequestParam("message") String message, @RequestParam("file") MultipartFile file, ModelMap modelMap) {
		
		System.out.println(email);
		System.out.println(subject);
		System.out.println(message);
		System.out.println(file);
		System.out.println(file.getOriginalFilename());
		
		// getting current path 
		Path currentRelativePath = Paths.get("");
		String path = currentRelativePath.toAbsolutePath().toString();

		System.out.println(path);
		
		
		try {
			byte[] bytes = file.getBytes();
			Path UPLOADED_FOLDER = Paths.get(path+"/file/"+file.getOriginalFilename());
			Files.write(UPLOADED_FOLDER, bytes);
//			System.out.println("Path "+UPLOADED_FOLDER);
			
			emailUtil.sendUploadAttachedEmail(email, subject, message, UPLOADED_FOLDER.toString());
			modelMap.addAttribute("msg", "Mail is send with attachment file");
			return "contactUAF";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "contactUAF";
		}
	

//		emailUtil.sendDefaultAttachedEmail(email, subject, message);
//		modelMap.addAttribute("msg", "Mail is send with attachment file");
//		return "contactUAF";
	}
	


}
