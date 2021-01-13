package com.test.string;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-01-07 15:39
 */
public class JSONTest {

    @Test
    public void testArray() {
        JSONObject jsonObject = JSON.parseObject("{\"sbuType\":[{\"label\":\"体检券\",\"value\":\"1\"},{\"label\":\"洗牙券\",\"value\":\"2\"}]}");
        List<Map<String, String>> list = new ArrayList<>();
        JSONArray jsonArray = jsonObject.getJSONArray("sbuType");
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject j = jsonArray.getJSONObject(i);
            Map<String, String> map = new HashMap<>();
            map.put("key", j.getString("label"));
            map.put("value", j.getString("value"));
            list.add(map);
        }
        System.out.println(JSON.toJSONString(list));
    }
}
