package fun.yuanjin.common.utils.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PrefixesDivBy5_1018
 * @Description TODO
 * @Author yuanjin
 * @Date 2021-01-14 22:29
 * @Version 1.0
 */
public class PrefixesDivBy5_1018 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 1, 1, 1};
        System.out.println(prefixesDivBy5(arr));
    }

    public static List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>();
        int count = 0;
        for (int value : A) {
            count = ((count << 1) + value) % 5;
            res.add(count % 5 == 0);
        }
        return res;
    }

}
