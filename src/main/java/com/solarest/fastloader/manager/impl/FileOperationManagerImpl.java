package com.solarest.fastloader.manager.impl;

import com.solarest.fastloader.manager.FileOperationManager;
import com.solarest.fastloader.util.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jinjian
 */
@Component
public class FileOperationManagerImpl implements FileOperationManager {

    private final Logger logger = LoggerFactory.getLogger(FileOperationManagerImpl.class);

    @Override
    public void uploadFile(File file) throws IOException {
        String path = ResourceUtils.getURL("classpath:").getPath();
        path = URLDecoder.decode(path, "UTF8");

        InputStream inputStream = new FileInputStream(file);
        FileUtils.writeFile(path, file.getName(), inputStream);
    }

    @Override
    public List<String> getFileList() throws FileNotFoundException, UnsupportedEncodingException {
        String path = ResourceUtils.getURL("classpath:").getPath();
        path = URLDecoder.decode(path, "UTF8");

        File file = new File(path);
        File[] fileList = file.listFiles();

        List<String> fileName = new ArrayList<>();
        if (fileList != null && fileList.length > 0) {
            fileName = Arrays.stream(fileList).filter(x -> !x.isDirectory())
                    .map(File::getName)
                    .collect(Collectors.toList());
        }
        return fileName;
    }

    @Override
    public void deleteFile() {

    }

    @Override
    public void updateFile() {

    }
}
