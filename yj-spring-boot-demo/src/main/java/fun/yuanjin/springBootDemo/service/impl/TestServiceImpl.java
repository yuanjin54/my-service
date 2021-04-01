package fun.yuanjin.springBootDemo.service.impl;

import fun.yuanjin.springBootDemo.dao.TestDao;
import fun.yuanjin.springBootDemo.domain.TestDO;
import fun.yuanjin.springBootDemo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.net.SocketException;

/**
 * @ClassName ImageServiceImpl
 * @Description TODO
 * @Author yuanjin
 * @Date 2020-11-05 22:03
 * @Version 1.0
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

    @Override
    @Transactional(rollbackFor = SocketException.class)
    public String save(TestDO t) throws Exception {
        testDao.save(t);
        if (!StringUtils.isEmpty(t.getName()) && "4".equals(t.getName())) {
            throw new RuntimeException("ee");
        }
        if (!StringUtils.isEmpty(t.getName()) && "8".equals(t.getName())) {
            throw new Exception("ee");
        }
        TestDO select = testDao.select();
        Thread.sleep(60*1000);
        if (null != select) {
            return select.toString();
        }
        return "null";
    }
}
