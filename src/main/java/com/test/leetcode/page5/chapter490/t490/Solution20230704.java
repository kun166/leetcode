package com.test.leetcode.page5.chapter490.t490;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Solution20230704
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/4 09:18
 * @Version: 1.0
 */
public class Solution20230704 {


    @Test
    public void test() {
        System.out.println(hasPath(new int[][]{{0, 0, 0, 0, 0}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 1, 0, 0, 1}, {0, 1, 0, 0, 0}},
                new int[]{4, 3},
                new int[]{0, 1}));
    }

    private static int[][] dirArr = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private Map<Integer, Boolean> map = new HashMap<>();

    /**
     * 感觉可以根据终点倒推啊
     *
     * @param maze
     * @param start
     * @param destination
     * @return
     */
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        boolean[][] visit = new boolean[m][n];
        map.put(start[0] * 100 + start[1], true);
        boolean has = false;
        for (int i = 0; i < dirArr.length; i++) {
            int x = destination[0] + dirArr[i][0], y = destination[1] + dirArr[i][1];
            if (x < 0 || y < 0 || x >= maze.length || y >= maze[0].length || maze[x][y] == 1) {
                has = has || hasPath(maze, new int[]{destination[0] - dirArr[i][0], destination[1] - dirArr[i][1]}, visit);
            }
        }
        return has;
    }


    public boolean hasPath(int[][] maze, int[] start, boolean[][] visit) {
        if (map.containsKey(start[0] * 100 + start[1])) {
            return map.get(start[0] * 100 + start[1]);
        }
        if (start[0] < 0 || start[1] < 0 || start[0] >= maze.length || start[1] >= maze[0].length || maze[start[0]][start[1]] == 1) {
            map.put(start[0] * 100 + start[1], false);
            return false;
        }
        // 当前路径四个方向尝试
        boolean has = false;
        for (int i = 0; i < dirArr.length; i++) {
            int x = start[0] + dirArr[i][0], y = start[1] + dirArr[i][1];
            if (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0 && !visit[x][y]) {
                visit[x][y] = true;
                has = has || hasPath(maze, new int[]{x, y}, visit);
                visit[x][y] = false;
            }
        }
        map.put(start[0] * 100 + start[1], has);
        return has;
    }

}
