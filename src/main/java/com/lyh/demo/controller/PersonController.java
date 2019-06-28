package com.lyh.demo.controller;

import com.lyh.demo.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luoyihang
 * @date 2019/4/30 17:11
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonDao personDao;

    @PostMapping("/queryName")
    public String queryName() {
        return personDao.getPersonName(1L);
    }
}
