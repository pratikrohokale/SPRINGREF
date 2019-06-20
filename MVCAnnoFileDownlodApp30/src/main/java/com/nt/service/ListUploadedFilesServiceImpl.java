package com.nt.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service("listUplService")
public class ListUploadedFilesServiceImpl implements ListUploadedFilesService {

	public List<String> getAllFiles() {
		File destDir=null;
		File files[]=null;
		List<String> listFiles=null;
		
		destDir=new File("E:/uploads");
		if(destDir.exists() && destDir.isDirectory()){
			files=destDir.listFiles();
			listFiles=new ArrayList();
		  for(File file:files){
			  if(file.isFile()){
				  listFiles.add(file.getName());
			  }
		  }//for
		}//if
		return listFiles;
	}

}
