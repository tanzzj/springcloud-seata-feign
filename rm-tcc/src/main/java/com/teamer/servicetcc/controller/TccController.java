package com.teamer.servicetcc.controller;

import com.teamer.servicetcc.service.impl.TccServiceImpl;
import io.seata.rm.tcc.api.BusinessActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author tanzj
 */
@RestController
public class TccController {

    @Autowired
    TccServiceImpl service;

    @PostMapping("/tcc-insert")
    public String insertTcc(@RequestBody Map<String, String> params) {
        return service.insert(params);
    }


}
