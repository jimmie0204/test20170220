package com.jimmie.test.图片image;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImageMaker {

	static Logger LOG = LoggerFactory.getLogger(ImageMaker.class);
	
	private static boolean byte2image(byte[] data,String path,String font) {
		
	    if(data.length < 3 || StringUtils.isBlank(path)) 
	    	return false;
	    
//	    FileImageOutputStream imageOutput = null;
	    try{
	    	
//	    	imageOutput = new FileImageOutputStream(new File(path));
			//
			ByteArrayInputStream in = new ByteArrayInputStream(data); //将b作为输入流；
			BufferedImage image = ImageIO.read(in);
			BufferedImage bufferedImage = ImageUtil.drawFontOnImage(image,font, 280, 720);
			ImageIO.write(bufferedImage, "jpg", new File(path));

//			imageOutput.write(data, 0, data.length);
	    	
	    	LOG.info("图片生成成功,路径为[ " + path + " ]");
	    	return true;
	    } catch(Exception e) {
	    	LOG.error("生成图片失败!!");
	    	return false;
	    } finally {
//	    	try {
//				if(imageOutput != null)
//					imageOutput.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
	    }
	  }
	
	
	private static boolean image2image(String oldImage,String path,String font,int left,int right) {
		
	    if(StringUtils.isBlank(oldImage) || StringUtils.isBlank(path)) 
	    	return false;
	    
	    try{
	    	
			BufferedImage image = ImageIO.read(new File(oldImage));
			BufferedImage bufferedImage = ImageUtil.drawFontOnImage(image,font, left, right);
			ImageIO.write(bufferedImage, "jpg", new File(path));

	    	LOG.info("图片生成成功,路径为[ " + path + " ]");
	    	return true;
	    } catch(Exception e) {
	    	LOG.error("生成图片失败!!");
	    	return false;
	    } 
	  }
	
	public static void main(String[] args) {
		ImageMaker.image2image("d:/aaa.png", "d:/aaa_bak.png", "f_ck",280,720);
		System.out.println("done==============");
	}
}
