package com.fhk.sample.util;


public class BizNoGenerator {


    public static synchronized String generate(String prefix) {
        try {
            Thread.sleep(1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return prefix + System.currentTimeMillis();
    }

    public static synchronized String generate() {
        try {
            Thread.sleep(1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return BizNoPrefix.BB + System.currentTimeMillis();
    }
}
