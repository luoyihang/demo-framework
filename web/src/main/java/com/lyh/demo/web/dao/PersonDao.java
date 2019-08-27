package com.lyh.demo.web.dao;

import com.lyh.demo.web.entity.PersonModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author luoyihang
 * @date 2019/5/6 14:37
 */
public interface PersonDao {

    /**
     * 单条插入
     *
     * @param param
     */
    void insertPerson50(@Param("param") PersonModel param);


    /**
     * 批量插入
     *
     * @param list
     */
    void batchInsertPerson50(@Param("list") List<PersonModel> list);
}
