package cn.gyyx.gy4j.util;

import org.apache.velocity.texen.util.FileUtil;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Hashtable;

/**
 * @Author : east.Fu
 * @Description :
 * @Date : Created in  2017/10/15 21:09
 */
public class QrcodeUtil {

    private static final int WHITE = 0xFFFFFFFF;

    public static void main(String[] args) throws Exception {
        String url = "http://ec.ps.cn";
        String savePath = "f:/test3.png";
        int color = Constants.qrcodeColorMap.get("4");
        QrcodeUtil.createZxingQrcode(url,savePath,color);
    }

    /**
     * 根据指定前景颜色生成二维码,背景透明
     * @param input_string
     * @param filePath
     * @param forgeColor
     */
    public static void createZxingQrcode(String input_string, String filePath ,int forgeColor) throws Exception {
        File f = new File(filePath);
        if(!f.getParentFile().exists()){
            f.getParentFile().mkdirs();
        }
        String suffix = filePath.substring(filePath.lastIndexOf(".")+1);
        // 二维码的图片格式
        Hashtable hints = new Hashtable();
        // 内容所使用编码
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        hints.put(EncodeHintType.MARGIN,0);
        int version = getVersionByContent(input_string);
        int width = 67 + 12 * (version - 1);
        int height = width;
        BitMatrix bitMatrix = new MultiFormatWriter().encode(input_string,
                BarcodeFormat.QR_CODE, width, height, hints);
        // 生成二维码
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
        int alpha = 0;
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                image.setRGB(x, y, bitMatrix.get(x, y) ? forgeColor : WHITE);
                int rgb = image.getRGB(x, y);
                int R = (rgb & 0xff0000) >> 16;
                int G = (rgb & 0xff00) >> 8;
                int B = (rgb & 0xff);
                if (((255-R)<30) && ((255-G)<30)&& ((255-B)<30)) {
                    rgb = ((alpha + 1) << 24) | (rgb & 0x00ffffff);
                }
                image.setRGB(x, y, rgb);
            }
        }
        ImageIO.write(image, suffix, new File(filePath));
    }

    public static void createImage(String sms_info,String filePath)throws Exception{
        BufferedImage bi = null;
        Graphics2D g = null;
        String suffix = filePath.substring(filePath.lastIndexOf(".")+1);
        try{
            Qrcode testQrcode =new Qrcode();
            testQrcode.setQrcodeErrorCorrect('L');
            testQrcode.setQrcodeEncodeMode('B');
            int version = getVersionByContent(sms_info);
            testQrcode.setQrcodeVersion(version);

            String testString = sms_info;
            byte[] d = testString.getBytes("UTF-8"); // 设置二维码编码方式
            int width = 67 + 12 * (version - 1);
            int height = width;

            bi = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);
            g = bi.createGraphics();
            g.setBackground(Color.WHITE);
            g.clearRect(0, 0, width, height);
            g.setColor(Color.BLACK);

            // 设置偏移量 不设置可能导致解析出错
            int pixoff = 2;
            // 输出内容 > 二维码
            if (d.length > 0 && d.length < 2560) {
                boolean[][] codeOut = testQrcode.calQrcode(d);
                for (int i = 0; i < codeOut.length; i++) {
                    for (int j = 0; j < codeOut.length; j++) {
                        if (codeOut[j][i]) {
                            g.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
                        }
                    }
                }
            } else {
                throw new Exception("QRCode content bytes length = "+d.length+" not in [ 0,2560 ]. ");
            }

            File f = FileUtil.isFile(filePath);
            //创建图片
            ImageIO.write(bi, suffix, f);

        }finally
        {
            g.dispose();
            bi.flush();
        }
    }

    /**
     * 获取二维码版本数*<p>
     * @param input_string
     *            二维码内容
     * @return 根据二维码内容的字符长度返回其二维码版本数
     * @throws Exception
     */
    public static int getVersionByContent(String input_string) throws Exception {
        byte[] d = input_string.getBytes("UTF-8"); // 设置二维码编码方式
        int byte_lenth = d.length;
        int version = 7;
        /** 根据输入字符串的长度生成不同大小的二维码图片 */
        if (byte_lenth <= 156) {
            version = 7;
        } else if (byte_lenth <= 194) {
            version = 8;
        } else if (byte_lenth <= 232) {
            version = 9;
        } else if (byte_lenth <= 274) {
            version = 10;
        } else if (byte_lenth <= 324) {
            version = 11;
        } else if (byte_lenth <= 370) {
            version = 12;
        } else if (byte_lenth <= 428) {
            version = 13;
        } else if (byte_lenth <= 461) {
            version = 14;
        } else if (byte_lenth <= 523) {
            version = 15;
        } else if (byte_lenth <= 589) {
            version = 16;
        } else if (byte_lenth <= 647) {
            version = 17;
        } else if (byte_lenth <= 721) {
            version = 18;
        } else if (byte_lenth <= 795) {
            version = 19;
        } else if (byte_lenth <= 861) {
            version = 20;
        } else if (byte_lenth <= 932) {
            version = 21;
        } else if (byte_lenth <= 1006) {
            version = 22;
        } else if (byte_lenth <= 1094) {
            version = 23;
        } else if (byte_lenth <= 1174) {
            version = 24;
        }
        return version;
    }

	/* public static void main(String args[]) throws Exception{
		 createImage("柜前阿斯顿发生的发生发送法师打发生的发生发送法师打发斯蒂阿斯顿法发生大发暗室逢灯斯蒂阿斯顿法发生大发","d:/gqTest.jpg");
	 }*/
}
