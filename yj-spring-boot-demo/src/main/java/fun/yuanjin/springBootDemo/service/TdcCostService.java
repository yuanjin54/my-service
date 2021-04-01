package fun.yuanjin.springBootDemo.service;

import fun.yuanjin.springBootDemo.domain.TdcCost;
import org.apache.poi.ss.usermodel.Row;

/**
 * @ClassName ImageService
 * @Description TODO
 * @Author yuanjin
 * @Date 2020-11-05 21:50
 * @Version 1.0
 */
public interface TdcCostService {
    int insert(TdcCost tdcCost);

    void deleteAll();

    void save(String json, int key);

    void saveData(Row row, int key);
}
