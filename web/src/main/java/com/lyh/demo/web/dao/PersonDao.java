package com.lyh.demo.web.dao;

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
}
