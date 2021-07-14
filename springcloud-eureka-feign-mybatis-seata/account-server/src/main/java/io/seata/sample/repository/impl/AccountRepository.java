package io.seata.sample.repository.impl;

import io.seata.sample.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author panbailiang
 * @Classname AccountRepository
 * @Date 2021/7/4 10:30 上午
 */
@Repository
public class AccountRepository implements io.seata.sample.repository.AccountRepository {
    @Autowired
    private AccountDao accountDao;
    @Override
    public void decrease(Long userId, BigDecimal money) {
        //模拟超时异常，全局事务回滚
        Random random = new Random();
        int ints = random.nextInt(10);
        if (ints % 2 == 0) {
            try {
                TimeUnit.MILLISECONDS.sleep(800);
                throw new RuntimeException("模拟失败");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        accountDao.decrease(userId, money);
    }
}
