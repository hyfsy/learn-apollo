package com.hyf.apollo;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author baB_hyf
 * @date 2022/09/13
 */
@EnableApolloConfig // inject @ApolloConfig
@SpringBootApplication
public class ApolloApplication {
    public static void main(String[] args) {

        System.setProperty("app.id", "hyftest");
        System.setProperty("apollo.meta", "http://106.54.227.205:8080");
        System.setProperty("apollo.cache-dir", "E:\\study\\code\\idea4\\learn-apollo\\cache");
        SpringApplication.run(ApolloApplication.class, args);
    }
}
