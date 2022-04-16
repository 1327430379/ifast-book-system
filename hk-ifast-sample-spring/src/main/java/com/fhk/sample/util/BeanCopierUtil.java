//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.fhk.sample.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.beanutils.BeanMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.core.Converter;
import org.springframework.util.CollectionUtils;

public final class BeanCopierUtil {
    private static final Logger log = LoggerFactory.getLogger(BeanCopierUtil.class);
    private static final Map<String, BeanCopier> BEAN_COPIER_CACHE = new LinkedHashMap<String, BeanCopier>() {
        protected boolean removeEldestEntry(Entry<String, BeanCopier> eldest) {
            return this.size() > 1000;
        }
    };



    public static void copyProperties(Object source, Object target) {
        if (source != null && target != null) {
            BeanCopier beanCopier = getBeanCopier(source.getClass(), target.getClass());
            beanCopier.copy(source, target, (Converter)null);
        }
    }

    public static <T> T copyProperties(Object source, Class<T> targetClass) {
        if (source == null) {
            return null;
        } else {
            T t = null;

            try {
                t = targetClass.getConstructor().newInstance();
                copyProperties(source, t);
            } catch (Exception var4) {
                log.warn("对象复制错误!source=" + source.getClass() + "|target=" + targetClass, var4);
            }

            return t;
        }
    }





    private static BeanCopier getBeanCopier(Class<?> sourceClass, Class<?> targetClass) {
        String beanKey = generateKey(sourceClass, targetClass);
        BeanCopier copier;
        if (!BEAN_COPIER_CACHE.containsKey(beanKey)) {
            copier = BeanCopier.create(sourceClass, targetClass, false);
            BEAN_COPIER_CACHE.put(beanKey, copier);
        } else {
            copier = (BeanCopier)BEAN_COPIER_CACHE.get(beanKey);
        }

        return copier;
    }

    private static String generateKey(Class<?> sourceClass, Class<?> targetClass) {
        return sourceClass.getName() + targetClass.getName();
    }


    public static Map<String, Object> objectToMap(Object obj) {
        if (obj == null) {
            return null;
        } else {
            Map<String, Object> map = new HashMap();
            BeanMap beanMap = new BeanMap(obj);
            if (CollectionUtils.isEmpty(beanMap)) {
                return map;
            } else {
                Iterator var3 = beanMap.entrySet().iterator();

                while(var3.hasNext()) {
                    Entry<Object, Object> entry = (Entry)var3.next();
                    map.put(entry.getKey().toString(), entry.getValue());
                }

                return map;
            }
        }
    }
}
