package com.solarest.fastloader.util;

import com.solarest.fastloader.manager.impl.FileOperationManagerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * @author jinjian
 */
public class FileUtils {

    private static final Logger logger = LoggerFactory.getLogger(FileOperationManagerImpl.class);

    public static void writeFile(String path, String name, InputStream inputStream) throws IOException {
        byte[] buffer = new byte[inputStream.available()];
        int length = inputStream.read(buffer);

        File targetFile = new File(path.concat(name));
        if (!targetFile.exists()) {
            targetFile.createNewFile();
        }
        OutputStream outputStream = new FileOutputStream(targetFile);
        outputStream.write(buffer);
        logger.info(String.format("file【%s(%s)】has uploaded : %s", targetFile.getName(), length, path));
    }

}
