package com.mk.user01.action;

import com.mk.common.ServiceResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController("user")
public class UserAction {

    private static final Logger log = LoggerFactory.getLogger(UserAction.class);
    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "one", method = RequestMethod.POST)
    public ServiceResult getUser01(HttpServletRequest request, @RequestBody Object o) {
//        int i =1/0;
        String token = request.getHeader("token");
        log.info(token+"===one===>" + port);

        return ServiceResult.successObject(port);
    }

    @RequestMapping(value = "two", method = RequestMethod.GET)
    public String getUser02() {
        log.info("one===>" + port);
        return "one===>" + port;
    }

}
