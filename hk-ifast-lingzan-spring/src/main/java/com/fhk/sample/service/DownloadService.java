package com.fhk.sample.service;

import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletResponse;

public interface DownloadService {

    ResponseEntity<byte[]> download(String path, HttpServletResponse response);
}
