package com.solarest.fastloader.manager.impl;

import com.solarest.fastloader.manager.CommandLineManager;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteWatchdog;
import org.apache.commons.exec.Executor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;

/**
 * @author jinjian
 */
@Component
public class CommandLineManagerImpl implements CommandLineManager {

    private final Logger logger = LoggerFactory.getLogger(CommandLineManagerImpl.class);

    @Override
    public int runCommandLine(String command, String... args) throws IOException {
        CommandLine cmdLine = new CommandLine(command);
        cmdLine.addArguments(args);

        ExecuteWatchdog watchdog = new ExecuteWatchdog(60 * 1000);

        Executor executor = new DefaultExecutor();
        executor.setExitValue(1);
        executor.setWatchdog(watchdog);
        return executor.execute(cmdLine);
    }

    @Override
    public int runCommandLineWithFile(String command, String fileName, String... args) throws IOException, InterruptedException {
        String path = ResourceUtils.getURL("classpath:").getPath();
        path = URLDecoder.decode(path, "UTF8");


        CommandLine cmdLine = new CommandLine(command);
        cmdLine.addArguments(args);
        cmdLine.addArgument("${file}");
        HashMap<String, Object> map = new HashMap<>(4);
        map.put("file", new File(path.concat(fileName)));
        cmdLine.setSubstitutionMap(map);

        ExecuteWatchdog watchdog = new ExecuteWatchdog(60 * 1000);

        DefaultExecutor executor = new DefaultExecutor();
        executor.setExitValue(0);
        executor.setWatchdog(watchdog);
        return executor.execute(cmdLine);
    }
}
