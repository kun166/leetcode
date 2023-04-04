package com.test.leetcode.page3.chapter290.t299;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: Solution20230404
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/4 15:49
 * @Version: 1.0
 */
public class Solution20230404 {

    /**
     * 执行用时：8 ms, 在所有 Java 提交中击败了14.01%的用户
     * 内存消耗：41.9 MB, 在所有 Java 提交中击败了9.83%的用户
     * 通过测试用例：152 / 152
     *
     * @param secret
     * @param guess
     * @return
     */
    public String getHint(String secret, String guess) {
        Map<Character, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int x = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                x++;
                set.add(i);
            } else {
                map.put(secret.charAt(i), map.getOrDefault(secret.charAt(i), 0) + 1);
            }
        }
        int y = 0;
        for (int i = 0; i < guess.length(); i++) {
            if (!set.contains(i) && map.containsKey(guess.charAt(i))) {
                y++;
                int count = map.get(guess.charAt(i));
                if (count > 1) {
                    map.put(guess.charAt(i), count - 1);
                } else {
                    map.remove(guess.charAt(i));
                }
            }
        }
        return x + "A" + y + "B";
    }
}
