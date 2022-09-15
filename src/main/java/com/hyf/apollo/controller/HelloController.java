package com.hyf.apollo.controller;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author baB_hyf
 * @date 2022/09/13
 */
@RestController
public class HelloController {

    @Value("${hyf}")
    private String s;
    @ApolloConfig // application
    private Config config;
    @ApolloConfig("hyf.yaml")
    private Config configHyf;

    // http://localhost:8082/1
    @RequestMapping("1")
    public void _1() {
        System.out.println(s);
        String property = config.getProperty("hyf", "");
        System.out.println(property);
        String propertyHyf = configHyf.getProperty("hyf", "");
        System.out.println(propertyHyf);
    }
}
