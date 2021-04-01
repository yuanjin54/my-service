package fun.yuanjin.common.utils.leetcode;

/**
 * @ClassName MaxScore_1423
 * @Description 1423. 可获得的最大点数
 * https://leetcode-cn.com/problems/maximum-points-you-can-obtain-from-cards/
 * @Author yuanjin
 * @Date 2021-02-06 09:18
 * @Version 1.0
 */
public class MaxScore_1423 {
    public static void main(String[] args) {

    }

    /**
     * 这种方法是采用递归的思想
     * 时间效率不满足
     */
    private int s = Integer.MIN_VALUE;

    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        for (int e : cardPoints) {
            sum += e;
        }
        if (cardPoints.length <= k) {
            return sum;
        }
        dfs(0, cardPoints.length - 1, k, 0, cardPoints);
        return s;
    }

    private void dfs(int i, int j, int k, int sum, int[] cardPoints) {
        if (i > j || k == 0) {
            s = Math.max(sum, s);
            return;
        }
        System.out.println(sum);
        dfs(i + 1, j, k - 1, sum + cardPoints[i], cardPoints);
        dfs(i, j - 1, k - 1, sum + cardPoints[j], cardPoints);
    }

    /**
     * 思路
     * 记数组 cardPoints 的长度为 n，
     * 由于只能从开头和末尾拿 k 张卡牌，所以最后剩下的必然是连续的 n-k 张卡牌。
     * 我们可以通过求出剩余卡牌点数之和的最小值，来求出拿走卡牌点数之和的最大值。
     */
    public int maxScore2(int[] cardPoints, int k) {
        int winLen = cardPoints.length - k;
        int allSum = 0;
        int winSum = 0;
        for (int i = 0; i < cardPoints.length; i++) {
            allSum += cardPoints[i];
            if (i == winLen - 1) {
                winSum = allSum;
            }
        }
        int min = winSum;
        for (int i = winLen; i < cardPoints.length; i++) {
            winSum = winSum - cardPoints[i - winLen] + cardPoints[i];
            min = Math.min(winSum, min);
        }
        return allSum - min;
    }
}
