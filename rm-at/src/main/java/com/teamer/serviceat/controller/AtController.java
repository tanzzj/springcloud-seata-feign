package com.teamer.serviceat.controller;

import com.alibaba.fastjson.JSON;
import com.teamer.serviceat.service.AtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AtController {

    @Autowired
    AtService atService;

    @PostMapping("/at-insert")
    public String insert(@RequestBody Map<String, String> params) {
        System.out.println(JSON.toJSONString(params));
        return atService.insert(params);
    }
}
