package com.hyf.apollo.controller;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import com.ctrip.framework.apollo.spring.annotation.ApolloJsonValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author baB_hyf
 * @date 2022/09/13
 */
@RestController
public class AnnotationUse {

    @ApolloConfig
    private Config config;
    @ApolloJsonValue("${hyf_json}")
    private HyfJson hyfJson;

    @RequestMapping("2")
    public void _2() {
        System.out.println(hyfJson);
    }

    @ApolloConfigChangeListener(value = {"application", "hyf.yaml"}, interestedKeys = "hyf", interestedKeyPrefixes = "test")
    private void onChange(ConfigChangeEvent changeEvent) {
        System.out.println(changeEvent.changedKeys());
    }

    public static class HyfJson {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "HyfJson{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
