package com.jimmie.test.excel测试;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPicture;
import org.apache.poi.hssf.usermodel.HSSFPictureData;
import org.apache.poi.hssf.usermodel.HSSFShape;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcel {
	 
	 public static void main(String[] args) throws Exception {
	  InputStream inp = new FileInputStream("D:\\aaa.xls");  
	     HSSFWorkbook workbook = (HSSFWorkbook) WorkbookFactory.create(inp);  
	        List<HSSFPictureData> pictures = workbook.getAllPictures();  
	        HSSFSheet sheet = (HSSFSheet) workbook.getSheetAt(0);  
	        Map<String,Object> map = new HashMap<String,Object>();
	        
	     for (HSSFShape shape : sheet.getDrawingPatriarch().getChildren()) {  
	            HSSFClientAnchor anchor = (HSSFClientAnchor) shape.getAnchor();  
	         if (shape instanceof HSSFPicture) {  
	                HSSFPicture pic = (HSSFPicture) shape;  
	                int row = anchor.getRow2();  
	                int col = anchor.getCol2();
	             System.out.println("--->" + anchor.getRow2() + ":"  + anchor.getCol2()); 
	             //map.put(row+":"+col, row+":"+col);
	             int pictureIndex = pic.getPictureIndex()-1;  
	             HSSFPictureData picData = pictures.get(pictureIndex);  
	             System.out.println("--->" + picData); 
	             map.put(row+":"+col, picData);
	             savePic(UUID.randomUUID().toString(), picData);  
	            }  
	      } 
	     
	     System.out.println(map);
	 }
	 
	 private static void savePic(String i, PictureData pic) throws Exception {  
	        String ext = pic.suggestFileExtension();  
	        byte[] data = pic.getData();  
	        if (ext.equals("jpeg")) {  
	            FileOutputStream out = new FileOutputStream("D:\\" + i + ".jpg"); 
	            out.write(data);  
	            out.close();  
	         File file = new File("D:\\" + i + ".jpg");
	         FileInputStream in = new FileInputStream(file);
	         System.out.println("in===>"+in);
	         if(file.isFile()){
	          file.delete();
	          System.out.println("=============delete");
	         }
	         
	        }  
	       /* if (ext.equals("png")) {  
	            FileOutputStream out = new FileOutputStream("F:\\" + i + ".jpg");  
	            out.write(data);  
	            out.close();  
	        }  */
	 } 
	}