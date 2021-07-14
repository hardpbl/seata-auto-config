package io.seata.sample.service;

import io.seata.sample.dao.AccountDao;
import io.seata.sample.feign.OrderApi;
import java.math.BigDecimal;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.seata.sample.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author IT云清
 */
@Service("accountServiceImpl")
public class AccountServiceImpl implements AccountService{

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private OrderApi orderApi;

    /**
     * 扣减账户余额
     * @param userId 用户id
     * @param money 金额
     */
    @Override
//    @Transactional(rollbackFor = Exception.class)
    public void decrease(Long userId, BigDecimal money) {
        LOGGER.info("------->扣减账户开始account中");
        accountRepository.decrease(userId,money);
        LOGGER.info("------->扣减账户结束account中");
    }
}
