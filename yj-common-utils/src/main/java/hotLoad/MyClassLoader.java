package hotLoad;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @ClassName MyClassLoader
 * @Description TODO
 * @Author yuanjin
 * @Date 2021-02-18 23:04
 * @Version 1.0
 */
public class MyClassLoader extends ClassLoader {
    private String rootDir = ".";

    public MyClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] bytes = readClassFile(name);
        if (bytes != null) {
            return defineClass(null, bytes, 0, bytes.length);
        } else {
            throw new ClassNotFoundException();
        }
    }

    private byte[] readClassFile(String name) {
        try {
            File file = new File(rootDir + File.separatorChar + name + ".class");
            InputStream input = new FileInputStream(file);
            byte[] buffer = new byte[4096];
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int num = 0;
            while ((num = input.read(buffer)) != -1) {
                baos.write(buffer, 0, num);
            }
            input.close();
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
