package com.solarest.fastloader.manager.impl;

import com.solarest.fastloader.manager.CommandLineManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommandLineManagerImplTest {

    @Autowired
    private CommandLineManager commandLineManager;

    @Test
    public void runCommandLine() throws IOException, InterruptedException {
        System.out.println(commandLineManager.runCommandLineWithFile("javac", "TestPrint.java"));
    }

    @Test
    public void runCommandLine1() {
    }
}