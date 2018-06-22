package com.study.my.utils;

import java.util.Properties;

/**
 * 获取配置
 * Created by sk-cailicheng on 2017/11/24.
 */
public class PropertiesUtils {
    /**
     * 加载属性文件
     *
     * @param filePath 文件路径
     * @return
     */
    public static Properties loadProps(String filePath) {
        Properties properties = new Properties();
        try {
            properties.load(PropertiesUtils.class.getResourceAsStream(filePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }
}
