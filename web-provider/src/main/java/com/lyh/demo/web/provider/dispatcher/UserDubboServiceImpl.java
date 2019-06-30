package com.lyh.demo.web.provider.dispatcher;

import com.lyh.demo.dubbo.interfaces.UserDubboService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @author luoyihang
 * @date 2019/6/30 14:57
 */
@Component
@Slf4j
@Service(version = "${service.api.version}", timeout = 100000, interfaceClass = UserDubboService.class)
public class UserDubboServiceImpl implements UserDubboService {

    @Override
    public String getUserName() {
        String result = "哈哈哈";
        System.out.println("返回值是" + result);
        return result;
    }
}
