package com.teamer.servicetm.controller;

import com.teamer.servicetm.service.TmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 发起事务controller
 *
 * @author tanzj
 */
@RestController
public class TmController {

    @Autowired
    TmService service;

    /**
     * 调用AT自动事务
     *
     * @param name - 传入参数
     * @return String (success)
     */
    @GetMapping("/insert-at")
    public String insertAt(@RequestParam String name) {
        Map<String, String> params = new HashMap<>(1);
        params.put("name", name);
        return service.insertAt(params);
    }

    /**
     * 调用TCC手工分布式事务
     *
     * @param name - 入参
     * @return String
     */
    @GetMapping("/insert-tcc")
    public String insertTcc(@RequestParam String name) {
        Map<String, String> params = new HashMap<>(1);
        params.put("name", name);
        return service.insertTcc(params);
    }


}
