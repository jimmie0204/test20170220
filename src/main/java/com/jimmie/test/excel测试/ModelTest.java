package com.jimmie.test.excel测试;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Before;
import org.junit.Test;

import com.jimmie.test.excel测试.tool.ExcelModelTool;

public class ModelTest {

	ExcelModelTool excelModelTool;
	
	@Before
	public void before() throws InvalidFormatException, IOException{
//		File file = new File("D:\\aaa.xls");
//		excelModelTool = new ExcelModelTool(file, 0,0);
		File file = new File("D:\\zzz.xlsx");
		excelModelTool = new ExcelModelTool(file, 1,0);
	}
	@Test
	public void test1(){
		System.out.println(excelModelTool.setCellValue(0, 1, "sd"));;
		System.out.println(excelModelTool.setCellValue(2, 3, "sd"));;
		System.out.println(excelModelTool.setCellValue(1, 0, "sd"));;
		System.out.println(excelModelTool.setCellValue(1, 1, "sd"));;
		
	}
	
	@Test
	public void test2(){
		System.out.println(excelModelTool.setCellValue(2, 3, "sd"));;
		
	}
	
	@Test
	public void test3(){
		System.out.println(excelModelTool.getCellValue(1, 0));;
		
	}
	
	@Test
	public void test31(){
		System.out.println(excelModelTool.getLastCellNum());;
		System.out.println(excelModelTool.getLastCellNumByRow(1));;
		System.out.println(excelModelTool.getLastCellNumByRow(2));;
		System.out.println(excelModelTool.getLastCellNumByRow(3));;
		System.out.println(excelModelTool.getLastCellNumByRow(4));;
		System.out.println(excelModelTool.getLastCellNumByRow(5));;
		System.out.println(excelModelTool.getLastCellNumByRow(6));;
	}
	
	@Test
	public void test32(){
		System.out.println(excelModelTool.getLastDataRowNum());
		
	}
	
	@Test
	public void test33(){
		System.out.println(excelModelTool.getRow(0));
		
	}
	
	@Test
	public void test4(){//平台
		Object platForm =excelModelTool.getCellValue(2, 1);
		System.out.println(platForm);//1.0
		
		String platForm2 =excelModelTool.getCellValueNew(2, 1);
		System.out.println(platForm2);//1
		
		Object platForm3=excelModelTool.getCellValueByString(2, 1);
		System.out.println(platForm3);//1
	}
	
	/**
	 * 2016/12/22 12:10:00,2016/12/22 12:10:01
2016/12/22 12:10:00,2016/12/22 12:10:01
2016/12/22 12:10:00,2016/12/22 12:10:01
	 */
	@Test
	public void test5(){//日期
		Object platForm =excelModelTool.getCellValue(2, 30);
		System.out.println(platForm);
		
		String platForm2 = excelModelTool.getCellValueNew(2, 30);
		System.out.println(platForm2);
		
		Object platForm3=excelModelTool.getCellValueByString(2, 30);
		System.out.println(platForm3);//
		
	}
	
	@Test
	public void test6(){//多整数
		Object platForm =excelModelTool.getCellValue(2, 31);
		System.out.println(platForm);
		
		String platForm2 = excelModelTool.getCellValueNew(2, 31);
		System.out.println(platForm2);
		
		splitPrint(platForm2);
	}
	
	public void splitPrint(String str){
		for(String temp:str.split(",")){
			System.out.println(temp);
		}
	}
	
	@Test
	public void test7(){//多汉字
		Object platForm =excelModelTool.getCellValue(2, 37);
		System.out.println(platForm);
		
		Object platForm2 =excelModelTool.getCellValueNew(2, 37);
		System.out.println(platForm2);
		
		Object platForm3=excelModelTool.getCellValueByString(2, 37);
		System.out.println(platForm3);//1
		
	}
	
	@Test
	public void test8(){//读空
		Object platForm =excelModelTool.getCellValue(2, 0);
		System.out.println(platForm);
		
		Object platForm2 =excelModelTool.getCellValueNew(2, 0);
		System.out.println(platForm2);
		
		Object platForm3=excelModelTool.getCellValueByString(2, 0);
		System.out.println(platForm3);//1
		
	}
	
}
