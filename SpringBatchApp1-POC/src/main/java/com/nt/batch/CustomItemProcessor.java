package com.nt.batch;

import org.springframework.batch.item.ItemProcessor;

public class CustomItemProcessor implements ItemProcessor<String, String> {

	@Override
	public String process(String bookNameWithoutAuthor) throws Exception {
		System.out.println("CIP:process(-)");
		String bookNameWithAuthor = "Book Name - "+bookNameWithoutAuthor+" | Author Name - ";
		
		
		if("CRJ".equalsIgnoreCase(bookNameWithoutAuthor)){
			bookNameWithAuthor += "PN+HS";
		}else if("TIJ".equalsIgnoreCase(bookNameWithoutAuthor)){
			bookNameWithAuthor += "BE";
		}else if("EJ".equalsIgnoreCase(bookNameWithoutAuthor)){
			bookNameWithAuthor += "JB";
		}else if("HFJ".equalsIgnoreCase(bookNameWithoutAuthor)){
			bookNameWithAuthor += "KS";
		}else if("SIA".equalsIgnoreCase(bookNameWithoutAuthor)){
			bookNameWithAuthor += "MS";
		}
		return bookNameWithAuthor;
	}

}
