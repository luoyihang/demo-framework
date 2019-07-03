package com.lyh.demo.web.common.config.sharding;

import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;

import java.util.*;

/**
 * @author luoyihang
 * @date 2019/7/3 15:11
 */
public class OrderShardingAlgorithm implements ComplexKeysShardingAlgorithm {

    @Override
    public Collection<String> doSharding(Collection availableTargetNames, ComplexKeysShardingValue shardingValue) {
        Set<String> result = new HashSet<>();
        result.add("t_order_0");
//        String orderName = (String) ((List) shardingValue.getColumnNameAndShardingValuesMap().get("orderName")).iterator().next();
//        Date createTime = (Date) shardingValue.getColumnNameAndShardingValuesMap().get("createTime");
        return result;
    }
}
