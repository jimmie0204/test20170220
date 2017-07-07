package com.jimmie.test.图片image;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.net.URL;
import java.util.Hashtable;
import java.util.Objects;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

/**
 * Created by supeng on 2017/5/31.
 */
public class ImageUtil {

    private static final Logger logger = LoggerFactory.getLogger(ImageUtil.class);

    /**
     * 拼接文字
     * @param backgroudimg
     * @param font
     * @param fontLeftLocation
     * @param fontTopLocation
     * @return
     * @throws Exception
     */
    public static BufferedImage drawFontOnImage(BufferedImage backgroudimg, String font, int fontLeftLocation, int fontTopLocation) throws Exception {
        Graphics2D g2d = (Graphics2D) backgroudimg.getGraphics();
        if (!Objects.equals(null, font) && !Objects.equals("", font)) {
            g2d.setColor(Color.black);
            g2d.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
//            g2d.setFont(new Font("黑体", Font.PLAIN, 20));
            g2d.drawString(font, fontLeftLocation, fontTopLocation);
        }

        return backgroudimg;
    }

    /**
     * 拼接图片
     * @param backgroudimg
     * @param qrcodeurl
     * @param qrCodeLeftLocation
     * @param qrCodeTopLocation
     * @param qcSize
     * @return
     * @throws Exception
     */
    public static BufferedImage drawImageOnImage(BufferedImage backgroudimg, String qrcodeurl, int qrCodeLeftLocation, int qrCodeTopLocation, int qcSize) throws Exception {
        Graphics2D g2d = (Graphics2D) backgroudimg.getGraphics();
        if (!Objects.equals(null, qrcodeurl) && !Objects.equals("", qrcodeurl)) {
            BufferedImage imageUrl = createImage(qrcodeurl, true, qcSize);
            g2d.drawImage(imageUrl, qrCodeLeftLocation, qrCodeTopLocation, (ImageObserver) null);
        }

        return backgroudimg;
    }

    public static BufferedImage createImage(String content, boolean needCompress, int qcSize) throws Exception {
        Hashtable hints = new Hashtable();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        hints.put(EncodeHintType.MARGIN, Integer.valueOf(0));
        BitMatrix bitMatrix = (new MultiFormatWriter()).encode(content, BarcodeFormat.QR_CODE, qcSize, qcSize, hints);
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, 1);

        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                image.setRGB(x, y, bitMatrix.get(x, y) ? -16777216 : -1);
            }
        }
        return image;
    }

    public static void main(String[] args) throws Exception {
        try {
//            File file = new File("/Users/Heyu/_M000001.jpg");
//            FileInputStream fis = new FileInputStream(file);
//            ByteArrayOutputStream bos = new ByteArrayOutputStream();
//            byte[] b = new byte[1024];
//            int n;
//            while ((n = fis.read(b)) != -1)
//            {
//                bos.write(b, 0, n);
//            }
//            fis.close();
//            bos.close();
//
//            ByteArrayInputStream in = new ByteArrayInputStream(bos.toByteArray()); //将b作为输入流；

            BufferedImage e = ImageIO.read(new URL("http://grampus-qrcode.ufile.ucloud.com.cn/56b6f318d23f42098f1a4284db5f60d6_M000001.jpg"));
//            BufferedImage e = ImageIO.read(new URL("http://grampus-qrcode.ufile.ucloud.cn/54fca009ad6f42b896d997ff0f016050_M000005.jpg"));

            BufferedImage bufferedImage = drawFontOnImage(e, "M000001", 300, 720);
            ImageIO.write(bufferedImage, "jpg", new File("/Users/Heyu/M000001.jpg"));
        } catch (Exception var6) {
            var6.printStackTrace();
        }

    }

}
