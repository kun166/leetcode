package com.test.leetcode.page1.chapter70.t71;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution20221121
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/11/21 19:11
 * @Version: 1.0
 */
public class Solution20221121 {

    @Test
    public void test() {
        System.out.println(simplifyPath("/a//b////c/d//././/.."));
    }

    public String simplifyPath(String path) {
        StringBuilder builder = new StringBuilder();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '/') {
                if (builder.length() == 0) {
                    // 连续的/
                    continue;
                }
                // 清空builder
                delStr(builder.toString(), list);
                builder.delete(0, builder.length());
            } else {
                builder.append(path.charAt(i));
            }
        }
        if (builder.length() > 0) {
            delStr(builder.toString(), list);
        }
        if (list.isEmpty()) {
            return "/";
        }
        builder.delete(0, builder.length());
        for (String str : list) {
            builder.append("/").append(str);
        }
        return builder.toString();
    }

    public void delStr(String str, List<String> list) {
        if (str.equals(".")) {
            return;
        } else if (str.equals("..")) {
            if (!list.isEmpty()) {
                list.remove(list.size() - 1);
            }
        } else {
            list.add(str);
        }
    }
}
