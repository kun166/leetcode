package com.test.design.decorate;

/**
 * @ClassName: DecorationTest
 * @Description:
 * @Author: qinfajia
 * @Date: 2024/5/16 16:15
 * @Version: 1.0
 */
public class DecorationTest {

    public static void main(String[] args) {
        // 初始化角色
        Role role = new MaleRole();
        // 穿个玄铁甲
        XuanTieJia xuanTieJia = new XuanTieJia(role);
        // 给玄铁甲镶嵌个火系宝珠
        FireGem fireGem = new FireGem(xuanTieJia);
        fireGem.decorate();
    }
}
