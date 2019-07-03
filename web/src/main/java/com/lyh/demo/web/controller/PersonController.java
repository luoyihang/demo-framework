package com.lyh.demo.web.controller;

import com.lyh.demo.web.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.Date;

/**
 * @author luoyihang
 * @date 2019/4/30 17:11
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    @Resource
    private PersonDao personDao;

    @PostMapping("/queryName")
    public String queryName() {
        return personDao.getPersonName(1L);
    }

    /**
     * 未配置分表的表能正常使用任何SQL
     *
     * @return
     */
    @PostMapping("/queryTest")
    public String queryTest() {
        personDao.getTest("aa");
        return "success";
    }

    @PostMapping("/queryOrder")
    public String queryOrder() {
        String orderName = "aaa";
        Date startDate = new Date();
        Date endDate = new Date();
        personDao.queryOrder(orderName, startDate, endDate);
        return "success";
    }

    @PostMapping("/insertOrder")
    public String insertOrder() {
        Date startDate = new Date();
        personDao.insertOrder(startDate);
        return "success";
    }

}
