package com.solarest.fastloader.manager.impl;

import com.solarest.fastloader.manager.FileOperationManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileOperationManagerImplTest {

    @Autowired
    private FileOperationManager fileOperationManager;

    @Test
    public void uploadFile() throws IOException {
        File file = new File("/Users/jinjian/项目/idea/personal-projects/faster-loader/src/main/resources/file/TestPrint.java");
        fileOperationManager.uploadFile(file);
    }

    @Test
    public void getFileList() throws IOException {
        System.out.println(fileOperationManager.getFileList());
    }

    @Test
    public void deleteFile() {
    }

    @Test
    public void updateFile() {
    }
}