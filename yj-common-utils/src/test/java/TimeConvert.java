import fun.yuanjin.common.utils.DateUtils;

import java.text.ParseException;
import java.util.Date;

/**
 * @ClassName TimeConvert
 * @Description TODO
 * @Author yuanjin
 * @Date 2020-11-05 14:46
 * @Version 1.0
 */
public class TimeConvert {
    public static void main(String[] args) throws ParseException {
        Long s = 1606566542L*1000;
        Date d = DateUtils.longToDate(s);
        String s1 = DateUtils.dateToString(d);
        System.out.println(s1);

        System.out.println(8*24*60*60);

        System.out.println(DateUtils.stringToLong("2020-10-01 00:00:00", DateUtils.PATTERN_00));
    }
}
