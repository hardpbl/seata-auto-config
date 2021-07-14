package io.seata.sample.service;

import io.seata.sample.dao.StorageDao;
import io.seata.sample.repository.StorageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author IT云清
 */
@Service("storageServiceImpl")
public class StorageServiceImpl implements StorageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StorageServiceImpl.class);

    @Autowired
    private StorageRepository storageRepository;

    /**
     * 扣减库存
     * @param productId 产品id
     * @param count 数量
     * @return
     */
    @Override
//    @Transactional(rollbackFor = Exception.class)
    public void decrease(Long productId, Integer count) {
        Random random = new Random();
        int ints = random.nextInt(10);
        if (ints % 2 == 0) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                throw new RuntimeException("模拟失败");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        LOGGER.info("------->扣减库存开始");
        storageRepository.decrease(productId,count);
        LOGGER.info("------->扣减库存结束");
    }
}
