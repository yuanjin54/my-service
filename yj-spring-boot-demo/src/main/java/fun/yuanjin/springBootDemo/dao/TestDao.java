package fun.yuanjin.springBootDemo.dao;

import fun.yuanjin.springBootDemo.domain.TestDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @ClassName ImageDao
 * @Description TODO
 * @Author yuanjin
 * @Date 2020-11-05 22:05
 * @Version 1.0
 */
@Mapper
@Repository
public interface TestDao {

    long save(TestDO t);
    TestDO select();
}
