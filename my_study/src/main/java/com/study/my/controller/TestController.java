package com.study.my.controller;

import com.study.my.dao.InfoDao;
import com.study.my.domain.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sk-cailicheng on 2018/6/14.
 */
@RestController
@RequestMapping("/info")
public class TestController {
    @Value("${hello.value:hello2}")
    private String value;

    @Value("${spring.data.mongodb.uri:xxx}")
    private String mongo;

    @Autowired
    private InfoDao infoDao;

    @RequestMapping(path = "/save", method = RequestMethod.GET)
    public String save(HttpServletRequest request) {
        Info info = new Info();
        info.setName("hello");
        infoDao.save(info);
        return value + " " + mongo;
    }
}
