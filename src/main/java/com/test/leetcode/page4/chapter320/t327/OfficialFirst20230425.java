package com.test.leetcode.page4.chapter320.t327;

/**
 * @ClassName: OfficialFirst20230425
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/25 08:46
 * @Version: 1.0
 */
public class OfficialFirst20230425 {

    /**
     * 归并排序
     * <p>
     * 归并排序的思路：如果我们需要求区间[s,e]的答案，那么如果我们已经知道了[s,mid]和
     * [mid+1,e]的答案（mid=(s+e)/2），是否有办法得到[s,e]的答案。这里我们设区间[s,mid]
     * 为 n1，区间[mid+1,e]为 n2，那么合法的数对(i,j)有且只有三种情况：
     * 1,i和j都出现在​n1中
     * 2,i和j都出现在​n2中
     * 3,左端点在n1,右端点在n2，即i在n1,j在n2
     *
     * @param nums
     * @param lower
     * @param upper
     * @return
     */
    public int countRangeSum(int[] nums, int lower, int upper) {
        long s = 0;
        long[] sum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            // 呃，这骚代码……还不如直接i从1开始 sum[i]=sum[i-1]+nums[i]了；
            s += nums[i];
            sum[i + 1] = s;
        }
        return countRangeSumRecursive(sum, lower, upper, 0, sum.length - 1);
    }

    /**
     * @param sum   数组前缀和
     * @param lower 下界
     * @param upper 上届
     * @param left  左侧起始
     * @param right 右侧起始
     * @return
     */
    public int countRangeSumRecursive(long[] sum, int lower, int upper, int left, int right) {
        if (left == right) {
            return 0;
        } else {
            // 选取中间点进行二分？
            int mid = (left + right) / 2;
            int n1 = countRangeSumRecursive(sum, lower, upper, left, mid);
            int n2 = countRangeSumRecursive(sum, lower, upper, mid + 1, right);
            int ret = n1 + n2;

            // 首先统计下标对的数量
            int i = left;
            int l = mid + 1;
            int r = mid + 1;
            while (i <= mid) {
                while (l <= right && sum[l] - sum[i] < lower) {
                    l++;
                }
                while (r <= right && sum[r] - sum[i] <= upper) {
                    r++;
                }
                ret += r - l;
                i++;
            }

            // 随后合并两个排序数组
            long[] sorted = new long[right - left + 1];
            int p1 = left, p2 = mid + 1;
            int p = 0;
            while (p1 <= mid || p2 <= right) {
                if (p1 > mid) {
                    sorted[p++] = sum[p2++];
                } else if (p2 > right) {
                    sorted[p++] = sum[p1++];
                } else {
                    if (sum[p1] < sum[p2]) {
                        sorted[p++] = sum[p1++];
                    } else {
                        sorted[p++] = sum[p2++];
                    }
                }
            }
            for (int j = 0; j < sorted.length; j++) {
                sum[left + j] = sorted[j];
            }
            return ret;
        }
    }
}
