package com.test.leetcode.page5.chapter420.t423;

/**
 * @ClassName: Solution20230602
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/2 08:43
 * @Version: 1.0
 */
public class Solution20230602 {
    /**
     * 执行用时：5 ms, 在所有 Java 提交中击败了84.96%的用户
     * 内存消耗：43.1 MB, 在所有 Java 提交中击败了15.85%的用户
     * 通过测试用例：24 / 24
     *
     * @param s
     * @return
     */
    // zero,one,two,three,four,five,six,seven,eight,nine
    // s[i] 为 ["e","g","f","i","h","o","n","s","r","u","t","w","v","x","z"] 这些字符之一
    public String originalDigits(String s) {
        char[] array = new char[26];
        for (char c : s.toCharArray()) {
            array[c - 'a']++;
        }
        //
        int[] number = new int[10];
        // z是zero,w肯定是two,u肯定是four,x肯定是six,g肯定是eight,
        // zero
        number[0] = array['z' - 'a'];
        remove(array, array['z' - 'a'], "zero");
        // two
        number[2] = array['w' - 'a'];
        remove(array, array['w' - 'a'], "two");
        // four
        number[4] = array['u' - 'a'];
        remove(array, array['u' - 'a'], "four");
        // six
        number[6] = array['x' - 'a'];
        remove(array, array['x' - 'a'], "six");
        // eight
        number[8] = array['g' - 'a'];
        remove(array, array['g' - 'a'], "eight");
        // 上面之后还剩下one,three,five,seven,nine
        // o是one,h是three,f是five，s是seven，剩下的是nine
        // one
        number[1] = array['o' - 'a'];
        remove(array, array['o' - 'a'], "one");
        // three
        number[3] = array['h' - 'a'];
        remove(array, array['h' - 'a'], "three");
        // five
        number[5] = array['f' - 'a'];
        remove(array, array['f' - 'a'], "five");
        // seven
        number[7] = array['s' - 'a'];
        remove(array, array['s' - 'a'], "seven");
        // nine
        number[9] = array['i' - 'a'];
        // 返回结果
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < number.length; i++) {
            while (number[i] > 0) {
                builder.append(i);
                number[i]--;
            }
        }
        return builder.toString();
    }

    // 从array中删除str
    public void remove(char[] array, int count, String str) {
        while (count > 0) {
            for (char c : str.toCharArray()) {
                array[c - 'a']--;
            }
            count--;
        }
    }
}
