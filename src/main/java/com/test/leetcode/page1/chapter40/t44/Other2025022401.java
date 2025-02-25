package com.test.leetcode.page1.chapter40.t44;

/**
 * @ClassName: Other2025022401
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/24 17:26
 * @Version: 1.0
 */
public class Other2025022401 {

    /**
     * 贪心算法，看看大神怎么写的
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        // 贪心 时间复杂度O(MN) s,p是随机字符串实际运行很快 空间复杂度O(1)
        int m = s.length(), n = p.length();
        /**
         * i是字符串s的下标,j是匹配串p的下标
         */
        int i = 0, j = 0;
        // indexS记录遇到*时s的位置 indexP记录最后一个*的位置
        /**
         * indexS记录更多尝试匹配*的位置,
         * 换句话说,就是记录，到目前为止,*匹配的s中的下标
         */
        int indexS = -1, indexP = -1;
        char[] charS = s.toCharArray();
        char[] charP = p.toCharArray();
        while (i < m) {
            if (j < n && (charS[i] == charP[j] || charP[j] == '?')) {
                // 当前字符可以匹配
                i++;
                j++;
            } else if (j < n && charP[j] == '*') {
                // 尝试从空字符串开始匹配
                /**
                 * 先从匹配0个开始尝试
                 * 下面的else if依次尝试匹配+1个
                 */
                indexS = i;
                indexP = j;
                j++;
            } else if (indexP != -1) {
                // 上一次的*没匹配上 则本次重新开始 但是indexS要+1 代表每次多匹配一个字符
                /**
                 * 每次再多匹配一个字符
                 *
                 * 换成indexS++;
                 * i = indexS;
                 * 更容易理解？
                 */
                i = indexS + 1;
                indexS++;
                /**
                 * 下面这行代码拆分成
                 * j = indexP;
                 * j++
                 * 更容易理解
                 */
                j = indexP + 1;
            } else {
                return false;
            }
        }
        while (j < p.length()) {
            if (p.charAt(j++) != '*') {
                return false;
            }
        }
        return true;
    }
}
