package com.test.design.decorate;

/**
 * 玄铁甲
 *
 * @ClassName: XuanTieJia
 * @Description:
 * @Author: qinfajia
 * @Date: 2024/5/16 16:13
 * @Version: 1.0
 */
public class XuanTieJia extends Clothes {

    public XuanTieJia(Role role) {
        super(role);
    }

    @Override
    public void decorate() {
        super.decorate();
        System.out.println("穿上玄铁甲");
    }
}
