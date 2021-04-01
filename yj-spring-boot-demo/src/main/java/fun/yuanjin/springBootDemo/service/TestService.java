package fun.yuanjin.springBootDemo.service;

import fun.yuanjin.springBootDemo.domain.TestDO;

/**
 * @ClassName ImageService
 * @Description TODO
 * @Author yuanjin
 * @Date 2020-11-05 21:50
 * @Version 1.0
 */
public interface TestService {
    String save(TestDO t)throws Exception;
}
