package com.teamer.serviceat.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.Map;

@Mapper
@Component
public interface AtDAO {

    @Insert("insert into service_at (name) value (#{name})")
    int insert(Map<String, String> map);

}
