package com.test.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-10-29 10:34
 */
public class UpperSolution {

    @Test
    public void test() {
        List<String> l = upper("Ab");
        for (String s : l) {
            System.out.println(s);
        }
    }

    /**
     * 输入小写字符串，小写字符可以大写，不改变顺序输出所有组合
     *
     * @param s
     * @return
     */
    public List<String> upper(String s) {
        char[] array = s.toCharArray();
        List<String> list = new ArrayList<>();
        upper(list, array, 0);
        return list;
    }

    public void upper(List<String> list, char[] array, int index) {
        if (index == array.length) {
            list.add(new String(array));
            return;
        }
        array[index] = Character.toLowerCase(array[index]);
        upper(list, array, index + 1);
        array[index] = Character.toUpperCase(array[index]);
        upper(list, array, index + 1);
        //array[index] = Character.toLowerCase(array[index]);
    }
}
