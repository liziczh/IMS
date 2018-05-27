package com.liziczh.ims.tools;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class VerifiCodeUtil{
    private static String[] fontNames = {"宋体","TimesRoman","Courier","Arial","楷体","黑体"};
    private static int codeLength = 4;

    public static String getCode() {
        return code;
    }

    private static String code ;
    private static Random random = new Random();
    /*
            设置验证码具体的字母是什么
        */

    protected static String generateCode() {
        char[] codes = new char[codeLength];
        for (int i = 0, len = codes.length; i < len; i++) {
            if (random.nextBoolean()) {
                codes[i] = (char) (random.nextInt(26) + 65);
            } else {
                codes[i] = (char) (random.nextInt(26) + 97);
            }
        }
        code = new String(codes);
        return code;
    }
    /*
        产生随机的颜色
    */
    public static Color getRandColor(int min, int max) {

        if (min > 255)
            min = 255;
        if (max > 255)
            max = 255;
        int red = random.nextInt(max - min) + min;
        int green = random.nextInt(max - min) + min;
        int blue = random.nextInt(max - min) + min;
        return new Color(red, green, blue);
    }
    public static BufferedImage getBufferdImage(int width, int height) {

            code = generateCode();


            //设置背景颜色
           Color bgcolor = getRandomColor(random);



            int startx = 0;
            BufferedImage charImage = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
            Graphics2D charg = (Graphics2D) charImage.getGraphics();





           charg.setColor(getRandColor(180, 200));;
            charg.fillRect(0, 0, width, height);

            for (int i = 0; i < code.length(); i++) {

                /* 随机旋转角度 */
                int degree = random.nextInt(45);

                /* 随机字体颜色 */
                Color frontcolor = getRandomColor(random);

                /* 随机字体  */
                String fontname = fontNames[random.nextInt(fontNames.length)];

                /* 是否加粗 */
                int isbold = random.nextInt(2);

                /* 随机字体大小 */
                int fontsize = 22 + random.nextInt(8);

                Font font = new Font(fontname,isbold ,fontsize);

                FontMetrics fm = sun.font.FontDesignMetrics.getMetrics(font);


                int charWidth = fm.charWidth(code.toCharArray()[i]);
                int charHeight = fm.getAscent();

                if(charWidth>charHeight) {
                    startx  += charWidth /2 ;
                }else {
                    startx  += charHeight /2 ;
                }


                int starty =  (height - charHeight)/2;

                int centerx = startx + charWidth/2;
                int centery = starty + charHeight/2;


                charg.translate(centerx, centery);
                charg.rotate(degree*Math.PI/180);
                charg.translate(-centerx, -centery);


                charg.setColor(frontcolor);
                charg.setFont(font);
                charg.drawString(""+code.toCharArray()[i], startx, starty+charHeight);

                charg.translate(centerx, centery);
                charg.rotate(-degree*Math.PI/180);
                charg.translate(-centerx, -centery);




                startx += charWidth;
            }

            /*干扰线*/
            for (int j = 0; j <random.nextInt(10); j++) {
                int linex1 = random.nextInt(width);
                int liney1 = random.nextInt(height);

                int linex2 = random.nextInt(width);
                int liney2 = random.nextInt(height);

                int linewidth = random.nextInt(4) ;

                int arcx = random.nextInt(width);
                int arcy = random.nextInt(height);
                int arcw = random.nextInt(width);
                int arch = random.nextInt(height);
                int degree1 = random.nextInt(360);
                int degree2= random.nextInt(360);

                charg.setColor(getRandColor(180, 200));


                charg.setStroke( new BasicStroke( linewidth ) );

                charg.drawLine(linex1, liney1, linex2, liney2);
                charg.drawArc(arcx, arcy, arcw, arch, degree1, degree2);

            }

            /* 噪点 */
            for (int j = 0; j < 20+random.nextInt(10); j++) {

                int dotx  = random.nextInt(width-1);
                int doty = random.nextInt(height-1);

                Color randomColor = getRandColor(180, 200);
                int dotsize = random.nextInt(4) ;

                charg.setColor(randomColor);
                charg.setStroke(new BasicStroke(dotsize));

                charg.drawLine(dotx, doty, dotx, doty);

            }
            charg.dispose();
            return charImage;


        }

        private static Color getRandomColor(Random random) {
            char r = (char) random.nextInt(256);
            char g = (char) random.nextInt(256);
            char b = (char) random.nextInt(256);

            return new Color(r,g,b);
        }

}