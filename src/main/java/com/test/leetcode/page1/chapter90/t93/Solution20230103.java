package com.test.leetcode.page1.chapter90.t93;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution20230103
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/3 21:28
 * @Version: 1.0
 */
public class Solution20230103 {

    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        restoreIpAddresses(s, list, new StringBuilder(), 0, 0);
        return list;
    }

    public void restoreIpAddresses(String s, List<String> list, StringBuilder builder, int index, int point) {
        if (point == 4 && index == s.length()) {
            list.add(builder.toString());
            return;
        }
        if (index >= s.length() || point > 4) {
            return;
        }
        if (point != 0) {
            builder.append('.');
        }
        if (s.charAt(index) == '0') {
            builder.append('0');
            restoreIpAddresses(s, list, builder, index + 1, point + 1);
            builder.delete(builder.length() - 1, builder.length());
        } else {
            //一个
            builder.append(s.charAt(index));
            restoreIpAddresses(s, list, builder, index + 1, point + 1);
            builder.delete(builder.length() - 1, builder.length());
            //两个
            if (index < s.length() - 1) {
                builder.append(s.charAt(index)).append(s.charAt(index + 1));
                restoreIpAddresses(s, list, builder, index + 2, point + 1);
                builder.delete(builder.length() - 2, builder.length());
            }
            //三个
            if (index < s.length() - 2 && Integer.parseInt(s.substring(index, index + 3)) <= 255) {
                builder.append(s.charAt(index)).append(s.charAt(index + 1)).append(s.charAt(index + 2));
                restoreIpAddresses(s, list, builder, index + 3, point + 1);
                builder.delete(builder.length() - 3, builder.length());
            }
        }
        if (point != 0) {
            builder.delete(builder.length() - 1, builder.length());
        }

    }
}
