package com.lyh.demo.web.controller;

import com.google.common.collect.Lists;
import com.lyh.demo.web.dao.PersonDao;
import com.lyh.demo.web.entity.PersonModel;
import com.lyh.demo.web.entity.TestParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author luoyihang
 * @date 2019/4/30 17:11
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class MyTestController {

    @Resource
    private PersonDao personDao;

    @PostMapping("/test1")
    public String test1(@RequestBody TestParam testParam) {
        System.gc();
        Integer testTotalNum = testParam.getTestTotalNum();
        Integer testPageNum = testParam.getTestPageNum();
        if (testTotalNum == null) {
            testTotalNum = 100000;
        }
        if (testPageNum == null) {
            testPageNum = 50;
        }
        List<PersonModel> personList = new ArrayList<>(testTotalNum);

        Date date = new Date();
        log.info("开始组装数据");
        for (int i = 1; i <= testTotalNum; i++) {
            PersonModel personModel = buildPerson(i);
            personList.add(personModel);
        }
        long startTime = System.currentTimeMillis();
        List<List<PersonModel>> partition = Lists.partition(personList, testPageNum);
        int nowSize = 0;
        int dataSize = personList.size();
        for (List<PersonModel> list : partition) {
            personDao.batchInsertPerson50(list);
            nowSize += testPageNum;
            log.info("当前插入，[{}]/[{}]", nowSize, dataSize);
        }
        log.info("插入结束，总条数[{}]，每次插入[{}]，花费时间 [{}]", testTotalNum, testPageNum, System.currentTimeMillis() - startTime);

        return "success";
    }

    private PersonModel buildPerson(Integer serialNum) {
        PersonModel personModel = new PersonModel();
        personModel.setId(serialNum);
        personModel.setUdf01(UUID.randomUUID().toString());
        personModel.setUdf02(UUID.randomUUID().toString());
        personModel.setUdf03(UUID.randomUUID().toString());
        personModel.setUdf04(UUID.randomUUID().toString());
        personModel.setUdf05(UUID.randomUUID().toString());
        personModel.setUdf06(UUID.randomUUID().toString());
        personModel.setUdf07(UUID.randomUUID().toString());
        personModel.setUdf08(UUID.randomUUID().toString());
        personModel.setUdf09(UUID.randomUUID().toString());
        personModel.setUdf10(UUID.randomUUID().toString());
        personModel.setUdf11(UUID.randomUUID().toString());
        personModel.setUdf12(UUID.randomUUID().toString());
        personModel.setUdf13(UUID.randomUUID().toString());
        personModel.setUdf14(UUID.randomUUID().toString());
        personModel.setUdf15(UUID.randomUUID().toString());
        personModel.setUdf16(UUID.randomUUID().toString());
        personModel.setUdf17(UUID.randomUUID().toString());
        personModel.setUdf18(UUID.randomUUID().toString());
        personModel.setUdf19(UUID.randomUUID().toString());
        personModel.setUdf20(UUID.randomUUID().toString());
        personModel.setUdf21(UUID.randomUUID().toString());
        personModel.setUdf22(UUID.randomUUID().toString());
        personModel.setUdf23(UUID.randomUUID().toString());
        personModel.setUdf24(UUID.randomUUID().toString());
        personModel.setUdf25(UUID.randomUUID().toString());
        personModel.setUdf26(UUID.randomUUID().toString());
        personModel.setUdf27(UUID.randomUUID().toString());
        personModel.setUdf28(UUID.randomUUID().toString());
        personModel.setUdf29(UUID.randomUUID().toString());
        personModel.setUdf30(UUID.randomUUID().toString());
        personModel.setUdf31(UUID.randomUUID().toString());
        personModel.setUdf32(UUID.randomUUID().toString());
        personModel.setUdf33(UUID.randomUUID().toString());
        personModel.setUdf34(UUID.randomUUID().toString());
        personModel.setUdf35(UUID.randomUUID().toString());
        personModel.setUdf36(UUID.randomUUID().toString());
        personModel.setUdf37(UUID.randomUUID().toString());
        personModel.setUdf38(UUID.randomUUID().toString());
        personModel.setUdf39(UUID.randomUUID().toString());
        personModel.setUdf40(UUID.randomUUID().toString());
        personModel.setUdf41(UUID.randomUUID().toString());
        personModel.setUdf42(UUID.randomUUID().toString());
        personModel.setUdf43(UUID.randomUUID().toString());
        personModel.setUdf44(UUID.randomUUID().toString());
        personModel.setUdf45(UUID.randomUUID().toString());
        personModel.setUdf46(UUID.randomUUID().toString());
        personModel.setUdf47(UUID.randomUUID().toString());
        personModel.setUdf48(UUID.randomUUID().toString());
        personModel.setUdf49(UUID.randomUUID().toString());
        personModel.setUdf50(UUID.randomUUID().toString());
        return personModel;
    }
}
