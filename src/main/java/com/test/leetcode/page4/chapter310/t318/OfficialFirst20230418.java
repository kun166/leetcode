package com.test.leetcode.page4.chapter310.t318;

/**
 * @ClassName: Official20230418
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/18 09:50
 * @Version: 1.0
 */
public class OfficialFirst20230418 {

    /**
     * 方法一：位运算
     * 执行用时：10 ms, 在所有 Java 提交中击败了92.34%的用户
     * 内存消耗：42.8 MB, 在所有 Java 提交中击败了48.08%的用户
     * 通过测试用例：168 / 168
     *
     * @param words
     * @return
     */
    public int maxProduct(String[] words) {
        //数组长度
        int length = words.length;
        // 每个数组的位掩码
        // int是32位，字母有26个，所以可以用一个int表示
        int[] masks = new int[length];
        for (int i = 0; i < length; i++) {
            String word = words[i];
            int wordLength = word.length();
            for (int j = 0; j < wordLength; j++) {
                // 牛逼plus
                masks[i] |= 1 << (word.charAt(j) - 'a');
            }
        }
        int maxProd = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    maxProd = Math.max(maxProd, words[i].length() * words[j].length());
                }
            }
        }
        return maxProd;
    }

}
