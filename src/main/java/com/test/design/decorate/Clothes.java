package com.test.design.decorate;

/**
 * 装备
 *
 * @ClassName: Clothes
 * @Description:
 * @Author: qinfajia
 * @Date: 2024/5/16 16:11
 * @Version: 1.0
 */
public abstract class Clothes implements Role {

    protected Role mRole;

    public Clothes(Role role) {
        mRole = role;
    }

    @Override
    public void decorate() {
        mRole.decorate();
    }
}
