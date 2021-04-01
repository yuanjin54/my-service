package fun.yuanjin.springBootDemo.dao;

import fun.yuanjin.springBootDemo.domain.TdcCost;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName ImageDao
 * @Description TODO
 * @Author yuanjin
 * @Date 2020-11-05 22:05
 * @Version 1.0
 */
@Mapper
@Repository
public interface TdcCostDao {

    List<TdcCost> selectList();

    TdcCost selectOne();

    int save(TdcCost obj);

    void deleteAll();
}
