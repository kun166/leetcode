package com.test.design.decorate;

/**
 * 功能宝珠
 *
 * @ClassName: Gem
 * @Description:
 * @Author: qinfajia
 * @Date: 2024/5/16 16:12
 * @Version: 1.0
 */
public abstract class Gem implements Role {

    protected Role mRole;

    public Gem(Role role) {
        mRole = role;
    }

    @Override
    public void decorate() {
        mRole.decorate();
    }
}
