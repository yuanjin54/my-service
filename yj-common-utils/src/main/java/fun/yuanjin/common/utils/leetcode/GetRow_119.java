package fun.yuanjin.common.utils.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName GetRow_119
 * @Description 119. 杨辉三角 II
 * https://leetcode-cn.com/problems/pascals-triangle-ii/
 * @Author yuanjin
 * @Date 2021-02-13 21:21
 * @Version 1.0
 */
public class GetRow_119 {
    public static void main(String[] args) {
        GetRow_119 m = new GetRow_119();
        System.out.println(m.getRow(4));
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        if (rowIndex == 0) {
            list.add(1);
            return list;
        }
        list.add(1);
        list.add(1);
        if (rowIndex == 1) {
            return list;
        }
        return getRow(rowIndex - 1, list);
    }

    public List<Integer> getRow(int rowIndex, List<Integer> list) {
        if (rowIndex == 0){
            return list;
        }
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for (int i = 0; i < list.size() - 1; i++) {
            res.add(list.get(i)+list.get(i+1));
        }
        res.add(1);
        return getRow(rowIndex-1,res);
    }
}
