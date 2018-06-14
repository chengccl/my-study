package com.study.my.dao.impl;

import com.study.my.dao.InfoDao;
import com.study.my.domain.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author sk-cailicheng on 2018/6/14.
 */
@Repository
public class InfoDaoImpl implements InfoDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void save(Info info) {
        mongoTemplate.save(info);
    }
}
