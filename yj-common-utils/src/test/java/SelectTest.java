import fun.yuanjin.common.utils.DateUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName SelectTest
 * @Description TODO
 * @Author yuanjin
 * @Date 2020-11-05 10:04
 * @Version 1.0
 */
public class SelectTest {
    public static void main(String[] args) throws ParseException {
        System.out.println(604701/3600.0);
        System.out.println(7 * 24 * 3600 - 256795);
        long s = DateUtils.stringToLong("2020-11-20 15:56:56") +(7 * 24 * 3600 - 256412)*1000 ;
        Date date = DateUtils.longToDate(s); //96567571

        System.out.println(DateUtils.dateToString(date));
    }
}
