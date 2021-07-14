package io.seata.sample.repository;

import io.seata.sample.entity.Order;

import java.math.BigDecimal;

public interface OrderRepository {
    /**
     * 创建订单
     * @param order
     * @return
     */
    void create(Order order);

    /**
     * 修改订单金额
     * @param userId
     * @param money
     */
    void update( Long userId,  BigDecimal money, Integer status);
}
