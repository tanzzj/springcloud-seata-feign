package com.teamer.servicetm.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

/**
 * AT模式调用at服务
 *
 * @author tanzj
 */
@FeignClient(value = "rm-at")
public interface ServiceATFeign {

    /**
     * 调用at服务插入记录
     *
     * @param params - name
     * @return String
     */
    @PostMapping(value = "/at-insert")
    String insertAT(Map<String, String> params);

}
