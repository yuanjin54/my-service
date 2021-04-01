package fun.yuanjin.common.utils.test;

/**
 * @ClassName CarMapper
 * @Description TODO
 * @Author yuanjin
 * @Date 2021-03-09 15:06
 * @Version 1.0
 */

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    @Mapping(source = "age", target = "age")
    Dog carToCarDto(Person person);
}
