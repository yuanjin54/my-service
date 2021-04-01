package fun.yuanjin.common.utils.leetcode;

import java.util.*;

/**
 * @ClassName Interview1
 * @Description 面试题 17.08. 马戏团人塔
 * 有个马戏团正在设计叠罗汉的表演节目，一个人要站在另一人的肩膀上。出于实际和美观的考虑，在上面的人要比下面的人矮一点且轻一点。已知马戏团每个人的身高和体重，请编写代码计算叠罗汉最多能叠几个人。
 * 示例：
 * 输入：height = [65,70,56,75,60,68] weight = [100,150,90,190,95,110]
 * 输出：6
 * 解释：从上往下数，叠罗汉最多能叠 6 层：(56,90), (60,95), (65,100), (68,110), (70,150), (75,190)
 * <p>
 * 链接：https://leetcode-cn.com/problems/circus-tower-lcci
 * @Author yuanjin
 * @Date 2020-12-06 18:47
 * @Version 1.0
 */
public class Interview1 {
    public static void main(String[] args) {
        System.out.println(bestSeqAtIndex(
                new int[]{65, 70, 56, 75, 60, 68}, new int[]{100, 150, 90, 190, 95, 110}
        ));
    }

    public static int bestSeqAtIndex(int[] height, int[] weight) {
        int len = height.length;
        int[][] person = new int[len][2];
        for (int i = 0; i < len; i++) {
            person[i] = new int[]{height[i], weight[i]};
        }
        Arrays.sort(person, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[] idx = new int[len];
        int max = 0;
        for (int i = len - 1; i >= 0; i--) {
            int count = 0;
            for (int j = i + 1; j < len; j++) {
                if (person[i][1] < person[j][1] && person[i][0] < person[j][0]) {
                    count = Math.max(idx[j], count);
                }
            }
            idx[i] = count + 1;
            max = Math.max(max, idx[i]);
        }
        System.out.println(Arrays.toString(idx));

        for (int i = 0; i < len; i++) {
            System.out.println(Arrays.toString(person[i]));
        }


        return max;
    }

    public static class Person {
        private int height;
        private int weight;

        public Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }
}
