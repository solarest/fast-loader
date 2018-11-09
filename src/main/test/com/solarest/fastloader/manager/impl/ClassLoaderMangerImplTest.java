package com.solarest.fastloader.manager.impl;

import com.solarest.fastloader.manager.ClassLoaderManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ClassLoaderMangerImplTest {

    @Autowired
    private ClassLoaderManager classLoaderManager;

    @Test
    public void run() throws IllegalAccessException, InvocationTargetException, UnsupportedEncodingException, InstantiationException, FileNotFoundException, NoSuchMethodException, ClassNotFoundException {
        classLoaderManager.run("TestPrint.class");
    }
}