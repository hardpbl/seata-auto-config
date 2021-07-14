package io.seata.sample.repository.impl;

import io.seata.sample.dao.StorageDao;
import io.seata.sample.repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author panbailiang
 * @Classname AccountRepository
 * @Date 2021/7/4 10:34 上午
 */
@Repository
public class StorageRepositoryImpl implements StorageRepository {

    @Autowired
    private StorageDao storageDao;
    @Override
    public void decrease(Long productId, Integer count) {
        storageDao.decrease(productId,count);
    }
}
