package com.nt.views;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.nt.dto.StudentDTO;

public class StudentExcelView extends AbstractXlsView {

	@Override
	public void buildExcelDocument(Map<String, Object> map, Workbook book, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		List<StudentDTO> listDTO = null;
		Sheet sheet = null;
		Row row = null;
		int i = 0;
		// Read model attribute
		listDTO = (List<StudentDTO>) map.get("studList");

		// construct excel sheet
		sheet = book.createSheet("Sheet1");
		// Construct rows
		for (StudentDTO dto : listDTO) {
			row = sheet.createRow(i);
			row.createCell(0).setCellValue(dto.getSno());
			row.createCell(1).setCellValue(dto.getSname());
			row.createCell(2).setCellValue(dto.getSadd());
			i++;
		}//for
	}// method
}// class
