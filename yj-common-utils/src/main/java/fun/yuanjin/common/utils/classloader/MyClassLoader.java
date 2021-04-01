package fun.yuanjin.common.utils.classloader;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @ClassName MyClassLoader
 * @Description 自定义classloader MyClassLoader
 * @Author yuanjin
 * @Date 2021-02-21 16:57
 * @Version 1.0
 */
public class MyClassLoader extends ClassLoader {
    // 文件路径
    private final String byteCodePath;

    public MyClassLoader(String byteCodePath) {
        this.byteCodePath = byteCodePath;
    }

    public MyClassLoader(ClassLoader parent, String byteCodePath) {
        super(parent);
        this.byteCodePath = byteCodePath;
    }

    @Override
    protected Class<?> findClass(String className) {
        BufferedInputStream bis = null;
        ByteArrayOutputStream baos = null;
        try {
            // 获取字节码文件的完整路径
            String fileName = byteCodePath + className + ".class";
            // 获取一个输入缓冲流
            bis = new BufferedInputStream(new FileInputStream(fileName));
            // 定义一个输出缓冲流
            baos = new ByteArrayOutputStream();
            // 具体读取数据
            int len;
            byte[] data = new byte[1024];
            while ((len = bis.read(data)) != -1) {
                baos.write(data, 0, len);
            }
            // 获取内存中完整的字节数组数据
            byte[] byteCodes = baos.toByteArray();
            // 调用defineClass，将字节数组数据转化为class的实例
            return defineClass(className, byteCodes, 0, byteCodes.length);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != baos) {
                    baos.close();
                }
                if (null != bis) {
                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
