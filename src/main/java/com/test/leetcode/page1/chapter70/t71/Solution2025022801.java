package com.test.leetcode.page1.chapter70.t71;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution2025022801
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/28 14:46
 * @Version: 1.0
 */
public class Solution2025022801 {

    /**
     * 先用系统函数吧，简单点
     *
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        List<String> list = new ArrayList<>();
        String[] strs = path.split("/");
        for (String str : strs) {
            if (str.length() == 0 || str.equals("."))
                continue;
            if (str.equals("..")) {
                if (list.size() > 0) {
                    list.remove(list.size() - 1);
                }
            } else {
                list.add(str);
            }
        }
        if (list.isEmpty()) {
            return "/";
        }
        StringBuilder builder = new StringBuilder();
        for (String str : list) {
            builder.append("/").append(str);
        }
        return builder.toString();
    }
}
