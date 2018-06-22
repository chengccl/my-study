package com.study.my.property;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author sk-cailicheng on 2018/6/14.
 */
@Configuration
public class CustomProperties extends PropertyPlaceholderConfigurer {

    /**
     * 重载合并属性实现
     * 先加载file properties， 然后并入ZK配置中心读取的properties
     *
     * @return 合并后的属性集合
     * @throws IOException 异常
     */
    @Override
    protected Properties mergeProperties() throws IOException {
        Properties result = new Properties();
        // 加载父类的配置
        Properties mergeProperties = super.mergeProperties();
        result.putAll(mergeProperties);
        // 加载从map读取到的配置
        Map<String, String> configs = loadConfigs();
        result.putAll(configs);
        return result;
    }

    private Map<String, String> loadConfigs() {
        Map<String, String> configs = new HashMap<>();

//        Properties properties = PropertiesUtils.loadProps("/config.properties");
//        configs.put("spring.data.mongodb.uri", properties.getProperty("spring.data.mongodb.uri"));
//        configs.put("spring.data.mongodb.repositories.enabled", properties.getProperty("spring.data.mongodb.repositories.enabled"));
//        configs.put("hello.value", properties.getProperty("hello.value"));

        configs.put("spring.data.mongodb.uri", "mongodb://mongo.host:27017/propertyTest");
        configs.put("spring.data.mongodb.repositories.enabled", "true");
        configs.put("hello.value", "hello2");

        return configs;
    }

    /**
     * 重载处理属性实现
     * 根据选项, 决定是否将合并后的props写入系统属性, Spring boot需要
     *
     * @param beanFactoryToProcess
     * @param props                合并后的属性
     * @throws BeansException
     */
    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
        // 原有逻辑
        super.processProperties(beanFactoryToProcess, props);
        // 写入到系统属性
        // write all properties to system for spring boot
        Enumeration<?> propertyNames = props.propertyNames();
        while (propertyNames.hasMoreElements()) {
            String propertyName = (String) propertyNames.nextElement();
            String propertyValue = props.getProperty(propertyName);
            System.setProperty(propertyName, propertyValue);
        }
    }

}
