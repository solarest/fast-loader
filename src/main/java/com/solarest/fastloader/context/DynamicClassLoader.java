package com.solarest.fastloader.context;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author jinjian
 */
public class DynamicClassLoader extends ClassLoader {

    private String classPath;

    private String className;

    public DynamicClassLoader(String classPath, String className, ClassLoader parent) {
        super(parent);
        this.classPath = classPath;
        this.className = className;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if (name != null && name.equals(this.classPath)) {
            return findClass(name);
        }
        return super.loadClass(name, false);
    }

    @Override
    public Class<?> findClass(String classPath) {
        byte[] raw = readClassBytes(classPath);
        Class<?> clazz = defineClass(null, raw, 0, raw.length);
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
