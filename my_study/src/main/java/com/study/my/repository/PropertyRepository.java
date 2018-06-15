package com.study.my.repository;

import com.study.my.domain.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author sk-cailicheng on 2018/6/14.
 */
@Repository
public interface PropertyRepository extends JpaRepository<Property, Long>, CrudRepository<Property, Long> {
}
