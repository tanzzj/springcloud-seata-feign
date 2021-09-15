package com.teamer.servicetm.service.impl;

import com.teamer.servicetm.dao.TmDAO;
import com.teamer.servicetm.feign.ServiceATFeign;
import com.teamer.servicetm.feign.ServiceTCCFeign;
import com.teamer.servicetm.service.TmService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * tm业务逻辑方法
 *
 * @author tanzj
 */
@Slf4j
@Service
public class TmServiceImpl implements TmService {

    @Autowired
    private TmDAO tmDAO;
    @Autowired
    private ServiceTCCFeign tccFeign;
    @Autowired
    private ServiceATFeign atFeign;

    /**
     * 往本地插入记录
     * 再请求tcc服务插入一条记录
     *
     * @param params - name
     * @return String
     */
    @Override
    @GlobalTransactional(timeoutMills = 60000 * 2)
    @Transactional
    public String insertTcc(Map<String, String> params) {
        log.info("------------------> xid = " + RootContext.getXID());
        tmDAO.insert(params);
        tccFeign.insertTCC(params);
        //throw new RuntimeException("TCC服务测试回滚");
        return "success";
    }

    /**
     * 请求本地事务插入一条记录
     * 再请求at服务插入一条记录
     *
     * @param params - name
     * @return String
     */
    @Override
    @GlobalTransactional(timeoutMills = 60000 * 2)
    @Transactional
    public String insertAt(Map<String, String> params) {
        log.info("------------------> xid = " + RootContext.getXID());
        tmDAO.insert(params);
        atFeign.insertAT(params);
        //throw new RuntimeException("AT服务测试回滚");
        return "success";
    }

}
