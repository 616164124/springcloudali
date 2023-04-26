package com.mk.news.action;

import com.com.bean.ObjectBean;
import com.com.bean.User;
import com.mk.common.ServiceResult;
import com.mk.news.bo.UserBean;
import com.mk.news.service.New01Service;
import com.mk.news.service.New02Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class NewsAction {

    private static final Logger log = LoggerFactory.getLogger(NewsAction.class);
    @Value("${server.port}")
    private String port;
    @Resource
    private New01Service new01Service;
    @Resource
    private New02Service new02Service;


    @RequestMapping(value = "new01", method = RequestMethod.GET)
    public ServiceResult getUser01() {
        log.info("new01===>" + port);
        User user = new User();
        user.setPassword("12331");
        ObjectBean objectBean = new ObjectBean();
        objectBean.setData(user);
        ServiceResult serviceResult = new01Service.get(objectBean, "tokenss!!!");
        serviceResult.setMsg(port);
        return serviceResult;
    }

    @RequestMapping(value = "new02", method = RequestMethod.GET)
    public ServiceResult getUser02() {
        log.info("new01===>" + port);
        User user = new User();
        user.setPassword("12331");
        ServiceResult serviceResult = new01Service.get(user, "hjhfuiw");
        serviceResult.setMsg(port);
        return serviceResult;
    }


    @RequestMapping(value = "new03", method = RequestMethod.GET)
    public ServiceResult getUser03() {
        log.info("new01===>" + port);
        UserBean user = new UserBean();
        user.setPassword("12331");
        ServiceResult serviceResult = new02Service.get(user);
        serviceResult.setMsg(port);
        return ServiceResult.defaultSuccess();
    }

    @RequestMapping(value = "new04", method = RequestMethod.GET)
    public ServiceResult getUser04() {
        log.info("new01===>" + port);
        UserBean userBean = new UserBean();

        userBean.setPassword("12331");
        ServiceResult serviceResult = new02Service.get(userBean);
        serviceResult.setMsg(port);
        return ServiceResult.defaultSuccess();
    }

}
