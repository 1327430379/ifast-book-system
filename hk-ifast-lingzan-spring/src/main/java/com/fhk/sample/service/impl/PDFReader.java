package com.fhk.sample.service.impl;

import com.fhk.sample.service.FileReader;
import com.fhk.sample.util.BizAssert;
import groovy.util.logging.Slf4j;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Slf4j
public class PDFReader extends FileReader {
    @Override
    public void read(String path, HttpServletResponse response) {
        ServletOutputStream outputStream = null;
        FileInputStream inputStream = null;
        try {
            outputStream = response.getOutputStream();
            File file = new File(path);
            BizAssert.isTrue(file.exists(), "文件不存在");
            inputStream = new FileInputStream(file);
            byte[] bytes = new byte[1024];

            while (inputStream.read(bytes) != -1) {
                outputStream.write(bytes);
            }
            outputStream.flush();
        } catch (IOException e) {

        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {

                e.printStackTrace();
            }

            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
