package com.hyf.apollo;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigChangeListener;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.model.ConfigChange;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;

import java.util.Set;

/**
 * appId -> namespace -> config
 *
 * @author baB_hyf
 * @date 2022/09/13
 */
public class Hello {

    public static void main(String[] args) throws Exception {
        System.setProperty("app.id", "hyftest");
        System.setProperty("apollo.meta", "http://106.54.227.205:8080");
        System.setProperty("apollo.cache-dir", "E:\\study\\code\\idea4\\learn-apollo\\cache");

        System.setProperty("apollo.label", "grey"); // 灰度标签

        Config appConfig = ConfigService.getAppConfig(); // default namespace: application / not properties -> hyf.yaml
        String property = appConfig.getProperty("hyf", "?");
        System.out.println(property);

        // 动态更新
        appConfig.addChangeListener(new ConfigChangeListener() {
            @Override
            public void onChange(ConfigChangeEvent changeEvent) {
                Set<String> changedKeys = changeEvent.changedKeys();
                for (String key : changedKeys) {
                    ConfigChange change = changeEvent.getChange(key);
                    System.out.printf("Found change - key: %s, oldValue: %s, newValue: %s, changeType: %s%n", change.getPropertyName(), change.getOldValue(), change.getNewValue(), change.getChangeType());
                }
            }
        });

        Thread.currentThread().join();
    }
}
