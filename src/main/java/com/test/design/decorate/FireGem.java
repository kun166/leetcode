package com.test.design.decorate;

/**
 * @ClassName: FireGem
 * @Description:
 * @Author: qinfajia
 * @Date: 2024/5/16 16:13
 * @Version: 1.0
 */
public class FireGem extends Gem {

    public FireGem(Role role) {
        super(role);
    }

    @Override
    public void decorate() {
        super.decorate();
        System.out.println("镶嵌火系宝珠");
    }
}
