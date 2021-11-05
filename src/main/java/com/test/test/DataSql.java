package com.test.test;

import org.junit.Test;

import java.io.*;
import java.util.*;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-11-16 15:26
 */
public class DataSql {

    @Test
    public void createUpdate() {
        String rootPath = DataSql.class.getResource("/").getPath();
        //System.out.println(rootPath);
        try (BufferedReader in = new BufferedReader(
                new FileReader(rootPath + "/financial_pay_detail_1616674715_5-9.txt"));
             PrintWriter out = new PrintWriter(rootPath + "/data_sql_5-9.sql", "utf-8")) {
            String line;
            List<Data> dataList = new ArrayList<>();
            Map<String, Data> map = new HashMap<>();
            while ((line = in.readLine()) != null) {
                if (line.trim() != "") {
                    String[] dataArray = line.trim().split("\\t");
                    Data data = map.get(dataArray[1]);
                    if (data == null) {
                        data = new Data();
                        data.businessId = dataArray[1];
                        map.put(dataArray[1], data);
                        dataList.add(data);
                    }
                    data.idList.add(Long.valueOf(dataArray[0]));
                }
            }

            for (Data data : dataList) {
                List<Long> list = data.idList;
                Collections.sort(list);
                for (int i = 1; i < list.size(); i++) {
                    StringBuilder sql = new StringBuilder();
                    sql.append("update financial_pay_detail set business_id = CONCAT(business_id,'-A").append(i);
                    sql.append("') where id = ").append(list.get(i)).append(" ; \r\n");
                    out.write(sql.toString());
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }
    }

    static class Data {
        public String businessId;
        public List<Long> idList = new ArrayList<>();
    }
}

