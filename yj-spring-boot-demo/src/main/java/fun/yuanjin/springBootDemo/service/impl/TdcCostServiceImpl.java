package fun.yuanjin.springBootDemo.service.impl;

import fun.yuanjin.common.utils.ExcelUtils;
import fun.yuanjin.springBootDemo.dao.TdcCostDao;
import fun.yuanjin.springBootDemo.domain.TdcCost;
import fun.yuanjin.springBootDemo.service.TdcCostService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ImageServiceImpl
 * @Description TODO
 * @Author yuanjin
 * @Date 2020-11-05 22:03
 * @Version 1.0
 */
@Service
public class TdcCostServiceImpl implements TdcCostService {

    private TdcCostDao tdcCostDao;

    public static Map<Integer, String> attr = new HashMap<>();
    private static List<Integer> bigDecimalAttr = new ArrayList<>();

    static {
        attr.put(0, "productName");
        attr.put(1, "priceItem");
        attr.put(2, "priceChildItem");
        attr.put(3, "count");
        attr.put(4, "unit");
        attr.put(5, "per");
        attr.put(6, "perUnit");
        attr.put(7, "cost");
        attr.put(8, "mouthRat");
        attr.put(9, "category");
        attr.put(10, "appKey");
        attr.put(11, "appKeyPriceChange");
        attr.put(12, "appName");
        attr.put(13, "userName");
        attr.put(14, "groupName");
        attr.put(15, "startTime");
        attr.put(16, "endTime");
        attr.put(17, "envName");

        bigDecimalAttr.add(3);
        bigDecimalAttr.add(5);
        bigDecimalAttr.add(7);
    }


    public TdcCostServiceImpl(TdcCostDao tdcCostDao) {
        this.tdcCostDao = tdcCostDao;
    }

    @Override
    public int insert(TdcCost tdcCost) {
        return tdcCostDao.save(tdcCost);
    }

    @Override
    public void deleteAll() {
        tdcCostDao.deleteAll();
    }

    @Override
    public void save(String json, int key) {
        if (StringUtils.isEmpty(json)) {
            return;
        }
        String[] attr = json.split(",");
        if (attr.length != 18) {
            throw new RuntimeException("长度有问题，json=" + json);
        }
        TdcCost obj = new TdcCost();
        if (!StringUtils.isEmpty(attr[0])) {
            obj.setProductName(attr[0]);
        }
        if (!StringUtils.isEmpty(attr[1])) {
            obj.setPriceItem(attr[1]);
        }
        if (!StringUtils.isEmpty(attr[2])) {
            obj.setPriceChildItem(attr[2]);
        }
        if (!StringUtils.isEmpty(attr[3])) {
            obj.setCount(new BigDecimal(attr[3]));
        }
        if (!StringUtils.isEmpty(attr[4])) {
            obj.setUnit(attr[4]);
        }
        if (!StringUtils.isEmpty(attr[5])) {
            obj.setPer(new BigDecimal(attr[5]));
        }
        if (!StringUtils.isEmpty(attr[6])) {
            obj.setPerUnit(attr[6]);
        }
        if (!StringUtils.isEmpty(attr[7])) {
            obj.setCost(new BigDecimal(attr[7]));
        }
        if (!StringUtils.isEmpty(attr[8])) {
            obj.setMouthRat(attr[8]);
        }
        if (!StringUtils.isEmpty(attr[9])) {
            obj.setCategory(attr[9]);
        }
        if (!StringUtils.isEmpty(attr[10])) {
            obj.setAppKey(attr[10]);
        }
        if (!StringUtils.isEmpty(attr[11])) {
            obj.setAppKeyPriceChange(attr[11]);
        }
        if (!StringUtils.isEmpty(attr[12])) {
            obj.setAppName(attr[12]);
        }
        if (!StringUtils.isEmpty(attr[13])) {
            obj.setUserName(attr[13]);
        }
        if (!StringUtils.isEmpty(attr[14])) {
            obj.setGroupName(attr[14]);
        }
        if (!StringUtils.isEmpty(attr[17])) {
            obj.setEnvName(attr[17]);
        }
        obj.setId(key);
        tdcCostDao.save(obj);
    }

    @Override
    public void saveData(Row row, int key) {
        short cell = row.getLastCellNum();
        TdcCost obj = new TdcCost();
        for (int j = 0; j < cell; j++) {
            Cell c = row.getCell(j);
            setValue(j, c, obj);
        }
        obj.setId(key);
        tdcCostDao.save(obj);
    }

    private void setValue(int idx, Cell cell, TdcCost obj) {
        Field field = null;
        String value = ExcelUtils.getStringValue(cell);
        try {
            field = obj.getClass().getDeclaredField(attr.get(idx));
            field.setAccessible(true);
            if (bigDecimalAttr.contains(idx)) {
                field.set(obj, new BigDecimal(value));
            } else if (idx == 15 || idx == 16){
                field.set(obj, ExcelUtils.getDateValue(cell));
            }else {
                field.set(obj, value);
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println(idx + "错误了，s=" + ExcelUtils.getStringValue(cell));
            e.printStackTrace();
        }
    }
}
