package fun.yuanjin.common.utils.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName YangHuiSanJiao
 * @Description 118. 杨辉三角
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 * @Author yuanjin
 * @Date 2020-12-06 10:15
 * @Version 1.0
 */
public class YangHuiSanJiao {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        while (numRows > 0) {
            numRows--;
            if (result.size() == 0) {
                result.add(Arrays.asList(1));
                continue;
            }
            List<Integer> last = result.get(result.size() - 1);
            List<Integer> newList = new ArrayList<>();
            newList.add(1);
            for (int i = 1; i < last.size(); i++) {
                newList.add(last.get(i) + last.get(i - 1));
            }
            newList.add(1);
            result.add(newList);
        }
        return result;
    }
}
