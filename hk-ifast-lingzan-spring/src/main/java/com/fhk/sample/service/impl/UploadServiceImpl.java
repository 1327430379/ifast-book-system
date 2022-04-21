package com.fhk.sample.service.impl;

import com.fhk.sample.service.UploadService;
import com.fhk.sample.util.ServletRequestUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationHome;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Service
public class UploadServiceImpl implements UploadService {

    @Value("${server.port}")
    private String port;

    @Override
    public String upload(MultipartFile file) {
        HttpServletRequest request = ServletRequestUtil.getHttpServletRequest();
        String filePath = "";
        String basePath = getSavePath();
        File basePathFile = new File(basePath);
        if (!basePathFile.exists()) {
            basePathFile.mkdirs();
        }
        filePath = basePath + file.getOriginalFilename();
        File file1 = new File(filePath);
        if (file1.exists()) {
            return file1.getAbsolutePath();
        }
        try {
            file.transferTo(file1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return filePath;
    }

    private String getSavePath() {
        ApplicationHome applicationHome = new ApplicationHome(this.getClass());
        return applicationHome.getDir().getParentFile().getParentFile().getAbsolutePath() + "\\src\\main\\resources\\static\\upload\\";
    }

}
