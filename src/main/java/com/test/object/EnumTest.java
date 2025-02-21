package com.test.object;

/**
 * @ClassName: EnumTest
 * @Description:
 * @Author: qinfajia
 * @Date: 2024/5/16 10:35
 * @Version: 1.0
 */
public enum EnumTest {

    TEST_ONE(1, "test1"),
    TEST_TWO(2, "test2"),
    TEST_THREE(3, "test3"),
    ;

    private Integer code;

    private String desc;

    EnumTest(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
