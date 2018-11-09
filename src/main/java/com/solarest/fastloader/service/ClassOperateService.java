package com.solarest.fastloader.service;

import org.springframework.web.multipart.MultipartFile;

public interface ClassOperateService {

    void uploadJar(MultipartFile file);

    void deleteJar(String jarName);

    void installJar(String jarName);

    void uninstallJar(String jarName);

}
