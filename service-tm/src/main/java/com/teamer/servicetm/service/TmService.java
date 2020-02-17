package com.teamer.servicetm.service;

import java.util.Map;

public interface TmService {

    /**
     * 往本地插入记录
     * 再请求tcc服务插入一条记录
     *
     * @param params - name
     * @return String
     */
    String insertTcc(Map<String, String> params);

    /**
     * 请求本地事务插入一条记录
     * 再请求at服务插入一条记录
     *
     * @param params - name
     * @return String
     */
    String insertAt(Map<String, String> params);
}
