package com.fhk.sample.service;

import groovy.util.logging.Slf4j;

import javax.servlet.http.HttpServletResponse;

@Slf4j
public abstract class FileReader {

   public abstract void read(String path, HttpServletResponse response);

}
