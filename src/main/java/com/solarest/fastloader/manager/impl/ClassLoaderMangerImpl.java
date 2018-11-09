package com.solarest.fastloader.manager.impl;

import com.solarest.fastloader.context.DynamicClassLoader;
import com.solarest.fastloader.manager.ClassLoaderManager;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLDecoder;

/**
 * @author jinjian
 */
@Component
public class ClassLoaderMangerImpl implements ClassLoaderManager {

    @Override
    public void run(String className) throws UnsupportedEncodingException, FileNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        String path = ResourceUtils.getURL("classpath:").getPath();
        path = URLDecoder.decode(path, "UTF8");

        String classPath = path.concat(className);

        DynamicClassLoader classLoader = new DynamicClassLoader(classPath, className, Thread.currentThread().getContextClassLoader());
        Object obj = classLoader.findClass(classPath).newInstance();

        Class clz  = obj.getClass();
        Method m = clz.getMethod("test");
        System.out.println(m.invoke(obj));
    }
}
