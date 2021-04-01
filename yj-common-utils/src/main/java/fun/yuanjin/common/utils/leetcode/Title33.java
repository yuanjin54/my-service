package fun.yuanjin.common.utils.leetcode;

/**
 * @ClassName Title33
 * @Description 33. 搜索旋转排序数组
 * 给你一个整数数组 nums ，和一个整数 target 。
 * 该整数数组原本是按升序排列，但输入时在预先未知的某个点上进行了旋转。（例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] ）。
 * 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *  
 * 示例 1：
 * 输入：nums = [7,8,9,0,1,2,3,4,5,6], target = 0
 * 输出：4
 * <p>
 * 示例 2：
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * <p>
 * 示例 3：
 * 输入：nums = [1], target = 0
 * 输出：-1
 * <p>
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * @Author yuanjin
 * @Date 2020-12-08 18:31
 * @Version 1.0
 */
public class Title33 {
    public static void main(String[] args) {
        int[] nums = {7, 8, 9, 0, 1, 2, 3, 4, 5, 6};
        int target = 0;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (target == nums[left]) {
                return left;
            }
            if (target == nums[right]) {
                return right;
            }
            // 中间值比两边都大
            if (nums[mid] > nums[left] && nums[mid] > nums[right]) {
                // 目标值小于中间值，说明目标值在左边，right = mid - 1，其他情况不在左边肯定在右边
                if (target < nums[mid] && target > nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
                // 中间值比两边都小
            } else if (nums[mid] < nums[left] && nums[mid] < nums[right]) {
                // 目标值大于中间值，说明目标值在右边，left = mid + 1，其他情况不在右边肯定在左边
                if (target > nums[mid] && target < nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else { // 目标值比left大且比right小
                if (target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
