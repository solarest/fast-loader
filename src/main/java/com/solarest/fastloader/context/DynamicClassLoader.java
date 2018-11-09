package com.solarest.fastloader.context;

import java.io.*;

/**
 * @author jinjian
 */
public class DynamicClassLoader extends ClassLoader {

    private String classPath;

    public DynamicClassLoader(String classPath, ClassLoader parent) {
        super(parent);
        this.classPath = classPath;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if (name != null && name.equals(this.classPath)) {
            return findClass(name);
        }
        return super.loadClass(name, false);
    }

    @Override
    protected Class<?> findClass(String fullClassPath) {
        byte[] raw = readClassBytes(fullClassPath);
        Class<?> clazz = defineClass(fullClassPath, raw, 0, raw.length);
        resolveClass(clazz);
        return clazz;
    }

    /**
     * 读取class文件
     *
     * @param classPath 类路径
     * @return byte
     */
    private byte[] readClassBytes(String classPath) {
        byte[] raw = null;
        File file = new File(classPath);

        try (InputStream stream = new FileInputStream(file)) {
            raw = new byte[(int) file.length()];
            stream.read(raw);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return raw;
    }
}
