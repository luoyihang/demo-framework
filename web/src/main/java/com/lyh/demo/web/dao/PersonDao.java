package com.lyh.demo.web.dao;

import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author luoyihang
 * @date 2019/5/6 14:37
 */
public interface PersonDao {

    /**
     * 通过ID获取name
     *
     * @param id
     * @return
     */
    String getPersonName(Long id);

    /**
     * 测试
     *
     * @param name
     * @return
     */
    String getTest(@Param("name") String name);

    /**
     * 复杂分片测试，
     *
     * @param orderName
     * @param startDate
     * @param endDate
     * @return
     */
    String queryOrder(@Param("orderName") String orderName, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    void insertOrder(@Param("createTime") Date createTime);
}
