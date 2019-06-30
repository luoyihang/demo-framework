package com.lyh.demo.web.provider.controller;

import com.lyh.demo.web.provider.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luoyihang
 * @date 2019/4/30 17:11
 */
@RestController
@RequestMapping("/test")
public class MyTestController {

    @Autowired
    private PersonDao personDao;

    @PostMapping("/test1")
    public String test() {
        return personDao.getPersonName(1L);
    }
}
