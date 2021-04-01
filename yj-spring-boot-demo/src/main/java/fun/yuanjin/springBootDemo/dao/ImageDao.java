package fun.yuanjin.springBootDemo.dao;

import fun.yuanjin.springBootDemo.domain.Image;
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
public interface ImageDao {

    List<Image> selectList();

    Image selectOne();

    long save(Image image);

    void deleteById(Long id);
}
