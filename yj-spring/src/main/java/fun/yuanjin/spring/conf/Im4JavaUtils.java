package fun.yuanjin.spring.conf;

import org.im4java.core.*;
import org.im4java.process.ArrayListOutputConsumer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Im4JavaUtils
 * @Description 图片工具类
 * @Author yuanjin
 * @Date 2021-03-31 15:17
 * @Version 1.0
 */
public class Im4JavaUtils {
    //代码中ImageMagick安装包的地址
    private static final String IMAGE_MAGICK_PATH = "/Users/yuanjin/ImageMagick-6.3.2/";

    //源图片目录
    public static final String SRC_IMAGE_PATH = "/Users/yuanjin/Pictures/";
    //新图片目录
    public static final String NEW_IMAGE_PATH = "/Users/yuanjin/Pictures/";
    //水印图片地址
    public static final String APPEND_IMAGE_PATH = "/Users/yuanjin/Pictures/timg.png";

    public static void main(String[] args) {

        //旋转图片
        //Im4JavaUtils.roateImage(SRC_IMAGE_PATH + "1.jpg", NEW_IMAGE_PATH + "1.jpg", 90.0);
        //裁剪图片
        //Im4JavaUtils.cutImage(SRC_IMAGE_PATH + "1.jpg", NEW_IMAGE_PATH + "1.jpg", 100, 100, 100, 100);
        //缩放图片
        //Im4JavaUtils.zoomImage(SRC_IMAGE_PATH + "1.jpg", NEW_IMAGE_PATH + "1.jpg", 400, 270);
        //压缩图片
        //Im4JavaUtils.compressImage(SRC_IMAGE_PATH + "1.jpg", NEW_IMAGE_PATH + "1.jpg", 50.0);
        //加文字水印
        //Im4JavaUtils.textImage(SRC_IMAGE_PATH + "1.jpg", NEW_IMAGE_PATH + "1.jpg", "TEST");
        //加图片水印
//        Im4JavaUtils.compositeImage(SRC_IMAGE_PATH + "1.jpg", NEW_IMAGE_PATH + "1.jpg", APPEND_IMAGE_PATH, 50);

        System.out.println("======获取信息=====");
        Map<String, String> imageInfo = Im4JavaUtils.getImageInfo(SRC_IMAGE_PATH + "t1.png");
        for (String key : imageInfo.keySet()) {
            System.out.println(key + " : " + imageInfo.get(key));
        }
        System.out.println("======获取信息=====");

    }

    enum CommandType {
        /**
         * 转换处理
         */
        convert("转换处理"), composite("图片合成"), identify("图片信息"),
        ;

        private String name;

        CommandType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

    private static ImageCommand getImageCommand(CommandType command) {
        ImageCommand cmd = null;
        switch (command) {
            case convert:
                cmd = new ConvertCmd();
                break;
            case composite:
                cmd = new CompositeCmd();
                break;
            case identify:
                cmd = new IdentifyCmd();
                break;
            default:
                break;
        }
        if (cmd != null) {
            cmd.setSearchPath(IMAGE_MAGICK_PATH);
        }
        return cmd;
    }

    /**
     * 旋转图片
     *
     * @param srcImagePath 原图片地址
     * @param newImagePath 新图片地址
     * @param degree       旋转角度
     * @return
     */
    public static boolean roateImage(String srcImagePath, String newImagePath, Double degree) {
        try {
            IMOperation op = new IMOperation();
            op.addImage(srcImagePath);
            op.rotate(degree);
            op.addImage(newImagePath);
            ImageCommand convert = getImageCommand(CommandType.convert);
            convert.run(op);
            System.out.println("旋转图片成功");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 裁剪图片
     *
     * @param srcImagePath 原图片地址
     * @param newImagePath 新图片地址
     * @param width        裁剪后的宽度
     * @param height       裁剪后的高度
     * @param x            起始横坐标
     * @param y            起始纵坐标
     * @return
     */
    public static boolean cutImage(String srcImagePath, String newImagePath, Integer width, Integer height, Integer x, Integer y) {
        try {
            IMOperation op = new IMOperation();
            op.addImage(srcImagePath);
            op.crop(width, height, x, y);
            op.addImage(newImagePath);
            ImageCommand convert = getImageCommand(CommandType.convert);
            convert.run(op);
            System.out.println("裁剪图片成功");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 缩放图片
     *
     * @param srcImagePath 原图片地址
     * @param newImagePath 新图片地址
     * @param width        缩放后的宽度
     * @param height       缩放后的高度
     *                     高度和宽度需符合图片比例，不符合的情况下，以其中最小值为准。
     * @return
     */
    public static boolean zoomImage(String srcImagePath, String newImagePath, Integer width, Integer height) {
        try {
            IMOperation op = new IMOperation();
            op.addImage(srcImagePath);
            op.resize(width, height);
            op.addImage(newImagePath);
            ImageCommand convert = getImageCommand(CommandType.convert);
            convert.run(op);
            System.out.println("缩放图片成功");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 压缩图片
     *
     * @param srcImagePath 原图片地址
     * @param newImagePath 新图片地址
     * @param quality      压缩比例
     *                     图片压缩比，有效值范围是0.0-100.0，数值越大，缩略图越清晰。
     * @return
     */
    public static boolean compressImage(String srcImagePath, String newImagePath, Double quality) {
        try {
            IMOperation op = new IMOperation();
            op.addImage(srcImagePath);
            op.quality(quality);
            op.addImage(newImagePath);
            ImageCommand convert = getImageCommand(CommandType.convert);
            convert.run(op);
            System.out.println("压缩图片成功");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 文字水印
     *
     * @param srcImagePath 原图片地址
     * @param newImagePath 新图片地址
     * @param content      水印文字，不支持汉字
     * @return
     */
    public static boolean textImage(String srcImagePath, String newImagePath, String content) {
        try {
            IMOperation op = new IMOperation();
            op.addImage(srcImagePath);
            //右下角
            op.font("ArialBold").gravity("southeast").pointsize(60).fill("#F2F2F2").draw("text 10,10 " + content);
            op.addImage(newImagePath);
            ImageCommand convert = getImageCommand(CommandType.convert);
            convert.run(op);
            System.out.println("添加文字水印成功");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 图片水印
     *
     * @param srcImagePath    原图片地址
     * @param newImagePath    新图片地址
     * @param appendImagePath 水印图片地址
     * @param dissolve        水印透明度，0-100
     * @return
     */
    public static boolean compositeImage(String srcImagePath, String newImagePath, String appendImagePath, Integer dissolve) {
        try {
            //原图片信息
            BufferedImage bufferedImage = ImageIO.read(new File(srcImagePath));
            int w = bufferedImage.getWidth();
            int h = bufferedImage.getHeight();
            //水印图片信息
            Image image = ImageIO.read(new File(appendImagePath));
            int w1 = image.getWidth(null);
            int h1 = image.getHeight(null);

            IMOperation op = new IMOperation();
            op.geometry(w1, h1, w - w1 - 10, h - h1 - 10);
            op.dissolve(dissolve);
            op.addImage(appendImagePath);
            op.addImage(srcImagePath);
            op.addImage(newImagePath);
            ImageCommand composite = getImageCommand(CommandType.composite);
            composite.run(op);
            System.out.println("添加图片水印成功");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 获取图片信息
     *
     * @param imagePath 图片地址
     * @return
     */
    public static Map<String, String> getImageInfo(String imagePath) {
        Map<String, String> imageInfo = new HashMap<>();
        try {
            IMOperation op = new IMOperation();
            op.format("%w,%h,%d/%f,%Q,%b,%e");
            op.addImage();
            //注意这里，用的是identify
            ImageCommand identifyCmd = getImageCommand(CommandType.identify);
            ArrayListOutputConsumer output = new ArrayListOutputConsumer();
            identifyCmd.setOutputConsumer(output);
            identifyCmd.run(op, imagePath);
            ArrayList<String> cmdOutput = output.getOutput();
            String[] result = cmdOutput.get(0).split(",");
            if (result.length == 6) {
                imageInfo.put("宽度", result[0]);
                imageInfo.put("高度", result[1]);
                imageInfo.put("路径", result[2]);
                imageInfo.put("质量", result[3]);
                imageInfo.put("大小", result[4]);
                imageInfo.put("格式", result[5]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imageInfo;
    }
}
