package com.fhk.sample.service.impl;

import com.fhk.sample.service.DownloadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;

@Slf4j
@Service
public class DownloadServiceImpl implements DownloadService {


    @Override
    public ResponseEntity<byte[]> download(String path, HttpServletResponse response) {
        byte [] body = null;
        String fileName = parseFileName(path);
        try {
            InputStream in = new FileSystemResource(path).getInputStream();
            body = new byte[in.available()];
            in.read(body);
        } catch (IOException e1) {
            log.debug("文件读入出错，文件路径为："+path);
            e1.printStackTrace();
            return null;
        }

        //添加响应头
        HttpHeaders headers = new HttpHeaders();
        try {
            fileName = URLDecoder.decode(fileName, "UTF-8");
            log.debug("获取的文件名为："+new String(fileName.getBytes("ISO8859-1"),"UTF-8"));
        } catch (UnsupportedEncodingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        //这里fileName有可能出现下载文件乱码-需要自己处理
        headers.add("Content-Disposition", "attachment;filename="+fileName);

        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        HttpStatus statusCode = HttpStatus.OK;

        return new ResponseEntity<byte[]>(body, headers, statusCode);

    }



    private  String parseFileName(String path) {
        int lastIndexOf = path.lastIndexOf("\\");
        String fileName = path.substring(lastIndexOf, path.length());
        System.out.println(fileName);
        return fileName;
    }

    public static void main(String[] args) {
//        String path ="Z:\\code\\book_system\\hk-ifast-lingzan-spring\\src\\main\\resources\\static\\upload\\plan.txt";
//        parseFileName(path);
        System.out.println("hello world");
    }
}
