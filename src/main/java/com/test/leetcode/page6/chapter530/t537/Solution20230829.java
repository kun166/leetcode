package com.test.leetcode.page6.chapter530.t537;

import org.junit.Test;

/**
 * @ClassName: Solution20230829
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/8/29 16:33
 * @Version: 1.0
 */
public class Solution20230829 {

    @Test
    public void test() {
        System.out.println(complexNumberMultiply("1+1i", "1+1i"));
    }

    public String complexNumberMultiply(String num1, String num2) {
        int[] numArray1 = paras(num1);
        int[] numArray2 = paras(num2);
        StringBuilder builder = new StringBuilder();
        builder.append(numArray1[0] * numArray2[0] - numArray1[1] * numArray2[1]);
        builder.append("+");
        builder.append(numArray1[0] * numArray2[1] + numArray1[1] * numArray2[0]);
        builder.append("i");
        return builder.toString();
    }

    public int[] paras(String num) {
        int[] ans = new int[2];
        int index = num.indexOf("+");
        ans[0] = Integer.parseInt(num.substring(0, index));
        if (num.charAt(index + 1) == '-') {
            ans[1] = Integer.parseInt(num.substring(index + 2, num.length() - 1)) * -1;
        } else {
            ans[1] = Integer.parseInt(num.substring(index + 1, num.length() - 1));
        }
        return ans;
    }
}
