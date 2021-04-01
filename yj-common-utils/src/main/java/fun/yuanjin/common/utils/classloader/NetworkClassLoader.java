package fun.yuanjin.common.utils.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URL;

/**
 * @ClassName NetworkClassLoader
 * @Description TODO
 * @Author yuanjin
 * @Date 2021-01-17 11:42
 * @Version 1.0
 */
public class NetworkClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = downloadClassData(name); // 从远程下载
        if (classData == null) {
            super.findClass(name); // 未找到，抛异常
        } else {
            return defineClass(name, classData, 0, classData.length); // convert class byte data to Class<?> object
        }
        return null;
    }

    private byte[] downloadClassData(String name) {        // 从 localhost 下载 .class 文件
        String path = "http://localhost" + File.separatorChar + "java" + File.separatorChar + name.replace('.', File.separatorChar) + ".class";

        try {
            URL url = new URL(path);
            InputStream ins = url.openStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int bufferSize = 4096;
            byte[] buffer = new byte[bufferSize];
            int bytesNumRead = 0;
            while ((bytesNumRead = ins.read(buffer)) != -1) {
                // 把下载的二进制数据存入 ByteArrayOutputStream
                baos.write(buffer, 0, bytesNumRead);
            }
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getName() {
        System.out.println("Real NetworkClassLoader");
        return "networkClassLoader";
    }
}
