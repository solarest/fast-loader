package com.solarest.fastloader.controller;

import com.solarest.fastloader.manager.CommandLineManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author jinjian
 */
@RestController
@RequestMapping("/command")
public class CommandLineController extends BaseController {

    private final CommandLineManager commandLineManager;

    @Autowired
    public CommandLineController(CommandLineManager commandLineManager) {
        this.commandLineManager = commandLineManager;
    }

    @RequestMapping(value = "/run-with-file", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String runWithFile(
            @RequestParam String cmd,
            @RequestBody MultipartFile file
    ) throws IOException, InterruptedException {
//        commandLineManager.runCommandLine(cmd, file);
        return responseSuccess();
    }
}
