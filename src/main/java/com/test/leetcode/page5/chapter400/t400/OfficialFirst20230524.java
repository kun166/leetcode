package com.test.leetcode.page5.chapter400.t400;

/**
 * @ClassName: OfficialFirst20230524
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/24 09:05
 * @Version: 1.0
 */
public class OfficialFirst20230524 {

    /**
     * 方法一：二分查找
     * 我们令一个整数的位数是d，则存在:由于任何整数都至少是一位数，因此d的最小值是1。对于d的上界，可以通过找规律的方式确定。
     * 1位数的范围是1到9，共有9个数，所有1位数的位数之和是1×9=9。
     * 2位数的取值范围是10到99，共有90个数，所有2位数的位数之和是2×90=180。
     * 3位数的取值范围是100到999，共有900个数，所有3位数的位数之和是3×900=2700。
     * 推广到一般情形，x位数的范围是x乘以9乘以10的x-1次方
     *
     * @param n
     * @return
     */
    public int findNthDigit(int n) {
        // 最低位数为1位数，最高位数为9位数(因为9位数满足题目要求的Integer.MAX_VALUE)
        int low = 1, high = 9;
        while (low < high) {
            // 二分
            int mid = (high - low) / 2 + low;
            if (totalDigits(mid) < n) {
                // 如果mid位数的位数总和小于n，则从mid+1作为起始位置继续查找
                low = mid + 1;
            } else {
                // 否则上限设置为mid
                high = mid;
            }
        }
        // 跳出循环，这个时候的low==high，且查找的那个数是low位
        int d = low;
        // 求出low-1位的所有位数之和
        int prevDigits = totalDigits(d - 1);
        // 查找的那个在low位数里面的索引
        int index = n - prevDigits - 1;
        // d位数的起始位置是1*10的d-1次方
        int start = (int) Math.pow(10, d - 1);
        // 第n位数所在的数字num
        int num = start + index / d;
        // 所在的数字num的第几位
        int digitIndex = index % d;
        // 求取num第digitIndex位上的数字
        int digit = (num / (int) (Math.pow(10, d - digitIndex - 1))) % 10;
        // 返回
        return digit;
    }

    /**
     * 求得传入的length位数，总共有多少位数
     *
     * @param length
     * @return
     */
    public int totalDigits(int length) {
        // 起始总共有0位，用于累加
        int digits = 0;
        // 起始从一位数开始，一位数总共有9乘以10的0次方
        int curLength = 1, curCount = 9;
        while (curLength <= length) {
            // 循环求总累加位数
            digits += curLength * curCount;
            curLength++;
            curCount *= 10;
        }
        return digits;
    }

}
