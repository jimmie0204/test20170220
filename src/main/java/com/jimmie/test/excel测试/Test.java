package com.jimmie.test.excel测试;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.jimmie.test.excel测试.tool.ExcelModelTool;

public class Test {

	public static void main(String[] args) throws InvalidFormatException, IOException {

//		  InputStream inp = new FileInputStream("D:\\aaa.xls");  
		File file = new File("D:\\aaa.xls");
		
		System.out.println(file.length());

		ExcelModelTool excelModelTool = new ExcelModelTool(file, 0,0);
		int coloumNum = excelModelTool.getLastCellNum();
		System.out.println(coloumNum);
		int rowNum = excelModelTool.getLastDataRowNum();
		System.out.println(rowNum);
		
		for(int i=1;i<rowNum;i++){
			int flag = i%2;
			if(flag==1){
				excelModelTool.delRow(i);
			}else{
				excelModelTool.setCellValue(i,(coloumNum-1),"这他妈错了");
			}
		}

//		excelModelTool.setCellValue(excelModelTool.getRow(1),1,"");
//		excelModelTool.setCellValue(excelModelTool.getRow(1),2,"");
//		excelModelTool.delRow(1);
		OutputStream os = new FileOutputStream("D:\\aaa_bak8.xls");
		excelModelTool.write(os);
		
//		System.out.println(excelModelTool.setCellValue(excelModelTool.getRow(1), 1,"yews"));;
	}


}
