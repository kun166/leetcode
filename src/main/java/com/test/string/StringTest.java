package com.test.string;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-07-06 09:56
 */
@Slf4j
public class StringTest {

    public final transient int i = 0;

    @Test
    public void testIntern() {
        String str = "56.87\n" +
                "MB\n" +
                "击败\n" +
                "47.49%";
        str = str.replaceAll("\n", "").replaceAll("击败", "\t击败");
        System.out.println(str);
    }

    @Test
    public void test() {
        System.out.println("popup_list_config".toUpperCase());
        System.out.println("POPUP_LIST_CONFIG".toLowerCase());
        System.out.println(StringTest.class.getName());
        List<String> list = new ArrayList<>();
//        list.add("oa1");
//        list.add("oa2");
//        list.add("oa3");
        System.out.println(JSON.toJSONString(list));

        String str = "[\"oa1\",\"oa2\",\"oa3\"]";
        list = JSON.parseObject(str, List.class);
        System.out.println(list.get(2));
    }


    @Test
    public void test2() {
        System.out.println(Thread.currentThread().getContextClassLoader().toString());
        System.out.println(JSON.toJSONString(null));
    }


    @Test
    public void test4() {
        System.out.println(0 << 16 | 65);
    }

    @Test
    public void test10() {
        String str = "建⽴过程：\n" +
                "1. client发送加密请求，⽣成并发送第1随机数\n" +
                "2. server收到请求，⽣成并返回第2随机数\n" +
                "3. server将注册在ca的公钥+ca数据证书发送给client\n" +
                "4. client⽣成第3随机数，第1+2+3随机数⽤公钥加密⽣成会话密钥发送给server\n" +
                "5. 双⽅后续通过会话密钥加解密数据（对称加密）";
        String[] arr = str.split("\n");
        for (String s : arr) {
            if (s.indexOf(".") > -1) {
                System.out.println(s.substring(s.indexOf(".") + 1).trim());
            } else {
                System.out.println(s.trim());
            }

        }
    }

    @Test
    public void test11() {
        System.out.println('z' - 'A');
        System.out.println('z' - 'Z');
        System.out.println('P' - '0');


    }

    private void parse(JSONObject json) {
        if (json == null || json.isEmpty()) {
            return;
        }
        for (Map.Entry<String, Object> entry : json.entrySet()) {
            String valueStr = entry.getValue().toString();
            // System.out.println(valueStr);
            if (valueStr.indexOf("{") == -1) {
                // 基本类型了，不处理了
                continue;
            }
            JSONObject child = JSON.parseObject(valueStr);
            parse(child);
            json.put(entry.getKey(), child);
        }
    }

    @Test
    public void test12() {
        Pattern pattern = Pattern.compile("^([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}$");
        System.out.println(pattern.matcher("127.0.0.1").matches());
        System.out.println("bulkCharLength".toLowerCase());
        int l = 5, h = 10;
        System.out.println(l + h >>> 1);
    }

    @Test
    public void test13() {
        StringTokenizer st = new StringTokenizer("abc,def;g", ",;");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }

        System.out.println("---------------");
        Pattern NAME_SEPARATOR = Pattern.compile("\\s*[,]+\\s*");

        for (String sp : NAME_SEPARATOR.split("abc,def;g")) {
            System.out.println(sp);
        }
    }

    @Test
    public void test14() {
        Random random = new Random();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            int num = random.nextInt(100);
            //map.computeIfAbsent(num, key -> map.get(num) == null ? 1 : map.get(num) + 1);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("key:" + entry.getKey() + ";value:" + entry.getValue());
        }

    }

    @Test
    public void test15() {
        BigDecimal bd = new BigDecimal("0.1889");
        System.out.println(bd.divide(new BigDecimal("365"), 5, RoundingMode.DOWN));


        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(1);
        ll.add(2);

        System.out.println(JSON.toJSONString(ll));
        ll.push(3);

        System.out.println(JSON.toJSONString(ll));
        ll.addLast(4);

        System.out.println(JSON.toJSONString(ll));
        ll.remove();

        System.out.println(JSON.toJSONString(ll));
        ll.poll();

        System.out.println(JSON.toJSONString(ll));
        ll.pop();

        System.out.println(JSON.toJSONString(ll));
    }

}
