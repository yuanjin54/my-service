package fun.yuanjin.common.utils.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ReverseWords_58
 * @Description TODO
 * @Author yuanjin
 * @Date 2021-01-25 22:49
 * @Version 1.0
 */
public class ReverseWords_58 {
    public static void main(String[] args) {

    }
    public String reverseWords(String s) {
        List<String> res = new ArrayList<>();
        String[] arr = s.split(" ");
        int i = 0;
        int j = arr.length-1;
        while (i<j){
            if (arr[i].length() == 0){
                i++;
            }else if (arr[j].length() == 0){
                j--;
            }else {


            }
        }
        return "";
    }
}
