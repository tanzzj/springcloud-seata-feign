package com.teamer.servicetcc.service.impl;

import com.teamer.servicetcc.dao.TccDAO;
import com.teamer.servicetcc.service.TccService;
import io.seata.core.context.RootContext;
import io.seata.rm.tcc.api.BusinessActionContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class TccServiceImpl implements  TccService {

    @Autowired
    TccDAO tccDAO;

    /**
     * tcc服务t（try）方法
     * 根据实际业务场景选择实际业务执行逻辑或者资源预留逻辑
     *
     * @param params - name
     * @return String
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public String insert(Map<String, String> params) {
        log.info("xid = " + RootContext.getXID());
        //todo 实际的操作，或操作MQ、redis等
        tccDAO.insert(params);
        //放开以下注解抛出异常
        //throw new RuntimeException("服务tcc测试回滚");
        return "success";
    }

    /**
     * tcc服务 confirm方法
     * 若一阶段采用资源预留，在二阶段确认时要提交预留的资源
     *
     * @param context 上下文
     * @return boolean
     */
    @Override
    public boolean commitTcc(BusinessActionContext context) {
        log.info("xid = " + context.getXid() + "提交成功");
        //todo 若一阶段资源预留，这里则要提交资源
        return true;
    }

    /**
     * tcc 服务 cancel方法
     *
     * @param context 上下文
     * @return boolean
     */
    @Override
    public boolean cancel(BusinessActionContext context) {
        //todo 这里写中间件、非关系型数据库的回滚操作
        System.out.println("please manually rollback this data:" + context.getActionContext("params"));
        return true;
    }
}
