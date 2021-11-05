package com.test.array;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-07-16 11:06
 */
public class TwoDimensionalSpaceArray {

    @Test
    public void test() {
        char[][] board = new char[2][3];
        System.out.println(board.length);
        System.out.println(board[0].length);
        board[0] = new char[]{'1', '1', '1'};
        board[1] = new char[]{'2', '2', '2'};
        System.out.println(JSON.toJSONString(board));
    }

    @Test
    public void test1() {
        boolean[][] f = new boolean[3][3];
        // f[0] = true;
        //System.out.println(JSON.toJSONString(board));
    }
}
