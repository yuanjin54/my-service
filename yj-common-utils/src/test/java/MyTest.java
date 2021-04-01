import java.io.*;

/**
 * @ClassName MyTest
 * @Description TODO
 * @Author yuanjin
 * @Date 2020-11-02 20:26
 * @Version 1.0
 */
public class MyTest {

    public static void main(String[] args) throws IOException {
        String url = "/Users/yuanjin/Desktop/data/image";
        String newUrl = "/Users/yuanjin/Desktop/sql";
        FileWriter fileWritter = new FileWriter(newUrl, true);
        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
        for (int i = 0; i < 128; i++) {
            String c = readFileContent(url, i);
            bufferWritter.write(c);
        }
        bufferWritter.close();
        System.out.println("Done");
    }


    public static String readFileContent(String fileName, int n) {
        File file = new File(fileName + n);
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        try {
            FileReader fileReader = null;
            try {
                fileReader = new FileReader(file);
            } catch (FileNotFoundException e) {

            }
            if (null == fileReader) {
                return "";
            }
            reader = new BufferedReader(fileReader);
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                tempStr = revert(tempStr, n);
                sbf.append(tempStr);
            }
            reader.close();
            return sbf.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return sbf.toString();
    }

    private static String revert(String s, int n) {
        if (s == null || s.trim().length() == 0) {
            return "";
        }
        String[] ss = s.split("\t");
        String u = ss[1].replace("p.vip.sankuai.com", "p0.meituan.net");

        return "update poi_images_" + n + " set url='" + u + "' where id=" + ss[0] + ";\n";

    }

}
