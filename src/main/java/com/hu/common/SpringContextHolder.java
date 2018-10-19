package com.hu.common;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class SpringContextHolder implements ApplicationContextAware , DisposableBean {


    private static ApplicationContext ac;

    public static <T> T getBean(Class<T> clazz){
        return ac.getBean(clazz);
    }

    public static <T> T getBean(String clazzName){
        return (T) ac.getBean(clazzName);
    }

    @Override
    public void destroy() throws Exception {
        this.ac = null;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
       this.ac = applicationContext;
    }

    public void assertClassNotNull(){
        Validate.validState(this.ac != null , "applicationContext没有注入");
    }
}
