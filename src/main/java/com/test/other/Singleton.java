package com.test.other;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Singleton {

    @Test
    public void test() {
        List<String> policyIdList = new ArrayList<>();
        policyIdList.add("a");
        policyIdList.add("b");
        System.out.println(joinPolicyId(policyIdList));
    }

    private String joinPolicyId(List<String> policyIdList) {
        if(policyIdList == null || policyIdList.size() == 0) {
            return "";
        }
        if(policyIdList.size() <= 100) {
            return String.join(",", policyIdList);
        }
        return String.join(",", policyIdList.subList(0, 100)) + "...";
    }
}


