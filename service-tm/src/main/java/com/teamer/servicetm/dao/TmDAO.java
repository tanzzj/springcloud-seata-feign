package com.teamer.servicetm.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author tanzj
 */
@Mapper
@Component
public interface TmDAO {

    /**
     * 插入A表数据
     *
     * @param map aName
     * @return int
     */
    @Insert("insert into service_tm (aName) value (#{name})")
    int insert(Map<String, String> map);

}
