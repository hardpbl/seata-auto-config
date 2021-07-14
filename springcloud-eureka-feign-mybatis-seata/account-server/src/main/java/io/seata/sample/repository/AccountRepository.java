package io.seata.sample.repository;

import java.math.BigDecimal;

public interface AccountRepository {
    /**
     * 扣减账户余额
     * @param userId 用户id
     * @param money 金额
     */
    void decrease(Long userId, BigDecimal money);
}
