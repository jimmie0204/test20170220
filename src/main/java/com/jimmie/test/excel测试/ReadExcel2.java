package com.jimmie.test.excel测试;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcel2 {
	 
	 public static void main(String[] args) throws Exception {
	  InputStream inp = new FileInputStream("D:\\aaa.xls");  
	     HSSFWorkbook workbook = (HSSFWorkbook) WorkbookFactory.create(inp);  
	     HSSFSheet sheet = (HSSFSheet) workbook.getSheetAt(0);  
	     
	   //获得总列数
	     int coloumNum=sheet.getRow(0).getPhysicalNumberOfCells();
	     int coloumNum2=sheet.getRow(0).getLastCellNum();
	     int rowNum=sheet.getLastRowNum();//获得总行数  
	     System.out.println(coloumNum);
	     System.out.println(coloumNum2);
	     System.out.println(rowNum);
	 }
	 
	 
	}