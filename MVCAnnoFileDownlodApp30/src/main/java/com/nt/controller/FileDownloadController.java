package com.nt.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.service.ListUploadedFilesService;

@Controller
public class FileDownloadController {
	@Autowired
	private ListUploadedFilesService service;
	
	@RequestMapping(value="/home.htm")
	public String showHome(Map<String,Object> map){
		List<String> listFiles=null;
		//use Service
		listFiles=service.getAllFiles();
	    //add to model attribute
		map.put("listFiles",listFiles);
		return "show_files";
	}
	
	
	@RequestMapping("/download.htm")
	public String  download(@RequestParam("fname")String fileName,
	                                               HttpServletRequest req,
	                                               HttpServletResponse res)throws Exception{
		File file=null;
		InputStream is=null;
		OutputStream os=null;
	   //Locate the  file
	     file=new File("E:/uploads/"+fileName);
	  // create Input stream pointing to the file
	    is=new FileInputStream(file);
	   //create output stream pointing to response obj
	     os=res.getOutputStream();
	    //set file length as response content length
	    res.setContentLength((int)file.length());
	    //get file contenttype and make it response content type
	    res.setContentType(req.getServletContext().getMimeType(file.getAbsolutePath()));
	    //use Content-Disposition header to attachment 
	     res.addHeader("Content-Disposition","attachment;fileName="+fileName);
	     //copy file content to response object
	     IOUtils.copy(is,os);
	     return null;
	     }
  }//class
       
