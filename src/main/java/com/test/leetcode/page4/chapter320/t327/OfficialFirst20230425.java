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
     * https://zhuanlan.zhihu.com/p/277560069
     * 归并排序的思路：如果我们需要求区间[s,e]的答案，那么如果我们已经知道了[s,mid]和
     * [mid+1,e]的答案（mid=(s+e)/2），是否有办法得到[s,e]的答案。这里我们设区间[s,mid]
     * 为 n1，区间[mid+1,e]为 n2，那么合法的数对(i,j)有且只有三种情况：
     * 1,i和j都出现在n1中
     * 2,i和j都出现在n2中
     * 3,左端点在n1,右端点在n2，即i在n1,j在n2
     * <p>
     * 根据归并排序的特性，
     * 第一种情况可以在递归求n1时得到，
     * 第二种情况可以在递归求n2时得到，
     * 第三种情况在归并n1和n2时得到，
     * 所以我们只需要考虑如何归并即可，
     * 另外在递归之后的n1和n2有一个重要的特性就是都是有序的
     * <p>
     * 那么现在的问题就是如何归并，即给定两个有序数组n1和n2,存在多少个数对(i,j)使得
     * n2[j]-n1[i]在区间[lower,upper],这是个相对简单的问题
     * <p>
     * 我们可以遍历n1数组，同时维护两个指针l和r,
     * 其中l指向n2中第一个符合n2[j]-n1[i]>=lower的位置,
     * r指向n2中第一个符合n2[j]-n1[i]>upper的位置，
     * 那么对于n1[i]在n2中满足条件的元素个数就是r-l了。
     * l和r的初始值可以都指向n2的起始位置,对于每个n1[i]不断地向后移动l和r直到它们满足条件，
     * 然后累加r-l到最终答案里去。由于n1是递增的，所以向后遍历n1的时候,l和r也只会向后移动
     *
     * @param nums  数组区间
     * @param lower 下限
     * @param upper 上限
     * @return 数组对数
     */
    public int countRangeSum(int[] nums, int lower, int upper) {
        long s = 0;
        // 求数组nums区间和
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
            // 归并排序，先二分
            int mid = (left + right) / 2;
            // 求取n1
            int n1 = countRangeSumRecursive(sum, lower, upper, left, mid);
            // 求取n2
            int n2 = countRangeSumRecursive(sum, lower, upper, mid + 1, right);
            // 存在三种情况中的两种累加
            int ret = n1 + n2;

            int i = left;
            int l = mid + 1;
            int r = mid + 1;
            while (i <= mid) {
                // 这个while跳出循环的条件,l>right或者 sum[l] - sum[i] >= lower
                while (l <= right && sum[l] - sum[i] < lower) {
                    l++;
                }
                // 这个while跳出循环的条件,r>right或者 sum[r] - sum[i] > upper
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
