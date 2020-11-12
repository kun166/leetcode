package com.test.leetcode.chapter70.t71;

import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-11-10 10:38
 */
public class Solution {

    @Test
    public void test() {
        String[] array = new String[]{"/home/", "/../", "/home//foo/", "/a/./b/../../c/", "/a/../../b/../c//.//", "/a//b////c/d//././/..", "/..."};
        //String[] array = new String[]{"/a//b////c/d//././/.."};
        for (String s : array) {
            System.out.println(s + "::::" + simplifyPath(s));
        }
    }

    public String simplifyPath(String path) {
        int length = path.length();
        if (length < 2)
            return path;
        StringBuilder sp = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (sp.length() == 0)
                sp.append("/");
            if (path.charAt(i) == '/' && sp.charAt(sp.length() - 1) == '/') {
                continue;
            } else if (path.charAt(i) == '.') {
                if (sp.charAt(sp.length() - 1) == '/') {
                    if ((i + 2 == length && path.charAt(i + 1) == '.') || (i + 2 < length && path.charAt(i + 1) == '.' && path.charAt(i + 2) == '/')) {
                        // 删除上一个"/"
                        if (sp.length() > 0)
                            sp.deleteCharAt(sp.length() - 1);
                        int index = sp.lastIndexOf("/");
                        if (index > -1)
                            sp.delete(index, sp.length());
                        i++;
                        continue;
                    } else if ((i + 1 < length && path.charAt(i + 1) == '/') || i + 1 == length) {
                        // 删除上一个"/"
                        if (sp.length() > 0)
                            sp.deleteCharAt(sp.length() - 1);
                        continue;
                    }
                }
            }
            sp.append(path.charAt(i));
        }
        if (sp.length() == 0)
            return "/";
        if (sp.length() > 1 && sp.charAt(sp.length() - 1) == '/')
            sp.deleteCharAt(sp.length() - 1);
        return sp.toString();
    }
}
