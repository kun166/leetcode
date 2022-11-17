package com.test.test;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.*;
import java.util.*;

/**
 * @ClassName: FileReadTest
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/7/8 12:31
 * @Version: 1.0
 */
public class FileReadTest {

    @Test
    public void test() {
        List<String> wbIdList = null; //getWbIdList();
        List<String> creditId = null;//getCreditId();
        List<Map<String, String>> dataList = new ArrayList<>();
        File root = new File("/Users/qinfajia/code/credit");
        for (String file : root.list()) {
            File first = new File(root.getAbsolutePath() + File.separator + file);
            if (first.isDirectory()) {
                for (String sunFile : new File("/Users/qinfajia/code/credit/" + file).list()) {
                    File second = new File(first.getAbsolutePath() + File.separator + sunFile);
                    if (second.getName().endsWith("2022-07-07-17.credit") || second.getName().endsWith("2022-07-07-18.credit")) {
                        try (BufferedReader reader = new BufferedReader(new FileReader(second))) {
                            String line;
                            while ((line = reader.readLine()) != null) {
                                if (line.indexOf("更新状态 signCreditContractPushReqDTO") > -1) {
                                    int index = line.indexOf("wbId=") + 5;
                                    String wbId = line.substring(index, line.indexOf(",", index));
                                    if (wbIdList.contains(wbId)) {
                                        Map<String, String> push = new HashMap<>();
                                        dataList.add(push);
                                        push.put("wbId", wbId);
                                        push.put("id", creditId.get(wbIdList.indexOf(wbId)));
                                        push.put("status", "300000102");
                                        // sourceFrom
                                        int sfi = line.indexOf("sourceFrom=") + 11;
                                        push.put("sourceFrom", line.substring(sfi, line.indexOf(",", sfi)));
                                        // investigationOrganization
                                        int ioi = line.indexOf("investigationOrganization=") + "investigationOrganization=".length();
                                        push.put("investigationOrganization", line.substring(ioi, ioi + 1));
                                    }
                                }
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {

                        }
                    }
                }
            }
        }
        System.out.println(dataList.size());
        System.out.println(JSON.toJSONString(dataList));
    }


    @Test
    public void splitFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/qinfajia/code/file.csv"))) {
            String line;
            int count = 0;
            int fileCount = 1;
            BufferedWriter write = null;
            while ((line = reader.readLine()) != null) {
                if (count == 0) {
                    if (write != null) {
                        write.close();
                    }
                    write = new BufferedWriter(new FileWriter("/Users/qinfajia/code/file" + fileCount + ".txt"));
                }
                write.write(line);
                write.write("\r\n");
                write.flush();
                count++;
                if (count == 10000) {
                    count = 0;
                    fileCount++;
                }
            }
            if (write != null) {
                write.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getCreditId() {
        Set<String> set = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/qinfajia/code/updateQuotaExpireService.log"));
             BufferedWriter write = new BufferedWriter(new FileWriter("/Users/qinfajia/code/creditId.txt", true))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (StringUtils.isBlank(line) || line.indexOf("更新成功") < 0) {
                    continue;
                }
                String creditId = line.split("wbId:")[1].split(",")[0];
                if (set.contains(creditId)) {
                    System.out.println("creditId:" + creditId + "重复");
                    continue;
                }
                write.write(creditId);
                write.write("\r\n");
                write.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void doubleLIne() {
        Set<String> set = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/qinfajia/code/creditId.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (set.contains(line)) {
                    System.out.println("creditId:" + line + "重复");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}