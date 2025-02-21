package com.test.test;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName: BooleanTest
 * @Description:
 * @Author: qinfajia
 * @Date: 2024/4/7 15:38
 * @Version: 1.0
 */
public class BooleanTest {

    @Test
    public void test() {
        Boolean[] array = new Boolean[]{true, false, false, true};
        Arrays.sort(array);
        System.out.println(JSON.toJSONString(array));
    }
}
