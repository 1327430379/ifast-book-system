package com.fhk.sample.service.impl;

import com.fhk.sample.service.FileReader;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class TXTReader extends FileReader {

    @Override
    public void read(String path, HttpServletResponse response) {
        FileInputStream inputStream = null;
        response.setContentType("text/html;charset=utf-8");
        try {
            inputStream = new FileInputStream(path);
            BufferedReader bis = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            String temp;
            while ((temp = bis.readLine()) != null) {
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(temp);
                System.out.println(temp);
            }
            bis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
