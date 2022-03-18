package com.test.leetcode.page1.chapter40.t43;

/**
 * @ClassName: OfficeSolutionFirst
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/3/16 17:11
 * @Version: 1.0
 */
public class OfficeSolutionFirst {

    public String multiply(String num1, String num2) {
        // 如果两者中有一个是0，则返回0
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String ans = "0";
        // 两数长度
        int m = num1.length(), n = num2.length();
        for (int i = n - 1; i >= 0; i--) {
            // 从后向前遍历
            StringBuffer curr = new StringBuffer();
            // add是进位
            int add = 0;
            for (int j = n - 1; j > i; j--) {
                // 当前是第几位，就补几个零
                curr.append(0);
            }
            // y是当前位的数字值
            int y = num2.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                // 用y根第一个数字的每一位相乘算加和
                // x是第一位数字上的各个值
                int x = num1.charAt(j) - '0';
                int product = x * y + add;
                // curr本次位上的成绩和进位的加和
                curr.append(product % 10);
                add = product / 10;
            }
            if (add != 0) {
                curr.append(add % 10);
            }
            ans = addStrings(ans, curr.reverse().toString());
        }
        return ans;
    }

    /**
     * 两个字符串数字加和
     *
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        // 很巧妙
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        ans.reverse();
        return ans.toString();
    }
}
