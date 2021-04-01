package fun.yuanjin.common.utils.leetcode;

import java.util.Arrays;

/**
 * @ClassName CountPrimes204
 * @Description 204. 计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 * 示例 1：
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 示例 2：
 * 输入：n = 0
 * 输出：0
 * 示例 3：
 * 输入：n = 1
 * 输出：0
 * 链接：https://leetcode-cn.com/problems/count-primes
 * @Author yuanjin
 * @Date 2020-12-03 22:37
 * @Version 1.0
 */
public class CountPrimes204 {
    public static void main(String[] args) {

    }

    /**
     * 思路：从2开始遍历到n，依次遍历到n，在遍历的时候标记处为质数的位置。
     *
     * @param n
     * @return
     */
    public static int countPrimes(int n) {
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                for (int j = i * i; j < n; j += i) {
                    primes[j] = false;
                }
            }
        }
        int c = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i]) {
                c++;
            }
        }
        return c;
    }

    public static boolean isPrime(int n) {
        int max = (int) Math.sqrt(n);
        for (int i = 2; i <= max; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
