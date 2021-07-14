package io.seata.sample.repository.impl;

import io.seata.sample.dao.OrderDao;
import io.seata.sample.entity.Order;
import io.seata.sample.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author panbailiang
 * @Classname OrderRepositoryImpl
 * @Date 2021/7/4 9:34 上午
 */
@Repository
public class OrderRepositoryImpl implements OrderRepository {
    @Autowired
    private OrderDao orderDao;

    @Override
//    @Transactional(rollbackFor = Exception.class)
    public void create(Order order) {

        Random random = new Random();
        int ints = random.nextInt(10);
        if (ints % 2 == 0) {
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        orderDao.create(order);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Long userId, BigDecimal money, Integer status) {
        orderDao.update(userId, money, status);
    }
}
