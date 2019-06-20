package com.nt.views;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.nt.dto.StudentDTO;

public class StudentPdfView extends AbstractPdfView {

	@Override
	public void buildPdfDocument(Map<String, Object> map, Document doc, PdfWriter pw, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		List<StudentDTO> listDTO=null;
		Paragraph p=null;
		Table t=null;
		//read model attribute
		listDTO=(List<StudentDTO>)map.get("studList");
		//create and add Paragraph
		p = new Paragraph("Student details");
		p.setAlignment("center");
		p.setFont(new Font(Font.BOLD));
		doc.add(p);
		
		//add table to Document
		t = new Table(3);
		for(StudentDTO dto:listDTO){
			t.addCell(String.valueOf(dto.getSno()));
			t.addCell(dto.getSname());
			t.addCell(dto.getSadd());
		}
		doc.add(t);
	}//builDocument(-,-,-,-,-)
}//class
