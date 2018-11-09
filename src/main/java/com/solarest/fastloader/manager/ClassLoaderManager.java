package com.solarest.fastloader.manager;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;

/**
 * @author jinjian
 */
public interface ClassLoaderManager {

    /**
     *
     */
    void run(String className) throws UnsupportedEncodingException, FileNotFoundException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException;


}
