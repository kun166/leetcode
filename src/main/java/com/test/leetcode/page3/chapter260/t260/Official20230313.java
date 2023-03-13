package com.test.leetcode.page3.chapter260.t260;

/**
 * @ClassName: Official20230313
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/13 08:50
 * @Version: 1.0
 */
public class Official20230313 {

    /**
     * 136题是一个数，这道题是两个数。
     * 1,全部异或之后，得到的数是这两个数的异或，计为n。
     * 2,得到的数n如果不是Integer.MIN_VALUE，则与它的相反数求位运算(n&(-n))，得到最低位的1
     * 3,说明在这个位上，这两个数不同。
     * 4,根据这个位上的1,将数分成两组
     * 5,剩下的和136题一样了
     * <p>
     * 注：这个题要学习的是n&(-n)
     *
     * @param nums
     * @return
     */
    public int[] singleNumber(int[] nums) {
        int xorsum = 0;
        for (int num : nums) {
            xorsum ^= num;
        }
        // 防止溢出
        int lsb = (xorsum == Integer.MIN_VALUE ? xorsum : xorsum & (-xorsum));
        int type1 = 0, type2 = 0;
        for (int num : nums) {
            if ((num & lsb) != 0) {
                type1 ^= num;
            } else {
                type2 ^= num;
            }
        }
        return new int[]{type1, type2};
    }

}
