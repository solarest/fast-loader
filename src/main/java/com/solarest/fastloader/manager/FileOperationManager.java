package com.solarest.fastloader.manager;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author jinjian
 */
public interface FileOperationManager {

    /**
     * 上传文件
     *
     * @param file 文件
     * @throws IOException IOException
     */
    void uploadFile(File file) throws IOException;

    /**
     * 获取文件列表
     *
     * @return 文件列表
     * @throws IOException IOException
     */
    List<String> getFileList() throws IOException;

    void deleteFile();

    void updateFile();

}
