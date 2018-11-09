package com.solarest.fastloader.manager;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author jinjian
 */
public interface CommandLineManager {

    /**
     * 运行命令行
     *
     * @param command 命令行
     * @param args    参数
     * @throws IOException IO异常
     */
    int runCommandLine(String command, String... args) throws IOException, InterruptedException;

    /**
     * 运行命令行
     *
     * @param command  命令行
     * @param fileName 文件名称
     * @param args     参数
     * @throws IOException IO异常
     */
    int runCommandLineWithFile(String command, String fileName, String... args) throws IOException, InterruptedException;
}
