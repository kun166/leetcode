package com.test.test;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-12-05 16:28
 */
public class ListTest {

    @Test
    public void test() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        List<Integer> l = list.stream().filter(t -> t > 5).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(list));
        System.out.println(JSON.toJSONString(l));
    }

    @Test
    public void test1() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(1);
        }
        Set<Integer> set = list.stream().collect(Collectors.toSet());

        System.out.println(JSON.toJSONString(set));
//        List<Integer> l = new ArrayList<>();
//        l.add(1);
//        list.removeAll(l);
//        System.out.println(JSON.toJSONString(list));
        //System.out.println(JSON.toJSONString(l));
    }

    @Test
    public void testLinkedList() {
        LinkedList<String> list = new LinkedList<>();
        list.add("abc");

        String ss = "[{\\\"id\\\":1113,\\\"codeType\\\":\\\"jk_audit_fail\\\",\\\"code\\\":\\\"1\\\",\\\"codeName\\\":\\\"122官网（交管12123）密码错误\\\"},{\\\"id\\\":1112,\\\"codeType\\\":\\\"jk_audit_fail\\\",\\\"code\\\":\\\"1\\\",\\\"codeName\\\":\\\"科目一考试低于70分（含），保司不予赔付，请勿重复提交\\\"},{\\\"id\\\":1114,\\\"codeType\\\":\\\"jk_audit_fail\\\",\\\"code\\\":\\\"2\\\",\\\"codeName\\\":\\\"科目一考试低于60分（含），保司不予赔付，请勿重复提交\\\"},{\\\"id\\\":1117,\\\"codeType\\\":\\\"jk_audit_fail\\\",\\\"code\\\":\\\"5\\\",\\\"codeName\\\":\\\"理赔科目通过，此次考试成绩已合格，请提交挂科的考试日期\\\"},{\\\"id\\\":1118,\\\"codeType\\\":\\\"jk_audit_fail\\\",\\\"code\\\":\\\"6\\\",\\\"codeName\\\":\\\"科目一/科目四考试0分，请提供考生签字的成绩单\\\"},{\\\"id\\\":1120,\\\"codeType\\\":\\\"jk_audit_fail\\\",\\\"code\\\":\\\"8\\\",\\\"codeName\\\":\\\"学员首次考试在保单生效前，无法理赔\\\"},{\\\"id\\\":1121,\\\"codeType\\\":\\\"jk_audit_fail\\\",\\\"code\\\":\\\"9\\\",\\\"codeName\\\":\\\"资料错误-授权书/系统填写缺少开户行信息，请在分行支行前填写开户行\\\"},{\\\"id\\\":1122,\\\"codeType\\\":\\\"jk_audit_fail\\\",\\\"code\\\":\\\"10\\\",\\\"codeName\\\":\\\"资料错误-授权书被保险人姓名与系统填写不一致\\\"},{\\\"id\\\":1123,\\\"codeType\\\":\\\"jk_audit_fail\\\",\\\"code\\\":\\\"11\\\",\\\"codeName\\\":\\\"资料错误-授权书领款人账户与发起理赔时系统中选择的理赔账户不一致\\\"},{\\\"id\\\":1220,\\\"codeType\\\":\\\"jk_audit_fail\\\",\\\"code\\\":\\\"13\\\",\\\"codeName\\\":\\\"资料错误-请使用正确的理赔授权书版本\\\"},{\\\"id\\\":1221,\\\"codeType\\\":\\\"jk_audit_fail\\\",\\\"code\\\":\\\"14\\\",\\\"codeName\\\":\\\"资料错误-对公账户收款请在授权书加盖公章\\\"},{\\\"id\\\":1228,\\\"codeType\\\":\\\"jk_audit_fail\\\",\\\"code\\\":\\\"15\\\",\\\"codeName\\\":\\\"资料错误-授权书请勿涂改/请使用黑色签字笔签字\\\"},{\\\"id\\\":1229,\\\"codeType\\\":\\\"jk_audit_fail\\\",\\\"code\\\":\\\"16\\\",\\\"codeName\\\":\\\"122网站信息无法判断，请提供考生签字成绩单或提供挂科当次发票+下次考试发票+预约考试时间证明\\\"},{\\\"id\\\":1232,\\\"codeType\\\":\\\"jk_audit_fail\\\",\\\"code\\\":\\\"18\\\",\\\"codeName\\\":\\\"首次考试时间小于投保后3天，无法理赔\\\"},{\\\"id\\\":1237,\\\"codeType\\\":\\\"jk_audit_fail\\\",\\\"code\\\":\\\"19\\\",\\\"codeName\\\":\\\"首次考试时间小于投保后7天，无法理赔\\\"},{\\\"id\\\":1238,\\\"codeType\\\":\\\"jk_audit_fail\\\",\\\"code\\\":\\\"20\\\",\\\"codeName\\\":\\\"投保前有单科5次挂科记录，无法理赔\\\"},{\\\"id\\\":1239,\\\"codeType\\\":\\\"jk_audit_fail\\\",\\\"code\\\":\\\"21\\\",\\\"codeName\\\":\\\"理赔科目错误\\\"},{\\\"id\\\":1240,\\\"codeType\\\":\\\"jk_audit_fail\\\",\\\"code\\\":\\\"22\\\",\\\"codeName\\\":\\\"考试日期错误，请提交挂科的考试日期\\\"},{\\\"id\\\":1241,\\\"codeType\\\":\\\"jk_audit_fail\\\",\\\"code\\\":\\\"23\\\",\\\"codeName\\\":\\\"该科目理赔次数已满4次，无法理赔\\\"},{\\\"id\\\":1242,\\\"codeType\\\":\\\"jk_audit_fail\\\",\\\"code\\\":\\\"24\\\",\\\"codeName\\\":\\\"驾校要求退回\\\"},{\\\"id\\\":1245,\\\"codeType\\\":\\\"jk_audit_fail\\\",\\\"code\\\":\\\"26\\\",\\\"codeName\\\":\\\"资料错误-请提供被保险人本人签字的第三方申请书\\\"},{\\\"id\\\":1246,\\\"codeType\\\":\\\"jk_audit_fail\\\",\\\"code\\\":\\\"27\\\",\\\"codeName\\\":\\\"资料错误-请提供被保险人本人手持身份证和授权书合影照片\\\"},{\\\"id\\\":1250,\\\"codeType\\\":\\\"jk_audit_fail\\\",\\\"code\\\":\\\"31\\\",\\\"codeName\\\":\\\"资料错误-请提供学员本人手持身份证和补充协议合影照片\\\"},{\\\"id\\\":1251,\\\"codeType\\\":\\\"jk_audit_fail\\\",\\\"code\\\":\\\"32\\\",\\\"codeName\\\":\\\"理赔电话号码首次核实号码错误（停机、非本人），请更新被保险人电话号码\\\"},{\\\"id\\\":1252,\\\"codeType\\\":\\\"jk_audit_fail\\\",\\\"code\\\":\\\"33\\\",\\\"codeName\\\":\\\"资料错误-核实授权书非学员本人签署，再次发起报案请提交学员手持身份证和本次报案（最近日期）授权书合影照片或赔付到被保险人本人\\\"},{\\\"id\\\":1253,\\\"codeType\\\":\\\"jk_audit_fail\\\",\\\"code\\\":\\\"34\\\",\\\"codeName\\\":\\\"理赔证明-合影中学员身份证/授权资料不清晰，再次发起报案请将学员身份证正反面照片/授权资料照片上传至辅助资料\\\"},{\\\"id\\\":1254,\\\"codeType\\\":\\\"jk_audit_fail\\\",\\\"code\\\":\\\"35\\\",\\\"codeName\\\":\\\"理赔电话号码连续两次核实号码错误（停机、非本人），再次发起报案请提交学员手持身份证和本次报案（最近日期）授权书合影照片或赔付到被保险人本人\\\"},{\\\"id\\\":1255,\\\"codeType\\\":\\\"jk_audit_fail\\\",\\\"code\\\":\\\"36\\\",\\\"codeName\\\":\\\"理赔责任-核实学员未参加本次考试，本次理赔报案不予赔付，重提无效\\\"},{\\\"id\\\":1256,\\\"codeType\\\":\\\"jk_audit_fail\\\",\\\"code\\\":\\\"37\\\",\\\"codeName\\\":\\\"理赔电话号码首次核实多次未接通，请更新被保险人电话号码\\\"},{\\\"id\\\":1257,\\\"codeType\\\":\\\"jk_audit_fail\\\",\\\"code\\\":\\\"38\\\",\\\"codeName\\\":\\\"理赔电话号码连续两次核实多次未接通，再次发起报案请提交学员手持身份证和本次报案（最近日期）授权书合影照片或赔付到被保险人本人\\\"},{\\\"id\\\":1259,\\\"codeType\\\":\\\"jk_audit_fail\\\",\\\"code\\\":\\\"40\\\",\\\"codeName\\\":\\\"资料错误-补充协议填写错误或缺少公章\\\"},{\\\"id\\\":1260,\\\"codeType\\\":\\\"jk_audit_fail\\\",\\\"code\\\":\\\"41\\\",\\\"codeName\\\":\\\"资料错误-赔付到第三方个人账户，请提供加盖公章的向第三方支付保险金申请书|如已在基础信息页上传申请书，请将个人账户保存至业务代理账户项中再发起理赔\\\"},{\\\"id\\\":1261,\\\"codeType\\\":\\\"jk_audit_fail\\\",\\\"code\\\":\\\"42\\\",\\\"codeName\\\":\\\"122密码错误次数已达上限，账号被锁定，可通过“忘记密码”功能解锁\\\"},{\\\"id\\\":1262,\\\"codeType\\\":\\\"jk_audit_fail\\\",\\\"code\\\":\\\"43\\\",\\\"codeName\\\":\\\"因122官网（交管12123）改版，核赔人员无法登录，请提供挂科证明（122截图或成绩单），首次理赔还需提供首次科目一预约时间证明。\\\"},{\\\"id\\\":1263,\\\"codeType\\\":\\\"jk_audit_fail\\\",\\\"code\\\":\\\"44\\\",\\\"codeName\\\":\\\"122官网（交管12123）改版，核赔人员无法登录，请提供挂科考试成绩（122截图或成绩单），或提供挂科考试预约详情截图+下次考试预约详情截图\\\"},{\\\"id\\\":1264,\\\"codeType\\\":\\\"jk_audit_fail\\\",\\\"code\\\":\\\"45\\\",\\\"codeName\\\":\\\"122官网（交管12123）改版，核赔人员无法登录，请提供首次科目一预约时间证明（截图需能够体现是首次）\\\"},{\\\"id\\\":1265,\\\"codeType\\\":\\\"jk_audit_fail\\\",\\\"code\\\":\\\"46\\\",\\\"codeName\\\":\\\"科目一/科目四理赔需提供122成绩截图或考生签字的成绩单\\\"},{\\\"id\\\":1266,\\\"codeType\\\":\\\"jk_audit_fail\\\",\\\"code\\\":\\\"47\\\",\\\"codeName\\\":\\\"理赔材料伪造，无法理赔\\\"},{\\\"id\\\":1267,\\\"codeType\\\":\\\"jk_audit_fail\\\",\\\"code\\\":\\\"47\\\",\\\"codeName\\\":\\\"122官网（交管12123）改版，核赔人员无法登录，请理赔到学员本人或协调被保险人通过二维码添加理赔服务微信号，配合扫码登录122进行核实\\\"},{\\\"id\\\":126,\\\"codeType\\\":\\\"jk_audit_fail\\\",\\\"code\\\":\\\"47\\\",\\\"codeName\\\":\\\"缺少驾校公示书，请联系驾校补充上传\\\"},{\\\"id\\\":1268,\\\"codeType\\\":\\\"jk_audit_fail\\\",\\\"code\\\":\\\"47\\\",\\\"codeName\\\":\\\"缺少驾校授权业务代表收款的授权书，请联系驾校补充上传\\\"}]\";\n";

        System.out.println(ss.replaceAll("\\\\", ""));

    }

    @Test
    public void sort() {
        List<IntegerObject> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new IntegerObject(i));
        }
        list.sort(Comparator.comparing(IntegerObject::getData).reversed());
        System.out.println(JSON.toJSONString(list));
    }

    @Test
    public void remove() {
        List<IntegerObject> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new IntegerObject(i));
        }
        System.out.println("list:" + JSON.toJSONString(list));
        List<IntegerObject> list1 = list.stream().filter(object -> object.getData() != 5).collect(Collectors.toList());
        System.out.println("list1:" + JSON.toJSONString(list1));
        System.out.println("list:" + JSON.toJSONString(list));

        list.removeIf(object -> object.getData() != 5);
        System.out.println("list:" + JSON.toJSONString(list));

    }
}
